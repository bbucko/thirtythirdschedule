package pl.iogreen.thirtythree.schedule;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;

import pl.iogreen.thirtythree.schedule.ui.fragments.MySessionsFragment;
import pl.iogreen.thirtythree.schedule.ui.fragments.SessionsFragment;
import pl.iogreen.thirtythree.schedule.ui.fragments.SpeakersFragment;
import pl.iogreen.thirtythree.schedule.ui.fragments.WelcomeFragment;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.drawer)
public class BaseActivity extends RoboActivity {

    @InjectView(R.id.drawer_layout) DrawerLayout drawer;
    @InjectView(R.id.left_drawer) ListView drawerList;

    private String[] menuItems = {"Sessions", "Speakers", "My Sessions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, new WelcomeFragment())
                .commit();

        drawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, menuItems));
        drawerList.setOnItemClickListener(new DrawerItemSelectedListener());
    }

    private class DrawerItemSelectedListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(@NotNull AdapterView<?> parent, View view, int position, long id) {
            final Fragment fragment;
            switch (menuItems[position]) {
                case "Speakers":
                    fragment = new SpeakersFragment();
                    break;
                case "Sessions":
                    fragment = new SessionsFragment();
                    break;
                case "My Sessions":
                    fragment = new MySessionsFragment();
                    break;
                default:
                    fragment = new Fragment();
                    break;
            }

            final FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            drawer.closeDrawer(drawerList);
        }
    }
}
