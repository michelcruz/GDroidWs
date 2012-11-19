package br.com.droid.dao;

import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDAO extends ConnectionFactory {

    public int verificaCadastrado(String cpf) throws ClassNotFoundException {

        int id = 0;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        try {
            stmt = conn
                    .prepareStatement("SELECT CodCli FROM Clientes WHERE CNPJCli = ?");
            stmt.setString(1, cpf);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("CodCli");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return id;
    }

    public int inserir(Clientes clientes) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int sucesso = 0;
        int prodsCadastrados = verificaCadastrado(clientes.getCNPJCli());

        if (prodsCadastrados == 0) {
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO "
                        + "Clientes (CNPJCli, InsCli, Sufra, RazCli, EndCli, NumCli, BaiCli,"
                        + " CEPCli, DDDFonCli, FonCli, DDDFaxCli, FaxCli, EmailCli, ObsCli,"
                        + " Alerta, NomCid, NomEst, CodContabil, EndCob, NumCob, BaiCob, "
                        + "CEPCob, TipoVenda)"
                        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                stmt.setString(1, clientes.getCNPJCli());
                stmt.setString(2, clientes.getInsCli());
                stmt.setString(3, clientes.getSufra());
                stmt.setString(4, clientes.getRazCli());
                stmt.setString(5, clientes.getEndCli());
                stmt.setString(6, clientes.getNumCli());
                stmt.setString(7, clientes.getBaiCli());
                stmt.setString(8, clientes.getCEPCli());
                stmt.setString(9, clientes.getDDDFonCli());
                stmt.setString(10, clientes.getFonCli());
                stmt.setString(11, clientes.getDDDFaxCli());
                stmt.setString(12, clientes.getFaxCli());
                stmt.setString(13, clientes.getEmailCli());
                stmt.setString(14, clientes.getObsCli());
                stmt.setString(15, clientes.getAlerta());
                stmt.setString(16, clientes.getNomCid());
                stmt.setString(17, clientes.getNomEst());
                stmt.setString(18, clientes.getCodContabil());
                stmt.setString(19, clientes.getEndCob());
                stmt.setString(20, clientes.getNumCob());
                stmt.setString(21, clientes.getBaiCob());
                stmt.setString(22, clientes.getCEPCob());
                stmt.setString(23, clientes.getTipoVenda());

                sucesso = stmt.executeUpdate();

                if (sucesso > 0) {
                    System.out.println("CLIENTE INSERIDO!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERRO AO INSERIR CLIENTE!");
            } finally {
                closeConnection(conn, stmt);
            }
        } else {
            System.out.println("ERRO: CLIENTE JA CADASTRADO");
            closeConnection(conn);
        }
        return sucesso;
    }

    public int alterar(Clientes clientes) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        PreparedStatement stmt = null;
        int sucesso = 0;
        try {
            stmt = conn
                    .prepareStatement("UPDATE "
                    + "Clientes SET CNPJCli = ?, InsCli = ?, Sufra = ?, RazCli = ?, EndCli = ?, NumCli = ?, BaiCli, = ?"
                    + " CEPCli = ?, DDDFonCli = ?, FonCli = ?, DDDFaxCli = ?, FaxCli = ?, EmailCli = ?, ObsCli, = ?"
                    + " Alerta = ?, NomCid = ?, NomEst = ?, CodContabil = ?, EndCob = ?, NumCob = ?, BaiCob = ?, "
                    + "CEPCob = ?, TipoVenda = ?)");

            stmt.setString(1, clientes.getCNPJCli());
            stmt.setString(2, clientes.getInsCli());
            stmt.setString(3, clientes.getSufra());
            stmt.setString(4, clientes.getRazCli());
            stmt.setString(5, clientes.getEndCli());
            stmt.setString(6, clientes.getNumCli());
            stmt.setString(7, clientes.getBaiCli());
            stmt.setString(8, clientes.getCEPCli());
            stmt.setString(9, clientes.getDDDFonCli());
            stmt.setString(10, clientes.getFonCli());
            stmt.setString(11, clientes.getDDDFaxCli());
            stmt.setString(12, clientes.getFaxCli());
            stmt.setString(13, clientes.getEmailCli());
            stmt.setString(14, clientes.getObsCli());
            stmt.setString(15, clientes.getAlerta());
            stmt.setString(16, clientes.getNomCid());
            stmt.setString(17, clientes.getNomEst());
            stmt.setString(18, clientes.getCodContabil());
            stmt.setString(19, clientes.getEndCob());
            stmt.setString(20, clientes.getNumCob());
            stmt.setString(21, clientes.getBaiCob());
            stmt.setString(22, clientes.getCEPCob());
            stmt.setString(23, clientes.getTipoVenda());
            stmt.setInt(24, clientes.getCodCli());
            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("CLIENTE ALTERADO!");
            } else {
                System.out.println("CLIENTE NÃO EXISTE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO ALTERAR CLIENTE!");
        } finally {
            closeConnection(conn, stmt);
        }
        return sucesso;
    }

    public int deletar(int id) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int excluidos = 0;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM Clientes WHERE CodCli = ?");
            stmt.setInt(1, id);
            excluidos = stmt.executeUpdate();

            if (excluidos > 0) {
                System.out.println("CLIENTE REMOVIDO!");
            } else {
                System.out.println("CLIENTE NÃO EXISTE!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO DELETAR CLIENTE!");
        } finally {
            closeConnection(conn, stmt);
        }
        return excluidos;
    }

    public Clientes buscar(int id) throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        Clientes clientes = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Clientes WHERE CodCli = ?");
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {




                clientes = new Clientes();
                clientes.setCodCli(resultSet.getInt("CodCli"));
                clientes.setCNPJCli(resultSet.getString("CNPJCli"));
                clientes.setInsCli(resultSet.getString("InsCli"));
                clientes.setSufra(resultSet.getString("Sufra"));
                clientes.setRazCli(resultSet.getString("RazCli"));
                clientes.setEndCli(resultSet.getString("EndCli"));
                clientes.setNumCli(resultSet.getString("NumCli"));
                clientes.setBaiCli(resultSet.getString("BaiCli"));
                clientes.setCEPCli(resultSet.getString("CEPCli"));
                clientes.setDDDFonCli(resultSet.getString("DDDFonCli"));
                clientes.setFonCli(resultSet.getString("FonCli"));
                clientes.setDDDFaxCli(resultSet.getString("DDDFaxCli"));
                clientes.setFonCli(resultSet.getString("FonCli"));
                clientes.setDDDFaxCli(resultSet.getString("DDDFaxCli"));
                clientes.setFaxCli(resultSet.getString("FaxCli"));
                clientes.setEmailCli(resultSet.getString("EmailCli"));
                clientes.setObsCli(resultSet.getString("ObsCli"));
                clientes.setAlerta(resultSet.getString("Alerta"));
                clientes.setNomCid(resultSet.getString("NomCid"));
                clientes.setNomEst(resultSet.getString("NomEst"));
                clientes.setCodContabil(resultSet.getString("CodContabil"));
                clientes.setNumCob(resultSet.getString("NumCob"));
                clientes.setCEPCob(resultSet.getString("CEPCob"));
                clientes.setTipoVenda(resultSet.getString("TipoVenda"));
                clientes.setEndCob(resultSet.getString("EndCob"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return clientes;
    }

    public ArrayList<Clientes> buscarTodos() throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ArrayList<Clientes> listaClientes = null;

        try {

            stmt = conn.prepareStatement("SELECT * FROM Clientes ORDER BY CodCli");
            resultSet = stmt.executeQuery();
            listaClientes = new ArrayList<Clientes>();

            while (resultSet.next()) {
                Clientes clientes = new Clientes();
                
                
                clientes.setCodCli(resultSet.getInt("CodCli"));
                clientes.setCNPJCli(resultSet.getString("CNPJCli"));
                clientes.setInsCli(resultSet.getString("InsCli"));
                clientes.setSufra(resultSet.getString("Sufra"));
                clientes.setRazCli(resultSet.getString("RazCli"));
                clientes.setEndCli(resultSet.getString("EndCli"));
                clientes.setNumCli(resultSet.getString("NumCli"));
                clientes.setBaiCli(resultSet.getString("BaiCli"));
                clientes.setCEPCli(resultSet.getString("CEPCli"));
                clientes.setDDDFonCli(resultSet.getString("DDDFonCli"));
                clientes.setFonCli(resultSet.getString("FonCli"));
                clientes.setDDDFaxCli(resultSet.getString("DDDFaxCli"));
                clientes.setFonCli(resultSet.getString("FonCli"));
                clientes.setDDDFaxCli(resultSet.getString("DDDFaxCli"));
                clientes.setFaxCli(resultSet.getString("FaxCli"));
                clientes.setEmailCli(resultSet.getString("EmailCli"));
                clientes.setObsCli(resultSet.getString("ObsCli"));
                clientes.setAlerta(resultSet.getString("Alerta"));
                clientes.setNomCid(resultSet.getString("NomCid"));
                clientes.setNomEst(resultSet.getString("NomEst"));
                clientes.setCodContabil(resultSet.getString("CodContabil"));
                clientes.setNumCob(resultSet.getString("NumCob"));
                clientes.setCEPCob(resultSet.getString("CEPCob"));
                clientes.setTipoVenda(resultSet.getString("TipoVenda"));
                clientes.setEndCob(resultSet.getString("EndCob"));
                
               
                listaClientes.add(clientes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            listaClientes = null;
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return listaClientes;
    }
}
