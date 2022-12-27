/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.service;

import com.girsang.girsangkafe.model.master.BahanBaku;
import com.girsang.girsangkafe.model.master.Jabatan;
import com.girsang.girsangkafe.model.master.Karyawan;
import com.girsang.girsangkafe.model.master.KategoriMenu;
import com.girsang.girsangkafe.model.master.Menu;
import com.girsang.girsangkafe.model.master.MenuAkses;
import com.girsang.girsangkafe.model.master.Meja;
import com.girsang.girsangkafe.model.master.Pelanggan;
import com.girsang.girsangkafe.model.master.SelisihBahanBaku;
import java.util.List;

/**
 *
 * @author User
 */
public interface MasterService {
    //Bahan Baku
    public void simpan (BahanBaku bahanBaku);
    public void hapus (BahanBaku bahanBaku);
    public BahanBaku bahanBakuBerdasarkanId(String id);
    public List<BahanBaku> semuaBahanBaku();
    public List<BahanBaku> bahanBakuBerdasaranNama(String namaBahanBaku);
    
    //Selisih Bahan Baku
    public void simpan (SelisihBahanBaku selisihBahanBaku);
    public void hapus (SelisihBahanBaku selisihBahanBaku);
    public SelisihBahanBaku selisihBahanBakuBerdasarkanId(String id);
    public List<SelisihBahanBaku> semuaSelisihBahanBaku();
    public List<SelisihBahanBaku> selisihBerdasaranBahanBaku(BahanBaku bahanBaku);
    
    //Jabatan
    public void simpan (Jabatan jabatan);
    public void hapus (Jabatan jabatan);
    public Jabatan jabatanBerdasarkanId(String id);
    public List<Jabatan> semuaJabatan();
    public List<Jabatan> jabatanBerdasaranNama(String jabatan);
    
    //Karyawan
    public void simpan (Karyawan karyawan);
    public void hapus (Karyawan karyawan);
    public Karyawan karyawanBerdasarkanId(String id);
    public Karyawan cariNamaAkun(String namaAkun);
    public Karyawan login(String namaAkun, String password);
    public List<Karyawan> semuaKaryawan();
    public List<Karyawan> karyawanBerdasaranNama(String karyawan);
    
    //Kategori Menu
    public void simpan (KategoriMenu kategoriMenu);
    public void hapus (KategoriMenu kategoriMenu);
    public KategoriMenu kategoriMenuBerdasarkanId(String id);
    public List<KategoriMenu> semuaKategoriMenu();
    public List<KategoriMenu> kategoriMenuBerdasaranNama(String kategoriMenu);
    
    //Menu Akses
    public void simpan (MenuAkses menuAkses);
    public void hapus (MenuAkses menuAkses);
    public MenuAkses menuAksesBerdasarkanId(String id);
    public List<MenuAkses> semuaMenuAkses();
    public List<MenuAkses> menuAksesBerdasaranNama(String menuAkses);
    
    //Menu
    public void simpan (Menu menu);
    public void hapus (Menu menu);
    public Menu menuBerdasarkanId(String id);
    public List<Menu> semuaMenu();
    public List<Menu> menuBerdasaranNama(String menu);
    
    //Nomor Meja
    public void simpan (Meja nomorMeja);
    public void hapus (Meja nomorMeja);
    public Meja nomorMejaBerdasarkanId(String id);
    public List<Meja> semuaNomorMeja();
    public List<Meja> nomorMejaBerdasaranNama(String nomorMeja);
    
    //Pelanggan
    public void simpan (Pelanggan pelanggan);
    public void hapus (Pelanggan pelanggan);
    public Pelanggan pelangganBerdasarkanId(String id);
    public List<Pelanggan> semuaPelanggan();
    public List<Pelanggan> pelangganBerdasaranNama(String pelanggan);
    
    
}
