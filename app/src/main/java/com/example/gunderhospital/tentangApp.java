package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tentangApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_app);
    }

    public void main(View view) {
        Intent intent = new Intent(tentangApp.this,MainActivity.class);
        startActivity(intent);
    }
}