/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halaman.kontakcs;

/**
 *
 * @author ASUS UX31E
 */
//package net.codejava.networking.chat.client;
 
import java.io.*;
import java.net.*;
import halaman.kontakcs.ViewKontakCS;
 
/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ViewKontakCS client;
 
    public ReadThread(Socket socket, ViewKontakCS client) {
        this.socket = socket;
        this.client = client;
 
        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
        while (true) {
            try {
                String response = reader.readLine();
                System.out.println("\n" + response);
 
                // prints the username after displaying the server's message
                if (client.getUserName() != null) {
                    String text = "[" + client.getUserName() + "]: ";
                    client.setTxtIsiChat("\n" + text);
                    
                    System.out.print("[" + client.getUserName() + "]: ");
                }
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}