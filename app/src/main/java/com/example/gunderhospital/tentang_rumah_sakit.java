package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tentang_rumah_sakit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_rumah_sakit);
    }

    public void main(View view) {
        Intent intent = new Intent(tentang_rumah_sakit.this,MainActivity.class);
        startActivity(intent);
    }
}