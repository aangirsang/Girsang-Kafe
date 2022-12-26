/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.Pelanggan;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class PelangganDao extends BaseDaoHibernate<Pelanggan>{
    public Pelanggan pelangganBerdasarkanId(String id){
        return (Pelanggan) sessionFactory.getCurrentSession().get(Pelanggan.class, id);
    }
    
    public List<Pelanggan> pelangganBerdasarkanNama(String namaPelanggan){
        return sessionFactory.getCurrentSession().createQuery("from Pelanggan b where "
                + "b.namaPelanggan LIKE :namaPelanggan Order By b.namaPelanggan Asc")
                .setParameter("namaPelanggan", "%" + namaPelanggan.toUpperCase() + "%")
                .list();
    }
    
    public List<Pelanggan> semuaPelanggan(){
        return sessionFactory.getCurrentSession().createQuery("from Pelanggan b "
                + "Order By b.namaPelanggan Asc")
                .list();
    }
}
