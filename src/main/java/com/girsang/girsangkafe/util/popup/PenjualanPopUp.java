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
import com.girsang.girsangkafe.UI.transaksi.MejaPanel;
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
public final class PenjualanPopUp extends AbstractButton{
    
    
    JButton actionButton;
    JPopupMenu popUpMenu;
    JMenu menuKaryawan;
    JMenu menuMenu;
    JTabbedPane TP;
    
    MejaPanel mejaPanel = new MejaPanel();
    
    
    public PenjualanPopUp(JTabbedPane TP, JPopupMenu popupMenuPenjualan, JButton btnPenjualan) {
        this.TP = TP;
        popupMenuPenjualan.add(new JMenuItem(new AbstractAction(PesanJO.namaMenu.DAFTAR_MEJA) {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (mejaPanel.getAktifPanel() == 1) {
                TP.setSelectedIndex(mejaPanel.getIndexTab());
                } else {
                mejaPanel = new MejaPanel();
                mejaPanel.setName(PesanJO.namaTab.MEJA);
                mejaPanel.setAktifPanel(mejaPanel.getAktifPanel() + 1);
                TP.addTab(mejaPanel.getName(), mejaPanel);
                mejaPanel.setIndexTab(TP.getTabCount() - 1);
                TP.setSelectedIndex(mejaPanel.getIndexTab());

                mejaPanel.getBtnTutup().addActionListener((ae1) -> {
                TP.remove(mejaPanel);
                mejaPanel.setAktifPanel(mejaPanel.getAktifPanel() - 1);
                TP.setSelectedIndex(mejaPanel.getIndexTab() -1);
                });
                }
            }
        }));
        btnPenjualan.addActionListener((ae) -> {
            popupMenuPenjualan.show(btnPenjualan, 0, btnPenjualan.getSize().height);
        });
    }
}
