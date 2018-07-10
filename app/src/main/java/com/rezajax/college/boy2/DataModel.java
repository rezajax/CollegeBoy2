package com.rezajax.college.boy2;

public class DataModel {
    String name;
    String header;
    String text;
    String rate;
    String file;
    String date;
    String user_name;
    String cat_name;

    public DataModel(String name, String header, String text, String rate, String file, String date, String user_name, String cat_name) {
        this.name = name;
        this.header = header;
        this.text = text;
        this.rate = rate;
        this.file = file;
        this.date = date;
        this.user_name = user_name;
        this.cat_name = cat_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
