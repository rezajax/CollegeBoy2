package com.rezajax.college.boy2.Model;

import android.text.format.DateFormat;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataModel {
    String name;
    String header;
    String text;
    String rate;
    String file;
    int image;
    String date;
    String user_name;
    String cat_name;
    String is_stu;

    public DataModel(String name, String header, String text, String rate, String file, int image, String date, String user_name, String cat_name, String is_stu) {
        this.name = name;
        this.header = header;
        this.text = text;
        this.rate = rate;
        this.file = file;
        this.image = image;
        this.date = date;   //   this.date = date;       this.date = date.substring(0 , 4);
        this.user_name = user_name;
        this.cat_name = cat_name;
        this.is_stu = is_stu;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIs_stu() {
        return is_stu;
    }

    public void setIs_stu(String is_stu) {
        this.is_stu = is_stu;
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
        return dateCalculator(date);
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


    public String dateCalculator (String date) {
//        Date d = new Date();
//        Log.i("jax", "d: " + d);
//        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
//        Log.i("jax", "s: " + s);
        String dateSys = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        Log.i("jax", "dateSys: " + dateSys);
        Log.i("jax", "this.date: " + this.date);

        if ( Integer.parseInt(date.substring(0,4)) < Integer.parseInt(dateSys.substring(0,4)) ) {
            int i = Integer.parseInt(dateSys.substring(0, 4)) - Integer.parseInt(date.substring(0, 4));
            return i + " year";
        }

        if (Integer.parseInt(date.substring(5, 7)) < Integer.parseInt(dateSys.substring(5, 7))) {
            int i = Integer.parseInt(dateSys.substring(5, 7)) - Integer.parseInt(date.substring(5, 7));
            return i + " month";
        }

        if (Integer.parseInt(date.substring(8, 10)) < Integer.parseInt(dateSys.substring(8, 10))) {
            int i = Integer.parseInt(dateSys.substring(8, 10)) - Integer.parseInt(date.substring(8, 10));
            return i + " day";
        }

        if (Integer.parseInt(date.substring(11, 13)) < Integer.parseInt(dateSys.substring(11, 13))) {
            int i = Integer.parseInt(dateSys.substring(11, 13)) - Integer.parseInt(date.substring(11, 13));
            return i + " hour";
        }

        if (Integer.parseInt(date.substring(14, 16)) < Integer.parseInt(dateSys.substring(14, 16))) {
            int i = Integer.parseInt(dateSys.substring(14, 16)) - Integer.parseInt(date.substring(14, 16));
            return i + " min";
        }

        if (Integer.parseInt(date.substring(17, 19)) < Integer.parseInt(dateSys.substring(17, 19))) {
            int i = Integer.parseInt(dateSys.substring(17, 19)) - Integer.parseInt(date.substring(17, 19));
            //Log.i("jax", i + "= " + dateSys.substring(17, 19) + " - " + date.substring(17, 19));
            return i + " sec";
        }

        return "";
    }



}
