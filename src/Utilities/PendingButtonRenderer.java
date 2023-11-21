/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HP
 */
public class PendingButtonRenderer extends JButton implements TableCellRenderer {
        private JButton button;
        private String button_text;

        public PendingButtonRenderer(String button_text) {
          this.button_text = button_text;
         button = new JButton();
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBackground(new Color(180, 173, 234));
        button.setText(button_text);
        if(button_text.equals("Approve")){
            button.setBackground(new Color(180, 173, 234));
        }else if(button_text.equals("Cancel")){
            button.setBackground(new Color(220,20,60));
        }
        
        int focusBorderSize = 5; // Set your desired size
        Border emptyBorder = BorderFactory.createEmptyBorder(focusBorderSize, focusBorderSize, focusBorderSize, focusBorderSize);
        button.setBorder(emptyBorder);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
    
}
