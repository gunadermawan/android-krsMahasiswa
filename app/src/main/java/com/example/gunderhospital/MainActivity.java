package com.example.gunderhospital;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private Button btnAllert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAllert = (Button) findViewById(R.id.btn_alert);
        btnAllert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new  AlertDialog.Builder(this);
//        set title dialog
        alertDialogBuilder.setTitle("Keluar dari aplikasi ?");
//        set massage dialog
        alertDialogBuilder
                .setMessage("Selalu gunakan masker dan jaga jarak untuk adaptasi kebiasaan baru :)")
                .setIcon(R.mipmap.ic_launcher_round)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
//        membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();
//        menampilkan alert
        alertDialog.show();
    }

    public void bukaInfo(View view) {
        Intent intent = new Intent(MainActivity.this,tentangApp.class);
        startActivity(intent);
    }

    public void bukaMaps(View view) {
        Intent intent = new Intent(MainActivity.this,maps.class);
        startActivity(intent);
    }

    public void bukaMatkul(View view) {
        Intent intent = new Intent(MainActivity.this,data_4.class);
        startActivity(intent);
    }

    public void bukaNilai(View view) {
        Intent intent = new Intent(MainActivity.this, data_3.class);
        startActivity(intent);
    }

    public void bukaAllert(View view) {
        Toast.makeText(this, "Belum ada pembaruan sampai saat ini", Toast.LENGTH_SHORT).show();
    }

    public void bukaSks(View view) {
        Intent intent = new Intent(MainActivity.this, data_2.class);
        startActivity(intent);
    }

    public void bukaIpk(View view) {
        Intent intent = new Intent(MainActivity.this,data.class);
        startActivity(intent);
    }
}