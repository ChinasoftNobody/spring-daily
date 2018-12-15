package com.lgh.spring.boot.model;

public class MVoiceClockMessage extends MBase {

    //cuid=baike&lan=ZH&ctp=1&pdt=31&vol=9&spd=4
    private String volTex;
    private String volCuid = "baike";
    private String volLan = "ZH";
    private String volCtp = "1";
    private String volPdt = "31";
    private String volVol = "9";
    private String volSpd = "4";
    private int count;

    public String getVolTex() {
        return volTex;
    }

    public void setVolTex(String volTex) {
        this.volTex = volTex;
    }

    public String getVolCuid() {
        return volCuid;
    }

    public void setVolCuid(String volCuid) {
        this.volCuid = volCuid;
    }

    public String getVolLan() {
        return volLan;
    }

    public void setVolLan(String volLan) {
        this.volLan = volLan;
    }

    public String getVolCtp() {
        return volCtp;
    }

    public void setVolCtp(String volCtp) {
        this.volCtp = volCtp;
    }

    public String getVolVol() {
        return volVol;
    }

    public void setVolVol(String volVol) {
        this.volVol = volVol;
    }

    public String getVolSpd() {
        return volSpd;
    }

    public void setVolSpd(String volSpd) {
        this.volSpd = volSpd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getVolPdt() {
        return volPdt;
    }

    public void setVolPdt(String volPdt) {
        this.volPdt = volPdt;
    }
}
