/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.MenuAkses;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class MenuAksesDao extends BaseDaoHibernate<MenuAkses>{
    public MenuAkses menuAksesBerdasarkanId(String id){
        return (MenuAkses) sessionFactory.getCurrentSession().get(MenuAkses.class, id);
    }
    
    public List<MenuAkses> menuAksesBerdasarkanNama(String menuAkses){
        return sessionFactory.getCurrentSession().createQuery("from MenuAkses mA where mA.menuAkses LIKE :menuAkses Order By mA.menuAkses Asc")
                .setParameter("menuAkses", "%" + menuAkses.toUpperCase() + "%")
                .list();
    }
    
    public List<MenuAkses> semuaMenuAkses(){
        return sessionFactory.getCurrentSession().createQuery("from MenuAkses b "
                + "Order By b.menuAkses Asc")
                .list();
    }
}
