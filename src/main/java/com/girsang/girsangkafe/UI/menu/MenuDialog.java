package com.girsang.girsangkafe.UI.menu;

import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.UI.FrameUtama;
import com.girsang.girsangkafe.model.master.BahanBaku;
import com.girsang.girsangkafe.model.master.KategoriMenu;
import com.girsang.girsangkafe.model.master.Menu;
import com.girsang.girsangkafe.model.master.MenuDetail;
import com.girsang.girsangkafe.util.Notifikasi;
import com.girsang.girsangkafe.util.PesanJO;
import com.girsang.girsangkafe.util.TextComponentUtils;
import com.girsang.girsangkafe.util.UkuranTabel;
import com.girsang.girsangkafe.util.tabelmodel.TabelModelMenuDetail;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class MenuDialog extends javax.swing.JDialog {

    Menu menu;
    MenuDetail menuDetail;
    BahanBaku bahanBaku;
    KategoriMenu kategoriMenu;
    List<MenuDetail> daftarMenuDetail;
    List<KategoriMenu> daftarKategoriMenu;
    public MenuDialog() {
        super(FrameUtama.getInstance(), true);
        initComponents();
        initListener();
        tampilData();
        isiComboKategoriMenu();
        txtNamaBahanBaku.setEditable(false);
        txtSatuanPakai.setEditable(false);
        TextComponentUtils.setAutoUpperCaseText(100, txtNamaMenu);
        TextComponentUtils.setCurrency(txtHarga);
        TextComponentUtils.setNumericTextOnly(txtJumlahPakai);
    }
    public Menu showDialog(Menu m){
        clearAll();
        if(m!=null){
            setTitle(PesanJO.namaDialog.MENU_UBAH);
            loadModelToFom(m);
        }else{
            setTitle(PesanJO.namaDialog.MENU_TAMBAH);
            menu = new Menu();
            daftarMenuDetail = new ArrayList<>();
        }
        
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        return menu;
    }
    private void tampilData(){
        if(menu==null){
            menu = new Menu();
        }
        daftarMenuDetail = menu.getMenuDetails();
        tblBahanBaku.setModel(new TabelModelMenuDetail(daftarMenuDetail));
        tblBahanBaku = new UkuranTabel().UkuranTabelMenuDetail(tblBahanBaku);
    }
    private void isiComboKategoriMenu(){
        cboKategoriMenu.removeAllItems();
        daftarKategoriMenu = GirsangKafe.getMasterService().semuaKategoriMenu();
        for(int i=0; i<daftarKategoriMenu.size(); i++){
            cboKategoriMenu.addItem(daftarKategoriMenu.get(i).getKategoriMenu());
        }
    }
    private void clearAll(){
        txtNamaMenu.setText("");
        txtHarga.setText("0");
        
        isiComboKategoriMenu();
        cboKategoriMenu.setSelectedItem(null);
        
        clearBahanBaku();
    }
    private void clearBahanBaku(){
        txtNamaBahanBaku.setText("");
        txtSatuanPakai.setText("");
        txtJumlahPakai.setText("0");
    }
    private void loadModelToFom(Menu m){
        menu = m;
        txtNamaMenu.setText(m.getNamaMenu());
        txtHarga.setText(TextComponentUtils.formatNumber(m.getHarga()));
        cboKategoriMenu.setSelectedItem(m.getKategoriMenu().getKategoriMenu());
        
        tampilData();
    }
    
    private boolean validasiSimpan(){
        if(menu == null
                || "".equals(txtNamaMenu.getText())
                || "0".equals(txtHarga.getText())
                || kategoriMenu == null){
                Notifikasi.pesanValidasiSimpan();
                return false;
            }
        return true;
    }
    private boolean validasiBahanBaku(){
        if( bahanBaku == null
                || "0".equals(txtJumlahPakai.getText())){
            Notifikasi.pesanValidasiSimpan();
            return false;
        }
        return true;
    }
    
    private void tambahBahanBaku(){
        boolean data = false;
        if(validasiBahanBaku()){
            menuDetail = new MenuDetail();
            menuDetail.setMenu(menu);
            menuDetail.setBahanBaku(bahanBaku);
            menuDetail.setSatuanPakai(txtSatuanPakai.getText());
            menuDetail.setJumlah(Integer.valueOf(txtJumlahPakai.getText()));
            
            if(daftarMenuDetail !=null){
                for(int i=0;i<daftarMenuDetail.size();i++){
                    if(daftarMenuDetail.get(i).getBahanBaku().getNamaBahanBaku()
                            .equals(menuDetail.getBahanBaku().getNamaBahanBaku())){
                        Notifikasi.pesanBahanBakuSudahAda();
                        data = true;
                    }
                }
            }
            if(data == false){
                daftarMenuDetail.add(menuDetail);
                tblBahanBaku.setModel(new TabelModelMenuDetail(daftarMenuDetail));
                tblBahanBaku = new UkuranTabel().UkuranTabelMenuDetail(tblBahanBaku);
                clearBahanBaku();
            }
        }
    }
    private void loadFormToModel(){
            menu.setNamaMenu(txtNamaMenu.getText());
            menu.setKategoriMenu(kategoriMenu);
            menu.setHarga(TextComponentUtils
                .parseNumberToBigDecimal(txtHarga.getText()));
            menu.setMenuDetails(daftarMenuDetail);
    }
    private void initListener(){
        btnBatal.addActionListener((ActionEvent ae) -> {
            menu = null;
            dispose();
        });
        btnSimpan.addActionListener((ActionEvent ae)->{
            if(validasiSimpan()){
                if (menu==null){
                    menu=new Menu();
                }
                loadFormToModel();
                dispose();
            }
        });
        btnCariBahanBaku.addActionListener((ActionEvent ae)->{
            BahanBaku bB = (BahanBaku) new BahanBakuPilihDialog().showDialog();
            if(bB!=null){
                bahanBaku = bB;
                txtNamaBahanBaku.setText(bahanBaku.getNamaBahanBaku());
                txtSatuanPakai.setText(bahanBaku.getSatuanPakai());
            }
        });
        btnMasukkanBahanBaku.addActionListener((ActionEvent ae)->{
            tambahBahanBaku();
        });
        cboKategoriMenu.addItemListener((ItemEvent e) -> {
            if(cboKategoriMenu.getSelectedIndex() >=0){
                kategoriMenu = daftarKategoriMenu.get(cboKategoriMenu.getSelectedIndex());
            }else{
                kategoriMenu = null;
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNamaMenu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboKategoriMenu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnCariBahanBaku = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamaBahanBaku = new javax.swing.JTextField();
        txtSatuanPakai = new javax.swing.JTextField();
        txtJumlahPakai = new javax.swing.JTextField();
        btnMasukkanBahanBaku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBahanBaku = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nama Menu");

        txtNamaMenu.setText("jTextField1");

        jLabel2.setText("Kategori Menu");

        cboKategoriMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Harga");

        txtHarga.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaMenu)
                    .addComponent(cboKategoriMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboKategoriMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Data Menu", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCariBahanBaku.setText("Cari Bahan Baku");

        jLabel4.setText("Bahan Baku");

        jLabel5.setText("Satuan Pakai");

        jLabel6.setText("Jumlah Pakai");

        txtNamaBahanBaku.setText("jTextField1");

        txtSatuanPakai.setText("jTextField1");

        txtJumlahPakai.setText("jTextField1");

        btnMasukkanBahanBaku.setText("Masukkan Bahan Baku");

        tblBahanBaku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblBahanBaku);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCariBahanBaku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMasukkanBahanBaku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(37, 37, 37)
                                .addComponent(txtNamaBahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJumlahPakai, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSatuanPakai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCariBahanBaku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaBahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSatuanPakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtJumlahPakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMasukkanBahanBaku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Data Bahan Baku Menu", jPanel4);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCariBahanBaku;
    private javax.swing.JButton btnMasukkanBahanBaku;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cboKategoriMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBahanBaku;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlahPakai;
    private javax.swing.JTextField txtNamaBahanBaku;
    private javax.swing.JTextField txtNamaMenu;
    private javax.swing.JTextField txtSatuanPakai;
    // End of variables declaration//GEN-END:variables
}
