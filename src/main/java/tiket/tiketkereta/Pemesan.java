/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

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
    
    // public void bookTicket();
    
    // public void orderRailfood();
    
    public void showAllPenumpang() {
        for (Penumpang penumpang : listPenumpang) {
            penumpang.printInfo();
        }
    }
    
    public Penumpang getPenumpang(int index){
        return listPenumpang[index];
    }
}
