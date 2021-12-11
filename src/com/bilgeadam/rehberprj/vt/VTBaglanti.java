package com.bilgeadam.rehberprj.vt;

import java.sql.*;

public class VTBaglanti {

    //Static - çünkü nesne oluşturmadan ulaşmak istiyorum
    public static Connection baglantiGetir() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection conn =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/rehber", "postgres", "postgres");

        return conn;
    }

    public static void baglantiKapat(Connection conn) throws SQLException {

            conn.close();

    }

}
