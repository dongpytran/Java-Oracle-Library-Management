/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DLL;

import DAL.UserDAL;
import Entity.Users;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class UserDLL {
    UserDAL dal = new UserDAL();
    public boolean getLogin(String u, String p){
        return dal.getLogin(u, p);
    }
    public ArrayList<Users> getAll(){
        return dal.getAll();
    }
    public boolean RemoveData(String username){
        return dal.RemoveData(username);
    }
    public boolean AddData(Users u){
        return dal.AddData(u);
    }
    public boolean UpdateData(Users u){
        return dal.updateData(u);
    }
    public boolean GetUsername(String u){
        return dal.getUsername(u);
    }
}
