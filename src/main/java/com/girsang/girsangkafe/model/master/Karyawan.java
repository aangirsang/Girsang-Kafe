/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.model.master;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author User
 */
@Entity
public class Karyawan implements Serializable {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String namaLengkap;
    private String tempatLahir;
    
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    private String alamat;
    private String tamatanTerakhir;
    
    @Temporal(TemporalType.DATE)
    private Date tanggalMulaiKerja;
    private String facebook;
    private String instagram;
    private String tiktok;
    private String whatsApp;
    private String twitter;
    
    @OneToOne
    private Jabatan jabatan;
    
    private Integer poin = 0;
    
    @Column(unique = true)
    private String namaAkun;
    private String password;

    //<editor-fold defaultstate="collapsed" desc="Getter Setter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNamaLengkap() {
        return namaLengkap;
    }
    
    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }
    
    public String getTempatLahir() {
        return tempatLahir;
    }
    
    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    
    public Date getTanggalLahir() {
        return tanggalLahir;
    }
    
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getTamatanTerakhir() {
        return tamatanTerakhir;
    }
    
    public void setTamatanTerakhir(String tamatanTerakhir) {
        this.tamatanTerakhir = tamatanTerakhir;
    }
    
    public Date getTanggalMulaiKerja() {
        return tanggalMulaiKerja;
    }
    
    public void setTanggalMulaiKerja(Date tanggalMulaiKerja) {
        this.tanggalMulaiKerja = tanggalMulaiKerja;
    }
    
    public String getFacebook() {
        return facebook;
    }
    
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    public String getInstagram() {
        return instagram;
    }
    
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
    
    public String getTiktok() {
        return tiktok;
    }
    
    public void setTiktok(String tiktok) {
        this.tiktok = tiktok;
    }
    
    public String getWhatsApp() {
        return whatsApp;
    }
    
    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }
    
    public String getTwitter() {
        return twitter;
    }
    
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
    public Jabatan getJabatan() {
        return jabatan;
    }
    
    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
    
    public Integer getPoin() {
        return poin;
    }
    
    public void setPoin(Integer poin) {
        this.poin = poin;
    }
    
    public String getNamaAkun() {
        return namaAkun;
    }
    
    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>
    
    
}
