/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package halaman.laporan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sultan
 */
public class menuStok extends javax.swing.JPanel {

    /**
     * Creates new form menuBarang
     */
    public menuStok() {
        initComponents();
    }
    
    String getSelectedButtonBarang()
    {   
        for (Enumeration<AbstractButton> buttons = buttonGroupBarang.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                String text = button.getText();
                switch (text) {
                    case "ID":
                        return "id_barang";
                    case "Nama":
                        return "nama_barang";
                    case "Jenis Barang":
                        return "jenis_barang";
                    case "Stok":
                        return "stok_barang";
                    case "Harga":
                        return "harga_barang";
                    case "Tanggal Masuk":
                        return "tgl_masuk";
                    case "Semua":
                        return "semua";
                    default:
                        break;
                }
            }
        }
        return null;
    }
    
    Connection con;
    PreparedStatement pat;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupBarang = new javax.swing.ButtonGroup();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtNilaiBarang = new javax.swing.JTextField();
        btnCetakBarang = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCetakTanggal = new javax.swing.JButton();
        txtTanggalAkhir = new javax.swing.JTextField();
        txtTanggalAwal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(20, 195, 142));

        buttonGroupBarang.add(jRadioButton10);
        jRadioButton10.setText("Stok");
        jRadioButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton10MouseClicked(evt);
            }
        });

        buttonGroupBarang.add(jRadioButton11);
        jRadioButton11.setText("Jenis Barang");
        jRadioButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton11MouseClicked(evt);
            }
        });

        buttonGroupBarang.add(jRadioButton12);
        jRadioButton12.setText("Nama");
        jRadioButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton12MouseClicked(evt);
            }
        });

        buttonGroupBarang.add(jRadioButton13);
        jRadioButton13.setText("ID");
        jRadioButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton13MouseClicked(evt);
            }
        });
        jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton13ActionPerformed(evt);
            }
        });

        buttonGroupBarang.add(jRadioButton14);
        jRadioButton14.setText("Semua");
        jRadioButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton14MouseClicked(evt);
            }
        });
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });

        jLabel7.setText("Nilai");

        txtNilaiBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNilaiBarangActionPerformed(evt);
            }
        });

        btnCetakBarang.setText("Cetak");
        btnCetakBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Dipilih Berdasarkan");

        buttonGroupBarang.add(jRadioButton8);
        jRadioButton8.setText("Tanggal Masuk");
        jRadioButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton8MouseClicked(evt);
            }
        });

        buttonGroupBarang.add(jRadioButton9);
        jRadioButton9.setText("Harga");
        jRadioButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton9MouseClicked(evt);
            }
        });

        jButton1.setText("Stok barang sedikit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stok barang terbanyak");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal Awal");

        jLabel2.setText("Tanggal Akhir");

        btnCetakTanggal.setText("Cetak");
        btnCetakTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakTanggalActionPerformed(evt);
            }
        });

        txtTanggalAkhir.setText("0000-00-00");
        txtTanggalAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalAkhirActionPerformed(evt);
            }
        });

        txtTanggalAwal.setText("0000-00-00");

        jLabel3.setText("Format Tahun-Bulan-Tangal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNilaiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnCetakBarang))
                            .addComponent(btnCetakTanggal))
                        .addGap(176, 176, 176))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtNilaiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCetakBarang))
                            .addComponent(jRadioButton14, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCetakTanggal))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton13ActionPerformed

    private void jRadioButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton14MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(false);
    }//GEN-LAST:event_jRadioButton14MouseClicked

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void txtNilaiBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNilaiBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNilaiBarangActionPerformed

    private void btnCetakBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakBarangActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/penjualan-alat-tulis", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\sultan\\Documents\\NetBeansProjects\\penjualan-alat-tulis\\src\\halaman\\laporan\\laporanStok.jrxml");
            
            String selectedButton;
            String query;
            String nilai = txtNilaiBarang.getText();
                    
            if(getSelectedButtonBarang().equals("semua")){
                query = "SELECT * FROM stok_barang";
            } else {
                selectedButton = getSelectedButtonBarang();
                query = "SELECT * FROM stok_barang WHERE " + selectedButton + " = " + "'" + nilai + "'";
            }
            
            
            
            System.out.println(query);
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            
            JasperViewer.viewReport(jprint);
            
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCetakBarangActionPerformed

    private void jRadioButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton13MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(true);
    }//GEN-LAST:event_jRadioButton13MouseClicked

    private void jRadioButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton12MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(true);
    }//GEN-LAST:event_jRadioButton12MouseClicked

    private void jRadioButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton11MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(true);
    }//GEN-LAST:event_jRadioButton11MouseClicked

    private void jRadioButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton10MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(true);
    }//GEN-LAST:event_jRadioButton10MouseClicked

    private void jRadioButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton9MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(true);
    }//GEN-LAST:event_jRadioButton9MouseClicked

    private void jRadioButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton8MouseClicked
        // TODO add your handling code here:
        txtNilaiBarang.setEditable(true);
    }//GEN-LAST:event_jRadioButton8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/penjualan-alat-tulis", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\sultan\\Documents\\NetBeansProjects\\penjualan-alat-tulis\\src\\halaman\\laporan\\laporanStok.jrxml");
            
            String query;
            
            query = "SELECT * FROM stok_barang ORDER BY stok_barang";
            
            System.out.println(query);
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            
            JasperViewer.viewReport(jprint);
            
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/penjualan-alat-tulis", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\sultan\\Documents\\NetBeansProjects\\penjualan-alat-tulis\\src\\halaman\\laporan\\laporanStok.jrxml");
            
            String query;
            
            query = "SELECT * FROM stok_barang ORDER BY stok_barang DESC";
            
            System.out.println(query);
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            
            JasperViewer.viewReport(jprint);
            
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCetakTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakTanggalActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/penjualan-alat-tulis", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\sultan\\Documents\\NetBeansProjects\\penjualan-alat-tulis\\src\\halaman\\laporan\\laporanStok.jrxml");
            
            String query;
            
            query = "SELECT * FROM stok_barang WHERE tgl_masuk > '"+ txtTanggalAwal.getText() + "' AND tgl_masuk < '" + txtTanggalAkhir.getText() + "' ";
            
            System.out.println(query);
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            
            JasperViewer.viewReport(jprint);
            
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCetakTanggalActionPerformed

    private void txtTanggalAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalAkhirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetakBarang;
    private javax.swing.JButton btnCetakTanggal;
    private javax.swing.ButtonGroup buttonGroupBarang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField txtNilaiBarang;
    private javax.swing.JTextField txtTanggalAkhir;
    private javax.swing.JTextField txtTanggalAwal;
    // End of variables declaration//GEN-END:variables
}
