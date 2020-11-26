/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem.model;

/**
 *
 * @author Windows
 */
public class BillModel {
    private int id;
    private String name;
    private String mobile;
    private String address;
    private String date;
    private String description;
    private String qty;
    private float rate;
    private float amount;
    private float total;
    private float due;
     private float amtPaid;
     private String itemcode;
     private float weight;

    public BillModel() {
    }   

    public BillModel(int id, String name, String mobile, String address, String date, float total,float due) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.date = date;
        this.total = total;
         this.due = due;
    }

    
    public BillModel(String name, String mobile, String address, String date, String description, String qty, float rate, float amount, float total) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.date = date;
        this.description = description;
        this.qty = qty;
        this.rate = rate;
        this.amount = amount;
        this.total = total;
    }

    public BillModel(int id, String name, String mobile, String address, String date, String description, String qty, float rate, float amount, float total, float due, float amtPaid) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.date = date;
        this.description = description;
        this.qty = qty;
        this.rate = rate;
        this.amount = amount;
        this.total = total;
        this.due = due;
        this.amtPaid = amtPaid;
    }

    public BillModel(int id, String name, String mobile, String address, String date, String description, String qty, float rate, float amount, float total, float due, float amtPaid, String itemcode, float weight) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.date = date;
        this.description = description;
        this.qty = qty;
        this.rate = rate;
        this.amount = amount;
        this.total = total;
        this.due = due;
        this.amtPaid = amtPaid;
        this.itemcode = itemcode;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    
    
    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public float getAmtPaid() {
        return amtPaid;
    }

    public void setAmtPaid(float amtPaid) {
        this.amtPaid = amtPaid;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
