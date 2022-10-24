package by.newsproject.techversion.controller.constant;

public class PatternURL {

    private PatternURL(){

    }

    public final static String NEWS_CONTROLLER = "/news";
    public final static String BASIC_PAGE_FORWARD = "/basic-page";
    public final static String BASIC_PAGE_REDIRECT = "redirect:/basic-page";

    public final static String ERROR_PAGE_FORWARD = "error-page";

    public final static String GO_TO_ADD_NEWS = "/goToAddNewsPage";
    public final static String GO_TO_EDIT_NEWS = "/goToEditNewsPage/{id}";
    public final static String GO_TO_VIEW_NEWS = "/goToViewNewsPage/{id}";
    public final static String CREATE_NEWS = "/create";
    public final static String UPDATE_NEWS = "/update";
    public final static String DELETE_ONE_NEWS = "/deleteOneNews/{id}";
    public final static String DELETE_MULTIPLE_NEWS = "/deleteMultipleNews";

}
