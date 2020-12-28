/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class CategoryDAL extends DatabaseAccess{
    private final String GET_BY_CODE ="Select categoryName from categorys where categoryCode =?";
    private final String GET_ALL = "Select * from categorys";
    public ArrayList<Categories> getByCode(String code){
        ArrayList<Categories> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_BY_CODE);
                ps.setString(1, code);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                        
                        Categories item = new Categories();
                        item.setCategoryName(rs.getString("categoryName"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
    
    public ArrayList<Categories> getAll(){
        ArrayList<Categories> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                        
                        Categories item = new Categories();
                        item.setCategoryCode(rs.getString("categoryCode"));
                        item.setCategoryName(rs.getString("categoryName"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
}
