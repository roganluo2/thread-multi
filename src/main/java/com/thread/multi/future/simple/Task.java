package com.thread.multi.future.simple;

/**
 * Created by rogan on 2019/8/7.
 */
public interface Task<IN,OUT> {

    OUT call(IN input);

}
