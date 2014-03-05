package pl.iogreen.thirtythree.schedule;

import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import pl.iogreen.thirtythree.schedule.model.NavDrawerItem;
import pl.iogreen.thirtythree.schedule.ui.adapters.NavDrawerListAdapter;
import pl.iogreen.thirtythree.schedule.ui.fragments.MySessionsFragment;
import pl.iogreen.thirtythree.schedule.ui.fragments.SessionsFragment;
import pl.iogreen.thirtythree.schedule.ui.fragments.SpeakersFragment;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.drawer)
public class WelcomeActivityWithDrawer extends RoboActivity {

    @InjectView(R.id.drawer_layout) DrawerLayout drawer;
    @InjectView(R.id.left_drawer) ListView drawerList;

    private ActionBarDrawerToggle drawerToggle;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        setupTopNavigation();
        setupDrawer();
    }

    private void setupDrawer() {
        drawerList.setAdapter(new NavDrawerListAdapter(getApplicationContext(), navDrawerItems));
        drawerList.setOnItemClickListener(new DrawerItemSelectedListener());

        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawer.setDrawerListener(drawerToggle);
    }

    private void setupTopNavigation() {
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        navDrawerItems = new ArrayList<>();
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));

        navMenuIcons.recycle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_search:
                drawer.closeDrawer(drawerList);
                return true;
            case R.id.action_sessions:
                drawer.closeDrawer(drawerList);
                return true;
            case R.id.action_speakers:
                drawer.closeDrawer(drawerList);
                return true;
            default:
                drawer.closeDrawer(drawerList);
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    private class DrawerItemSelectedListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(@NotNull AdapterView<?> parent, View view, int position, long id) {
            final Fragment fragment;
            switch (position) {
                case 1:
                    fragment = new SpeakersFragment();
                    break;
                case 2:
                    fragment = new SessionsFragment();
                    break;
                case 3:
                    fragment = new MySessionsFragment();
                    break;
                default:
                    fragment = new Fragment();
                    break;
            }

            getFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            drawer.closeDrawer(drawerList);
        }
    }
}
