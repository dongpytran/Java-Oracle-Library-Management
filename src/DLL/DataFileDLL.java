/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DataFileDAL;
import Entity.DataFile;
import java.util.ArrayList;

/**
 *
 * @author PY
 */
public class DataFileDLL {
    DataFileDAL dal = new DataFileDAL();
    
    public ArrayList<DataFile> getAll(){
        return dal.getALL();
    }
}
