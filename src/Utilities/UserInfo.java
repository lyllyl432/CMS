/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author HP
 */
public class UserInfo {
    private int account_id,user_id,age,patient_id;
    private String profile_picture,first_name,middle_name,last_name,suffix,civil_status,address,contact_number,work_position;
    
    public UserInfo(int account_id, int user_id, String profile_picture, String first_name, String middle_name, String last_name, String suffix, int age, String civil_status, String address, String contact_number, String work_position,int patient_id){
        this.account_id = account_id;
        this.user_id = user_id;
        this.profile_picture  = profile_picture;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.suffix = suffix;
        this.age = age;
        this.civil_status = civil_status;
        this.address = address;
        this.contact_number = contact_number;
        this.work_position = work_position;
        this.patient_id = patient_id;
    }
    
    public int getAccountId(){
        return account_id;
    }
    public int getUserId(){
        return user_id;
    }
    public String getProfilePicture(){
        return profile_picture;
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
    public String getCivilStatus(){
        return civil_status;
    }
    public String getAddress(){
        return address;
    }
    public String getContactNumber(){
        return contact_number;
    }
    public String getWorkPosition(){
        return work_position;
    }
    public int getPatientId(){
        return patient_id;
    }
}
