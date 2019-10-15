package com.kingdie.wangweijian.lambda.resourse;

import com.kingdie.wangweijian.lambda.file.FileConsumer;
import org.junit.Test;

import java.io.*;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 10:48 2019/10/15 0015
 * @ Description ：资源关闭优化前与优化后代码量对比
 */
public class ResourceCloseVs {

    @Test
    public void newFileHandle(String url, FileConsumer fileConsumer) {
        //try注意是 ()
        try(
            FileInputStream fileInputStream = new FileInputStream(url);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ){
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }

            fileConsumer.fileHandler(stringBuilder.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void oldFileHandle(String url, FileConsumer fileConsumer) throws IOException {
        //声明
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        //创建文件读取流
        try{
            fileInputStream = new FileInputStream(url);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            //定义行变量和内容sb
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            //循环读取文件内容
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }

            //调用函数式接口方法，将文件内容传递给lambda表达式，实现业务逻辑
            fileConsumer.fileHandler(stringBuilder.toString());
        }finally{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(fileInputStream != null){
                fileInputStream.close();
            }
        }
    }
}
