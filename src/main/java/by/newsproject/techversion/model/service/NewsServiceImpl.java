package by.newsproject.techversion.model.service;

import by.newsproject.techversion.model.bean.News;
import by.newsproject.techversion.model.dao.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    @Transactional
    public void create(News news) {
        newsDAO.saveNews(news);
    }

    @Override
    @Transactional
    public void update(News news) {
        newsDAO.updateNews(news);
    }

    @Override
    @Transactional
    public void deleteOneNews(int newsID) {
        newsDAO.deleteOneNews(newsID);
    }

    @Override
    @Transactional
    public News readOneNews(int newsID) {
        News news = newsDAO.readOneNews(newsID);
        return news;
    }

    @Override
    @Transactional
    public List<News> readAllNewsSortedByDate() {
        return newsDAO.readAllNews();
    }
}
