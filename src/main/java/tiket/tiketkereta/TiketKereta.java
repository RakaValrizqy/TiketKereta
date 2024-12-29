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
        Pengguna foundUser = null;
        Petugas petugas = null;
        Pemesan currentUser=null;
        int pilihLogin=0, pilihPetugas = 0, pilihPemesan = 0;
        String email,password;
        Saldo saldo;
        boolean isAccessMainMenu = true;
        Tiket selectedTiket=null;
        Utility.initializeTiket();
           
        while (isAccessMainMenu){
            try {
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
                            Utility.separator();
                            System.out.print("Selamat datang ");
                            currentUser.printInfo();
                            System.out.println();
                            boolean isAccess = true;
                            while (isAccess){
                                pilihPemesan = Utility.menuPemesan();
                                switch (pilihPemesan){
                                    case 1:
                                        currentUser.bookTiket();
                                        break;
                                    case 2:
                                        currentUser.cekTiketPemesan();
                                        break;
                                    case 3:
                                        System.out.print("Input Kode Tiket: ");
                                        String kode = in.next();
                                        selectedTiket=currentUser.findTiket(kode);
                                        if (selectedTiket!=null&&selectedTiket.getStatus().equals("Booked")) {
                                            System.out.print("Input tanggal keberangkatan baru: ");
                                            String tgl = in.next();
                                            selectedTiket.rescheduleTiket(tgl);
                                            System.out.println("Tiket berhasil diubah jadwal");
                                        } else {
                                            System.out.println("Kode tiket tidak ditemukan");
                                        }
                                        break;
                                    case 4:
                                        System.out.print("Input Kode Tiket: ");
                                        kode = in.next();
                                        selectedTiket=currentUser.findTiket(kode);
                                        if (selectedTiket!=null&&selectedTiket.getStatus().equals("Booked")) {
                                            selectedTiket.cancelTiket();
                                            System.out.println("Tiket berhasil dibatalkan");

                                        } else {
                                            System.out.println("Kode tiket tidak ditemukan");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Daftar penumpang: ");
                                        currentUser.showAllPenumpang();
                                        break;
                                    case 6:
                                        saldo = currentUser.getSaldo();
                                        System.out.println("Jumlah Saldo: " + saldo.getJumlahSaldo());
                                        System.out.print("Apakah anda mau top up saldo? (y/n): ");
                                        String mau = in.next();
                                        if (mau.equals("y")){
                                            System.out.print("Masukkan nominal top up: ");
                                            int jumlahTopup = in.nextInt();
                                                if (jumlahTopup > 0) {
                                                    saldo.topUp(jumlahTopup);
                                                    System.out.println("Anda berhasil top up, saldo anda sekarang: "+saldo.getJumlahSaldo());
                                                } else {
                                                    System.out.println("Jumlah topup tidak boleh kurang dari 0.\n");
                                                }

                                        } else if (mau.equals("n")){
                                            System.out.println("Terimakasih.\n");
                                            break;
                                        }
                                        break;
                                    case 7:
                                        System.out.println("Berhasil logout.");
                                        currentUser = (Pemesan) currentUser.logOut();
                                        isAccess = false;
                                        break;
                                    default:
                                        System.out.println("Input tidak valid, silahkan input kembali");
                                        break;
                                }
                            }
                        }
                        break;
                    case 2:

                        try {

                        Utility.separator();
                        System.out.println("Login Petugas\n");
                        System.out.print("Masukkan email: ");
                        email = in.next();
                        System.out.print("Masukkan password: ");

                        password = in.next();

                            foundUser = Utility.findUser(email, password);
                            if (foundUser == null){
                                throw new Exception();
                            }

                            if (foundUser != null) {
    //                        System.out.println("Akun tidak ditemukan");
                                if (foundUser instanceof Petugas){
                                    petugas = (Petugas) Utility.findUser(email, password);
                                    Utility.separator();
                                    System.out.print("Selamat datang ");
                                    petugas.printInfo();
                                    System.out.println();
                                    boolean isAccess = true;
                                    while (isAccess) {
                                        pilihPetugas = Utility.menuPetugas();
                                        switch(pilihPetugas) {
                                            case 1:
                                                System.out.println();
                                                Utility.separator();
                                                petugas.cekTiketPetugas();
                                                break;
                                            case 2:
                                                System.out.println("Berhasil log-out");
                                                isAccess = false;
                                                petugas = (Petugas) petugas.logOut();
                                                break;
                                            default:
                                                System.out.println("Input tidak valid, silahkan input kembali");
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("Maaf, akun pemesan tidak dapat login sebagai petugas");
                                }  
                        }


                        } catch (Exception e) {
                            System.out.println("Akun tidak ditemukan atau password salah");
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
            } catch (Exception e){
                System.out.println("Input tidak valid. Silakan masukkan angka yang tersedia");
                in.nextLine();
            }
            
        }
    }
}
