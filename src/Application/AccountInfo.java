/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Application;

import Utilities.AccountManager;
import Utilities.ConnectionProvider;
import Utilities.General;
import Utilities.UserInfo;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AccountInfo extends javax.swing.JFrame {

    /**
     * Creates new form AccountInfo
     */
    private UserInfo user_info;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String file_path;
    private int user_id;
    public AccountInfo() {
        initComponents();
    }
    public AccountInfo(UserInfo user_info){
        initComponents();
        this.user_info = user_info;
        this.user_id = user_info.getUserId();
        fillAccountInfo();
        General.setProfileInfo(user_info, this.greeting_name_label, this.admin_name_label);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        appointment_label = new javax.swing.JLabel();
        admin_name_label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        greeting_name_label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        scroll_pane = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        first_name_field = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        middle_name_field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        last_name_field = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        suffix_field = new javax.swing.JTextField();
        civil_status_field = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address_field = new javax.swing.JTextArea();
        age_field = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        contact_number_field = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        confirm_password_field = new javax.swing.JPasswordField();
        check_box_log = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        file_label = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        old_password_field = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        new_password_field = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel33.setBackground(new java.awt.Color(64, 89, 173));

        jPanel34.setBackground(new java.awt.Color(64, 89, 173));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("TCC CARES");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthcare (1) (1).png"))); // NOI18N
        jLabel1.setText("Medicines");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/business-report (1).png"))); // NOI18N
        jLabel2.setText("Dashboard");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient (1).png"))); // NOI18N
        jLabel3.setText("Patients");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        appointment_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        appointment_label.setForeground(new java.awt.Color(255, 255, 255));
        appointment_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reports.png"))); // NOI18N
        appointment_label.setText("Appointments");
        appointment_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointment_labelMouseClicked(evt);
            }
        });

        admin_name_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        admin_name_label.setForeground(new java.awt.Color(255, 255, 255));
        admin_name_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/administrator (1).png"))); // NOI18N
        admin_name_label.setText("Administrator");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notification (1).png"))); // NOI18N
        jLabel6.setText("Pending Appointments");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-user.png"))); // NOI18N
        jLabel8.setText("Add Account");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(appointment_label)
                            .addComponent(admin_name_label)
                            .addComponent(jLabel3))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admin_name_label)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(appointment_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 151, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(64, 89, 173));

        greeting_name_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        greeting_name_label.setForeground(new java.awt.Color(255, 255, 255));
        greeting_name_label.setText("Hello, Admin!");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Log out");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greeting_name_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greeting_name_label)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 22, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 91, -1, -1));

        jButton1.setBackground(new java.awt.Color(180, 173, 234));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Choose File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 234, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("First Name:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 270, -1, -1));

        first_name_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(first_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 293, 500, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Middle Name:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 339, -1, -1));

        middle_name_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(middle_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 362, 500, 40));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Last Name:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 408, -1, -1));

        last_name_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(last_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 431, 500, 40));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Suffix:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 477, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Age:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 546, -1, -1));

        suffix_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(suffix_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 500, 500, 40));

        civil_status_field.setBackground(new java.awt.Color(180, 173, 234));
        civil_status_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        civil_status_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Divorced", "Widowed" }));
        jPanel2.add(civil_status_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, 500, 40));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Civil Status:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Address:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, -1, -1));

        address_field.setColumns(20);
        address_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        address_field.setRows(5);
        jScrollPane2.setViewportView(address_field);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 710, 500, 100));

        age_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 569, 500, 40));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Contact Number:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 820, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(64, 89, 173));
        jLabel20.setText("PERSONAL INFORMATION");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 68, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(64, 89, 173));
        jLabel22.setText("CHANGE PASSWORD");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 950, -1, -1));

        contact_number_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(contact_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 840, 500, 40));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setText("Confirm Password");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1140, -1, -1));

        confirm_password_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(confirm_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1160, 500, 40));

        check_box_log.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        check_box_log.setText("Show Password");
        check_box_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_box_logActionPerformed(evt);
            }
        });
        jPanel2.add(check_box_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1210, -1, -1));

        jButton2.setBackground(new java.awt.Color(180, 173, 234));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Update Profile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 890, 500, 40));

        file_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/no-photos.png"))); // NOI18N
        jPanel2.add(file_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 91, 200, 137));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel28.setText("Old Password");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 990, -1, 20));

        old_password_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(old_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1020, 500, 40));

        jButton3.setBackground(new java.awt.Color(180, 173, 234));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Change Password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1250, 500, 40));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setText("New Password:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1070, -1, -1));

        new_password_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(new_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1090, 500, 40));

        scroll_pane.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void fillAccountInfo(){
        //get the latest image file path from user_info
        ImageIcon original_icon = new ImageIcon(user_info.getProfilePicture());
        
        //resize the image
        Image original_image = original_icon.getImage();
        Image resized_image = original_image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        //set the icon to the image label
        ImageIcon resized_icon = new ImageIcon(resized_image);
        this.file_label.setIcon(resized_icon);
        
        //set the user info in text fields
        this.first_name_field.setText(user_info.getFirstName());
        this.middle_name_field.setText(user_info.getMiddleName());
        this.last_name_field.setText(user_info.getLastName());
        this.suffix_field.setText(user_info.getSuffix());
        this.age_field.setText(Integer.toString(user_info.getAge()));
        this.civil_status_field.setSelectedItem(user_info.getCivilStatus());
        this.address_field.setText(user_info.getAddress());
        this.contact_number_field.setText(user_info.getContactNumber());
        
    }
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Medicine(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        switch(user_info.getWorkPosition()){
            case "Doctor":
            new MainDashboard(user_info).setVisible(true);
            break;
            case "Nurse":
            new MainDashboard(user_info).setVisible(true);
            break;
            case "Staff":
            new Dashboard(user_info).setVisible(true);
            break;
            default:
            System.out.println("Something error");
        }
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void appointment_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointment_labelMouseClicked
        new Appointment(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_appointment_labelMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new AppointmentPending(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        new SignIn().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser file_chooser  = new JFileChooser();
        int return_value = file_chooser.showOpenDialog(null);

        if(return_value == JFileChooser.APPROVE_OPTION){
            try {
                File selected_file = file_chooser.getSelectedFile();
                Image original_image;
                
                original_image = ImageIO.read(selected_file);
                Image scaled_image = original_image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
                ImageIcon image_icon = new ImageIcon(scaled_image);
                this.file_label.setIcon(image_icon);

                file_path = selected_file.getAbsolutePath();
            } catch (IOException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void check_box_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_box_logActionPerformed
        this.confirm_password_field.setEchoChar(check_box_log.isSelected() ? '\0' : '*');
    }//GEN-LAST:event_check_box_logActionPerformed
//update profile button click
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //personal information
        String first_name = this.first_name_field.getText();
        String middle_name = this.middle_name_field.getText();
        String last_name = this.last_name_field.getText();
        String suffix = this.suffix_field.getText();
        String age_text = this.age_field.getText();
        String civil_status = this.civil_status_field.getSelectedItem().toString();
        String address = this.address_field.getText();
        String contact_number = this.contact_number_field.getText();
        int age = 0;


        this.con = ConnectionProvider.connect();
        if(AccountManager.isValidInput( first_name,last_name,age_text,address,contact_number)){
        
            //convert age text to integer after validation
            age = AccountManager.isValidInt(age_text) ? Integer.parseInt(age_text) : 0;
            
            try {
            ps = this.con.prepareStatement("UPDATE user_info SET profile_picture = ?, first_name = ?,middle_name = ?,last_name = ?,suffix = ?,age = ?,civil_status = ?,address = ?,contact_number = ?,work_position = ? WHERE user_id = ?");
            if(file_path == null){
             ps.setString(1,user_info.getProfilePicture());   
            }else{
             ps.setString(1, file_path);   
            }
            ps.setString(2, first_name);
            ps.setString(3, middle_name);
            ps.setString(4, last_name);
            ps.setString(5, suffix);
            ps.setInt(6, age);
            ps.setString(7, civil_status);
            ps.setString(8, address);
            ps.setString(9, contact_number);
            ps.setString(10,user_info.getWorkPosition());
            ps.setInt(11, user_id);
            
             int rowsUpdated = this.ps.executeUpdate();
            if(rowsUpdated > 0){
                //update user_info object to an updated entry in database
                user_info = General.getUserInfoEntry(user_id);
                JOptionPane.showMessageDialog(null, "Information updated successfully!");
                //update the form fields
                this.fillAccountInfo();
                //update the admin profile interface
                General.setProfileInfo(user_info, greeting_name_label, admin_name_label);
            }else{
                System.out.println("Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
       String error_message = AccountManager.validRequiredFields(first_name, last_name,age_text,contact_number, address);
        // Display the message only if there are required fields missing
        if (!error_message.equals("Please fill up the required fields:\n")) {
            JOptionPane.showMessageDialog(this, error_message);
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//change password button click
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String old_password_entry = AccountManager.getOldPassword(user_id);
        //old password user input
        char[] old_password_confirmation_chars = this.old_password_field.getPassword();
        String old_password_confirmation = AccountManager.hashPassword(new String(old_password_confirmation_chars));
        //new password user input
        char[] new_password_chars = this.new_password_field.getPassword();
        String new_password = new String(new_password_chars);
        //confirmation password user input
        char[] confirmation_password_chars = this.confirm_password_field.getPassword();
        String confirm_password = new String(confirmation_password_chars);
        String new_hash_password;
        
        if(old_password_entry.equals(old_password_confirmation)){
            if(!AccountManager.isValidPassword(new_password)){
                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long");

            }else{
                if(AccountManager.validateNewPassword(new_password, confirm_password)){
                    new_hash_password = AccountManager.hashPassword(new_password);
                   AccountManager.updatePassword(user_id, new_hash_password);
                   JOptionPane.showMessageDialog(null, "Password changed successfully!");

                   this.old_password_field.setText("");
                   this.new_password_field.setText("");
                   this.confirm_password_field.setText("");
                }else{
                   JOptionPane.showMessageDialog(null, "New password and confirm password do not match.");
                   }   
            }
        }else{
                JOptionPane.showMessageDialog(null, "Authentication failed. Invalid old password.");
   
        }
    }//GEN-LAST:event_jButton3ActionPerformed
//patient nav click
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new Patient(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address_field;
    private javax.swing.JLabel admin_name_label;
    private javax.swing.JTextField age_field;
    private javax.swing.JLabel appointment_label;
    private javax.swing.JCheckBox check_box_log;
    private javax.swing.JComboBox<String> civil_status_field;
    private javax.swing.JPasswordField confirm_password_field;
    private javax.swing.JTextField contact_number_field;
    private javax.swing.JLabel file_label;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel greeting_name_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JTextField middle_name_field;
    private javax.swing.JPasswordField new_password_field;
    private javax.swing.JPasswordField old_password_field;
    private javax.swing.JScrollPane scroll_pane;
    private javax.swing.JTextField suffix_field;
    // End of variables declaration//GEN-END:variables
}
