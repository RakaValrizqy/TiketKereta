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
        this.status = "true";
    }

    public String getNomorKursi() {
        return nomorKursi;
    }
    
    public boolean checkStatus(){
        return this.status == "true";
    }
    
    public void bookKursi(){
        
    }
    
}
