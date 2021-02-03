package com.example.codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cotter.app.IdentityManager;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Handles response from Cotter's login
        String resp = IdentityManager.handleResponse(getIntent());
        if (resp != null) {
            Log.i("Login Response: ", resp);
        }

        // Handles error here
        String error = IdentityManager.handleError(getIntent());
        if (error != null) {
            Log.i("Login Error: ", error);
        }
    }

    // Allows user to return to homepage on click
    public void signOut(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}