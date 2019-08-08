package com.thread.multi.future.simple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rogan on 2019/8/7.
 */
public class FutureServiceImpl<IN,OUT> implements FutureService<IN, OUT> {

    static AtomicInteger  nextCounter = new AtomicInteger(0);

    static String FUTURE_THREAD_PREFIX = "FUTURE-";

    //通过新的线程执行
    public Future<?> submit(Runnable runnable) {
        FutureTask<Void> futureTask = new FutureTask<Void>();
        new Thread(() ->{
            runnable.run();
           futureTask.finish(null);
        }, getNextName()).start();

        return futureTask;
    }

    public Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback) {
        FutureTask<OUT> futureTask = new FutureTask<>();
        new Thread(() ->{
            OUT reuslt = task.call(input);
            futureTask.finish(reuslt);
            if(null != callback)
            {
                callback.call(reuslt);
            }
        }, getNextName()).start();
        return futureTask;
    }

    public String getNextName() {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }
}
