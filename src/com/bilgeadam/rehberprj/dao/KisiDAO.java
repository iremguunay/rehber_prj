package com.bilgeadam.rehberprj.dao;

import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;
import com.bilgeadam.rehberprj.vt.VTBaglanti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KisiDAO {

    public static boolean ekle(KisiDTO kisi) throws SQLException, ClassNotFoundException {

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "insert into kisi(no, ad, soyad, maas, dogtar, mobil_tel) values(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setInt(1, kisi.getNo());
        ps.setString(2, kisi.getAd());
        ps.setString(3, kisi.getSoyad());
        ps.setDouble(4,kisi.getMaas());
        ps.setDate(5, CevirmeIslemleri.utilToSqlDate(kisi.getDogtar()));
        // ps.setDate(5, new java.sql.Date(kisi.getDogtar().getTime()));
        ps.setString(6,kisi.getCepTel());

        int sonuc = ps.executeUpdate();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        if (sonuc > 0)
            return true;
        else
            return false;

    }

    public static List<KisiDTO> listele() throws SQLException, ClassNotFoundException {

        List<KisiDTO> kisiListesi = new ArrayList();

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "select no, ad, soyad, maas, dogtar, mobil_tel from kisi";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            KisiDTO kisi = new KisiDTO();
            kisi.setNo(rs.getInt("no"));
            kisi.setAd(rs.getString("ad"));
            kisi.setSoyad(rs.getString("soyad"));
            kisi.setMaas(rs.getDouble("maas"));
            kisi.setDogtar(CevirmeIslemleri.sqlToUtilDate(rs.getDate("dogtar")));
            kisi.setCepTel(rs.getString("mobil_tel"));

            kisiListesi.add(kisi);
        }

        rs.close();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        return kisiListesi;
    }

    public static boolean sil(int no) throws SQLException, ClassNotFoundException {

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "delete from kisi where no=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setInt(1, no);

        int sonuc = ps.executeUpdate();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        if (sonuc > 0)
            return true;
        else
            return false;

    }

    public static boolean guncelle(KisiDTO kisi) throws SQLException, ClassNotFoundException {

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "update kisi set ad=?, soyad=?,maas=?, dogtar=?, mobil_tel=? where no=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setString(1, kisi.getAd());
        ps.setString(2, kisi.getSoyad());
        ps.setDouble(3,kisi.getMaas());

        if(kisi.getDogtar() == null)
            ps.setDate(4, null);
        else
            ps.setDate(4, CevirmeIslemleri.utilToSqlDate(kisi.getDogtar()));
        // ps.setDate(5, new java.sql.Date(kisi.getDogtar().getTime()));

        ps.setString(5,kisi.getCepTel());

        ps.setInt(6, kisi.getNo());

        int sonuc = ps.executeUpdate();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        if (sonuc > 0)
            return true;
        else
            return false;
    }
}
