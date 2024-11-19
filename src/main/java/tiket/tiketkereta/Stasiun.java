/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author bagas
 */
public class Stasiun {
    private String nama_stasiun;
    private String kota;

    public Stasiun(String nama_stasiun, String kota) {
        this.nama_stasiun = nama_stasiun;
        this.kota = kota;
    }

    public String getNama_stasiun() {
        return nama_stasiun;
    }

    public String getKota() {
        return kota;
    }
   
    @Override
    public String toString() {
        return "Stasiun " + nama_stasiun + ", " + kota;
    }
    
    public void printInfo() {
        System.out.println(toString());
    }
}
