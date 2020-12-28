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
public class Session {
    private int SID;
    private long serial;
    private String PADDR;
    private String user;
    private String machine;
    private String program;
    private String status;
    
    public Session(){
        this.SID = 0;
        this.serial = 0;
        this.PADDR = this.user = this.machine = this.program = this.status = "";
    }

    public int getSID() {
        return SID;
    }

    public long getSerial() {
        return serial;
    }

    public String getPADDR() {
        return PADDR;
    }

    public String getUser() {
        return user;
    }

    public String getMachine() {
        return machine;
    }

    public String getProgram() {
        return program;
    }

    public String getStatus() {
        return status;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public void setPADDR(String PADDR) {
        this.PADDR = PADDR;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
