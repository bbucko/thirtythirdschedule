package pl.iogreen.thirtythree.schedule.ui;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Session;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_session)
public class SessionActivity extends BaseActivity {

    public static final String SESSION_ID = "pl.iogreen.thirtythree.SESSION_ID";

    @InjectView(R.id.session_name)
    private TextView sessionName;

    @InjectView(R.id.session_room)
    private TextView sessionRoom;

    @InjectView(R.id.session_start)
    private TextView sessionStart;

    @InjectView(R.id.session_description)
    private TextView sessionDescription;

    @InjectView(R.id.speakers)
    private ListView speakersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long sessionId = 0;

        if (savedInstanceState != null) {
            sessionId = savedInstanceState.getLong(SESSION_ID);
            System.out.println(sessionId);
        }

        Session session = new Session(sessionId, "Name", "Lorem Ipsum", new Date());

        sessionName.setText(session.getName());
        sessionDescription.setText(session.getDescription());
        sessionStart.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(session.getStart()));
        sessionRoom.setText("Session Room //FIXME");
    }
}
