/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ProfileUsers;
import Entity.UserDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ProfileUserDAL extends DatabaseAccess{
    private final String GET_ALL = "select USERNAME from dba_users a where a.PROFILE = ?";
    private final String GET_USER = "select USERNAME, PASSWORD, a.account_status, a.default_tablespace, a.created, a.profile from dba_users a where a.USERNAME = ?";
    public ArrayList<ProfileUsers> getUsername(String code){
        ArrayList<ProfileUsers> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ps.setString(1, code);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        ProfileUsers item = new ProfileUsers();
                        item.setUsername(rs.getString("USERNAME"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<UserDetails> getDetails(String code){
        ArrayList<UserDetails> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_USER);
                ps.setString(1, code);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        UserDetails item = new UserDetails();
                        item.setUsername(rs.getString("USERNAME"));
                        item.setPass(rs.getString("PASSWORD"));
                        item.setStatus(rs.getString("ACCOUNT_STATUS"));
                        item.setTablespace(rs.getString("DEFAULT_TABLESPACE"));
                        item.setCreated(rs.getString("CREATED"));
                        item.setProfile(rs.getString("PROFILE"));
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
