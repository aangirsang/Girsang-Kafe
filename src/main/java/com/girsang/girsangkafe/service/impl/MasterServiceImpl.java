/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.service.impl;

import com.girsang.girsangkafe.Dao.master.*;
import com.girsang.girsangkafe.model.master.*;
import com.girsang.girsangkafe.service.MasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service("MasterService")
@Transactional(readOnly = true)
public class MasterServiceImpl implements MasterService{
    
    @Autowired BahanBakuDao bahanBakuDao;
    @Autowired SelisihBahanBakuDao selisihDao;
    @Autowired JabatanDao jabatanDao;
    @Autowired KaryawanDao karyawanDao;
    @Autowired KategoriMenuDao kategoriMenuDao;
    @Autowired MenuAksesDao menuAksesDao;
    @Autowired MenuDao menuDao;
    @Autowired NomorMejaDao nomorMejaDao;
    @Autowired PelangganDao pelangganDao;

    //<editor-fold defaultstate="collapsed" desc="Bahan Baku">
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(BahanBaku bahanBaku) {
        bahanBakuDao.simpan(bahanBaku);
    }
    
    @Override
    @Transactional
    public void hapus(BahanBaku bahanBaku) {
        bahanBakuDao.hapus(bahanBaku);
    }
    
    @Override
    public BahanBaku bahanBakuBerdasarkanId(String id) {
        return bahanBakuDao.bahanBakuBerdasarkanId(id);
    }
    
    @Override
    public List<BahanBaku> semuaBahanBaku() {
        return bahanBakuDao.semuaBahanBaku();
    }
    
