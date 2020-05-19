package com.anemon.ykssayac;

public class Duyurular {
    private String key;
    private String duyuru;
    private  int num;

    public Duyurular() {
    }

    public Duyurular(String key, String duyuru, int num) {
        this.key = key;
        this.duyuru = duyuru;
        this.num = num;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDuyuru() {
        return duyuru;
    }

    public void setDuyuru(String duyuru) {
        this.duyuru = duyuru;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
