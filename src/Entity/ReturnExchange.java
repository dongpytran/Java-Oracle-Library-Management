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
public class ReturnExchange {
    private String reCode;
    private String bookCode;
    private String cardNum;
    private String emCode;
    private String dayBorrow;
    private String dayReturn;

    public String getReCode() {
        return reCode;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getEmCode() {
        return emCode;
    }

    public String getDayBorrow() {
        return dayBorrow;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public void setReCode(String reCode) {
        this.reCode = reCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setEmCode(String emCode) {
        this.emCode = emCode;
    }

    public void setDayBorrow(String dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public void setDayReturn(String dayReturn) {
        this.dayReturn = dayReturn;
    }
    
    
}
