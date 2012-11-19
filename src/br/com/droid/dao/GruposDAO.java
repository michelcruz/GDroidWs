package br.com.droid.dao;

import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.Grupos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GruposDAO extends ConnectionFactory {

    public int verificaCadastrado(String CodGrupo) throws ClassNotFoundException {

        int id = 0;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        try {
            stmt = conn
                    .prepareStatement("SELECT CodGrupo FROM Grupos WHERE DesGrupo = ?");
            stmt.setString(1, CodGrupo);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("CodGrupo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return id;
    }

    public int inserir(Grupos grupos) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int sucesso = 0;
        int prodsCadastrados = verificaCadastrado(grupos.getDesGrupo());

        if (prodsCadastrados == 0) {
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO "
                        + "Grupos (DesGrupo, GeraCom, Margem, PDes)"
                        + " VALUES(?,?,?,?)");
                stmt.setString(1, grupos.getDesGrupo());
                //Campo do tipo char vamu ve se roda com INT
                stmt.setString(2, grupos.getGeraCom());
                stmt.setDouble(3, grupos.getMargem());
                stmt.setDouble(4, grupos.getPDes());



                sucesso = stmt.executeUpdate();

                if (sucesso > 0) {
                    System.out.println("GRUPO INSERIDO!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERRO AO INSERIR GRUPO!");
            } finally {
                closeConnection(conn, stmt);
            }
        } else {
            System.out.println("ERRO: GRUPO JA CADASTRADO");
            closeConnection(conn);
        }
        return sucesso;
    }

    public int alterar(Grupos grupos) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        PreparedStatement stmt = null;
        int sucesso = 0;
        try {
            stmt = conn
                    .prepareStatement("UPDATE "
                   + "Grupos (DesGrupo = ?, GeraCom = ?, Margem = ?, PDes = ?)");

            stmt.setString(1, grupos.getDesGrupo());
            stmt.setString(2, grupos.getGeraCom());
            stmt.setDouble(3, grupos.getMargem());
            stmt.setDouble(4, grupos.getPDes());
            stmt.setInt(5, grupos.getCodGrupo());
            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("GRUPO ALTERADO!");
            } else {
                System.out.println("GRUPO NÃO EXISTE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO ALTERAR GRUPO!");
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
            stmt = conn.prepareStatement("DELETE FROM Grupos WHERE CodGrupo = ?");
            stmt.setInt(1, id);
            excluidos = stmt.executeUpdate();

            if (excluidos > 0) {
                System.out.println("GRUPO REMOVIDO!");
            } else {
                System.out.println("GRUPO NÃO EXISTE!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO DELETAR GRUPO!");
        } finally {
            closeConnection(conn, stmt);
        }
        return excluidos;
    }

    public Grupos buscar(int id) throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        Grupos grupos = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Grupos WHERE CodGrupo = ?");
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {




                grupos = new Grupos();
                grupos.setCodGrupo(resultSet.getInt("CodGrupo"));
                grupos.setDesGrupo(resultSet.getString("DesGrupo"));
                grupos.setGeraCom(resultSet.getString("GeraCom"));
                grupos.setMargem(resultSet.getDouble("Margem"));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return grupos;
    }

    public ArrayList<Grupos> buscarTodos() throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ArrayList<Grupos> listaGrupos = null;

        try {

            stmt = conn.prepareStatement("SELECT * FROM Grupos ORDER BY CodGrupo");
            resultSet = stmt.executeQuery();
            listaGrupos = new ArrayList<Grupos>();

            while (resultSet.next()) {
                Grupos grupos = new Grupos();

grupos.setCodGrupo(resultSet.getInt("CodGrupo"));
                grupos.setDesGrupo(resultSet.getString("DesGrupo"));
                grupos.setGeraCom(resultSet.getString("GeraCom"));
                grupos.setMargem(resultSet.getDouble("Margem"));
                
              

                listaGrupos.add(grupos);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            listaGrupos = null;
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return listaGrupos;
    }
}
