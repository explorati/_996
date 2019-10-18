package com.kingdie.wangweijian.lambda.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:46 2019/10/18 0018
 * @ Description ：
 */
public class ThreadVs {

    @Test
    public void newHandle() throws InterruptedException {

        ExecutorService threadpool = Executors.newFixedThreadPool(10);
        //使用循环来模拟许多用户请求的场景
        for(int request = 1; request < 100; request ++){
            threadpool.execute(() -> {
                System.out.println("文档处理开始!");

                try {
                    TimeUnit.MILLISECONDS.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("文档处理结束!");
            });
        }
        Thread.sleep(1000 * 100);
    }

    /**
     * 老的处理方式
     */
    @Test
    public void oldHandle() throws InterruptedException {
        /**
         * 使用循环模拟许多用户访问的场景
         */
        for(int request = 1; request <= 100; request++){
            new Thread(() -> {
                System.out.println("文档处理开始!");

                try {
                    //将 Word 转成 PDF 格式：处理时间很长的耗时过程
//                    Thread.sleep(1000L * 30);
                    TimeUnit.MILLISECONDS.sleep(1000 * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("文档处理结束!");
            }).start();
        }

        Thread.sleep(1000 * 1000);
    }

}
