package com.thread.multi.lesson1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 产生图片类型的新闻工厂
 * Created by rogan on 2019/5/17.
 */
public class ImageFactory implements INewsFactory {
    @Override
    public List<Object> getNews(Object query) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
