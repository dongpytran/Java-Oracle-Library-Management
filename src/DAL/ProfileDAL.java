/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Profile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ProfileDAL extends DatabaseAccess{
    private final String GET_PROFILE = "select distinct PROFILE from dba_profiles";
    private final String GET_TABLESPACE = "SELECT DISTINCT NAME FROM v$tablespace";
    public ArrayList<Profile> getALL(){
        ArrayList<Profile> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_PROFILE);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Profile item = new Profile();
                        item.setName(rs.getString("PROFILE"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    public ArrayList<Profile> getTableSpace(){
        ArrayList<Profile> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_TABLESPACE);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Profile item = new Profile();
                        item.setName(rs.getString("NAME"));
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
