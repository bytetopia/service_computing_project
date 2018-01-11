package dao;


import bean.Company;
import bean.User;
import com.mysql.fabric.xmlrpc.base.Array;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import sun.plugin.com.event.COMEventHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDao {

    public User getUserById(String userId) {
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from t_user where userId=?");
            ps.setString(1,userId);
            ResultSet rs=ps.executeQuery();
            User u=new User();
            if(rs.next()){
                u.setUserId(rs.getString(1));
                u.setPwd(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPhone(rs.getString(4));
            }
            else{
                u=null;
            }
            rs.close();
            ps.close();
            conn.close();
            return u;
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

    public ArrayList<Company> getAllCompany(){
        try {
            Connection conn=DbHelper.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from t_company");
            ResultSet rs=ps.executeQuery();
            ArrayList<Company> list=new ArrayList<>();
            while(rs.next()){
                Company c=new Company();
                c.setCompanyId(rs.getString(1));
                c.setPwd(rs.getString(2));
                c.setName(rs.getString(3));
                c.setDescription(rs.getString(4));
                c.setWsdl(rs.getString(5));
                c.setUpdateAt(rs.getString(6));
                c.setType(rs.getInt(7));
                list.add(c);
            }
            rs.close();
            ps.close();
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
