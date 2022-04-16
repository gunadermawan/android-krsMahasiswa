package com.example.gunderhospital;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gunderhospital.paketku.AdapterDataku;
import com.example.gunderhospital.paketku.Dataku;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class data_4 extends AppCompatActivity {
    FloatingActionButton tblData;
    RecyclerView recyclerView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //         path utk nentuin nama db di firebase
    DatabaseReference myRef = database.getReference("Matkul");
    List<Dataku> list = new ArrayList<>();
    AdapterDataku adapterDataku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_4);
        //    start here
        tblData = findViewById(R.id.tbl_data);
        recyclerView = findViewById(R.id.reseikel_viu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tblData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogTambahData();
            }
        });
        bacaData();
    }


    private void bacaData() {
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Dataku value = snapshot.getValue(Dataku.class);
                    list.add(value);
                }
                adapterDataku = new AdapterDataku(data_4.this,list);
                recyclerView.setAdapter(adapterDataku);

                setClick();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }


    private void setClick() {
        adapterDataku.setOnCallBack(new AdapterDataku.OnCallBack() {
            @Override
            public void onTblHapus(Dataku dataku) {
                hapusData(dataku);
            }

            @Override
            public void onTblEdit(Dataku dataku) {
                showDialogEditData(dataku);
            }
        });
    }

    private void showDialogEditData(final Dataku dataku) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        start pemanggialn layout
        dialog.setContentView(R.layout.tambah_data_leot);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//         start biar kalo tombol di klik yg kedua kali,layout yg dipanggil akan menutup
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow().getAttributes()));
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
//         start biar tmobol keluar bsa ditekan
        ImageButton tblKeluar = dialog.findViewById(R.id.tbl_keluar);
        tblKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        final EditText txtTambah1 = dialog.findViewById(R.id.txt_tambah_1);

        txtTambah1.setText(dataku.getNama());
        final Button tblTambah = dialog.findViewById(R.id.tbl_tambah);
//         start jika tblTambah diklik
        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtTambah1.getText())){
                    tblTambah.setError("silahkan lengkapi data !");
                } else {
                    editData(dataku,txtTambah1.getText().toString());
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private void editData(Dataku dataku, String s) {
        myRef.child(dataku.getKunci()).child("nama").setValue(s).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "diupdate!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hapusData(final Dataku dataku) {
        myRef.child(dataku.getKunci()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(getApplicationContext(),dataku.getNama()+ "telah dihapus", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialogTambahData() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        start pemanggialn layout
        dialog.setContentView(R.layout.tambah_data_leot);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//         start biar kalo tombol di klik yg kedua kali,layout yg dipanggil akan menutup
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow().getAttributes()));
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
//         start biar tmobol keluar bsa ditekan
        ImageButton tblKeluar = dialog.findViewById(R.id.tbl_keluar);
        tblKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        final EditText txtTambah1 = dialog.findViewById(R.id.txt_tambah_1);


        final Button tblTambah = dialog.findViewById(R.id.tbl_tambah);
//         start jika tblTambah diklik
        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtTambah1.getText())){
                    tblTambah.setError("silahkan lengkapi data !");
                } else {
                    simpanData1(txtTambah1.getText().toString());
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }


    private void simpanData1(String s) {

        String kunci = myRef.push().getKey();
        Dataku dataku = new Dataku(kunci,s,s,s,s,s);
        myRef.child(kunci).setValue(dataku).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "sip!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}