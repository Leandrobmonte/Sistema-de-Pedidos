/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trabalho_pos.tp.dao.ClienteDao;
import trabalho_pos.tp.dao.ItemDoPedidoDao;
import trabalho_pos.tp.dao.PedidoDao;
import trabalho_pos.tp.dao.ProdutoDao;
import trabalho_pos.tp.domain.Cliente;
import trabalho_pos.tp.domain.ItemDoPedido;
import trabalho_pos.tp.domain.Pedido;
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author leand
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
          this.getContentPane().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        lblNomeCliente = new javax.swing.JLabel();
        btnListarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        produtosDisponiveis = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensAdicionados = new javax.swing.JTable();
        btnIncluirItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        quantidadeItem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvarPedido = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho_pos/tp/imagens/TituloFinal-1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CPF");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Novo Pedido");

        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpfKeyPressed(evt);
            }
        });

        lblNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNomeCliente.setText("Cliente:");

        btnListarProduto.setText("Listar Produtos");
        btnListarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProdutoActionPerformed(evt);
            }
        });

        produtosDisponiveis.setModel(modeloTabelaProduto);
        jScrollPane1.setViewportView(produtosDisponiveis);

        tblItensAdicionados.setModel(modeloTabelaItemPedido);
        jScrollPane2.setViewportView(tblItensAdicionados);

        btnIncluirItem.setText("Incluir");
        btnIncluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setText("Excluir");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        quantidadeItem.setText("1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Quantidade");

        btnSalvarPedido.setText("Salvar");
        btnSalvarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPedidoActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Produto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Pedidos Realizados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

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
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(lblNomeCliente))
                            .addComponent(btnListarProduto))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnIncluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(quantidadeItem))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCliente))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnListarProduto)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(quantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIncluirItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarPedido)
                    .addComponent(btnVoltar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPedidoActionPerformed
       Produto poduto = new Produto();
       Cliente cliente = new Cliente();
       List<ItemDoPedido> itensdoPedido = new ArrayList();
       for (int i = 0; i < modeloTabelaItemPedido.getRowCount(); i++) {
            itensdoPedido.add(modeloTabelaItemPedido.getItemDoPedido(i));
        }
       
       try {
            ItemDoPedidoDao daoItem = new ItemDoPedidoDao();          
            PedidoDao daoPedido = new PedidoDao();
            ClienteDao dao = new ClienteDao();
            
            cliente.setCpf(cpf.getText());
            cliente = dao.buscaClienteByCpf(cliente);
            System.out.println("cliente cpf"+cliente.getCpf());
            System.out.println("cliente nome"+cliente.getNome());
            System.out.println("cliente sobrenome"+cliente.getSobrenome());
            System.out.println("cliente id"+cliente.getId());

            System.out.println("cliente CAMPO:"+ cpf.getText());
            //LocalDateTime formatodata = LocalDateTime.now();            
            LocalDate formatodata = LocalDate.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
            String data = formatodata.format(formatter);
            System.out.println("DATA: "+ data);
            
            Pedido pedido = new Pedido(null, data, cliente,itensdoPedido);
            System.out.println("criando pedido");
            daoPedido.insert(pedido);
            System.out.println("pedido salvo");
            
            
            for(ItemDoPedido itempedido : itensdoPedido){                
                daoItem.insert(pedido);
            }
        
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao realizar inclusão de cliente.", "Erro", JOptionPane.ERROR_MESSAGE);

       }
 
    }//GEN-LAST:event_btnSalvarPedidoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaCadastroCliente tela = new TelaCadastroCliente();
       tela.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaCadastroProduto tela = new TelaCadastroProduto();
       tela.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaListaPedido tela = new TelaListaPedido();
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicial tela = new TelaInicial();
       tela.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnListarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProdutoActionPerformed
        try{
            if(modeloTabelaItemPedido.getRowCount() == 0){
                ProdutoDao dao = new ProdutoDao();
                List<Produto> list = dao.getLista();
                modeloTabelaProduto.setListaProduto(list);
            }else{
                JOptionPane.showMessageDialog(null,"Lista de produtos atualizada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);

        }  
        
    }//GEN-LAST:event_btnListarProdutoActionPerformed

    private void btnIncluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirItemActionPerformed
        
        int[] linhasSelecionadas = produtosDisponiveis.getSelectedRows();
        List<ItemDoPedido> itensPedidos = new ArrayList();
        List<ItemDoPedido> itensAdicionados = new ArrayList();
        List<Produto> itensDisponiveis = new ArrayList();  
        
        for (int i = 0; i < linhasSelecionadas.length; i++) { 
            String quant = quantidadeItem.getText(); 
            Integer quantidade = Integer.parseInt(quant); 
            Produto produto = modeloTabelaProduto.getProduto(linhasSelecionadas[i]);
            ItemDoPedido itemAdd = new ItemDoPedido(produto, quantidade);
            itensPedidos.add(itemAdd);
        }
        for(ItemDoPedido itensProduto:itensPedidos){
          modeloTabelaItemPedido.adicionaItemDoPedido(itensProduto);
        }
        
        //for para pegar objetos da tabela ItensSelecionados
        for (int i = 0; i < modeloTabelaItemPedido.getRowCount(); i++) {
            itensAdicionados.add(modeloTabelaItemPedido.getItemDoPedido(i));
        } 
        
        for (int i = 0; i < modeloTabelaProduto.getRowCount(); i++){
            itensDisponiveis.add(modeloTabelaProduto.getProduto(i));
        }
        
        for (Produto p:itensDisponiveis){
            for (ItemDoPedido ip:itensAdicionados){
                if (p.getId() == ip.getProduto().getId()){
                    modeloTabelaProduto.removeProduto(p);
                } 
            }
        }
     
        ////////////////////////////////////////////////
        
               
        
        
        
     
//
//           for(ItemDoPedido itempedido : itensPedidos){
//            for (ItemDoPedido it : itensAdicionados){
//               if(itempedido.getProduto().getId() == it.getProduto().getId()){
//                   itempedido.setQuantidade(itempedido.somarItens(itempedido.getQuantidade(), it.getQuantidade()));                   
//                }
//            }
//        }   
                
    }//GEN-LAST:event_btnIncluirItemActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
                
    }//GEN-LAST:event_cpfActionPerformed

    private void cpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            //JOptionPane.showMessageDialog(null, "Enter Pressionado");
            Cliente cliente = new Cliente();  
           
            try { 
                cliente.setCpf(cpf.getText());
                ClienteDao dao = new ClienteDao();
                cliente = dao.buscaClienteByCpf(cliente);
                lblNomeCliente.setText("Cliente: "+cliente.getNome()+" "+cliente.getSobrenome()); 
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } // faz qualquer coisa que você quiser jButton1.doClick(); 
    }//GEN-LAST:event_cpfKeyPressed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        int[] linhasSelecionadas = tblItensAdicionados.getSelectedRows();
        List<ItemDoPedido> itensPedidos = new ArrayList();
        List<Produto> itensDisponiveis = new ArrayList();
        List<Produto> produtosDisponiveis = new ArrayList(); 
               
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            
            ItemDoPedido itemPedido = modeloTabelaItemPedido.getItemDoPedido(linhasSelecionadas[i]);
            itensPedidos.add(itemPedido);
        }
        for(ItemDoPedido itensRemovidos:itensPedidos){
            itensDisponiveis.add(itensRemovidos.getProduto());
            modeloTabelaItemPedido.removeItemDoPedido(itensRemovidos);
            
        }
        
        //for para pegar objetos da tabela ItensSelecionados
        for (int i = 0; i < modeloTabelaProduto.getRowCount(); i++) {
            produtosDisponiveis.add(modeloTabelaProduto.getProduto(i));
        } 
  
        if (!produtosDisponiveis.contains(itensDisponiveis)){
            for (int i = 0; i < itensDisponiveis.size(); i++) {
                 modeloTabelaProduto.adicionaProduto(itensDisponiveis.get(i));
            }
        }
//        for (Produto p:itensDisponiveis){
//            for (Produto pr:produtosDisponiveis){
//                if (p.getId() != pr.getId()){
//                    modeloTabelaProduto.adicionaProduto(p);
//                } 
//            }
//        }
//        
        
        
        
    }//GEN-LAST:event_btnExcluirItemActionPerformed

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
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnIncluirItem;
    private javax.swing.JButton btnListarProduto;
    private javax.swing.JButton btnSalvarPedido;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JTable produtosDisponiveis;
    private javax.swing.JTextField quantidadeItem;
    private javax.swing.JTable tblItensAdicionados;
    // End of variables declaration//GEN-END:variables
}
