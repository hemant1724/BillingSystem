/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem.model;


public class SupplierModel {
    private  float rate ;
  private  String suppliername ;
  private  String itemname ;
  private  String itemcode ;
  private  String mobile ;
  private  String date ;
  private  int qty ;
  private  int id ;
  private  float total;
  private  float amtpaid;
  private  float due;
  private  float mrp;
  

    public SupplierModel() {
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public SupplierModel(float rate,String date, String suppliername, String itemname, String itemcode, String mobile, int qty, float total, float amtpaid, float due, float mrp) {
        this.rate = rate;
         this.date = date;
        this.suppliername = suppliername;
        this.itemname = itemname;
        this.itemcode = itemcode;
        this.mobile = mobile;
        this.qty = qty;
        this.total = total;
        this.amtpaid = amtpaid;
        this.due = due;
        this.mrp = mrp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getAmtpaid() {
        return amtpaid;
    }

    public void setAmtpaid(float amtpaid) {
        this.amtpaid = amtpaid;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }
    
    
    
   
  
}
