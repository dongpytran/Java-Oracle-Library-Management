/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Instance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class InstanceDAL extends DatabaseAccess{
    private final String GET_ALL = "select instance_name, HOST_NAME, VERSION, STARTUP_TIME, STATUS from v$instance";
    
    public ArrayList<Instance> getAll(){
            ArrayList<Instance> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Instance item = new Instance();
                        item.setName(rs.getString("INSTANCE_NAME"));
                        item.setHost(rs.getString("HOST_NAME"));
                        item.setVersion(rs.getString("VERSION"));
                        item.setDate(rs.getString("STARTUP_TIME"));
                        item.setStatus(rs.getString("STATUS"));
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
