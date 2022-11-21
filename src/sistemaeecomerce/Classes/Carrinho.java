
package sistemaeecomerce.Classes;

import java.util.ArrayList;

public class Carrinho extends Cliente{
    private Query query = new Query();
    private int quantidade;
    private String Id;
    private String valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public void AddCarrinho(String IdLivro, String IdUsuario){
        query.AdicionarCarrinho(this.Id ,IdLivro, IdUsuario);
    }
    
    public void RemCarrinho(String IdLivro, String Id) {
        query.RemoverCarrinho(Id, IdLivro);
    }
    
    public String AtualizarValor() {
        this.valor = query.MostrarValorCarrinho(this.Id);
        return this.valor;
    }
    
    public ArrayList<ArrayList<String>> verDetalhes(String Id){
        ArrayList<ArrayList<String>> arr = query.MostrarLivrosCarrinho(Id);
        ArrayList<String> result = new ArrayList();
        for (int i = 0; i < arr.size(); i++) {
            result.add(arr.get(i).get(0));
        }
        this.idLivros = result;
        return arr;
    }
    
    public int ConsultarQuantidade(String Id, String IdLivro) {
        return query.ConsultarQuantidadeCarrinho(Id, IdLivro);
    }
    
    public int ConsultarQuantidade(String IdLivro) {
        return query.ConsultarQuantidadeCarrinho(this.Id, IdLivro);
    }
    
    public void ProsseguirCompra(String idVenda, String idUser){
        Livro l = new Livro();
        for (int i = 0; i < this.idLivros.size(); i++) {
            double valor = Double.parseDouble(query.PesquisarLivroValorId(this.idLivros.get(i)));
            for (int j = 0; j < query.ConsultarQuantidadeCarrinho(this.Id, this.idLivros.get(i)); j++) {
                query.InserirVenda(idVenda, idUser, this.Id, this.idLivros.get(i), valor);
                l.setId(idLivros.get(i));
                l.TakeUnidade(1);
            }
        }
    }
    
}
