package br.com.droid;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Version;

public class T {

    public static void main(String[] args) throws ClassNotFoundException {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

    
        String url = "jdbc:postgresql://gdias.dyndns.biz/GDroid";
        String user = "postgres";
        String password = "postgresgdias";

        try {
            
            Class.forName("org.postgresql.Driver"); 
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM vendedores");
                    
            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}