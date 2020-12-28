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
public class ReCards {
    private String cardNum;
    private String startDay;
    private String finishDay;
    private String note;

    public String getCardNum() {
        return cardNum;
    }

    public String getStartDay() {
        return startDay;
    }

    public String getFinishDay() {
        return finishDay;
    }

    public String getNote() {
        return note;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public void setFinishDay(String finishDay) {
        this.finishDay = finishDay;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
