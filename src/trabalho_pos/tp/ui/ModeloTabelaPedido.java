/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trabalho_pos.tp.domain.Cliente;
import trabalho_pos.tp.domain.Pedido;

/**
 *
 * @author leand
 */
class ModeloTabelaPedido extends AbstractTableModel{
     private String[] colunas = new String[]{"id","Data","Cliente_id"};

    private List<Pedido> lista = new ArrayList();

    
    public ModeloTabelaPedido(List<Pedido> lista){
        this.lista=lista;
    }

    public ModeloTabelaPedido(){
    }


    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //    return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return pedido.getId();//if column 0 (code)
            case 1: return pedido.getData();//if column 1 (cpf)
            case 2: return pedido.getCliente().getId();//if column 2 (name)
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Pedido pedido = lista.get(row);
        switch (col) {
            case 0:
                pedido.setId((Long) value); //if column 0 (code)
                break;
            case 1:
                 pedido.setData((String) value);
                break;
            case 2:
                 pedido.getCliente().setId((Long) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removePedido(Pedido pedido) {
        int linha = this.lista.indexOf(pedido);
        boolean result = this.lista.remove(pedido);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaPedido(Pedido pedido) {
        this.lista.add(pedido);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaPedido(List<Pedido> pedido) {
        this.lista = pedido;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Pedido getPedido(int linha){
        return lista.get(linha);
    }
    
}
