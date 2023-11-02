 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

/**
 *
 * @author AUDITOR FAMILY
 */
public class PatientList {
    private int patient_id;
    private String first_name,middle_name,last_name,suffix,course,college_year,section,civil_status,email,address,phone_number,gender;
    
    public PatientList(int patient_id, String first_name, String middle_name, String last_name,String suffix, String email, String course, String college_year, String section, String civil_status, String address, String phone_number, String gender){
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.suffix = suffix;
        this.email = email;
        this.course = course;   
        this.college_year = college_year;
        this.section = section;
        this.civil_status = civil_status;
        this.address = address;
        this.phone_number = phone_number;
        this.gender = gender;
          
    }
    public int getPatientId(){
        return patient_id;
    }
    public String getFirstName(){
        return first_name;
    }
    public String getMiddleName(){
        return middle_name;
    }
    public String getLastName(){
        return last_name;
    }
    public String getSuffix(){
        return suffix;
    }
    public String getCourse(){
        return course;
    }
    public String getCollegeYear(){
        return college_year;
    }
    public String getSection(){
        return section;
    }
    public String getCivilStatus(){
        return civil_status;
    }
    public String getEmail(){
        return email;
    }public String getAddress(){
        return address;
    }public String getPhoneNumber(){
        return phone_number;
    }public String getGender(){
        return gender;
    }
    
    
    
    
}

