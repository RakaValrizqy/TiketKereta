/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author Lenovo
 */
public class TipeKelas {
    private String namaTipe;
    private int harga;
    private KursiPenumpang[] listKursi;

    public TipeKelas(String namaTipe, int harga) {
        this.namaTipe = namaTipe;
        this.harga = harga;
        switch (namaTipe){
            case "Ekonomi" -> {
                KursiPenumpang[] listKursi = {
                    (new KursiPenumpang("1A")), (new KursiPenumpang("1B")), (new KursiPenumpang("1C")), (new KursiPenumpang("1D")), (new KursiPenumpang("1E")),
                    (new KursiPenumpang("2A")), (new KursiPenumpang("2B")), (new KursiPenumpang("2C")), (new KursiPenumpang("2D")), (new KursiPenumpang("2E")),
                    (new KursiPenumpang("3A")), (new KursiPenumpang("3B")), (new KursiPenumpang("3C")), (new KursiPenumpang("3D")), (new KursiPenumpang("3E")),
                    (new KursiPenumpang("4A")), (new KursiPenumpang("4B")), (new KursiPenumpang("4C")), (new KursiPenumpang("4D")), (new KursiPenumpang("4E")),
                    (new KursiPenumpang("5A")), (new KursiPenumpang("5B")), (new KursiPenumpang("5C")), (new KursiPenumpang("5D")), (new KursiPenumpang("5E")),
                    (new KursiPenumpang("6A")), (new KursiPenumpang("6B")), (new KursiPenumpang("6C")), (new KursiPenumpang("6D")), (new KursiPenumpang("6E")),
                    (new KursiPenumpang("7A")), (new KursiPenumpang("7B")), (new KursiPenumpang("7C")), (new KursiPenumpang("7D")), (new KursiPenumpang("7E")),
                    (new KursiPenumpang("8A")), (new KursiPenumpang("8B")), (new KursiPenumpang("8C")), (new KursiPenumpang("8D")), (new KursiPenumpang("8E")),
                    (new KursiPenumpang("9A")), (new KursiPenumpang("9B")), (new KursiPenumpang("9C")), (new KursiPenumpang("9D")), (new KursiPenumpang("9E")),
                    (new KursiPenumpang("10A")), (new KursiPenumpang("10B")), (new KursiPenumpang("10C")), (new KursiPenumpang("10D")), (new KursiPenumpang("10E")),
                    (new KursiPenumpang("11A")), (new KursiPenumpang("11B")), (new KursiPenumpang("11C")), (new KursiPenumpang("11D")), (new KursiPenumpang("11E")),
                    (new KursiPenumpang("12A")), (new KursiPenumpang("12B")), (new KursiPenumpang("12C")), (new KursiPenumpang("12D")), (new KursiPenumpang("12E")),
                    (new KursiPenumpang("13A")), (new KursiPenumpang("13B")), (new KursiPenumpang("13C")), (new KursiPenumpang("13D")), (new KursiPenumpang("13E")),
                    (new KursiPenumpang("14A")), (new KursiPenumpang("14B")), (new KursiPenumpang("14C")), (new KursiPenumpang("14D")), (new KursiPenumpang("14E")),
                    (new KursiPenumpang("15A")), (new KursiPenumpang("15B")), (new KursiPenumpang("15C")), (new KursiPenumpang("15D")), (new KursiPenumpang("15E")),
                    (new KursiPenumpang("16A")), (new KursiPenumpang("16B")), (new KursiPenumpang("16C")), (new KursiPenumpang("16D")), (new KursiPenumpang("16E")),
                    (new KursiPenumpang("17A")), (new KursiPenumpang("17B")), (new KursiPenumpang("17C")), (new KursiPenumpang("17D")), (new KursiPenumpang("17E")),
                    (new KursiPenumpang("18A")), (new KursiPenumpang("18B")), (new KursiPenumpang("18C")), (new KursiPenumpang("18D")), (new KursiPenumpang("18E")),
                    (new KursiPenumpang("19A")), (new KursiPenumpang("19B")), (new KursiPenumpang("19C")), (new KursiPenumpang("19D")), (new KursiPenumpang("19E")),
                    (new KursiPenumpang("20A")), (new KursiPenumpang("20B")), (new KursiPenumpang("20C")), (new KursiPenumpang("20D")), (new KursiPenumpang("20E")),
                };
            }
            case "Bisnis" -> {
                KursiPenumpang[] listKursi = {
                   (new KursiPenumpang("1A")), (new KursiPenumpang("1B")), (new KursiPenumpang("1C")), (new KursiPenumpang("1D")),
                   (new KursiPenumpang("2A")), (new KursiPenumpang("2B")), (new KursiPenumpang("2C")), (new KursiPenumpang("2D")),
                   (new KursiPenumpang("3A")), (new KursiPenumpang("3B")), (new KursiPenumpang("3C")), (new KursiPenumpang("3D")),
                   (new KursiPenumpang("4A")), (new KursiPenumpang("4B")), (new KursiPenumpang("4C")), (new KursiPenumpang("4D")),
                   (new KursiPenumpang("5A")), (new KursiPenumpang("5B")), (new KursiPenumpang("5C")), (new KursiPenumpang("5D")),
                   (new KursiPenumpang("6A")), (new KursiPenumpang("6B")), (new KursiPenumpang("6C")), (new KursiPenumpang("6D")),
                   (new KursiPenumpang("7A")), (new KursiPenumpang("7B")), (new KursiPenumpang("7C")), (new KursiPenumpang("7D")),
                   (new KursiPenumpang("8A")), (new KursiPenumpang("8B")), (new KursiPenumpang("8C")), (new KursiPenumpang("8D")),
                   (new KursiPenumpang("9A")), (new KursiPenumpang("9B")), (new KursiPenumpang("9C")), (new KursiPenumpang("9D")),
                   (new KursiPenumpang("10A")), (new KursiPenumpang("10B")), (new KursiPenumpang("10C")), (new KursiPenumpang("10D")),
                   (new KursiPenumpang("11A")), (new KursiPenumpang("11B")), (new KursiPenumpang("11C")), (new KursiPenumpang("11D")),
                   (new KursiPenumpang("12A")), (new KursiPenumpang("12B")), (new KursiPenumpang("12C")), (new KursiPenumpang("12D")),
                   (new KursiPenumpang("13A")), (new KursiPenumpang("13B")), (new KursiPenumpang("13C")), (new KursiPenumpang("13D")),
                   (new KursiPenumpang("14A")), (new KursiPenumpang("14B")), (new KursiPenumpang("14C")), (new KursiPenumpang("14D")),
                   (new KursiPenumpang("15A")), (new KursiPenumpang("15B")), (new KursiPenumpang("15C")), (new KursiPenumpang("15D")),
                   (new KursiPenumpang("16A")), (new KursiPenumpang("16B")), (new KursiPenumpang("16C")), (new KursiPenumpang("16D")),
                   (new KursiPenumpang("17A")), (new KursiPenumpang("17B")), (new KursiPenumpang("17C")), (new KursiPenumpang("17D")),
                };
            }
            case "Eksekutif" -> {
                KursiPenumpang[] listKursi = {
                   (new KursiPenumpang("1A")), (new KursiPenumpang("1B")), (new KursiPenumpang("1C")), (new KursiPenumpang("1D")),
                   (new KursiPenumpang("2A")), (new KursiPenumpang("2B")), (new KursiPenumpang("2C")), (new KursiPenumpang("2D")),
                   (new KursiPenumpang("3A")), (new KursiPenumpang("3B")), (new KursiPenumpang("3C")), (new KursiPenumpang("3D")),
                   (new KursiPenumpang("4A")), (new KursiPenumpang("4B")), (new KursiPenumpang("4C")), (new KursiPenumpang("4D")),
                   (new KursiPenumpang("5A")), (new KursiPenumpang("5B")), (new KursiPenumpang("5C")), (new KursiPenumpang("5D")),
                   (new KursiPenumpang("6A")), (new KursiPenumpang("6B")), (new KursiPenumpang("6C")), (new KursiPenumpang("6D")),
                   (new KursiPenumpang("7A")), (new KursiPenumpang("7B")), (new KursiPenumpang("7C")), (new KursiPenumpang("7D")),
                   (new KursiPenumpang("8A")), (new KursiPenumpang("8B")), (new KursiPenumpang("8C")), (new KursiPenumpang("8D")),
                   (new KursiPenumpang("9A")), (new KursiPenumpang("9B")), (new KursiPenumpang("9C")), (new KursiPenumpang("9D")),
                   (new KursiPenumpang("10A")), (new KursiPenumpang("10B")), (new KursiPenumpang("10C")), (new KursiPenumpang("10D")),
                   (new KursiPenumpang("11A")), (new KursiPenumpang("11B")), (new KursiPenumpang("11C")), (new KursiPenumpang("11D")),
                   (new KursiPenumpang("12A")), (new KursiPenumpang("12B")), (new KursiPenumpang("12C")), (new KursiPenumpang("12D")),
                   (new KursiPenumpang("13A")), (new KursiPenumpang("13B")), (new KursiPenumpang("13C")), (new KursiPenumpang("13D")),
                   (new KursiPenumpang("14A")), (new KursiPenumpang("14B")), (new KursiPenumpang("14C")), (new KursiPenumpang("14D")),
                   (new KursiPenumpang("15A")), (new KursiPenumpang("15B")), (new KursiPenumpang("15C")), (new KursiPenumpang("15D")),
                };
            }
        }
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public int getHarga() {
        return harga;
    }
    
    
}
