package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Step1Fragment extends Fragment {

    private TextView textView;
    private OnNextStep1Listener listener;

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // TODO cast context to listener
        listener = (OnNextStep1Listener) context;
    }*/

    // TODO Override onCreateViewMethod
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_step1, container, false);
    }

    public interface OnNextStep1Listener {
        // TODO add onNext() method
        void onNext();
    }
}
