package fr.android.androidexercises;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Step2Fragment extends Fragment {

    private TextView textView;

    // TODO Override onCreateViewMethod
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step2, container, false);
        textView = (TextView) view.findViewById(R.id.step2TextView);
        textView.setText(R.string.text_step2);
        return view;
    }
}
