/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author bagas
 */
public class Petugas extends Pengguna {
    private String nama_petugas;
    private String posisi;

    public Petugas(String email, String password, String nama_petugas, String posisi) {
        super(email, password);
        this.nama_petugas = nama_petugas;
        this.posisi = posisi;
    }

    public void setNama_petugas(String nama_petugas) {
        this.nama_petugas = nama_petugas;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getPosisi() {
        return posisi;
    }

    @Override
    public String toString() {
        return "Nama Petugas : " + nama_petugas + ", Posisi : " + posisi;
    }
    
    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
