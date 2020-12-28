/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.PublishDAL;
import Entity.PublishingHouses;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class PublishDLL {
    PublishDAL dal  = new PublishDAL();
    public ArrayList<PublishingHouses> getByCode(String code){
        return dal.getByCode(code);
    }
    public ArrayList<PublishingHouses> getAll(){
        return dal.getAll();
    }
    public boolean addData(PublishingHouses p){
        return dal.addData(p);
    }
    public boolean updateData(PublishingHouses p){
        return dal.updateData(p);   
    }
    public boolean removeData(String code){
        return dal.removeData(code);
    }
}
