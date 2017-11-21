package net.snailgame.importMysql.util;

/**
 * <p>
 * Title: FileUtil.java
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

import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.util.List;


public class FileUtil {
    public FileUtil() {
    }


    public static boolean moveFile(File srcFile, String destFileName, boolean overlay) {
        /* 16 */boolean flag = false;
        /* 17 */if ((srcFile.exists()) &&
        /* 18 */(srcFile.isFile())) {
            /* 19 */flag = copyFile(srcFile.getPath(), destFileName, overlay);
        }

        /* 22 */if (flag) {
            /* 23 */flag = srcFile.delete();
        }
        /* 25 */return flag;
    }


    public static List<File> getFiles(String realpath) {
        /* 30 */List<File> files = new java.util.ArrayList<File>();
        /* 31 */File realFile = new File(realpath);
        /* 32 */if (realFile.isDirectory()) {
            /* 33 */File[] subfiles = realFile.listFiles();
            /* 34 */for (File file : subfiles) {
                /* 35 */if (!file.isDirectory()) {

                    /* 38 */files.add(file);
                }
            }
        }
        /* 42 */return files;
    }



    public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) {
        /* 58 */File srcFile = new File(srcFileName);


        /* 61 */if (!srcFile.exists())
            /* 62 */return false;
        /* 63 */if (!srcFile.isFile()) {
            /* 64 */return false;
        }


        /* 68 */File destFile = new File(destFileName);
        /* 69 */if (destFile.exists()) {
            /* 71 */if (overlay) {
                /* 73 */new File(destFileName).delete();
            }

        }
        /* 77 */else if (!destFile.getParentFile().exists()) {
            /* 79 */if (!destFile.getParentFile().mkdirs()) {
                /* 81 */return false;
            }
        }



        /* 87 */int byteread = 0;
        /* 88 */InputStream in = null;
        /* 89 */OutputStream out = null;
        try {
            /* 92 */in = new java.io.FileInputStream(srcFile);
            /* 93 */out = new java.io.FileOutputStream(destFile);
            /* 94 */byte[] buffer = new byte['Ѐ'];

            /* 96 */while ((byteread = in.read(buffer)) != -1) {
                /* 97 */out.write(buffer, 0, byteread);
            }
            /* 99 */return true;
        } catch (FileNotFoundException e) {
            /* 101 */return false;
        } catch (IOException e) {
            /* 103 */return false;
        } finally {
            try {
                /* 106 */if (out != null)
                    /* 107 */out.close();
                /* 108 */if (in != null)
                    /* 109 */in.close();
            } catch (IOException e) {
                /* 111 */e.printStackTrace();
            }
        }
    }

}
