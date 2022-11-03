package sistemaeecomerce.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Livro {
    private Query query = new Query();
    private String Id;
    private String nome;
    private double preco;
    private int unidade;
    private String editora;
    private String autor;

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
    
    public void AddUnidade(){
        this.unidade++;
    }
    
    public void TakeUnidade(){
        this.unidade--;
    }
     
    public void Inserir() {
        
        this.setId(query.InserirLivro(nome, autor, editora, preco, unidade));
        
    }
    
    public ArrayList<ArrayList<String>> mostrarLivros() {
        return query.MostrarLivros();
    }
    
    public ArrayList<ArrayList<String>> pesquisarLivros(String nome) {
        return query.PesquisarLivros(nome);
    }

    public Livro(String nome, double preco, int unidade, String editora, String autor) {
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.editora = editora;
        this.autor = autor;
    }

    public Livro() {
        
    }
    
}
