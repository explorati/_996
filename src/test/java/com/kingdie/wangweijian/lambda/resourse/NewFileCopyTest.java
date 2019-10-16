package com.kingdie.wangweijian.lambda.resourse;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 20:13 2019/10/16 0016
 * @ Description ：JDK7之后，实现正确关闭资源方法
 *                  try - with - resource
 */
public class NewFileCopyTest {

    @Test
    public void copyFile() {
        /**
         * 1.创建输入输出流
         * 2.执行文件拷贝，读取文件内容，写入另一个文件中
         * 3.关闭输入输出流
         */
        String originalFilePath = "lib/FileCopyTest.java";
        String targetFilePath = "targetTest/new";

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(targetFilePath);
                FileInputStream fileInputStream = new FileInputStream(originalFilePath);
        ) {
            int content;
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
