package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.model.Session;

public class SessionFragment extends Fragment {

    private Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        session = getArguments().getParcelable("session");
        getActivity().setTitle("Session details");
        return view;
    }
}
