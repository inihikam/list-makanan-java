package com.example.listkuliner;

public class Kuliner {

    private String nama, deskripsi, harga;
    private int id_gambar;

    public Kuliner(String nama, String deskripsi, String harga, int id_gambar) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.id_gambar = id_gambar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getId_gambar() {
        return id_gambar;
    }

    public void setId_gambar(int id_gambar) {
        this.id_gambar = id_gambar;
    }
}
