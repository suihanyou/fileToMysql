package net.snailgame.importMysql.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.snailgame.importMysql.config.Config;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;

/**
 * <p>
 * Title: SendMqThread.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 * 
 * @author SHY 2017年11月20日
 * @version 1.0
 */
public class SendMqThread extends Thread {
    private final static Logger logger = Logger.getLogger(SendMqThread.class);
    private Integer atom = new Integer(0);
    private Long beginTime = Long.valueOf(System.currentTimeMillis());
    private DefaultMQProducer producer;

    private Config config;
    private ConcurrentLinkedQueue<File> concurrentLinkedQueue;
    private BufferedReader input;


    public SendMqThread(Config config, ConcurrentLinkedQueue<File> concurrentLinkedQueue, DefaultMQProducer producer) {
        this.config = config;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
        this.producer = producer;
    }

    public void run() {
        sendMq();
    }

    private void sendMq() {
        SendResult sendResult = null;
        SendStatus sendStatus = null;
        String serviceNbr = null;
        String line = null;
        String servId = null;
        input = null;
        while (true) {
            File file = concurrentLinkedQueue.poll();
            if (file == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                logger.error("线程：" + getName() + "开始处理文件：" + file.getName());

                try {
                    input = new BufferedReader(new FileReader(file));

                    while ((line = input.readLine()) != null) {
                        JSONObject json = JSONObject.parseObject(line);
                        serviceNbr = json.get("acc_nbr").toString();
                        servId = json.get("serv_id").toString();
                        if (this.atom.intValue() >= this.config.getSendNumMin()) {
                            long sendTime = System.currentTimeMillis() - this.beginTime.longValue();
                            if (sendTime < 1000L) {
                                this.atom = Integer.valueOf(0);
                                this.beginTime = Long.valueOf(System.currentTimeMillis());
                                sleep(1000L - sendTime);
                            }
                        }

                        doSendMq(sendResult, sendStatus, this.config.getSendMqTopic(), this.config.getUserAttrTag(),
                                servId.getBytes());
                        doSendMq(sendResult, sendStatus, this.config.getSendMqTopic(), this.config.getAcctRelTag(),
                                servId.getBytes());
                        doSendMq(sendResult, sendStatus, this.config.getSendMqTopic(), this.config.getUserOrderTag(),
                                serviceNbr.getBytes());
                    }
                    logger.error(file.getName() + "处理完成");
                } catch (Exception e) {
                    logger.error("error do sendMq for msg" + line);
                    e.printStackTrace();
                }
            }
        }
    }

    private void doSendMq(SendResult sendResult, SendStatus sendStatus, String topic, String tag, byte[] sendByte) {
        Message msg = new Message(topic, tag, sendByte);
        while (SendStatus.SEND_OK != sendStatus) {
            try {
                sendResult = this.producer.send(msg);
                sendStatus = sendResult.getSendStatus();
            } catch (Exception e) {
                try {
                    sleep(100L);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}
