/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.util.popup;

import com.girsang.girsangkafe.UI.master.NomorMejaPanel;
import com.girsang.girsangkafe.UI.master.karyawan.JabatanPanel;
import com.girsang.girsangkafe.UI.master.karyawan.KaryawanPanel;
import com.girsang.girsangkafe.UI.security.MenuAksesPanel;
import com.girsang.girsangkafe.UI.menu.BahanBakuPanel;
import com.girsang.girsangkafe.UI.menu.KategoriMenuPanel;
import com.girsang.girsangkafe.UI.menu.MenuPanel;
import com.girsang.girsangkafe.util.PesanJO;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

/**
 *
 * @author User
 */
public final class MasterPopUp extends AbstractButton{
    
    
    JButton actionButton;
    JPopupMenu popUpMenu;
    JMenu menuKaryawan;
    JMenu menuMenu;
    JTabbedPane TP;
    
    MenuAksesPanel menuAksesPanel = new MenuAksesPanel();
    JabatanPanel jabatanPanel = new JabatanPanel();
    KaryawanPanel karyawanPanel = new KaryawanPanel();
    KategoriMenuPanel kategoriMenuPanel = new KategoriMenuPanel();
    NomorMejaPanel nomorMejaPanel = new NomorMejaPanel();
    BahanBakuPanel bahanBakuPanel = new BahanBakuPanel();
    MenuPanel menuPanel = new MenuPanel();
    
    
    public MasterPopUp(JTabbedPane TP, JPopupMenu popupMenuMaster, JButton btnMaster) {
        this.TP = TP;
        popupMenuMaster.add(menuKaryawan());
        popupMenuMaster.add(menuMenu());
        popupMenuMaster.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.MENUAKSES) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (menuAksesPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(menuAksesPanel.getIndexTab());
                } else {
                menuAksesPanel = new MenuAksesPanel();
                menuAksesPanel.setName(PesanJO.namaTab.KELOMPOK_MENU);
                menuAksesPanel.setAktifPanel(menuAksesPanel.getAktifPanel() + 1);
                TP.addTab(menuAksesPanel.getName(), menuAksesPanel);
                menuAksesPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(menuAksesPanel.getIndexTab());

                menuAksesPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(menuAksesPanel);
                menuAksesPanel.setAktifPanel(menuAksesPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(menuAksesPanel.getIndexTab() -1);
                });
                }
            }
        }));
        popupMenuMaster.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.MEJA) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (nomorMejaPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(nomorMejaPanel.getIndexTab());
                } else {
                nomorMejaPanel = new NomorMejaPanel();
                nomorMejaPanel.setName(PesanJO.namaTab.MEJA);
                nomorMejaPanel.setAktifPanel(nomorMejaPanel.getAktifPanel() + 1);
                TP.addTab(nomorMejaPanel.getName(), nomorMejaPanel);
                nomorMejaPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(nomorMejaPanel.getIndexTab());

                nomorMejaPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(nomorMejaPanel);
                nomorMejaPanel.setAktifPanel(nomorMejaPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(nomorMejaPanel.getIndexTab() -1);
                });
                }
            }
        }));
        btnMaster.addActionListener((ae) -> {
            popupMenuMaster.show(btnMaster, 0, btnMaster.getSize().height);
        });
    }
    public JMenuItem menuKaryawan(){
        menuKaryawan = new JMenu(PesanJO.namaMenu.DATA_KARYAWAN);
        menuKaryawan.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.JABATAN) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (jabatanPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(jabatanPanel.getIndexTab());
                } else {
                jabatanPanel = new JabatanPanel();
                jabatanPanel.setName(PesanJO.namaTab.JABATAN);
                jabatanPanel.setAktifPanel(jabatanPanel.getAktifPanel() + 1);
                TP.addTab(jabatanPanel.getName(), jabatanPanel);
                jabatanPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(jabatanPanel.getIndexTab());

                jabatanPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(jabatanPanel);
                jabatanPanel.setAktifPanel(jabatanPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(jabatanPanel.getIndexTab() -1);
                });
                }
            }
        }));
        menuKaryawan.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.KARYAWAN) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (karyawanPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(karyawanPanel.getIndexTab());
                } else {
                karyawanPanel = new KaryawanPanel();
                karyawanPanel.setName(PesanJO.namaTab.KARYAWAN);
                karyawanPanel.setAktifPanel(karyawanPanel.getAktifPanel() + 1);
                TP.addTab(karyawanPanel.getName(), karyawanPanel);
                karyawanPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(karyawanPanel.getIndexTab());

                karyawanPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(karyawanPanel);
                karyawanPanel.setAktifPanel(karyawanPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(karyawanPanel.getIndexTab() -1);
                });
                }
            }
        }));
        return menuKaryawan;
    }
    public JMenuItem menuMenu(){
        menuMenu = new JMenu(PesanJO.namaMenu.DATA_MENU);
        menuMenu.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.KATEGORI_MENU) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (kategoriMenuPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(kategoriMenuPanel.getIndexTab());
                } else {
                kategoriMenuPanel = new KategoriMenuPanel();
                kategoriMenuPanel.setName(PesanJO.namaTab.KATEGORI_MENU);
                kategoriMenuPanel.setAktifPanel(kategoriMenuPanel.getAktifPanel() + 1);
                TP.addTab(kategoriMenuPanel.getName(), kategoriMenuPanel);
                kategoriMenuPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(kategoriMenuPanel.getIndexTab());

                kategoriMenuPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(kategoriMenuPanel);
                kategoriMenuPanel.setAktifPanel(kategoriMenuPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(kategoriMenuPanel.getIndexTab() -1);
                });
                }
            }
        }));
        menuMenu.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.MENU) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (menuPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(menuPanel.getIndexTab());
                } else {
                menuPanel = new MenuPanel();
                menuPanel.setName(PesanJO.namaTab.MENU);
                menuPanel.setAktifPanel(menuPanel.getAktifPanel() + 1);
                TP.addTab(menuPanel.getName(), menuPanel);
                menuPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(menuPanel.getIndexTab());

                menuPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(menuPanel);
                menuPanel.setAktifPanel(menuPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(menuPanel.getIndexTab() -1);
                });
                }
            }
        }));
        menuMenu.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.BAHANBAKU) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (bahanBakuPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(bahanBakuPanel.getIndexTab());
                } else {
                bahanBakuPanel = new BahanBakuPanel();
                bahanBakuPanel.setName(PesanJO.namaTab.BAHANBAKU);
                bahanBakuPanel.setAktifPanel(bahanBakuPanel.getAktifPanel() + 1);
                TP.addTab(bahanBakuPanel.getName(), bahanBakuPanel);
                bahanBakuPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(bahanBakuPanel.getIndexTab());

                bahanBakuPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(bahanBakuPanel);
                bahanBakuPanel.setAktifPanel(bahanBakuPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(bahanBakuPanel.getIndexTab() -1);
                });
                }
            }
        }));
        return menuMenu;
    }
}
