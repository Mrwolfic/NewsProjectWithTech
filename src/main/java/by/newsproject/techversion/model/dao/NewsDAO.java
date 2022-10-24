package by.newsproject.techversion.model.dao;

import by.newsproject.techversion.model.bean.News;

import java.util.List;

public interface NewsDAO {
    void saveNews(News news);

    News readOneNews(int NewsID);

    void updateNews(News news);

    void deleteOneNews(int newsID);

    List<News> readAllNews();
}
