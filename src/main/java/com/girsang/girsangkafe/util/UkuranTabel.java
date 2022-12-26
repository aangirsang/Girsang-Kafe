package com.girsang.girsangkafe.util;

import javax.swing.JTable;

public class UkuranTabel extends JTable{

    JTable tabel = new JTable();

    public JTable UkuranTabelMenuAkses(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);//Menu Akses
        return tabel;
    }
    public JTable UkuranTabelJabatan(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);//Jabatan
        return tabel;
    }
    public JTable UkuranTabelKategoriMenu(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);//Jabatan
        return tabel;
    }
    public JTable UkuranTabelBahanBaku(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(300);//Bahan Baku
        tabel.getColumnModel().getColumn(2).setPreferredWidth(100);//Stok
        return tabel;
    }
    public JTable UkuranTabelNomorMeja(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);//Jabatan
        return tabel;
    }
    public JTable UkuranTabelKaryawan(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);//Nama Lengkap
        tabel.getColumnModel().getColumn(2).setPreferredWidth(200);//Tempat Lahir
        tabel.getColumnModel().getColumn(3).setPreferredWidth(200);//Tanggal Lahir
        tabel.getColumnModel().getColumn(4).setPreferredWidth(200);//Alamat
        tabel.getColumnModel().getColumn(5).setPreferredWidth(200);//Pendidikan Terakhir
        tabel.getColumnModel().getColumn(6).setPreferredWidth(200);//Jabatan
        tabel.getColumnModel().getColumn(7).setPreferredWidth(200);//Tanggal Mulai Kerja
        tabel.getColumnModel().getColumn(8).setPreferredWidth(200);//Nama Akun
        return tabel;
    }
       public JTable UkuranTabelMenu(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(600);//Menu
        tabel.getColumnModel().getColumn(2).setPreferredWidth(300);//Kategori Menu
        tabel.getColumnModel().getColumn(3).setPreferredWidth(100);//Harga
        return tabel;
    }
    public JTable UkuranTabelMenuDetail(JTable tabel) {
        this.tabel = tabel;
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(200);//Bahan Baku
        tabel.getColumnModel().getColumn(2).setPreferredWidth(100);//Satuan Pakai
        tabel.getColumnModel().getColumn(3).setPreferredWidth(70);//Jumlah
        return tabel;
    }
}
