/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trabalho_pos.tp.dao.ClienteDao;
import trabalho_pos.tp.dao.ItemDoPedidoDao;
import trabalho_pos.tp.dao.ProdutoDao;
import trabalho_pos.tp.domain.Cliente;
import trabalho_pos.tp.domain.ItemDoPedido;
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author Kissy de Melo
 */
public class TelaCadastroPedido extends javax.swing.JFrame {

    private ModeloTabelaProduto modeloTabelaProduto;
    private ModeloTabelaItemPedido modeloTabelaItemPedido;
    private int linhaClicada = -1;
    
    public TelaCadastroPedido() {
        modeloTabelaProduto = new ModeloTabelaProduto();
        modeloTabelaItemPedido = new ModeloTabelaItemPedido();
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.lightGray);
    } 
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        produtosDisponiveis = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        sair = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        btnListarProduto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        produtosSelecionados = new javax.swing.JTable();
        btnSalvarPeddo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIncluirProduto = new javax.swing.JButton();
        lblNomeCliente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        produtosDisponiveis.setModel(modeloTabelaProduto);
        jScrollPane1.setViewportView(produtosDisponiveis);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Cadastrar Pedido");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CPF");

        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpfKeyPressed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        btnListarProduto.setText("Listar Produtos");
        btnListarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProdutoActionPerformed(evt);
            }
        });

        produtosSelecionados.setModel(modeloTabelaItemPedido);
        jScrollPane2.setViewportView(produtosSelecionados);

        btnSalvarPeddo.setText("Salvar Pedido");
        btnSalvarPeddo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarPeddoMouseClicked(evt);
            }
        });
        btnSalvarPeddo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPeddoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Produtos Disponíveis");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Produtos Selecionados");

        btnIncluirProduto.setText("Incluir Produto");
        btnIncluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirProdutoActionPerformed(evt);
            }
        });

        lblNomeCliente.setText("nome do cliente");
        lblNomeCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sair");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIncluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnSalvarPeddo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(149, 620, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lblNomeCliente))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(btnListarProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sair)
                    .addComponent(voltar)
                    .addComponent(btnIncluirProduto)
                    .addComponent(btnSalvarPeddo))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarActionPerformed

    private void btnIncluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirProdutoActionPerformed
        int count = 0;
        int[] linhasSelecionadas = produtosDisponiveis.getSelectedRows();
        List<ItemDoPedido> itensPedidos = new ArrayList();
        List<ItemDoPedido> itensAdicionados = new ArrayList();
        //verfica quais itens estao selecionados na tabela produtosDisponiveis       
        for (int i = 0; i < linhasSelecionadas.length; i++) { 
                ItemDoPedido itemquanti = new ItemDoPedido();
                Integer quantidadeAdicionada = itemquanti.setQuantidade(quantidadeItem.getText());
                Produto produto = modeloTabelaProduto.getProduto(linhasSelecionadas[i]);
                ItemDoPedido itemva = new ItemDoPedido(produto, quantidadeAdicionada);
                itensPedidos.add(itemva);
            } 
         //adiciona na tabela itensSelecioandos
        for(ItemDoPedido itempedido:itensPedidos){              
//            if(!modeloTabelaItemPedido.getItemDoPedido(modeloTabelaItemPedido.getRowCount()).equals(itempedido.getProduto().getId())){
                
                modeloTabelaItemPedido.adicionaItemDoPedido(itempedido);
//            }else{
//                itempedido.somarItens(itempedido.getQuantidade(), 1);
//            }
        }
 
     
    }//GEN-LAST:event_btnIncluirProdutoActionPerformed

    private void btnListarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProdutoActionPerformed
          
        try{
            ProdutoDao dao = new ProdutoDao();
            List<Produto> list = dao.getLista();
            modeloTabelaProduto.setListaProduto(list);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnListarProdutoActionPerformed

    private void cpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            //JOptionPane.showMessageDialog(null, "Enter Pressionado");
            Cliente cliente = new Cliente();  
           
            try { 
                cliente.setCpf(cpf.getText());
                ClienteDao dao = new ClienteDao();
          
                cliente.setNome(dao.buscaClienteByCpf(cliente));
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            cliente.setNome(lblNomeCliente.getText()); 

            
        } // faz qualquer coisa que você quiser jButton1.doClick(); 
    }//GEN-LAST:event_cpfKeyPressed

    private void btnSalvarPeddoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPeddoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarPeddoActionPerformed

    private void btnSalvarPeddoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarPeddoMouseClicked
        JOptionPane.showMessageDialog(null, "Pedido Salvo com sucesso!"); //mensagem para depois de salvar o pedido
    }//GEN-LAST:event_btnSalvarPeddoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIncluirProduto;
    private javax.swing.JButton btnListarProduto;
    private javax.swing.JButton btnSalvarPeddo;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JTable produtosDisponiveis;
    private javax.swing.JTable produtosSelecionados;
    private javax.swing.JButton sair;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
