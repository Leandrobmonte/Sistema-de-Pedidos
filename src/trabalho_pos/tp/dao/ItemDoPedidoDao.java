/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalho_pos.tp.domain.ItemDoPedido;
import trabalho_pos.tp.domain.Pedido;
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author leand
 */
public class ItemDoPedidoDao {
    
     private Connection connection;
    private PreparedStatement stmtAdiciona;
    
    public ItemDoPedidoDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into item_do_pedido (id_pedido,id_produto, qtdade) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
    }
    
    public List<ItemDoPedido> getListItensByPedido(Pedido pedido) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmtLista = this.connection.prepareStatement("select * from item_do_pedido where id_pedido = "+pedido.getId());
        System.out.println("chega aqui");
        
        try {
            rs = stmtLista.executeQuery();

            ProdutoDao daoProduto = new ProdutoDao();
            Produto produto = new Produto();
            List<ItemDoPedido> itensDoPedido = new ArrayList();
            //List<>
            while (rs.next()) {
                // criando o objeto Pedido
                Integer id = rs.getInt("id_produto");
                Integer qtdade= rs.getInt("qtdade");
                
                produto = daoProduto.getProdutobyId(id);
                System.out.println("retorna aqui");
                itensDoPedido.add(new ItemDoPedido(produto,qtdade));
            }
            
            return itensDoPedido;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }
    }
    
    public void insert(Pedido pedido) {        
        try {
            for(ItemDoPedido itensDoPedido : pedido.getItens()){
              stmtAdiciona.setLong(1, pedido.getId());
              stmtAdiciona.setLong(2, itensDoPedido.getProduto().getId());
              stmtAdiciona.setLong(3, itensDoPedido.getQuantidade());
              // executa
              stmtAdiciona.execute();
            }
            
         } catch (SQLException ex) {
            throw new RuntimeException(ex);
         }
        
    }

    public void delete(ItemDoPedido itemDoPedido, Pedido pedido) throws SQLException {
        PreparedStatement stmtExcluir = this.connection.prepareStatement("delete from item_do_pedido WHERE id_produto=? and id_pedido=?;");
        try {
            stmtExcluir.setLong(1, itemDoPedido.getProduto().getId());
            stmtExcluir.setLong(2, pedido.getId());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }
    }
    
}
