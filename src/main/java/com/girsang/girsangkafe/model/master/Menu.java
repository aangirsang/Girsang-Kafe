/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author User
 */
@Entity
public class Menu implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false, unique = true)
    private String namaMenu;
    
   private KategoriMenu kategoriMenu;
   
   private BigDecimal harga = BigDecimal.ZERO;
   
   @OneToMany(mappedBy = "menu",cascade = CascadeType.ALL)
   @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
   private List<MenuDetail> menuDetails = new ArrayList<MenuDetail>();

   //<editor-fold defaultstate="collapsed" desc="Getter Setter">
   public String getId() {
       return id;
   }
   
   public void setId(String id) {
       this.id = id;
   }
   
   public String getNamaMenu() {
       return namaMenu;
   }
   
   public void setNamaMenu(String namaMenu) {
       this.namaMenu = namaMenu;
   }
   
   public KategoriMenu getKategoriMenu() {
       return kategoriMenu;
   }
   
   public void setKategoriMenu(KategoriMenu kategoriMenu) {
       this.kategoriMenu = kategoriMenu;
   }
   
   public BigDecimal getHarga() {
       return harga;
   }
   
   public void setHarga(BigDecimal harga) {
       this.harga = harga;
   }
   
   public List<MenuDetail> getMenuDetails() {
       return menuDetails;
   }
   
   public void setMenuDetails(List<MenuDetail> menuDetails) {
       this.menuDetails = menuDetails;
       if(menuDetails !=null && !menuDetails.isEmpty()){
           for(MenuDetail menu : menuDetails){
               menu.setMenu(this);
           }
       }
   }
    //</editor-fold>
   
   public void tambahMenuDetails(MenuDetail detail){
       if(menuDetails==null){
           menuDetails = new ArrayList<>();
       }
       menuDetails.add(detail);
       detail.setMenu(this);
   }
   
   public void hapusMenuDetail(MenuDetail detail){
       if(menuDetails==null){
           menuDetails = new ArrayList<>();
       }
       menuDetails.remove(detail);
       detail.setMenu(null);
   }
   
}
