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
        Petugas petugas = null;
        Pengguna currentUser=null;
        int pilihLogin=0, pilihPetugas = 0;
        String email,password;
        boolean isAccessMainMenu = true;
        
        
        while (currentUser==null && isAccessMainMenu){
            System.out.println("-----------------------------MENU LOGIN---------------------------------");
            System.out.println("1. Login sebagai pemesan");
            System.out.println("2. Login sebagai petugas");
            System.out.println("3. Keluar");
            System.out.print("\nPilih: ");
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
                    break;
                case 2:
                    Utility.separator();
                    System.out.println("Login Petugas\n");
                    System.out.print("Masukkan email: ");
                    email = in.next();
                    System.out.print("Masukkan password: ");
                    password = in.next();
                    petugas = (Petugas) Utility.findPetugas(email, password);
                    if (petugas == null) {
                        System.out.println("Akun tidak ditemukan");
                    } else {
                        Utility.separator();
                        System.out.println("Selamat datang " + petugas.getNama_petugas() + "!");
                        System.out.println();
                        boolean isAccess = true;
                        while (isAccess) {
                            pilihPetugas = Utility.menuPetugas();
                            switch(pilihPetugas) {
                                case 1:
                                    System.out.println();
                                    Utility.separator();
                                    Utility.cekTiketPetugas(petugas);
                                    break;
                                case 2:
                                    System.out.println("Berhasil log-out");
                                    isAccess = false;
                                    break;
                                default:
                                    System.out.println("Input tidak valid, silahkan input kembali");
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terimakasih dan Sampai Jumpa");
                    isAccessMainMenu = false;
                    break;
                default:
                    System.out.println("Input tidak valid, silahkan input kembali");
                    break;
            }
        }
    }
}
