package com.example.codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cotter.app.Cotter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cotter.init(this.getApplicationContext(),
                "https://www.cotter.app/api/v0",
                "45d59d89-6129-47f1-8bbd-6e0d9725928e");
    }

    // Retrieves Cotter's email login form through WebView
    public void register(View view) {
        Cotter.newIdentity(this, "com.example.codingchallenge://auth_callback").login("EMAIL",
                this, Dashboard.class);
    }

}