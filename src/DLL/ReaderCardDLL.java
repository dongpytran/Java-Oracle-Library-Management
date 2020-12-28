/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ReaderCardDAL;
import Entity.ReCards;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ReaderCardDLL {
    ReaderCardDAL dal = new ReaderCardDAL();
    public ArrayList<ReCards> getAll(){
        return dal.getAll();
    }
    public boolean addData(ReCards r){
        return dal.AddDaTa(r);
    }
    public boolean updateData(ReCards r){
        return dal.updateData(r);
    }
    public boolean removeData(String n){
        return dal.removeData(n);
    }
    public int countNum(String num){
        return dal.countNum(num);
    }
}
