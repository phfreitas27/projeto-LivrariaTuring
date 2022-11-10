package sistemaeecomerce.Classes;

import javax.swing.JOptionPane;

public class Catalogo extends Livro{

    public Catalogo() {
    }
    
    public void Incluir(int getId, String getnome, double getpreco, int getunidade, String geteditora, String autor){
        getId = getId;
        getnome = getnome;
        getpreco = getpreco;
        getunidade = getunidade;
        geteditora = geteditora;
    }
    public void Excluir(String Id){
        if(Id == Id){
         System.out.println("O livro foi excluido!");
        } else{
            System.out.println("Id nao encontrado, Tente novamente!");
        }
    }
    public void Consultar(String Id){
        if(Id.equals(Id)){
            System.out.println("Nome: " + getnome() + 
            "/nPreco: " + getpreco () + 
            "/nUnidade: " + getunidade () + 
            "/nEditora: " + geteditora());
        } else{
            System.out.println("Livro indisponivel !!!");
        }
    }
    public void Alterar(String Id){
        if(Id.equals(Id)){
            String alt = JOptionPane.showInputDialog("Digite o numero que corresponde oque voce deseja alterar:" + "\nNome = 1" + "\nPreco = 2" + "\nUnidade = 3" + "\nEditora = 4");
            if("1".equals(alt)){
                 String novonome = JOptionPane.showInputDialog("Digite o nome novo do livro: ");
                 novonome = getnome();
            }
            if("2".equals(alt)){
                double novopreco = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo preco do livro: "));
                novopreco = getpreco();
            }
            if("3".equals(alt)){
                int novaunidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade"));
                novaunidade = getunidade();
                }
            if( "4".equals(alt)){
                String novaeditora = JOptionPane.showInputDialog("Digite a nova editora: ");
                novaeditora = geteditora();
            } else{
                JOptionPane.showMessageDialog(null, "Erro!!!, Tente novamente");
            }
        }
                
    }
}
