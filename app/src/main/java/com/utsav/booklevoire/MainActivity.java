package com.utsav.booklevoire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.utsav.booklevoire.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }*/ //I commented this line as this is not required because of application running through nav_graph and is navigated from nav_host

    }
}