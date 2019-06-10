package com.thread.multi.lesson4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rogan on 2019/6/3.
 */
public class ConditionDemoWait implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Condition before await");
            condition.await();
            System.out.println("Condition after await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionDemoWait waite = new ConditionDemoWait(lock, condition);
        ConditionDemeSingal singal = new ConditionDemeSingal(lock, condition);
        new Thread(waite).start();
        new Thread(singal).start();
        System.out.println("main thread end");
    }
}
