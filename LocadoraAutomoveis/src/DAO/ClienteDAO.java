/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bancoDeDados.ConnectionFactory;
import classes.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class ClienteDAO {

        private final String stmtInsereCliente = "insert into cliente(nome, sobrenome, rg, cpf, endereco) values(?, ?, ?, ?, ?)";
        private final String stmtAlteraCliente = "update cliente set nome = ?, sobrenome = ?, rg = ?, cpf = ?, endereco = ? where idcliente = ?;";
        private final String stmtExcluirCliente = "delete from cliente where idcliente = ?";
        private final String stmtSelecionaTodosClientes = "select idcliente, nome, sobrenome, rg, cpf, endereco from cliente;";

        public void adiciona(Cliente cliente) throws Exception {
                Connection con = null;
                PreparedStatement stmt = null;
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtInsereCliente);
                        stmt.setString(1, cliente.getNome());
                        stmt.setString(2, cliente.getSobrenome());
                        stmt.setString(3, cliente.getRg());
                        stmt.setString(4, cliente.getCpf());
                        stmt.setString(5, cliente.getEndereco());
                        stmt.executeUpdate();

                } catch (IOException | SQLException e) {
                        throw new Exception("Erro ao tentar inserir cadastro no banco de dados!");
                } finally {
                        try {
                                con.close();
                        } catch (SQLException e) {
                        }
                        try {
                                stmt.close();
                        } catch (SQLException e) {
                        }
                }

        }
        
        public void atualiza(Cliente cliente) throws Exception{
                Connection con = null;
                PreparedStatement stmt = null;
                try{
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtAlteraCliente);
                        stmt.setString(1, cliente.getNome());
                        stmt.setString(2, cliente.getSobrenome());
                        stmt.setString(3, cliente.getRg());
                        stmt.setString(4, cliente.getCpf());
                        stmt.setString(5, cliente.getEndereco());
                        stmt.setInt(6, cliente.getIdcliente());
                        stmt.executeUpdate();
                        
                }catch (IOException | SQLException e) {
                        throw new Exception("Erro ao acessar o banco de dados");
                } finally {
                        try {
                                con.close();
                        } catch (SQLException e) {
                        }
                        try {
                                stmt.close();
                        } catch (SQLException e) {
                        }
                }
        }
        
        public void excluir(Cliente cliente) throws Exception{
                Connection con = null;
                PreparedStatement stmt = null;
                try{
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtExcluirCliente);
                        stmt.setInt(1, cliente.getIdcliente());
                        stmt.executeUpdate();
                        
                }catch (IOException | SQLException e) {
                        throw new Exception("Erro ao tentar excluir o cliente");
                } finally {
                        try {
                                con.close();
                        } catch (SQLException e) {
                        }
                        try {
                                stmt.close();
                        } catch (SQLException e) {
                        }
                }
        }

        
        public List<Cliente> selecionaClientes() throws Exception{
                List<Cliente> listaClientes = new ArrayList();
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                try{
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtSelecionaTodosClientes);
                        rs = stmt.executeQuery();
                        while(rs.next()){
                                int id = rs.getInt("idcliente");
                                String nome = rs.getString("nome");
                                String sobrenome = rs.getString("sobrenome");
                                String rg = rs.getString("rg");
                                String cpf = rs.getString("cpf");
                                String endereco = rs.getString("endereco");
                                Cliente cliente = new Cliente(nome, sobrenome, rg, cpf, endereco);
                                cliente.setIdcliente(id);
                                listaClientes.add(cliente);
                        }
                }catch (IOException | SQLException e) {
                        throw new Exception("Erro ao acessar o banco de dados");
                } finally {
                        try {
                                con.close();
                        } catch (SQLException e) {
                        }
                        try {
                                stmt.close();
                        } catch (SQLException e) {
                        }
                        try {
                                rs.close();
                        } catch (SQLException e) {
                        }
                }
                return listaClientes;
        }
}
