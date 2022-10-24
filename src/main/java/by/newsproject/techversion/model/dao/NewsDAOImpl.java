package by.newsproject.techversion.model.dao;

import by.newsproject.techversion.model.bean.News;
import by.newsproject.techversion.model.bean.constant.NewsParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveNews(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
    }

    private final static String SELECT_ONE_NEWS_HQL = "from News where id =:newsID";

    @Override
    public News readOneNews(int newsID) {
        Session session = sessionFactory.getCurrentSession();

        Query<News> query = session.createQuery(SELECT_ONE_NEWS_HQL, News.class);
        query.setParameter(NewsParam.ID_KEY, newsID);

        return query.getSingleResult();
    }

    private final static String UPDATE_NEWS_HQL = "update News set title=:newsTitle," +
            " brief=:newsBrief, content=:newsContent  where id=:newsID";
    @Override
    public void updateNews(News news) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(UPDATE_NEWS_HQL);

        query.setParameter(NewsParam.ID_KEY, news.getId());
        query.setParameter(NewsParam.TITLE_KEY, news.getTitle());
        query.setParameter(NewsParam.BRIEF_KEY, news.getBrief());
        query.setParameter(NewsParam.CONTENT_KEY, news.getContent());
        query.executeUpdate();
    }

    private final static String DELETE_ONE_NEWS_HQL = "update News set status=:status where id=:newsID";
    @Override
    public void deleteOneNews(int newsID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(DELETE_ONE_NEWS_HQL);
        query.setParameter(NewsParam.ID_KEY, newsID);
        query.setParameter(NewsParam.STATUS_KEY, NewsParam.STATUS_DELETE_VALUE);
        query.executeUpdate();
    }

    private final static String SELECT_ALL_ACTIVE_NEWS_HQL = "from News where status=:status order by dateOfCreation desc";
    @Override
    public List<News> readAllNews() {
        Session session = sessionFactory.getCurrentSession();

        Query<News> query = session.createQuery(SELECT_ALL_ACTIVE_NEWS_HQL, News.class);
        query.setParameter(NewsParam.STATUS_KEY, NewsParam.STATUS_EXIST_VALUE);

        return query.getResultList();
    }
}
