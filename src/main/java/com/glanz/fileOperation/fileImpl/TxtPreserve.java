package com.glanz.fileOperation.fileImpl;

import com.glanz.fileOperation.allInterface.FilePreserve;

import java.io.*;

public class TxtPreserve implements FilePreserve {
    public void writeByFileOutputStream(String filePath, String content) {
        File file = new File(filePath);
        FileOutputStream fos = null;
        try {
            synchronized (file) {
                fos = new FileOutputStream(filePath);
                fos.write(content.getBytes("GBK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writeByBufferedOutputStream(String filePath, String content) {
        File file = new File(filePath);
        BufferedOutputStream fos = null;
        try {
            synchronized (file) {
                fos = new BufferedOutputStream(new FileOutputStream(filePath));
                fos.write(content.getBytes("GBK"));
                fos.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writeByFileWriter(String filePath, String content) {
        File file = new File(filePath);
        FileWriter fw = null;
        try {
            synchronized (file) {
                fw = new FileWriter(filePath);
                fw.write(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
