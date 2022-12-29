/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.UI.transaksi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author GIRSANG PC
 */
public class XOButton extends JButton implements ActionListener{
    byte value=0;
    public XOButton(String textButton){
        this.addActionListener(this);
        setText(textButton);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        value++;
        value%=3;
        switch(value){
            case 1:
                System.out.println(getText()+" Klik 1 Kali");
                break;
        }
    }
}
