/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tiket.tiketkereta;

/**
 *
 * @author RVA
 */
public class TiketKereta {

    public static void main(String[] args) {
        
        // logIn() Pengguna
        String email = "def@gmail.com";
        String password = "456";
        int i = 0;
        Pemesan currentUser = null;
        while (currentUser == null && i < Utility.listUser.length) {
            if (Utility.listUser[i].logIn(email, password)) {
                currentUser = (Pemesan) Utility.listUser[i];
                break;
            }
            i++;
        }
        
        if (currentUser == null) {
            System.out.println("\nAkun tidak ditemukan, pastikan email dan password benar.");
        } else {
            System.out.println("\nSelamat Datang!");
            currentUser.printInfo();
        }
        
        currentUser.showAllPenumpang();
        Utility.separator();
        //coba create tiket
        for (Tiket tick : Utility.listTiket) {
            tick.printInfo();
            Utility.separator();
        }
        currentUser.cekSaldo();
        Utility.cekTiketPemesan(currentUser);
        Utility.cekTiketPetugas(Utility.listPetugas[1]);
    }
}
