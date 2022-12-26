package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.NomorMeja;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelNomorMeja extends AbstractTableModel{

    List<NomorMeja> daftarNomorMeja;
    
    public TabelModelNomorMeja(List<NomorMeja> list){
        this.daftarNomorMeja=list;
    }
    @Override
    public int getRowCount() {
        return daftarNomorMeja.size();
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
        NomorMeja nM = daftarNomorMeja.get(row);
        switch(col){
            case (0):return nM.getId();
            case (1):return nM.getNomorMeja();
            default:return"";
        }
    }
    
}
