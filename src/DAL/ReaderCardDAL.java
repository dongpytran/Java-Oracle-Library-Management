/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ReCards;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PY
 */
public class ReaderCardDAL extends DatabaseAccess{
    private final String GET_ALL = "Select * from reCards";
    private final String ADD_DATA ="insert into reCards(cardNum,startDay,finishDay,note) values(?,?,?,?)";
    private final String UPDATE_DATA = "Update reCards Set startDay=?,finishDay=?,note=? where cardNum=?";
    private final String REMOVE_DATA = "Delete From reCards where cardNum=?";
    private final String COUNT_NUM = "Select count(*) as sl From reCards where cardNum=?";
    public ArrayList<ReCards> getAll(){
        ArrayList<ReCards> objs = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    ReCards r = new ReCards();
                    r.setCardNum(rs.getString("cardNum"));
                    r.setStartDay(rs.getString("startDay"));
                    r.setFinishDay(rs.getString("finishDay"));
                    r.setNote(rs.getString("note"));
                    objs.add(r);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDaTa(ReCards r){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(ADD_DATA);
            ps.setString(1, r.getCardNum());
            ps.setString(2, r.getStartDay());
            ps.setString(3, r.getFinishDay());
            ps.setString(4, r.getNote());
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
    public boolean updateData(ReCards r){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, r.getStartDay());
            ps.setString(2, r.getFinishDay());
            ps.setString(3, r.getNote());
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
    public boolean removeData(String num){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(REMOVE_DATA);
            ps.setString(1, num);
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
    
    public int countNum(String num){
        int check = 0;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(COUNT_NUM);
            ps.setString(1, num);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    check = rs.getInt("sl");
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
