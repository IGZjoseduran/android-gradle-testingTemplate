package com.example.app.presenter;


import com.example.app.model.NewsElement;
import com.example.app.model.Repository;
import com.example.app.screen.IHomeScreen;

import java.util.List;

/**
 * Created by lgvalle on 05/04/14.
 */
public class HomePresenter implements IHomePresenter{

    private final IHomeScreen screen;
    private final Repository repo;

    public HomePresenter(IHomeScreen screen, Repository repo) {
        this.screen = screen;
        this.repo = repo;
    }

    @Override
    public void needNews() {
        List<NewsElement> news = repo.getNews();
        if (news != null && news.size() > 0) {
            screen.displayNews(news);
        } else {
            screen.displayFetchingError();
        }


    }
}
