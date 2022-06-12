package Main.login;

import halaman.login.*;
import halaman.stok.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sultan
 */
public class Koneksi {

    private static java.sql.Connection koneksi;

    public static java.sql.Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/penjualan-alat-tulis";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil Tersambung");
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }
        return koneksi;
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        getKoneksi();
    }
}
