package com.yu.springboot_jdbc_mybatis.tool;

import java.io.*;

/**
 * @author 二十九
 * //图片处理
 */
public class Image {
    public static byte[] getImage(String titleName, String userName) throws IOException {
        //获取用户输入的用户名
        String filename = titleName + ".jpg";  //根据用户名生成文件名
        String path = "E:\\test\\" + userName + "\\" + "menuImage" + "\\";
        File file = new File(path, filename);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] data = new byte[(int) size];
            fis.read(data, 0, (int) size);
            fis.close();
            return data;
        } catch (Exception e) {
            String filename1 = "1.png";  //根据用户名生成文件名
            String path1 = "E:\\test\\错误\\menuImage";
            File file1 = new File(path1, filename1);
            FileInputStream fis1;
            fis1 = new FileInputStream(file1);
            long size = file1.length();
            byte[] data = new byte[(int) size];
            fis1.read(data, 0, (int) size);
            fis1.close();
            System.out.println(e.getMessage());
            return data;
        }
    }
}
