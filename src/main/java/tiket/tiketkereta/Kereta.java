/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author RVA
 */
public class Kereta {
    private String nama;
    private Stasiun stasiunB;
    private Stasiun stasiunT;
    private Jadwal jadwal;
    private TipeKelas[] tipe = new TipeKelas[3];

    public Kereta(String nama, int eko, int bis, int eks,Stasiun sB, Stasiun sT, Jadwal jadwal) {
        this.nama = nama;
        this.tipe = new TipeKelas[] {
            (new TipeKelas("Ekonomi",eko)),
            (new TipeKelas("Bisnis",bis)),
            (new TipeKelas("Eksekutif",eks))
        };
        this.stasiunB = sB;
        this.stasiunT = sT;
        this.jadwal = jadwal;
    }

    public void show(){
        System.out.println(nama+" Rp "+tipe[0].getHarga()+" - Rp "+tipe[2].getHarga());
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
    
}
