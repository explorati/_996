package com.kingdie.wangweijian.lambda.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 19:30 2019/10/18 0018
 * @ Description ：创建线程池的两种方式
 */
public class RunTest {

    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        /**
         *利用submit方法提交任务，接收任务的返回结果
         */
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(1000 * 10);
            return 2 * 5;
        });

        /**
         * 阻塞方法，直到任务有返回值后，才向下执行
         */
        Integer num = future.get();

        System.out.println("执行结果：" + num);
    }

    @Test
    public void executTest() throws InterruptedException {
        //创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        /**
         * 利用execute方法提交任务，没有返回结果
         */
        threadPool.execute(() -> {
            try {
                Thread.sleep(1000L * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer num = 2 * 5;
            System.out.println("执行结果：" + num);
        });

        Thread.sleep(1000L * 1000);
    }
}
