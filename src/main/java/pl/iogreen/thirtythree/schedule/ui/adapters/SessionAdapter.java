package pl.iogreen.thirtythree.schedule.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Session;

public class SessionAdapter extends BaseAdapter {

    private final Session[] sessions;
    private final Context context;

    public SessionAdapter(Session[] sessions, Context context) {
        this.sessions = sessions;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sessions.length;
    }

    @Override
    public Object getItem(int position) {
        return sessions[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public View getView(int position, View convertView, @NotNull ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View sessionListView = inflater.inflate(R.layout.speaker_session_list_view, parent, false);

        final Session session = sessions[position];

        final TextView textView = (TextView) sessionListView.findViewById(R.id.session_name);
        textView.setText(session.getName());

        return sessionListView;
    }
}