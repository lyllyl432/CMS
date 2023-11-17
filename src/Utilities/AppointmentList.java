/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author HP
 */
public class AppointmentList {
    int reference_id, patient_id;
    String clinic_position,reason,patient_name;
    Time time;
    Date appointment_date;
    boolean status;
    public AppointmentList(int reference_id, int patient_id,String patient_name, Date appointment_date, Time time, String clinic_position, String reason, boolean status){
        this.reference_id = reference_id;
        this.patient_id = patient_id;
        this.appointment_date = appointment_date;
        this.time = time;
        this.clinic_position = clinic_position;
        this.reason = reason;
        this.status = status;
        this.patient_name = patient_name;
    }
    public AppointmentList(int reference_id, int patient_id, Date appointment_date, Time time, String clinic_position, String reason, boolean status){
        this.reference_id = reference_id;
        this.patient_id = patient_id;
        this.appointment_date = appointment_date;
        this.time = time;
        this.clinic_position = clinic_position;
        this.reason = reason;
        this.status = status;
    }
    public int getReferenceId(){
        return reference_id;
    }
    public int getPatientId(){
        return patient_id;
    }
    public Date getAppointmentDate(){
        return appointment_date;
    }
    public String getPatientName(){
        return patient_name;
    }
    public String getClinicPosition(){
        return clinic_position;
    }
    public String getReason(){
        return reason;
    }
    public Time getTime(){
        return time;
    }
    public boolean getStatus(){
        return status;
    }
}
