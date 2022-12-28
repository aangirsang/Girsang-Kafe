package com.girsang.girsangkafe.UI.menu;


import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.model.master.KategoriMenu;
import com.girsang.girsangkafe.util.Notifikasi;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;

public class KategoriMenuPanel extends javax.swing.JPanel {

    KategoriMenu kategoriMenu;
    List<KategoriMenu> daftarKategoriMenu;
    private String idSelect;
    private JPopupMenu popup = new JPopupMenu();
    DefaultListModel mdl = new DefaultListModel();
    
    //<editor-fold defaultstate="collapsed" desc="Tabbed">
    int IndexTab = 0;
    int aktifPanel = 0;
    public int getIndexTab() {
        return IndexTab;
    }
    public void setIndexTab(int IndexTab) {
        this.IndexTab = IndexTab;
    }
    public int getAktifPanel() {
        return aktifPanel;
    }
    public void setAktifPanel(int aktifPanel) {
        this.aktifPanel = aktifPanel;
    }
    public JButton getBtnTutup(){
        return btnKeluar;
    }
//</editor-fold>
    public KategoriMenuPanel() {
        initComponents();
        initListener();
        tampilData();
        addPopupmenu();
    }
    private void cariJabatan(){
        if (!idSelect.equals("")) {
            kategoriMenu = new KategoriMenu();
            kategoriMenu = GirsangKafe.getMasterService().kategoriMenuBerdasarkanId(idSelect);
        } else {
            kategoriMenu = null;
        }
    }
    private void tampilData(){
        mdl.removeAllElements();
        daftarKategoriMenu = GirsangKafe.getMasterService().semuaKategoriMenu();
        for(int i=0;i<daftarKategoriMenu.size();i++){
            mdl.addElement(daftarKategoriMenu.get(i).getKategoriMenu());
        }
        
        list.setModel(mdl);
        kategoriMenu = null;
        idSelect = "";
        
        lblJumlah.setText(daftarKategoriMenu.size() +" Data Item   ");
    }
    
    private void baruKategori(){
        kategoriMenu = null;
        KategoriMenu kM = new KategoriMenuDialog().showDialog(kategoriMenu);
        if(kM!=null){
            boolean data = false;
            kategoriMenu = new KategoriMenu();
            kategoriMenu = kM;
            List<KategoriMenu> kategoriMenus = GirsangKafe.getMasterService().semuaKategoriMenu();
            for(int j=0;j<kategoriMenus.size();j++){
                if(kategoriMenus.get(j).getKategoriMenu()
                        .equals(kategoriMenu.getKategoriMenu())&&
                        (kategoriMenus.get(j).getId() == null ? kategoriMenu.getId() 
                        != null : !kategoriMenus.get(j).getId().equals(kategoriMenu.getId()))){
                    list.setSelectedIndex(j);
                    Notifikasi.pesanDataSudahAda();
                    data = true;
                }
            }
            if(data==false){
                GirsangKafe.getMasterService().simpan(kategoriMenu);
                tampilData();
            }
        }
    }
    private void editKategori(){
        cariJabatan();
        if(kategoriMenu==null){
                Notifikasi.pesanTidakAdaData();
            }else{
               KategoriMenu kM = new KategoriMenuDialog().showDialog(kategoriMenu);
                if(kM!=null){
                    boolean data = false;
                    kategoriMenu = kM;
                    List<KategoriMenu> kategoriMenus = GirsangKafe.getMasterService().semuaKategoriMenu();
            for(int j=0;j<kategoriMenus.size();j++){
                if(kategoriMenus.get(j).getKategoriMenu()
                        .equals(kategoriMenu.getKategoriMenu())&&
                        (kategoriMenus.get(j).getId() == null ? kategoriMenu.getId() 
                        != null : !kategoriMenus.get(j).getId().equals(kategoriMenu.getId()))){
                    list.setSelectedIndex(j);
                    Notifikasi.pesanDataSudahAda();
                    data = true;
                    }
                }
                    if(data==false){
                        GirsangKafe.getMasterService().simpan(kategoriMenu);
                        tampilData();
                    }
                }
            }
    }
    private void hapusKategori(){
        cariJabatan();
        if(kategoriMenu==null){
                Notifikasi.pesanTidakAdaData();
            }else{
                if(Notifikasi.pesanValidasiHapus()){
                    GirsangKafe.getMasterService().hapus(kategoriMenu);
                    tampilData();
                }
            }
    }
    private void addPopupmenu(){
        popup.add(new JMenuItem(new AbstractAction("Tambah Kategori Menu") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                baruKategori();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Edit Kategori Menu") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                editKategori();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Hapus Kategori Menu") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hapusKategori();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Refresh Tabel") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tampilData();
            }
        }));
    }
    private void initListener(){
        list.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(list.getSelectedIndex()>=0){
                
                idSelect = daftarKategoriMenu.get(list.getSelectedIndex()).getId();
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    JList source = (JList) e.getSource();
                    int row = source.locationToIndex(e.getPoint());

                    if (!source.isSelectedIndex(row)) {
                    source.setSelectedIndex(row);
                        System.out.println("Select " + row);
                    }

                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    editKategori();
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblJudul = new javax.swing.JLabel();
        lblKeterangan = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/GolonganBarang 63X63.png"))); // NOI18N

        lblJudul.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblJudul.setText("Daftar Jabatan");

        lblKeterangan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblKeterangan.setText("Disini anda bisa menambah, mengedit atau menghapus data jabatan");

        lblJumlah.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblJumlah.setText("jLabel4");

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Keluar 32.png"))); // NOI18N
        btnKeluar.setText("Tutup");
        btnKeluar.setFocusable(false);
        btnKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeluar.setMaximumSize(new java.awt.Dimension(55, 57));
        btnKeluar.setMinimumSize(new java.awt.Dimension(55, 57));
        btnKeluar.setPreferredSize(new java.awt.Dimension(55, 57));
        btnKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul)
                    .addComponent(lblKeterangan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJumlah)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJudul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKeterangan))
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(lblJumlah)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JList<String> list;
    // End of variables declaration//GEN-END:variables
}
