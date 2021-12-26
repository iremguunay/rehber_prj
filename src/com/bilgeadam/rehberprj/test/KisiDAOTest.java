package com.bilgeadam.rehberprj.test;

import com.bilgeadam.rehberprj.dao.KisiDAO;
import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class KisiDAOTest {

    public void ekleTest() throws ParseException, SQLException, ClassNotFoundException {
        KisiDTO kisi = new KisiDTO();
        kisi.setNo(6);
        kisi.setAd("İrem");
        kisi.setSoyad("Günay");
        kisi.setMaas(0);
        kisi.setDogtar(CevirmeIslemleri.strToUtilDate("21/04/2002"));
        kisi.setCepTel("+9053242347454");

        boolean sonuc = KisiDAO.ekle(kisi);

        if (sonuc)
            System.out.println("Başarıyla eklendi");
        else
            System.out.println("Eklenemedi!!!");
    }

    public void listeleTest() throws SQLException, ClassNotFoundException {

        List<KisiDTO> kisiler = KisiDAO.listele();

        for (KisiDTO kisi: kisiler) {
            System.out.println(kisi);
        }
    }

    public static void main(String[] args) {

        try {
            KisiDAOTest kdt = new KisiDAOTest();
            //kdt.ekleTest();
            kdt.listeleTest();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
