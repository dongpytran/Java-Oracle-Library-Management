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
public class Books {
    private String bookCode;
    private String bookName;
    private String author;
    private String categoryCode;
    private String publisherCode;
    private String  pubYear;
    private String stus;
    private byte[] picture;

    public String getBookCode() {
        return bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public String getPubYear() {
        return pubYear;
    }

    public String getStus() {
        return stus;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setPublisherCode(String publiherCode) {
        this.publisherCode = publiherCode;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public void setStus(String stus) {
        this.stus = stus;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    
}