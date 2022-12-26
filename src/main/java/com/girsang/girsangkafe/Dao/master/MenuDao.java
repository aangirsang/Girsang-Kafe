/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.Dao.master;

import com.girsang.girsangkafe.Dao.BaseDaoHibernate;
import com.girsang.girsangkafe.model.master.Menu;
import com.girsang.girsangkafe.model.master.MenuDetail;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class MenuDao extends BaseDaoHibernate<Menu>{
    public Menu menuBerdasarkanId(String id){
        Menu menu =  (Menu) sessionFactory.getCurrentSession().get(Menu.class, id);
        if(menu !=null){
            Hibernate.initialize(menu.getMenuDetails());
            for(MenuDetail mm : menu.getMenuDetails()){
                Hibernate.initialize(mm.getBahanBaku());
            }
        }
        return menu;
    }
    
    public List<Menu> menuBerdasarkanNama(String namaMenu){
        return sessionFactory.getCurrentSession().createQuery("from Menu m where "
                + "m.namaMenu LIKE :namaMenu Order By m.namaMenu Asc")
                .setParameter("namaMenu", "%" + namaMenu.toUpperCase() + "%")
                .list();
    }
    
    public List<Menu> semuaMenu(){
        return sessionFactory.getCurrentSession().createQuery("from Menu m "
                + "Order By m.namaMenu Asc")
                .list();
    }
}
