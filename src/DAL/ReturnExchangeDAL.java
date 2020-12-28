/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ReturnExchange;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ReturnExchangeDAL extends DatabaseAccess{
    private String GET_ALL = "Select * from returnExchange";
    private String ADD_DATA = "Insert into returnExchange(reCode,bookCode,cardNum,emCode,dayBorrow,dayReturn) values (?,?,?,?,?,?)";
    private String UPDATE_DATA = "Update returnExchange Set bookCode=?,cardNum=?,emCode=?,dayBorrow=?,dayReturn=? where reCode=?";
    private String REMOVE_DATA = "Delete From returnExchange where reCode =?";
    public ArrayList<ReturnExchange> getAll(){
        ArrayList<ReturnExchange> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                        
                        ReturnExchange item = new ReturnExchange();
                        item.setReCode(rs.getString("reCode"));
                        item.setBookCode(rs.getString("bookCode"));
                        item.setCardNum(rs.getString("cardNum"));
                        item.setEmCode(rs.getString("emCode"));
                        item.setDayBorrow(rs.getString("dayBorrow"));
                        item.setDayReturn(rs.getString("dayReturn"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
    
    public boolean addData(ReturnExchange r){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(ADD_DATA);
            ps.setString(1, r.getReCode());
            ps.setString(2, r.getBookCode());
            ps.setString(3, r.getCardNum());
            ps.setString(4, r.getEmCode());
            ps.setString(5, r.getDayBorrow());
            ps.setString(6, r.getDayReturn());
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
    
    public boolean updateData(ReturnExchange r){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, r.getBookCode());
            ps.setString(2, r.getCardNum());
            ps.setString(3, r.getEmCode());
            ps.setString(4, r.getDayBorrow());
            ps.setString(5, r.getDayReturn());
            ps.setString(6, r.getReCode());
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
    
    public boolean removeData(String reCode){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(REMOVE_DATA);
            ps.setString(1, reCode);
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
