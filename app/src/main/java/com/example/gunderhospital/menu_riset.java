package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu_riset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_riset);
    }

    public void main(View view) {
        Intent intent = new Intent(menu_riset.this,MainActivity.class);
        startActivity(intent);
    }
}