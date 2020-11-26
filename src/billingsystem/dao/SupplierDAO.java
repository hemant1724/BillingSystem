/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem.dao;

import billingsystem.GetConnection;
import billingsystem.model.BillModel;
import billingsystem.model.SupplierModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SupplierDAO {
    
  public static boolean submit(SupplierModel supplierModel) {
        Connection con = null;
        boolean status = false;
        try {
            con = GetConnection.getConnection();
            String sql = "insert into supplierinfo(SupplierName,Mobile,ItemCode,ItemName,Rate,MRP,Quantity,AmtPaid,Total,Due,Date) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,supplierModel.getSuppliername() );
            ps.setString(2, supplierModel.getMobile());
            ps.setString(3, supplierModel.getItemcode());
            ps.setString(4, supplierModel.getItemname());
            ps.setFloat(5, supplierModel.getRate());
            ps.setFloat(6, supplierModel.getMrp());
            ps.setFloat(7, supplierModel.getQty());
            ps.setFloat(8, supplierModel.getAmtpaid());
            ps.setFloat(9, supplierModel.getTotal());
            ps.setFloat(10, supplierModel.getDue());
            ps.setString(11, supplierModel.getDate());
            if (ps.executeUpdate() != 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

   public static ArrayList<SupplierModel> getBillModelList() {
        Connection con = null;
        ArrayList<SupplierModel> al = new ArrayList<>();
        try {
            con = GetConnection.getConnection();
            String sql = "select * from supplierinfo order by id desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String suppliername = rs.getString(2);
                String mobile = rs.getString(3);
                String itemcode = rs.getString(4);
                String itemname = rs.getString(5);
                float  rate = rs.getFloat(6);
                float  mrp = rs.getFloat(7);
                int qty = rs.getInt(8);
                float total = Float.parseFloat(rs.getString(9));
                float amtpaid = Float.parseFloat(rs.getString(10));
                float due = Float.parseFloat(rs.getString(11));
                 String date = rs.getString(12);
                

                SupplierModel p = new SupplierModel();
                p.setId(id);
                p.setSuppliername(suppliername);
                p.setMobile(mobile);
                p.setItemcode(itemcode);
                p.setItemname(itemname);
                p.setDate(date);
                p.setTotal(total);
                p.setAmtpaid(amtpaid);
                p.setDue(due);
                p.setRate(rate);
                p.setMrp(mrp);
                p.setQty(qty);

                al.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return al;
    }
   
   public static ArrayList<SupplierModel> searchList(String searchText) {
        Connection con = null;
        ArrayList<SupplierModel> al = new ArrayList<>();
        try {
            con = GetConnection.getConnection();
            String sql1 = "select * from supplierinfo where concat(SupplierName,Mobile,ItemName,ItemCode,Date) like '%" + searchText + "%' order by Id desc";
            PreparedStatement ps = con.prepareStatement(sql1);
            //ps.setString(1, searchText);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String suppliername = rs.getString(2);
                String mobile = rs.getString(3);
                String itemcode = rs.getString(4);
                String itemname = rs.getString(5);
                float  rate = rs.getFloat(6);
                float  mrp = rs.getFloat(7);
                int qty = rs.getInt(8);
                float total = Float.parseFloat(rs.getString(9));
                float amtpaid = Float.parseFloat(rs.getString(10));
                float due = Float.parseFloat(rs.getString(11));
                 String date = rs.getString(12);
                

                SupplierModel p = new SupplierModel();
                p.setId(id);
                p.setSuppliername(suppliername);
                p.setMobile(mobile);
                p.setItemcode(itemcode);
                p.setItemname(itemname);
                p.setDate(date);
                p.setTotal(total);
                p.setAmtpaid(amtpaid);
                p.setDue(due);
                p.setRate(rate);
                p.setMrp(mrp);
                p.setQty(qty);

                al.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return al;
    }
   
     public static boolean deleteData(int bottom_value, int top_value) {

        Connection con = null;
        boolean status = false;

        try {
            con = GetConnection.getConnection();
            for (int i = bottom_value; i >= top_value; i--) {
                String sql = "DELETE FROM supplierinfo WHERE id =" + i;
                PreparedStatement ps = con.prepareStatement(sql);
          //ps.setInt(1,id);
                //ps.setInt(1,bottom_value);
                // ps.setInt(2,top_value);
                ps.executeUpdate(sql);
            }
            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public static boolean delete(int value) {

        Connection con = null;
        boolean status = false;

        try {
            con = GetConnection.getConnection();

            String sql = "DELETE FROM supplierinfo WHERE id =" + value;
            //String s = "alter table datamanagement auto_increment = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            // PreparedStatement ps1 = con.prepareStatement(s);
          //ps.setInt(1,id);
            //ps.setInt(1,bottom_value);
            // ps.setInt(2,top_value);
            ps.executeUpdate(sql);
           // ps1.executeUpdate(s);

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
}
