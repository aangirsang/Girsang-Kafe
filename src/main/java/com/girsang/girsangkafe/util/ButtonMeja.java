/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girsang.girsangkafe.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author User
 */
public class ButtonMeja extends JButton implements ActionListener{
    byte value=0;
    public ButtonMeja(){
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        value++;
        value%=3;
        switch(value){
            case 0:
                setText("");
                break;
            case 1:
                setText("1");
                break;
            case 2:
                setText("2");
                break;
        }
    }
}
