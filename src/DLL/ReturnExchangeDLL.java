/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ReturnExchangeDAL;
import Entity.ReturnExchange;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class ReturnExchangeDLL {
    ReturnExchangeDAL dal = new ReturnExchangeDAL();
    public ArrayList<ReturnExchange> getAll(){
        return dal.getAll();
    }
    public boolean addData(ReturnExchange r){
        return dal.addData(r);
    }
    public boolean updateData(ReturnExchange r){
        return dal.updateData(r);
    }
    public boolean removeData(String code){
        return dal.removeData(code);
    }
}
