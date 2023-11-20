/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.Date;

/**
 *
 * @author HP
 */
public class PatientRecordList {
    private int reference_id;
    private String clinic_position, reason, review_message;
    private Date appointment_date, review_date;
    private boolean status;
    public PatientRecordList(int reference_id, String clinic_position, String reason, String review_message, Date appointment_date, Date review_date, boolean status){
       this.reference_id = reference_id;
       this.clinic_position = clinic_position;
       this.reason = reason;
       this.review_message = review_message;
       this.appointment_date = appointment_date;
       this.review_date = review_date;
       this.status = status;
    }
    public PatientRecordList(Date appointment_date, Date review_date, String clinic_position){
       this.clinic_position = clinic_position;
       this.appointment_date = appointment_date;
       this.review_date = review_date;
    }
    public int getReferenceId(){
        return reference_id;
    }
    public String getClinicPosition(){
        return clinic_position;
    }
    public String getReason(){
        return reason;
    }
    public String getReviewMessage(){
        return review_message;
    }
    public Date getAppointmentDate(){
        return appointment_date;
    }
    public Date getReviewDate(){
        return review_date;
    }
    public boolean getStatus(){
        return status;
    }
}
