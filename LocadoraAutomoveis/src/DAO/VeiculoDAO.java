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
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import enums.ModeloMotocicleta;
import enums.ModeloVan;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author luis
 */
public class VeiculoDAO {

        private final String stmtInsert = "insert into veiculo(valordecompra, placa, ano, idmodelo, idmarca, idestado, idcategoria) values(?, ?,  ?,  ?, ?, ?, ?)";
        private final String stmtUpdate = "update veiculo set valordecompra = ?, placa = ?, ano = ?, idmodelo = ?, idmarca = ?, idestado = ?,"
                + " idcategoria = ? where idveiculo = ? ";
        private final String stmtBuscaPorNome1 = "select id";
        private final String stmtBuscaPorNome2 = " from ";
        private final String stmtBuscaPorNome3 = " where nome like ? ";
        private final String stmtBuscaId = "select idveiculo from veiculo where placa like ?";
        private final String stmtExcluiVeiculo = "delete from veiculo where idveiculo = ?";
        private final String stmtSelecionaVeiculos = "select ve.idveiculo, ve.valordecompra, ve.placa, ve.ano, mod.nome, mar.nome, est.nome, cat.nome, idtipomodelo from veiculo ve\n"
                + "left join marca mar on ve.idmarca = mar.idmarca\n"
                + "left join estado est on ve.idestado = est.idestado\n"
                + "left join categoria cat on ve.idcategoria = cat.idcategoria\n"
                + "left join modelo mod on ve.idmodelo = mod.idmodelo\n"
                + "inner join tipomodelo on mod.idtipomodelo = tipomodelo.id\n"
                + "order by tipomodelo.id";
        private final String stmlBuscaNomePorIdEnum1 = "select nome from ";
        private final String stmlBuscaNomePorIdEnum2 = " where id";
        private final String stmlBuscaNomePorIdEnum3 = " = ?";

        public void criaVeiculo(Veiculo veiculo) throws IOException {
                Connection con = null;
                PreparedStatement stmt = null;
                int modelo;
                modelo = this.retornaModeloVeiculo(veiculo);
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtInsert);
                        stmt.setDouble(1, veiculo.getValorParaVenda());
                        stmt.setString(2, veiculo.getPlaca());
                        stmt.setInt(3, veiculo.getAno());
                        stmt.setInt(4, modelo);
                        stmt.setInt(6, this.buscaIdPorNomeEnum(veiculo.getMarca()));
                        stmt.setInt(5, this.buscaIdPorNomeEnum(veiculo.getEstado()));
                        stmt.setInt(7, this.buscaIdPorNomeEnum(veiculo.getCategoria()));

