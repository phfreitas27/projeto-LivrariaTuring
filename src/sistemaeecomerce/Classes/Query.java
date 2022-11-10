/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaeecomerce.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 821223900
 */
public class Query {
    private void pvDeletarUsuario(String id) {
        //1: Definir o comando SQL
        String sql = "DELETE FROM user WHERE login = ?";
        //2: Abrir uma conexão
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, id);
            //5: Executa o comando
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void DeletarAdmin(String id) {
        pvDeletarUsuario(id);
    }
    
    public void DeletarCliente(String id) {
        pvDeletarUsuario(id);
    }
    
    private void pvInserirAdmin (String login){
    //1: Definir o comando SQL
    String sql = "INSERT INTO admin(login) VALUES (?)";
    //2: Abrir uma conexão
    MySQL factory = new MySQL();
    try (Connection c = factory.obtemConexao()){
        //3: Pré compila o comando
        PreparedStatement ps = c.prepareStatement(sql);
        //4: Preenche os dados faltantes
        ps.setString(1, login);
        //5: Executa o comando
        ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void InserirAdmin (String login){
        pvInserirAdmin(login);
    }
    
    private boolean pvUsuarioExiste (String loginIns) {
        //1: Definir o comando SQL
        String sql = "SELECT EXISTS(SELECT * FROM user WHERE login = ?);";
        //2: Abrir uma conexão
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, loginIns);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            rs.next();
            return rs.getInt(1) == 1;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean UsuarioExiste (String login) {
        return pvUsuarioExiste(login);
    }
    
    private String[] pvLogar(String loginIns) {
        String[] resultado = new String[2];
        //1: Definir o comando SQL
        String sql = "SELECT login, password FROM user WHERE login = ?";
        //2: Abrir uma conexão
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, loginIns);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            
            rs.next();
            
            resultado[0] = rs.getString("login");
            resultado [1] = rs.getString("password");
            
            
            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] notFound = {"Nenhum usuário encontrado"};
        return notFound;
    }
    
    public String[] Logar(String loginIns) {
        return pvLogar(loginIns);
    }
    
