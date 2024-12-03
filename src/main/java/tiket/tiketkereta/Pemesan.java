/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Pemesan extends Pengguna {
    private Saldo saldo;
    private Penumpang[] listPenumpang;

    public Pemesan(String email, String password, int saldo, Penumpang[] listPenumpang) {
        super(email, password);
        this.saldo = new Saldo(saldo);
        this.listPenumpang = listPenumpang;
    }

    public Saldo getSaldo() {
        return saldo;
    }
    
    
    
    // public void bookTicket();
    public void bookTiket(){
        Scanner in = new Scanner(System.in);
        String asal,tujuan, tanggal, namaKereta;
        Penumpang selectedPenumpang;
        Kereta selectedKereta;
        TipeKelas selectedTipe;
        Railfood selectedRailfood = null;
        int idxPenumpang, idxTipe;
        
        Utility.separator();
        System.out.println("----------------------------Pesan Tiket---------------------------------");
        System.out.print("Masukkan kota asal  : ");
        asal = in.next();
        System.out.print("Masukkan kota tujuan: ");
        tujuan = in.next();
        System.out.print("Masukkan tanggal perjalanan (dd//mm//yyyy): ");
        tanggal = in.next();
        if (!Utility.checkKeretaOnRoad(asal,tujuan)) {
            System.out.println("Tidak ada kereta yang sesuai dengan destinasi anda");
            
        } else {
            for (Kereta train:Utility.listKereta){
                if (train.isOnRoute(asal, tujuan)) {
                    Utility.separator();
                    train.show();
                }
            }
            System.out.print("Input nama kereta: ");
            namaKereta = in.next();
            while (Utility.findKereta(namaKereta, asal, tujuan)==null){
                System.out.print("Nama tidak valid!\nInput nama kereta sesuai yang muncul pada layar: ");
                namaKereta = in.next();
            }
            selectedKereta = Utility.findKereta(namaKereta, asal, tujuan);
            System.out.println(selectedKereta.getNama());
            selectedKereta.showAllTipe();
            System.out.print("Pilih nomor tipe: ");
            idxTipe = in.nextInt();
            while (idxTipe < 1 || idxTipe>3){
                System.out.print("Pilihan tidak valid!\nPilih nomor tipe: ");
                idxTipe = in.nextInt();
            }
            selectedTipe = selectedKereta.getTipeKelas(idxTipe-1);
            //System.out.println(selectedTipe.getNamaTipe());
            
            showAllPenumpang();
            System.out.print("Pilih nomor penumpang: ");
            idxPenumpang = in.nextInt();
            while (idxPenumpang < 1 || idxPenumpang>listPenumpang.length){
                System.out.print("Pilihan tidak valid!\nPilih nomor penumpang: ");
                idxPenumpang = in.nextInt();
            }
            selectedPenumpang = getPenumpang(idxPenumpang-1);
            
            System.out.print("Ingin memesan Railfood? Y/N: ");
            String yn = in.next();
            if (yn.equalsIgnoreCase("Y")) {
                Utility.showAllRailfood();
                System.out.print("Pilih nomor Railfood: ");
                int idxRailfood = in.nextInt();
                while (idxRailfood < 1 || idxRailfood>Utility.listRailfood.length){
                    System.out.print("Pilihan tidak valid!\nPilih nomor Railfood: ");
                    idxRailfood = in.nextInt();
                }
                selectedRailfood = Utility.listRailfood[idxRailfood-1];
                
            }
            
            if (selectedRailfood==null) {
                System.out.println("Harga Tiket: Rp "+selectedTipe.getHarga());
                System.out.println("Total tagihan: Rp"+selectedTipe.getHarga());
                saldo.bayar(selectedTipe.getHarga());
                Utility.listTiket.add(new Tiket(selectedPenumpang,this,tanggal,selectedKereta,selectedTipe));
            } else {
                System.out.println("Harga Tiket: Rp "+selectedTipe.getHarga());
                System.out.println("Harga "+selectedRailfood.getNama()+": Rp "+selectedRailfood.getHarga());
                System.out.println("Total tagihan: Rp "+selectedTipe.getHarga());
                saldo.bayar(selectedRailfood.getHarga()+selectedTipe.getHarga());
                Utility.listTiket.add(new Tiket(selectedPenumpang,this,tanggal,selectedKereta,selectedTipe,selectedRailfood));
            }
        }
        
    }
    
    // public void orderRailfood();

    public void cekSaldo() {
        System.out.println("Sisa saldo " + super.getEmail() + ": Rp " + saldo.getJumlahSaldo());
    }
    
    public void showAllPenumpang() {
        int i=1;
        for (Penumpang penumpang : listPenumpang) {
            System.out.print(i+". ");
            penumpang.printInfo();
            i++;
        }
    }
    
    public Penumpang getPenumpang(int index){
        return listPenumpang[index];
    }
}
