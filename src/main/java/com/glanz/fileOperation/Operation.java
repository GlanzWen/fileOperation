package com.glanz.fileOperation;

import java.io.File;
import java.io.IOException;

public class Operation {


    //创建文件夹
    public boolean createDirectory(String directory){
        boolean result = false;
        File file = new File(directory);
        if(!file.exists()){
            result = file.mkdirs();
        }

        return result;
    }
    //创建文件
    public boolean createFile(String filePath){
        boolean result = false;
        File file = new File(filePath);
        if(!file.exists()){
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    //删除文件夹
    public void deleteDirectory(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            return;
        }

        if(file.isFile()){
            file.delete();
        }else if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File myfile : files) {
                deleteDirectory(filePath + "/" + myfile.getName());
            }

            file.delete();
        }
    }
    //删除文件
    public boolean deleteFile(String filePath){
        boolean result = false;
        File file = new File(filePath);
        if(file.exists() && file.isFile()){
            result = file.delete();
        }
        return result;
    }



    //读取文件, 可读取多种类型文件，使用接口实现


    //文件转码


    //保存在内存中



    //保存在文本中


    //保存在excel中
}
