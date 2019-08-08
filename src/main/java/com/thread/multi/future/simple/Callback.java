package com.thread.multi.future.simple;

/**
 * Created by rogan on 2019/8/7.
 */
public interface Callback<T> {

    void call(T t);

}
