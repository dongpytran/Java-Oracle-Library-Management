/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.PublishingHouses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PY
 */
public class PublishDAL extends DatabaseAccess{
    private final String GET_BY_CODE = "Select publisherName from publishingHouses Where publisherCode = ?";
    private final String GET_ALL = "SELECT * FROM publishingHouses";
    private final String ADD_DATA = "insert into publishingHouses(publisherCode,publisherName,adress,phone,email) values (?,?,?,?,?)";
    private final String UPDATE_DATA = "UPDATE PUBLISHINGHOUSES a SET a.publisherName =?,a.adress=?,a.phone=?,a.email=? where a.publisherCode=?";
    private final String REMOVE_DATA = "Delete From publishingHouses where publisherCode=?";
    public ArrayList<PublishingHouses> getByCode(String code){
        ArrayList<PublishingHouses> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_BY_CODE);
                ps.setString(1, code);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                        
                        PublishingHouses item = new PublishingHouses();
                        item.setPubName(rs.getString("publisherName"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
    
    public ArrayList<PublishingHouses> getAll(){
        ArrayList<PublishingHouses> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                        
                        PublishingHouses item = new PublishingHouses();
                        item.setPubCode(rs.getString("publisherCode"));
                        item.setPubName(rs.getString("publisherName"));
                        item.setAdress(rs.getString("adress"));
                        item.setPhone(rs.getString("phone"));
                        item.setEmail(rs.getString("email"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
    public boolean addData(PublishingHouses p){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(ADD_DATA);
            ps.setString(1, p.getPubCode());
            ps.setString(2, p.getPubName());
            ps.setString(3, p.getAdress());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getEmail());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean updateData(PublishingHouses p){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, p.getPubName());
            ps.setString(2, p.getAdress());
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getPubCode());
            int rs = ps.executeUpdate();
            if(rs == 1){
                check = true;
            }   
            getClose();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean removeData(String code){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(REMOVE_DATA);
            ps.setString(1, code);
            int rs = ps.executeUpdate();
            if(rs>0){
                check=true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
