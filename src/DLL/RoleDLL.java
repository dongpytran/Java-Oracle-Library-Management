/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.RoleDAL;
import Entity.Role;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class RoleDLL {
    RoleDAL dal = new RoleDAL();
    
    public ArrayList<Role> getRole(){
        return dal.getALL();
    }
    public ArrayList<Role> getbyName(String name){
        return dal.getByName(name);
    }
}
