package com.thread.multi.lesson4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by rogan on 2019/6/3.
 */
public class ConditionDemeSingal implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionDemeSingal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Condition before signal");
            condition.signal();
            System.out.println("Condition after signal");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
