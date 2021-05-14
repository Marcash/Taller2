package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ValidationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
    }

    public void MainView(View view) {
        Intent mainview = new Intent(this, MainActivity.class);
        startActivity(mainview);
    }
}