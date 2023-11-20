/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.PatientRecordPdf;
import Application.ViewPatientRecord;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author HP
 */
public class ViewRecordButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int button_role;
    private int patient_id;
    private String patient_name;
    private int reference_id;
    private String button_text;
    private AppointmentList appointment_list;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private PatientList patient;
    private UserInfo user_info;
    public ViewRecordButtonEditor(ViewPatientRecord view_patient_record,JTable table, String button_text,JCheckBox checkBox,UserInfo user_info, PatientList patient){
        super(checkBox);
        button = new JButton();
        button.setText(button_text);
        button.setOpaque(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        
        
        int focusBorderSize = 5; // Set your desired size
        Border emptyBorder = BorderFactory.createEmptyBorder(focusBorderSize, focusBorderSize, focusBorderSize, focusBorderSize);
        button.setBorder(emptyBorder);
        
        this.user_info = user_info;
        this.patient = patient;
        //database connection object
        this.con = ConnectionProvider.connect();
        
        button.addActionListener((ActionEvent e) -> {
             int selected_row = table.getSelectedRow();
             TableModel model = table.getModel();
             reference_id = (int)model.getValueAt(selected_row, 7);
             PatientRecordPdf patient_record_frame = new PatientRecordPdf(patient.getFullName(),patient,reference_id);
             patient_record_frame.setVisible(true);
             //convert JFrame into a pdf file
                General.createAndOpenPDF(patient_record_frame);
             patient_record_frame.dispose();
            
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

