/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author Lenovo
 */
public class Jadwal {
    private String waktuBerangkat;
    private String waktuTiba;

    public Jadwal(String waktuBerangkat, String waktuTiba) {
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
    }

    public String getWaktuBerangkat() {
        return waktuBerangkat;
    }

    public String getWaktuTiba() {
        return waktuTiba;
    }   
}
