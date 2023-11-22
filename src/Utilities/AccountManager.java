/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

/**
 *
 * @author HP
 */
public class AccountManager {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    //string to hash password converter
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
            return null;
        }
    }
    //get latest password from database
    public static String getOldPassword(int user_id){
        String old_password = null;
        con = ConnectionProvider.connect();
        
        try {
            ps = con.prepareStatement("SELECT password FROM user WHERE user_id = ?");
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while(rs.next()){
                old_password = rs.getString("password");
            }
            return old_password;
        } catch (SQLException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //validate new input password
    public static boolean validateNewPassword(String new_password, String confirm_password){
        return new_password.equals(confirm_password);
    }
    //update to new password
    public static void updatePassword(int user_id, String new_password){
        try {
            con = ConnectionProvider.connect();
            ps = con.prepareStatement("UPDATE user SET password = ? WHERE user_id = ?");
            ps.setString(1, new_password);
            ps.setInt(2, user_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Validation method to check if specific fields are filled up
        public static boolean isValidInput(Object... values) {
            for (Object value : values) {
                if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
                    return false;
                }
            }
            return true;
        }
         // Validation method for integer
        public static boolean isValidInt(String value) {
            try {
                Integer.parseInt(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

    //field characters authentication
        public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        // Regular expression for a simple email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
        //check the username availability
        public static boolean isUsernameAvailable(String username){
        try {
            con = ConnectionProvider.connect();
            ps = con.prepareStatement("SELECT * FROM user WHERE username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; //exception handling
        }
        
        //validation of password
        public static boolean isValidPassword(String password) {
            // Add your password validation logic here
            // For example, you might want to check for a minimum length
            return password != null && password.length() >= 8;
        }
        
        //validation of patient username
        public static boolean isValidUserName(String username) {
    // Check if the username is not null, not empty, and starts with "TCC"
    return username != null && !username.trim().isEmpty() && username.startsWith("TCC");
        }
        
        //Validation of all required fields in patient sign in
        public static String validRequiredFields(String first_name, String last_name, String age_text, String date_birth, String email,
                                               String course, String college_year, String section, String civil_status, String address,
                                               String user_name, String password){
            
             String error_message = "Please fill up the required fields:\n";
        if (first_name == null || first_name.trim().isEmpty()) {
       error_message += "- First Name\n";
        }
        if (last_name == null || last_name.trim().isEmpty()) {
            error_message += "- Last Name\n";
        }
        if (age_text == null || age_text.trim().isEmpty()) {
            error_message += "- Age\n";
        }
        if (date_birth == null || date_birth.trim().isEmpty()) {
            error_message += "- Date of Birth\n";
        }
        if (email == null || email.trim().isEmpty()) {
            error_message += "- Email\n";
        }
        if (course == null || course.trim().isEmpty()) {
            error_message += "- Course\n";
        }
        if (college_year == null || college_year.trim().isEmpty()) {
            error_message += "- College Year\n";
        }
        if (section == null || section.trim().isEmpty()) {
            error_message += "- Section\n";
        }
        if (civil_status == null || civil_status.trim().isEmpty()) {
            error_message += "- Civil Status\n";
        }
        if (address == null || address.trim().isEmpty()) {
            error_message += "- Address\n";
        }
        if (user_name == null || user_name.trim().isEmpty()) {
            error_message += "- Username\n";
        }
        if (password == null || password.trim().isEmpty()) {
            error_message += "- Password\n";
        }   
        return error_message;
        }
        
        // method overloading for sign in validation of all required fields
        public static String validRequiredFields(String file_path,String first_name, String last_name,String age_text, String email,String contact_number,String work_position,String address, String user_name, String password){
            
        String error_message = "Please fill up the required fields:\n";
        if (file_path == null || file_path.trim().isEmpty()) {
       error_message += "- Profile\n";
        }
        if (first_name == null || first_name.trim().isEmpty()) {
       error_message += "- First Name\n";
        }
        if (last_name == null || last_name.trim().isEmpty()) {
            error_message += "- Last Name\n";
        }
        if (age_text == null || age_text.trim().isEmpty()) {
            error_message += "- Age\n";
        }
        if (address == null || address.trim().isEmpty()) {
            error_message += "- Address\n";
        }
        if (work_position == null || work_position.trim().isEmpty()) {
            error_message += "- Work Position\n";
        }
        if (contact_number == null || contact_number.trim().isEmpty()) {
            error_message += "- Contact Number\n";
        }
        if (user_name == null || user_name.trim().isEmpty()) {
            error_message += "- Username\n";
        }
         if (email == null || email.trim().isEmpty()) {
            error_message += "- Email\n";
        }
        if (password == null || password.trim().isEmpty()) {
            error_message += "- Password\n";
        }   
        return error_message;
        }
        
        // method overloading for account info validation of all required fields
        public static String validRequiredFields(String first_name, String last_name,String age_text,String contact_number,String address){
            
        String error_message = "Please fill up the required fields:\n";
        if (first_name == null || first_name.trim().isEmpty()) {
       error_message += "- First Name\n";
        }
        if (last_name == null || last_name.trim().isEmpty()) {
            error_message += "- Last Name\n";
        }
        if (age_text == null || age_text.trim().isEmpty()) {
            error_message += "- Age\n";
        }
        if (address == null || address.trim().isEmpty()) {
            error_message += "- Address\n";
        }
        if (contact_number == null || contact_number.trim().isEmpty()) {
            error_message += "- Contact Number\n";
        }
        return error_message;
        }
        
}
