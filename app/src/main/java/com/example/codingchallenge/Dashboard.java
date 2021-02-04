package com.example.codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cotter.app.IdentityManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Dashboard extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Handles response from Cotter's login
        String resp = IdentityManager.handleResponse(getIntent());
        if (resp != null) {
            Log.i("Login Response: ", resp);
            JsonElement jElement = new JsonParser().parse(resp);
            JsonObject jsonObject = jElement.getAsJsonObject();
            jsonObject = jsonObject.getAsJsonObject("oauth_token");

            // Get the user access token and store in Shared Preferences
            String accessToken = jsonObject.get("access_token").getAsString();

            sp = getSharedPreferences("Token", Context.MODE_PRIVATE);
            sp.edit().putString("Access Token", accessToken);

            // Add code to validate whether token exists in backend below
        }

        // Handles error here
        String error = IdentityManager.handleError(getIntent());
        if (error != null) {
            Log.i("Login Error: ", error);
        }
    }

    // Allows user to return to homepage on click
    public void signOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}