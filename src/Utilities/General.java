/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.UpdatePatient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static PatientList patient;
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
    public static PatientList getEntry(int patient_id){
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
                patient = new PatientList(patient_id, first_name, middle_name, last_name, suffix,age,date_birth, email, course, year, section, civil_status, address, phone_number, gender,height,weight,blood_type,vaccination_status); 
            }
            return patient;
            
     
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
    