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
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author leand
 */
public class ProdutoDao {
    
     private Connection connection;
    private PreparedStatement stmtAdiciona;
    public ProdutoDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into produto (descricao) values (?)", Statement.RETURN_GENERATED_KEYS);
    
        
    }
    
      public List<Produto> getLista() throws SQLException{
        ResultSet rs = null;
        PreparedStatement stmtLista = this.connection.prepareStatement("select * from produto");
        try {
            rs = stmtLista.executeQuery();
            List<Produto> produto = new ArrayList();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                Long id = rs.getLong("id_produto");
                String descricao= rs.getString("descricao");
   
                
                // adicionando o objeto à lista
                produto.add(new Produto(id,descricao));
            }
            
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

    }
    
    
    public void insert(Produto produto) {
           try {
            // prepared statement para inserção
            //PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmtAdiciona.setString(1, produto.getDescricao());
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            Long i = rs.getLong(1);
            produto.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
        
    }
    
     public void atualiza(Produto produto) throws SQLException{
           PreparedStatement stmtAtualiza = this.connection.prepareStatement("update produto set descricao=?  WHERE id_produto=?;");
        try {
            stmtAtualiza.setString(1, produto.getDescricao());
            stmtAtualiza.setLong(2, produto.getId());
            stmtAtualiza.executeUpdate();
        } finally{
            stmtAtualiza.close();
        }     
    }  
    
    public void delete(Produto produto) throws SQLException{
        
        PreparedStatement stmtExcluir = this.connection.prepareStatement("delete from produto WHERE id_produto=?;");
        try {
            stmtExcluir.setLong(1, produto.getId());
            System.out.println(stmtExcluir.toString());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }
         
    }
    
    
    
}
