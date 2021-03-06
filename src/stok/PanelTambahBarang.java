/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package stok;

import Main.GenerateQRCodeFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PanelTambahBarang extends javax.swing.JPanel {
    
    Koneksi koneksi = new Koneksi();

    private DefaultTableModel model;

    // method untuk membuat id otomatis
    private void autonumber() {
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT MAX(id_barang) as jumlah_barang FROM stok_barang";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String id_barang = r.getString("jumlah_barang");
                
                if(id_barang == null){
                    txtIDBarang.setText("BG1");
                } else {
                    String[] parts = id_barang.split("G");
                    int part1 = Integer.parseInt(parts[1]);
                    part1++;

                    String No = "BG" + Integer.toString(part1);
                    txtIDBarang.setText(No);
                }
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("autonumber error");
        }
    }

    public void clear() {
        txtNamaBarang.setText("");
        txtHargaBeli.setText("");
    }

    private void loadData() {
        String id_jenis_barang = "";
        String id_satuan = "";
        String id_jenis_jenis = "";
        
        ArrayList<String> item_jenis_barang = new ArrayList<String>();
        ArrayList<String> item_satuan = new ArrayList<String>();
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM stok_barang";
            ResultSet r = s.executeQuery(sql);
            
            Connection c1 = Koneksi.getKoneksi();
            Statement s1 = c.createStatement();
            String sql1;
            ResultSet r1;

            while (r.next()) {
                Object[] o = new Object[10];
                o[0] = r.getString("id_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("deskripsi");
                id_jenis_barang = r.getString("id_jenis_barang");
                id_jenis_jenis = r.getString("id_jenis_jenis");
                id_satuan = r.getString("id_satuan");
                o[6] = r.getString("stok_barang");
                o[7] = r.getString("harga_beli");
                o[8] = r.getString("harga_jual");
                o[9] = r.getString("tgl_masuk_barang");
                
                // set tabel jenis barang
                sql1 = "SELECT * FROM jenis_barang WHERE id_jenis_barang = '" + id_jenis_barang + "'";
                r1 = s1.executeQuery(sql1);
                while (r1.next()) {
                    o[3] = r1.getString("jenis_barang");
                }
                
                // set tabel jenis dari jenis barang
                sql1 = "SELECT * FROM jenis_dari_jenis WHERE id_jenis_jenis = '" + id_jenis_jenis + "'";
                r1 = s1.executeQuery(sql1);
                while (r1.next()) {
                    o[4] = r1.getString("jenis_jenis");
                }
                
                // set tabel jenis dari jenis barang
                sql1 = "SELECT * FROM satuan WHERE id_satuan = '" + id_satuan + "'";
                r1 = s1.executeQuery(sql1);
                while (r1.next()) {
                    o[5] = r1.getString("satuan");
                }
                
                model.addRow(o);
            }
            
            
            // jenis barang
            txtIDJenisBarang.removeAllItems();
            sql = "SELECT * FROM jenis_barang";
            r = s.executeQuery(sql);
            while (r.next()) {
                item_jenis_barang.add(r.getString("jenis_barang"));
            }
            for (int i = 0; i < item_jenis_barang.size(); i++) {
                txtIDJenisBarang.addItem(item_jenis_barang.get(i));
            }
            
            // satuan
            txtIDSatuan.removeAllItems();
            sql = "SELECT * FROM satuan";
            r = s.executeQuery(sql);
            while (r.next()) {
                item_satuan.add(r.getString("satuan"));
            }
            for (int i = 0; i < item_satuan.size(); i++) {
                txtIDSatuan.addItem(item_satuan.get(i));
            }
            
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Creates new form Home
     */
    public PanelTambahBarang() {
        initComponents();
        
        txtIDBarang.setEnabled(false);

        model = new DefaultTableModel();

        jTable1.setModel(model);

        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Deskripsi");
        model.addColumn("Jenis Barang");
        model.addColumn("Jenis");
        model.addColumn("Satuan");
        model.addColumn("Stok");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Tanggal Masuk");

        loadData();
        autonumber();
        
        Date date = new Date();
        txtTanggalMasuk.setDate(date);
    }
    
    private String getIDJenisBarang(String jenis){
        String id_jenis_barang = "";
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM jenis_barang WHERE jenis_barang = '" + jenis + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                id_jenis_barang = r.getString("id_jenis_barang");
            }
            
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id_jenis_barang;
    }
    
    private String getIDJenisJenis(String jenis){
        String id_jenis_jenis = "";
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM jenis_dari_jenis WHERE jenis_jenis = '" + jenis + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                id_jenis_jenis = r.getString("id_jenis_jenis");
            }
            
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id_jenis_jenis;
    }
    
    private String getIDSatuan(String satuan){
        String id_satuan = "";
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM satuan WHERE satuan = '" + satuan + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                id_satuan = r.getString("id_satuan");
            }
            
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id_satuan;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDJenisBarang = new javax.swing.JComboBox<>();
        txtStokBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHargaBeli = new javax.swing.JTextField();
        txtTanggalMasuk = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtCariBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        txtIDSatuan = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtHargaJual = new javax.swing.JTextField();
        txtJenisJenis = new javax.swing.JLabel();
        txtIDJenisJenis = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(20, 195, 142));
        setMinimumSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(20, 195, 142));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("INSERT STOK BARANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(389, 389, 389))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setText("ID Barang");

        jLabel3.setText("Nama Barang");

        txtIDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBarangActionPerformed(evt);
            }
        });

        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });

        jLabel4.setText("Jenis Barang");

        jLabel5.setText("Stok Barang");

        txtIDJenisBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtIDJenisBarangItemStateChanged(evt);
            }
        });
        txtIDJenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDJenisBarangActionPerformed(evt);
            }
        });

        txtStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Harga Beli");

        jLabel7.setText("Tanggal Masuk");

        txtHargaBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBeliActionPerformed(evt);
            }
        });

        jLabel8.setText("Cari Barang");

        txtCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariBarangActionPerformed(evt);
            }
        });
        txtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariBarangKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnInsert.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnInsert.setText("Tambah");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        txtIDSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSatuanActionPerformed(evt);
            }
        });

        jLabel10.setText("Satuan");

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        jScrollPane2.setViewportView(txtDeskripsi);

        jLabel11.setText("Deskripsi");

        jLabel12.setText("Harga Jual");

        txtHargaJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaJualActionPerformed(evt);
            }
        });

        txtJenisJenis.setText("Jenis ...");

        txtIDJenisJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDJenisJenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(23, 23, 23)
                        .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDBarang)
                                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIDJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtJenisJenis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIDJenisJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIDSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(36, 36, 36)
                                                .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(36, 36, 36)
                                                .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtIDJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtJenisJenis)
                                    .addComponent(txtIDJenisJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtIDSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStokBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBarangActionPerformed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void txtIDJenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDJenisBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDJenisBarangActionPerformed

    private void txtStokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokBarangActionPerformed

    private void txtHargaBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBeliActionPerformed

    private void txtCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariBarangActionPerformed

    private void txtCariBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyTyped
        // TODO add your handling code here:
        String id_jenis_barang = "";
        String id_satuan = "";
        String id_jenis_jenis = "";
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        if(txtCariBarang.getText().length() == 0){
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();

                String sql = "SELECT * FROM stok_barang";
                ResultSet r = s.executeQuery(sql);

                Connection c1 = Koneksi.getKoneksi();
                Statement s1 = c.createStatement();
                String sql1;
                ResultSet r1;

                while (r.next()) {
                    Object[] o = new Object[10];
                    o[0] = r.getString("id_barang");
                    o[1] = r.getString("nama_barang");
                    o[2] = r.getString("deskripsi");
                    id_jenis_barang = r.getString("id_jenis_barang");
                    id_jenis_jenis = r.getString("id_jenis_jenis");
                    id_satuan = r.getString("id_satuan");
                    o[6] = r.getString("stok_barang");
                    o[7] = r.getString("harga_beli");
                    o[8] = r.getString("harga_jual");
                    o[9] = r.getString("tgl_masuk_barang");

                    // set tabel jenis barang
                    sql1 = "SELECT * FROM jenis_barang WHERE id_jenis_barang = '" + id_jenis_barang + "'";
                    r1 = s1.executeQuery(sql1);
                    while (r1.next()) {
                        o[3] = r1.getString("jenis_barang");
                    }

                    // set tabel jenis dari jenis barang
                    sql1 = "SELECT * FROM jenis_dari_jenis WHERE id_jenis_jenis = '" + id_jenis_jenis + "'";
                    r1 = s1.executeQuery(sql1);
                    while (r1.next()) {
                        o[4] = r1.getString("jenis_jenis");
                    }

                    // set tabel jenis dari jenis barang
                    sql1 = "SELECT * FROM satuan WHERE id_satuan = '" + id_satuan + "'";
                    r1 = s1.executeQuery(sql1);
                    while (r1.next()) {
                        o[5] = r1.getString("satuan");
                    }
                    
                    model.addRow(o);    
                }
            } catch (SQLException e) {
                System.out.println("Pencarian Data Waktu Nilai Kosong Error");
            }
        } else {
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT * FROM stok_barang WHERE id_barang like '%" + txtCariBarang.getText() + "%' OR id_jenis_barang  like '%" + txtCariBarang.getText() + "%' OR id_jenis_jenis  like '%" + txtCariBarang.getText() + "%' OR id_satuan  like '%" + txtCariBarang.getText() + "%' OR nama_barang  like '%" + txtCariBarang.getText() + "%' OR stok_barang  like '%" + txtCariBarang.getText() + "%' or harga_beli  like '%" + txtCariBarang.getText() + "%' OR harga_jual  like '%" + txtCariBarang.getText() + "%' OR deskripsi  like '%" + txtCariBarang.getText() + "%' OR tgl_masuk_barang  like '%" + txtCariBarang.getText() + "%'";
                ResultSet r = s.executeQuery(sql);

                Connection c1 = Koneksi.getKoneksi();
                Statement s1 = c.createStatement();
                String sql1;
                ResultSet r1;

                while (r.next()) {
                    Object[] o = new Object[10];
                    o[0] = r.getString("id_barang");
                    o[1] = r.getString("nama_barang");
                    o[2] = r.getString("deskripsi");
                    id_jenis_barang = r.getString("id_jenis_barang");
                    id_jenis_jenis = r.getString("id_jenis_jenis");
                    id_satuan = r.getString("id_satuan");
                    o[6] = r.getString("stok_barang");
                    o[7] = r.getString("harga_beli");
                    o[8] = r.getString("harga_jual");
                    o[9] = r.getString("tgl_masuk_barang");

                    // set tabel jenis barang
                    sql1 = "SELECT * FROM jenis_barang WHERE id_jenis_barang = '" + id_jenis_barang + "'";
                    r1 = s1.executeQuery(sql1);
                    while (r1.next()) {
                        o[3] = r1.getString("jenis_barang");
                    }

                    // set tabel jenis dari jenis barang
                    sql1 = "SELECT * FROM jenis_dari_jenis WHERE id_jenis_jenis = '" + id_jenis_jenis + "'";
                    r1 = s1.executeQuery(sql1);
                    while (r1.next()) {
                        o[4] = r1.getString("jenis_jenis");
                    }

                    // set tabel jenis dari jenis barang
                    sql1 = "SELECT * FROM satuan WHERE id_satuan = '" + id_satuan + "'";
                    r1 = s1.executeQuery(sql1);
                    while (r1.next()) {
                        o[5] = r1.getString("satuan");
                    }
                    model.addRow(o);
                }
            } catch (SQLException e) {
                System.out.println("Pencarian Data Berdasarkan Nama Error");
            }
        }
    }//GEN-LAST:event_txtCariBarangKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String id = txtIDBarang.getText();
        String nama = txtNamaBarang.getText();
        String deskripsi = txtDeskripsi.getText();
        String jenis_barang = (String) txtIDJenisBarang.getSelectedItem();
        String jenis_jenis = (String) txtIDJenisJenis.getSelectedItem();
        String satuan = (String) txtIDSatuan.getSelectedItem();
        String harga_jual = txtHargaJual.getText();
        String harga_beli = txtHargaBeli.getText();
        String stok = txtStokBarang.getText();
        
        String id_jenis_barang = getIDJenisBarang(jenis_barang);
        String id_satuan = getIDSatuan(satuan);
        String id_jenis_jenis = getIDJenisJenis(jenis_jenis);

        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgl_masuk = String.valueOf(fm.format(txtTanggalMasuk.getDate()));

        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO stok_barang values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, id_jenis_barang);
            p.setString(3, id_jenis_jenis);
            p.setString(4, id_satuan);
            p.setString(5, nama);
            p.setString(6, stok);
            p.setString(7, harga_beli);
            p.setString(8, harga_jual);
            p.setString(9, deskripsi);
            p.setString(10, tgl_masuk);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            
            // generate qrcode
            GenerateQRCodeFrame generateQRCode = new GenerateQRCodeFrame(id, "barang");
            generateQRCode.setVisible(true);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            loadData();
            autonumber();
            clear();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtIDSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSatuanActionPerformed

    private void txtHargaJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaJualActionPerformed

    private void txtIDJenisJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDJenisJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDJenisJenisActionPerformed

    private void txtIDJenisBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtIDJenisBarangItemStateChanged
        // TODO add your handling code here:
        String id_jenis_barang = "";
        String jenis_barang = "";
        ArrayList<String> item_jenis_jenis = new ArrayList<String>();
        
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM jenis_barang WHERE jenis_barang = '" + txtIDJenisBarang.getSelectedItem() + "'";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                id_jenis_barang = r.getString("id_jenis_barang");
                jenis_barang = r.getString("jenis_barang");
            }
            
            txtJenisJenis.setText("Jenis " + jenis_barang);
            
            // jenis dari jenis
            txtIDJenisJenis.removeAllItems();
            sql = "SELECT * FROM jenis_dari_jenis WHERE id_jenis_barang = '" + id_jenis_barang + "'";
            r = s.executeQuery(sql);
            while (r.next()) {
                item_jenis_jenis.add(r.getString("jenis_jenis"));
            }
            for (int i = 0; i < item_jenis_jenis.size(); i++) {
                txtIDJenisJenis.addItem(item_jenis_jenis.get(i));
            }
            
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txtIDJenisBarangItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCariBarang;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtIDBarang;
    private javax.swing.JComboBox<String> txtIDJenisBarang;
    private javax.swing.JComboBox<String> txtIDJenisJenis;
    private javax.swing.JComboBox<String> txtIDSatuan;
    private javax.swing.JLabel txtJenisJenis;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtStokBarang;
    private com.toedter.calendar.JDateChooser txtTanggalMasuk;
    // End of variables declaration//GEN-END:variables
}