    @Override
    public List<BahanBaku> bahanBakuBerdasaranNama(String namaBahanBaku) {
        return bahanBakuDao.bahanBakuBerdasarkanNama(namaBahanBaku);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Jabatan">
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(Jabatan jabatan) {
        jabatanDao.simpan(jabatan);
    }
    
    @Override
    @Transactional
    public void hapus(Jabatan jabatan) {
        jabatanDao.hapus(jabatan);
    }
    
    @Override
    public Jabatan jabatanBerdasarkanId(String id) {
        return jabatanDao.jabatanBerdasarkanId(id);
    }
    
    @Override
    public List<Jabatan> semuaJabatan() {
        return jabatanDao.semuaJabatan();
    }
    
    @Override
    public List<Jabatan> jabatanBerdasaranNama(String jabatan) {
        return jabatanDao.jabatanBerdasarkanNama(jabatan);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Karyawan">
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(Karyawan karyawan) {
        karyawanDao.simpan(karyawan);
    }
    
    @Override
    @Transactional
    public void hapus(Karyawan karyawan) {
        karyawanDao.hapus(karyawan);
    }
    
    @Override
    public Karyawan karyawanBerdasarkanId(String id) {
        return karyawanDao.karyawanBerdasarkanId(id);
    }

    @Override
    public Karyawan cariNamaAkun(String namaAkun){
        return karyawanDao.cariNamaAkun(namaAkun);
    }
    
    @Override
    public Karyawan login(String namaAkun, String password){
        return karyawanDao.login(namaAkun, password);
    }
    
    @Override
    public List<Karyawan> semuaKaryawan() {
        return karyawanDao.semuaKaryawan();
    }
    
    @Override
    public List<Karyawan> karyawanBerdasaranNama(String karyawan) {
        return karyawanDao.karyawanBerdasarkanNama(karyawan);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Kategori Menu">
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(KategoriMenu kategoriMenu) {
        kategoriMenuDao.simpan(kategoriMenu);
    }
    
    @Override
    @Transactional
    public void hapus(KategoriMenu kategoriMenu) {
        kategoriMenuDao.hapus(kategoriMenu);
    }
    
    @Override
    public KategoriMenu kategoriMenuBerdasarkanId(String id) {
        return kategoriMenuDao.kategoriMenuBerdasarkanId(id);
    }
    
    @Override
    public List<KategoriMenu> semuaKategoriMenu() {
        return kategoriMenuDao.semuaKategoriMenu();
    }
    
    @Override
    public List<KategoriMenu> kategoriMenuBerdasaranNama(String kategoriMenu) {
        return kategoriMenuDao.kategoriMenuBerdasarkanNama(kategoriMenu);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Menu Akses">
    
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(MenuAkses menuAkses) {
        menuAksesDao.simpan(menuAkses);
    }
    
    @Override
    @Transactional
    public void hapus(MenuAkses menuAkses) {
        menuAksesDao.hapus(menuAkses);
    }
    
    @Override
    public MenuAkses menuAksesBerdasarkanId(String id) {
        return menuAksesDao.menuAksesBerdasarkanId(id);
    }
    
    @Override
    public List<MenuAkses> semuaMenuAkses() {
        return menuAksesDao.semuaMenuAkses();
    }
    
    @Override
    public List<MenuAkses> menuAksesBerdasaranNama(String menuAkses) {
        return menuAksesDao.menuAksesBerdasarkanNama(menuAkses);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Menu">
    
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(Menu menu) {
        menuDao.simpan(menu);
    }
    
    @Override
    @Transactional
    public void hapus(Menu menu) {
        menuDao.hapus(menu);
    }
    
    @Override
    public Menu menuBerdasarkanId(String id) {
        return menuDao.menuBerdasarkanId(id);
    }
    
    @Override
    public List<Menu> semuaMenu() {
        return menuDao.semuaMenu();
    }
    
    @Override
    public List<Menu> menuBerdasaranNama(String menu) {
        return menuDao.menuBerdasarkanNama(menu);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Nomor Meja">
    
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void simpan(NomorMeja nomorMeja) {
        nomorMejaDao.simpan(nomorMeja);
    }
    
    @Override
    @Transactional
    public void hapus(NomorMeja nomorMeja) {
        nomorMejaDao.hapus(nomorMeja);
    }
    
    @Override
    public NomorMeja nomorMejaBerdasarkanId(String id) {
        return nomorMejaDao.nomorMejaBerdasarkanId(id);
    }
    
    @Override
    public List<NomorMeja> semuaNomorMeja() {
        return nomorMejaDao.semuaNomorMeja();
    }
    
    @Override
    public List<NomorMeja> nomorMejaBerdasaranNama(String nomorMeja) {
        return nomorMejaDao.nomorMejaBerdasarkanNama(nomorMeja);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Pelanggan">
    
    @Override
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void simpan(Pelanggan pelanggan) {
        pelangganDao.simpan(pelanggan);
    }
    
    @Override
    @Transactional
    public void hapus(Pelanggan pelanggan) {
        pelangganDao.hapus(pelanggan);
    }
    
    @Override
    public Pelanggan pelangganBerdasarkanId(String id) {
        return pelangganDao.pelangganBerdasarkanId(id);
    }
    
    @Override
    public List<Pelanggan> semuaPelanggan() {
        return pelangganDao.semuaPelanggan();
    }
    
    @Override
    public List<Pelanggan> pelangganBerdasaranNama(String pelanggan) {
        return pelangganDao.pelangganBerdasarkanNama(pelanggan);
        
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Selisih Bahan Baku">
    @Override
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void simpan(SelisihBahanBaku selisihBahanBaku) {
        selisihDao.simpan(selisihBahanBaku);
    }
    
    @Override
    @Transactional
    public void hapus(SelisihBahanBaku selisihBahanBaku) {
        selisihDao.hapus(selisihBahanBaku);
    }
    
    @Override
    public SelisihBahanBaku selisihBahanBakuBerdasarkanId(String id) {
        return selisihDao.selisihBerdasarkanId(id);
    }
    
    @Override
    public List<SelisihBahanBaku> semuaSelisihBahanBaku() {
        return selisihDao.semuaBahanBaku();
    }
    
    @Override
    public List<SelisihBahanBaku> selisihBerdasaranBahanBaku(BahanBaku bahanBaku) {
        return selisihDao.selisihBerdasarkanBahanBaku(bahanBaku);
    }
//</editor-fold>

       
}
