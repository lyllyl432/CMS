/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.AddReport;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class ReportMedicineButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int prescribed_id;
    private int medicine_id;
    private int unit;
    private Connection con;
    private PreparedStatement ps;

    public ReportMedicineButtonEditor(AddReport add_report,JTable table,Icon icon,JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setIcon(icon);
        button.setOpaque(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        
        int focusBorderSize = 5; // Set your desired size
        Border emptyBorder = BorderFactory.createEmptyBorder(focusBorderSize, focusBorderSize, focusBorderSize, focusBorderSize);
        button.setBorder(emptyBorder);        

        //initialize a database connection
            this.con = ConnectionProvider.connect();
            //button event listener
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(table.isEditing()){
                            table.getCellEditor().stopCellEditing();
                        }

                        int selected_row = table.getSelectedRow();
                        System.out.println(selected_row);
                        TableModel model = table.getModel();
                        prescribed_id = (int)model.getValueAt(selected_row, 5);
                        unit = (int)model.getValueAt(selected_row, 1);
                        medicine_id = (int)model.getValueAt(selected_row, 6);
                        //delete the entry in appointment_prescribed_medication table based on reference_id
                        ps = con.prepareStatement("DELETE FROM appointment_prescribed_medication WHERE prescribed_id = ?");
                        ps.setInt(1, prescribed_id);
                        int rows_affected = ps.executeUpdate();
                        if(rows_affected > 0){
                            //update stock value in entry
                        ps = con.prepareStatement("UPDATE medicines SET stock = stock + ? WHERE id = ?");
                        ps.setInt(1, unit);
                        ps.setInt(2, medicine_id);
                        ps.executeUpdate();
                        add_report.showAddedMedicine();
                        }
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(ReportMedicineButtonEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

