/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class RoleDAL extends DatabaseAccess{
    private final String GET_ALL = "Select ROLE from dba_roles";
    private final String GET_BY_NAME = "select ROLE from dba_roles where role=? AND COMMON ='NO'";
    
    public ArrayList<Role> getALL(){
        ArrayList<Role> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Role item = new Role();
                        item.setName(rs.getString("ROLE"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Role> getByName(String name){
        ArrayList<Role> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_BY_NAME);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Role item = new Role();
                        item.setName(rs.getString("ROLE"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
