package net.snailgame.importMysql;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.snailgame.importMysql.config.Config;
import net.snailgame.importMysql.dao.MysqlAbstractDao;
import net.snailgame.importMysql.thread.InsertThread;
import net.snailgame.importMysql.thread.ScanFileThread;
import net.snailgame.importMysql.thread.SendMqThread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

/**
 * <p>
 * Title: ImPortMysql.java
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
public class ImPortMysql {
    private static ApplicationContext context;

    public static void main(String[] args) throws ClassNotFoundException {
        context = new FileSystemXmlApplicationContext(args[0]);
        Config config = context.getBean(Config.class);
        ConcurrentLinkedQueue<File> concurrentLinkedQueue = new ConcurrentLinkedQueue<File>();
        MysqlAbstractDao mysqlAbstractDao = context.getBean(MysqlAbstractDao.class);
        ScanFileThread scanFileThread = new ScanFileThread(config, concurrentLinkedQueue);
        scanFileThread.start();
        switch (config.getRunType()) {
            case SYNC_REDIS:
                DefaultMQProducer producer = context.getBean(DefaultMQProducer.class);
                for (int i = 0; i < config.getInsertDbThreadNum(); i++) {
                    SendMqThread sendMqThread = new SendMqThread(config, concurrentLinkedQueue, producer);
                    sendMqThread.start();
                }
                break;
            case INSERT_DB:
                for (int i = 0; i < config.getInsertDbThreadNum(); i++) {
                    InsertThread insertThread = new InsertThread(config, concurrentLinkedQueue, mysqlAbstractDao);
                    insertThread.start();
                }
                break;

            default:
                break;
        }
    }
}
