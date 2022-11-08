package sistemaeecomerce.Classes;


import java.util.ArrayList;

public class Livro {
    private Query query = new Query();
    private String Id;
    private String nome;
    private double preco;
    private int unidade;
    private String editora;
    private String autor;
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
   
    private void setId(String Id){
       this.Id = Id;
    }
    public String getId(){
         return this.Id;
    }

    public void setnome(String nome){
        this.nome = nome;
    }
    public String getnome(){
        return this.nome;
    }

    public void setpreco(double preco){
        this.preco = preco;
}
    public double getpreco(){
    return this.preco;
}

    public void setunidade(int unidade){
        this.unidade = unidade;
    }
    public int getunidade(){
        return this.unidade;
    }

    public void seteditora(String editora){
        this.editora = editora;
    }
    public String geteditora(){
        return this.editora;
    }
    
    public void AddUnidade(int quantidade){
        this.unidade += quantidade;
        query.AlterarLivroUnidade(Id, unidade);
    }
    
    public void TakeUnidade(int quantidade){
        this.unidade -= quantidade;
        query.AlterarLivroUnidade(Id, unidade);
    }
     
    public void Inserir() {
        
        this.setId(query.InserirLivro(nome, autor, editora, preco, unidade, genero));
        
    }
    
    public ArrayList<ArrayList<String>> mostrarLivros() {
        return query.MostrarLivros();
    }
    
    public ArrayList<ArrayList<String>> pesquisarLivros(String nome) {
        return query.PesquisarLivros(nome);
    }
    
    public ArrayList<ArrayList<String>> pesquisarLivrosGenero(String genero) {
        return query.PesquisarLivrosGenero(genero);
    }
    
    public String getIdBd(String nome) {
        String id = query.PegarIdLivro(nome);
        return id;
    }
    
    public boolean Alterar (String Id, String nome, String preco, String unidades, String editora, String autor, String genero) {
        return query.AlterarLivro(Id, nome, preco, unidades, editora, autor, genero);
    }
    
    public boolean Deletar (String Id) {
        return query.DeletarLivro(Id);
    }
    
    public int ConsultarEstoque(String Id) {
        return query.ConsultarEstoque(Id);
    }

    public Livro(String nome, double preco, int unidade, String editora, String autor, String genero) {
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.editora = editora;
        this.autor = autor;
        this.genero = genero;
    }

    public Livro() {
        
    }
    
}
