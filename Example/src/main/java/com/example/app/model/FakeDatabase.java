package com.example.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgvalle on 05/04/14.
 */
public class FakeDatabase  implements  Repository{


    private static FakeDatabase instance;

    protected FakeDatabase(){}

    public static FakeDatabase getInstance() {
        if (instance == null) {
            instance = new FakeDatabase();
        }
        return instance;
    }

    @Override
    public List<NewsElement> getNews() {
        List<NewsElement> news = new ArrayList<NewsElement>();
        news.add(new NewsElement(1, "Noticia 1", "Descripción de la noticia 1"));
        news.add(new NewsElement(2, "Noticia 2", "Descripción de la noticia 2"));
        news.add(new NewsElement(3, "Noticia 3", "Descripción de la noticia 3"));
        news.add(new NewsElement(4, "Noticia 4", "Descripción de la noticia 4"));

        return news;
    }
}
