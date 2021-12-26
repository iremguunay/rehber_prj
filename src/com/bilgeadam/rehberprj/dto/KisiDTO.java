package com.bilgeadam.rehberprj.dto;

import com.bilgeadam.rehberprj.util.CevirmeIslemleri;

import java.util.Date;

public class KisiDTO {

    private int no;
    private String ad;
    private String soyad;
    private double maas;
    private Date dogtar;
    private String cepTel;

    @Override
    public String toString() {
        return "Kisi:" +
                "no=" + no +
                ", ad=" + ad +
                ", soyad='" + soyad +
                ", maas=" + maas +
                ", dogtar=" + CevirmeIslemleri.utilDateToStr(dogtar) +
                ", cepTel=" + cepTel;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public Date getDogtar() {
        return dogtar;
    }

    public void setDogtar(Date dogtar) {
        this.dogtar = dogtar;
    }

    public String getCepTel() {
        return cepTel;
    }

    public void setCepTel(String cepTel) {
        this.cepTel = cepTel;
    }
}
