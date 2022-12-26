/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.util;

/**
 *
 * @author Girsang
 */
public interface PesanJO {
    
    interface pesan {
        String PERHATIAN_TITLE = "Perhatian";
        String INFORMASI_TITLE = "Informasi";
        String KONFIRMASI_TITLE = "Konfirmasi";
        String HAPUS_ERROR = "Tidak Bisa Menghapus Data, Data Masih Digunakan Pada Tabel Lain";
        String DATA_SUDAH_ADA = "Data Sudah Ada";
        String DATA_AKUN_SUDAH_ADA = "Nama Akun Sudah Ada";
        String DATA_AKUN = "Nama Akun dan Password harus Diisi";
        String TIDAK_ADA_DATA = "Tidak Ada Data Yang Dipilih. Silahkan Pilih Data Terlebih Dahulu";
        String TANYA_HAPUS = "Anda Yakin Ingin Menghapus Data Ini?";
        String TANYA_UBAH ="Anda Yakin Ingin Menyimpan Perubahan Data Ini?";
        String DATA_TIDAK_LENGKAP = "Data Belum Lengkap, Silahkan Lengkapi Data Terlebih Dahulu";
        String HAPUS_DATA = "Apakah Anda Yakin Ingin Menghapus Data Ini?";
    }
    
    interface namaTab{
        String MENU = "Data Menu";
        String BAHANBAKU = "Data Bahan Baku";
        String KATEGORI_MENU = "Data Kategori Menu";
        String KELOMPOK_MENU = "Data kelompok Menu";
        String JABATAN = "Data Jabatan";
        String KARYAWAN = "Data Karyawan";
        String MEJA = "Data Meja";
        String PELANGGAN = "Data Pelanggan";
        String PESANAN = "Data Pesanan";
        String BELANJA = "Data Pengeluaran";
        String PENGELUARAN = "Data Pengeluaran";
        String PEMASUKAN = "Data Pemasukan";
    }
    interface namaMenu{
        String BAHANBAKU = "Bahan Baku";
        String MENU = "Menu";
        String KATEGORI_MENU = "Kategori Menu";
        String MENUAKSES = "Menu Akses";
        String KELOMPOK_MENU = "Kelompok Menu";
        String PELANGGAN = "Pelanggan";
        String JABATAN = "Jabatan";
        String MEJA = "Meja";
        String KARYAWAN = "Karyawan";
        String PEMASUKAN = "Pemasukan";
        String PESANAN = "Pesanan";
        String PENGELUARAN = "Pengeluaran";
        String BELANJA = "Pengeluaran";
    }
    interface namaDialog{
        String KARYAWAN_TAMBAH = "Tambah Data Karyawan";
        String KARYAWAN_UBAH = "Ubah Data Karyawan";
        String KARYAWAN_PILIH = "Pilih Data Karyawan";
        String MENU_TAMBAH = "Tambah Data Menu";
        String MENU_UBAH = "Ubah Data Menu";
        String MENU_PILIH = "Pilih Data Menu";
        String KATEGORIMENU_TAMBAH = "Tambah Data Kategori Menu";
        String KATEGORIMENU_UBAH = "Ubah  Data Kategori Menu";
        String KATEGORIMENU_PILIH = "Pilih  Data Kategori Menu";
        String MENUAKSES_TAMBAH = "Tambah Data Menu Akses";
        String MENUAKSES_UBAH = "Ubah Data Menu Akses";
        String MENUAKSES_PILIH = "Pilih Data Menu Akses";
        String PELANGGAN_TAMBAH = "Tambah Data Pelanggan";
        String PELANGGAN_UBAH = "Ubah Data Pelanggan";
        String PELANGGAN_PILIH = "Pilih Data Pelanggan";
        String JABATAN_TAMBAH = "Tambah Data Jabatan";
        String JABATAN_UBAH = "Ubah Data Jabatan";
        String JABATAN_PILIH = "Pilih Data Jabatan";
        String NOMORMEJA_TAMBAH = "Tambah Data Meja";
        String NOMORMEJA_UBAH = "Ubah Data Meja";
        String NOMORMEJA_PILIH = "Pilih Data Meja";
        String BAHANBAKU_TAMBAH = "Tambah Data Bahan Baku";
        String BAHANBAKU_UBAH = "Ubah Data Bahan Baku";
        String BAHANABAKU_PILIH = "Pilih Data Bahan Baku";
    }
    
}
