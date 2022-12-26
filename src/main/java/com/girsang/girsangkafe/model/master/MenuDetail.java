/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.model.master;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author User
 */
@Entity
public class MenuDetail implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "menu",nullable = false)
    private Menu menu;
    
    @ManyToOne
    @JoinColumn(name = "bahanBaku",nullable = false)
    private BahanBaku bahanBaku;
    
    private String satuanPakai;
    
    private Integer jumlahPakai = 0;

    //<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Menu getMenu() {
        return menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public BahanBaku getBahanBaku() {
        return bahanBaku;
    }
    
    public void setBahanBaku(BahanBaku bahanBaku) {
        this.bahanBaku = bahanBaku;
    }
    public String getSatuanPakai(){
        return satuanPakai;
    }
    
    public void setSatuanPakai(String satuanPakai){
        this.satuanPakai = satuanPakai;
    }
    public Integer getJumlah() {
        return jumlahPakai;
    }
    
    public void setJumlah(Integer jumlah) {
        this.jumlahPakai = jumlah;
    }
    //</editor-fold>
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuDetail other = (MenuDetail) obj;
        return !((this.id == null) ? (other.id != null) : !this.id.equals(other.id));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
