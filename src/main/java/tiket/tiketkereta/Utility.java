/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author RVA
 */
public class Utility {
    static Jadwal[] listJadwal = {
        (new Jadwal("18:00","06:00")),
        (new Jadwal("16:00","04:00")),
        (new Jadwal("08:00","12:00"))
    };
    static Stasiun[] listStasiun = {
        (new Stasiun("Kiaracondong","Bandung")),
        (new Stasiun("Malang","Malang")),
        (new Stasiun("Jember","Jember")),
    };
    static Kereta[] listKereta = {
        (new Kereta("Mutiara_Selatan",200000,300000,400000,listStasiun[1],listStasiun[0],listJadwal[0])),
        (new Kereta("Malabar",300000,400000,500000,listStasiun[1],listStasiun[0],listJadwal[1])),
        (new Kereta("Tawang_Alun",40000,50000,60000,listStasiun[2],listStasiun[1],listJadwal[2]))
    };
    
    static Pengguna[] listUser = {
        (new Pemesan("abc@gmail.com", "123", 1000000, 
            new Penumpang[] {
                (new Penumpang("Lima", "19112024")),
                (new Penumpang("Dina", "11111111")),
            })),
        (new Pemesan("def@gmail.com", "456", 100000, 
            new Penumpang[] {
                (new Penumpang("Bagas", "22222222")),
                (new Penumpang("Duhan", "33333333")),
            })),
        (new Pemesan("ghi@gmail.com", "456", 1000000, 
            new Penumpang[] {
                (new Penumpang("Raka", "44444444")),
                (new Penumpang("Elzio", "55555555")),
            })),
      };
    
    public static Railfood[] listRailfood = {
        new Railfood("Pop Mie",10000),
        new Railfood("Air Mineral",4000)
    };
    
    
    public static Petugas[] listPetugas = {
        new Petugas("pet1@p.p","123","Prasetyo","Pramugara"),
        new Petugas("pet2@p.p","123","Vi","Pramugari"),
    };
    
    public static ArrayList<Tiket> listTiket = new ArrayList<>();
    
    static {
        listTiket.add(new Tiket(((Pemesan) listUser[1]).getPenumpang(0), ((Pemesan) listUser[1]), "24/11/2024", listKereta[2], listKereta[2].getTipeKelas(2)));
        listTiket.add(new Tiket(((Pemesan) listUser[1]).getPenumpang(1), ((Pemesan) listUser[1]), "1/12/2024", listKereta[1], listKereta[1].getTipeKelas(1), listRailfood[0]));
        listTiket.add(new Tiket(((Pemesan) listUser[0]).getPenumpang(1), ((Pemesan) listUser[0]), "1/12/2024", listKereta[1], listKereta[1].getTipeKelas(1), listRailfood[1]));
        listTiket.add(new Tiket(((Pemesan) listUser[2]).getPenumpang(0), ((Pemesan) listUser[2]), "1/12/2024", listKereta[0], listKereta[0].getTipeKelas(0), listRailfood[0]));
    } 
    
    
    public static String generateKode(){
        StringBuilder sb = new StringBuilder ();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random ();
        for (int i = 0; i < 5; i ++) {
            sb.append (candidateChars.charAt (random.nextInt (candidateChars.length ())));
        }

        return sb.toString();
    }
    
    public static Petugas assignPetugas(){
        int rnd = new Random().nextInt(listPetugas.length);
        return listPetugas[rnd];
    }
    
    public static KursiPenumpang assignKursiPenumpang(KursiPenumpang[] listKursi){
        int rnd = new Random().nextInt(listKursi.length);
        while (!listKursi[rnd].checkStatus()){
            rnd = new Random().nextInt(listKursi.length);
        }
        return listKursi[rnd];
    }

    public static void cekTiketPemesan(Pemesan pemesan){
        // pemesan mengecek info penumpang dan tiket apa saja yang telah dipesan
        System.out.println("Tiket yang telah dipesan oleh: " + pemesan.getEmail());
            for (Tiket tiket : listTiket) {
                if (tiket.getPemesan() == pemesan && tiket.getStatus().equals("Booked")) {
                    tiket.printInfo();
                    separator();
                }
        }
    }

    public static void cekTiketPetugas(Petugas petugas) {
        System.out.println("Tiket yang ditugaskan untuk petugas ini adalah: " + petugas.getNama_petugas());
        for (Tiket tiket : listTiket) {
            if (tiket.getPetugas() == petugas && tiket.getStatus().equals("Booked")) {
                tiket.printInfo();
                separator();
            }
        }
    }
    
    public static void separator(){
        System.out.println("------------------------------------------------------------------------");
    }
    
    public static boolean checkKeretaOnRoad(String asal, String tujuan){
        for (Kereta train:listKereta) {
            if (train.isOnRoute(asal, tujuan)) {
                return true;
            }
        }
        return false;
    }
    
    public static Kereta findKereta(String nama, String asal, String tujuan){
        for (Kereta train:listKereta){
            if (train.getNama().equalsIgnoreCase(nama)&&train.isOnRoute(asal, tujuan)) {
                return train;
            }
        }
        return null;
    }
    
    public static void showAllRailfood(){
        int i = 1;
        for (Railfood food:listRailfood) {
            System.out.println(i+". "+food.getNama()+" Rp "+food.getHarga());
            i++;
        }
    }
    
    public static Pengguna findPemesan(String email, String password){
        int i=0;
        Pengguna foundUser = null;
        while (foundUser == null && i < Utility.listUser.length) {
            if (Utility.listUser[i].logIn(email, password)) {
                foundUser = Utility.listUser[i];
                return foundUser;
            }
            i++;
        }
        return null;
    }
    
    public static Petugas findPetugas(String email, String password) {
        int i = 0;
        Petugas found = null;
        while (found == null && i < listPetugas.length) {
            if (listPetugas[i].logIn(email, password)) {
                found = listPetugas[i];
                return found;
            }
            i++;
        }
        return null;
    }
    
    public static int menuPetugas() {
        Scanner in = new Scanner(System.in);
        System.out.println("====== Menu Petugas ======");
        System.out.println("1. Lihat Pesanan Railfood");
        System.out.println("2. Log-out");
        System.out.print("\nPilih: ");
        int pilih = in.nextInt();
        return pilih;
    }
    
    public static int menuPemesan(){
        Scanner in = new Scanner(System.in);
        System.out.println("----- Menu Pemesan -----");
        System.out.println("1. Pesan Tiket");
        System.out.println("2. Lihat Tiket yang Dipesan");
        System.out.println("3. Resechedule Ticket");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. Lihat Data Penumpang");
        System.out.println("6. Cek Saldo");
        System.out.println("7. Logout");
        System.out.print("\nPilih: ");
        int pilih = in.nextInt();
        return pilih;
    }
}
