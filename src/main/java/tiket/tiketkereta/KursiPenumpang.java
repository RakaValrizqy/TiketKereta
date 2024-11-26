/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author Lenovo
 */
public class KursiPenumpang {
    private String nomorKursi;
    private String status;

    public KursiPenumpang(String nomorKursi) {
        this.nomorKursi = nomorKursi;
        this.status = "Tersedia";
    }

    public String getNomorKursi() {
        return nomorKursi;
    }
    
    public boolean checkStatus(){
        return this.status == "Tersedia";
    }
    
    public void bookKursi(){
        if (checkStatus()) {
            this.status = "Tersedia";
            System.out.println("Kursi dengan nomor " + nomorKursi + " berhasil dipesan.");
        } else {
            System.out.println("Maaf, kursi dengan nomor " + nomorKursi + " sudah terjual.");
        }
    }
    
}
