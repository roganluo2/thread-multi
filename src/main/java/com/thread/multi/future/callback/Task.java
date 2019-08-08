package com.thread.multi.future.callback;

/**
 * Created by rogan on 2019/8/7.
 */
public interface Task<IN,OUT> {

    OUT call(IN input);

}
