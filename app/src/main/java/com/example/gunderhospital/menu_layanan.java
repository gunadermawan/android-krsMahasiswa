package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu_layanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_layanan);
    }

    public void main(View view) {
        Intent intent = new Intent(menu_layanan.this,MainActivity.class);
        startActivity(intent);
    }
}