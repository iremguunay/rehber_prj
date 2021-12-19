package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JPanel jPanel1;
    private JTextField adTF;
    private JPasswordField sifrePF;
    private JButton girisButton;

    public LoginForm() {

        add(jPanel1);

        //kapatma butonuna (çarpıya) basınca programdan çıksın
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300,400);
        //mutlaka setSize'dan sonra tanımlanmalı.
        //ekrana göre ortalasın
        setLocationRelativeTo(null);

        setTitle("Giriş Ekranı");

        girisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Butona basıldı!");
                if (adTF.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Ad alanı boş geçilemez.");
                    //Aşağıdaki kodları çalıştırmasın diye return ekledik.
                    return;
                }
                if (String.valueOf(sifrePF.getPassword()).length() == 0) {
                    JOptionPane.showMessageDialog(null, "Şifre alanı boş geçilemez.");
                    return;
                }

                try {
                    KullaniciDTO kullanici = new KullaniciDTO();
                    kullanici.setKullaniciAdi(adTF.getText());
                    kullanici.setSifre(String.valueOf(sifrePF.getPassword()));

                    boolean sonuc = KullaniciDAO.giriseYetkiliMi(kullanici);

                    if (sonuc) {
                        MenuForm menu = new MenuForm();
                        //menu ekranını göster
                        menu.setVisible(true);

                        //login ekranını gizle
                        setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Giriş yetkisi yok!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
                }
            }
        });
    }
}
