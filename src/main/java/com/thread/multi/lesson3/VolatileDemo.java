package com.thread.multi.lesson3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rogan on 2019/5/28.
 */
public class VolatileDemo {
    public volatile static boolean stop = false;

    /**
     * volatile 使用与不使用的区别
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
            int i=0;
            while (!stop)
            {
                i++;
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }




}
