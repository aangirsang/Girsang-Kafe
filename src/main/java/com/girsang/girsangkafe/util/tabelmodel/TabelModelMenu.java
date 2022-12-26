package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.Menu;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelMenu extends AbstractTableModel{

    List<Menu> daftarMenu;
    
    public TabelModelMenu(List<Menu> list){
        this.daftarMenu=list;
    }
    @Override
    public int getRowCount() {
        return daftarMenu.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case (0):return "ID";
            case (1):return "Menu";
            case (2):return "Kategori Menu";
            case (3):return "Harga";
            default:return"";
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        Menu m = daftarMenu.get(row);
        return switch (col) {
            case 0 -> m.getId();
            case 1 -> m.getNamaMenu();
            case 2 -> m.getKategoriMenu().getKategoriMenu();
            case 3 -> m.getHarga();
            default -> "";
        };
    }
    
    @Override
        public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 3 -> BigDecimal.class;
            default -> String.class;
        };
        }
    
}
