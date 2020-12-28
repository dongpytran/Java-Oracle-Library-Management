/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class SessionDAL extends DatabaseAccess{
    private final String GET_ALL = "select SID, SERIAL#, PADDR, USERNAME, MACHINE, PROGRAM,STATUS from v$session where type <> 'BACKGROUND'";
    
    public ArrayList<Session> getALL(){
        ArrayList<Session> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Session item = new Session();
                        item.setSID(rs.getInt("SID"));
                        item.setSerial(rs.getLong("SERIAL#"));
                        item.setPADDR(rs.getString("PADDR"));
                        item.setUser(rs.getString("USERNAME"));
                        item.setMachine(rs.getString("MACHINE"));
                        item.setProgram(rs.getString("PROGRAM"));
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
