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
        (new Jadwal("08:00","12:00")),
        (new Jadwal("22:00","06:00")),
        (new Jadwal("13:00","17:00")),
        (new Jadwal("18:00","23:00")),
        (new Jadwal("10:00","17:30")),
        (new Jadwal("09:00","14:00"))
    };
    static Stasiun[] listStasiun = {
        (new Stasiun("Kiaracondong","Bandung")),
        (new Stasiun("Malang","Malang")),
        (new Stasiun("Jember","Jember")),
        (new Stasiun("Balapan","Solo")),
        (new Stasiun("Pasarsenen","Jakarta")),
    };
    static Kereta[] listKereta = {
        (new Kereta("Mutiara_Selatan",200000,300000,400000,listStasiun[1],listStasiun[0],listJadwal[0])),
        (new Kereta("Malabar",300000,400000,500000,listStasiun[1],listStasiun[0],listJadwal[1])),
        (new Kereta("Tawang_Alun",40000,50000,60000,listStasiun[2],listStasiun[1],listJadwal[2])),
        (new Kereta("Lodaya",160000,210000,240000,listStasiun[0],listStasiun[3],listJadwal[3])),
        (new Kereta("Turangga",620000,680000,720000,listStasiun[4],listStasiun[0],listJadwal[7])),
        (new Kereta("Pasundan",80000,120000,160000,listStasiun[0],listStasiun[3],listJadwal[0])),
        (new Kereta("Serayu",60000,80000,100000,listStasiun[0],listStasiun[4],listJadwal[5])),
        (new Kereta("Pangandaran",150000,170000,190000,listStasiun[4],listStasiun[0],listJadwal[4])),
        (new Kereta("Brawijaya",460000,485000,500000,listStasiun[1],listStasiun[3],listJadwal[5])),
        (new Kereta("Matarmaja",170000,180000,190000,listStasiun[3],listStasiun[1],listJadwal[7]))
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
        (new Petugas("pet1@p.p","123","Prasetyo","Pramugara")),
        (new Petugas("pet2@p.p","123","Vi","Pramugari"))
      };
    
    public static Railfood[] listRailfood = {
        new Railfood("Pop Mie",10000),
        new Railfood("Air Mineral",4000)
    };
 
    public static void initializeTiket(){
        ((Pemesan)listUser[1]).initializeTiket(((Pemesan)listUser[1]).getPenumpang(0), "24/11/2024", listKereta[2], listKereta[2].getTipeKelas("Eksekutif"));
        ((Pemesan)listUser[1]).initializeTiket(((Pemesan)listUser[1]).getPenumpang(1), "1/12/2024", listKereta[1], listKereta[1].getTipeKelas("Bisnis"), listRailfood[0]);
        ((Pemesan)listUser[0]).initializeTiket(((Pemesan)listUser[0]).getPenumpang(1), "1/12/2024", listKereta[1], listKereta[1].getTipeKelas("Bisnis"), listRailfood[1]);
        ((Pemesan)listUser[2]).initializeTiket(((Pemesan)listUser[2]).getPenumpang(0), "1/12/2024", listKereta[0], listKereta[0].getTipeKelas("Ekonomi"), listRailfood[0]);
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
        ArrayList<Integer> idxPetugas = new ArrayList<>();
        for (int i=0; i<listUser.length; i++){
            if(listUser[i] instanceof Petugas){
                idxPetugas.add(i);
            }
        }
        int rnd = new Random().nextInt(idxPetugas.size());
        int idx = idxPetugas.get(rnd);
        return (Petugas) listUser[idx];
    }
    
    public static KursiPenumpang assignKursiPenumpang(KursiPenumpang[] listKursi){
        int rnd = new Random().nextInt(listKursi.length);
        while (!listKursi[rnd].checkStatus()){
            rnd = new Random().nextInt(listKursi.length);
        }
        return listKursi[rnd];
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
    
    public static Pengguna findUser(String email, String password) {
        int i = 0;
        Pengguna found = null;
        while (found == null && i < listUser.length) {
            if (listUser[i].logIn(email, password)) {  
                found = listUser[i];
                return found;
            }
            i++;
        }
        return null;
    }
    
    public static int menuPetugas() {
        Scanner in = new Scanner(System.in);
        int pilih= -1;
        boolean isValid = false;
        
        while(!isValid){
            try {
                System.out.println("====== Menu Petugas ======");
                System.out.println("1. Lihat Pesanan Railfood");
                System.out.println("2. Log-out");
                System.out.print("\nPilih: ");
                pilih = in.nextInt();
                isValid = true;
            } catch(Exception e) {
                System.out.println("Input tidak valid. Silakan masukkan angka yang tersedia");
                in.nextLine();
            }
        }
        
        
        return pilih;
    }
    
    public static int menuPemesan(){
        Scanner in = new Scanner(System.in);
        int pilih= -1;
        boolean isValid = false;
        
        while(!isValid){
            try {
                System.out.println("----- Menu Pemesan -----");
                System.out.println("1. Pesan Tiket");
                System.out.println("2. Lihat Tiket yang Dipesan");
                System.out.println("3. Resechedule Ticket");
                System.out.println("4. Cancel Ticket");
                System.out.println("5. Lihat Data Penumpang");
                System.out.println("6. Cek Saldo");
                System.out.println("7. Logout");
                System.out.print("\nPilih: ");
                pilih = in.nextInt();
                isValid = true;
            } catch(Exception e) {
                System.out.println("Input tidak valid. Silakan masukkan angka yang tersedia");
                in.nextLine();
            }
        }
        
        
        return pilih;
    }   
}
