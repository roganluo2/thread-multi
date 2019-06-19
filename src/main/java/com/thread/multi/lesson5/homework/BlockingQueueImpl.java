package com.thread.multi.lesson5.homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rogan on 2019/6/20.
 */
public class BlockingQueueImpl implements QueueDemo {

    private Integer size = 0;

    private Integer capacity;

    private static Integer DEFAULT_CAPACITY = 1 << 4;

    private Object[] data;

    private Integer putIndex = 0;

    private Integer takeIndex = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition emptyCondition;

    private Condition fullCondition;

    public BlockingQueueImpl() {
        this(DEFAULT_CAPACITY);
    }

    public BlockingQueueImpl(Integer capacity)
    {
        this.capacity = capacity;
        data = new Object[this.capacity];
        emptyCondition = lock.newCondition();
        fullCondition = lock.newCondition();
    }

    @Override
    public void put(Object obj) {
        lock.lock();
        try {
            //遇到队列满了，就阻塞
            if(size.equals(capacity))
            {
                fullCondition.await();
            }
            data[putIndex] = obj;
            putIndex++;
            //数组复位
            if(putIndex.equals(data.length))
            {
                putIndex = 0;
            }
            size ++;
            emptyCondition.signalAll();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public Object take() {
        lock.lock();
        try {
            //遇到队列是空阻塞
            if(size .equals(0))
            {
                emptyCondition.await();
            }

            Object o = data[takeIndex];
            takeIndex++;
            //数组复位
            if(takeIndex.equals(data.length))
            {
                takeIndex = 0;
            }
            size --;
            fullCondition.signalAll();
            return o;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        return null;
    }
}
