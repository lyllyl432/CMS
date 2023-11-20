/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author AUDITOR FAMILY
 */
public class MedicineList {
    private int medicine_id,stock,unit,prescribed_id;
    private String medicine_name,description,medicine_type,dosage,instruction;
    private boolean status;
    
    public MedicineList(int medicine_id, String medicine_name, String description, String medicine_type, String dosage, int stock, boolean status){
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.description = description;
        this.medicine_type = medicine_type;
        this.stock = stock;
        this.status = status;
        this.dosage = dosage;
    }
    
    public MedicineList(int medicine_id, String medicine_name){
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
    }
    
    public MedicineList(String medicine_name, String dosage, String instruction, int unit, int prescribed_id, int medicine_id){
        this.medicine_name = medicine_name;
        this.dosage = dosage;
        this.instruction = instruction;
        this.unit = unit;
        this.prescribed_id = prescribed_id;
        this.medicine_id = medicine_id;
    }
    
    
    public int getMedicineId(){
        return medicine_id;
    }
    public String getMedicineName(){
        return medicine_name;
    }
    public String getDescription(){
        return description;
    }
    public String getMedicineType(){
        return medicine_type;
    }
    public int getStock(){
        return stock;
    }
    public String getDosage(){
        return dosage;
    }
    public boolean getStatus(){
        return status;
    }
    public int getUnit(){
        return unit;
    }
    public String getInstruction(){
        return instruction;
    }
    public int getPrescribedId(){
        return prescribed_id;
    }
    
    @Override
    public String toString() {
        return medicine_name; // Return the medicine name for display
    }
}
