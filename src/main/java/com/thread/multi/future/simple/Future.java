package com.thread.multi.future.simple;

/**
 * Created by rogan on 2019/8/7.
 */
public interface Future<T> {

    T get() throws InterruptedException;

    boolean isDone();
}
