package com.thread.multi.future.simple;

/**
 * 提交任务
 * 提交有返回值和没有返回值的任务
 * Created by rogan on 2019/8/7.
 */
public interface FutureService<IN, OUT> {

    Future<?> submit(Runnable runnable);

    Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback);

    static <T, R> FutureService<T, R> newService(){
        return new FutureServiceImpl<>();
    }


}
