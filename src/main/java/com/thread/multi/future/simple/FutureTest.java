package com.thread.multi.future.simple;

import com.thread.multi.lesson1.interupt.InteruptDemo;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogan on 2019/8/7.
 */
public class FutureTest {

    public static void main(String[] argsss) throws Exception {
        FutureService<String, Integer> futureService = FutureService.newService();
        futureService.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        },"TEST",in ->{
//            System.out.println("wanchengzhixing ");
            System.out.println(in);
        });

    }


}
