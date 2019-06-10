package com.thread.multi.lesson5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for(int i = 0 ;i< 10;i++){
           new Car(semaphore,i).start();
        }

    }

    static class Car extends Thread{
        private Semaphore semaphore;
        private int i;
        public Car(Semaphore semaphore,Integer i){
            this.semaphore = semaphore;
            this.i = i;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();
                System.out.println("第" + i + "辆车抢到了车位");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("第" + i + "释放了车位车位");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
