/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import Application.AddPatient;
import Application.UpdatePatient;
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

/**
 *
 * @author AUDITOR FAMILY
 */
public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private JTable table; // Reference to the JTable


    public ButtonEditor(AddPatient addPatient,JTable table,Icon icon,JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setIcon(icon);
        button.setOpaque(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        
        int focusBorderSize = 5; // Set your desired size
        Border emptyBorder = BorderFactory.createEmptyBorder(focusBorderSize, focusBorderSize, focusBorderSize, focusBorderSize);
        button.setBorder(emptyBorder);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  int i = table.getSelectedRow();
                  TableModel model = table.getModel();
                  int patient_id = (int)model.getValueAt(i, 6);
                  UpdatePatient updatePatient = new UpdatePatient();
                  updatePatient.setVisible(true);
                  addPatient.dispose();
                 
            
                  
              
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    
        return button;
    }
}
