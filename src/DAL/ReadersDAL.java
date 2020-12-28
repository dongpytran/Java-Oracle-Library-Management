/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Readers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ReadersDAL extends DatabaseAccess{
    private final String GET_ALL = "Select * from readers";
    private final String ADD_DATA = "Insert into readers(reaCode,reaName,adress,cardNum) Values (?,?,?,?)";
    private final String UPDATE_DATA = "Update readers SET reaName=?,adress=?,cardNum=? where reaCode=?";
    private final String REMOVE_DATA = "Delete from readers where reaCode=?";
    private final String GET_BY_NUM ="Select reaName From readers where cardNum=?";
    public ArrayList<Readers> getAll(){
        ArrayList<Readers> objs = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Readers r = new Readers();
                    r.setReCode(rs.getString("reaCode"));
                    r.setReName(rs.getString("reaName"));
                    r.setAdress(rs.getString("adress"));
                    r.setCardNum(rs.getString("cardNum"));
                    objs.add(r);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    public boolean addData(Readers r){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(ADD_DATA);
            ps.setString(1, r.getReCode());
            ps.setString(2, r.getReName());
            ps.setString(3, r.getAdress());
            ps.setString(4, r.getCardNum());
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
    public boolean updateData(Readers r){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, r.getReName());
            ps.setString(2, r.getAdress());
            ps.setString(3, r.getCardNum());
            ps.setString(4, r.getReCode());
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
    public ArrayList<Readers> getByNum(String num){
        ArrayList<Readers> objs = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_BY_NUM);
            ps.setString(1, num);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Readers r = new Readers();
                    r.setReName(rs.getString("reaName"));
                    objs.add(r);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
