package com.girsang.girsangkafe.UI.transaksi;

import com.girsang.girsangkafe.GirsangKafe;
import com.girsang.girsangkafe.model.master.Meja;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MejaPanel extends javax.swing.JPanel {

    JButton btn = new JButton();
    Meja meja;
    List<Meja> daftarMeja;
    //<editor-fold defaultstate="collapsed" desc="Tabbed">
    int IndexTab = 0;
    int aktifPanel = 0;
    public int getIndexTab() {
        return IndexTab;
    }
    public void setIndexTab(int IndexTab) {
        this.IndexTab = IndexTab;
    }
    public int getAktifPanel() {
        return aktifPanel;
    }
    public void setAktifPanel(int aktifPanel) {
        this.aktifPanel = aktifPanel;
    }
    public JButton getBtnTutup(){
        return btnKeluar;
    }
//</editor-fold>
    public MejaPanel() {
        initComponents();
        tambah();
    }
    private void tambahButton(){
        mainPanel = new JPanel();
        btn = new JButton("Coba Button");
        Dimension size = new Dimension(50, 30);
        btn.setMaximumSize(size);
        btn.setMinimumSize(size);
        btn.setPreferredSize(size);
        mainPanel.add(btn);
        mainPanel.revalidate();
        
        
    }
    private void tambah(){
        int rows = 15;
        int columns = 9;
        int column = 0, row = 0;
        JLabel label;
        JButton button;
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints= new GridBagConstraints();

        /*for(int rowIndex = 0; rowIndex < rows; rowIndex++){
        for(int columnIndex = 0 ; columnIndex < columns; columnIndex++){
        button = new JButton(String.format("table row:%d, column:%d ", rowIndex+1,columnIndex+1));
        Dimension size = new Dimension(150, 100);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        button.setPreferredSize(size);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = columnIndex;
        constraints.gridy = rowIndex;
        mainPanel.add(button, constraints);
        }
        }*/
        daftarMeja = GirsangKafe.getMasterService().semuaNomorMeja();
        double x = 0;
        for(int m=0;m<daftarMeja.size();m++){
            if(m==0){
                x = 0;
            }else{
                x = m/columns;
                x = Math.floor(x);
                    if(x<1){
                        row = 0;
                        column = m - row;
                    }else{
                        row = (int) x;
                        column =  (int) (m-(columns * x));
                    }
            }
            button = new JButton(daftarMeja.get(m).getNomorMeja());
            Dimension size = new Dimension(200, 150);
            button.setMaximumSize(size);
            button.setMinimumSize(size);
            button.setPreferredSize(size);
            constraints.fill = GridBagConstraints.VERTICAL;
            constraints.gridx = column;
            constraints.gridy = row;
            mainPanel.add(button, constraints);
            System.out.println("column "+column+", row "+row);
        }
            
    }
    private void initListener(){
        
    }
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        btnKeluar = new javax.swing.JButton();

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        pane.setViewportView(mainPanel);

        btnKeluar.setText("Keluar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKeluar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKeluar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane pane;
    // End of variables declaration//GEN-END:variables

}
