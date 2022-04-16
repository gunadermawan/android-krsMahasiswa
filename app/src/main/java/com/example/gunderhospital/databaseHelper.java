package com.example.gunderhospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {
    private static final  String DATABASE_OBAT = "db_obat";
    private static final  String TABEL_OBAT = "tabel_obat";
    private static final  String KODE = "kode";
    private static final  String NAMA = "nama";
    private static final  String SATUAN = "satuan";
    private static final  String JUMLAH = "jumlah";
    private static final  String HARGA = "harga";
    private static final  String EXPIRED = "expired";

    public databaseHelper (@Nullable Context context) {
        super(context, DATABASE_OBAT, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String nama_tabel = "create table "+TABEL_OBAT+ "(" + KODE + " integer primary key autoincrement," + NAMA + " text)";
        db.execSQL(nama_tabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean tambahData (String nama){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA,nama);

        long hasil = db.insert(TABEL_OBAT,null,contentValues);
        return hasil != -1;
    }

    public Cursor tampilObat() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from "+TABEL_OBAT;
        Cursor cursor = db.rawQuery(sql,null);
        return  cursor;
    }
    public boolean updateData (String nama,String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA,nama);
        db.update(TABEL_OBAT,contentValues, "kode = ?",new String[] {id});
        return true;
    }
}
