package com.rezajax.college.boy2;

public class DataModel {
    String name;
    String header;
    String text;
    int id;
    int image;

    public DataModel(String name, String header, String text, int id, int image) {
        this.name = name;
        this.header = header;
        this.text = text;
        this.id = id;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
