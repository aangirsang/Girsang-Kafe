/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.girsang.girsangkafe.UI.FrameUtama;
import com.girsang.girsangkafe.service.MasterService;
import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author User
 */
public class GirsangKafe {
    
    private static MasterService masterService;
    private static DataSource dataSource;
    
    /**
     * @return the masterService
     */
    public static MasterService getMasterService() {
        return masterService;
    }
    public static DataSource getDataSource() {
        return dataSource;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            
            /*BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", Boolean.FALSE);
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", Boolean.FALSE);*/

            AbstractApplicationContext ctx
                    = new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml");
            ctx.registerShutdownHook();
            
            dataSource = (DataSource) ctx.getBean("dataSource");
            masterService = (MasterService) ctx.getBean("MasterService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Masalah Pada Database","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
        java.awt.EventQueue.invokeLater(() -> {
            FrameUtama fu = new FrameUtama();
            fu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fu.setVisible(true);
            fu.jam();
        });
        // TODO code application logic here
    }

    /**
     * @return the dataSource
     */
    

    
}
