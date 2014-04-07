package com.example.test.activity;

import android.app.Activity;
import android.widget.ListView;
import com.example.app.R;
import com.example.app.screen.HomeScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Config(manifest = "../Example/src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class IGZTemplateActivityRobolectricTest {

    private HomeScreen homeScreen;
    private ActivityController<HomeScreen> homeScreenController;


    @Test
    public void testCreation() throws Exception {
        Activity activity = Robolectric.buildActivity(HomeScreen.class).create().get();
        assertTrue(activity != null);
    }




    @Before
    public void setup()  {
        homeScreen = Robolectric.buildActivity(HomeScreen.class).create()
                .start()
                .resume()
                .get();
        homeScreenController = Robolectric.buildActivity(HomeScreen.class).create().start();
    }

    @Test
    public void shouldCreateActivityWithListView() throws Exception {
        ListView listView = (ListView) homeScreen.findViewById(R.id.listview);

        assertNotNull(homeScreen);
        assertNotNull(listView);
    }

    @Test
    public void shouldCreateActivityWithListAndContent() {
        ListView listView = (ListView) homeScreen.findViewById(R.id.listview);

        assertNotNull(homeScreen);
        assertNotNull(listView);

        assertTrue(listView.getAdapter().getCount() > 0);
    }


    @After
    public void tearDown() throws Exception {
        homeScreenController = homeScreenController.pause().stop().destroy();
    }

}
