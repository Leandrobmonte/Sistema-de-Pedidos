/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trabalho_pos.tp.domain.ItemDoPedido;
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author leand
 */
class ModeloTabelaItemPedido extends AbstractTableModel{
    
     private String[] colunas = new String[]{"Produto","Quantidade"};

    private List<ItemDoPedido> lista = new ArrayList();
    private List<Produto> listaProduto = new ArrayList();

    
    public ModeloTabelaItemPedido(List<ItemDoPedido> listaDeItens){
        this.lista=listaDeItens;
    }

    public ModeloTabelaItemPedido(){
    }


    public int getRowCount() {
        return this.lista.size();
    }

    public int getColumnCount() {
        return this.colunas.length;
    }

    public String getColumnName(int index) {
        return this.colunas[index];
    }

    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //    return false;
        //return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemDoPedido itensDoPedido = lista.get(rowIndex);
        switch (columnIndex) {
   
            case 0: return itensDoPedido.getProduto().getDescricao();
            case 1: return itensDoPedido.getQuantidade();//
            default : return null;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        ItemDoPedido itemPedido = lista.get(row);
        switch (col) {
            case 0:
                itemPedido.getProduto().setDescricao((String) value); //if column 0 (code)
                break;
            case 1:
                 itemPedido.setQuantidade((int) value);
                break;

            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeItemDoPedido(ItemDoPedido item) {
        int linha = this.lista.indexOf(item);
        boolean result = this.lista.remove(item);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaItemDoPedido(ItemDoPedido item) {
        this.lista.add(item);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }    
   
    public void setListaItemDoPedido(List<ItemDoPedido> item) {

        this.lista =  item;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public ItemDoPedido getItemDoPedido(int linha){
        return lista.get(linha);
    }

   
}
