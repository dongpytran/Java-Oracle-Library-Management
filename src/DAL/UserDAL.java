/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import Entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class UserDAL extends DatabaseAccess{
    private final String GET_LOGIN = "Select * from Users where Username=? and Pass=?";
    private final String GET_ALL = "Select * from Users";
    private final String REMOVE_DATA = "Delete from Users where Username=?";
    private final String ADD_DATA = "Insert into Users(Username,Pass) Values (?,?)";
    private final String UPDATE_DATA = "Update Users set Pass=? where Username=?";
    
    
    private final String GET_USERNAME = "Select Username From Users where Username=?";
    
    
    
    
    
    
    
    public boolean getLogin(String u, String p){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if(rs!=null && rs.next()){
                check=true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<Users> getAll(){
        ArrayList<Users> objs = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Users item = new Users();
                    item.setUsername(rs.getString("username"));
                    item.setPass(rs.getString("pass"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean RemoveData(String username){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(REMOVE_DATA);
            ps.setString(1, username);
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
    
    public boolean AddData(Users u){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(ADD_DATA);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPass());
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
    
    public boolean updateData(Users u){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, u.getPass());
            ps.setString(2, u.getUsername());
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
    public boolean getUsername(String user){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_USERNAME);
            ps.setString(1, user);
            ResultSet rs =ps.executeQuery();
            if(rs!=null){
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
