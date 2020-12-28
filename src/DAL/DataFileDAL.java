/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.DataFile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class DataFileDAL extends DatabaseAccess{
    private final String GET_ALL = "select FILE_NAME, tablespace_name, BYTES, maxbytes, STATUS from dba_data_files";
    public ArrayList<DataFile> getALL(){
        ArrayList<DataFile> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        DataFile item = new DataFile();
                        item.setName(rs.getString("FILE_NAME"));
                        item.setTable(rs.getString("TABLESPACE_NAME"));
                        item.setBytes(rs.getLong("BYTES"));
                        item.setMaxbytes(rs.getLong("MAXBYTES"));
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
