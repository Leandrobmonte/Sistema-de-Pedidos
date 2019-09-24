/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trabalho_pos.tp.domain.Cliente;

public class ClienteDao {
    
    private Connection connection;
    private PreparedStatement stmtAdiciona;

    public ClienteDao() throws SQLException {
        //this.connection = DriverManager.getConnection("jdbc:mysql://localhost/exercicio", "root", "");
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into cliente (cpf,nome,sobrenome) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
    }
    
    public List<Long> listarById(Cliente cliente) throws SQLException{
        List<Cliente> clientes = new ArrayList();
        clientes = this.getLista();
        List<Long> clientesIds = new ArrayList();
        for(Cliente cli : clientes){
            clientesIds.add(cli.getId());
        }        
        return clientesIds;
    }
     public List<Cliente> getLista() throws SQLException{
        ResultSet rs = null;
        PreparedStatement stmtLista = this.connection.prepareStatement("select * from cliente");
        try {
            rs = stmtLista.executeQuery();
                         

            List<Cliente> cliente = new ArrayList();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                long id = rs.getLong("id_cliente");
                String nome= rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                
                // adicionando o objeto à lista
                cliente.add(new Cliente(id,cpf,nome,sobrenome));
            }
            
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

    }
     
    public Cliente buscaClienteByCpf(Cliente cliente) throws SQLException{      
        List<Cliente> clientes = new ArrayList();
        clientes = this.getLista();
        
        for(Cliente cli : clientes){
            if(cliente.getCpf().equals(cli.getCpf())){
                cliente = cli;
            }
        }        
        return cliente;
    }
    
    public void insert(Cliente cliente){
        try {
            // prepared statement para inserção
            //PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmtAdiciona.setString(1, cliente.getCpf());
            stmtAdiciona.setString(2, cliente.getNome());
            stmtAdiciona.setString(3, cliente.getSobrenome());
          
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            cliente.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 

    }
    
    public void atualiza(Cliente cliente) throws SQLException{
           PreparedStatement stmtAtualiza = this.connection.prepareStatement("update cliente set cpf=?, nome=?, sobrenome=?  WHERE id_cliente=?;");
        try {
            stmtAtualiza.setString(1, cliente.getCpf());
            stmtAtualiza.setString(2, cliente.getNome());
            stmtAtualiza.setString(3, cliente.getSobrenome());
            stmtAtualiza.setLong(4, cliente.getId());
            stmtAtualiza.executeUpdate();
        } finally{
            stmtAtualiza.close();
        }     
    }  
    
    public void delete(Cliente cliente) throws SQLException{
        
        
        PreparedStatement stmtExcluir = this.connection.prepareStatement("delete from cliente WHERE id_cliente=?;");
        try {
            int idCliente;
            idCliente = (int) cliente.getId().longValue();
            stmtExcluir.setLong(1, idCliente);
            System.out.println(stmtExcluir.toString());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }
         
    }

}
