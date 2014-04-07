package com.example.app.screen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.app.R;
import com.example.app.model.FakeDatabase;
import com.example.app.model.NewsElement;
import com.example.app.model.Repository;
import com.example.app.presenter.HomePresenter;

import java.util.List;


public class HomeScreen extends Activity implements IHomeScreen {

    private HomePresenter presenter;
    private ListView listView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        context = this;

        initPresenter();
        initLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.needNews();
    }

    private void initPresenter() {
        // fixme - dependency
        Repository repo = FakeDatabase.getInstance();
        this.presenter = new HomePresenter(this, repo);
    }

    private void initLayout() {
        this.listView = (ListView) findViewById(R.id.listview);
    }


    @Override
    public void displayNews(List<NewsElement> news) {
        NewsAdapter adapter = new NewsAdapter(this, R.layout.activity_home_screen, news);
        listView.setAdapter(adapter);
    }

    @Override
    public void displayFetchingError() {
        Toast.makeText(this, getString(R.string.error_fetching), Toast.LENGTH_SHORT);
    }

    public class NewsAdapter extends ArrayAdapter<NewsElement> {

        public NewsAdapter(Context context, int resource, List<NewsElement> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_news_element, parent, false);
            TextView tvTitle = (TextView) rowView.findViewById(R.id.row_title);
            TextView tvDesc = (TextView) rowView.findViewById(R.id.row_desc);
            tvTitle.setText(getItem(position).getTitle());
            tvDesc.setText(getItem(position).getDescription());

            return rowView;
        }
    }
}
