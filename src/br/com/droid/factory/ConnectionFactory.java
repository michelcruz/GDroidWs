package br.com.droid.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class ConnectionFactory {
    
    // database URL
    private static final String DATABASE_URL = "jdbc:postgresql://192.168.0.100/gdroid";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "q1w2e3r4";
    
//     String url = "jdbc:postgresql://localhost/gdroid";
//        String user = "postgres";
//        String password = "q1w2e3r4";

    public Connection getConnection() throws ClassNotFoundException {

     Class.forName("org.postgresql.Driver");   
     Connection con = null;
     
     try {
         con = DriverManager.getConnection(DATABASE_URL, USERNAME,
                 PASSWORD);
     } catch (Exception e) {
         System.out.println("Erro ao criar conexao.");
     }
     return con;
    }

    public void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
     try {
         close(conn, stmt, rs);
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
     }
    }

    public void closeConnection(Connection conn, Statement stmt) {
     try {
         close(conn, stmt, null);
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
     }
    }

    public void closeConnection(Connection conn) {
     try {
         close(conn, null, null);
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
     }
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {

     try {
         if (rs != null) {
             rs.close();
         }
         if (stmt != null) {
             stmt.close();
         }
         if (conn != null) {
             conn.close();
         }
     } catch (Exception e) {
         System.out.println("Erro ao fechar conexao.");
     }
    }
}
 
