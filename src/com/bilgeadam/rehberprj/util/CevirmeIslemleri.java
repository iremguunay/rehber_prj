package com.bilgeadam.rehberprj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CevirmeIslemleri {

    public static java.sql.Date utilToSqlDate (java.util.Date tarih) {
        java.sql.Date sqlTarih = new java.sql.Date(tarih.getTime());

        return sqlTarih;
    }

    public static java.util.Date sqlToUtilDate(java.sql.Date tarih) {

        java.util.Date utilTarih = new java.util.Date(tarih.getTime());

        return utilTarih;
    }

    public static String utilDateToStr(java.util.Date tarih) {

        SimpleDateFormat sdf = new SimpleDateFormat(Sabitler.TARIH_FORMAT);

        return sdf.format(tarih);
    }

    public static java.util.Date strToUtilDate(String tarih) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(Sabitler.TARIH_FORMAT);
        return sdf.parse(tarih);
    }

}
