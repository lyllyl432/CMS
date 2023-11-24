/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Application.AddAppointment;
import Application.MainDashboard;
import Application.UpdatePatient;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author AUDITOR FAMILY
 */
public class General {
    private static Connection con;
    private static PreparedStatement ps;
    private static PatientList patient_list;
    private static MedicineList medicine_list;
    private static DefaultTableModel model;
    private static  TableRowSorter sorter;
    private static ResultSet rs;
    private static java.util.Date selectedDate;
    private static SimpleDateFormat dateFormat;
    private static String email;
    //filter search based on patient name
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
    //get patient entry based on patient id
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
    //get medicine entry based on medicine id
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
    
    //set profile information on the application interface
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
    //create circular image for admin profile picture
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
    
    //set specified table column to zero
    public static void  setColumnWidthZero(TableColumnModel column_model, int row){
      TableColumn column = column_model.getColumn(row);
     column.setMinWidth(0);
     column.setMaxWidth(0);
     column.setPreferredWidth(0);
     column.setWidth(0);
    }
    //get approve entry from database
    public static AppointmentList getApproveEntry(int reference_id, AppointmentList appointment_list){
        try {
            ps = con.prepareStatement("SELECT * FROM pending WHERE reference_id = ?");
            ps.setInt(1, reference_id);
            rs = ps.executeQuery();
            while(rs.next()){
                appointment_list = new AppointmentList(rs.getInt("reference_id"),rs.getInt("patient_id"),rs.getDate("appointment_date"),rs.getTime("time"),rs.getString("clinic_position"),rs.getString("reason"),rs.getBoolean("status"));
            }
            return appointment_list;
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    //get user entry based on the id
    public static UserInfo getUserInfoEntry(int user_id){
        UserInfo user_info = null;
        con = ConnectionProvider.connect();
        try {
            String user_info_query = "SELECT * FROM user_info WHERE user_id = ?";
            ps = con.prepareStatement(user_info_query);
            ps.setInt(1,user_id);
            rs  = ps.executeQuery();
            while(rs.next()) {
                user_info = new UserInfo(rs.getInt("account_id"),rs.getInt("user_id"),rs.getString("profile_picture"),rs.getString("first_name"),rs.getString("middle_name"),rs.getString("last_name"),rs.getString("suffix"), rs.getInt("age"),rs.getString("civil_status"),rs.getString("address"),rs.getString("contact_number"),rs.getString("work_position"));
            }
            return user_info;
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //delete pending entry based on reference_id
    public static void deletePendingEntry(int reference_id){
        try {
            ps = con.prepareStatement("DELETE FROM pending WHERE reference_id = ?");
            ps.setInt(1, reference_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //insert appointment entry from the database
    public static void insertAppointment(AppointmentList appointment_list){
        selectedDate = appointment_list.getAppointmentDate();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ps = con.prepareStatement("INSERT INTO appointment_list(reference_id,patient_id,appointment_date, time, clinic_position, reason,status) VALUES(?,?,?,?,?,?,?);");
            ps.setInt(1, appointment_list.getReferenceId());
            ps.setInt(2, appointment_list.getPatientId());
            ps.setString(3, dateFormat.format(selectedDate));
            ps.setTime(4, appointment_list.getTime());
            ps.setString(5, appointment_list.getClinicPosition());
            ps.setString(6, appointment_list.getReason());
            ps.setBoolean(7, true);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //send mail to the specific provided email
    public static void sendMailToRecipient(int patient_id, String mail_message){
        try {
            ps = con.prepareStatement("SELECT email from patient WHERE patient_id = ?");
            ps.setInt(1, patient_id);
            //Execute the query
            rs = ps.executeQuery();

            //Process the result set
            while(rs.next()) {
                email = rs.getString("email");
//                System.out.println("Email: " + email);
            }
            try {
                MailUtil.sendMail(email,mail_message);
            } catch (MessagingException ex) {
                Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Make the date as a readable string date format
    public static String convertDateToReadable(String date_string){
        LocalDate date = LocalDate.parse(date_string);
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
             return date.format(formatter);
    }
    //make the time as a readable string time format
    public static String convertTimeToReadable(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        return sdf.format(time);
    }
    //change the date format to insert in database
    public static String changeDateFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    //change string time value to time data type format
    public static java.sql.Time changeTimeFormat(String time_value){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Date date;
        java.sql.Time time;
        try {
            date = sdf.parse(time_value);
             time = new java.sql.Time(date.getTime());
             return time;
        } catch (ParseException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //set table column font
    public static void setTableFont(JTable table){
        Font header_font = new Font("Times New Roman", Font.BOLD, 14); // Replace with your desired font settings

        // Set the custom renderer for the column headers
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer(header_font));
    }
    //convert JFrame to pdf
    public static void createAndOpenPDF(JFrame frameToPrint) {
        try {
            int frameWidth = frameToPrint.getWidth();
        int frameHeight = frameToPrint.getHeight();
            // Create a PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(frameWidth, frameHeight));
        document.addPage(page);

        // Create a content stream for adding content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Capture the graphics of the AnotherFrame
        BufferedImage image = new BufferedImage(frameToPrint.getWidth(), frameToPrint.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        frameToPrint.paint(g2d);
        g2d.dispose();

        // Convert the image to a PDImageXObject and add it to the PDF
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);
        contentStream.drawImage(pdImage, 0, 0, frameToPrint.getWidth(), frameToPrint.getHeight());

//        contentStream.endText();

        // Close the content stream
        contentStream.close();

        // Save the document to a file
        document.save("output.pdf");

        // Close the document
        document.close();

        // Open the PDF file with the default PDF viewer
        Desktop.getDesktop().open(new File("output.pdf"));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    //make an array list of JOIN query of appointment_prescribed_medication and medicines table
    public static ArrayList<MedicineList> medicineList(String query, int reference_id){
        try {
            ArrayList<MedicineList> medicineArrayList = new ArrayList<>();
            con = ConnectionProvider.connect();
             
            ps = con.prepareStatement(query);
            ps.setInt(1, reference_id);
            rs = ps.executeQuery();
            while(rs.next()){
            
                medicine_list = new MedicineList(rs.getString("medicine"),rs.getString("dosage"),rs.getString("instruction"), rs.getInt("unit"),rs.getInt("prescribed_id"),rs.getInt("medicine_id"));
                medicineArrayList.add(medicine_list);               
            }
            return medicineArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     // Method to remove the label from its parent container
    public static void removeLabel(JLabel label, JFrame frame, UserInfo user_info) {
        Container parent = label.getParent();
        if(user_info.getWorkPosition().equals("Staff")){
        if (parent instanceof JPanel) {
            JPanel panel = (JPanel) parent;
            panel.remove(label);
            panel.revalidate(); // Notify the layout manager
            panel.repaint();    // Repaint the panel
        } else if (parent instanceof JFrame) {
            // If the label is directly added to the JFrame
            frame.remove(label);
            frame.revalidate();
            frame.repaint();
        }
       }
    }
    public static int countRecords(String tableName) {
    int totalRecords = 0;
    try {
        con = ConnectionProvider.connect();
        String query = "SELECT COUNT(*) AS total_records FROM " + tableName;
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()) {
            totalRecords = rs.getInt("total_records");
        }
        return totalRecords;
    } catch (SQLException ex) {
        Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close resources (ResultSet, PreparedStatement, Connection) in a finally block
        // to ensure they are always closed, even if an exception occurs.
        // Add code to close rs, ps, and con.
    }
    return totalRecords;
}
     public static int countAdminRecords(String admin_position){
        int total_admin_records = 0;
        try {
            con = ConnectionProvider.connect();
            ps = con.prepareStatement("SELECT COUNT(*) AS total_admin_records FROM user_info WHERE work_position = ?");
            ps.setString(1, admin_position);
            rs = ps.executeQuery();
            while(rs.next()){
                total_admin_records = rs.getInt("total_admin_records");
            }
            return total_admin_records;
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total_admin_records;
    }
}    