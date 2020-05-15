
package veritabanı;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Veritabanı {

    private String kullanıcıad="root";
private  String sifre="1234";
private String host="localhost";
private int port=3306;
private String databasename="ders";
private Connection con=null;
private  Statement statement=null;
//Constructor tanımladım ve veritabanına bağlandım.
public Veritabanı(){
    String url="jdbc:mysql://"+host+":"+port+"/"+databasename+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı");
        }
        try {
            con=DriverManager.getConnection(url,kullanıcıad,sifre);
            orneksorgu();
        } catch (SQLException ex) {
            System.out.println("Bağlantı Sağlanamadı.");
        }
    
}
   
 public void orneksorgu(){
   
        try {
            String sorgu="Select*From dersler";
            statement = con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
                String derskodu=rs.getString("ders_kodu");
                String ders=rs.getString("ders_adi");
                System.out.println(derskodu);
                System.out.println(ders);
                System.out.println("********");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabanı.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
   }
   
    
}
