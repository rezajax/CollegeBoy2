package com.rezajax.college.boy2.Model;

public class UserModel {
    String id;
    String appid;
    String stuid;
    String pass;
    String name;
    String family;
    String image;
    String cource;
    String email;
    String phone;
    String date;
    String num_post;

    public UserModel(String id, String appid, String stuid, String pass, String name, String family, String image, String cource, String email, String phone, String date, String num_post) {
        this.id = id;
        this.appid = appid;
        this.stuid = stuid;
        this.pass = pass;
        this.name = name;
        this.family = family;
        this.image = image;
        this.cource = cource;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.num_post = num_post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum_post() {
        return num_post;
    }

    public void setNum_post(String num_post) {
        this.num_post = num_post;
    }
}
