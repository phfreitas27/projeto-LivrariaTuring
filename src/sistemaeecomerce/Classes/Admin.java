package sistemaeecomerce.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Admin extends Pessoa{
    
    Query query = new Query();
    
    public void RemoverCliente(String id){
        query.DeletarCliente(id);
    }
    
    public void AtualizarCatalogo(String id){
        
    }
    
    public void inserirAdmin (){
        query.InserirAdmin(this.getLogin());
    }
    
    public void deletarAdmin(String id) {
        
        query.DeletarAdmin(id);
        
    }
    
}

