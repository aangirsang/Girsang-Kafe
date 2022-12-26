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
public class BahanBaku implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String namaBahanBaku;
    private String satuanPakai;
    private String satuanBeli;
    
    
    private Integer stok = 0;
    private Integer isiSatuanBeli = 0;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBahanBaku() {
        return namaBahanBaku;
    }

    public void setNamaBahanBaku(String namaBahanBaku) {
        this.namaBahanBaku = namaBahanBaku;
    }

    public String getSatuanPakai() {
        return satuanPakai;
    }

    public void setSatuanPakai(String satuanPakai) {
        this.satuanPakai = satuanPakai;
    }

    public String getSatuanBeli() {
        return satuanBeli;
    }

    public void setSatuanBeli(String satuanBeli) {
        this.satuanBeli = satuanBeli;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Integer getIsiSatuanBeli() {
        return isiSatuanBeli;
    }

    public void setIsiSatuanBeli(Integer isiSatuanBeli) {
        this.isiSatuanBeli = isiSatuanBeli;
    }

}
