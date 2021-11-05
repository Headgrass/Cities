package ru.geekbrains.cities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.cities.R;

public class MainActivity extends AppCompatActivity {

    private static final String FRAGMENT_TAG = "CitiesFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new CitiesFragment()).commit();

        CitiesFragment citiesFragment = (CitiesFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (citiesFragment == null) {
            citiesFragment = new CitiesFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, citiesFragment, FRAGMENT_TAG).commit();
    }

    // Переопределяем кнопку назад. При нажатии, выталкивает фрагмент, находящийся на активити
    // из BackStack, вместо закрытия приложения
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getFragments().size() > 0) {
            getSupportFragmentManager().popBackStack();
        } else
            super.onBackPressed();
    }
}