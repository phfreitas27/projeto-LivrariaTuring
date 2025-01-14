/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemaeecomerce;

import java.awt.Color;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
import sistemaeecomerce.Classes.Carrinho;
import sistemaeecomerce.Classes.Livro;
import sistemaeecomerce.Classes.Query;

/**
 *
 * @author thiago.baptista
 */
public class CarrinhoTela extends javax.swing.JFrame {
    
    String IdUsuario;
    String valor;
    String Id;
    ArrayList<String> LivrosNome = new ArrayList();
    
    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    private void atualizarValorTela() {
        String formatted = this.valor;
        String partOne = formatted.substring(0, formatted.length() - 3);
        String partTwo = formatted.substring(formatted.length() - 2, formatted.length());
        String combined = partOne + partTwo;
        System.out.println(combined);
        String plainText = combined;
        formatted = "";
        switch (plainText.length()) {
            case 0:
                formatted = "R$0,00";
                break;
            case 1:
                formatted = "R$0,0" + plainText;
                break;
            case 2:
                formatted = "R$0," + plainText;
                break;
            default:
                partOne = plainText.substring(0, plainText.length() - 2);
                partTwo = plainText.substring(plainText.length() - 2, plainText.length());
                int k = 0;
                boolean doSubtring = false;
                for (int j = 0; j < partOne.length(); j++) {

                    if(Character.toString(partOne.charAt(j)).equals("0")) {
                        doSubtring = true;
                        k++;
                    } else {
                        if(doSubtring) {
                            partOne = partOne.substring(k);
                        }
                        break;
                    }

                    if(j == partOne.length() - 1) {
                        if(doSubtring) {
                            partOne = partOne.substring(k - 1);
                        }
                        break;
                    }

                }

                formatted = "R$" + partOne + "," + partTwo;
                break;
        }
        ValorTotal.setText(formatted);
    }
    
    public void atualizar() {
        javax.swing.JPanel[] lista = {L1, L2, L3, L4, L5, L6, L7, L8};
        javax.swing.JLabel[] titulos = {TituloL1, TituloL2, TituloL3, TituloL4, TituloL5, TituloL6, TituloL7, TituloL8};
        javax.swing.JTextField[] precos = {PrecoL1, PrecoL2, PrecoL3, PrecoL4, PrecoL5, PrecoL6, PrecoL7, PrecoL8};
        javax.swing.JTextField[] editoras = {EditoraL1, EditoraL2, EditoraL3, EditoraL4, EditoraL5, EditoraL6, EditoraL7, EditoraL8};
        javax.swing.JTextField[] autores = {AutorL1, AutorL2, AutorL3, AutorL4, AutorL5, AutorL6, AutorL7, AutorL8};
        javax.swing.JTextField[] generos = {GeneroL1, GeneroL2, GeneroL3, GeneroL4, GeneroL5, GeneroL6, GeneroL7, GeneroL8};
        javax.swing.JSpinner[] quantidades = {QuantidadeL1, QuantidadeL2, QuantidadeL3, QuantidadeL4, QuantidadeL5, QuantidadeL6, QuantidadeL7, QuantidadeL8};
        Carrinho c = new Carrinho();
        LivrosNome.clear();
        c.setId(Id);
        c.AtualizarValor();
        
        this.valor = c.getValor();
        atualizarValorTela();
        
        ArrayList<ArrayList<String>> arrL = c.verDetalhes(Id);
        
        for (int i = 0; i < lista.length; i++) {
            
            if(i < arrL.size()) {
                
                String nomes1 = arrL.get(i).get(1);
                String formatted = arrL.get(i).get(2);
                String partOne = formatted.substring(0, formatted.length() - 3);
                String partTwo = formatted.substring(formatted.length() - 2, formatted.length());
                String combined = partOne + partTwo;
                String plainText = combined;
                formatted = "";
                switch (plainText.length()) {
                    case 0:
                        formatted = "R$0,00";
                        break;
                    case 1:
                        formatted = "R$0,0" + plainText;
                        break;
                    case 2:
                        formatted = "R$0," + plainText;
                        break;
                    default:
                        partOne = plainText.substring(0, plainText.length() - 2);
                        partTwo = plainText.substring(plainText.length() - 2, plainText.length());
                        int k = 0;
                        boolean doSubtring = false;
                        for (int j = 0; j < partOne.length(); j++) {

                            if(Character.toString(partOne.charAt(j)).equals("0")) {
                                doSubtring = true;
                                k++;
                            } else {
                                if(doSubtring) {
                                    partOne = partOne.substring(k);
                                }
                                break;
                            }

                            if(j == partOne.length() - 1) {
                                if(doSubtring) {
                                    partOne = partOne.substring(k - 1);
                                }
                                break;
                            }

                        }

                        formatted = "R$" + partOne + "," + partTwo;
                        break;
                }
                String precos1 = formatted;
                String unidades1 = arrL.get(i).get(3);
                String editoras1 = arrL.get(i).get(4);
                String autores1 = arrL.get(i).get(5);
                String generos1 = arrL.get(i).get(6);
                String quantidades1 = arrL.get(i).get(7);
                
                titulos[i].setText("<html><p style=\"width:120px\">"+nomes1+"</p></html>");
                LivrosNome.add(nomes1 + " (" + quantidades1 + ")");
                precos[i].setText(precos1);
                editoras[i].setText(editoras1);
                autores[i].setText(autores1);
                generos[i].setText(generos1);
                quantidades[i].setValue(Integer.parseInt(quantidades1));
                
            } else {
                lista[i].setVisible(false);
            }  
        }
    }
    
