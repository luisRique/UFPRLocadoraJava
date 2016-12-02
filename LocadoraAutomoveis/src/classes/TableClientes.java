/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luis
 */
public class TableClientes extends AbstractTableModel {

        private List<Cliente> lista;
        private String[] colunas = new String[]{"Id", "Nome", "Sobrenome", "CPF", "RG", "Endereço"};

        public TableClientes() {
                this.lista = new ArrayList();
        }

        public TableClientes(List<Cliente> lista) {
                this.lista = lista;
        }

        @Override
        public int getRowCount() {
                return lista.size();
        }

        @Override
        public int getColumnCount() {
                return this.colunas.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
                Cliente cliente = lista.get(rowIndex);

                switch (columnIndex) {
                        case 0:
                                return cliente.getIdcliente();
                        case 1:
                                return cliente.getNome();
                        case 2:
                                return cliente.getSobrenome();
                        case 3:
                                return cliente.getCpf();
                        case 4:
                                return cliente.getRg();
                        case 5:
                                return cliente.getEndereco();
                        default:
                                throw new IndexOutOfBoundsException("Column index out of bounds");
                }
        }

        @Override
        public String getColumnName(int columnIndex) {
                return colunas[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                        case 0:
                                return Integer.class;
                        default:
                                return String.class;
                }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Cliente cliente = lista.get(rowIndex);

                switch (columnIndex) {
                        case 0:
                                cliente.setIdcliente(Integer.parseInt(aValue.toString()));
                                break;
                        case 1:
                                cliente.setNome(aValue.toString());
                                break;
                        case 2:
                                cliente.setSobrenome(aValue.toString());
                                break;
                        case 3:
                                cliente.setCpf(aValue.toString());
                                break;
                        case 4:
                                cliente.setRg(aValue.toString());
                                break;
                        case 5:
                                cliente.setEndereco(aValue.toString());
                                break;
                        default:
                                throw new IndexOutOfBoundsException("Column index out of bounds");
                }
                fireTableCellUpdated(rowIndex, columnIndex);
        }

        public void setValueAt(Cliente cliente, int rowIndex) {
                Cliente c = lista.get(rowIndex);

                c.setIdcliente(cliente.getIdcliente());
                c.setNome(cliente.getNome());
                c.setSobrenome(cliente.getSobrenome());
                c.setCpf(cliente.getCpf());
                c.setRg(cliente.getRg());
                c.setEndereco(cliente.getEndereco());

                fireTableRowsUpdated(rowIndex, rowIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                        case 0:
                                return false;
                        default:
                                return true;
                }
        }

        public Cliente getCliente(int rowIndex) {
                return lista.get(rowIndex);
        }

        public void adicionaCliente(Cliente cliente) {
                lista.add(cliente);
                int lastIndex = getRowCount() - 1;
                fireTableRowsInserted(lastIndex, lastIndex);
                System.out.println("anything");
        }

        public void removeCliente(int rowIndex) {
                lista.remove(rowIndex);
                fireTableRowsDeleted(rowIndex, rowIndex);
        }

        public void addListaClientes(List<Cliente> listaClientes) {
                int oldSize = getRowCount();
                lista.addAll(listaClientes);
                fireTableRowsInserted(oldSize, getRowCount() - 1);
        }

        public void limpar() {
                lista.clear();
                fireTableDataChanged();
        }

        public boolean isEmpty() {
                return lista.isEmpty();
        }

        public String limpaCpf(String cpf) {
                String quebrado[] = cpf.split("\\.");
                String quebrado1[] = quebrado[2].split("\\-");
                String retorno = quebrado[0] + quebrado[1] + quebrado1[0] + quebrado1[1];

                return retorno;
        }
}
