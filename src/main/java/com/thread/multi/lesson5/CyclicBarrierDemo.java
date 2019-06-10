package com.thread.multi.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by rogan on 2019/6/10.
 */
public class CyclicBarrierDemo {

    static class DataImportThread extends Thread{
        private String path;
        private CyclicBarrier cyclicBarrier;

        public DataImportThread(String path, CyclicBarrier cyclicBarrier) {
            this.path = path;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("开始导入"+path +"位置的数据");
            try {
                cyclicBarrier.await(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }



    static class CyclicBarrierAnalysis extends Thread{
        @Override
        public void run() {
            System.out.println("开始进行数据分析");
        }
    }

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new CyclicBarrierAnalysis());
        for(int i=0;i< 2;i++){
            new Thread(new DataImportThread("file"+i,cyclicBarrier)).start();
        }

    }

}
