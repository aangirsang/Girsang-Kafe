package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.Jabatan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelJabatan extends AbstractTableModel{

    List<Jabatan> daftarJabatan;
    
    public TabelModelJabatan(List<Jabatan> list){
        this.daftarJabatan=list;
    }
    @Override
    public int getRowCount() {
        return daftarJabatan.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case (0):return "ID";
            case (1):return "Jabatan";
            default:return"";
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        Jabatan j = daftarJabatan.get(row);
        switch(col){
            case (0):return j.getId();
            case (1):return j.getJabatan();
            default:return"";
        }
    }
    
}