    private String pvPegarIdLivro(String nome) {
        nome = nome.substring(29, nome.length() - 11);
        
        MySQL factory = new MySQL();
        String Id = "";
        //1: Definir o comando SQL
        String sql = "SELECT * FROM book WHERE name = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, nome);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            rs.next();
            Id = Integer.toString(rs.getInt("id"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Id;
    }
    
    public String PegarIdLivro(String nome) {
        return pvPegarIdLivro(nome);
    }
    
    private ArrayList<ArrayList<String>> pvPesquisarLivros(String nome) {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        MySQL factory = new MySQL();
          
        //1: Definir o comando SQL
        String sql = "SELECT * FROM book WHERE name LIKE ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, "%" + nome + "%");
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            int i = 0;
            while(rs.next()) {
                arr.add(new ArrayList());
                arr.get(i).add(Integer.toString(rs.getInt("id")));
                arr.get(i).add(rs.getString("name"));
                arr.get(i).add(Integer.toString(rs.getInt("price")));
                arr.get(i).add(Integer.toString(rs.getInt("stock")));
                arr.get(i).add(rs.getString("publisher"));
                arr.get(i).add(rs.getString("author"));
                arr.get(i).add(rs.getString("genero"));
                i++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<ArrayList<String>> PesquisarLivros(String nome) {
        return pvPesquisarLivros(nome);
    }
    
    private ArrayList<ArrayList<String>> pvPesquisarLivrosGenero(String genero) {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        MySQL factory = new MySQL();
          
        //1: Definir o comando SQL
        String sql = "SELECT * FROM book WHERE genero = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, genero);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            int i = 0;
            while(rs.next()) {
                arr.add(new ArrayList());
                arr.get(i).add(Integer.toString(rs.getInt("id")));
                arr.get(i).add(rs.getString("name"));
                arr.get(i).add(Integer.toString(rs.getInt("price")));
                arr.get(i).add(Integer.toString(rs.getInt("stock")));
                arr.get(i).add(rs.getString("publisher"));
                arr.get(i).add(rs.getString("author"));
                arr.get(i).add(rs.getString("genero"));
                i++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<ArrayList<String>> PesquisarLivrosGenero(String genero) {
        return pvPesquisarLivrosGenero(genero);
    }
    
    private ArrayList<ArrayList<String>> pvMostrarLivros() {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        MySQL factory = new MySQL();
          
        //1: Definir o comando SQL
        String sql = "SELECT * FROM book";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            int i = 0;
            while(rs.next()) {
                arr.add(new ArrayList());
                arr.get(i).add(Integer.toString(rs.getInt("id")));
                arr.get(i).add(rs.getString("name"));
                arr.get(i).add(rs.getString("price"));
                arr.get(i).add(Integer.toString(rs.getInt("stock")));
                arr.get(i).add(rs.getString("publisher"));
                arr.get(i).add(rs.getString("author"));
                arr.get(i).add(rs.getString("genero"));
                i++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<ArrayList<String>> MostrarLivros() {
        return pvMostrarLivros();
    }
    
    private String pvInserirLivro(String nome, String autor, String editora, double preco, int unidade, String genero) {
        String sql = "INSERT INTO book(price, stock, name, publisher, author, genero) VALUES (?, ?, ?, ?, ?,?)";
            //2: Abrir uma conexão
            MySQL factory = new MySQL();
            try (Connection c = factory.obtemConexao()) {
                //3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);
                //4: Preenche os dados faltantes
                ps.setDouble(1, preco);
                ps.setInt(2, unidade);
                ps.setString(3, nome);
                ps.setString(4, editora);
                ps.setString(5, autor);
                ps.setString(6, genero);
                //5: Executa o comando
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            //1: Definir o comando SQL
        String sql2 = "SELECT id FROM book WHERE name = ? AND publisher = ? AND author = ?;";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, nome);
            ps.setString(2, editora);
            ps.setString(3, autor);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            rs.next();
            return Integer.toString(rs.getInt("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Erro";
    }
    
    public String InserirLivro(String nome, String autor, String editora, double preco, int unidade, String genero) {
        return pvInserirLivro(nome, autor, editora, preco, unidade, genero);
    }
    
    private void pvInserirUsuario(String login, String senha, String email, String nome, int idade) {
        //1: Definir o comando SQL
            String sql = "INSERT INTO user(login, password, email, nome, idade) VALUES (?, ?, ?, ?, ?)";
            //2: Abrir uma conexão
            MySQL factory = new MySQL();
            try (Connection c = factory.obtemConexao()) {
                //3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);
                //4: Preenche os dados faltantes
                ps.setString(1, login);
                ps.setString(2, senha);
                ps.setString(3, email);
                ps.setString(4, nome);
                ps.setInt(5, idade);
                //5: Executa o comando
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public void InserirUsuario(String login, String senha, String email, String nome, int idade) {
        pvInserirUsuario(login, senha, email, nome, idade);
    }
    
    private boolean pvChecarAdmin(String loginIns) {
        //1: Definir o comando SQL
        String sql = "SELECT login FROM admin WHERE login = ?";
        //2: Abrir uma conexão
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, loginIns);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            if(!rs.next()) {
                return false;
            } else {
                return true;
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean ChecarAdmin(String loginIns) {
        return pvChecarAdmin(loginIns);
    }
    
    private void pvAdicionarCarrinho(String Id, String IdLivro, String IdUsuario) {
        //1: Definir o comando SQL
            String sql = "INSERT INTO cart(id, idBook, idUser) VALUES (?, ?, ?)";
            //2: Abrir uma conexão
            MySQL factory = new MySQL();
            try (Connection c = factory.obtemConexao()) {
                //3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);
                //4: Preenche os dados faltantes
                ps.setString(1, Id);
                ps.setString(2, IdLivro);
                ps.setString(3, IdUsuario);
                //5: Executa o comando
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public void AdicionarCarrinho(String Id, String IdLivro, String IdUsuario) {
        pvAdicionarCarrinho(Id ,IdLivro, IdUsuario);
    }
    
    private ArrayList<String> pvMostrarGeneros() {
        ArrayList arr = new ArrayList();
        String sql1 = "select * from rgenero";
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()){
             PreparedStatement ps = c.prepareStatement(sql1);
             ResultSet rs = ps.executeQuery();
             int i = 0;
             while(rs.next()){
             arr.add(rs.getString(2));
             }
        } catch (Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        return arr;
    }
    
    public ArrayList<String> MostrarGeneros() {
        return pvMostrarGeneros();
    }
    
    private ArrayList<String> pvMostrarAutores() {
        ArrayList arr = new ArrayList();
        String sql1 = "select * from rautor";
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()){
             PreparedStatement ps = c.prepareStatement(sql1);
             ResultSet rs = ps.executeQuery();
             int i = 0;
             while(rs.next()){
             arr.add(rs.getString(2));
             }
        } catch (Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        return arr;
    }
    
    public ArrayList<String> MostrarAutores() {
        return pvMostrarAutores();
    }
    
    private ArrayList<String> pvMostrarEditoras() {
        ArrayList arr = new ArrayList();
        String sql1 = "select * from reditora";
        MySQL factory = new MySQL();
        try (Connection c = factory.obtemConexao()){
             PreparedStatement ps = c.prepareStatement(sql1);
             ResultSet rs = ps.executeQuery();
             int i = 0;
             while(rs.next()){
             arr.add(rs.getString(2));
             }
        } catch (Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        return arr;
    }
    
    public ArrayList<String> MostrarEditoras() {
        return pvMostrarEditoras();
    }
    
    private void pvRemoverCarrinho(String Id, String IdLivro) {
        //1: Definir o comando SQL
            String sql = "DELETE FROM cart WHERE id = ? AND idBook = ?";
            //2: Abrir uma conexão
            MySQL factory = new MySQL();
            try (Connection c = factory.obtemConexao()) {
                //3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);
                //4: Preenche os dados faltantes
                ps.setString(1, Id);
                ps.setString(2, IdLivro);
                //5: Executa o comando
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public void RemoverCarrinho(String Id, String IdLivro) {
          pvRemoverCarrinho(Id, IdLivro);
    }
    
    private ArrayList<ArrayList<String>> pvMostrarLivrosCarrinho(String Id) {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        MySQL factory = new MySQL();
          
        //1: Definir o comando SQL
        String sql = "SELECT IdBook FROM cart WHERE id = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Id);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            int i = 0;
            String lastId = "";
            while(rs.next()) {
                if(!lastId.equals(rs.getString("IdBook"))) {
                    lastId = rs.getString("IdBook");
                    arr.add(pvPesquisarLivroId(rs.getString("IdBook")));
                    arr.get(i).add(Integer.toString(pvConsultarQuantidadeCarrinho(Id, rs.getString("IdBook"))));
                    i++;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<ArrayList<String>> MostrarLivrosCarrinho(String Id) {
        return pvMostrarLivrosCarrinho(Id);
    }
    
    private String pvMostrarValorCarrinho(String Id) {
        double valor = 0.00;
        ArrayList<Double> arr = new ArrayList<>();
        MySQL factory = new MySQL();
          
        //1: Definir o comando SQL
        String sql = "SELECT IdBook FROM cart WHERE id = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Id);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            int i = 0;
            while(rs.next()) {
                arr.add(Double.parseDouble(pvPesquisarLivroValorId(rs.getString("IdBook"))));
                i++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < arr.size(); i++) {
            valor += arr.get(i);
        }
        
        valor += 0.001;
        String resultado = Double.toString(valor);
        int ponto = 0;
        for (int i = 0; i < resultado.length(); i++) {
            if(resultado.charAt(i) == '.') {
                ponto = i;
            }
        }
        
        resultado = resultado.substring(0, ponto + 3);
        
        return resultado;
    }
    
    public String MostrarValorCarrinho(String Id) {
        return pvMostrarValorCarrinho(Id);
    }
    
    private ArrayList<String> pvPesquisarLivroId(String Id) {
        ArrayList<String> arr = new ArrayList();
        MySQL factory = new MySQL();
          
        //1: Definir o comando SQL
        String sql = "SELECT * FROM book WHERE id = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Id);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            int i = 0;
            while(rs.next()) {
                arr.add(Integer.toString(rs.getInt("id")));
                arr.add(rs.getString("name"));
                arr.add(rs.getString("price"));
                arr.add(Integer.toString(rs.getInt("stock")));
                arr.add(rs.getString("publisher"));
                arr.add(rs.getString("author"));
                arr.add(rs.getString("genero"));
                i++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    private String pvPesquisarLivroValorId(String Id) {
        MySQL factory = new MySQL();
        String valor = "";
        //1: Definir o comando SQL
        String sql = "SELECT price FROM book WHERE id = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Id);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            rs.next();
            valor = rs.getString("price");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
    }
    
    public ArrayList<String> PesquisarLivroId(String Id) {
        return pvPesquisarLivroId(Id);
    }
    
    private void pvAdicionarAutor(String nome) {
        //1: Definir o comando SQL
            String sql = "INSERT INTO `rautor`(`autor`) VALUES (?)";
            //2: Abrir uma conexão
            MySQL factory = new MySQL();
            try (Connection c = factory.obtemConexao()) {
                //3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);
                //4: Preenche os dados faltantes
                ps.setString(1, nome);
                //5: Executa o comando
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public void AdicionarAutor(String nome) {
        pvAdicionarAutor(nome);
    }
    
    private void pvAdicionarEditora(String nome) {
        //1: Definir o comando SQL
            String sql = "INSERT INTO `reditora`(`editora`) VALUES (?)";
            //2: Abrir uma conexão
            MySQL factory = new MySQL();
            try (Connection c = factory.obtemConexao()) {
                //3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);
                //4: Preenche os dados faltantes
                ps.setString(1, nome);
                //5: Executa o comando
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public void AdicionarEditora(String nome) {
        pvAdicionarEditora(nome);
    }
    
    private boolean pvAlterarLivro(String id, String nome, String preco, String unidades, String editora, String autor, String genero) {
        boolean success = false;
        
        String sql = "UPDATE book SET name=?, price=?, stock = ?, publisher=?, author=? ,genero=? WHERE id=?";
        MySQL factory = new MySQL();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, preco);
            ps.setString(3, unidades);
            ps.setString(4, editora);
            ps.setString(5, autor);
            ps.setString(7, id);
            ps.setString(6, genero);
            int adicionado = ps.executeUpdate();
            if (adicionado > 0) {
                success = true;
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }
    
    public boolean AlterarLivro(String id, String nome, String preco, String unidades, String editora, String autor, String genero) {
        return pvAlterarLivro(id, nome, preco, unidades, editora, autor, genero);
    }
    
    private boolean pvDeletarLivro (String Id) {
        String sql = "Delete From book WHERE id=?";
        MySQL factory = new MySQL();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, Id);
            int adicionado = ps.executeUpdate();
            if (adicionado > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }
    
    public boolean DeletarLivro (String Id) {
        return pvDeletarLivro(Id);
    }
    
    private void pvAlterarLivroUnidade(String id, int unidades) {
        String sql = "UPDATE book SET stock = ? WHERE id=?";
        MySQL factory = new MySQL();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, Integer.toHexString(unidades));
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void AlterarLivroUnidade(String Id, int unidades) {
        pvAlterarLivroUnidade(Id, unidades);
    }
    
    private int pvConsultarEstoque(String Id) {
        MySQL factory = new MySQL();
        int quantidade = 0;
        //1: Definir o comando SQL
        String sql = "SELECT stock FROM book WHERE id = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Id);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            rs.next();
            quantidade = rs.getInt("stock");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quantidade;
    }
    
    public int ConsultarEstoque(String Id) {
        return pvConsultarEstoque(Id);
    }
    
    private int pvConsultarQuantidadeCarrinho(String Id, String IdLivro) {
        MySQL factory = new MySQL();
        int quantidade = 0;
        //1: Definir o comando SQL
        String sql = "SELECT COUNT(id) FROM cart WHERE id = ? AND IdBook = ?";
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Id);
            ps.setString(2, IdLivro);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            rs.next();
            quantidade = rs.getInt(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quantidade;
    }
    
    public int ConsultarQuantidadeCarrinho(String Id, String IdLivro) {
        return pvConsultarQuantidadeCarrinho(Id, IdLivro);
    }
}