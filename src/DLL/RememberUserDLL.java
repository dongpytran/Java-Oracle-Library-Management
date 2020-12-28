/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DLL;

import DAL.RememberUserDAL;
import Entity.RememberUser;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class RememberUserDLL {
    RememberUserDAL dal = new RememberUserDAL();
    public ArrayList<RememberUser> getAll(){
        return dal.getALL();
    }
    
    public void AddData(RememberUser re){
        dal.AddDaTa(re);
    }
    
    public void RemoveData(){
        dal.removeData();
    }
}
