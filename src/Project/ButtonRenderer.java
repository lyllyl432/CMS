/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author AUDITOR FAMILY
 */
public class ButtonRenderer extends JButton implements TableCellRenderer{
    private JButton button;

    public ButtonRenderer(Icon icon) {
         button = new JButton();
        button.setIcon(icon); // Set the icon on the button
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);   
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      
        return button;
    }
    
}
