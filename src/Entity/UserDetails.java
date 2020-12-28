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
public class UserDetails {
    private String username;
    private String pass;
    private String status;
    private String tablespace;
    private String created;
    private String profile;
    
    public UserDetails(){
        this.username = this.pass = this.status = this.tablespace = this.created = this.profile;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getStatus() {
        return status;
    }

    public String getTablespace() {
        return tablespace;
    }

    public String getCreated() {
        return created;
    }

    public String getProfile() {
        return profile;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTablespace(String tablespace) {
        this.tablespace = tablespace;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    
}
