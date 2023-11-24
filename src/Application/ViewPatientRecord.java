/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Application;

import Utilities.ConnectionProvider;
import Utilities.CustomOptionPane;
import Utilities.General;
import Utilities.MedicineList;
import Utilities.PatientList;
import Utilities.PatientRecordList;
import Utilities.UserInfo;
import Utilities.ViewRecordButtonEditor;
import Utilities.ViewRecordButtonRenderer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author HP
 */
public class ViewPatientRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewPatientRecord
     */
    private int patient_id;
    private PatientList patient;
    private PatientRecordList patient_record_list;
    private UserInfo user_info;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel model;
    private MedicineList medicine_list;
    private ImageIcon icon;
    
    public ViewPatientRecord() {
        initComponents();
    }
    //method overloading for another constructor call
    public ViewPatientRecord(UserInfo user_info, PatientList patient) {
        initComponents();
        this.user_info = user_info;
        this.patient = patient;
        //patient interface and admin interface sidebar logic
       General.setProfileInfo(user_info, this.greeting_name_label, this.admin_name_label);
       General.setUpSideBar(this.appointment_label, this.medicine_label, this.add_account_label, this.patient_label,this,user_info);
       General.setSizeSidePanel(side_bar_panel,200,700);
        this.showPatientInformation();
        this.showPatientRecords();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel47 = new javax.swing.JPanel();
        side_bar_panel = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        medicine_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        patient_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        admin_name_label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        appointment_label = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        add_account_label = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patient_information_table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        patient_record_table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        greeting_name_label = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        side_bar_panel.setBackground(new java.awt.Color(64, 89, 173));

        jPanel49.setBackground(new java.awt.Color(64, 89, 173));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("TCC CARES");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel26)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(25, 25, 25))
        );

        medicine_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        medicine_label.setForeground(new java.awt.Color(255, 255, 255));
        medicine_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthcare (1) (1).png"))); // NOI18N
        medicine_label.setText("Medicines");
        medicine_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicine_labelMouseClicked(evt);
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

        patient_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        patient_label.setForeground(new java.awt.Color(255, 255, 255));
        patient_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient (1).png"))); // NOI18N
        patient_label.setText("Patients");
        patient_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_labelMouseClicked(evt);
            }
        });

        admin_name_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        admin_name_label.setForeground(new java.awt.Color(255, 255, 255));
        admin_name_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/administrator (1).png"))); // NOI18N
        admin_name_label.setText("Administrator");
        admin_name_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_name_labelMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        appointment_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        appointment_label.setForeground(new java.awt.Color(255, 255, 255));
        appointment_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reports.png"))); // NOI18N
        appointment_label.setText("Appointments");
        appointment_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointment_labelMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notification (1).png"))); // NOI18N
        jLabel10.setText("Pending Appointments");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        add_account_label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add_account_label.setForeground(new java.awt.Color(255, 255, 255));
        add_account_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-user.png"))); // NOI18N
        add_account_label.setText("Add Account");
        add_account_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_account_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_bar_panelLayout = new javax.swing.GroupLayout(side_bar_panel);
        side_bar_panel.setLayout(side_bar_panelLayout);
        side_bar_panelLayout.setHorizontalGroup(
            side_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_bar_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(side_bar_panelLayout.createSequentialGroup()
                        .addGroup(side_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(medicine_label)
                            .addComponent(admin_name_label)
                            .addGroup(side_bar_panelLayout.createSequentialGroup()
                                .addComponent(add_account_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(appointment_label)
                            .addComponent(jLabel10)
                            .addGroup(side_bar_panelLayout.createSequentialGroup()
                                .addComponent(patient_label)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        side_bar_panelLayout.setVerticalGroup(
            side_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_bar_panelLayout.createSequentialGroup()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admin_name_label)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(side_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(patient_label)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(medicine_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appointment_label)
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_account_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 325, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(180, 173, 234));

        patient_information_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient's Name", "Contact Number", "Email", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(patient_information_table);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Patient Record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        patient_record_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reference ID", "Reason", "Doctor", "Review Date", "Prescription Date", "Status", "", "Reference ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(patient_record_table);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Prescription Records");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(64, 89, 173));

        greeting_name_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        greeting_name_label.setForeground(new java.awt.Color(255, 255, 255));
        greeting_name_label.setText("Hello, Admin!");

        jButton4.setBackground(new java.awt.Color(220, 20, 60));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(greeting_name_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greeting_name_label)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(side_bar_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_bar_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 702, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //show Patient Records
    public void showPatientRecords(){
        String view_button_text = "View";
        ArrayList<PatientRecordList> recordArrayList = patientRecordList();
        model = (DefaultTableModel)this.patient_record_table.getModel();
         Object[] row = new Object[8];
         
        //set table font to times new roman
         General.setTableFont(this.patient_record_table);
        // create a button renderer and button editor for the view record of each reference
         this.patient_record_table.getColumnModel().getColumn(6).setCellRenderer(new ViewRecordButtonRenderer(view_button_text));
         // Create a custom cell editor for the button column
         this.patient_record_table.getColumnModel().getColumn(6).setCellEditor(new ViewRecordButtonEditor(this,this.patient_record_table,view_button_text,new JCheckBox(),user_info, patient));
        

        for(int i = 0; i < recordArrayList.size(); i++){
            String appointment_date = General.convertDateToReadable(recordArrayList.get(i).getAppointmentDate().toString());
            String review_date = General.convertDateToReadable(recordArrayList.get(i).getReviewDate().toString());
            row[0] = "RID" + recordArrayList.get(i).getReferenceId();
            row[1] = recordArrayList.get(i).getReason();
            row[2] = recordArrayList.get(i).getClinicPosition();
            row[3] = review_date;
            row[4] = appointment_date;
            boolean completed_status = recordArrayList.get(i).getStatus();
            if(completed_status){
                row[5] = "Completed";
            }else{
                row[5] = null;
            }
            row[7] = recordArrayList.get(i).getReferenceId();
             
            model.addRow(row);
            
             this.patient_record_table.setRowHeight(50);
       this.patient_record_table.getColumnModel().getColumn(0).setPreferredWidth(100);
       this.patient_record_table.getColumnModel().getColumn(1).setPreferredWidth(250);
       this.patient_record_table.getColumnModel().getColumn(2).setPreferredWidth(100);
       this.patient_record_table.getColumnModel().getColumn(3).setPreferredWidth(150);
       this.patient_record_table.getColumnModel().getColumn(4).setPreferredWidth(150);
       this.patient_record_table.getColumnModel().getColumn(5).setPreferredWidth(80);


        TableColumnModel columnModel = this.patient_record_table.getColumnModel();
        General.setColumnWidthZero(columnModel, 7);
        }
         
    }
//get Patient Records
    public ArrayList<PatientRecordList> patientRecordList(){
        ArrayList<PatientRecordList> patientRecordArrayList = new ArrayList<>();
        this.con = ConnectionProvider.connect();
        try {
            ps = con.prepareStatement("SELECT * FROM patient_record WHERE patient_id = ?");
            ps.setInt(1, patient.getPatientId());
            rs = ps.executeQuery();
            while(rs.next()){
                patient_record_list = new PatientRecordList(rs.getInt("reference_id"), rs.getString("clinic_position"), rs.getString("reason"), rs.getString("review_message"), rs.getDate("appointment_date"), rs.getDate("review_date"),rs.getBoolean("status"));
                patientRecordArrayList.add(patient_record_list);
            }
            return patientRecordArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ViewPatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //show patient information based on PatientList object 
    public void showPatientInformation(){
     model = (DefaultTableModel)this.patient_information_table.getModel();
         Object[] row = new Object[4];  

        //set table font to times new roman
         General.setTableFont(this.patient_information_table);
        
        row[0] = patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName();
        row[1] = patient.getPhoneNumber();
        row[2] = patient.getEmail();
        row[3] = patient.getAddress();
        model.addRow(row);
        this.patient_information_table.setRowHeight(50);
        
        
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        icon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/CMS/src/loginfailed.png");

        CustomOptionPane.showQuestionMessageDialog(
            this,
            "Are you sure you want to log out?",
            "Custom Dialog",
            JOptionPane.QUESTION_MESSAGE,
            icon);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void add_account_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_account_labelMouseClicked
        new SignIn().setVisible(true);
    }//GEN-LAST:event_add_account_labelMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new AppointmentPending(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void appointment_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointment_labelMouseClicked
        new Appointment(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_appointment_labelMouseClicked

    private void admin_name_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_name_labelMouseClicked
        new AccountInfo(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_admin_name_labelMouseClicked

    private void patient_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_labelMouseClicked
        if(user_info.getWorkPosition().equals("Patient")){
            ViewPatient view_patient = new ViewPatient(user_info);
            view_patient.setVisible(true);
            view_patient.fillInformationLabel(General.getPatientEntry(user_info.getPatientId()));
        }else{
            new Patient(user_info).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_patient_labelMouseClicked

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
                case "Patient":
                    //get the patient_id 
                    new PatientDashboard(user_info).setVisible(true);            
                    break;
            }
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void medicine_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicine_labelMouseClicked
        new Medicine(user_info).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_medicine_labelMouseClicked

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
            java.util.logging.Logger.getLogger(ViewPatientRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPatientRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPatientRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPatientRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPatientRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_account_label;
    private javax.swing.JLabel admin_name_label;
    private javax.swing.JLabel appointment_label;
    private javax.swing.JLabel greeting_name_label;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel medicine_label;
    private javax.swing.JTable patient_information_table;
    private javax.swing.JLabel patient_label;
    private javax.swing.JTable patient_record_table;
    private javax.swing.JPanel side_bar_panel;
    // End of variables declaration//GEN-END:variables
}
