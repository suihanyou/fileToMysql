package net.snailgame.importMysql.thread;

import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.snailgame.importMysql.config.Config;
import net.snailgame.importMysql.util.FileUtil;

import org.apache.log4j.Logger;

/**
 * <p>
 * Title: ScanFileThread.java
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
public class ScanFileThread extends Thread {
    private final static Logger logger = Logger.getLogger(ScanFileThread.class);

    private Config config;
    private ConcurrentLinkedQueue<File> concurrentLinkedQueue;

    public ScanFileThread(Config config, ConcurrentLinkedQueue<File> concurrentLinkedQueue) {
        this.config = config;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    public void run() {
        while (true) {
            List<File> files = FileUtil.getFiles(this.config.getDataFilePath());
            logger.error("扫描目录" + this.config.getDataFilePath() + ",文件数：" + files.size());
            if ((files == null) || (files.size() == 0)) {
                logger.error("未扫描到文件,睡60s...");
                try {
                    Thread.sleep(60000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (File file : files) {
                    FileUtil.moveFile(file, config.getDoingFilePath() + file.getName(), true);
                    concurrentLinkedQueue.add(new File(config.getDoingFilePath() + file.getName()));
                }
            }
        }
    }
}
