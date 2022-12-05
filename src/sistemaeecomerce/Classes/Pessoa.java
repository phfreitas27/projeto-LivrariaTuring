package sistemaeecomerce.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import javax.swing.JOptionPane;
import sistemaeecomerce.Classes.MySQL;

public class Pessoa {
    
    private Query query = new Query();
    private String nome;
    private int idade;
    private String email;
    private String login;
    private String senha;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void inserir(String cep, String rua, String complemento, String estado, String cidade) {
        if(loginExists(this.login)) {
            JOptionPane.showMessageDialog(null,"Já existe um usuário com este login, escolha outro!", "Atenção!",JOptionPane.INFORMATION_MESSAGE );
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro Concluído!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            query.InserirUsuario(this.login, this.senha, this.email, this.nome, this.idade, cep, rua, complemento, estado, cidade);
        }
    }
    
    public boolean loginExists(String loginIns) {
        return query.UsuarioExiste(loginIns);
    }
    
    public boolean logar(String loginIns, String senhaIns) {
        if(loginExists(loginIns)) {
            
            String[] dados = query.Logar(loginIns);
            
            this.setLogin(dados[0]);
            this.setSenha(dados[1]);
            
            if(this.getLogin().equals(loginIns) && this.getSenha().equals(senhaIns)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean isAdmin(String loginIns) {
        return query.ChecarAdmin(loginIns);
    }
    
    public String getNomeById(String Id) {
        return query.PesquisarNomeByIdUsuario(Id);
    }
}
