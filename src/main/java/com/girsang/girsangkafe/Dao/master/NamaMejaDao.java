/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.Meja;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class NamaMejaDao extends BaseDaoHibernate<Meja>{
    public Meja namaMejaBerdasarkanId(String id){
        return (Meja) sessionFactory.getCurrentSession().get(Meja.class, id);
    }
    
    public List<Meja> namaMejaBerdasarkanNama(String namaMeja){
        return sessionFactory.getCurrentSession().createQuery("from Meja b where "
                + "b.namaMeja LIKE :namaMeja Order By b.namaMeja Asc")
                .setParameter("namaMeja", "%" + namaMeja.toUpperCase() + "%")
                .list();
    }
    
    public List<Meja> semuaNamaMeja(){
        return sessionFactory.getCurrentSession().createQuery("from Meja b "
                + "Order By b.namaMeja Asc")
                .list();
    }
}
