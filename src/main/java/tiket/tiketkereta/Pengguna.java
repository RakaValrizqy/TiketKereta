/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.tiketkereta;

/**
 *
 * @author LENOVO
 */
public abstract class Pengguna {
    private String email;
    private String password;

    public Pengguna(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean logIn(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public Pengguna logOut() {
        return null;
    }
    
    public abstract void printInfo();
    
    // apa kek
}
