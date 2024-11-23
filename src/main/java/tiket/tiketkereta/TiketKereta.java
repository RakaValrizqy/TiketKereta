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
        String tgl = "19/11/2024";
        Tiket tick = new Tiket(currentUser.getPenumpang(0),currentUser,tgl,Utility.listKereta[2],Utility.listKereta[2].getTipeKelas(2));
        tick.printInfo();
        Utility.separator();
        Tiket tick2 = new Tiket(currentUser.getPenumpang(1),currentUser,tgl,Utility.listKereta[1],Utility.listKereta[1].getTipeKelas(1),Utility.listRailfood[0]);
        tick2.printInfo();
    }
}
