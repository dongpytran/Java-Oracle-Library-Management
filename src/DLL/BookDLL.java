/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DLL;

import DAL.BookDAL;
import Entity.Books;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class BookDLL {
    BookDAL dal = new BookDAL();
    
    public ArrayList<Books> getALL(){
        return dal.getALL();
    }
    public boolean AddData(Books bk){
        return dal.AddDaTa(bk);
    }
    public boolean removeData(String emCode){
        return dal.removeData(emCode);
    }
    
    public boolean updateData(Books bk){
        return dal.updateData(bk);
    }
    public ArrayList<Books> getByCode(String code){
        return dal.getByCode(code);
    }
    public int countCode(String code){
        return dal.countCode(code);
    }
    public ArrayList<Books> getByName(String name){
        return dal.getByName(name);
    }
}
