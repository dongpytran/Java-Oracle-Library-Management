/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.EmployeeDAL;
import Entity.Employees;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class EmployeeDLL {
    EmployeeDAL dal = new EmployeeDAL();
    public ArrayList<Employees> getAll(){
        return dal.getAll();
    }
    public ArrayList<Employees> getGender(){
        return dal.getGender();
    }
    public boolean addData(Employees e){
        return dal.AddDaTa(e);
    }
    public boolean updateData(Employees em){
        return dal.updateData(em);
    }
    public boolean removeData(String emCode){
        return dal.removeData(emCode);
    }
    public int countCode(String code){
        return dal.countCode(code);
    }
}
