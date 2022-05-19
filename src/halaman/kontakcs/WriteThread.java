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
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ViewKontakCS client;
 
    public WriteThread(Socket socket, ViewKontakCS client) {
        this.socket = socket;
        this.client = client;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
 
        //Console console = System.console();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter your name: ");

        String userName = "a";
//        try{
//            userName = br.readLine();
//        }catch(IOException e){
//            System.out.println("ee ; "+e);
//        }
        
        client.setUserName(userName);
        writer.println(userName);
 
        String text="";
 
        do {
            //text = console.readLine("[" + userName + "]: ");
            text = "[" + userName + "]: ";
            client.setTxtIsiChat("\n" + text);
            
            text = client.getPesan();
            client.setTxtIsiChat("\n" + text);
            //            text = br.readLine();
            writer.println(text);
 
        } while (!text.equals("bye"));
 
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}