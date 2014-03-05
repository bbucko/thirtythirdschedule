package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Speaker;
import pl.iogreen.thirtythree.schedule.ui.adapters.SessionAdapter;

public class SpeakerFragment extends Fragment {

    private TextView speakerName;
    private TextView speakerDescription;

    private ListView sessions;

    private ImageView speakerPhoto;

    private Speaker speaker;

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.speaker, container, false);

        speaker = getArguments().getParcelable("speaker");
        System.out.println(getArguments().size());

        this.speakerName = (TextView) rootView.findViewById(R.id.speaker_name);
        this.speakerName.setText(speaker.getName());

        this.speakerDescription = (TextView) rootView.findViewById(R.id.speaker_description);
        this.speakerDescription.setText(speaker.getDescription());

        this.speakerPhoto = (ImageView) rootView.findViewById(R.id.speaker_photo);

        this.sessions = (ListView) rootView.findViewById(R.id.sessions);
        this.sessions.setAdapter(new SessionAdapter(speaker.getSessions(), container.getContext()));
        this.sessions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Bundle args = new Bundle();
                args.putParcelable("session", speaker.getSessions()[position]);

                final Fragment fragment = new SessionFragment();
                fragment.setArguments(args);

                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
            }
        });

        getActivity().setTitle("Speaker details");
        return rootView;
    }


}
