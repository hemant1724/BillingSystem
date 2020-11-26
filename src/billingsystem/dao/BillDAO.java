/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem.dao;

import billingsystem.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import billingsystem.model.BillModel;

/**
 *
 * @author Windows
 */
public class BillDAO {

    public static boolean save(String name, String mobile, String address, String date, float total, float amtPaid, float due) {
        Connection con = null;
        boolean status = false;
        try {
            con = GetConnection.getConnection();
            String sql = "insert into datamanagement(Name,Mobile,Address,Date,Total,AmtPaid,Due) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setString(3, address);
            ps.setString(4, date);
            ps.setFloat(5, total);
            ps.setFloat(6, amtPaid);
            ps.setFloat(7, due);
            if (ps.executeUpdate() != 0){
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

    public static void fecthDataInModel(BillModel b) {
        Connection con = null;
        try {
            con = GetConnection.getConnection();
            String sql = "select * from datamanagement where Id =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, b.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setName(rs.getString(2));
                b.setMobile(rs.getString(3));
                b.setAddress(rs.getString(4));
                b.setDue(rs.getFloat(8));
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
    }

    public static boolean update(float amtpaid, float due, int id) {
        boolean status = false;
        Connection con = null;
        try {
            con = GetConnection.getConnection();
            String sql = "update datamanagement set AmtPaid = ? , Due = ? where Id =?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setFloat(1, amtpaid);
            ps.setFloat(2, due);
            ps.setInt(3, id);

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

    public static void fecthUpdateModel(BillModel b) {
        Connection con = null;
        try {
            con = GetConnection.getConnection();
            String sql = "select * from datamanagement where Id =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, b.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setTotal(rs.getFloat(6));
                b.setAmtPaid(rs.getFloat(7));
                b.setDue(rs.getFloat(8));
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
    }

    public static ArrayList<BillModel> getBillModelList() {
        Connection con = null;
        ArrayList<BillModel> al = new ArrayList<>();
        try {
            con = GetConnection.getConnection();
            String sql = "select * from datamanagement order by id desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String mobile = rs.getString(3);
                String address = rs.getString(4);
                String date = rs.getString(5);
                float total = Float.parseFloat(rs.getString(6));
                float amtpaid = Float.parseFloat(rs.getString(7));
                float due = Float.parseFloat(rs.getString(8));

                BillModel p = new BillModel();
                p.setId(id);
                p.setName(name);
                p.setMobile(mobile);
                p.setAddress(address);
                p.setDate(date);
                p.setTotal(total);
                p.setAmtPaid(amtpaid);
                p.setDue(due);

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

    public static ArrayList<BillModel> searchList(String searchText) {
        Connection con = null;
        ArrayList<BillModel> al = new ArrayList<>();
        try {
            con = GetConnection.getConnection();
            String sql = "select * from datamanagement where concat(name,mobile,address,date) like '%" + searchText + "%' order by Id desc";
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setString(1, searchText);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String mobile = rs.getString(3);
                String address = rs.getString(4);
                String date = rs.getString(5);
                float total = Float.parseFloat(rs.getString(6));
                float amtpaid = Float.parseFloat(rs.getString(7));
                float due = Float.parseFloat(rs.getString(8));

                BillModel p = new BillModel();
                p.setId(id);
                p.setName(name);
                p.setMobile(mobile);
                p.setAddress(address);
                p.setDate(date);
                p.setTotal(total);
                p.setAmtPaid(amtpaid);
                p.setDue(due);

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

    /*public static void delete()
     {
     Connection con=null;
       
     try
     {
     con=GetConnection.getConnection();
     String sql= "truncate * from datamanagement";
     Statement ps=con.createStatement();
     ps.executeUpdate(sql);
       
        
     }
     catch(Exception e)
     {
     e.printStackTrace();
     }
     finally
     {
     try
     {
     con.close();
     }
     catch(Exception e)
     {
     e.printStackTrace();
     }
     }
       
     }*/
    public static boolean deleteData(int bottom_value, int top_value) {

        Connection con = null;
        boolean status = false;

        try {
            con = GetConnection.getConnection();
            for (int i = bottom_value; i >= top_value; i--) {
                String sql = "DELETE FROM datamanagement WHERE id =" + i;
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

            String sql = "DELETE FROM datamanagement WHERE id =" + value;
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
