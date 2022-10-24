package by.newsproject.techversion.controller;

import by.newsproject.techversion.controller.constant.ModelAttr;
import by.newsproject.techversion.controller.constant.PatternURL;
import by.newsproject.techversion.model.bean.News;
import by.newsproject.techversion.model.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
@Controller
public class MainPageController {
    @Autowired
    private NewsService newsService;

    @RequestMapping
    public String redirectToBasicPage(){
        return PatternURL.BASIC_PAGE_REDIRECT;
    }

    @RequestMapping(PatternURL.BASIC_PAGE_FORWARD)
    public String goToBasicPage(Model model){

        List<News> newsList = newsService.readAllNewsSortedByDate();

        model.addAttribute(ModelAttr.VIEW_NEWS_KEY, ModelAttr.VIEW_NEWS_LIST_VALUE);
        model.addAttribute(ModelAttr.OBJECT_NEWS_LIST_KEY, newsList);

        return PatternURL.BASIC_PAGE_FORWARD;
    }
}
