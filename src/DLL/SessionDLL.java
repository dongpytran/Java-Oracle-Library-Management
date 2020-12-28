/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.SessionDAL;
import Entity.Session;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class SessionDLL {
    SessionDAL dal = new SessionDAL();
    
    public ArrayList<Session> getAll(){
        return dal.getALL();
    }
}
