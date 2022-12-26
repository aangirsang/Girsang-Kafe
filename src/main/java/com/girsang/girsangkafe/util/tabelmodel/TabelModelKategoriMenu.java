package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.KategoriMenu;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelKategoriMenu extends AbstractTableModel{

    List<KategoriMenu> daftarKategoriMenu;
    
    public TabelModelKategoriMenu(List<KategoriMenu> list){
        this.daftarKategoriMenu=list;
    }
    @Override
    public int getRowCount() {
        return daftarKategoriMenu.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case (0):return "ID";
            case (1):return "Kategori Menu";
            default:return"";
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        KategoriMenu j = daftarKategoriMenu.get(row);
        switch(col){
            case (0):return j.getId();
            case (1):return j.getKategoriMenu();
            default:return"";
        }
    }
    
}
