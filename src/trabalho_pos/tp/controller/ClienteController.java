/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho_pos.tp.bussines.ValidaCPF;
import trabalho_pos.tp.dao.ClienteDao;
import trabalho_pos.tp.dao.PedidoDao;
import trabalho_pos.tp.domain.Cliente;
import trabalho_pos.tp.domain.Pedido;

/**
 *
 * @author leand
 */
public class ClienteController {
        
    ValidaCPF validaCPF = new ValidaCPF();
    public ClienteController() {
    }  

    
    public boolean verificaCpf(Cliente cliente){
        boolean verificaCpf = true;
        if (!validaCPF.isCPF(cliente.getCpf()) == true){
            verificaCpf = false;
        }
        return verificaCpf;
    }
    
    public Boolean validaNome(Cliente cliente){
       boolean verificanome = false;
       if(cliente.getNome().equals("")){
           verificanome = true;
       }
       return verificanome;
    };
    
    public boolean adicionarCliente(Cliente cliente) throws SQLException{
        boolean verificaCpf = false;
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientesCadastrados = clienteDao.getLista();
        for(Cliente clienteCpf :  clientesCadastrados){
            if(cliente.getCpf().equals(clienteCpf.getCpf()) ){
                verificaCpf = true;
            }
        }
        if(verificaCpf == false){
            clienteDao.insert(cliente);
        }        
        return verificaCpf;        
    }
    
    public List<Cliente> listaClientes() throws SQLException{
          ClienteDao dao = new ClienteDao();
          List<Cliente> lista = dao.getLista();
          return lista;
    }
    public void alterarCliente(Cliente cliente) throws SQLException{
        ClienteDao dao = new ClienteDao();
        dao.atualiza(cliente);
    }
    
    public boolean excluirCliente(Cliente cliente) throws SQLException{
        ClienteDao dao = new ClienteDao();
        boolean verficaPedido = true;
        PedidoDao daoPedido = new PedidoDao();
        List<Pedido> pedido = new ArrayList();
        pedido = daoPedido.getLista(cliente);
        if (!pedido.isEmpty()){
            verficaPedido = false;
        }else{
           dao.delete(cliente); 
        }
        
        return verficaPedido;
        
        
    }
    
    
}
