/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.MainDashboard;
import Application.UpdatePatient;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author AUDITOR FAMILY
 */
public class General {
    public static Connection con;
    public static PreparedStatement ps;
    public static PatientList patient_list;
    public static MedicineList medicine_list;
    public static DefaultTableModel model;
    private static  TableRowSorter sorter;
    public static void filterSearch(String query, JTable table){
          model = (DefaultTableModel)table.getModel();
          sorter = new TableRowSorter<>(model);
          table.setRowSorter(sorter);
          if(query.isEmpty()){
              sorter.setRowFilter(null);
          }else{
              RowFilter<TableModel, Object> filter = RowFilter.regexFilter(query, 1); // Adjust the column index as needed
              sorter.setRowFilter(filter);
          }
    }
    public static PatientList getPatientEntry(int patient_id){
        con = ConnectionProvider.connect();

        try {
            ps = con.prepareStatement("SELECT * FROM patient WHERE patient_id = ?;");
            ps.setInt(1,patient_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String first_name = rs.getString("firstname");
                String middle_name = rs.getString("middlename");
                String last_name = rs.getString("lastname");
                String suffix = rs.getString("suffix");
                int age = rs.getInt("age");
                String date_birth = rs.getString("date_of_birth");
                String email = rs.getString("email");
                String course = rs.getString("course");
                String year = rs.getString("college_year");
                String section = rs.getString("section");
                String civil_status = rs.getString("civil_status");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                String gender = rs.getString("gender");
                String height = rs.getString("height");
                String weight = rs.getString("weight");
                String blood_type = rs.getString("blood_type");
                String vaccination_status = rs.getString("vaccination_status");      
                patient_list = new PatientList(patient_id, first_name, middle_name, last_name, suffix,age,date_birth, email, course, year, section, civil_status, address, phone_number, gender,height,weight,blood_type,vaccination_status); 
            }
            return patient_list;
            
     
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }       
    }
    
    public static MedicineList getMedicineEntry(int medicine_id){
        con = ConnectionProvider.connect();
        try {
            ps = con.prepareStatement("SELECT * FROM medicines WHERE id = ?;");
            ps.setInt(1,medicine_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String medicine_name = rs.getString("medicine");
                String description = rs.getString("description");
                String medicine_type = rs.getString("medicine_type");
                String dosage = rs.getString("dosage");
                int stocks = rs.getInt("stock");
                medicine_list = new MedicineList(id, medicine_name, description, medicine_type, dosage,stocks,true);
            }
            return medicine_list;
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static void setProfileInfo(UserInfo user_info, JLabel greeting_name_label, JLabel admin_name_label){
       greeting_name_label.setText("Hello " + user_info.getWorkPosition() + " " + user_info.getFirstName() + "!");
       admin_name_label.setText(user_info.getWorkPosition() + " " + user_info.getFirstName());
       
        try {
            BufferedImage original_image = ImageIO.read(new File(user_info.getProfilePicture()));
            // Resize the image
            Image resizedImage = original_image.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            BufferedImage bufferedResizedImage = new BufferedImage(35, 35, BufferedImage.TYPE_INT_ARGB);
            bufferedResizedImage.getGraphics().drawImage(resizedImage, 0, 0, null);
            // Create a circular mask
            BufferedImage circularImage = createCircularImage(bufferedResizedImage);

            // Create an ImageIcon from the circular image
            ImageIcon icon = new ImageIcon(circularImage);
            admin_name_label.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static BufferedImage createCircularImage(BufferedImage originalImage) {
        BufferedImage circularImage = new BufferedImage(
                originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = circularImage.createGraphics();
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, originalImage.getWidth(), originalImage.getHeight());

        // Create a clipping mask using the ellipse
        g2d.setClip(ellipse);
        g2d.drawImage(originalImage, 0, 0, null);

        g2d.dispose();

        return circularImage;
    }
    
}
    