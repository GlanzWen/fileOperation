package com.glanz.fileOperation.allInterface;

/*
* 文件保存
* */
public interface FilePreserve {
    void writeByFileOutputStream(String filePath, String content);
    void writeByBufferedOutputStream(String filePath, String content);
    void writeByFileWriter(String filePath, String content);
}
