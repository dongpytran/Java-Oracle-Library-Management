/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ProfileUserDAL;
import Entity.ProfileUsers;
import Entity.UserDetails;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ProfileUserDLL {
    ProfileUserDAL dal = new ProfileUserDAL();
    
    public ArrayList<ProfileUsers> getALL(String code){
        return dal.getUsername(code);
    }
    
    public ArrayList<UserDetails> getDetails(String code){
        return dal.getDetails(code);
    }
}
