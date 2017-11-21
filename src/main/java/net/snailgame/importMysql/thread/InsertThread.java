package net.snailgame.importMysql.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.snailgame.importMysql.config.Config;
import net.snailgame.importMysql.config.EnumTableName;
import net.snailgame.importMysql.dao.MysqlAbstractDao;
import net.snailgame.importMysql.po.TbAAcctBalance;
import net.snailgame.importMysql.po.TbUOfrDetailInst;
import net.snailgame.importMysql.po.TbUServ;
import net.snailgame.importMysql.util.FastJSONUtils;
import net.snailgame.importMysql.util.FileUtil;

import org.apache.log4j.Logger;

/**
 * <p>
 * Title: InsertThread.java
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
public class InsertThread extends Thread {
    private final static Logger logger = Logger.getLogger(InsertThread.class);
    private Config config;
    private ConcurrentLinkedQueue<File> concurrentLinkedQueue;
    private Class<?> clazz;
    private final static int INSERTNUM = 100;
    private BufferedReader input = null;
    private MysqlAbstractDao mysqlAbstractDao;
    private int total = 0;
    private String sqlName;

    public InsertThread(Config config, ConcurrentLinkedQueue<File> concurrentLinkedQueue,
            MysqlAbstractDao mysqlAbstractDao) throws ClassNotFoundException {
        this.config = config;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
        this.mysqlAbstractDao = mysqlAbstractDao;
        getsqlString(this.config.getTableName());

    }

    public void run() {
        List<Object> data = new ArrayList<Object>();
        File file = null;
        int i = 0;
        while (true) {
            try {
                file = concurrentLinkedQueue.poll();
                if (file == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    logger.error("线程：" + getName() + "开始处理文件：" + file.getName());
                    input = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = input.readLine()) != null) {
                        if (i < INSERTNUM - 1) {
                            data.add(FastJSONUtils.toBean(line, clazz));
                            i++;
                            continue;
                        }
                        i++;
                        data.add(FastJSONUtils.toBean(line, clazz));
                        this.mysqlAbstractDao.inserts(sqlName, data);
                        data.clear();
                        total += i;
                        i = 0;
                    }
                    if (data.size() > 0) {
                        this.mysqlAbstractDao.inserts(sqlName, data);
                        data.clear();
                        total += i;
                    }
                    i = 0;
                    logger.error(file.getName() + "处理完成,共插入数据：" + total);
                    total = 0;
                    input.close();
                    FileUtil.moveFile(file, this.config.getFinishPath() + file.getName() + ".finish", true);
                }
            } catch (Exception e) {
                logger.error("do failed for file" + file.getName() + " at fileNum:" + total);
                data.clear();
                total = 0;
                i = 0;
                e.printStackTrace();
            }
        }
    }

    private void getsqlString(EnumTableName enumTableName) {
        switch (enumTableName) {
            case TBUSERV:
                this.sqlName = "net.snailgame.importMysql.po.TbUServ.inserts";
                this.clazz = TbUServ.class;
                break;
            case TBAACCTBALANCE:
                this.sqlName = "net.snailgame.importMysql.po.TbAAcctBalance.inserts";
                this.clazz = TbAAcctBalance.class;
                break;
            case TBUDETAILINST:
                this.sqlName = "net.snailgame.importMysql.po.TbUOfrDetailInst.inserts";
                this.clazz = TbUOfrDetailInst.class;
                break;
            default:
                break;
        }
    }
}
