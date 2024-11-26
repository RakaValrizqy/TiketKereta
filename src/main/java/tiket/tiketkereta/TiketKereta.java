/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tiket.tiketkereta;

import java.util.Scanner;

/**
 *
 * @author RVA
 */
public class TiketKereta {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // logIn() Pengguna
        Pengguna currentUser=null;
        int pilihLogin=0;
        String email,password;
        
        
        while (currentUser==null && pilihLogin != 3){
            System.out.println("-----------------------------MENU LOGIN---------------------------------");
            System.out.println("1. Login sebagai pemesan");
            System.out.println("2. Login sebagai petugas");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihLogin = in.nextInt();
            switch (pilihLogin) {
                case 1:
                    System.out.print("Masukkan email: ");
                    email = in.next();
                    System.out.print("Masukkan password: ");
                    password = in.next();
                    currentUser = (Pemesan) Utility.findPemesan(email, password);
                    if (currentUser==null) {
                        System.out.println("Akun tidak ditemukan");
                    } else {
                        System.out.println("Selamat datang "+currentUser.getEmail());
                    }
            }
        }
    }
}
