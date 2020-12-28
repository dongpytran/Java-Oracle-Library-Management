/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ReadersDAL;
import Entity.Readers;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ReadersDLL {
    ReadersDAL dal = new ReadersDAL();
    public ArrayList<Readers> getAll(){
        return dal.getAll();
    }
    public boolean addData(Readers r){
        return dal.addData(r);
    }
    public boolean updateData(Readers r){
        return dal.updateData(r);
    }
    public boolean removeData(String code){
        return dal.removeData(code);
    }
    public ArrayList<Readers> getByNum(String num){
        return dal.getByNum(num);
    }
}
