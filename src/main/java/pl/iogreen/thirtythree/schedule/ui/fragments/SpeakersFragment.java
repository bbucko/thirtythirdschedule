package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;

public class SpeakersFragment extends Fragment {

    private ListView speakersList;
    private String[] speakers = {"John Rambo", "John McClane"};

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.speakers, container, false);

        this.speakersList = (ListView) rootView.findViewById(R.id.speakers);
        this.speakersList.setAdapter(new SpeakerAdapter(rootView.getContext(), speakers));

        getActivity().setTitle("Speakers");
        return rootView;
    }

    private static class SpeakerAdapter extends BaseAdapter {
        private final Context context;
        private final String[] speakers;

        public SpeakerAdapter(Context context, String[] speakers) {
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
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.speaker, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.speaker_name);
            textView.setText(speakers[position]);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.speaker_photo);
            return rowView;
        }
    }
}
