package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fr.android.androidexercises.Step1Fragment.OnNextStep1Listener;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        View fragment2 = findViewById(R.id.fragment2);

        boolean landscape = getResources().getBoolean(R.bool.landscape);
        if(landscape){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                    .addToBackStack(Step0Fragment.class.getSimpleName())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment2, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                    .addToBackStack(Step1Fragment.class.getSimpleName())
                    .commit();
            fragment2.setVisibility(View.VISIBLE);
        }
        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                    .addToBackStack(Step0Fragment.class.getSimpleName())
                    .commit();
            fragment2.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNext() {
        // TODO replace Step1Fragment in containerFrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();
    }

}
