package pl.iogreen.thirtythree.schedule.ui;

import android.view.Menu;

import pl.iogreen.thirtythree.schedule.R;
import roboguice.activity.RoboActivity;

public abstract class BaseActivity extends RoboActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
