package com.kingdie.wangweijian.lambda.resourse;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 12:38 2019/10/15 0015
 * @ Description ：JDK7之前的文件拷贝功能
 */
public class FileCopyTest {

    @Test
    public void fileCopy(){
        /**
         * 1.创建输入输出流
         * 2.执行文件拷贝，读取文件内容，写入另一个文件中
         * 3.关闭文件流资源
         */

        //定义输入路径和输出路径
        String originalUrl = "lib\\FileCopyTest.java";
        String targetUrl = "targetTest\\target.txt";

        //声明文件输入流和输出流
        FileInputStream originalFileInputStream = null;
        FileOutputStream targetFileOutputStream = null;

        try {
            //实例化文件流对象
            originalFileInputStream = new FileInputStream(originalUrl);
            targetFileOutputStream = new FileOutputStream(targetUrl);

            //读取的字节信息
            int content;

            //迭代，读取/写入字节
            while((content = originalFileInputStream.read()) != -1){
                targetFileOutputStream.write(content);
            }

            /**
             * 另一种读取方式
             */
//            byte[] b = new byte[1024];
//            while((content = originalFileInputStream.read(b)) != -1){
//                targetFileOutputStream.write(b, 0,content);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭流资源
            if(targetFileOutputStream != null){
                try {
                    targetFileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(originalFileInputStream != null){
                try {
                    originalFileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
