package com.thread.multi.lesson1.interupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/5/17.
 */
public class InteruptReset {

    public static void main(String[] args) throws InterruptedException {
//        restByInterupted();
        resetByException();
    }

    private static void resetByException() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("捕获中断异常" + Thread.currentThread().isInterrupted());
//                    e.printStackTrace();
                }

            }
        }, "InteruptReset");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

    private static void restByInterupted() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println("收到中断信号:" + Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    System.out.println("重置了中断信号:" + Thread.currentThread().isInterrupted());
                }

            }
        }, "InteruptReset");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }


}
