package by.newsproject.techversion.controller;

import by.newsproject.techversion.controller.constant.ModelAttr;
import by.newsproject.techversion.controller.constant.PathVar;
import by.newsproject.techversion.controller.constant.PatternURL;
import by.newsproject.techversion.controller.constant.RequestParameter;
import by.newsproject.techversion.model.bean.News;
import by.newsproject.techversion.model.bean.constant.NewsParam;
import by.newsproject.techversion.model.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(PatternURL.NEWS_CONTROLLER)
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(PatternURL.GO_TO_ADD_NEWS)
    public String goToAddNewsPage(Model model) {

        model.addAttribute(ModelAttr.VIEW_NEWS_KEY, ModelAttr.VIEW_NEWS_VALUE);
        model.addAttribute(ModelAttr.NEWS_ACTION_KEY, ModelAttr.NEWS_ACTION_ADD_VALUE);
        model.addAttribute(ModelAttr.OBJECT_NEWS_KEY, new News());

        return PatternURL.BASIC_PAGE_FORWARD;
    }

    @RequestMapping(PatternURL.GO_TO_EDIT_NEWS)
    public String goToEditNewsPage(Model model, @PathVariable(PathVar.newsID) int newsID) {

        News news = newsService.readOneNews(newsID);

        model.addAttribute(ModelAttr.VIEW_NEWS_KEY, ModelAttr.VIEW_NEWS_VALUE);
        model.addAttribute(ModelAttr.NEWS_ACTION_KEY, ModelAttr.NEWS_ACTION_EDIT_VALUE);
        model.addAttribute(ModelAttr.OBJECT_NEWS_KEY, news);

        return PatternURL.BASIC_PAGE_FORWARD;
    }

    @RequestMapping(PatternURL.GO_TO_VIEW_NEWS)
    public String goToViewNewsPage(Model model, @PathVariable(PathVar.newsID) int newsID) {

        News news = newsService.readOneNews(newsID);

        model.addAttribute(ModelAttr.VIEW_NEWS_KEY, ModelAttr.VIEW_NEWS_VALUE);
        model.addAttribute(ModelAttr.NEWS_ACTION_KEY, ModelAttr.NEWS_ACTION_VIEW_VALUE);
        model.addAttribute(ModelAttr.OBJECT_NEWS_KEY, news);
        return PatternURL.BASIC_PAGE_FORWARD;
    }

    @PostMapping(PatternURL.CREATE_NEWS)
    public String createNews(@ModelAttribute(ModelAttr.OBJECT_NEWS_KEY) @Valid News news, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(ModelAttr.VIEW_NEWS_KEY, ModelAttr.VIEW_NEWS_VALUE);
            model.addAttribute(ModelAttr.NEWS_ACTION_KEY, ModelAttr.NEWS_ACTION_ADD_VALUE);
            return PatternURL.BASIC_PAGE_FORWARD;
        }

        news.setStatus(NewsParam.STATUS_EXIST_VALUE);
        newsService.create(news);

        return PatternURL.BASIC_PAGE_REDIRECT;
    }

    @PostMapping(PatternURL.UPDATE_NEWS)
    public String updateNews(@ModelAttribute(ModelAttr.OBJECT_NEWS_KEY) @Valid News news, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(ModelAttr.VIEW_NEWS_KEY, ModelAttr.VIEW_NEWS_VALUE);
            model.addAttribute(ModelAttr.NEWS_ACTION_KEY, ModelAttr.NEWS_ACTION_EDIT_VALUE);
            return PatternURL.BASIC_PAGE_FORWARD;
        }
        newsService.update(news);
        return PatternURL.BASIC_PAGE_REDIRECT;
    }

    @DeleteMapping(PatternURL.DELETE_ONE_NEWS)
    public String deleteOneNews(@PathVariable(PathVar.newsID) int newsID) {

        newsService.deleteOneNews(newsID);

        return PatternURL.BASIC_PAGE_REDIRECT;
    }

    @DeleteMapping(PatternURL.DELETE_MULTIPLE_NEWS)
    public String deleteMultipleNews(@RequestParam(RequestParameter.ID_NEWS_LIST) int[] newsID) {

        for (int id : newsID) {
            newsService.deleteOneNews(id);
        }
        return PatternURL.BASIC_PAGE_REDIRECT;

    }

    @ExceptionHandler(Exception.class)
    public String errorHandle(){
        return PatternURL.ERROR_PAGE_FORWARD;
    }
}
