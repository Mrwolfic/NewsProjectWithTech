package by.newsproject.techversion.model.service;

import by.newsproject.techversion.model.bean.News;

import java.util.List;

public interface NewsService {

    void create(News news);

    void update(News news);

    void deleteOneNews(int newsID);

    News readOneNews(int newsID);

    List<News> readAllNewsSortedByDate();

}
