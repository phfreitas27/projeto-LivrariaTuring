/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaeecomerce.Classes;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 821223900
 */
public class MySQL {
    private String usuario = "Mm9vZV2ljr";
    private String senha = "MKLGhqNlMp";
    private String host = "remotemysql.com";
    private String porta = "3306";
    private String bd = "Mm9vZV2ljr";
    public Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + porta + "/" + bd,
                usuario,
                senha
            );
            return c;
            }
                catch (Exception e){
                e.printStackTrace();
                return null;
            }
    }
}
