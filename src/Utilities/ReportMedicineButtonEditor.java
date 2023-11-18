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

/**
 *
 * @author HP
 */
public class ReportMedicineButtonEditor extends DefaultCellEditor {
     private JButton button;
    private int button_role;
    private int medicine_id;
    Connection con;
    PreparedStatement ps;

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
        
        this.button_role = button_role;
        
        //database connection object
            this.con = ConnectionProvider.connect();




            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                        if(table.isEditing()){
//                            table.getCellEditor().stopCellEditing();
//                        }
//                        System.out.println("deleted");
//                        int selected_row = table.getSelectedRow();
//                        System.out.println(selected_row);
//                        TableModel model = table.getModel();
//                        medicine_id = (int)model.getValueAt(selected_row, 8);
//                        try {
//                            ps = con.prepareStatement("DELETE FROM medicines WHERE id = ?");
//                            ps.setInt(1, medicine_id);
//                            ps.executeUpdate();
//                            DefaultTableModel patientListDefaultTableModel = (DefaultTableModel)table.getModel();
//                            patientListDefaultTableModel.setRowCount(0);
////                            medicine.showMedicine();
//                        } catch (SQLException ex) {
//                            Logger.getLogger(ReportMedicineButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                         
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

