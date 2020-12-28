/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import Entity.Books;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class BookDAL extends DatabaseAccess{
    private final String GET_ALL = "select * from SYS.books";
    private final String ADD_DATA = "Insert into "
                                    +"books(bookCode,bookName,author,categoryCode,publisherCode,pubYear,stus,image)"
                                    + "values (?,?,?,?,?,?,?,?)";
    private final String REMOVE_DATA = "Delete from books where bookCode=?";
    private final String UPDATE_DATA = "Update books"+" Set bookName=?,author=?,categoryCode=?,publisherCode=?,pubYear=?,stus=?,image=?"
                                        +" where bookCode=?";
    private final String GET_BY_CODE = "Select bookName From books where bookCode=?";
    private final String COUNT_CODE = "Select count(*) as lk From books where bookCode=?";
    private final String GET_BY_NAME = "Select * from books where bookName like ?";
    public ArrayList<Books> getALL(){
        ArrayList<Books> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Books item = new Books();
                        item.setBookCode(rs.getString("bookCode"));
                        item.setBookName(rs.getString("bookName"));
                        item.setAuthor(rs.getString("author"));
                        item.setCategoryCode(rs.getString("categoryCode"));
                        item.setPublisherCode(rs.getString("publisherCode"));
                        item.setPubYear(rs.getString("pubYear"));
                        item.setStus(rs.getString("stus"));
                        item.setPicture(rs.getBytes("image"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddDaTa(Books b){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(ADD_DATA);
            ps.setString(1, b.getBookCode());
            ps.setString(2, b.getBookName());
            ps.setString(3, b.getAuthor());
            ps.setString(4, b.getCategoryCode());
            ps.setString(5, b.getPublisherCode());
            ps.setString(6, b.getPubYear());
            ps.setString(7, b.getStus());
            ps.setBytes(8, b.getPicture());
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
    
    public boolean removeData(String bookCode){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(REMOVE_DATA);
            ps.setString(1, bookCode);
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
    
    public boolean updateData(Books em){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(UPDATE_DATA);
            ps.setString(1, em.getBookName());
            ps.setString(2, em.getAuthor());
            ps.setString(3, em.getCategoryCode());
            ps.setString(4, em.getPublisherCode());
            ps.setString(5, em.getPubYear());
            ps.setString(6, em.getStus());
            ps.setBytes(7, em.getPicture());
            ps.setString(8, em.getBookCode());
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
    public ArrayList<Books> getByCode(String code){
        ArrayList<Books> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_BY_CODE);
                ps.setString(1, code);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Books item = new Books();
                        item.setBookName(rs.getString("bookName"));
                        objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public int countCode(String code){
        int check = 0;
        try {
            getConnection();
            PreparedStatement ps = co.prepareStatement(COUNT_CODE);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    check = rs.getInt("lk");
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<Books> getByName(String name){
        ArrayList<Books> objs = new ArrayList<>();
        try {
            getConnection();
                PreparedStatement ps = co.prepareStatement(GET_BY_NAME);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                
                if(rs!=null){
                    while (rs.next()) {                        
                        Books item = new Books();
                        item.setBookCode(rs.getString("bookCode"));
                        item.setBookName(rs.getString("bookName"));
                        item.setAuthor(rs.getString("author"));
                        item.setCategoryCode(rs.getString("categoryCode"));
                        item.setPublisherCode(rs.getString("publisherCode"));
                        item.setPubYear(rs.getString("pubYear"));
                        item.setStus(rs.getString("stus"));
                        item.setPicture(rs.getBytes("image"));
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
