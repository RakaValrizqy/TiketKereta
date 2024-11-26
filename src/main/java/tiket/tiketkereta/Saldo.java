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
        int tempBalance = getJumlahSaldo();
        if (jumlah > 0) {
            if (getJumlahSaldo() >= 0) {
                tempBalance -= jumlah;
                if (tempBalance < 0) {
                    System.out.println("Saldo anda tidak cukup, silahkan Top Up terlebih dahulu");   
                } else {
                    this.jumlahSaldo -= jumlah;
                    System.out.println("===== Pembayaran berhasil =====");
                    System.out.printf("Pembayaran sebesar : Rp %d,00\n", jumlah);
                    System.out.printf("Sisa saldo : Rp %d,00\n", getJumlahSaldo());
                    System.out.println("===============================");
                }
            }
        } else {
            System.out.println("Nominal bayar tidak boleh nol atau kurang dari nol.");
        }
    }

    public void printInfo() {
        System.out.println("Jumlah Saldo : " + getJumlahSaldo());
        System.out.println();
    }
    
}
