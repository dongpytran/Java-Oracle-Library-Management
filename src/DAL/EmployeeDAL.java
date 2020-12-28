/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Employees;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class EmployeeDAL extends DatabaseAccess{
    private final String GET_ALL = "Select * From employees";
    private final String GET_GENDER = "Select distinct (gender) From employees";
    private final String INSERT_DATA = "Insert into employees(emCode,emLastName,emFirstName,birth,gender,adress,phone,email) Values(?,?,?,?,?,?,?,?)";
    private final String UPDATE_DATA ="Update employees Set emLastName =?,emFirstName=?,birth=?,gender=?,adress=?,phone=?,email=? where emCode=?";
    private final String REMOVE_DATA = "Delete From employees where emCode =?";
    private final String COUNT_CODE = "Select count(*) as sl from employees where emCode=?";
    public ArrayList<Employees> getAll(){
        ArrayList<Employees> objs = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                    while (rs.next()) {                        
                        Employees item = new Employees();
                        item.setEmCode(rs.getString("emCode"));
                        item.setEmLastName(rs.getString("emLastName"));
                        item.setEmFirstName(rs.getString("emFirstName"));
                        item.setBirth(rs.getString("birth"));
                        item.setGender(rs.getString("gender"));
                        item.setAdress(rs.getString("adress"));
                        item.setPhone(rs.getString("phone"));
                        item.setEmail(rs.getString("email"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Employees> getGender(){
        ArrayList<Employees> objs = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_GENDER);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Employees e = new Employees();
                    e.setGender(rs.getString("gender"));
                    objs.add(e);
                }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDaTa(Employees em){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(INSERT_DATA);
            ps.setString(1, em.getEmCode());
            ps.setString(2, em.getEmLastName());
            ps.setString(3, em.getEmFirstName());
            ps.setString(4, em.getBirth());
            ps.setString(5, em.getGender());
            ps.setString(6, em.getAdress());
            ps.setString(7, em.getPhone());
            ps.setString(8, em.getEmail());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public boolean updateData(Employees em){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, em.getEmLastName());
            ps.setString(2, em.getEmFirstName());
            ps.setString(3, em.getBirth());
            ps.setString(4, em.getGender());
            ps.setString(5, em.getAdress());
            ps.setString(6, em.getPhone());
            ps.setString(7, em.getEmail());
            ps.setString(8, em.getEmCode());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean removeData(String emCode){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(REMOVE_DATA);
            ps.setString(1, emCode);
            int rs = ps.executeUpdate();
            if(rs>0){
                check=true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public int countCode(String code){
        int check = 0;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(COUNT_CODE);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    check = rs.getInt("sl");
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
