package com.glanz.fileOperation.fileImpl;

import com.glanz.fileOperation.allInterface.FileRead;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtRead implements FileRead {
    public String readFileInByte(String fileName, String filePath) {
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            System.out.println(fileName + " don't exist");
            return null;
        }

        StringBuffer content = new StringBuffer();

        try {
            byte[] temp = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            while(fileInputStream.read(temp) != -1){
                content.append(new String(temp));
                temp = new byte[1024];
            }

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public String readFileInChar(String fileName, String filePath) {
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            System.out.println(fileName + " don't exist");
            return null;
        }

        StringBuffer content = new StringBuffer();
        try {
            char[] temp = new char[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            while(inputStreamReader.read(temp) != -1){
                content.append(new String(temp));
                temp = new char[1024];
            }
            fileInputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public List<String> readFileInLine(String fileName, String filePath) {
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            System.out.println(fileName + " don't exist");
            return null;
        }

        List<String> content = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String lineContent = "";
            while ((lineContent = reader.readLine()) != null) {
                content.add(lineContent);
                System.out.println(lineContent);
            }

            fileInputStream.close();
            inputStreamReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
