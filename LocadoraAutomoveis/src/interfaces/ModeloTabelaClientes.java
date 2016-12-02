/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author caiiqueam
 */
class ModeloTabelaClientes extends AbstractTableModel{
    private String[] colunas=new String[]{"Nome", "sobre nome", "RG", "CPF","Endereço"};

    private List<Cliente> lista=new ArrayList();

    
    public ModeloTabelaClientes(List<Cliente> lista){
        this.lista=lista;
    }

    public ModeloTabelaClientes(){
    }
    

    void adicionaCliente(Cliente cliente) {
        this.lista.add(cliente);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    Cliente getCliente(int linhaClicada) {
         return lista.get(linhaClicada);
    }

    public boolean removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void setListaClientes(List<Cliente> clientes){
        this.lista = clientes;
        this.fireTableDataChanged();
        
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
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();//if column 0 (id)
            case 1: return cliente.getSobrenome();//if column 1 (nome)
            case 2: return cliente.getRg();
            case 3: return cliente.getCpf();
            case 4: return cliente.getEndereco();
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente cliente = lista.get(row);
        switch (col) {
            case 0:
               cliente.setNome((String) value); //if column 0 (id)
                break;
            case 1:
                cliente.setSobrenome((String) value);
                break;
            case 2:
                cliente.setRg((String) value);
                break;
            case 3:
                cliente.setCpf((String) value);
                break;
            case 4:
                cliente.setEndereco((String) value);
                break;    
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeSistema(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaSistema(Cliente cliente) {
        this.lista.add(cliente);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaSistemas(List<Cliente> clientes) {
        this.lista = clientes;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Cliente getSistema(int linha){
        return lista.get(linha);
    }
    
    public List<Cliente> getLista(int[] indices){
        List<Cliente> lista = new ArrayList();
        for(int i=0; i<indices.length;i++){
            lista.add(this.lista.get(indices[i]));
        }
        return lista;
    }
    
}
