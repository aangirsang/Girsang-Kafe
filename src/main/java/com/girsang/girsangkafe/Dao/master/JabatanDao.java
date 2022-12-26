/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.Jabatan;
import com.girsang.girsangkafe.model.master.ListMenuAkses;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JabatanDao extends BaseDaoHibernate<Jabatan>{
    public Jabatan jabatanBerdasarkanId(String id){
        Jabatan jabatan =  (Jabatan) sessionFactory.getCurrentSession().get(Jabatan.class, id);
        if (jabatan!=null){
            Hibernate.initialize(jabatan.getListMenuAkses());
            for (ListMenuAkses menu : jabatan.getListMenuAkses()){
                Hibernate.initialize(menu.getMenuAkses());
            }
        }
        return jabatan;
    }
    
    public List<Jabatan> jabatanBerdasarkanNama(String jabatan){
        return sessionFactory.getCurrentSession().createQuery("from Jabatan j where "
                + "j.jabatan LIKE :jabatan Order By j.jabatan Asc")
                .setParameter("jabatan", "%" + jabatan.toUpperCase() + "%")
                .list();
    }
    
    public List<Jabatan> semuaJabatan(){
        return sessionFactory.getCurrentSession().createQuery("from Jabatan j "
                + "Order By j.jabatan Asc")
                .list();
    }
}
