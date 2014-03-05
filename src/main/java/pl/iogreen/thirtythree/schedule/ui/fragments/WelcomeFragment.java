package pl.iogreen.thirtythree.schedule.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import pl.iogreen.thirtythree.schedule.R;

public class WelcomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.welcome, container, false);
        getActivity().setTitle(R.string.application_name);
        return rootView;
    }
}
