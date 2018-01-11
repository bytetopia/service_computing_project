package dao;


import bean.Company;
import bean.Order;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class OrderDao {

    public List<Order> getOrderListByUser(String userId) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from t_order where userId=?");
            ps.setString(1,userId);
            ResultSet rs=ps.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while(rs.next()){
                Order o = new Order();
                o.setOrderId(rs.getString(1));
                o.setUserId(rs.getString(2));
                o.setOrderAt(rs.getString(3));
                o.setAirlineId(rs.getString(4));
                o.setHotelId(rs.getString(5));
                o.setCarId(rs.getString(6));
                o.setSightId(rs.getString(7));
                o.setAirlineStatus(rs.getString(8));
                o.setHotelStatus(rs.getString(9));
                o.setCarStatus(rs.getString(10));
                o.setSightStatus(rs.getString(11));
                orderList.add(o);
            }
            rs.close();
            ps.close();
            conn.close();
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Company getCompanyUserById(String companyId) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from t_company where companyId=?");
            ps.setString(1,companyId);
            ResultSet rs=ps.executeQuery();
            Company c=new Company();
            if(rs.next()){
                c.setCompanyId(rs.getString(1));
                c.setPwd(rs.getString(2));
                c.setName(rs.getString(3));
                c.setDescription(rs.getString(4));
                c.setWsdl(rs.getString(5));
                c.setUpdateAt(rs.getString(6));
                c.setType(rs.getInt(7));
            }
            else{
                c=null;
            }
            rs.close();
            ps.close();
            conn.close();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateCompanyInfo(Company c) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("update t_company set pwd=?,name=?,description=?,wsdl=?,updateAt=?,type=? where companyId=?");
            ps.setString(1,c.getPwd());
            ps.setString(2,c.getName());
            ps.setString(3,c.getDescription());
            ps.setString(4,c.getWsdl());
            ps.setString(5,c.getUpdateAt());
            ps.setInt(6,c.getType());
            ps.setString(7,c.getCompanyId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUserInfo(User u) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("update t_user set pwd=?,email=?,phone=? where userId=?");
            ps.setString(1,u.getPwd());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPhone());
            ps.setString(4,u.getUserId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Order getOrder(String oid) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from t_order where orderId=?");
            ps.setString(1,oid);
            ResultSet rs=ps.executeQuery();
            Order o = new Order();
            if(rs.next()){
                o.setOrderId(rs.getString(1));
                o.setUserId(rs.getString(2));
                o.setOrderAt(rs.getString(3));
                o.setAirlineId(rs.getString(4));
                o.setHotelId(rs.getString(5));
                o.setCarId(rs.getString(6));
                o.setSightId(rs.getString(7));
                o.setAirlineStatus(rs.getString(8));
                o.setHotelStatus(rs.getString(9));
                o.setCarStatus(rs.getString(10));
                o.setSightStatus(rs.getString(11));
            }
            else{
                o=null;
            }
            rs.close();
            ps.close();
            conn.close();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveOrder(Order o) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into t_order values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getUserId());
            ps.setString(3, o.getOrderAt());
            ps.setString(4, o.getAirlineId());
            ps.setString(5, o.getHotelId());
            ps.setString(6, o.getCarId());
            ps.setString(7, o.getSightId());
            ps.setString(8, o.getAirlineStatus());
            ps.setString(9, o.getHotelStatus());
            ps.setString(10, o.getCarStatus());
            ps.setString(11, o.getSightStatus());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
