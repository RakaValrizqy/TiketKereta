/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

import java.util.HashMap;

/**
 *
 * @author RVA
 */
public class Kereta {
    private String nama;
    private Stasiun stasiunB;
    private Stasiun stasiunT;
    private Jadwal jadwal;
    private HashMap<String,TipeKelas> tipe = new HashMap<>();

    public Kereta(String nama, int eko, int bis, int eks,Stasiun sB, Stasiun sT, Jadwal jadwal) {
        this.nama = nama;
        tipe.put("Ekonomi", new TipeKelas("Ekonomi",eko));
        tipe.put("Bisnis", new TipeKelas("Bisnis",bis));
        tipe.put("Eksekutif", new TipeKelas("Eksekutif",eks));
        this.stasiunB = sB;
        this.stasiunT = sT;
        this.jadwal = jadwal;
    }

    public void show(){
        System.out.println(nama+" Rp "+tipe.get("Ekonomi").getHarga()+" - Rp "+tipe.get("Eksekutif").getHarga());
        System.out.println(stasiunB.toString()+" -> "+stasiunT.toString());
        System.out.println(jadwal.getWaktuBerangkat()+"\t\t\t  "+jadwal.getWaktuTiba());
        System.out.println("");
    }
    
    public boolean isOnRoute(String keberangkatan, String tujuan){
        return (keberangkatan.equalsIgnoreCase(stasiunB.getKota()) && tujuan.equalsIgnoreCase(stasiunT.getKota()));
    }

    public String getNama() {
        return nama;
    }
    
    public TipeKelas getTipeKelas(String key){
        return tipe.get(key);
    }
    
    public void showAllTipe(){
        System.out.println(1+". Kelas "+tipe.get("Ekonomi").getNamaTipe()+" Rp "+tipe.get("Ekonomi").getHarga());
        System.out.println(2+". Kelas "+tipe.get("Bisnis").getNamaTipe()+" Rp "+tipe.get("Bisnis").getHarga());
        System.out.println(3+". Kelas "+tipe.get("Eksekutif").getNamaTipe()+" Rp "+tipe.get("Eksekutif").getHarga());
    }
    
}
