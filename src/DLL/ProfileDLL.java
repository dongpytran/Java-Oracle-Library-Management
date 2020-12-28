/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ProfileDAL;
import Entity.Profile;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ProfileDLL {
    ProfileDAL dal = new ProfileDAL();
    
    public ArrayList<Profile> getALL(){
        return dal.getALL();
    }
    
    public ArrayList<Profile> getTablespace(){
        return dal.getTableSpace();
    }
}
