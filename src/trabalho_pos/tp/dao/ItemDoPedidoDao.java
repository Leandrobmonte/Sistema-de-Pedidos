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
    
}
