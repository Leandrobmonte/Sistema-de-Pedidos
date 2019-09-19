/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tb.bussines;

import java.sql.Connection;
import java.sql.SQLException;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import trabalho_pos.tp.dao.ClienteDao;
import trabalho_pos.tp.dao.ConnectionFactory;
import trabalho_pos.tp.dao.PedidoDao;
import trabalho_pos.tp.domain.Cliente;
import trabalho_pos.tp.domain.Pedido;

/**
 *
 * @author leand
 */
public class ClienteBussines {
    
    Cliente cliente;
    Pedido pedido;
    ClienteDao clienteDao;
    PedidoDao pedidoDao;
    
    public void cadastrarCliente(Connection con, Cliente cliente){
        
//        try{
//                clienteDao.insert(con, cliente.getCpf() ,cliente.getNome(), cliente.getSobrenome());
//        }catch(SQLException ex){
//            printStackTrace("erro na função cadastrar Cliente");
//        }
    }
    
    
    
    
    
}
