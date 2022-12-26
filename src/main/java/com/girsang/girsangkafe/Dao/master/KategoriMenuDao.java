/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.KategoriMenu;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class KategoriMenuDao extends BaseDaoHibernate<KategoriMenu>{
    public KategoriMenu kategoriMenuBerdasarkanId(String id){
        return (KategoriMenu) sessionFactory.getCurrentSession().get(KategoriMenu.class, id);
    }
    
    public List<KategoriMenu> kategoriMenuBerdasarkanNama(String kategoriMenu){
        return sessionFactory.getCurrentSession().createQuery("from KategoriMenu k where "
                + "k.kategoriMenu LIKE :kategoriMenu Order By k.kategoriMenu Asc")
                .setParameter("kategoriMenu", "%" + kategoriMenu.toUpperCase() + "%")
                .list();
    }
    
    public List<KategoriMenu> semuaKategoriMenu(){
        return sessionFactory.getCurrentSession().createQuery("from KategoriMenu k "
                + "Order By k.kategoriMenu Asc")
                .list();
    }
}
