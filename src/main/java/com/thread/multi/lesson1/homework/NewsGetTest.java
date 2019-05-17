package com.thread.multi.lesson1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by rogan on 2019/5/17.
 */
public class NewsGetTest {


    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        Object query = new Object();
        //调用图片工厂，查询图片信息 视频工厂查询视频新闻，通过多线程异步执行，本身是非阻塞的
        List<Future<List<Object>>> futureList = new ArrayList<>();
        Future<List<Object>> imageList = executorService.submit(new GetNewsCall(new ImageFactory(), query));
        futureList.add(imageList);
        Future<List<Object>> videoList  = executorService.submit(new GetNewsCall(new ViedoFactory(), query));
        futureList.add(videoList);
        Future<List<Object>> artileList = executorService.submit(new GetNewsCall(new ArticleFactory(), query));
        futureList.add(artileList);
//        最后要得到一个由视频，图片，文章组成的推荐列表
        List<Object> recommendList = new ArrayList<>();
        for(Future<List<Object>> future : futureList)
        {
            try {
                List<Object> objects = future.get();
                recommendList.add(objects);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("获取推荐列表总共耗时"+ (end -start) + "ms");

    }


    //异步去获取对应的新闻类型
    static class GetNewsCall implements Callable<List<Object>>
    {

        private INewsFactory newsFactory;

        private Object query;

        GetNewsCall(INewsFactory newsFactory, Object query) {
            this.newsFactory = newsFactory;
            this.query = query;
        }


        @Override
        public List<Object> call() throws Exception {
            return newsFactory.getNews(query);
        }
    }

}
