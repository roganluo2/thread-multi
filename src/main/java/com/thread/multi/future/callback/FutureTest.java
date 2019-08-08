package com.thread.multi.future.callback;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/8/7.
 */
public class FutureTest {

    public static void main(String[] argsss) throws Exception {
//       testGetVoid();
        testGetResult();
    }

    private static void testGetResult()throws Exception{
        FutureService<String, Integer> futureService = FutureService.newService();
        Future<Integer> future = futureService.submit(new Task<String, Integer>() {
            @Override
            public Integer call(String input) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return input.length();
            }
        },"hello");

        System.out.println(future.get());
    }

    private static void testGetVoid() throws InterruptedException{

        FutureService<Object, Object> futureService = FutureService.newService();
        Future<?> submit = futureService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am finish done.");
            }
        });
        submit.get();
    }

}
