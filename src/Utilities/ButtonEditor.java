/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.Patient;
import Application.UpdatePatient;
import Application.ViewPatient;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AUDITOR FAMILY
 */
public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int button_role;
    private int patient_id;
    Connection con;
    PreparedStatement ps;
    UserInfo user_info;
    public ButtonEditor(Patient patient,JTable table,Icon icon,JCheckBox checkBox, int button_role, UserInfo user_info) {
        super(checkBox);
        button = new JButton();
        button.setIcon(icon);
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
                        System.out.println(user_info.getAge());
                        int selected_row = table.getSelectedRow();
                      TableModel model = table.getModel();
                      patient_id = (int)model.getValueAt(selected_row, 6);
                      UpdatePatient updatePatient = new UpdatePatient(patient);
                      updatePatient.setVisible(true);
                      updatePatient.fillUpdateForm(General.getPatientEntry(patient_id));
                    }
                    //delete click
                    else if(button_role == 1){
                        if(table.isEditing()){
                            table.getCellEditor().stopCellEditing();
                        }
                        System.out.println("deleted");
                        int selected_row = table.getSelectedRow();
                        System.out.println(selected_row);
                        TableModel model = table.getModel();
                        patient_id = (int)model.getValueAt(selected_row, 6);
                        try {
                            ButtonEditor.this.ps = ButtonEditor.this.con.prepareStatement("DELETE FROM patient WHERE patient_id = ?");
                            ButtonEditor.this.ps.setInt(1, patient_id);
                            ButtonEditor.this.ps.executeUpdate();
                            DefaultTableModel patientListDefaultTableModel = (DefaultTableModel)table.getModel();
                            patientListDefaultTableModel.setRowCount(0);
                            patient.showPatient();
                        } catch (SQLException ex) {
                            Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                    }
                    //view click
                    else if(button_role == 2){
                        int selected_row = table.getSelectedRow();
                        TableModel model = table.getModel();
                        patient_id = (int)model.getValueAt(selected_row, 6);
                        ViewPatient viewPatient = new ViewPatient(user_info);
                        viewPatient.setVisible(true);
                        viewPatient.fillInformationLabel(General.getPatientEntry(patient_id));
                        patient.dispose();
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
