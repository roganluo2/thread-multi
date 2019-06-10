package com.thread.multi.lesson4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/6/6.
 */
public class CountDownLatchDemo2 extends Thread{

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i =0 ;i< 1000; i++){
            new CountDownLatchDemo2().start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.print("所有线程准备开始跑");
        countDownLatch.countDown();
    }
}
