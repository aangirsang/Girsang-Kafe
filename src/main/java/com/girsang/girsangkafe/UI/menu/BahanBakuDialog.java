package com.girsang.girsangkafe.UI.menu;

import com.girsang.girsangkafe.UI.FrameUtama;
import com.girsang.girsangkafe.model.master.BahanBaku;
import com.girsang.girsangkafe.model.master.SelisihBahanBaku;
import com.girsang.girsangkafe.util.Notifikasi;
import com.girsang.girsangkafe.util.PesanJO;
import com.girsang.girsangkafe.util.TextComponentUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class BahanBakuDialog extends javax.swing.JDialog {

    BahanBaku bahanBaku;
    SelisihBahanBaku selisih;
    List<SelisihBahanBaku> listSelisih;
    public BahanBakuDialog() {
        super(FrameUtama.getInstance(), true);
        initComponents();
        initListener();
        TextComponentUtils.setAutoUpperCaseText(100, txtNamaBahanBaku);
    }
    public BahanBaku showDialog(BahanBaku bB){
        clear();
        if(bB!=null){
            setTitle(PesanJO.namaDialog.BAHANBAKU_UBAH);
            bahanBaku = new BahanBaku();
            bahanBaku = bB;
            loadModelToFom();
        }else{
            setTitle(PesanJO.namaDialog.BAHANBAKU_TAMBAH);
            bahanBaku = new BahanBaku();
            listSelisih = new ArrayList<>();
        }
        
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        return bahanBaku;
    }
    
    private void clear(){
        txtNamaBahanBaku.setText("");
        txtStok.setText("");
        txtSatuanBeli.setText("");
        txtSatuanPakai.setText("");
        
        lblSatuanBeli.setText("");
        lblSatuanPakai.setText("");
    }
    
    private void loadModelToFom(){
        txtNamaBahanBaku.setText(bahanBaku.getNamaBahanBaku());
        cboSatuanBeli.setSelectedItem(bahanBaku.getSatuanBeli());
        txtStok.setText(bahanBaku.getStok().toString());
        cboSatuanPakai.setSelectedItem(bahanBaku.getSatuanPakai());
        txtIsiSatuanBeli.setText(bahanBaku.getIsiSatuanBeli().toString());
    }
    private boolean validasiSimpan(){
        if(txtNamaBahanBaku.getText().isEmpty()){
                Notifikasi.pesanValidasiSimpan();
                return false;
            }
        return true;
    }
    private void loadFormToModel(BahanBaku bB){
            bB.setNamaBahanBaku(txtNamaBahanBaku.getText());
            bB.setSatuanBeli(txtSatuanBeli.getText());
            bB.setStok(Integer.parseInt(txtStok.getText()));
            bB.setSatuanPakai(txtSatuanPakai.getText());
            bB.setIsiSatuanBeli(Integer.valueOf(txtIsiSatuanBeli.getText()));
    }
    private void initListener(){
        btnBatal.addActionListener((ActionEvent ae) -> {
            bahanBaku = null;
            dispose();
        });
        btnSimpan.addActionListener((ActionEvent ae)->{
            if(validasiSimpan()){
                if (bahanBaku==null){
                    bahanBaku=new BahanBaku();
                }
                loadFormToModel(bahanBaku);
                dispose();
            }
        });
        txtSatuanBeli.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                lblSatuanBeli.setText(txtSatuanBeli.getText());
            }
        });
        txtSatuanPakai.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                lblSatuanPakai.setText(txtSatuanPakai.getText());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNamaBahanBaku = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        lblSatuanBeli = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIsiSatuanBeli = new javax.swing.JTextField();
        lblSatuanPakai = new javax.swing.JLabel();
        txtSatuanPakai = new javax.swing.JTextField();
        txtSatuanBeli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSimpan.setText("Simpan");

        btnBatal.setText("Batal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatal, btnSimpan});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nama Bahan Baku");

        txtNamaBahanBaku.setText("jTextField1");

        jLabel2.setText("Satuan Beli");

        jLabel3.setText("Stok");

        txtStok.setText("jTextField1");

        lblSatuanBeli.setText("jLabel6");

        jLabel4.setText("Satuan Pakai");

        txtIsiSatuanBeli.setText("jTextField1");

        lblSatuanPakai.setText("jLabel6");

        txtSatuanPakai.setText("jTextField1");

        txtSatuanBeli.setText("jTextField2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSatuanBeli))
                    .addComponent(txtNamaBahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSatuanBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIsiSatuanBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSatuanPakai))
                    .addComponent(txtSatuanPakai, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamaBahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtSatuanPakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIsiSatuanBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSatuanPakai)
                    .addComponent(txtSatuanBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSatuanBeli))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblSatuanBeli;
    private javax.swing.JLabel lblSatuanPakai;
    private javax.swing.JTextField txtIsiSatuanBeli;
    private javax.swing.JTextField txtNamaBahanBaku;
    private javax.swing.JTextField txtSatuanBeli;
    private javax.swing.JTextField txtSatuanPakai;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
