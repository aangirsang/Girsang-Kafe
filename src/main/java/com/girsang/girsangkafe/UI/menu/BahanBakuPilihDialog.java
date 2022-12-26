package com.girsang.girsangkafe.UI.menu;

import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.UI.FrameUtama;
import com.girsang.girsangkafe.model.master.BahanBaku;
import com.girsang.girsangkafe.util.Notifikasi;
import com.girsang.girsangkafe.util.PesanJO;
import com.girsang.girsangkafe.util.UkuranTabel;
import com.girsang.girsangkafe.util.tabelmodel.TabelModelBahanBaku;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;

public class BahanBakuPilihDialog extends javax.swing.JDialog {

    BahanBaku bahanBaku;
    List<BahanBaku> daftarBahanBaku;
    private String idSelect;
    private JPopupMenu popup = new JPopupMenu();
    public BahanBakuPilihDialog() {
        super(FrameUtama.getInstance(), true);
        initComponents();
        initListener();
    }
    public Object showDialog(){
        setTitle(PesanJO.namaDialog.BAHANABAKU_PILIH);
        tampilData();
        addPopupmenu();
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        return bahanBaku;
    }
    private void cariBahanBaku(){
        if (!idSelect.equals("")) {
            bahanBaku = new BahanBaku();
            bahanBaku = GirsangKafe.getMasterService().bahanBakuBerdasarkanId(idSelect);
        } else {
            bahanBaku = null;
        }
    }
    private void tampilData(){
        txtCari.setText("");
        daftarBahanBaku = GirsangKafe.getMasterService().semuaBahanBaku();
        tabel.setModel(new TabelModelBahanBaku(daftarBahanBaku));
        tabel = new UkuranTabel().UkuranTabelBahanBaku(tabel);
        tabel.clearSelection();
        
        bahanBaku = null;
        idSelect = "";
        
        lblJumlah.setText(daftarBahanBaku.size() +" Data Item   ");
    }
    private void baruBahanBaku(){
        bahanBaku = null;
        BahanBaku bB = new BahanBakuDialog().showDialog(bahanBaku);
        if(bB!=null){
            boolean data = false;
            bahanBaku = new BahanBaku();
            bahanBaku = bB;
            List<BahanBaku> kategoriMenus = GirsangKafe.getMasterService().semuaBahanBaku();
            for(int j=0;j<kategoriMenus.size();j++){
                if(kategoriMenus.get(j).getNamaBahanBaku()
                        .equals(bahanBaku.getNamaBahanBaku())&&
                        (kategoriMenus.get(j).getId() == null ? bahanBaku.getId() 
                        != null : !kategoriMenus.get(j).getId().equals(bahanBaku.getId()))){
                    tabel.setRowSelectionInterval(j, j);
                    Notifikasi.pesanDataSudahAda();
                    data = true;
                }
            }
            if(data==false){
                GirsangKafe.getMasterService().simpan(bahanBaku);
                tampilData();
            }
        }
    }
    private void editBahanBaku(){
        cariBahanBaku();
        if(bahanBaku==null){
                Notifikasi.pesanTidakAdaData();
            }else{
               BahanBaku bB = new BahanBakuDialog().showDialog(bahanBaku);
                if(bB!=null){
                    boolean data = false;
                    bahanBaku = bB;
                    List<BahanBaku> bahanBakus = GirsangKafe.getMasterService().semuaBahanBaku();
            for(int j=0;j<bahanBakus.size();j++){
                if(bahanBakus.get(j).getNamaBahanBaku()
                        .equals(bahanBaku.getNamaBahanBaku())&&
                        (bahanBakus.get(j).getId() == null ? bahanBaku.getId() 
                        != null : !bahanBakus.get(j).getId().equals(bahanBaku.getId()))){
                    tabel.setRowSelectionInterval(j, j);
                    Notifikasi.pesanDataSudahAda();
                    data = true;
                    }
                }
                    if(data==false){
                        GirsangKafe.getMasterService().simpan(bahanBaku);
                        tampilData();
                    }
                }
            }
    }
    private void hapusBahanBaku(){
        cariBahanBaku();
        if(bahanBaku==null){
                Notifikasi.pesanTidakAdaData();
            }else{
                if(Notifikasi.pesanValidasiHapus()){
                    GirsangKafe.getMasterService().hapus(bahanBaku);
                    tampilData();
                }
            }
    }
    private void pilihBahanBaku(){
        cariBahanBaku();
        if(bahanBaku==null){
            Notifikasi.pesanTidakAdaData();
        }else{
            cariBahanBaku();
            dispose();
        }
    }
            
    private void addPopupmenu(){
        popup.add(new JMenuItem(new AbstractAction("Tambah Kategori Menu") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                baruBahanBaku();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Edit Kategori Menu") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                editBahanBaku();
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Hapus Kategori Menu") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hapusBahanBaku();
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
                    editBahanBaku();
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
                    daftarBahanBaku = GirsangKafe.getMasterService()
                            .bahanBakuBerdasaranNama(txtCari.getText());
                    tabel.setModel(new TabelModelBahanBaku(daftarBahanBaku));
                    tabel = new UkuranTabel().UkuranTabelKategoriMenu(tabel);
                }
            }
        });
        btnPilih.addActionListener((al) ->{
            pilihBahanBaku();
        });
        btnBaru.addActionListener((al) ->{
            baruBahanBaku();
        });
        btnEdit.addActionListener((ae)->{
            editBahanBaku();
        });
        btnHapus.addActionListener((al)->{
            hapusBahanBaku();
        });
        btnRefresh.addActionListener((al)->{
            tampilData();
        });
        btnKeluar.addActionListener((al)->{
            dispose();
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        btnPilih = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnBaru = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnRefresh = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnKeluar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        lblJumlah = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        btnPilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/btnPilih 32.png"))); // NOI18N
        btnPilih.setText("Pilih");
        btnPilih.setFocusable(false);
        btnPilih.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPilih.setMaximumSize(new java.awt.Dimension(55, 57));
        btnPilih.setMinimumSize(new java.awt.Dimension(55, 57));
        btnPilih.setPreferredSize(new java.awt.Dimension(55, 57));
        btnPilih.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnPilih);
        toolBar.add(jSeparator3);

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
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblJumlah)
                        .addGap(431, 431, 431))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJumlah)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPilih;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JTable tabel;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
