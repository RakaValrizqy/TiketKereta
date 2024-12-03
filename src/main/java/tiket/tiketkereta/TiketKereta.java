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
        Pemesan currentUser=null;
        int pilihLogin=0, pilihPetugas = 0, pilihPemesan = 0;
        String email,password;
        Saldo saldo = new Saldo(0);
        boolean isAccessMainMenu = true;
        Tiket selectedTiket=null;
        
        
        while (isAccessMainMenu){
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
                        System.out.println("Selamat datang "+currentUser.getEmail());
                        System.out.println();
                        boolean isAccess = true;
                        while (isAccess){
                            pilihPemesan = Utility.menuPemesan();
                            switch (pilihPemesan){
                                case 1:
                                    currentUser.bookTiket();
                                    break;
                                case 2:
                                    Utility.cekTiketPemesan(currentUser);
                                    break;
                                case 3:
                                    System.out.print("Input Kode Tiket: ");
                                    String kode = in.next();
                                    selectedTiket=Utility.findTiket(kode);
                                    if (selectedTiket!=null&&selectedTiket.getPemesan()==currentUser&&selectedTiket.getStatus().equals("Booked")) {
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
                                    selectedTiket=Utility.findTiket(kode);
                                    if (selectedTiket!=null&&selectedTiket.getPemesan()==currentUser&&selectedTiket.getStatus().equals("Booked")) {
                                        selectedTiket.cancelTiket();
                                        System.out.println("Tiket berhasil dibatalkan");
                                        
                                    } else {
                                        System.out.println("Kode tiket tidak ditemukan");
                                    }
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    System.out.println("Jumlah Saldo: " + saldo.getJumlahSaldo());
                                    System.out.print("Apakah anda mau top up saldo? ");
                                    String mau = in.next();
                                    if (mau.equals("iya")){
                                        System.out.print("Masukkan nominal top up: ");
                                        int jumlahTopup = in.nextInt();
                                            if (jumlahTopup > 0) {
                                                saldo.topUp(jumlahTopup);
                                                System.out.println("Anda berhasil top up, saldo anda sekarang: "+saldo.getJumlahSaldo());
                                            } else {
                                                System.out.println("Jumlah topup tidak boleh kurang dari 0.");
                                            }
                                        
                                    } else if (mau.equals("tidak")){
                                        break;
                                    }
                                    break;
                                case 7:
                                    System.out.println("Berhasil logout.");
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
