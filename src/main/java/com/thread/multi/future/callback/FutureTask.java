package com.thread.multi.future.callback;

/**
 * Created by rogan on 2019/8/7.
 */
public class FutureTask<T> implements Future {

    private T result;

    private boolean isDone = false;

    private final Object LOCK = new Object();


    public Object get() throws InterruptedException {
        synchronized (LOCK)
        {
            while (!isDone)
            {
                LOCK.wait();
            }
            return result;
        }
    }


    protected void finish(T result){
        synchronized (LOCK)
        {
            if(isDone)
            {
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

    public boolean isDone() {
       return isDone;
    }
}
