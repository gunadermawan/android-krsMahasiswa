package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    EditText Input1,Input2,Input3,Input4,Input5,Input6;
    private String nama,noid;
    Button tblupdate;
    databaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        db = new databaseHelper(this);

        Input1 = findViewById(R.id.input1);
        Input2 = findViewById(R.id.input2);
        Input3 = findViewById(R.id.input3);
        Input4 = findViewById(R.id.input4);
        Input5 = findViewById(R.id.input5);
        Input6 = findViewById(R.id.input6);

        Bundle extras = getIntent().getExtras();
        Input1.setText(extras.getString("data1"));
        Input2.setText(extras.getString("data2"));

        tblupdate = (Button)findViewById(R.id.tblUpdate);
        tblupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                start debuging update
                Input5.setText(Input1.getText().toString());
                Input6.setText(Input2.getText().toString());

                boolean haselE = db.updateData(Input2.getText().toString(),Input1.getText().toString());
                if (haselE) {
                    Toast.makeText(update.this, "Update Berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(update.this, "Update Gagal !", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}