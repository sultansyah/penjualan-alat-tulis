/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package halaman.laporan;

/**
 *
 * @author sultan
 */
public class LaporanView1 extends javax.swing.JPanel {
    
    menuKaryawan karyawan;
    menuStok barang;
    menuKasir kasir;
    menuStok stok;
    
    
    /**
     * Creates new form LaporanView1
     */
    public LaporanView1() {
        initComponents();
        
        karyawan = new menuKaryawan();
        
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.add(karyawan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        btnKasir = new javax.swing.JButton();
        btnStok = new javax.swing.JButton();
        btnKaryawan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        karyawanPanel = new javax.swing.JPanel();
        barangPanel = new javax.swing.JPanel();
        kasirPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));

        menuPanel.setBackground(new java.awt.Color(102, 102, 255));

        btnKasir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKasir.setText("Kasir");
        btnKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKasirActionPerformed(evt);
            }
        });

        btnStok.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStok.setText("Stok Barang");
        btnStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStokActionPerformed(evt);
            }
        });

        btnKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKaryawan.setText("Karyawan");
        btnKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaryawanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Laporan");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuPanelLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKasir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuPanelLayout.createSequentialGroup()
                    .addGap(197, 197, 197)
                    .addComponent(btnKasir)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnStok)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnKaryawan)
                    .addContainerGap(197, Short.MAX_VALUE)))
        );

        mainPanel.setBackground(new java.awt.Color(102, 102, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        karyawanPanel.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout karyawanPanelLayout = new javax.swing.GroupLayout(karyawanPanel);
        karyawanPanel.setLayout(karyawanPanelLayout);
        karyawanPanelLayout.setHorizontalGroup(
            karyawanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        karyawanPanelLayout.setVerticalGroup(
            karyawanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        mainPanel.add(karyawanPanel, "card2");

        barangPanel.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout barangPanelLayout = new javax.swing.GroupLayout(barangPanel);
        barangPanel.setLayout(barangPanelLayout);
        barangPanelLayout.setHorizontalGroup(
            barangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        barangPanelLayout.setVerticalGroup(
            barangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        mainPanel.add(barangPanel, "card3");

        javax.swing.GroupLayout kasirPanelLayout = new javax.swing.GroupLayout(kasirPanel);
        kasirPanel.setLayout(kasirPanelLayout);
        kasirPanelLayout.setHorizontalGroup(
            kasirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        kasirPanelLayout.setVerticalGroup(
            kasirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        mainPanel.add(kasirPanel, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKasirActionPerformed
        // TODO add your handling code here:
        // remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // add
        kasir = new menuKasir();

        mainPanel.add(kasir);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKasirActionPerformed

    private void btnStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStokActionPerformed
        // TODO add your handling code here:
        // remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // add
        stok = new menuStok();

        mainPanel.add(stok);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnStokActionPerformed

    private void btnKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaryawanActionPerformed
        // TODO add your handling code here:
        // remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // add
        karyawan = new menuKaryawan();

        mainPanel.add(karyawan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKaryawanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barangPanel;
    private javax.swing.JButton btnKaryawan;
    private javax.swing.JButton btnKasir;
    private javax.swing.JButton btnStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel karyawanPanel;
    private javax.swing.JPanel kasirPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}