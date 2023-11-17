/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.AddReport;
import Application.Appointment;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class AppointmentButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int button_role;
    private int patient_id;
    private String patient_name;
    private int reference_id;
    private String button_text;
    AppointmentList appointment_list;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UserInfo user_info;
    public AppointmentButtonEditor(Appointment appointment,JTable table, String button_text,JCheckBox checkBox,int button_role,UserInfo user_info, String patient_name){
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
        this.patient_name = patient_name;
        //database connection object
        this.con = ConnectionProvider.connect();
        
        button.addActionListener((ActionEvent e) -> {
             int selected_row = table.getSelectedRow();
             TableModel model = table.getModel();
             reference_id = (int)model.getValueAt(selected_row, 8);
            //view click
            if(button_role == 0){
                
            }
            //report click
            else if(button_role == 1){
                new AddReport(user_info,patient_name,reference_id).setVisible(true);
                appointment.dispose();
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
