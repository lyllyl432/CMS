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
    private int patient_id, age;
    private String first_name,middle_name,last_name,suffix,course,college_year,section,civil_status,email,address,phone_number,gender,height,weight,blood_type,vaccination_status,date_birth;
    
    public PatientList(int patient_id, String first_name, String middle_name, String last_name,String suffix, int age, String date_birth, String email, String course, String college_year, String section, String civil_status, String address, String phone_number, String gender, String height, String weight, String blood_type, String vaccination_status){
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.suffix = suffix;
        this.age = age;
        this.date_birth = date_birth;
        this.email = email;
        this.course = course;   
        this.college_year = college_year;
        this.section = section;
        this.civil_status = civil_status;
        this.address = address;
        this.phone_number = phone_number;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.blood_type = blood_type;
        this.vaccination_status = vaccination_status;
          
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
    public int getAge(){
        return age;
    }
    public String getBirth(){
        return date_birth;
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
    public String getHeight(){
        return height;
    }
    public String getWeight(){
        return weight;
    }
    public String getBloodType(){
        return blood_type;
    }
    public String getVaccinationStatus(){
        return vaccination_status;
    }
    
    
    
    
    
}

