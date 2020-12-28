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
public class Database {
    private String name;
    private String created;
    private String mode;
    private String role;
    
    public Database(){
        this.name = this.created = this.mode = this.role;
    }

    public String getName() {
        return name;
    }

    public String getCreated() {
        return created;
    }

    public String getMode() {
        return mode;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
