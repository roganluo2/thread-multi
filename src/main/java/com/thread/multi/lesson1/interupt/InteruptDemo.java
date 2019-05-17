package com.thread.multi.lesson1.interupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/5/17.
 */
public class InteruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

            }
        }, "InteruptThread");

//        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

}
