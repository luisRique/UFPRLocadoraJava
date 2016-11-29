/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bancoDeDados.ConnectionFactory;
import classes.Automovel;
import classes.Motocicleta;
import classes.Van;
import classes.Veiculo;
import enums.Categoria;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class VeiculoDAO {

        private final String stmtInsert = "insert into veiculo(valordecompra, placa, ano, idmodelo, idmarca, idestado, idcategoria) values(?, ?,  ?,  ?, ?, ?, ?)";
        private final String stmtQuery = "update veiculo set valordecompra = ?, placa = ?, ano = ?, idmodelo = ?, idmarca = ?, idestado = ?,"
                + " idcategoria = ? where id = ? ";
        private final String stmtBuscaPorNome1 = "select id";
        private final String stmtBuscaPorNome2 = " from ";
        private final String stmtBuscaPorNome3 = " where nome like ? ";

        public void criaVeiculo(Veiculo veiculo) throws IOException {
                Connection con = null;
                PreparedStatement stmt = null;
                int modelo;
                if(veiculo instanceof Automovel){
                        Automovel auto = (Automovel)veiculo;
                        modelo = this.BuscaIdPorNomeEnum(auto.getModeloAutomovel());
                }else if(veiculo instanceof Motocicleta){
                        Motocicleta moto = (Motocicleta)veiculo;
                        modelo = this.BuscaIdPorNomeEnum(moto.getModeloMotocicleta());
                }else{
                        Van van = (Van)veiculo;
                        modelo = this.BuscaIdPorNomeEnum(van.getModeloVan());
                }
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtInsert);
                        stmt.setDouble(1, veiculo.getValorParaVenda());
                        stmt.setString(2, veiculo.getPlaca());
                        stmt.setInt(3, veiculo.getAno());
                        stmt.setInt(4, modelo);
                        stmt.setInt(6,  this.BuscaIdPorNomeEnum(veiculo.getMarca()));
                        stmt.setInt(5, this.BuscaIdPorNomeEnum(veiculo.getEstado()));
                        stmt.setInt(7,  this.BuscaIdPorNomeEnum(veiculo.getCategoria()));
                        
                        stmt.executeUpdate();
                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao tentar inserir cadastro no banco de dados!" +  e.getMessage());
                }finally{
                        try{
                                con.close();
                        }catch(SQLException e){
                                
                        }
                        try{
                                stmt.close();
                        }catch(SQLException e){
                                
                        }
                }

        }
        
        public int BuscaIdPorNomeEnum(Enum nome){
                int retorno = 0;
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                String quebrado[] = nome.getClass().toString().split("\\.");
                String quebrado1[] = quebrado[1].split("@");
                String table[] = quebrado1[0].split("[A-Z]");
                String campo = quebrado[1].substring(0, 1).toLowerCase() +  table[1].toLowerCase();
                String stmtdefinitivo = this.stmtBuscaPorNome1 +  campo +this.stmtBuscaPorNome2 +  campo + this.stmtBuscaPorNome3;
                try{
                        con  = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(stmtdefinitivo);
                        stmt.setString(1,nome.name().toUpperCase());
                         rs = stmt.executeQuery();
                        while(rs.next()){
                                retorno = rs.getInt("id"+ campo);
                        }
                }catch(IOException | SQLException e){
                        System.err.println("Erro ao acessar o bando de dados! " + e.getMessage());
                }finally{
                        try{
                                con.close();
                        }catch(SQLException e){
                                
                        }
                        try{
                                stmt.close();
                        }catch(SQLException e){
                                
                        }
                        try{
                                rs.close();
                        }catch(SQLException e){
                                
                        }
                }
                return retorno;
        }
        
        

}
