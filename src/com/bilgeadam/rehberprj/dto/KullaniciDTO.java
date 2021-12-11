package com.bilgeadam.rehberprj.dto;

public class KullaniciDTO {

    private int no;
    private String kullaniciAdi;
    private String sifre;
    private int aktif;



    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getAktif() {
        return aktif;
    }

    public void setAktif(int aktif) {
        this.aktif = aktif;
    }
}
