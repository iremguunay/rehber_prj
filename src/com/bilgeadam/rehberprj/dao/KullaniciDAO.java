package com.bilgeadam.rehberprj.dao;

import com.bilgeadam.rehberprj.dto.KullaniciDTO;
import com.bilgeadam.rehberprj.sec.AES;
import com.bilgeadam.rehberprj.util.Sabitler;
import com.bilgeadam.rehberprj.vt.VTBaglanti;

import java.sql.*;

public class KullaniciDAO {

    public static boolean giriseYetkiliMi(KullaniciDTO kullanici) throws SQLException, ClassNotFoundException {

        String vtSifre = null;
        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "select sifre from kullanici where kullanici_adi=?";
        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setString(1, kullanici.getKullaniciAdi());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            vtSifre = rs.getString("sifre");
        }
        rs.close();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        String cozulmus_sifre = null;

        if(vtSifre != null) {
            cozulmus_sifre = AES.decrypt(vtSifre, Sabitler.SECRET_KEY);
        }
        else {
            // vtSifre null ise aşağıdaki eşitliği kontrol etmeye gerek yok.
            // Buradan metod sonucunu false olarak döndürüyorum.
            return false;
        }

        if(kullanici.getSifre().equals(vtSifre))
            return true;
        else
            return false;

    }

}
