package br.com.droid.dao;

import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.Vendedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendedoresDAO extends ConnectionFactory {

    public int verificaCadastrado(String CodGrupo) throws ClassNotFoundException {

        int id = 0;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        try {
            stmt = conn
                    .prepareStatement("SELECT CodVen FROM Vendedores WHERE NomVen = ?");
            stmt.setString(1, CodGrupo);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("CodVen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return id;
    }

    public int inserir(Vendedores vendedores) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int sucesso = 0;
        int prodsCadastrados = verificaCadastrado(vendedores.getNomVen());

        if (prodsCadastrados == 0) {
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO Vendedores("
                        + "CodVen, PesVen, CNPJVen, InsVen, Inativo, DatInativo,"
                        + "NomVen, Apelido, EndVen, BaiVen, CEPVen, CodCidVen,"
                        + "DDDFonVen, FonVen, DD2FonVen, Fon2Ven, DDDFaxVen, FaxVen,"
                        + "DDDCelVen, CelVen, ConVen, EmailVen, AgVen, ContaVen,"
                        + "CodBanVen, CadVen, ObsVen, NomCid, NomEst)"
                        + "VALUES (?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?)");
                stmt.setString(1, vendedores.getPesVen());
                stmt.setString(2, vendedores.getCNPJVen());
                stmt.setString(3, vendedores.getInsVen());
                stmt.setBoolean(4, vendedores.getInativo());
                stmt.setString(5, vendedores.getDatInativo());
                stmt.setString(6, vendedores.getNomVen());
                stmt.setString(7, vendedores.getApelido());
                stmt.setString(8, vendedores.getEndVen());
                stmt.setString(9, vendedores.getBaiVen());
                stmt.setString(10, vendedores.getCEPVen());
                stmt.setInt(11, vendedores.getCodCidVen());
                stmt.setString(12, vendedores.getDDDFonVen());
                stmt.setString(13, vendedores.getFonVen());
                stmt.setString(14, vendedores.getDD2FonVen());
                stmt.setString(15, vendedores.getFon2Ven());
                stmt.setString(16, vendedores.getDDDFaxVen());
                stmt.setString(17, vendedores.getFaxVen());
                stmt.setString(18, vendedores.getDDDCelVen());
                stmt.setString(19, vendedores.getCelVen());
                stmt.setString(20, vendedores.getConVen());
                stmt.setString(21, vendedores.getEmailVen());
                stmt.setString(22, vendedores.getAgVen());
                stmt.setString(23, vendedores.getContaVen());
                stmt.setInt(24, vendedores.getCodBanVen());
                stmt.setString(25, vendedores.getCadVen());
                stmt.setString(26, vendedores.getObsVen());
                stmt.setString(27, vendedores.getNomCid());
                stmt.setString(28, vendedores.getNomEst());





                sucesso = stmt.executeUpdate();

                if (sucesso > 0) {
                    System.out.println("VENDEDOR INSERIDO!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERRO AO INSERIR VENDEDOR!");
            } finally {
                closeConnection(conn, stmt);
            }
        } else {
            System.out.println("ERRO: VENDEDOR JA CADASTRADO");
            closeConnection(conn);
        }
        return sucesso;
    }

    public int alterar(Vendedores vendedores) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        PreparedStatement stmt = null;
        int sucesso = 0;
        try {
            stmt = conn
                    .prepareStatement("UPDATE ItemsPed SET "
                    + "CodVen = ?, PesVen = ?, CNPJVen = ?, InsVen = ?, Inativo = ?, DatInativo = ?,"
                    + "NomVen = ?, Apelido = ?, EndVen = ?, BaiVen = ?, CEPVen = ?, CodCidVen = ?,"
                    + "DDDFonVen = ?, FonVen = ?, DD2FonVen = ?, Fon2Ven = ?, DDDFaxVen = ?, FaxVen = ?,"
                    + "DDDCelVen = ?, CelVen = ?, ConVen = ?, EmailVen = ?, AgVen = ?, ContaVen = ?,"
                    + "CodBanVen = ?, CadVen = ?, ObsVen = ?, NomCid = ?, NomEst = ?)");

            stmt.setString(1, vendedores.getPesVen());
            stmt.setString(2, vendedores.getCNPJVen());
            stmt.setString(3, vendedores.getInsVen());
            stmt.setBoolean(4, vendedores.getInativo());
            stmt.setString(5, vendedores.getDatInativo());
            stmt.setString(6, vendedores.getNomVen());
            stmt.setString(7, vendedores.getApelido());
            stmt.setString(8, vendedores.getEndVen());
            stmt.setString(9, vendedores.getBaiVen());
            stmt.setString(10, vendedores.getCEPVen());
            stmt.setInt(11, vendedores.getCodCidVen());
            stmt.setString(12, vendedores.getDDDFonVen());
            stmt.setString(13, vendedores.getFonVen());
            stmt.setString(14, vendedores.getDD2FonVen());
            stmt.setString(15, vendedores.getFon2Ven());
            stmt.setString(16, vendedores.getDDDFaxVen());
            stmt.setString(17, vendedores.getFaxVen());
            stmt.setString(18, vendedores.getDDDCelVen());
            stmt.setString(19, vendedores.getCelVen());
            stmt.setString(20, vendedores.getConVen());
            stmt.setString(21, vendedores.getEmailVen());
            stmt.setString(22, vendedores.getAgVen());
            stmt.setString(23, vendedores.getContaVen());
            stmt.setInt(24, vendedores.getCodBanVen());
            stmt.setString(25, vendedores.getCadVen());
            stmt.setString(26, vendedores.getObsVen());
            stmt.setString(27, vendedores.getNomCid());
            stmt.setString(28, vendedores.getNomEst());


            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("VENDEDOR ALTERADO!");
            } else {
                System.out.println("VENDEDOR NÃO EXISTE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO ALTERAR VENDEDOR!");
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
            stmt = conn.prepareStatement("DELETE FROM Vendedores WHERE CodVen = ?");
            stmt.setInt(1, id);
            excluidos = stmt.executeUpdate();

            if (excluidos > 0) {
                System.out.println("VENDEDOR REMOVIDO!");
            } else {
                System.out.println("VENDEDOR NÃO EXISTE!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO DELETAR VENDEDOR!");
        } finally {
            closeConnection(conn, stmt);
        }
        return excluidos;
    }

    public Vendedores buscar(int id) throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        Vendedores vendedores = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Vendedores WHERE CodVen = ?");
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {




                vendedores = new Vendedores();
                vendedores.setCodVen(resultSet.getInt("CodVen"));
                vendedores.setPesVen(resultSet.getString("PesVen"));
                vendedores.setCNPJVen(resultSet.getString("CNPJVen"));
                vendedores.setInsVen(resultSet.getString("InsVen"));
                vendedores.setInativo(resultSet.getBoolean("Inativo"));
                vendedores.setDatInativo(resultSet.getString("DatInativo"));
                vendedores.setNomVen(resultSet.getString("NomVen"));
                vendedores.setApelido(resultSet.getString("Apelido"));
                vendedores.setEndVen(resultSet.getString("EndVen"));
                vendedores.setBaiVen(resultSet.getString("BaiVen"));
                vendedores.setCEPVen(resultSet.getString("CEPVen"));
                vendedores.setCodCidVen(resultSet.getInt("CodCidVen"));
                vendedores.setDDDFonVen(resultSet.getString("DDDFonVen"));
                vendedores.setFonVen(resultSet.getString("FonVen"));
                vendedores.setDD2FonVen(resultSet.getString("DD2FonVen"));
                vendedores.setFon2Ven(resultSet.getString("Fon2Ven"));
                vendedores.setDDDFaxVen(resultSet.getString("DDDFaxVen"));
                vendedores.setFaxVen(resultSet.getString("FaxVen"));
                vendedores.setDDDCelVen(resultSet.getString("DDDCelVen"));
                vendedores.setCelVen(resultSet.getString("CelVen"));
                vendedores.setConVen(resultSet.getString("ConVen"));
                vendedores.setEmailVen(resultSet.getString("EmailVen"));
                vendedores.setAgVen(resultSet.getString("AgVen"));
                vendedores.setContaVen(resultSet.getString("ContaVen"));
                vendedores.setCodBanVen(resultSet.getInt("CodBanVen"));
                vendedores.setCadVen(resultSet.getString("CadVen"));
                vendedores.setObsVen(resultSet.getString("ObsVen"));
                vendedores.setNomCid(resultSet.getString("NomCid"));
                vendedores.setNomEst(resultSet.getString("NomEst"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return vendedores;
    }

    public ArrayList<Vendedores> buscarTodos() throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ArrayList<Vendedores> listaVendedores = null;

        try {

            stmt = conn.prepareStatement("SELECT * FROM Grupos ORDER BY CodGrupo");
            resultSet = stmt.executeQuery();
            listaVendedores = new ArrayList<Vendedores>();

            while (resultSet.next()) {
                Vendedores vendedores = new Vendedores();

                  vendedores.setCodVen(resultSet.getInt("CodVen"));
                vendedores.setPesVen(resultSet.getString("PesVen"));
                vendedores.setCNPJVen(resultSet.getString("CNPJVen"));
                vendedores.setInsVen(resultSet.getString("InsVen"));
                vendedores.setInativo(resultSet.getBoolean("Inativo"));
                vendedores.setDatInativo(resultSet.getString("DatInativo"));
                vendedores.setNomVen(resultSet.getString("NomVen"));
                vendedores.setApelido(resultSet.getString("Apelido"));
                vendedores.setEndVen(resultSet.getString("EndVen"));
                vendedores.setBaiVen(resultSet.getString("BaiVen"));
                vendedores.setCEPVen(resultSet.getString("CEPVen"));
                vendedores.setCodCidVen(resultSet.getInt("CodCidVen"));
                vendedores.setDDDFonVen(resultSet.getString("DDDFonVen"));
                vendedores.setFonVen(resultSet.getString("FonVen"));
                vendedores.setDD2FonVen(resultSet.getString("DD2FonVen"));
                vendedores.setFon2Ven(resultSet.getString("Fon2Ven"));
                vendedores.setDDDFaxVen(resultSet.getString("DDDFaxVen"));
                vendedores.setFaxVen(resultSet.getString("FaxVen"));
                vendedores.setDDDCelVen(resultSet.getString("DDDCelVen"));
                vendedores.setCelVen(resultSet.getString("CelVen"));
                vendedores.setConVen(resultSet.getString("ConVen"));
                vendedores.setEmailVen(resultSet.getString("EmailVen"));
                vendedores.setAgVen(resultSet.getString("AgVen"));
                vendedores.setContaVen(resultSet.getString("ContaVen"));
                vendedores.setCodBanVen(resultSet.getInt("CodBanVen"));
                vendedores.setCadVen(resultSet.getString("CadVen"));
                vendedores.setObsVen(resultSet.getString("ObsVen"));
                vendedores.setNomCid(resultSet.getString("NomCid"));
                vendedores.setNomEst(resultSet.getString("NomEst"));




                listaVendedores.add(vendedores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            listaVendedores = null;
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return listaVendedores;
    }
}
