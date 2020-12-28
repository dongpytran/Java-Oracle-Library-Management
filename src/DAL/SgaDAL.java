/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Sga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class SgaDAL extends DatabaseAccess{
    private final String GET_ALL  = "select name, value from v$sga";
    private final String GET_ALL_PGA = "select name,value from v$pgastat";
    public ArrayList<Sga> getAll(){
        ArrayList<Sga> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Sga item = new Sga();
                        item.setName(rs.getString("NAME"));
                        item.setValue(rs.getLong("VALUE"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Sga> getAllpGA(){
        ArrayList<Sga> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL_PGA);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Sga item = new Sga();
                        item.setName(rs.getString("NAME"));
                        item.setValue(rs.getLong("VALUE"));
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
