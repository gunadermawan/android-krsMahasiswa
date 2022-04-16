package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class menu_input extends AppCompatActivity {
    databaseHelper bd;
    ListView listView;
    EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;

    ArrayList<String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_input);
        listView = findViewById(R.id.listObat);
        editText = findViewById(R.id.input2);
        tblTambah = findViewById(R.id.tblSubmit);
        bd = new databaseHelper(this);
        listviewku = new ArrayList<>();

        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.tambahData(editText.getText().toString());
                Toast.makeText(menu_input.this, "Data berhasil ditambahkan!", Toast.LENGTH_SHORT).show();
            }
        });
    }





}