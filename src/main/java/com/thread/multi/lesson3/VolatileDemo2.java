package com.thread.multi.lesson3;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/5/28.
 */
public class VolatileDemo2 {

    static  int a = 0;
    //原子性分析
    public static void main(String[] args) throws InterruptedException {
        for(int i =0; i < 100;i ++){
            new Thread(() ->{
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = a+10;}).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(a);

    }


}
