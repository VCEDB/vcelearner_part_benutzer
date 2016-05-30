/**
 * Design Pattern: Singleton
 * Idee: möchte nur 1 Objekt dieser Klasse haben
 * Umsetzung:
 * Connection con ist static, ist Klassenvariable
 * falls es con noch nicht gibt, wird con erstellt und zurückgegeben
 * falls con schon vorhanden ist, wird con zurückgegeben
 */
package vcelearner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rolfhackel
 */
public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/vcelearner";
    private static final String USER = "root";
    private static final String PASSWORD = "ncc1701d";

    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return con;
    }
    public static void closeConnection(){
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
