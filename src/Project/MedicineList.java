/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

/**
 *
 * @author AUDITOR FAMILY
 */
public class MedicineList {
    private int medicineId;
    private String medicineName;
    
    public MedicineList(int medicineId, String medicineName){
        this.medicineId = medicineId;
        this.medicineName = medicineName;
    }
    public int getMedicineId(){
        return medicineId;
    }
    
    public String getMedicineName(){
        return medicineName;
    }
}
