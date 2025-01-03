/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

import java.util.Random;

/**
 *
 * @author RVA
 */
public class Tiket {
    private String kodeTiket;
    private Penumpang penumpang;
    private String tanggal;
    private Kereta kereta;
    private TipeKelas tipe;
    private KursiPenumpang kursi;
    private int harga_railfood;
    private int harga_tiket;
    private Railfood railfood;
    private Petugas petugas;
    private String status;

    public Tiket(Penumpang penumpang, String tanggal, Kereta kereta, TipeKelas tipe) {
        this.kodeTiket = Utility.generateKode();
        this.penumpang = penumpang;
        this.tanggal = tanggal;
        this.kereta = kereta;
        this.tipe = tipe;
        this.kursi = Utility.assignKursiPenumpang(tipe.getListKursi());
        this.status = "Booked";
    }

    public Tiket(Penumpang penumpang, String tanggal, Kereta kereta, TipeKelas tipe, Railfood railfood) {
        this.kodeTiket = Utility.generateKode();
        this.penumpang = penumpang;
        this.tanggal = tanggal;
        this.kereta = kereta;
        this.tipe = tipe;
        this.kursi = Utility.assignKursiPenumpang(tipe.getListKursi());
        this.railfood = railfood;
        this.petugas = Utility.assignPetugas();
        this.status = "Booked";
    }

    public void cancelTiket(){
        this.status = "Canceled";
    }
    
    public void rescheduleTiket(String tgl){
        this.tanggal = tgl;
    }
    
    public boolean isKodeAvailable(String kode){
        boolean status = true;
        if (kode.equals(kodeTiket)) {
            status = false;
        }
        return status;
    }

    public String getKodeTiket() {
        return kodeTiket;
    }


    public Petugas getPetugas() {
        return petugas;
    }

    public String getStatus() {
        return status;
    }
    
    
    public void printInfo(){
        System.out.println("Kode Tiket\t\t: " + kodeTiket);
        System.out.println("Penumpang\t\t: " + penumpang.getName()+", "+penumpang.getNIK());
        System.out.println("Tanggal keberangkatan\t: " + tanggal);
        System.out.println("Kereta\t\t\t: " + kereta.getNama());
        System.out.println("Nomor kursi\t\t: " + tipe.getNamaTipe()+", "+kursi.getNomorKursi());
        if (railfood != null) {
            System.out.println("Railfood\t\t: " + railfood.getNama());
            System.out.println("Petugas\t\t\t: " + petugas.getNama_petugas());
            System.out.println("Harga Tiket      : Rp "+tipe.getHarga());
            System.out.println("Harga Railfood   : Rp "+railfood.getHarga());
            System.out.println("Pajak            : Rp "+(railfood.hitungPajak()+tipe.hitungPajak()));
            System.out.println("Total            : Rp "+(tipe.getHarga()+railfood.getHarga()+railfood.hitungPajak()+tipe.hitungPajak()));
        } else {
            System.out.println("Harga Tiket      : Rp "+tipe.getHarga());
            System.out.println("Pajak            : Rp "+(tipe.hitungPajak()));
            System.out.println("Total            : Rp "+(tipe.getHarga()+tipe.hitungPajak()));
        }
    }
}
