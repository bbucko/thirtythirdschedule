package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Speaker;

public class SpeakersFragment extends Fragment {

    private ListView speakersList;
    private Speaker[] speakers = {new Speaker("John Rambo"), new Speaker("John McClane")};

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.speakers_fragment, container, false);

        if (rootView != null) {
            this.speakersList = (ListView) rootView.findViewById(R.id.speakers);
            this.speakersList.setAdapter(new SpeakerAdapter(rootView.getContext(), speakers));
            this.speakersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(@NotNull AdapterView<?> parent, View view, int position, long id) {
                    final Fragment fragment = new SpeakerFragment(speakers[position]);

                    final FragmentManager fragmentManager = getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.beginTransaction()
                                .replace(R.id.content_frame, fragment)
                                .commit();
                    }
                }
            });
        }

        final Activity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Speakers");
        }
        return rootView;
    }


    private static class DownloadSpeakerInfo extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            return null;
        }
    }

    private static class SpeakerAdapter extends BaseAdapter {
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

            if (speakerListView != null) {
                final TextView textView = (TextView) speakerListView.findViewById(R.id.speaker_name);
                textView.setText(speakers[position].getName());

                final ImageView imageView = (ImageView) speakerListView.findViewById(R.id.speaker_photo);
                imageView.setImageResource(R.drawable.ic_contact_picture);
            }
            return speakerListView;
        }
    }
}
