package com.example.gunderhospital.paketku;

public class Dataku {
    String kunci;
    String nama;
    String id;
    String gender;
    String lulusan;
    String waktuKerja;

    public Dataku(){

    }
    public Dataku(String kunci, String nama, String id, String gender, String lulusan, String waktuKerja) {
        this.kunci = kunci;
        this.nama = nama;
        this.id = id;
        this.gender = gender;
        this.lulusan = lulusan;
        this.waktuKerja = waktuKerja;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLulusan() {
        return lulusan;
    }

    public void setLulusan(String lulusan) {
        this.lulusan = lulusan;
    }

    public String getWaktuKerja() {
        return waktuKerja;
    }

    public void setWaktuKerja(String waktuKerja) {
        this.waktuKerja = waktuKerja;
    }
}
