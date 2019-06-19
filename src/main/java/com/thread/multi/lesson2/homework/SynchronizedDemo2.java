package com.thread.multi.lesson2.homework;

import java.io.IOException;

/**
 * Created by rogan on 2019/5/28.
 */
public class SynchronizedDemo2 {

    static Integer count=0;
    public static void incr(){
        synchronized (count) {//这里是对count 加锁
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++; //这里同步代码块中对加锁的对象值进行了修改，出现changelock导致锁被释放，最终结果不能是1000
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->SynchronizedDemo2.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println("result:"+count);
    }

}
