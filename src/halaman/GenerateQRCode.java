/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package halaman;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sultan
 */
public class GenerateQRCode {
    public GenerateQRCode(String id, String modul){
        generateQR(id, modul);
    }
    
    private void generateQR(String id, String modul){
        try{
            String QrCodeData= id;
            String name = id;
            
            String filePath= "C:\\Users\\sultan\\OneDrive\\Dokumen\\NetBeansProjects\\penjualan-alat-tulis\\qrcode\\" + modul  + "\\" + name + ".png";
            
            String charset= "UTF-8";
            Map <EncodeHintType,ErrorCorrectionLevel> hintMap= new HashMap <EncodeHintType,ErrorCorrectionLevel> ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix  matrix= new MultiFormatWriter().encode(
            new String (QrCodeData.getBytes(charset),charset),
            BarcodeFormat.QR_CODE,200,200,hintMap);

            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.')+1),new File(filePath));
            System.out.println("Qr code has been generated at the location " + filePath);
            
            JFrame frame = new JFrame();
            ImageIcon icon = new ImageIcon("C:\\Users\\sultan\\OneDrive\\Dokumen\\NetBeansProjects\\penjualan-alat-tulis\\qrcode\\" + modul  + "\\" + name + ".png");
            JLabel label = new JLabel(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            
            frame.setExtendedState(JFrame.MAXIMIZED_HORIZ);
        } catch(WriterException | HeadlessException | IOException e){
            System.out.println(e);
        }
    }
}
