package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.MenuAkses;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelMenuAkses extends AbstractTableModel{

    List<MenuAkses> daftarMenuAkses;
    
    public TabelModelMenuAkses(List<MenuAkses> list){
        this.daftarMenuAkses=list;
    }
    @Override
    public int getRowCount() {
        return daftarMenuAkses.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case (0):return "ID";
            case (1):return "Menu Akses";
            default:return"";
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        MenuAkses mA = daftarMenuAkses.get(row);
        switch(col){
            case (0):return mA.getId();
            case (1):return mA.getMenuAkses();
            default:return"";
        }
    }
    
}
