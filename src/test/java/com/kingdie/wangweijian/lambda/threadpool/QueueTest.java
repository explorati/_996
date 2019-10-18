package com.kingdie.wangweijian.lambda.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:49 2019/10/18 0018
 * @ Description ：
 */
public class QueueTest {

    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        /**
         * 基于数组的有界队列，队列容量为10
         */
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

        //循环想队列添加元素
        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加值：" + i + "成功");
        }
    }

    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        /**
         * 基于链表的有界阻塞队列，队列容量为10
         */
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(10);

        //循环想队列添加元素
        for (int i = 0; i < 20; i++) {
            linkedBlockingQueue.put(i);
            System.out.println("向队列中添加值：" + i + "成功");
        }
    }

    @Test
    public void synchronizedQueue() throws InterruptedException {
        /**
         * 同步移交阻塞队列
         */
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        //插入值
        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("插入成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //删除值
//        new Thread(() -> {
//            try {
//                queue.take();
//                System.out.println("删除成功");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        Thread.sleep(1000 * 10);

    }


}
