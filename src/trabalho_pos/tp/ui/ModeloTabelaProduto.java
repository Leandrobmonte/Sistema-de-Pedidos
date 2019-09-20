/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author leand
 */
class ModeloTabelaProduto extends AbstractTableModel{
    
     private String[] colunas = new String[]{"id","descricao"};

    private List<Produto> lista = new ArrayList();

    
    public ModeloTabelaProduto(List<Produto> lista){
        this.lista=lista;
    }

    public ModeloTabelaProduto(){
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
        Produto customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();//if column 0 (code)
            case 1: return customer.getDescricao();//if column 1 (cpf)
           
            default : return null;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        Produto customer = lista.get(row);
        switch (col) {
            case 0:
                customer.setId((Long) value); //if column 0 (code)
                break;
            case 1:
                 customer.setDescricao((String) value);
                break;

            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeProduto(Produto produto) {
        int linha = this.lista.indexOf(produto);
        boolean result = this.lista.remove(produto);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaProduto(Produto produto) {
        this.lista.add(produto);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaProduto(List<Produto> produto) {
        this.lista = produto;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Produto getProduto(int linha){
        return lista.get(linha);
    }
    
}
