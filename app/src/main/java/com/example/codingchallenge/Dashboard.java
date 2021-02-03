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

        // Handle response here
        String resp = IdentityManager.handleResponse(getIntent());
        if (resp != null) {
            Log.i("Login Response: ", resp);
        }

        // Handle error here
        String error = IdentityManager.handleError(getIntent());
        if (error != null) {
            Log.i("Login Error: ", error);
        }
    }

    // Returns back to homepage
    public void signOut(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}