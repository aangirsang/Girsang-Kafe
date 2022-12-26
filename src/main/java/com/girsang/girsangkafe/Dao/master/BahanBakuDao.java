/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.BahanBaku;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class BahanBakuDao extends BaseDaoHibernate<BahanBaku>{
    public BahanBaku bahanBakuBerdasarkanId(String id){
        return (BahanBaku) sessionFactory.getCurrentSession().get(BahanBaku.class, id);
    }
    
    public List<BahanBaku> bahanBakuBerdasarkanNama(String namaBahanBaku){
        return sessionFactory.getCurrentSession().createQuery("from BahanBaku b where "
                + "b.namaBahanBaku LIKE :namaBahanBaku Order By b.namaBahanBaku Asc")
                .setParameter("namaBahanBaku", "%" + namaBahanBaku.toUpperCase() + "%")
                .list();
    }
    
    public List<BahanBaku> semuaBahanBaku(){
        return sessionFactory.getCurrentSession().createQuery("from BahanBaku b "
                + "Order By b.namaBahanBaku Asc")
                .list();
    }
}
