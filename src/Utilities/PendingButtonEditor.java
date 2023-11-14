/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.AppointmentPending;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class PendingButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int button_role;
    private int patient_id;
    Connection con;
    PreparedStatement ps;
    UserInfo user_info;
    public PendingButtonEditor(AppointmentPending appointment_pending,JTable table,String button_text,JCheckBox checkBox, int button_role, UserInfo user_info) {
        super(checkBox);
        button = new JButton();
        button.setText(button_text);
        button.setOpaque(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        
        
        int focusBorderSize = 5; // Set your desired size
        Border emptyBorder = BorderFactory.createEmptyBorder(focusBorderSize, focusBorderSize, focusBorderSize, focusBorderSize);
        button.setBorder(emptyBorder);
        
        this.button_role = button_role;
        this.user_info = user_info;
        
        //database connection object
            this.con = ConnectionProvider.connect();




            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //update click
                    if(button_role == 0){
                        try {
                            MailUtil.sendMail("lyllyl432@gmail.com");
                        } catch (MessagingException ex) {
                            Logger.getLogger(PendingButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //delete click
                    else if(button_role == 1){
                        
                         
                    }
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setBackground(table.getBackground());
        }

        return button;
    }
}

        
    
    

