package com.javarush.task;

import java.io.*;
import java.sql.Blob;
import java.util.Base64;

public class Solution {

    public static void main(String[] args)throws Exception {
        Blob image = null;
        //save image into database
        File file = new File("D:\\test.jpg");
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();

//            ByteArrayInputStream bais = new ByteArrayInputStream(bFile);
//            System.out.println(bais);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] bytes = "Hello, World!".getBytes("UTF-8");
        String encoded = Base64.getEncoder().encodeToString(bFile);
        byte[] decoded = Base64.getDecoder().decode(encoded);
        System.out.println(encoded);
        writeToFile(decoded, "D:\\testFromByte.jpg" );
    }

    public static void writeToFile(byte[] data, String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName);
        out.write(data);
        out.close();
    }


}