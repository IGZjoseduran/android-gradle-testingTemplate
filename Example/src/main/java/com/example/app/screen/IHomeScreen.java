package com.example.app.screen;

import com.example.app.model.NewsElement;

import java.util.List;

/**
 * Created by lgvalle on 05/04/14.
 */
public interface IHomeScreen {

    /**
     * Called from the {@link HomePresenter HomePresenter} when it has news to display
     * @param news List of news to display
     */
    public void displayNews(List<NewsElement> news);

    /**
     * Display an error when can't get news
     */
    public void displayFetchingError();
}
