package com.girsang.girsangkafe.UI.master;

import com.girsang.girsangkafe.UI.FrameUtama;
import com.girsang.girsangkafe.model.master.Meja;
import com.girsang.girsangkafe.util.Notifikasi;
import com.girsang.girsangkafe.util.PesanJO;
import com.girsang.girsangkafe.util.TextComponentUtils;
import java.awt.event.ActionEvent;

public class NomorMejaDialog extends javax.swing.JDialog {

    Meja nomorMeja;
    public NomorMejaDialog() {
        super(FrameUtama.getInstance(), true);
        initComponents();
        initListener();
        TextComponentUtils.setAutoUpperCaseText(100, txtNomorMeja);
    }
    public Meja showDialog(Meja nM){
        if(nM!=null){
            setTitle(PesanJO.namaDialog.NOMORMEJA_UBAH);
            nomorMeja = new Meja();
            clear();
            loadModelToFom(nM);
        }else{
            setTitle(PesanJO.namaDialog.KATEGORIMENU_TAMBAH);
            clear();
        }
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        return nomorMeja;
    }
    
    private void clear(){
        txtNomorMeja.setText("");
    }
    private void loadModelToFom(Meja nM){
        nomorMeja = nM;
        txtNomorMeja.setText(nomorMeja.getNomorMeja());
    }
    private void loadFormToModel(){
        if(nomorMeja==null){
                nomorMeja = new Meja();
            }
            nomorMeja.setNomorMeja(txtNomorMeja.getText());
    }
    private void initListener(){
        btnBatal.addActionListener((ActionEvent ae) -> {
            nomorMeja = null;
            dispose();
        });
        btnSimpan.addActionListener((ActionEvent ae)->{
            if(txtNomorMeja.getText().isEmpty()){
                Notifikasi.pesanValidasiSimpan();
            }else {
                loadFormToModel();
                dispose();
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
        txtNomorMeja = new javax.swing.JTextField();

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnSimpan))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nomor Meja");

        txtNomorMeja.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(txtNomorMeja, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomorMeja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtNomorMeja;
    // End of variables declaration//GEN-END:variables
}
