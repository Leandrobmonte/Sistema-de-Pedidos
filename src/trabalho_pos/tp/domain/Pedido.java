/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private Long id;
    private String data; 
    Cliente cliente =  new Cliente();
    List<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
    
    public Pedido(){}
    
    public Pedido(Long id, String data, Cliente cliente, List<ItemDoPedido> itens) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
    } 

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
    }    
    
    
    
    
}
