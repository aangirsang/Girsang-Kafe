package com.girsang.girsangkafe.util.tabelmodel;

import com.girsang.girsangkafe.model.master.MenuDetail;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelMenuDetail extends AbstractTableModel{

    List<MenuDetail> daftarMenuDetai;
    
    public TabelModelMenuDetail(List<MenuDetail> list){
        this.daftarMenuDetai=list;
    }
    @Override
    public int getRowCount() {
        return daftarMenuDetai.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int col){
        return switch (col) {
            case 0 -> "ID";
            case 1 -> "Bahan Baku";
            case 2 -> "Satuan Pakai";
            case 3 -> "Jumlah";
            default -> "";
        };
    }
    @Override
    public Object getValueAt(int row, int col) {
        MenuDetail menuDetail = daftarMenuDetai.get(row);
        return switch (col) {
            case 0 -> menuDetail.getId();
            case 1 -> menuDetail.getBahanBaku().getNamaBahanBaku();
            case 2 -> menuDetail.getSatuanPakai();
            case 3 -> menuDetail.getJumlah();
            default -> "";
        };
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 3 : return Integer.class;
            default:return String.class;
        }
    }
    @Override
        public boolean isCellEditable(int row, int columnIndex) {
            if (columnIndex == 3) {
                return true;
            } else {
                return false;
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            MenuDetail detail = daftarMenuDetai.get(rowIndex);
            switch(columnIndex){
                case 3:
                    Integer jumlah = (Integer) aValue;
                    detail.setJumlah(jumlah);
                    fireTableCellUpdated(rowIndex, columnIndex); // Total may also have changed
                    break;
                
            }
        }
}
