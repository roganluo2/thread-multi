package com.thread.multi.lesson1.status;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/5/16.
 */
public class ThreadStauts {

    public static void main(String[] args) {
        new Thread(() ->{
            try {
                TimeUnit.MINUTES.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"TIME_WAITING").start();
        Object obj = new Object();
        new Thread(() ->{
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"WAITING").start();

        new Thread(new BlockDemo(),"Blocked-thread1").start();
        new Thread(new BlockDemo(),"Blocked-thread2").start();
        new Thread(new BlockDemo(),"Blocked-thread3 not start");//看不到new的状态



    }

    static class BlockDemo implements Runnable{

        @Override
        public void run() {
            ThreadStauts.mockBlocking();
        }
    }

    public static synchronized void mockBlocking(){
        int i = 0;
        while (true)
        {
           i ++;
        }
    }

}
