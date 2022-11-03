
package sistemaeecomerce.Classes;

import java.util.ArrayList;

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
        query.AdicionarCarrinho(this.Id ,IdLivro, IdUsuario);
    }
    
    public void RemCarrinho(String IdLivro, String Id) {
        query.RemoverCarrinho(Id, IdLivro);
    }
    
    public ArrayList<ArrayList<String>> verDetalhes(String Id){
        return query.MostrarLivrosCarrinho(Id);
    }
    
    public void ProsseguirCompra(){
        
    }
    
}