                        stmt.executeUpdate();
                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao tentar inserir cadastro no banco de dados!" + e.getMessage());
                } finally {
                        try { con.close(); } catch (SQLException e) {}
                        try { stmt.close(); } catch (SQLException e) {}
                }

        }

        public void atualizaVeiculo(Veiculo veiculo) {
                Connection con = null;
                PreparedStatement stmt = null;
                int modelo;
                modelo = this.retornaModeloVeiculo(veiculo);
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtUpdate);
                        stmt.setDouble(1, veiculo.getValorParaVenda());
                        System.out.println(veiculo.getValorParaVenda());
                        stmt.setString(2, veiculo.getPlaca());
                        stmt.setInt(3, veiculo.getAno());
                        stmt.setInt(4, modelo);
                        stmt.setInt(6, this.buscaIdPorNomeEnum(veiculo.getMarca()));
                        stmt.setInt(5, this.buscaIdPorNomeEnum(veiculo.getEstado()));
                        stmt.setInt(7, this.buscaIdPorNomeEnum(veiculo.getCategoria()));
                        stmt.setInt(8, this.buscaIdPorPlaca(veiculo));
                        System.out.println(stmt.toString());
                        stmt.executeUpdate();

                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao tentar inserir cadastro no banco de dados!" + e.getMessage());
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

        public void excluiVeiculo(Veiculo veiculo) {
                Connection con = null;
                PreparedStatement stmt = null;

                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtExcluiVeiculo);
                        stmt.setInt(1, this.buscaIdPorPlaca(veiculo));
                        stmt.executeUpdate();
                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao tentar inserir cadastro no banco de dados!" + e.getMessage());
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

        public ArrayList<Veiculo> selecionaVeiculos() {

                ArrayList<Veiculo> listaVeiculos = new ArrayList();
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtSelecionaVeiculos);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
//                                select idveiculo, valordecompra, placa, ano, idmodelo, idmarca, idestado, idcategoria from veiculo;
                                int idveiculo = rs.getInt(1);
                                double valorDeCompra = rs.getDouble(2);
                                String placa = rs.getString(3);
                                int ano = rs.getInt(4);
                                String modelo = rs.getString(5);
                                String marca = rs.getString(6);
                                String estado = rs.getString(7);
                                String categoria = rs.getString(8);
                                int tipomodelo = rs.getInt(9);
                                switch (tipomodelo) {
                                        case 1:
                                                {
                                                        Automovel veiculo = new Automovel(Marca.getMarca(marca), Estado.getEstado(estado), null, Categoria.getCategoria(categoria), valorDeCompra, placa, ano, ModeloAutomovel.getModeloAutomovel(modelo));
                                                        listaVeiculos.add(veiculo);
                                                        break;
                                                }
                                        case 2:
                                                {
                                                        Motocicleta veiculo = new Motocicleta(Marca.getMarca(marca), Estado.getEstado(estado), null, Categoria.getCategoria(categoria), valorDeCompra, placa, ano, ModeloMotocicleta.getModeloMotocicleta(modelo));
                                                        listaVeiculos.add(veiculo);
                                                        break;
                                                }
                                        default:
                                                {
                                                        Van veiculo = new Van(Marca.getMarca(marca), Estado.getEstado(estado), null, Categoria.getCategoria(categoria), valorDeCompra, placa, ano, ModeloVan.getModeloVan(modelo));
                                                        listaVeiculos.add(veiculo);
                                                        break;
                                                }
                                }
                        }
                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao acessar o bando de dados! " + e.getMessage());
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

                return listaVeiculos;
        }

        public int buscaIdPorPlaca(Veiculo veiculo) {
                int retorno = 0;
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;

                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(this.stmtBuscaId);
                        stmt.setString(1, veiculo.getPlaca());
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                                retorno = rs.getInt("idveiculo");
                        }

                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao acessar o bando de dados! " + e.getMessage());
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
                return retorno;
        }

        public int buscaIdPorNomeEnum(Enum nome) {
                int retorno = 0;
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                String quebrado[] = nome.getClass().toString().split("\\.");
                String quebrado1[] = quebrado[1].split("@");
                String table[] = quebrado1[0].split("[A-Z]");
                String campo = quebrado[1].substring(0, 1).toLowerCase() + table[1].toLowerCase();
                String stmtdefinitivo = this.stmtBuscaPorNome1 + campo + this.stmtBuscaPorNome2 + campo + this.stmtBuscaPorNome3;
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(stmtdefinitivo);
                        stmt.setString(1, nome.name().toUpperCase());
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                                retorno = rs.getInt("id" + campo);
                        }
                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao acessar o bando de dados! " + e.getMessage());
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
                return retorno;
        }

        public String buscaNomePorIdEnum(int id, String tabela) {
                String retorno = null;
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                String consulta = this.stmlBuscaNomePorIdEnum1 + tabela + this.stmlBuscaNomePorIdEnum2 + tabela + this.stmlBuscaNomePorIdEnum3;
                try {
                        con = new ConnectionFactory().getConnection();
                        stmt = con.prepareStatement(consulta);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                                retorno = rs.getString("nome");
                        }

                } catch (IOException | SQLException e) {
                        System.err.println("Erro ao acessar o bando de dados! " + e.getMessage());
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
                return retorno;
        }

        public int retornaModeloVeiculo(Veiculo veiculo) {
                int retorno;
                if (veiculo instanceof Automovel) {
                        Automovel auto = (Automovel) veiculo;
                        retorno = this.buscaIdPorNomeEnum(auto.getModeloAutomovel());
                } else if (veiculo instanceof Motocicleta) {
                        Motocicleta moto = (Motocicleta) veiculo;
                        retorno = this.buscaIdPorNomeEnum(moto.getModeloMotocicleta());
                } else {
                        Van van = (Van) veiculo;
                        retorno = this.buscaIdPorNomeEnum(van.getModeloVan());
                }
                return retorno;
        }
}
