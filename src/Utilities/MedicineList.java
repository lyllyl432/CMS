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
    private int medicine_id,stock;
    private String medicine_name,description,medicine_type,dosage;
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
}
