/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.model.master;

import java.io.Serializable;
import java.util.Date;
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
public class SelisihBahanBaku implements Serializable{
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name="bahanBaku",nullable=false)
    private BahanBaku bahanBaku;
    
    private Date tanggal;
    
    private Integer selisih = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BahanBaku getBahanBaku() {
        return bahanBaku;
    }

    public void setBahanBaku(BahanBaku bahanBaku) {
        this.bahanBaku = bahanBaku;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getSelisih() {
        return selisih;
    }

    public void setSelisih(Integer selisih) {
        this.selisih = selisih;
    }
    
    
}
