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
public class ListMenuAkses implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jabatan jabatan;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private MenuAkses menuAkses;
    
    private Boolean status = Boolean.TRUE;

    //<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Jabatan getJabatan() {
        return jabatan;
    }
    
    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
    
    public MenuAkses getMenuAkses() {
        return menuAkses;
    }
    
    public void setMenuAkses(MenuAkses menuAkses) {
        this.menuAkses = menuAkses;
    }
    
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
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
        final ListMenuAkses other = (ListMenuAkses) obj;
        return !((this.id == null) ? (other.id != null) : !this.id.equals(other.id));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
