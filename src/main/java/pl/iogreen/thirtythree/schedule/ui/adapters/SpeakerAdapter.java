package pl.iogreen.thirtythree.schedule.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Speaker;

public class SpeakerAdapter extends BaseAdapter {
    private final Context context;
    private final Speaker[] speakers;

    public SpeakerAdapter(Context context, Speaker[] speakers) {
        this.context = context;
        this.speakers = speakers;
    }

    @Override
    public int getCount() {
        return speakers.length;
    }

    @Override
    public Object getItem(int position) {
        return speakers[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public View getView(int position, View convertView, @NotNull ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View speakerListView = inflater.inflate(R.layout.speakers_list_view, parent, false);


        final TextView textView = (TextView) speakerListView.findViewById(R.id.speaker_name);
        textView.setText(speakers[position].getName());

        final ImageView imageView = (ImageView) speakerListView.findViewById(R.id.speaker_photo);
        imageView.setImageResource(R.drawable.ic_contact_picture);

        return speakerListView;
    }
}