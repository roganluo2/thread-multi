package com.thread.multi.lesson5.homework;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/6/20.
 */
public class QueueDemoTest {

    public static void main(String[] args) {
        QueueDemo queueDemo = new BlockingQueueImpl(5);
        for(int i= 0 ;i<6;i++){
            new Thread(()->{
                queueDemo.put(new Object() );
                System.out.println(Thread.currentThread().getName() + "添加成功");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"producer" + i).start();
        }

        for(int i= 0 ;i<10;i++){
            new Thread(()->{
                queueDemo.take();
                System.out.println(Thread.currentThread().getName() + "获取成功");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"consumer" + i).start();
        }
    }
}