    public void setId(String Id) {
        this.Id = Id;
        atualizar();
    }
    
    public void remCarrinho(String nome) {
        Livro l = new Livro();
        String IdLivro = l.getIdBd(nome);
        Carrinho c = new Carrinho();
        c.RemCarrinho(IdLivro, Id);
        atualizar();
        /*for (int i = 0; i < LivrosNome.size(); i++) {
            if(LivrosNome.get(i).equals(nome)) {
                LivrosNome.remove(i);
            }
        }
        */
        JOptionPane.showMessageDialog(null, "Livro removido do carrinho!");
    }
    
    /**
     * Creates new form Carrinho
     */
    public CarrinhoTela() {
        super("Carrinho");
        initComponents();
        Query qa = new Query();
        qa.Inseriricone(this);
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        L1 = new javax.swing.JPanel();
        TituloL1 = new javax.swing.JLabel();
        CarrinhoL1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        PrecoL1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        EditoraL1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        AutorL1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        GeneroL1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        QuantidadeL1 = new javax.swing.JSpinner();
        L2 = new javax.swing.JPanel();
        TituloL2 = new javax.swing.JLabel();
        CarrinhoL2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        PrecoL2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        EditoraL2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        AutorL2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        GeneroL2 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        QuantidadeL2 = new javax.swing.JSpinner();
        L3 = new javax.swing.JPanel();
        TituloL3 = new javax.swing.JLabel();
        CarrinhoL3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        PrecoL3 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        EditoraL3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        AutorL3 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        GeneroL3 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        QuantidadeL3 = new javax.swing.JSpinner();
        L4 = new javax.swing.JPanel();
        TituloL4 = new javax.swing.JLabel();
        CarrinhoL4 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        PrecoL4 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        EditoraL4 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        AutorL4 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        GeneroL4 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        QuantidadeL4 = new javax.swing.JSpinner();
        L5 = new javax.swing.JPanel();
        TituloL5 = new javax.swing.JLabel();
        CarrinhoL5 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        PrecoL5 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        EditoraL5 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        AutorL5 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        GeneroL5 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        QuantidadeL5 = new javax.swing.JSpinner();
        L6 = new javax.swing.JPanel();
        TituloL6 = new javax.swing.JLabel();
        CarrinhoL6 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        PrecoL6 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        EditoraL6 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        AutorL6 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        GeneroL6 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        QuantidadeL6 = new javax.swing.JSpinner();
        L7 = new javax.swing.JPanel();
        TituloL7 = new javax.swing.JLabel();
        CarrinhoL7 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        PrecoL7 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        EditoraL7 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        AutorL7 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        GeneroL7 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        QuantidadeL7 = new javax.swing.JSpinner();
        L8 = new javax.swing.JPanel();
        TituloL8 = new javax.swing.JLabel();
        CarrinhoL8 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        PrecoL8 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        EditoraL8 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        AutorL8 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        GeneroL8 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        QuantidadeL8 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        ValorTotal = new javax.swing.JTextField();
        FinalizarCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        L1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL1.setText("Titulo");

        CarrinhoL1.setText("Remover");
        CarrinhoL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL1ActionPerformed(evt);
            }
        });

        jLabel28.setText("Preço:");

        PrecoL1.setEditable(false);

        jLabel29.setText("Editora:");

        EditoraL1.setEditable(false);

        jLabel30.setText("Autor(a):");

        AutorL1.setEditable(false);

        jLabel31.setText("Gênero:");

        GeneroL1.setEditable(false);

        jLabel60.setText("Quantidade:");

        QuantidadeL1.setEnabled(false);

        javax.swing.GroupLayout L1Layout = new javax.swing.GroupLayout(L1);
        L1.setLayout(L1Layout);
        L1Layout.setHorizontalGroup(
            L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL1))
                    .addGroup(L1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL1))
                    .addGroup(L1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(14, 14, 14)
                        .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL1)))
                    .addGroup(L1Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL1))
                    .addGroup(L1Layout.createSequentialGroup()
                        .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel28))
                            .addComponent(TituloL1)
                            .addGroup(L1Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L1Layout.setVerticalGroup(
            L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L1Layout.createSequentialGroup()
                .addComponent(TituloL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(PrecoL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(EditoraL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(GeneroL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(AutorL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(QuantidadeL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL1)
                .addContainerGap())
        );

        jPanel1.add(L1, new java.awt.GridBagConstraints());

        L2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL2.setText("Titulo");

        CarrinhoL2.setText("Remover");
        CarrinhoL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL2ActionPerformed(evt);
            }
        });

        jLabel32.setText("Preço:");

        PrecoL2.setEditable(false);

        jLabel33.setText("Editora:");

        EditoraL2.setEditable(false);

        jLabel34.setText("Autor(a):");

        AutorL2.setEditable(false);

        jLabel35.setText("Gênero:");

        GeneroL2.setEditable(false);

        jLabel61.setText("Quantidade:");

        QuantidadeL2.setEnabled(false);

        javax.swing.GroupLayout L2Layout = new javax.swing.GroupLayout(L2);
        L2.setLayout(L2Layout);
        L2Layout.setHorizontalGroup(
            L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL2))
                    .addGroup(L2Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL2))
                    .addGroup(L2Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(14, 14, 14)
                        .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL2)))
                    .addGroup(L2Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL2))
                    .addGroup(L2Layout.createSequentialGroup()
                        .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel32))
                            .addComponent(TituloL2)
                            .addGroup(L2Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L2Layout.setVerticalGroup(
            L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L2Layout.createSequentialGroup()
                .addComponent(TituloL2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(PrecoL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(EditoraL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(GeneroL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(AutorL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(QuantidadeL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL2)
                .addContainerGap())
        );

        jPanel1.add(L2, new java.awt.GridBagConstraints());

        L3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL3.setText("Titulo");

        CarrinhoL3.setText("Remover");
        CarrinhoL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL3ActionPerformed(evt);
            }
        });

        jLabel36.setText("Preço:");

        PrecoL3.setEditable(false);

        jLabel37.setText("Editora:");

        EditoraL3.setEditable(false);

        jLabel38.setText("Autor(a):");

        AutorL3.setEditable(false);

        jLabel39.setText("Gênero:");

        GeneroL3.setEditable(false);

        jLabel62.setText("Quantidade:");

        QuantidadeL3.setEnabled(false);

        javax.swing.GroupLayout L3Layout = new javax.swing.GroupLayout(L3);
        L3.setLayout(L3Layout);
        L3Layout.setHorizontalGroup(
            L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL3))
                    .addGroup(L3Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL3))
                    .addGroup(L3Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(14, 14, 14)
                        .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL3)))
                    .addGroup(L3Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL3))
                    .addGroup(L3Layout.createSequentialGroup()
                        .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel36))
                            .addComponent(TituloL3)
                            .addGroup(L3Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L3Layout.setVerticalGroup(
            L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L3Layout.createSequentialGroup()
                .addComponent(TituloL3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(PrecoL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(EditoraL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(GeneroL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(AutorL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(QuantidadeL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL3)
                .addContainerGap())
        );

        jPanel1.add(L3, new java.awt.GridBagConstraints());

        L4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL4.setText("Titulo");

        CarrinhoL4.setText("Remover");
        CarrinhoL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL4ActionPerformed(evt);
            }
        });

        jLabel40.setText("Preço:");

        PrecoL4.setEditable(false);

        jLabel41.setText("Editora:");

        EditoraL4.setEditable(false);

        jLabel42.setText("Autor(a):");

        AutorL4.setEditable(false);

        jLabel43.setText("Gênero:");

        GeneroL4.setEditable(false);

        jLabel63.setText("Quantidade:");

        QuantidadeL4.setEnabled(false);

        javax.swing.GroupLayout L4Layout = new javax.swing.GroupLayout(L4);
        L4.setLayout(L4Layout);
        L4Layout.setHorizontalGroup(
            L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL4))
                    .addGroup(L4Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL4))
                    .addGroup(L4Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(14, 14, 14)
                        .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL4)))
                    .addGroup(L4Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL4))
                    .addGroup(L4Layout.createSequentialGroup()
                        .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel40))
                            .addComponent(TituloL4)
                            .addGroup(L4Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L4Layout.setVerticalGroup(
            L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L4Layout.createSequentialGroup()
                .addComponent(TituloL4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(PrecoL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(EditoraL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(GeneroL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(AutorL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(QuantidadeL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL4)
                .addContainerGap())
        );

        jPanel1.add(L4, new java.awt.GridBagConstraints());

        L5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL5.setText("Titulo");

        CarrinhoL5.setText("Remover");
        CarrinhoL5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL5ActionPerformed(evt);
            }
        });

        jLabel44.setText("Preço:");

        PrecoL5.setEditable(false);

        jLabel45.setText("Editora:");

        EditoraL5.setEditable(false);

        jLabel46.setText("Autor(a):");

        AutorL5.setEditable(false);

        jLabel47.setText("Gênero:");

        GeneroL5.setEditable(false);

        jLabel64.setText("Quantidade:");

        QuantidadeL5.setEnabled(false);

        javax.swing.GroupLayout L5Layout = new javax.swing.GroupLayout(L5);
        L5.setLayout(L5Layout);
        L5Layout.setHorizontalGroup(
            L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL5))
                    .addGroup(L5Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL5))
                    .addGroup(L5Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(14, 14, 14)
                        .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL5)))
                    .addGroup(L5Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL5))
                    .addGroup(L5Layout.createSequentialGroup()
                        .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel44))
                            .addComponent(TituloL5)
                            .addGroup(L5Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L5Layout.setVerticalGroup(
            L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L5Layout.createSequentialGroup()
                .addComponent(TituloL5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(PrecoL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(EditoraL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(GeneroL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(AutorL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(QuantidadeL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL5)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(L5, gridBagConstraints);

        L6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        L6.setEnabled(false);

        TituloL6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL6.setText("Titulo");

        CarrinhoL6.setText("Remover");
        CarrinhoL6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL6ActionPerformed(evt);
            }
        });

        jLabel48.setText("Preço:");

        PrecoL6.setEditable(false);

        jLabel49.setText("Editora:");

        EditoraL6.setEditable(false);

        jLabel50.setText("Autor(a):");

        AutorL6.setEditable(false);

        jLabel51.setText("Gênero:");

        GeneroL6.setEditable(false);

        jLabel65.setText("Quantidade:");

        QuantidadeL6.setEnabled(false);

        javax.swing.GroupLayout L6Layout = new javax.swing.GroupLayout(L6);
        L6.setLayout(L6Layout);
        L6Layout.setHorizontalGroup(
            L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL6))
                    .addGroup(L6Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL6))
                    .addGroup(L6Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(14, 14, 14)
                        .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL6)))
                    .addGroup(L6Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL6))
                    .addGroup(L6Layout.createSequentialGroup()
                        .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel48))
                            .addComponent(TituloL6)
                            .addGroup(L6Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L6Layout.setVerticalGroup(
            L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L6Layout.createSequentialGroup()
                .addComponent(TituloL6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(PrecoL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(EditoraL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(GeneroL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(AutorL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(QuantidadeL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL6)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(L6, gridBagConstraints);

        L7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL7.setText("Titulo");

        CarrinhoL7.setText("Remover");
        CarrinhoL7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL7ActionPerformed(evt);
            }
        });

        jLabel52.setText("Preço:");

        PrecoL7.setEditable(false);

        jLabel53.setText("Editora:");

        EditoraL7.setEditable(false);

        jLabel54.setText("Autor(a):");

        AutorL7.setEditable(false);

        jLabel55.setText("Gênero:");

        GeneroL7.setEditable(false);

        jLabel66.setText("Quantidade:");

        QuantidadeL7.setEnabled(false);

        javax.swing.GroupLayout L7Layout = new javax.swing.GroupLayout(L7);
        L7.setLayout(L7Layout);
        L7Layout.setHorizontalGroup(
            L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL7))
                    .addGroup(L7Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL7))
                    .addGroup(L7Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(14, 14, 14)
                        .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL7)))
                    .addGroup(L7Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL7))
                    .addGroup(L7Layout.createSequentialGroup()
                        .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel52))
                            .addComponent(TituloL7)
                            .addGroup(L7Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L7Layout.setVerticalGroup(
            L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L7Layout.createSequentialGroup()
                .addComponent(TituloL7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(PrecoL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(EditoraL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(GeneroL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(AutorL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(QuantidadeL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL7)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(L7, gridBagConstraints);

        L8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TituloL8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloL8.setText("Titulo");

        CarrinhoL8.setText("Remover");
        CarrinhoL8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoL8ActionPerformed(evt);
            }
        });

        jLabel56.setText("Preço:");

        PrecoL8.setEditable(false);

        jLabel57.setText("Editora:");

        EditoraL8.setEditable(false);

        jLabel58.setText("Autor(a):");

        AutorL8.setEditable(false);

        jLabel59.setText("Gênero:");

        GeneroL8.setEditable(false);

        jLabel67.setText("Quantidade:");

        QuantidadeL8.setEnabled(false);

        javax.swing.GroupLayout L8Layout = new javax.swing.GroupLayout(L8);
        L8.setLayout(L8Layout);
        L8Layout.setHorizontalGroup(
            L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CarrinhoL8))
                    .addGroup(L8Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(7, 7, 7)
                        .addComponent(AutorL8))
                    .addGroup(L8Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(14, 14, 14)
                        .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoL8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditoraL8)))
                    .addGroup(L8Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(14, 14, 14)
                        .addComponent(GeneroL8))
                    .addGroup(L8Layout.createSequentialGroup()
                        .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(L8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel56))
                            .addComponent(TituloL8)
                            .addGroup(L8Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuantidadeL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        L8Layout.setVerticalGroup(
            L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L8Layout.createSequentialGroup()
                .addComponent(TituloL8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(PrecoL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(EditoraL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(GeneroL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(AutorL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(QuantidadeL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrinhoL8)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel1.add(L8, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Valor total:");

        ValorTotal.setEditable(false);
        ValorTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        FinalizarCompra.setText("Finalizar compra");
        FinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(FinalizarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(FinalizarCompra))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose();
        Usuario usuario = new Usuario();
        usuario.setLocationRelativeTo(null);
        usuario.setIdUsuario(this.IdUsuario, Id);
        usuario.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CarrinhoL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL1ActionPerformed
        remCarrinho(TituloL1.getText());
    }//GEN-LAST:event_CarrinhoL1ActionPerformed

    private void CarrinhoL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL2ActionPerformed
        remCarrinho(TituloL2.getText());
    }//GEN-LAST:event_CarrinhoL2ActionPerformed

    private void CarrinhoL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL3ActionPerformed
        remCarrinho(TituloL3.getText());
    }//GEN-LAST:event_CarrinhoL3ActionPerformed

    private void CarrinhoL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL4ActionPerformed
        remCarrinho(TituloL4.getText());
    }//GEN-LAST:event_CarrinhoL4ActionPerformed

    private void CarrinhoL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL5ActionPerformed
        remCarrinho(TituloL5.getText());
    }//GEN-LAST:event_CarrinhoL5ActionPerformed

    private void CarrinhoL6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL6ActionPerformed
        remCarrinho(TituloL6.getText());
    }//GEN-LAST:event_CarrinhoL6ActionPerformed

    private void CarrinhoL7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL7ActionPerformed
        remCarrinho(TituloL7.getText());
    }//GEN-LAST:event_CarrinhoL7ActionPerformed

    private void CarrinhoL8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoL8ActionPerformed
        remCarrinho(TituloL8.getText());
    }//GEN-LAST:event_CarrinhoL8ActionPerformed

    private void FinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarCompraActionPerformed
        FinalizarCompra f = new FinalizarCompra();
        f.setIds(this.Id, this.IdUsuario);
        f.setValor(this.ValorTotal.getText());
        f.setLivros(LivrosNome);
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_FinalizarCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarrinhoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarrinhoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarrinhoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarrinhoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarrinhoTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AutorL1;
    private javax.swing.JTextField AutorL2;
    private javax.swing.JTextField AutorL3;
    private javax.swing.JTextField AutorL4;
    private javax.swing.JTextField AutorL5;
    private javax.swing.JTextField AutorL6;
    private javax.swing.JTextField AutorL7;
    private javax.swing.JTextField AutorL8;
    private javax.swing.JButton CarrinhoL1;
    private javax.swing.JButton CarrinhoL2;
    private javax.swing.JButton CarrinhoL3;
    private javax.swing.JButton CarrinhoL4;
    private javax.swing.JButton CarrinhoL5;
    private javax.swing.JButton CarrinhoL6;
    private javax.swing.JButton CarrinhoL7;
    private javax.swing.JButton CarrinhoL8;
    private javax.swing.JTextField EditoraL1;
    private javax.swing.JTextField EditoraL2;
    private javax.swing.JTextField EditoraL3;
    private javax.swing.JTextField EditoraL4;
    private javax.swing.JTextField EditoraL5;
    private javax.swing.JTextField EditoraL6;
    private javax.swing.JTextField EditoraL7;
    private javax.swing.JTextField EditoraL8;
    private javax.swing.JButton FinalizarCompra;
    private javax.swing.JTextField GeneroL1;
    private javax.swing.JTextField GeneroL2;
    private javax.swing.JTextField GeneroL3;
    private javax.swing.JTextField GeneroL4;
    private javax.swing.JTextField GeneroL5;
    private javax.swing.JTextField GeneroL6;
    private javax.swing.JTextField GeneroL7;
    private javax.swing.JTextField GeneroL8;
    private javax.swing.JPanel L1;
    private javax.swing.JPanel L2;
    private javax.swing.JPanel L3;
    private javax.swing.JPanel L4;
    private javax.swing.JPanel L5;
    private javax.swing.JPanel L6;
    private javax.swing.JPanel L7;
    private javax.swing.JPanel L8;
    private javax.swing.JTextField PrecoL1;
    private javax.swing.JTextField PrecoL2;
    private javax.swing.JTextField PrecoL3;
    private javax.swing.JTextField PrecoL4;
    private javax.swing.JTextField PrecoL5;
    private javax.swing.JTextField PrecoL6;
    private javax.swing.JTextField PrecoL7;
    private javax.swing.JTextField PrecoL8;
    private javax.swing.JSpinner QuantidadeL1;
    private javax.swing.JSpinner QuantidadeL2;
    private javax.swing.JSpinner QuantidadeL3;
    private javax.swing.JSpinner QuantidadeL4;
    private javax.swing.JSpinner QuantidadeL5;
    private javax.swing.JSpinner QuantidadeL6;
    private javax.swing.JSpinner QuantidadeL7;
    private javax.swing.JSpinner QuantidadeL8;
    private javax.swing.JLabel TituloL1;
    private javax.swing.JLabel TituloL2;
    private javax.swing.JLabel TituloL3;
    private javax.swing.JLabel TituloL4;
    private javax.swing.JLabel TituloL5;
    private javax.swing.JLabel TituloL6;
    private javax.swing.JLabel TituloL7;
    private javax.swing.JLabel TituloL8;
    private javax.swing.JTextField ValorTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
