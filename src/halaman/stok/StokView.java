/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package halaman.stok;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import halaman.GenerateQRCodeFrame;
/**
 *
 * @author sultan
 */
public class StokView extends javax.swing.JPanel {
    
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
                int Noint = r.getInt("jumlah_barang") + 1;
                String No = Integer.toString(Noint);
                txtIDBarang.setText(No);
            } else {
                txtIDBarang.setText("1");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    public void clear() {
        txtNamaBarang.setText("");
        txtHargaBarang.setText("");
    }

    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM stok_barang";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[7];
                o[0] = r.getString("id_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("jenis_barang");
                o[3] = r.getString("stok_barang");
                o[4] = r.getString("harga_jual");
                o[5] = r.getString("harga_beli");
                o[6] = r.getString("tgl_masuk");

                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Creates new form StokBarang
     */
    public StokView() {
        initComponents();
        

        txtIDBarang.setEnabled(false);

        model = new DefaultTableModel();

        jTable1.setModel(model);

        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Stok");
        model.addColumn("Harga Jual");
        model.addColumn("Harga Beli");
        model.addColumn("Tanggal Masuk");

        loadData();
        autonumber();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        txtStokBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHargaBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIDBarang = new javax.swing.JTextField();
        txtCariBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtJenisBarang = new javax.swing.JComboBox<>();
        txtTanggalMasuk = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtHargaBeli = new javax.swing.JTextField();

        setBackground(new java.awt.Color(20, 195, 142));

        jLabel5.setText("Stok Barang");

        btnSimpan.setText("Simpan");
        btnSimpan.setBorderPainted(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Harga Jual");

        jPanel1.setBackground(new java.awt.Color(20, 195, 142));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("FORM BARANG ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jLabel7.setText("Tanggal Masuk");

        txtHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBarangActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Barang");

        jLabel3.setText("Nama Barang");

        jLabel8.setText("Cari Barang");

        txtIDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBarangActionPerformed(evt);
            }
        });

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

        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
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

        jLabel4.setText("Jenis Barang");

        txtJenisBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pensil", "Penggaris", "Kertas", "Pulpen", " " }));
        txtJenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJenisBarangActionPerformed(evt);
            }
        });

        jLabel9.setText("Harga Beli");

        txtHargaBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIDBarang)
                                .addComponent(txtNamaBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(txtHargaBarang, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStokBarang)
                    .addComponent(txtJenisBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnSimpan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String id = txtIDBarang.getText();
        String nama = txtNamaBarang.getText();
        String jenis = (String) txtJenisBarang.getSelectedItem();
        String hargaJual = txtHargaBarang.getText();
        String hargaBeli = txtHargaBeli.getText();
        String stok = txtStokBarang.getText();

        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgl_masuk = String.valueOf(fm.format(txtTanggalMasuk.getDate()));

        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO stok_barang VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, jenis);
            p.setString(4, stok);
            p.setString(5, hargaJual);
            p.setString(6, hargaBeli);
            p.setString(7, tgl_masuk);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadData();
            autonumber();
            clear();
            
            // generate qrcode
            GenerateQRCodeFrame generateQRCode = new GenerateQRCodeFrame(id, "barang");
            generateQRCode.setVisible(true);
        } catch (SQLException e) {
            System.out.println(e);
        }
        loadData();
    // GEN-LAST:event_btnSimpanActionPerformed
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtJenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenisBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJenisBarangActionPerformed

    private void txtStokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokBarangActionPerformed

    private void txtHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBarangActionPerformed

    private void txtIDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBarangActionPerformed

    private void txtCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariBarangActionPerformed

    private void txtCariBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyTyped
        // TODO add your handling code here:
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("ID");
        tabel.addColumn("Nama");
        tabel.addColumn("Jenis");
        tabel.addColumn("Stok");
        tabel.addColumn("Harga Jual");
        tabel.addColumn("Harga Beli");
        tabel.addColumn("Tanggal Masuk");
        
        if(txtCariBarang.getText().length() == 0){
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "SELECT * FROM stok_barang";
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    tabel.addRow(new Object[] {
                            r.getString(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5),
                            r.getString(6),
                            r.getString(7)
                    });
                }
                jTable1.setModel(tabel);
                loadData();
            } catch (SQLException e) {
                System.out.println("Pencarian Data Waktu Nilai Kosong Error");
            }
        } else {
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "SELECT * FROM stok_barang WHERE nama_barang like '%" + txtCariBarang.getText() + "%'";
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    tabel.addRow(new Object[] {
                            r.getString(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5),
                            r.getString(6),
                            r.getString(7)
                    });
                }
                jTable1.setModel(tabel);
                loadData();
            } catch (Exception e) {
                System.out.println("Pencarian Data Berdasarkan Nama Error");
            }
        }
    // GEN-LAST:event_txtCariBarangKeyTyped
    }//GEN-LAST:event_txtCariBarangKeyTyped

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        btnSimpan.setEnabled(false);
//        int i = jTable1.getSelectedRow();
//        if (i == -1) {
//            return;
//        }
//
//        String id = (String) model.getValueAt(i, 0);
//        txtIDBarang.setText(id);
//        String nama = (String) model.getValueAt(i, 1);
//        txtNamaBarang.setText(nama);
//        System.out.println(nama);
//        String jenis = (String) model.getValueAt(i, 2);
//        txtJenisBarang.setSelectedItem(jenis);
//        System.out.println(jenis);
//        String stok = (String) model.getValueAt(i, 3);
//        txtStokBarang.setText(stok);
//        String harga = (String) model.getValueAt(i, 4);
//        txtHargaBarang.setText(harga);
//
//        String tgl_masuk = (String) jTable1.getModel().getValueAt(i, 5);
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-M-dd");
//        try {
//            java.util.Date d = f.parse(tgl_masuk);
//            txtTanggalMasuk.setDate(d);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    // GEN-LAST:event_jTable1MouseClicked
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtHargaBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBeliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCariBarang;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtIDBarang;
    private javax.swing.JComboBox<String> txtJenisBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtStokBarang;
    private com.toedter.calendar.JDateChooser txtTanggalMasuk;
    // End of variables declaration//GEN-END:variables

}
