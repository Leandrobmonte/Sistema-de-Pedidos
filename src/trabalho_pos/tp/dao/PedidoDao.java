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
import trabalho_pos.tp.domain.Cliente;
import trabalho_pos.tp.domain.Pedido;

/**
 *
 * @author leand
 */
public class PedidoDao {
    
    private Connection connection;
    private PreparedStatement stmtAdiciona;
    
    public PedidoDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into pedido (data, id_cliente) values (?,?)", Statement.RETURN_GENERATED_KEYS);
    }
    
     public List<Pedido> getLista(Cliente cliente) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmtLista = this.connection.prepareStatement("select * from pedido where id_cliente = "+cliente.getId());
        try {
            rs = stmtLista.executeQuery();
            List<Pedido> pedido = new ArrayList();
            while (rs.next()) {
                // criando o objeto Pedido
                long id = rs.getLong("id_pedido");
                String data= rs.getString("data");
                //long id_cliente = rs.getLong("id_cliente");               
                // adicionando o objeto à lista
               // cliente.setId(id_cliente);
                pedido.add(new Pedido(id,data,cliente,null));
            }
            
            return pedido;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }
         
    }

    public void insert(Pedido pedido) {
        try {
            System.out.println("1");
            System.out.println("data"+pedido.getData());
            System.out.println("cliente"+pedido.getCliente().getId());
            stmtAdiciona.setString(1, pedido.getData());          
            stmtAdiciona.setLong(2, pedido.getCliente().getId());
              // executa
             System.out.println("2");

              stmtAdiciona.execute();
                         System.out.println("3");

            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
                         System.out.println("4");

            rs.next();
            long i = rs.getLong(1);
            pedido.setId(i);          
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }

   
    
}
