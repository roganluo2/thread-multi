package com.thread.multi.lesson1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 这个是一个视频信息
 * Created by rogan on 2019/5/17.
 */
public class ViedoFactory implements INewsFactory {
    @Override
    public List<Object> getNews(Object query) {
        //这里查询DB获取用户喜欢的视频
        Video video = new Video();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    class Video {

    }
}
