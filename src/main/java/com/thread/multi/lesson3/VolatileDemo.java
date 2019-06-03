package com.thread.multi.lesson3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by rogan on 2019/5/28.
 */
public class VolatileDemo {
    public static /*volatile*/ boolean stop = false;

    //volatile 使用
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
            int i=0;
            while (!stop)
            {
                System.out.println(i++);
            }
        });
        thread.start();
        System.out.println("begin start thread");
        TimeUnit.SECONDS.sleep(1);
        stop = true;

    }




}
