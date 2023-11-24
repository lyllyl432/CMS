/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.AppointmentPending;
import Application.CancelAppointmentPending;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PendingButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int button_role;
    private int patient_id;
    private int reference_id;
    private String email;
    private String first_name;
    private String selected_date;
    private String approve_mail_message;
    private java.util.Date selectedDate;
    private SimpleDateFormat dateFormat;
    private PatientList patient_list;
    private ImageIcon icon;
        
    AppointmentList appointment_list;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UserInfo user_info;
    public PendingButtonEditor(AppointmentPending appointment_pending,JTable table,String button_text,JCheckBox checkBox, int button_role, UserInfo user_info) {
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
        
        //database connection object
            this.con = ConnectionProvider.connect();




            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //update click
                    if(button_role == 0){
                        approve_mail_message = "Appointment Approved";
                        if(table.isEditing()){
                            table.getCellEditor().stopCellEditing();
                        }
                            con = ConnectionProvider.connect();
                            //get selected row in jtable and get the patient id
                            int selected_row = table.getSelectedRow();
                            TableModel model = table.getModel();
                            patient_id = (int)model.getValueAt(selected_row, 7);
                            reference_id = (int)model.getValueAt(selected_row, 8);
                            
                            //get the pending entry and create an object using appointment list object
                            appointment_list = General.getApproveEntry(reference_id, appointment_list);
                            
                            //delete pending entry
                            General.deletePendingEntry(reference_id);
                            //insert the pending entry to the appointment table
                            General.insertAppointment(appointment_list);
                            //send mail to patient after the approval
                            General.sendMailToRecipient(patient_id,approve_mail_message);
                            //update the pending table after sending
                             icon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/CMS/src/checked.png");
                            CustomOptionPane.showMessageDialog("Approve", "Appointment Approved", JOptionPane.INFORMATION_MESSAGE, icon);
     
                            appointment_pending.showAdminPendingList();
                        } 
                    //delete click
                    else if(button_role == 1){
                        int selected_row = table.getSelectedRow();
                        TableModel model = table.getModel();
                        patient_id = (int)model.getValueAt(selected_row, 7);
                        reference_id = (int)model.getValueAt(selected_row, 8);
                        try {
                            ps = con.prepareStatement("SELECT firstname,middlename,lastname,email from patient WHERE patient_id = ?");
                            ps.setInt(1, patient_id);
                            //Execute the query
                            rs = ps.executeQuery();

                            //Process the result set
                            while(rs.next()) {
                                System.out.println(rs.getString("firstname"));
                                patient_list = new PatientList(rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), rs.getString("email"),patient_id);
                            }
                                new CancelAppointmentPending(patient_list,reference_id, appointment_pending).setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(PendingButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
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

        
    
    

