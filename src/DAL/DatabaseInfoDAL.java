/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class DatabaseInfoDAL extends DatabaseAccess{
    private final String GET_ALL = "select NAME, CREATED, OPEN_MODE, DATABASE_ROLE from v$database";
    
    public ArrayList<Database> getAll(){
            ArrayList<Database> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Database item = new Database();
                        item.setName(rs.getString("NAME"));
                        item.setCreated(rs.getString("CREATED"));
                        item.setMode(rs.getString("OPEN_MODE"));
                        item.setRole(rs.getString("DATABASE_ROLE"));
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
