/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author LENOVO
 */
public class Penumpang {
    private String name;
    private String nik;

    public Penumpang(String name, String nik) {
        this.name = name;
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public String getNIK() {
        return nik;
    }

    public void printInfo() {
        System.out.println("Penumpang | Nama: " + name + ", NIK: " + nik);
    }
}
