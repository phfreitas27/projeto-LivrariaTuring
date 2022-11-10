
package sistemaeecomerce.Classes;

import java.util.ArrayList;

public class Endereco extends Cliente{
    private String rua;
    private String numero;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
    private String bairro;
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean pesquisarCep(String cep) {
        Query query = new Query();
        ArrayList<String> resultado = query.ConsultarCep(cep);
        if(resultado.size() > 1) {
            this.rua = resultado.get(0);
            this.complemento = resultado.get(1);
            this.estado = resultado.get(2);
            this.cidade = resultado.get(3);
            this.bairro = resultado.get(4);
            this.cep = cep;
            return true;
        } else {
            return false;
        }
        
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
}
