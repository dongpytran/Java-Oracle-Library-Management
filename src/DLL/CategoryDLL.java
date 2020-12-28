/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.CategoryDAL;
import Entity.Categories;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class CategoryDLL {
    CategoryDAL dal = new CategoryDAL();
    public ArrayList<Categories> getByCode(String code){
        return dal.getByCode(code);
    }
    public ArrayList<Categories> getAll(){
        return dal.getAll();
    }
}
