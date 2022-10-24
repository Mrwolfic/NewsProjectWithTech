package by.newsproject.techversion.aop;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggerAOPforExcetpion {
    private final static Logger log = LogManager.getRootLogger();

    @AfterThrowing(pointcut = "execution" +
            "(public String by.newsproject.techversion.controller.NewsController.createNews(..))", throwing = "e")
    public void loggingForSavingNews(Throwable e) {

        log.log(Level.ERROR, "Something's wrong with saving news", e);
    }

    @AfterThrowing(pointcut = "execution" +
            "(public String by.newsproject.techversion.controller.NewsController.updateNews(..))", throwing = "e")
    public void loggingForUpdatingNews(Throwable e) {

        log.log(Level.ERROR, "Something's wrong with updating news", e);
    }

    @AfterThrowing(pointcut = "execution" +
            "(public String by.newsproject.techversion.controller.NewsController.deleteOneNews(int))", throwing = "e")
    public void loggingForDeleteOneNews(Throwable e) {

        log.log(Level.ERROR, "Something's wrong with deleting one news", e);
    }

    @AfterThrowing(pointcut = "execution" +
            "(public String by.newsproject.techversion.controller.NewsController.deleteMultipleNews(int[]))", throwing = "e")
    public void loggingForDeleteMultipleNews(Throwable e) {

        log.log(Level.ERROR, "Something's wrong with deleting multiple news", e);
    }
}
