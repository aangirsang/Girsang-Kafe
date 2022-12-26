/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.BahanBaku;
import com.girsang.girsangkafe.model.master.SelisihBahanBaku;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class SelisihBahanBakuDao extends BaseDaoHibernate<SelisihBahanBaku>{
    public SelisihBahanBaku selisihBerdasarkanId(String id){
        return (SelisihBahanBaku) sessionFactory.getCurrentSession().get(SelisihBahanBaku.class, id);
    }
    
    public List<SelisihBahanBaku> selisihBerdasarkanBahanBaku(BahanBaku bahanBaku){
        return sessionFactory.getCurrentSession().createQuery("from SelisihBahanBaku b where "
                + "b.bahanBaku LIKE :bahanBaku Order By b.bahanBaku.namaBahanBaku Asc")
                .setParameter("bahanBaku", bahanBaku)
                .list();
    }
    
    public List<SelisihBahanBaku> semuaBahanBaku(){
        return sessionFactory.getCurrentSession().createQuery("from SelisihBahanBaku b "
                + "Order By b.bahanBaku.namaBahanBaku Asc")
                .list();
    }
}
