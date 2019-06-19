package com.thread.multi.lesson4.homework;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 分析reentrantReadWriteLock原理
 * Created by rogan on 2019/6/20.
 */
public class ReentrantReadWriteLockDemo
{


    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        readLock.unlock();

        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();

        writeLock.unlock();


    }

}
