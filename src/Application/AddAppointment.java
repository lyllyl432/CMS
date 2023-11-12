/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Application;

import Utilities.ConnectionProvider;
import Utilities.PatientList;
import Utilities.UserInfo;
import com.raven.event.EventTimePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.text.ParseException;
/**
 *
 * @author HP
 */
public class AddAppointment extends javax.swing.JFrame {

    /**
     * Creates new form AddAppointment
     */
    PatientList patient;
    Connection con;
    PreparedStatement ps;
    UserInfo user_info;
    ViewPatient viewPatient;
    public AddAppointment() {
        initComponents();
    }
//create an overload of constructor to initiate a patient object
    public AddAppointment(PatientList patient, UserInfo user_info, ViewPatient viewPatient) {
        initComponents();
        this.patient = patient;
        this.user_info = user_info;
        this.viewPatient = viewPatient;
        populateComboBox();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        date_appointment_chooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        time_picker_label = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        choose_worker_box = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reason_text_box = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        timePicker1.setDisplayText(time_picker_label);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(64, 89, 173));
        jLabel1.setText("APPOINTMENT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 15, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1161, 10));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Date of Appointment:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 66, -1, -1));

        date_appointment_chooser.setBackground(new java.awt.Color(180, 173, 234));
        jPanel1.add(date_appointment_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 89, 720, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Time");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 141, -1, -1));

        time_picker_label.setEditable(false);
        time_picker_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(time_picker_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 164, 620, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Doctor / Nurse");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 216, -1, -1));

        choose_worker_box.setBackground(new java.awt.Color(180, 173, 234));
        choose_worker_box.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(choose_worker_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 239, 726, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Reason");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 291, -1, -1));

        reason_text_box.setColumns(20);
        reason_text_box.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reason_text_box.setRows(5);
        jScrollPane1.setViewportView(reason_text_box);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 314, 726, 131));

        jButton1.setBackground(new java.awt.Color(180, 173, 234));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, -1, -1));

        jButton3.setBackground(new java.awt.Color(180, 173, 234));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, -1));

        jButton2.setBackground(new java.awt.Color(180, 173, 234));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Select Time");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   //populate combo box according to the work position of user info table
    public void populateComboBox(){
        this.con = ConnectionProvider.connect();
         DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
         
        try {
            this.ps = con.prepareStatement("SELECT work_position, first_name, middle_name, last_name FROM user_info WHERE work_position IN ('Nurse', 'Doctor')");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String work_position = rs.getString("work_position");
//                System.out.println(work_position);
                if(work_position.equals("Doctor")){
                    comboBoxModel.addElement("Dr. " + rs.getString("first_name") + " " + rs.getString("middle_name") + " " + rs.getString("last_name"));
                }else if(work_position.equals("Nurse")){
                    comboBoxModel.addElement("CN. " + rs.getString("first_name") + " " + rs.getString("middle_name") + " " + rs.getString("last_name"));

                }
                this.choose_worker_box.setModel(comboBoxModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.timePicker1.showPopup(this, 30, 230);
    }//GEN-LAST:event_jButton2ActionPerformed
//submit pending appointment button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.con = ConnectionProvider.connect();
        Date selectedDate = this.date_appointment_chooser.getDate();
        Date empty_date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        int patient_id = patient.getPatientId();
        String appointment_date = dateFormat.format(selectedDate);
        String time_value = this.time_picker_label.getText();
        String choose_worker = this.choose_worker_box.getSelectedItem().toString();
        String reason = this.reason_text_box.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Date date;
        java.sql.Time time = null; 
        try {
            date = sdf.parse(time_value);
             time = new java.sql.Time(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        try {
            this.ps = this.con.prepareStatement("INSERT INTO pending(patient_id,appointment_date, time, clinic_position, reason,status) VALUES(?,?,?,?,?,?);");
            this.ps.setInt(1, patient_id);
            this.ps.setString(2, appointment_date);
            this.ps.setTime(3, time);
            this.ps.setString(4, choose_worker);
            this.ps.setString(5, reason);
            this.ps.setBoolean(6, false);
            this.ps.executeUpdate();
            new AppointmentPending(user_info).setVisible(true);
            viewPatient.dispose();
            this.dispose();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> choose_worker_box;
    private com.toedter.calendar.JDateChooser date_appointment_chooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea reason_text_box;
    private com.raven.swing.TimePicker timePicker1;
    private javax.swing.JTextField time_picker_label;
    // End of variables declaration//GEN-END:variables
}