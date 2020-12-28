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
public class Instance {
    private String name;
    private String host;
    private String version;
    private String date;
    private String status;
    
    public Instance(){
        this.name= this.host = this.version = this.date = this.status = "";
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getVersion() {
        return version;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
