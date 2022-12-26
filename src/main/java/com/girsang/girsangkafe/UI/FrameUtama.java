package com.girsang.girsangkafe.UI;

import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.model.master.Karyawan;
import com.girsang.girsangkafe.util.popup.MasterPopUp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class FrameUtama extends javax.swing.JFrame {

    private static FrameUtama instance;
    private Karyawan karyawan;
    
    public static FrameUtama getInstance() {
        return instance;
    }
    public JPanel getPanelToolbar() {
        return panelToolbar;
    }
    public FrameUtama() {
        initComponents();
        initListener();
        setTitle("Aplikasi Kafe");
        clear();
        panelToolbar.setVisible(true);
        tabbedPane.setSelectedIndex(1);
        setFocusableWindowState(true);
        tampil();
    }
    
    private void tampil() {
    JPopupMenu popUpMenuMaster = new JPopupMenu();
    /*JPopupMenu popUpMenuPemasukan = new JPopupMenu();
    JPopupMenu popUpMenuPengeluaran = new JPopupMenu();
    JPopupMenu popUpPribadi = new JPopupMenu();
    JPopupMenu popUpReport = new JPopupMenu();*/
    MasterPopUp master = new MasterPopUp(tabbedPane, popUpMenuMaster, btnMaster);
    /*PemasukanPopUp pemasukanPopUp = new PemasukanPopUp(tabbedPane, popUpMenuPemasukan, btnPemasukan);
    PengeluaranPopUp pengeluaranPopUp = new PengeluaranPopUp(tabbedPane, popUpMenuPengeluaran, btnPengeluaran);
    ReportPopUp reportPopUp = new ReportPopUp(tabbedPane, popUpReport, btnReport);
    PribadiPopUp pribadiPopUp = new PribadiPopUp(tabbedPane, popUpPribadi, btnPribadi);
    */}
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
    public void jam() {
        Thread t = new Thread(() -> {
            while (true) {
                lblJam.setText(new SimpleDateFormat(
                        "EEE, MMM dd yyyy HH:mm:ss")
                        .format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        t.start();
    }
    private void clear() {
        txtUsername.setText("admin");
        txtPass.setText("admin");
    }
    private Karyawan login() {
        Karyawan k = GirsangKafe.getMasterService().cariNamaAkun(txtUsername.getText());
        if (k == null) {
        JOptionPane.showMessageDialog(this, "Username " + txtUsername.getText() + " Tidak Terdaftar");
        txtUsername.requestFocus();
        } else {
        if (!k.getPassword().equals(txtPass.getText())) {
        JOptionPane.showMessageDialog(this,
        "Username dan Password Tidak Cocok");
        txtPass.requestFocus();
        } else {
        karyawan = k;
        }
        }
        return karyawan;
    }
    private void initListener() {
        //<editor-fold defaultstate="collapsed" desc="close Windows">
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Ya", "Tidak"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Apakah Anda Yakin Ingin Menutup Aplikasi Ini?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });//</editor-fold>
        btnKeluar.addActionListener((ae) -> {
            String ObjButtons[] = {"Ya", "Tidak"};
            int PromptResult = JOptionPane.showOptionDialog(null,
                    "Apakah Anda Yakin Ingin Menutup Aplikasi Ini?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, ObjButtons, ObjButtons[1]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        btnBatal.addActionListener((ae) -> {
            System.exit(0);
        });
        btnLogin.addActionListener((ae) -> {
            login();
            if (karyawan != null) {
            tampil();
            panelToolbar.setVisible(true);
            lblUser.setText(karyawan.getNamaLengkap());
            tabbedPane.remove(loginPanel);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelHome = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblJam = new javax.swing.JLabel();
        panelToolbar = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnMaster = new javax.swing.JButton();
        btnPemasukan = new javax.swing.JButton();
        btnPengeluaran = new javax.swing.JButton();
        btnPribadi = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Home", panelHome);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        txtUsername.setText("jTextField1");

        txtPass.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLogin.setText("Login");

        btnBatal.setText("Batal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Login", loginPanel);

        lblUser.setText("USER");

        lblJam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJam.setText("USER");

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Master32.png"))); // NOI18N
        btnMaster.setText(" Master ");
        btnMaster.setFocusable(false);
        btnMaster.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMaster.setMaximumSize(new java.awt.Dimension(65, 60));
        btnMaster.setMinimumSize(new java.awt.Dimension(51, 60));
        btnMaster.setPreferredSize(new java.awt.Dimension(65, 65));
        btnMaster.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnMaster);

        btnPemasukan.setText(" Pemasukan ");
        btnPemasukan.setFocusable(false);
        btnPemasukan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPemasukan.setPreferredSize(new java.awt.Dimension(55, 65));
        btnPemasukan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPemasukan);

        btnPengeluaran.setText(" Pengeluaran ");
        btnPengeluaran.setFocusable(false);
        btnPengeluaran.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPengeluaran.setPreferredSize(new java.awt.Dimension(55, 65));
        btnPengeluaran.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPengeluaran);

        btnPribadi.setText(" Pribadi ");
        btnPribadi.setFocusable(false);
        btnPribadi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPribadi.setPreferredSize(new java.awt.Dimension(55, 65));
        btnPribadi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPribadi);

        btnReport.setText(" Laporan ");
        btnReport.setFocusable(false);
        btnReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReport.setPreferredSize(new java.awt.Dimension(55, 65));
        btnReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnReport);

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Keluar 32.png"))); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.setFocusable(false);
        btnKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeluar.setMaximumSize(new java.awt.Dimension(51, 57));
        btnKeluar.setMinimumSize(new java.awt.Dimension(51, 57));
        btnKeluar.setPreferredSize(new java.awt.Dimension(55, 65));
        btnKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btnKeluar);

        javax.swing.GroupLayout panelToolbarLayout = new javax.swing.GroupLayout(panelToolbar);
        panelToolbar.setLayout(panelToolbarLayout);
        panelToolbarLayout.setHorizontalGroup(
            panelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToolbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelToolbarLayout.setVerticalGroup(
            panelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToolbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelToolbarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jToolBar1, jToolBar3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblJam, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJam)
                    .addComponent(lblUser))
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMaster;
    private javax.swing.JButton btnPemasukan;
    private javax.swing.JButton btnPengeluaran;
    private javax.swing.JButton btnPribadi;
    private javax.swing.JButton btnReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelToolbar;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
