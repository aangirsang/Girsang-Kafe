/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.NomorMeja;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class NomorMejaDao extends BaseDaoHibernate<NomorMeja>{
    public NomorMeja nomorMejaBerdasarkanId(String id){
        return (NomorMeja) sessionFactory.getCurrentSession().get(NomorMeja.class, id);
    }
    
    public List<NomorMeja> nomorMejaBerdasarkanNama(String nomorMeja){
        return sessionFactory.getCurrentSession().createQuery("from NomorMeja b where "
                + "b.nomorMeja LIKE :nomorMeja Order By b.nomorMeja Asc")
                .setParameter("nomorMeja", "%" + nomorMeja.toUpperCase() + "%")
                .list();
    }
    
    public List<NomorMeja> semuaNomorMeja(){
        return sessionFactory.getCurrentSession().createQuery("from NomorMeja b "
                + "Order By b.nomorMeja Asc")
                .list();
    }
}
