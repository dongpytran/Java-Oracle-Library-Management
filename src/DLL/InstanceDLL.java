/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.InstanceDAL;
import Entity.Instance;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class InstanceDLL {
    InstanceDAL dal = new InstanceDAL();
    
    public ArrayList<Instance> getALL(){
        return dal.getAll();
    }
}
