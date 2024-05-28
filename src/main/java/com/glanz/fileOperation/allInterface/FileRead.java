package com.glanz.fileOperation.allInterface;

import java.io.File;
import java.util.List;

/*
* 文件读取
* */
public interface FileRead {

    String readFileInByte(String fileName, String filePath);
    String readFileInChar(String fileName, String filePath);
    List<String> readFileInLine(String fileName, String filePath);

}
