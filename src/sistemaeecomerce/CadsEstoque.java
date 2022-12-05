/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemaeecomerce;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaeecomerce.Classes.Livro;
import sistemaeecomerce.Classes.MySQL;
import java.sql.ResultSet;
import sistemaeecomerce.Classes.Query;


/**
 *
 * @author User
 */
public class CadsEstoque extends javax.swing.JFrame {

       ResultSet rs = null;

    
    public CadsEstoque() {
        super("Cadastro de estoque");
        initComponents();
        Query qa = new Query();
        qa.Inseriricone(this);
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        
        Query query = new Query();
        
        ArrayList<String> generos1 = new ArrayList();
        
        generos1 = query.MostrarGeneros();
        
        for (int i = 0; i < generos1.size(); i++) {
            gen.addItem(generos1.get(i));
        }
        
        ArrayList<String> autores1 = new ArrayList();
        
        autores1 = query.MostrarAutores();
        
        for (int i = 0; i < autores1.size(); i++) {
            Aut.addItem(autores1.get(i));
        }
        
        ArrayList<String> editoras1 = new ArrayList();
        
        editoras1 = query.MostrarEditoras();
        
        for (int i = 0; i < editoras1.size(); i++) {
            Edi.addItem(editoras1.get(i));
        }
        
        Livro l = new Livro();

        ArrayList<ArrayList<String>> arr = l.mostrarLivros();

        for (int i = 0; i < arr.size(); i++) {
            String ids = arr.get(i).get(0);
            String nomes = arr.get(i).get(1);
            String precos = arr.get(i).get(2);
            String unidades = arr.get(i).get(3);
            String editoras = arr.get(i).get(4);
            String autores = arr.get(i).get(5);
            String genero = arr.get(i).get(6);

            DefaultTableModel val = (DefaultTableModel) Tabela.getModel();
            val.addRow(new String[]{ids, nomes, precos, unidades, editoras, autores, genero});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        Preco = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        Uni = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        gen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Aut = new javax.swing.JComboBox<>();
        Edi = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomeKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(nome);

        Preco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PrecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PrecoFocusLost(evt);
            }
        });
        Preco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrecoKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(Preco);

        jScrollPane5.setViewportView(Uni);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel1.setText("Cadastrar Livros");

        jLabel3.setText("Livro");

        jLabel4.setText("Preço");

        jLabel5.setText("Unidade");

        jLabel6.setText("Editora");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", " Livro", "Preço", "Unidade", "Editora", "Autor(a)", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Tabela);

        jLabel7.setText("Autor(a)");

        gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genActionPerformed(evt);
            }
        });

        jLabel2.setText("Genero");

        Aut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutMouseClicked(evt);
            }
        });

        Edi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EdiMouseClicked(evt);
            }
        });
        Edi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdiActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        voltar.setText("voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(gen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Aut, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Edi, 0, 180, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(voltar)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gen, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voltar)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       if(Preco.getText().length() > 0) {
            String formatted = Preco.getText();

            String partOne = formatted.substring(2, formatted.length() - 3);
            String partTwo = formatted.substring(formatted.length() - 2, formatted.length());
            String combined = partOne + "." + partTwo;
            
            while(combined.length() != 0 && combined.charAt(0) == '0') {
                combined = combined.replaceFirst("0", "");
            }
            
            Preco.setText(combined);
            
        }
        
       String nomes = nome.getText().trim();
       String precos = Preco.getText().trim();
       String unidades = Uni.getText().trim();
       String editoras = Edi.getSelectedItem().toString();
       String autores = Aut.getSelectedItem().toString();
       String genero = gen.getSelectedItem().toString();
       
       try {
            Double.parseDouble(Preco.getText());
            Livro l = new Livro(nomes, Double.parseDouble(precos), Integer.parseInt(unidades), editoras, autores, genero);
       
            l.Inserir();

            String IDs = l.getId();

            DefaultTableModel val = (DefaultTableModel) Tabela.getModel();
            val.addRow(new String[]{IDs, nomes, precos, unidades, editoras, autores, genero});

            nome.setText("");
            Preco.setText("");
            Uni.setText("");
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O preço deve ser um número!");
       }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void PrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecoKeyTyped
       try {
            Double.parseDouble(Character.toString(evt.getKeyChar()));
        } catch (Exception e) {
            evt.setKeyChar('\b');
        }
    }//GEN-LAST:event_PrecoKeyTyped

    private void PrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PrecoFocusGained
        if(Preco.getText().length() > 0) {
            String formatted = Preco.getText();

            String partOne = formatted.substring(2, formatted.length() - 3);
            String partTwo = formatted.substring(formatted.length() - 2, formatted.length());
            String combined = partOne + partTwo;
            
            while(combined.length() != 0 && combined.charAt(0) == '0') {
                combined = combined.replaceFirst("0", "");
            }
            
            Preco.setText(combined);
            
        }
    }//GEN-LAST:event_PrecoFocusGained

    private void PrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PrecoFocusLost
        String plainText = Preco.getText();
        String formatted = "";
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
                String partOne = plainText.substring(0, plainText.length() - 2);
                String partTwo = plainText.substring(plainText.length() - 2, plainText.length());
                int k = 0;
                boolean doSubtring = false;
                for (int i = 0; i < partOne.length(); i++) {
                    
                    if(Character.toString(partOne.charAt(i)).equals("0")) {
                        doSubtring = true;
                        k++;
                    } else {
                        if(doSubtring) {
                            partOne = partOne.substring(k);
                        }
                        break;
                    }
                    
                    if(i == partOne.length() - 1) {
                        if(doSubtring) {
                            partOne = partOne.substring(k - 1);
                        }
                        break;
                    }
                    
                }
                
                formatted = "R$" + partOne + "," + partTwo;
                break;
        }
        
        Preco.setText(formatted);
    }//GEN-LAST:event_PrecoFocusLost

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
        this.setVisible(false);
        AltEstoque alte = new AltEstoque();
        alte.setVisible(true);        
        alte.setSelectedBookId(String.valueOf(Tabela.getValueAt(Tabela.getSelectedRow(), 0)));
    }//GEN-LAST:event_TabelaMouseClicked

    private void genActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genActionPerformed

    private void EdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EdiActionPerformed

    private void nomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyTyped
        if(nome.getText().length() >= 65) {
            evt.setKeyChar('\b');
        }
    }//GEN-LAST:event_nomeKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CadsAutor CadsAutor = new CadsAutor();
        CadsAutor.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutMouseClicked
        ArrayList<String> autores = new ArrayList();
        
        Query query = new Query();
        
        autores = query.MostrarAutores();
        Aut.removeAllItems();
        for (int i = 0; i < autores.size(); i++) {
            Aut.addItem(autores.get(i));
        }
    }//GEN-LAST:event_AutMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CadsEditora CadsEditora = new CadsEditora();
        CadsEditora.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EdiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EdiMouseClicked
        ArrayList<String> editoras = new ArrayList();
        
        Query query = new Query();
        
        editoras = query.MostrarEditoras();
        Edi.removeAllItems();
        for (int i = 0; i < editoras.size(); i++) {
            Edi.addItem(editoras.get(i));
        }
    }//GEN-LAST:event_EdiMouseClicked

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        setVisible(false);
        dispose();
        AdminTela adm = new AdminTela();
        adm.setVisible(true);
    }//GEN-LAST:event_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(CadsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadsEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Aut;
    private javax.swing.JComboBox<String> Edi;
    private javax.swing.JTextPane Preco;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextPane Uni;
    private javax.swing.JComboBox<String> gen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane nome;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
