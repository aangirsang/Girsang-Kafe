/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.Karyawan;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class KaryawanDao extends BaseDaoHibernate<Karyawan>{
    public Karyawan karyawanBerdasarkanId(String id){
        return (Karyawan) sessionFactory.getCurrentSession().get(Karyawan.class, id);
    }
    
    public Karyawan cariNamaAkun(String namaAkun){
        return (Karyawan) sessionFactory.getCurrentSession().createQuery
                ("from Karyawan k where k.namaAkun=:namaAkun")
                .setString("namaAkun", namaAkun)
                .uniqueResult();
    }
    
    public Karyawan login(String namaAkun, String password){
        return (Karyawan) sessionFactory.getCurrentSession().createQuery
                ("from Karyawan k where k.namaAkun=:namaAkun and k.password=:password")
                .setString("namaAkun", namaAkun)
                .setString("password", password)
                .uniqueResult();
    }
    
    public List<Karyawan> karyawanBerdasarkanNama(String namaLengkap){
        return sessionFactory.getCurrentSession().createQuery("from Karyawan k where "
                + "k.namaLengkap LIKE :namaLengkap Order By k.namaLengkap Asc")
                .setParameter("namaLengkap", "%" + namaLengkap.toUpperCase() + "%")
                .list();
    }
    
    public List<Karyawan> semuaKaryawan(){
        return sessionFactory.getCurrentSession().createQuery("from Karyawan k "
                + "Order By k.namaLengkap Asc")
                .list();
    }
}
