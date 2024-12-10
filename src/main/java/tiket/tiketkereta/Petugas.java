/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author bagas
 */
import java.util.ArrayList;
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

    public String getNama_petugas() {
        return nama_petugas;
    }
    
    public void cekTiketPetugas() {
        System.out.println("Tiket yang ditugaskan untuk petugas ini adalah: " + getNama_petugas());
        // Pemesan[] listUser = Utility.listUser;
        for (int i = 0; i < Utility.listUser.length; i++) {
            if (Utility.listUser[i] instanceof Pemesan) {
                Pemesan pemesan = ((Pemesan)Utility.listUser[i]);
                
                ArrayList<Tiket> listTiket = pemesan.getListTiket();
                for (Tiket tiket : listTiket) {
                    if (tiket.getPetugas() == this && tiket.getStatus().equals("Booked")) {
                        tiket.printInfo();
                        Utility.separator();
                    }
                }
            }
        }   
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
