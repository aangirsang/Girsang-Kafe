package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.BahanBaku;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelBahanBaku extends AbstractTableModel{

    List<BahanBaku> daftarBahanBaku;
    
    public TabelModelBahanBaku(List<BahanBaku> list){
        this.daftarBahanBaku=list;
    }
    @Override
    public int getRowCount() {
        return daftarBahanBaku.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case (0):return "ID";
            case (1):return "Bahan Baku";
            case (2):return "Stok";
            case (3):return "Satuan";
            default:return"";
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        BahanBaku j = daftarBahanBaku.get(row);
        switch(col){
            case (0):return j.getId();
            case (1):return j.getNamaBahanBaku();
            case (2):return j.getStok();
            case (3):return j.getSatuanBeli();
            default:return"";
        }
    }
    
}
