/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.LogIn;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
     
     public static int showQuestionMessageDialog(JFrame invoking_frame, String message, String title, int messageType, Icon icon) {
        Color backgroundColor = new Color(64, 89, 173);
        Color textBackgroundColor = new Color(180, 173, 234);

        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 12));

        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");

        yesButton.addActionListener(e -> {
            // Perform actions for Yes
            UIManager.put("OptionPane.returnValue", JOptionPane.YES_OPTION);
            UIManager.getLookAndFeel().provideErrorFeedback(yesButton);
            
            // Close the JOptionPane
            SwingUtilities.getWindowAncestor(yesButton).dispose();
            //open log in page
            new LogIn().setVisible(true);
            // close the invoking frame
            invoking_frame.dispose();
        });

        noButton.addActionListener(e -> {
            // Perform actions for No
            UIManager.put("OptionPane.returnValue", JOptionPane.NO_OPTION);
            UIManager.getLookAndFeel().provideErrorFeedback(noButton);
            
            // Close the JOptionPane
            SwingUtilities.getWindowAncestor(noButton).dispose();
        });

        Object[] options = {yesButton, noButton};

        int result = JOptionPane.showOptionDialog(
                null,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                messageType,
                icon,
                options,
                options[0]);

        // Reset UIManager properties to default values
        UIManager.put("OptionPane.background", UIManager.get("Panel.background"));
        UIManager.put("OptionPane.messageFont", UIManager.get("Label.font"));
        UIManager.put("Panel.background", UIManager.get("Panel.background"));

        return result;
    }
}
