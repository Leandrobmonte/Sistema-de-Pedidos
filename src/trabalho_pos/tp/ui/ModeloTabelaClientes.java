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

/**
 *
 * @author Leandro
 */
public class ModeloTabelaClientes extends AbstractTableModel{
    private String[] colunas = new String[]{"id","cpf","nome","sobrenome"};

    private List<Cliente> lista = new ArrayList();

    
    public ModeloTabelaClientes(List<Cliente> lista){
        this.lista=lista;
    }

    public ModeloTabelaClientes(){
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
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();//if column 0 (code)
            case 1: return customer.getCpf();//if column 1 (cpf)
            case 2: return customer.getNome();//if column 2 (name)
            case 3: return customer.getSobrenome();//if column 3 (sobrenome)
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente customer = lista.get(row);
        switch (col) {
            case 0:
                customer.setId((Long) value); //if column 0 (code)
                break;
            case 1:
                 customer.setCpf((String) value);
                break;
            case 2:
                 customer.setNome((String) value);
                break;
            case 3:
                customer.setSobrenome((String) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeCliente(Cliente customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaCliente(Cliente customer) {
        this.lista.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaCliente(List<Cliente> cliente) {
        this.lista = cliente;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Cliente getCliente(int linha){
        return lista.get(linha);
    }
    
}