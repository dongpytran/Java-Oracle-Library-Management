/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.SgaDAL;
import Entity.Sga;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class SgaDLL {
    SgaDAL dal= new SgaDAL();
    
    public ArrayList<Sga> getALL(){
        return dal.getAll();
    }
    public ArrayList<Sga> getALLpGa(){
        return dal.getAllpGA();
    }
}
