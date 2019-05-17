package com.thread.multi.lesson1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 这个主要返回美文的新闻
 * Created by rogan on 2019/5/17.
 */
public class ArticleFactory implements INewsFactory {
    @Override
    public List<Object> getNews(Object query) {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
