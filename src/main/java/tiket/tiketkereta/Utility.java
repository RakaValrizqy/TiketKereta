/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

import java.util.Random;

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
        (new Kereta("Mutiara Selatan",200000,300000,400000,listStasiun[1],listStasiun[0],listJadwal[0])),
        (new Kereta("Malabar",300000,400000,500000,listStasiun[1],listStasiun[0],listJadwal[1])),
        (new Kereta("Tawang Alun",40000,50000,60000,listStasiun[2],listStasiun[1],listJadwal[2]))
    };
    
    static Pengguna[] listUser = {
        (new Pemesan("abc@gmail.com", "123", 1000000, 
            new Penumpang[] {
                (new Penumpang("Lima", "19112024")),
                (new Penumpang("Dina", "11111111")),
            })),
        (new Pemesan("def@gmail.com", "456", 1000000, 
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
    
    static Tiket[] listTiket = {
            new Tiket(((Pemesan) listUser[1]).getPenumpang(0),((Pemesan) listUser[1]),"24/11/2024",listKereta[2],listKereta[2].getTipeKelas(2)),
            new Tiket(((Pemesan) listUser[1]).getPenumpang(1),((Pemesan) listUser[1]),"1/12/2024",listKereta[1],listKereta[1].getTipeKelas(1),listRailfood[0]),
            new Tiket(((Pemesan) listUser[0]).getPenumpang(1),((Pemesan) listUser[0]),"1/12/2024",listKereta[1],listKereta[1].getTipeKelas(1),listRailfood[1]),
            new Tiket(((Pemesan) listUser[2]).getPenumpang(0),((Pemesan) listUser[2]),"1/12/2024",listKereta[0],listKereta[0].getTipeKelas(0),listRailfood[0]),
    };
    
    
    
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
        return listKursi[rnd];
    }

    public static void cekTiketPemesan(Pemesan pemesan){
        // pemesan mengecek info penumpang dan tiket apa saja yang telah dipesan
        System.out.println("Tiket yang telah dipesan oleh: " + pemesan.getEmail());
            for (Tiket tiket : listTiket) {
                if (tiket.getPemesan() == pemesan) {
                    tiket.printInfo();
                    System.out.println("------------------------------------------------------------------------");
            }
        }
    }

    public static void cekTiketPetugas(Petugas petugas) {
        System.out.println("Tiket yang ditugaskan untuk petugas ini adalah: " + petugas.getNama_petugas());
        for (Tiket tiket : listTiket) {
            if (tiket.getPetugas() == petugas) {
                tiket.printInfo();
                separator();
            }
        }
    }
    
    public static void separator(){
        System.out.println("------------------------------------------------------------------------");
    }
}
