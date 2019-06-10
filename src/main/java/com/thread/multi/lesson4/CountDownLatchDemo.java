package com.thread.multi.lesson4;

import java.util.concurrent.CountDownLatch;

/**
 * Created by rogan on 2019/6/6.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        for(int i = 0 ;i< 3; ++i) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "- 执行中");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "- 执行完毕");
            },"t"+i).start();
        }
        countDownLatch.await();
        System.out.println("所有线程执行完毕");


    }
}
