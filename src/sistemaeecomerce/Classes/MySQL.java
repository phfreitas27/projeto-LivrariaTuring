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
    private String usuario = "root";
    private String senha = "anima123";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "biblioteca";
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
