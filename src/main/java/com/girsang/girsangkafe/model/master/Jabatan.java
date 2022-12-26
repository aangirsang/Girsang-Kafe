/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.model.master;

import java.io.Serializable;
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
public class Jabatan implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false,unique = true)
    private String jabatan;
    
    @OneToMany(mappedBy = "menuAkses", cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<ListMenuAkses> listMenuAkses = new ArrayList<ListMenuAkses>();

    //<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getJabatan() {
        return jabatan;
    }
    
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    public List<ListMenuAkses> getListMenuAkses() {
        return listMenuAkses;
    }
    
    public void setListMenuAkses(List<ListMenuAkses> listMenuAkses) {
        this.listMenuAkses = listMenuAkses;
        if(listMenuAkses !=null && !listMenuAkses.isEmpty()){
            for (ListMenuAkses menu : listMenuAkses){
                menu.setJabatan(this);
            }
        }
    }
    //</editor-fold>
    
    public void addMenuAkses(ListMenuAkses menu){
        if(getListMenuAkses()==null){
            setListMenuAkses(new ArrayList<>());
        }
        getListMenuAkses().add(menu);
        menu.setJabatan(this);
    }
    public void removeMenuAkses(ListMenuAkses menu){
        if(getListMenuAkses()==null){
            setListMenuAkses(new ArrayList<>());
        }
        getListMenuAkses().remove(menu);
        menu.setJabatan(null);
    }
    
}
