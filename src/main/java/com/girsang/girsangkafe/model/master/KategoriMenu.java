/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.model.master;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author User
 */
@Entity
public class KategoriMenu implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String kategoriMenu;

    //<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getKategoriMenu() {
        return kategoriMenu;
    }
    
    public void setKategoriMenu(String kategoriMenu) {
        this.kategoriMenu = kategoriMenu;
    }
    //</editor-fold>
    
    
}
