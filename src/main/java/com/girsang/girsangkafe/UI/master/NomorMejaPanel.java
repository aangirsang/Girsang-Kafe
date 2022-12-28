package com.girsang.girsangkafe.UI.master;


import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.UI.menu.KategoriMenuDialog;
import com.girsang.girsangkafe.model.master.Meja;
import com.girsang.girsangkafe.util.Notifikasi;
import com.girsang.girsangkafe.util.PesanJO;
import com.girsang.girsangkafe.util.UkuranTabel;
import com.girsang.girsangkafe.util.tabelmodel.TabelModelKategoriMenu;
import com.girsang.girsangkafe.util.tabelmodel.TabelModelNomorMeja;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;

public class NomorMejaPanel extends javax.swing.JPanel {

    Meja nomorMeja;
    List<Meja> daftarNomorMeja;
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
    public NomorMejaPanel() {
        initComponents();
        initListener();
        tampilData();
        addPopupmenu();
    }
    private void cariJabatan(){
        if (!idSelect.equals("")) {
            nomorMeja = new Meja();
            nomorMeja = GirsangKafe.getMasterService().nomorMejaBerdasarkanId(idSelect);
        } else {
            nomorMeja = null;
        }
    }
    private void tampilData(){
        daftarNomorMeja = GirsangKafe.getMasterService().semuaNomorMeja();
        mdl.removeAllElements();
        
        for (int i=0;i<daftarNomorMeja.size();i++){
            mdl.addElement(daftarNomorMeja.get(i).getNomorMeja());
        }
        list.setModel(mdl);
        
        nomorMeja = null;
        idSelect = "";
        
        lblJumlah.setText(daftarNomorMeja.size() +" Data Item   ");
    }
    
    private void baruJabatan(){
        nomorMeja = null;
        Meja nM = new NomorMejaDialog().showDialog(nomorMeja);
        if(nM!=null){
            boolean data = false;
            nomorMeja = new Meja();
            nomorMeja = nM;
            List<Meja> listMeja = GirsangKafe.getMasterService().semuaNomorMeja();
            for(int j=0;j<listMeja.size();j++){
                if(listMeja.get(j).getNomorMeja()
                        .equals(nomorMeja.getNomorMeja())&&
                        (listMeja.get(j).getId() == null ? nomorMeja.getId() 
                        != null : !listMeja.get(j).getId().equals(nomorMeja.getId()))){
                    list.setSelectedIndex(j);
                    Notifikasi.pesanDataSudahAda();
                    data = true;
                }
            }
            if(data==false){
                GirsangKafe.getMasterService().simpan(nomorMeja);
                tampilData();
            }
        }
    }
    private void editJabatan(){
        cariJabatan();
        if(nomorMeja==null){
                Notifikasi.pesanTidakAdaData();
            }else{
               Meja kM = new NomorMejaDialog().showDialog(nomorMeja);
                if(kM!=null){
                    boolean data = false;
                    nomorMeja = kM;
                    List<Meja> listMeja = GirsangKafe.getMasterService().semuaNomorMeja();
            for(int j=0;j<listMeja.size();j++){
                if(listMeja.get(j).getNomorMeja()
                        .equals(nomorMeja.getNomorMeja())&&
                        (listMeja.get(j).getId() == null ? nomorMeja.getId() 
                        != null : !listMeja.get(j).getId().equals(nomorMeja.getId()))){
                    list.setSelectedIndex(j);
                    Notifikasi.pesanDataSudahAda();
                    data = true;
                    }
                }
                    if(data==false){
                        GirsangKafe.getMasterService().simpan(nomorMeja);
                        tampilData();
                    }
                }
            }
    }
    private void hapusJabatan(){
        cariJabatan();
        if(nomorMeja==null){
                Notifikasi.pesanTidakAdaData();
            }else{
                if(Notifikasi.pesanValidasiHapus()){
                    GirsangKafe.getMasterService().hapus(nomorMeja);
                    tampilData();
                }
            }
    }
    private void addPopupmenu(){
        popup.add(new JMenuItem(new AbstractAction("Tambah Otomatis Meja") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(Notifikasi.pesanValidasiHapusALL()){
                    daftarNomorMeja = GirsangKafe.getMasterService().semuaNomorMeja();
                    int jumlahMeja = new AutoNomorMejaDialog().showDialog();
                    String meja ,nol = "", jM;
                    int digitMeja = 0,digitPakai = 0;
                    if(jumlahMeja>0){
                        for (int i=0;i<daftarNomorMeja.size();i++){
                            nomorMeja = daftarNomorMeja.get(i);
                            GirsangKafe.getMasterService().hapus(nomorMeja);
                        }
                    }
                    
                    digitMeja = (String.valueOf(jumlahMeja)).length();
                    for(int jm=1;jm<=jumlahMeja;jm++){
                        digitPakai = digitMeja - (String.valueOf(jm)).length();

                        switch(digitPakai){
                            case 4:
                                nol="0000";
                                break;
                            case 3:
                                nol="000";
                                break;
                            case 2:
                                nol="00";
                                break;
                            case 1:
                                nol="0";
                                break;
                            default:
                                nol="";
                        }
                        System.out.println("Nomor Meja "+nol+jm);   
                        nomorMeja = new Meja();
                        nomorMeja.setNomorMeja("Meja "+nol+jm);
                        
                        GirsangKafe.getMasterService().simpan(nomorMeja);
                    }
                    tampilData();
                }
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Tambah Meja") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                baruJabatan();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Edit Meja") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                editJabatan();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Hapus Meja") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hapusJabatan();
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
                
                idSelect = daftarNomorMeja.get(list.getSelectedIndex()).getId();
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
                    editJabatan();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnKeluar = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/GolonganBarang 63X63.png"))); // NOI18N

        lblJudul.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblJudul.setText("Daftar Jabatan");

        lblKeterangan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblKeterangan.setText("Disini anda bisa menambah, mengedit atau menghapus data jabatan");

        lblJumlah.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblJumlah.setText("jLabel4");

        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list);

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Keluar 32.png"))); // NOI18N
        btnKeluar.setText("Tutup");
        btnKeluar.setFocusable(false);
        btnKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeluar.setMaximumSize(new java.awt.Dimension(55, 57));
        btnKeluar.setMinimumSize(new java.awt.Dimension(55, 57));
        btnKeluar.setPreferredSize(new java.awt.Dimension(55, 57));
        btnKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJudul)
                            .addComponent(lblKeterangan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblJumlah))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 270, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
