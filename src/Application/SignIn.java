/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Application;

import Utilities.AccountManager;
import Utilities.ConnectionProvider;
import Utilities.CustomOptionPane;
import Utilities.General;
import Utilities.PatientList;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author AUDITOR FAMILY
 */
public class SignIn extends javax.swing.JFrame {

    /**
     * Creates new form SignIn
     */
    String file_path;
    Connection con;
    PreparedStatement ps;
    private ImageIcon icon;
    public SignIn() {
        initComponents();
        adjustScrollBar();
    }
    
    public void adjustScrollBar(){
        this.scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar vertical_scroll_bar = this.scroll_pane.getVerticalScrollBar();
        vertical_scroll_bar.setUnitIncrement(5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        scroll_pane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        first_name_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        middle_name_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        last_name_field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        suffix_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        civil_status_field = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        gender_field = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address_field = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        age_field = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        work_position_field = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        contact_number_field = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        check_box_log = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        file_label = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Create an Account!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 22, -1, -1));

        jPanel2.setBackground(new java.awt.Color(64, 89, 173));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1416, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1416));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 91, -1, -1));

        jButton1.setBackground(new java.awt.Color(180, 173, 234));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Choose File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 234, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("First Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 270, -1, -1));

        first_name_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 293, 500, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Middle Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 339, -1, -1));

        middle_name_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(middle_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 362, 500, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Last Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 408, -1, -1));

        last_name_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 431, 500, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Suffix:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 477, -1, -1));

        username_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1102, 500, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Age:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 546, -1, -1));

        suffix_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(suffix_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 500, 500, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Gender:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 615, -1, -1));

        civil_status_field.setBackground(new java.awt.Color(180, 173, 234));
        civil_status_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        civil_status_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Divorced", "Widowed" }));
        jPanel1.add(civil_status_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 707, 500, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Civil Status:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 684, -1, -1));

        gender_field.setBackground(new java.awt.Color(180, 173, 234));
        gender_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        gender_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel1.add(gender_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 638, 500, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Address:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 753, -1, -1));

        address_field.setColumns(20);
        address_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        address_field.setRows(5);
        jScrollPane2.setViewportView(address_field);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 776, 500, 100));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Work Position:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 963, -1, -1));

        age_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 569, 500, 40));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Contact Number:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 888, -1, -1));

        work_position_field.setBackground(new java.awt.Color(180, 173, 234));
        work_position_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        work_position_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Nurse", "Doctor", " " }));
        jPanel1.add(work_position_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 986, 500, 40));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(64, 89, 173));
        jLabel14.setText("PERSONAL INFORMATION");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 68, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(64, 89, 173));
        jLabel15.setText("LOG IN CREDENTIALS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1050, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Username:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1079, -1, -1));

        contact_number_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(contact_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 911, 500, 40));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Password:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1217, -1, -1));

        password_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1240, 500, 40));

        check_box_log.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        check_box_log.setText("Show Password");
        check_box_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_box_logActionPerformed(evt);
            }
        });
        jPanel1.add(check_box_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1286, -1, -1));

        jButton2.setBackground(new java.awt.Color(180, 173, 234));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Register Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1313, 500, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 1406, 525, 10));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Already have an account?");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 1371, -1, -1));

        jLabel20.setBackground(new java.awt.Color(64, 89, 173));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(64, 89, 173));
        jLabel20.setText("Log in!");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 1371, -1, -1));

        file_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/no-photos.png"))); // NOI18N
        jPanel1.add(file_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 91, 200, 137));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Email");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1148, -1, -1));

        email_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1171, 500, 40));

        scroll_pane.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//select image on file manager and display to the label
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser file_chooser  = new JFileChooser();
        int return_value = file_chooser.showOpenDialog(null);
        
        if(return_value == JFileChooser.APPROVE_OPTION){
            File selected_file = file_chooser.getSelectedFile();
            Image original_image;
            try {
                original_image = ImageIO.read(selected_file);
                Image scaled_image = original_image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
                ImageIcon image_icon = new ImageIcon(scaled_image);
                this.file_label.setIcon(image_icon);
                
                file_path = selected_file.getAbsolutePath();
              
            } catch (IOException ex) {
                Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//           
//            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//if already have an account click log in to go to the log in frame
    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked
//password checker 
    private void check_box_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_box_logActionPerformed
        this.password_field.setEchoChar(check_box_log.isSelected() ? '\0' : '*');

    }//GEN-LAST:event_check_box_logActionPerformed
//register account button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //connection provider object
        this.con = ConnectionProvider.connect();

        int user_id = -1;
        //log in credentials
        String username = this.username_field.getText();
        char[] password_chars = this.password_field.getPassword();
        String password = new String(password_chars);
        String email = this.email_field.getText();
        //personal information
        String first_name = this.first_name_field.getText();
        String middle_name = this.middle_name_field.getText();
        String last_name = this.last_name_field.getText();
        String suffix = this.suffix_field.getText();
        String age_text = this.age_field.getText();
        String gender = this.gender_field.getSelectedItem().toString();
        String civil_status = this.civil_status_field.getSelectedItem().toString();
        String address = this.address_field.getText();
        String contact_number = this.contact_number_field.getText();
        String work_position = this.work_position_field.getSelectedItem().toString();
        int age = -1;
        
        if(AccountManager.isValidInput(file_path,username, password, email, first_name,age_text, gender,civil_status,address,contact_number, work_position,gender)){
            //convert the age text to integer after validation
            age = AccountManager.isValidInt(age_text) ? Integer.parseInt(age_text) : 0;

          if(!AccountManager.isUsernameAvailable(username)){
              icon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/CMS/src/loginfailed.png");
              CustomOptionPane.showMessageDialog("Username is already taken. Please choose a different username.", "Username Taken", JOptionPane.INFORMATION_MESSAGE, icon);
               
         }else if(!AccountManager.isValidEmail(email)){
             icon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/CMS/src/loginfailed.png");
             CustomOptionPane.showMessageDialog("Please enter a valid email address.", "Invalid Email", JOptionPane.INFORMATION_MESSAGE, icon);
               
         }else if(!AccountManager.isValidPassword(password)){
             icon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/CMS/src/lock.png");
             CustomOptionPane.showMessageDialog("Password must have at least 8 characters.", "Invalid Password", JOptionPane.INFORMATION_MESSAGE, icon);
                   
         }else{
        try {
            //hash password for database insertion
           String hash_password = AccountManager.hashPassword(password);
            this.ps = this.con.prepareStatement("INSERT INTO user(username,password,email) VALUES(?,?,?);");
            this.ps.setString(1, username);
            this.ps.setString(2, hash_password);
            this.ps.setString(3, email);
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ps = this.con.prepareStatement("SELECT user_id FROM user WHERE username = ?;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user_id = rs.getInt("user_id");
           }
            this.ps = this.con.prepareStatement("INSERT INTO user_info (user_id,profile_picture,first_name,middle_name,last_name,suffix,age,civil_status,address,contact_number,work_position) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                this.ps.setInt(1, user_id);
                this.ps.setString(2, file_path);
                this.ps.setString(3, first_name);
                this.ps.setString(4, middle_name);
                this.ps.setString(5, last_name);
                this.ps.setString(6, suffix);
                this.ps.setInt(7, age);
                this.ps.setString(8, civil_status);
                this.ps.setString(9, address);
                this.ps.setString(10, contact_number);
                this.ps.setString(11, work_position);
                this.ps.executeUpdate();
                this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      } else{
       String error_message = AccountManager.validRequiredFields(file_path,first_name, last_name,age_text, email,contact_number, work_position, address, username, password);
        // Display the message only if there are required fields missing
        if (!error_message.equals("Please fill up the required fields:\n")) {
            icon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/CMS/src/loginfailed.png");
            CustomOptionPane.showMessageDialog(error_message, "Required Fields", JOptionPane.INFORMATION_MESSAGE, icon);
                
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address_field;
    private javax.swing.JTextField age_field;
    private javax.swing.JCheckBox check_box_log;
    private javax.swing.JComboBox<String> civil_status_field;
    private javax.swing.JTextField contact_number_field;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel file_label;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JComboBox<String> gender_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JTextField middle_name_field;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JScrollPane scroll_pane;
    private javax.swing.JTextField suffix_field;
    private javax.swing.JTextField username_field;
    private javax.swing.JComboBox<String> work_position_field;
    // End of variables declaration//GEN-END:variables
}
