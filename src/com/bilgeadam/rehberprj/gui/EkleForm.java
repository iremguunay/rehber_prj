package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KisiDAO;
import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class EkleForm extends JFrame {
    private JPanel jPanel1;
    private JTextField noTextField;
    private JTextField adTextField;
    private JTextField soyadTextField;
    private JTextField maasTextField;
    private JTextField dogtarTextField;
    private JTextField ceptelTextField;
    private JButton ekleButton;

    public EkleForm() {
        add(jPanel1);
        setTitle("Kişi Ekle Ekranı");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(300,400);
        setLocationRelativeTo(null);
        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    KisiDTO kisi = new KisiDTO();

                    kisi.setNo(Integer.parseInt(noTextField.getText()));
                    kisi.setAd(adTextField.getText());
                    kisi.setSoyad(soyadTextField.getText());
                    kisi.setMaas(Double.parseDouble(maasTextField.getText()));
                    kisi.setDogtar(CevirmeIslemleri.strToUtilDate(dogtarTextField.getText()));
                    kisi.setCepTel(ceptelTextField.getText());

                    boolean sonuc = KisiDAO.ekle(kisi);

                    if (sonuc) {
                        JOptionPane.showMessageDialog(null, "Kişi başarıyla eklendi.");
                        temizle();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Kişi ekleme başarısız!");
                    }


                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:" + ex.getMessage());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:" + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:" + ex.getMessage());
                }
            }
        });
    }

    public void temizle() {
        noTextField.setText("");
        adTextField.setText("");
        soyadTextField.setText("");
        maasTextField.setText("");
        dogtarTextField.setText("");
        ceptelTextField.setText("");
    }

//    public static void main(String[] args) {
//        EkleForm ekle = new EkleForm();
//        ekle.setVisible(true);
//    }
}
