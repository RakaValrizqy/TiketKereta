/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

import java.util.Scanner;

/**
 *
 * @author bagas
 */
public class Saldo {
    private int jumlahSaldo;

    public Saldo(int jumlahSaldo) {
        this.jumlahSaldo = jumlahSaldo;
    }
    

    public int getJumlahSaldo() {
        return jumlahSaldo;
    }

    public void topUp(int nominal) {
        this.jumlahSaldo += nominal;
    }
    
    public void bayar(int jumlah) {
        Scanner in = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid){
            try {
                if (getJumlahSaldo() < jumlah) {
                    boolean isAccess = false;
                    System.out.println();
                    while (!isAccess) {
                        Utility.separator();
                        System.out.println("Maaf saldo anda kurang, silahkan Top Up terlebih dahulu");
                        System.out.println();
                        System.out.printf("Saldo anda saat ini: Rp %d,00\n", getJumlahSaldo());
                        System.out.printf("Total kekurangan saldo: Rp %d,00\n", (getJumlahSaldo()-jumlah)*-1);
                        System.out.println();
                        System.out.print("Masukkan jumlah Top Up: ");
                        int nominal = in.nextInt();
                        topUp(nominal);
                        isValid = true;
                        System.out.println();
                        if (getJumlahSaldo() >= jumlah) {
                            isAccess = true;
                        }
                    }
                }
                if (getJumlahSaldo() >= jumlah) {
                    this.jumlahSaldo -= jumlah;
                    System.out.println("================== Pembayaran berhasil ==================");
                    System.out.printf("Pembayaran sebesar : Rp %d,00\n", jumlah);
                    System.out.printf("Sisa saldo : Rp %d,00\n", getJumlahSaldo());
                    Utility.separator();
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("Mohon hanya masukkan angka untuk nominal top up");
                in.nextLine();
            }
        }
        
        
    }
    
    public void printInfo() {
        System.out.println("Jumlah Saldo : " + getJumlahSaldo());
        System.out.println();
    }
    
}
