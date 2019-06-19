package com.thread.multi.lesson2.homework;

/**
 * Created by rogan on 2019/5/28.
 */
public class SynchronizedDemo implements Runnable {
    int x = 100;

    public synchronized void m1() {
        x = 1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x=" + x);
    }

    public synchronized void m2() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = 2000;
    }
    public static void main(String[] args) throws InterruptedException {
            SynchronizedDemo sd = new SynchronizedDemo();
            new Thread(() -> sd.m1(), "thread1").start();
            new Thread(() -> sd.m2(), "thread2").start();
            sd.m2();
            System.out.println("Main x=" + sd.x);
    }

    @Override
    public void run() {
        m1();
    }
}
/*
输出结果，x =1000 Main x=2000交替出现
x=1000
Main x=2000
thread1 thread2 main线程的执行m1 m2 方法都需要持有对象锁，任何一个线程先拿到对象锁，都可以先执行，
如果main拿到对象锁，就输出Main:x=2000，然后输出x=1000
如果是thread1拿到对象锁，就输出x=1000,然后输出 main x= 2000
 */
