package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.model.Session;
import pl.iogreen.thirtythree.schedule.model.Speaker;
import pl.iogreen.thirtythree.schedule.ui.adapters.SpeakerAdapter;

public class SpeakersFragment extends Fragment {

    private ListView speakersList;

    private Speaker[] speakers = {new Speaker("John Rambo", "Description", null, new Session[]{new Session(2, "Name", "Description", null)}), new Speaker("John McClane")};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.speakers_fragment, container, false);

        this.speakersList = (ListView) rootView.findViewById(R.id.speakers);
        this.speakersList.setAdapter(new SpeakerAdapter(rootView.getContext(), speakers));
        this.speakersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Bundle args = new Bundle();
                args.putParcelable("speaker", speakers[position]);

                final Fragment fragment = new SpeakerFragment();
                fragment.setArguments(args);

                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
            }
        });

        getActivity().setTitle("Speakers");
        return rootView;
    }
}
