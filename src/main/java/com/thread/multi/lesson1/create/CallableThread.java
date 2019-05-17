package com.thread.multi.lesson1.create;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * Created by rogan on 2019/5/16.
 */
public class CallableThread implements Callable<String> {

    private String name;

    public CallableThread(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return name + "你好！";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new CallableThread("mic"));
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }
}
