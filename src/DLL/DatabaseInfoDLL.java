/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DatabaseInfoDAL;
import Entity.Database;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class DatabaseInfoDLL {
    DatabaseInfoDAL dal = new DatabaseInfoDAL();
    
    public ArrayList<Database> getALL(){
        return dal.getAll();
    }
}
