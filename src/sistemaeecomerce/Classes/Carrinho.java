
package sistemaeecomerce.Classes;

import java.util.ArrayList;
import java.util.UUID;

public class Carrinho extends Cliente{
    private Query query = new Query();
    private int quantidade;
    private String Id;
    private double valor;
    private ArrayList<String> idLivros;
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void AddCarrinho(String IdLivro, String IdUsuario){
        query.InserirCarrinho(this.Id, IdLivro, IdUsuario);
    }
    
    public void verDetalhes(){
        
    }
    
    public void ProsseguirCompra(){
        
    }

    public Carrinho(ArrayList<String> IdLivros, String IdUsuario) {
        this.Id = UUID.randomUUID().toString();
        this.idLivros = IdLivros;
        
        for (int i = 0; i < IdLivros.size(); i++) {
            query.InserirCarrinho(this.Id, IdLivros.get(i), IdUsuario);
        }
    }
    
    public Carrinho() {
        this.Id = UUID.randomUUID().toString();
    }
    
}
