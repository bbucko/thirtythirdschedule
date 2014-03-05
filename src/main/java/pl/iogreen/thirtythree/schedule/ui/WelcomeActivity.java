package pl.iogreen.thirtythree.schedule.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Schedule;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    @InjectView(R.id.scheduleList)
    private ListView scheduleList;

    private final List<Schedule> schedules = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        schedules.add(new Schedule(1, "Room #1", "Session Name #1", new Date()));
        schedules.add(new Schedule(2, "Room #2", "Session Name #2", new Date()));
        schedules.add(new Schedule(3, "Room #3", "Session Name #3", new Date()));

        scheduleList.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return schedules.size();
            }

            @Override
            public Object getItem(int position) {
                return schedules.get(position);
            }

            @Override
            public long getItemId(int position) {
                return schedules.get(position).getId();
            }

            @Nullable
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final Schedule schedule = schedules.get(position);

                final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view = inflater.inflate(R.layout.schedule_list_item, parent, false);

                final TextView hourTextView = (TextView) view.findViewById(R.id.hour);
                hourTextView.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(schedule.getStart()));

                final TextView sessionName = (TextView) view.findViewById(R.id.session_name);
                sessionName.setText(schedule.getName());

                final TextView room = (TextView) view.findViewById(R.id.room);
                room.setText(schedule.getRoom());
                return view;
            }
        });
        scheduleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent scheduleSelected = new Intent(parent.getContext(), SessionActivity.class);
                scheduleSelected.putExtra(SessionActivity.SESSION_ID, id);
                startActivity(scheduleSelected);
            }
        });
    }
}
