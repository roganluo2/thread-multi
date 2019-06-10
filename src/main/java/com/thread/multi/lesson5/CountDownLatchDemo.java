package com.thread.multi.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for(int i = 0;i<3 ;i++)
        {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("ssss");
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"t"+i).start();
        }
        TimeUnit.MINUTES.sleep(30);
        System.out.print("==============");
        countDownLatch.countDown();

    }


}
