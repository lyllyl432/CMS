/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;
import java.sql.*;
/**
 *
 * @author AUDITOR FAMILY
 */
public class ConnectionProvider {
    public static Connection connect(){
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system", "root", "");
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}
