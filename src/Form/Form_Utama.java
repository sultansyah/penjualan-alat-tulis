/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import Form.Form_Karyawan;
import Form.Form_Lembur;
import Form.Form_Penggajian;
import Form.Form_User;
import Form.Lap_Karyawan;
import Form.Lap_Penggajian;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.LoginFrame;

/**
 *
 * @author khazil
 */
public class Form_Utama extends javax.swing.JFrame {

    /**
     * Creates new form Form_Utama
     */
    public Form_Utama() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mUtama = new javax.swing.JMenuBar();
        mData = new javax.swing.JMenu();
        dKaryawan = new javax.swing.JMenuItem();
        dLembur = new javax.swing.JMenuItem();
        dPenggajian = new javax.swing.JMenuItem();
        mLaporan = new javax.swing.JMenu();
        lKaryawan = new javax.swing.JMenuItem();
        lPenggajian = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mKeluar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(160, 30));
        setSize(new java.awt.Dimension(1000, 800));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Sistem Informasi Manajemen");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Penggajian Karyawan");

        mData.setText("DATA");
        mData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mDataMouseClicked(evt);
            }
        });

        dKaryawan.setText("Data Karyawan");
        dKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dKaryawanMouseClicked(evt);
            }
        });
        dKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dKaryawanActionPerformed(evt);
            }
        });
        mData.add(dKaryawan);

        dLembur.setText("Data Lembur");
        dLembur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dLemburMouseClicked(evt);
            }
        });
        dLembur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dLemburActionPerformed(evt);
            }
        });
        mData.add(dLembur);

        dPenggajian.setText("Data Penggajian");
        dPenggajian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dPenggajianMouseClicked(evt);
            }
        });
        dPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dPenggajianActionPerformed(evt);
            }
        });
        mData.add(dPenggajian);

        mUtama.add(mData);

        mLaporan.setText("LAPORAN");

        lKaryawan.setText("Laporan Karyawan");
        lKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lKaryawanActionPerformed(evt);
            }
        });
        mLaporan.add(lKaryawan);

        lPenggajian.setText("Laporan Penggajian");
        lPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lPenggajianActionPerformed(evt);
            }
        });
        mLaporan.add(lPenggajian);

        mUtama.add(mLaporan);

        jMenu1.setText("USER");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        mUtama.add(jMenu1);

        mKeluar.setText("LOGOUT");
        mKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mKeluarMouseClicked(evt);
            }
        });
        mKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKeluarActionPerformed(evt);
            }
        });
        mUtama.add(mKeluar);

        setJMenuBar(mUtama);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(469, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dKaryawanActionPerformed
        new Form_Karyawan().setVisible(true);
    }//GEN-LAST:event_dKaryawanActionPerformed

    private void dLemburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dLemburActionPerformed
        new Form_Lembur().setVisible(true);
    }//GEN-LAST:event_dLemburActionPerformed

    private void dPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dPenggajianActionPerformed
        new Form_Penggajian().setVisible(true);
    }//GEN-LAST:event_dPenggajianActionPerformed

    private void mKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKeluarActionPerformed

    }//GEN-LAST:event_mKeluarActionPerformed

    private void mKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mKeluarMouseClicked
        int i = JOptionPane.showConfirmDialog(null, "Apakah anda yakin Keluar?","Konfrmasi",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            this.dispose();
            new LoginFrame().setVisible(true); 
        }
    }//GEN-LAST:event_mKeluarMouseClicked

    private void mDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mDataMouseClicked

    private void dKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dKaryawanMouseClicked

    }//GEN-LAST:event_dKaryawanMouseClicked

    private void dLemburMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dLemburMouseClicked

    }//GEN-LAST:event_dLemburMouseClicked

    private void dPenggajianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dPenggajianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dPenggajianMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new Form_User().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void lKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lKaryawanActionPerformed
        new Lap_Karyawan().setVisible(true);
    }//GEN-LAST:event_lKaryawanActionPerformed

    private void lPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lPenggajianActionPerformed
        new Lap_Penggajian().setVisible(true);
    }//GEN-LAST:event_lPenggajianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dKaryawan;
    private javax.swing.JMenuItem dLembur;
    private javax.swing.JMenuItem dPenggajian;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem lKaryawan;
    private javax.swing.JMenuItem lPenggajian;
    private javax.swing.JMenu mData;
    private javax.swing.JMenu mKeluar;
    private javax.swing.JMenu mLaporan;
    private javax.swing.JMenuBar mUtama;
    // End of variables declaration//GEN-END:variables
}