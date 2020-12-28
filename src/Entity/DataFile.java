/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author PY
 */
public class DataFile {
    private String name;
    private String table;
    private long bytes;
    private long maxbytes;
    private String status;
    
    public DataFile(){
        this.name= this.table = this.status = "";
        this.bytes = this.maxbytes = 0;
    }

    public String getName() {
        return name;
    }

    public String getTable() {
        return table;
    }

    public long getBytes() {
        return bytes;
    }

    public long getMaxbytes() {
        return maxbytes;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    public void setMaxbytes(long maxbytes) {
        this.maxbytes = maxbytes;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
