package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Speaker;

public class SpeakerFragment extends Fragment {

    private TextView speakerName;
    private TextView speakerDescription;

    private ImageView speakerPhoto;

    private final Speaker speaker;

    public SpeakerFragment(Speaker speaker) {
        this.speaker = speaker;
    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.speaker, container, false);
        if (rootView != null) {
            this.speakerName = (TextView) rootView.findViewById(R.id.speaker_name);
            this.speakerName.setText(speaker.getName());

            this.speakerDescription = (TextView) rootView.findViewById(R.id.speaker_description);
            this.speakerDescription.setText(speaker.getDescription());
        }
        return rootView;
    }
}
