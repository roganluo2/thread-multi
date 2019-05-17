package com.thread.multi.lesson1.homework;

import java.util.List;

/**
 * 会根据查询参数返回对应的新闻
 * Created by rogan on 2019/5/16.
 */
public interface INewsFactory {

    List<Object> getNews(Object query);

}
