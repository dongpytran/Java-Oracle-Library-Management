/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import Entity.RememberUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class RememberUserDAL extends DatabaseAccess{
    private final String GET_ALL ="Select * from RememberUser";
    private final String DELETE = "Delete from RememberUser";
    private final String INSERT = "Insert into RememberUser(Users,Pas) "+"Values(?,?)";
    
    public ArrayList<RememberUser> getALL(){
        ArrayList<RememberUser> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        RememberUser item = new RememberUser();
                        item.setUsers(rs.getString("USERS"));
                        item.setPas(rs.getString("PAS"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public void AddDaTa(RememberUser re){
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(INSERT);
            ps.setString(1, re.getUsers());
            ps.setString(2, re.getPas());
            ps.executeUpdate();    
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeData(){
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(DELETE);
            int rs = ps.executeUpdate();
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
