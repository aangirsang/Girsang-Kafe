package com.girsang.girsangkafe.UI.master;


import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.UI.menu.KategoriMenuDialog;
import com.girsang.girsangkafe.model.master.Meja;
import com.girsang.girsangkafe.util.Notifikasi;
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
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;

public class NomorMejaPanel extends javax.swing.JPanel {

    Meja nomorMeja;
    List<Meja> daftarNomorMeja;
    private String idSelect;
    private JPopupMenu popup = new JPopupMenu();
    
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
        txtCari.setText("");
        daftarNomorMeja = GirsangKafe.getMasterService().semuaNomorMeja();
        tabel.setModel(new TabelModelNomorMeja(daftarNomorMeja));
        tabel = new UkuranTabel().UkuranTabelNomorMeja(tabel);
        tabel.clearSelection();
        
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
            List<Meja> list = GirsangKafe.getMasterService().semuaNomorMeja();
            for(int j=0;j<list.size();j++){
                if(list.get(j).getNomorMeja()
                        .equals(nomorMeja.getNomorMeja())&&
                        (list.get(j).getId() == null ? nomorMeja.getId() 
                        != null : !list.get(j).getId().equals(nomorMeja.getId()))){
                    tabel.setRowSelectionInterval(j, j);
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
                    List<Meja> list = GirsangKafe.getMasterService().semuaNomorMeja();
            for(int j=0;j<list.size();j++){
                if(list.get(j).getNomorMeja()
                        .equals(nomorMeja.getNomorMeja())&&
                        (list.get(j).getId() == null ? nomorMeja.getId() 
                        != null : !list.get(j).getId().equals(nomorMeja.getId()))){
                    tabel.setRowSelectionInterval(j, j);
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
        tabel.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if(tabel.getSelectedRow()>=0){
                idSelect = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
            }
        });
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    JTable source = (JTable) e.getSource();
                    int row = source.rowAtPoint(e.getPoint());
                    int column = source.columnAtPoint(e.getPoint());

                    if (!source.isRowSelected(row)) {
                        source.changeSelection(row, column, false, false);
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
        txtCari.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if ("".equals(txtCari.getText())) {
                    tampilData();
                } else {
                    daftarNomorMeja = GirsangKafe.getMasterService()
                            .nomorMejaBerdasaranNama(txtCari.getText());
                    tabel.setModel(new TabelModelNomorMeja(daftarNomorMeja));
                    tabel = new UkuranTabel().UkuranTabelNomorMeja(tabel);
                }
            }
        });
        btnBaru.addActionListener((al) ->{
            baruJabatan();
        });
        btnEdit.addActionListener((ae)->{
            editJabatan();
        });
        btnHapus.addActionListener((al)->{
            hapusJabatan();
        });
        btnRefresh.addActionListener((al)->{
            tampilData();
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblJudul = new javax.swing.JLabel();
        lblKeterangan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        lblJumlah = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        btnBaru = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnRefresh = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnKeluar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        txtCari = new javax.swing.JTextField();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/GolonganBarang 63X63.png"))); // NOI18N

        lblJudul.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblJudul.setText("Daftar Jabatan");

        lblKeterangan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblKeterangan.setText("Disini anda bisa menambah, mengedit atau menghapus data jabatan");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabel.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tabel);

        lblJumlah.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblJumlah.setText("jLabel4");

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        btnBaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/btnBaru 32.png"))); // NOI18N
        btnBaru.setText("Baru");
        btnBaru.setFocusable(false);
        btnBaru.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBaru.setMaximumSize(new java.awt.Dimension(55, 57));
        btnBaru.setMinimumSize(new java.awt.Dimension(55, 57));
        btnBaru.setPreferredSize(new java.awt.Dimension(55, 57));
        btnBaru.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnBaru);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/btnEdit 32.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setMaximumSize(new java.awt.Dimension(55, 57));
        btnEdit.setMinimumSize(new java.awt.Dimension(55, 57));
        btnEdit.setPreferredSize(new java.awt.Dimension(55, 57));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnEdit);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/btnHapus 32.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setFocusable(false);
        btnHapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapus.setMaximumSize(new java.awt.Dimension(55, 57));
        btnHapus.setMinimumSize(new java.awt.Dimension(55, 57));
        btnHapus.setPreferredSize(new java.awt.Dimension(55, 57));
        btnHapus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHapus);
        toolBar.add(jSeparator1);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/btnRefresh 32.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setMaximumSize(new java.awt.Dimension(55, 57));
        btnRefresh.setMinimumSize(new java.awt.Dimension(55, 57));
        btnRefresh.setPreferredSize(new java.awt.Dimension(55, 57));
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnRefresh);
        toolBar.add(jSeparator2);

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Keluar 32.png"))); // NOI18N
        btnKeluar.setText("Tutup");
        btnKeluar.setFocusable(false);
        btnKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeluar.setMaximumSize(new java.awt.Dimension(55, 57));
        btnKeluar.setMinimumSize(new java.awt.Dimension(55, 57));
        btnKeluar.setPreferredSize(new java.awt.Dimension(55, 57));
        btnKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnKeluar);

        jToolBar1.setFloatable(false);

        txtCari.setText("jTextField1");
        txtCari.setAutoscrolls(false);
        txtCari.setMaximumSize(new java.awt.Dimension(200, 25));
        txtCari.setMinimumSize(new java.awt.Dimension(200, 25));
        txtCari.setPreferredSize(new java.awt.Dimension(200, 25));
        jToolBar1.add(txtCari);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
                            .addComponent(lblKeterangan)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblJumlah)))
                .addGap(441, 441, 441))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(lblKeterangan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JTable tabel;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
