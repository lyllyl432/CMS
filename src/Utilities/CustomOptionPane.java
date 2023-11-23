/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class CustomOptionPane {
     public static void showMessageDialog(String message, String title, int messageType, Icon icon) {
        SwingUtilities.invokeLater(() -> {
            Color backgroundColor = new Color(64, 89, 173);
            Color textBackgroundColor = new Color(180, 173, 234);


            UIManager.put("OptionPane.background", backgroundColor);
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 12));

            JOptionPane optionPane = new JOptionPane(message, messageType);
            optionPane.setIcon(icon);

            JDialog dialog = optionPane.createDialog(null, title);
            dialog.setVisible(true);
            
            JPanel panel = new JPanel();
            panel.setBackground(textBackgroundColor);

            // Reset UIManager properties to default values
            UIManager.put("OptionPane.background", UIManager.get("Panel.background"));
            UIManager.put("OptionPane.messageFont", UIManager.get("Label.font"));
            UIManager.put("Panel.background", UIManager.get("Panel.background"));
        });
    }
}
