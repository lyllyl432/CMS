/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.AddMedicine;
import Application.Patient;
import Application.UpdateMedicine;
import Application.UpdatePatient;
import Application.ViewPatient;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author AUDITOR FAMILY
 */
public class MedicineButtonEditor extends DefaultCellEditor {
     private JButton button;
    private int button_role;
    private int medicine_id;
    Connection con;
    PreparedStatement ps;

    public MedicineButtonEditor(AddMedicine addMedicine,JTable table,Icon icon,JCheckBox checkBox, int button_role) {
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
        
        //database connection object
            this.con = ConnectionProvider.connect();




            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //update click
                    if(button_role == 0){
                        int selected_row = table.getSelectedRow();
                      TableModel model = table.getModel();
                      medicine_id = (int)model.getValueAt(selected_row, 8);
                      UpdateMedicine updateMedicine = new UpdateMedicine();
                      updateMedicine.setVisible(true);
                      updateMedicine.getEntry(medicine_id);
                      addMedicine.dispose();
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
                        medicine_id = (int)model.getValueAt(selected_row, 8);
                        try {
                            ps = con.prepareStatement("DELETE FROM medicines WHERE id = ?");
                            ps.setInt(1, medicine_id);
                            ps.executeUpdate();
                            DefaultTableModel patientListDefaultTableModel = (DefaultTableModel)table.getModel();
                            patientListDefaultTableModel.setRowCount(0);
                            addMedicine.showMedicine();
                        } catch (SQLException ex) {
                            Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
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
