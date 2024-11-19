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
    static Tiket[] listTiket = {
            //(new Tiket()),
            //(new Tiket("AAAAA"))
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
    
    public static String generateKode(){
        StringBuilder sb = new StringBuilder ();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random ();
        for (int i = 0; i < 5; i ++) {
            sb.append (candidateChars.charAt (random.nextInt (candidateChars.length ())));
        }

        return sb.toString();
    }
}
