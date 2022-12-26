package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.Karyawan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelKaryawan extends AbstractTableModel{

    List<Karyawan> daftarKaryawan;
    
    public TabelModelKaryawan(List<Karyawan> list){
        this.daftarKaryawan=list;
    }
    @Override
    public int getRowCount() {
        return daftarKaryawan.size();
    }
    
    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case (0):return "ID";
            case (1):return "Nama Lengkap";
            case (2):return "Tampat Lahir";
            case (3):return "Tanggal Lahir";
            case (4):return "Alamat";
            case (5):return "Pendidikan Terakhir";
            case (6):return "Jabatan";
            case (7):return "Tanggal Mulai Kerja";
            case (8):return "Nama Akun";
            default:return"";
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        Karyawan k = daftarKaryawan.get(row);
        switch(col){
            case (0):return k.getId();
            case (1):return k.getNamaLengkap();
            case (2):return k.getTempatLahir();
            case (3):return k.getTanggalLahir();
            case (4):return k.getAlamat();
            case (5):return k.getTamatanTerakhir();
            case (6): 
                    if (k.getJabatan() != null){
                        return   k.getJabatan().getJabatan();
                    }else {
                        return "";
                    }
            case (7):return k.getTanggalMulaiKerja();
            case (8):return k.getNamaAkun();
            default:return"";
        }
    }
    
}
