package sistemaeecomerce.Classes;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private Float saldo;
    private Query query = new Query();
    
    public Float getSaldo() {
        return saldo;
    }
    
    public String PesquisarEndereco(String Id) {
        ArrayList<String> resultado = query.ConsultarEndereco(Id);
        String endereco = "";
        for (int i = 0; i < resultado.size(); i++) {
            if (i == 0) {
                endereco += resultado.get(i);
            } else {
                endereco += ", " + resultado.get(i);
            }
        }
        return endereco;
    }
    
}
