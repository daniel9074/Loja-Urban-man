 
package central;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import Dao.daoProduto;
 
public class menu {

    
    public static void main(String[] args) {
        
 
        
        tela_login tl = new tela_login();
        tl.setVisible(true);
        tl.setTitle("tela de login");
        tl.setLocationRelativeTo(null);

       
      
   
    }
    
}
