package br.com.droid.dao;

import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.ItemsPed;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsPedDAO extends ConnectionFactory {

    public int verificaCadastrado(String DesPro) throws ClassNotFoundException {

        int id = 0;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        try {
            stmt = conn
                    .prepareStatement("SELECT CodPed FROM ItemsPed WHERE DesPro = ?");
            stmt.setString(1, DesPro);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("CodPed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return id;
    }

    public int inserir(ItemsPed itemsPed) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int sucesso = 0;
        int prodsCadastrados = verificaCadastrado(itemsPed.getDesPro());

        if (prodsCadastrados == 0) {
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO "
                        + "ItemsPed(CodPed, Seq, TipoMov, CodPro, DesPro, CodBarra, Unid,"
                        + "Quant, Custo, PrUnit, PrTot, IPI, ICMS, PeLiq,"
                        + "PeBru, PerDes, ValDes, ClassFiscal, SitTrib, PrSem,"
                        + "ValSem, TotSem, PrCom, ValCom, TotCom, ValIPI, QdeSem,"
                        + "QdeCom, Cortado, QdeCorte, Liberado, Obs, Motivo,"
                        + "PrComissao, QComissao, TotComissao, PerComissao, FixaComissao,"
                        + "QdeConferido, Caixa, NroMaster, DataCF, Hora, CodConf,"
                        + "QdeDevFala, TotDevFalta, SDevFalta, DevFalta, Inserido,"
                        + "LVenda, CodEmb, LPRUnit, TravCom, ValIcms, Pis, ValPis,"
                        + " Cofins, ValCofins, IcmsST, ValIcmsST, BasIcmsST, CfCod,"
                        + "DIcms, ValDIcms, Dpis, ValDPis, DCofins, ValdCofins)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?,"
                        + "?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, itemsPed.getSeq());
                stmt.setString(2, itemsPed.getTipoMov());
                stmt.setInt(3, itemsPed.getCodPro());
                stmt.setString(4, itemsPed.getDesPro());
                stmt.setString(5, itemsPed.getCodBarra());
                stmt.setString(6, itemsPed.getUnid());
                stmt.setDouble(7, itemsPed.getQuant());
                stmt.setBigDecimal(8, itemsPed.getCusto());
                stmt.setDouble(9, itemsPed.getPrUnit());
                stmt.setDouble(10, itemsPed.getPrTot());
                stmt.setDouble(11, itemsPed.getIpi());
                stmt.setDouble(12, itemsPed.getIcms());
                stmt.setDouble(13, itemsPed.getPeLiq());
                stmt.setDouble(14, itemsPed.getPeBru());
                stmt.setDouble(15, itemsPed.getPerDes());
                stmt.setDouble(16, itemsPed.getValDes());
                stmt.setString(17, itemsPed.getClassFiscal());
                stmt.setDouble(18, itemsPed.getPrSem());
                stmt.setDouble(19, itemsPed.getValSem());
                stmt.setDouble(20, itemsPed.getTotSem());
                stmt.setDouble(21, itemsPed.getPrCom());
                stmt.setDouble(22, itemsPed.getValCom());
                stmt.setDouble(23, itemsPed.getTotCom());
                stmt.setDouble(24, itemsPed.getValIPI());
                stmt.setDouble(25, itemsPed.getQdeSem());
                stmt.setDouble(26, itemsPed.getQdeCom());
                stmt.setBoolean(27, itemsPed.getCortado());
                stmt.setDouble(28, itemsPed.getQdeCorte());
                stmt.setBoolean(29, itemsPed.getLiberado());
                stmt.setString(30, itemsPed.getObs());
                stmt.setString(31, itemsPed.getMotivo());
                stmt.setDouble(32, itemsPed.getPrComissao());
                stmt.setDouble(33, itemsPed.getQComissao());
                stmt.setDouble(34, itemsPed.getTotComissao());
                stmt.setDouble(35, itemsPed.getPerComissao());
                stmt.setString(36, itemsPed.getFixaComissao());
                stmt.setDouble(37, itemsPed.getQdeConferido());
                stmt.setInt(39, itemsPed.getNroMaster());
                stmt.setString(40, itemsPed.getDataCF());
                stmt.setString(41, itemsPed.getHora());
                stmt.setInt(42, itemsPed.getCodConf());
                stmt.setDouble(43, itemsPed.getQdeDevFala());
                stmt.setDouble(44, itemsPed.getTotDevFalta());
                stmt.setString(45, itemsPed.getSDevFalta());
                stmt.setString(46, itemsPed.getDevFalta());
                stmt.setString(47, itemsPed.getInserido());
                stmt.setDouble(48, itemsPed.getLVenda());
                stmt.setInt(49, itemsPed.getCodEmb());
                stmt.setDouble(50, itemsPed.getLPRUnit());
                stmt.setString(51, itemsPed.getTravCom());
                stmt.setDouble(52, itemsPed.getValIcms());
                stmt.setDouble(53, itemsPed.getPis());
                stmt.setDouble(54, itemsPed.getValPis());
                stmt.setDouble(55, itemsPed.getCofins());
                stmt.setDouble(56, itemsPed.getValCofins());
                stmt.setDouble(57, itemsPed.getIcmsST());
                stmt.setDouble(58, itemsPed.getValIcmsST());
                stmt.setDouble(59, itemsPed.getBasIcmsST());
                stmt.setString(60, itemsPed.getCfCod());
                stmt.setDouble(61, itemsPed.getDIcms());
                stmt.setDouble(62, itemsPed.getDpis());
                stmt.setDouble(63, itemsPed.getValDPis());
                stmt.setDouble(64, itemsPed.getDCofins());
                stmt.setDouble(65, itemsPed.getValdCofins());




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

    public int alterar(ItemsPed itemsPed) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        PreparedStatement stmt = null;
        int sucesso = 0;
        try {
            stmt = conn
                    .prepareStatement("UPDATE ItemsPed  SET CodPed = ?, Seq = ?, TipoMov = ?, CodPro = ?, DesPro = ?, CodBarra = ?, Unid = ?,"
                    + "Quant = ?, Custo = ?, PrUnit = ?, PrTot = ?, IPI = ?, ICMS = ?, PeLiq = ?,"
                    + "PeBru = ?, PerDes = ?, ValDes = ?, ClassFiscal = ?, SitTrib = ?, PrSem = ?,"
                    + "ValSem = ?, TotSem = ?, PrCom = ?, ValCom = ?, TotCom = ?, ValIPI = ?, QdeSem = ?,"
                    + "QdeCom = ?, Cortado = ?, QdeCorte = ?, Liberado = ?, Obs = ?, Motivo = ?,"
                    + "PrComissao = ?, QComissao = ?, TotComissao = ?, PerComissao = ?, FixaComissao = ?,"
                    + "QdeConferido = ?, Caixa = ?, NroMaster = ?, DataCF = ?, Hora = ?, CodConf = ?,"
                    + "QdeDevFala = ?, TotDevFalta = ?, SDevFalta = ?, DevFalta = ?, Inserido = ?,"
                    + "LVenda = ?, CodEmb = ?, LPRUnit = ?, TravCom = ?, ValIcms = ?, Pis = ?, ValPis = ?,"
                    + " Cofins = ?, ValCofins = ?, IcmsST = ?, ValIcmsST = ?, BasIcmsST = ?, CfCod = ?,"
                    + "DIcms = ?, ValDIcms = ?, Dpis = ?, ValDPis = ?, DCofins = ?, ValdCofins = ?)");

            stmt.setInt(1, itemsPed.getSeq());
            stmt.setString(2, itemsPed.getTipoMov());
            stmt.setInt(3, itemsPed.getCodPro());
            stmt.setString(4, itemsPed.getDesPro());
            stmt.setString(5, itemsPed.getCodBarra());
            stmt.setString(6, itemsPed.getUnid());
            stmt.setDouble(7, itemsPed.getQuant());
            stmt.setBigDecimal(8, itemsPed.getCusto());
            stmt.setDouble(9, itemsPed.getPrUnit());
            stmt.setDouble(10, itemsPed.getPrTot());
            stmt.setDouble(11, itemsPed.getIpi());
            stmt.setDouble(12, itemsPed.getIcms());
            stmt.setDouble(13, itemsPed.getPeLiq());
            stmt.setDouble(14, itemsPed.getPeBru());
            stmt.setDouble(15, itemsPed.getPerDes());
            stmt.setDouble(16, itemsPed.getValDes());
            stmt.setString(17, itemsPed.getClassFiscal());
            stmt.setDouble(18, itemsPed.getPrSem());
            stmt.setDouble(19, itemsPed.getValSem());
            stmt.setDouble(20, itemsPed.getTotSem());
            stmt.setDouble(21, itemsPed.getPrCom());
            stmt.setDouble(22, itemsPed.getValCom());
            stmt.setDouble(23, itemsPed.getTotCom());
            stmt.setDouble(24, itemsPed.getValIPI());
            stmt.setDouble(25, itemsPed.getQdeSem());
            stmt.setDouble(26, itemsPed.getQdeCom());
            stmt.setBoolean(27, itemsPed.getCortado());
            stmt.setDouble(28, itemsPed.getQdeCorte());
            stmt.setBoolean(29, itemsPed.getLiberado());
            stmt.setString(30, itemsPed.getObs());
            stmt.setString(31, itemsPed.getMotivo());
            stmt.setDouble(32, itemsPed.getPrComissao());
            stmt.setDouble(33, itemsPed.getQComissao());
            stmt.setDouble(34, itemsPed.getTotComissao());
            stmt.setDouble(35, itemsPed.getPerComissao());
            stmt.setString(36, itemsPed.getFixaComissao());
            stmt.setDouble(37, itemsPed.getQdeConferido());
            stmt.setInt(39, itemsPed.getNroMaster());
            stmt.setString(40, itemsPed.getDataCF());
            stmt.setString(41, itemsPed.getHora());
            stmt.setInt(42, itemsPed.getCodConf());
            stmt.setDouble(43, itemsPed.getQdeDevFala());
            stmt.setDouble(44, itemsPed.getTotDevFalta());
            stmt.setString(45, itemsPed.getSDevFalta());
            stmt.setString(46, itemsPed.getDevFalta());
            stmt.setString(47, itemsPed.getInserido());
            stmt.setDouble(48, itemsPed.getLVenda());
            stmt.setInt(49, itemsPed.getCodEmb());
            stmt.setDouble(50, itemsPed.getLPRUnit());
            stmt.setString(51, itemsPed.getTravCom());
            stmt.setDouble(52, itemsPed.getValIcms());
            stmt.setDouble(53, itemsPed.getPis());
            stmt.setDouble(54, itemsPed.getValPis());
            stmt.setDouble(55, itemsPed.getCofins());
            stmt.setDouble(56, itemsPed.getValCofins());
            stmt.setDouble(57, itemsPed.getIcmsST());
            stmt.setDouble(58, itemsPed.getValIcmsST());
            stmt.setDouble(59, itemsPed.getBasIcmsST());
            stmt.setString(60, itemsPed.getCfCod());
            stmt.setDouble(61, itemsPed.getDIcms());
            stmt.setDouble(62, itemsPed.getDpis());
            stmt.setDouble(63, itemsPed.getValDPis());
            stmt.setDouble(64, itemsPed.getDCofins());
            stmt.setDouble(65, itemsPed.getValdCofins());
            stmt.setInt(66, itemsPed.getCodPed());
            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("Itens ALTERADO!");
            } else {
                System.out.println("Itens NÃO EXISTE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO ALTERAR Itens!");
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
            stmt = conn.prepareStatement("DELETE FROM ItemsPed WHERE CodPed = ?");
            stmt.setInt(1, id);
            excluidos = stmt.executeUpdate();

            if (excluidos > 0) {
                System.out.println("Itens REMOVIDO!");
            } else {
                System.out.println("Itens NÃO EXISTE!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO DELETAR CLIENTE!");
        } finally {
            closeConnection(conn, stmt);
        }
        return excluidos;
    }

    public ItemsPed buscar(int id) throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ItemsPed itemsPed = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM ItensPed WHERE CodPed = ?");
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {




                itemsPed = new ItemsPed();
                itemsPed.setSeq(resultSet.getInt("Seq"));
                itemsPed.setTipoMov(resultSet.getString("TipoMov"));
                itemsPed.setCodPro(resultSet.getInt("CodPro"));
                itemsPed.setDesPro(resultSet.getString("DesPro"));
                itemsPed.setCodBarra(resultSet.getString("CodBarra"));
                itemsPed.setUnid(resultSet.getString("Unid"));
                itemsPed.setQuant(resultSet.getDouble("Quant"));
                itemsPed.setCusto(resultSet.getBigDecimal("Custo"));
                itemsPed.setPrUnit(resultSet.getDouble("PrUnit"));
                itemsPed.setPrTot(resultSet.getDouble("PrTot"));
                itemsPed.setIpi(resultSet.getDouble("IPI"));
                itemsPed.setIcms(resultSet.getDouble("ICMS"));
                itemsPed.setPeLiq(resultSet.getDouble("PeLiq"));
                itemsPed.setPeBru(resultSet.getDouble("PeBru"));
                itemsPed.setPerDes(resultSet.getDouble("PerDes"));
                itemsPed.setValDes(resultSet.getDouble("ValDes"));
                itemsPed.setClassFiscal(resultSet.getString("ClassFiscal"));
                itemsPed.setSitTrib(resultSet.getString("SitTrib"));
                itemsPed.setPrSem(resultSet.getDouble("PrSem"));
                itemsPed.setQdeCom(resultSet.getDouble("QdeCom"));
                itemsPed.setCortado(resultSet.getBoolean("Cortado"));
                itemsPed.setQdeCorte(resultSet.getDouble("QdeCorte"));
                itemsPed.setLiberado(resultSet.getBoolean("Liberado"));
                itemsPed.setObs(resultSet.getString("Obs"));
                itemsPed.setMotivo(resultSet.getString("Motivo"));
                itemsPed.setPrComissao(resultSet.getDouble("PrComissao"));
                itemsPed.setQComissao(resultSet.getDouble("QComissao"));
                itemsPed.setTotComissao(resultSet.getDouble("TotComissao"));
                itemsPed.setPerComissao(resultSet.getDouble("PerComissao"));
                itemsPed.setFixaComissao(resultSet.getString("FixaComissao"));
                itemsPed.setQdeConferido(resultSet.getDouble("QdeConferido"));
                itemsPed.setCaixa(resultSet.getInt("Caixa"));
                itemsPed.setNroMaster(resultSet.getInt("NroMaster"));
                itemsPed.setDataCF(resultSet.getString("DataCF"));
                itemsPed.setHora(resultSet.getString("Hora"));
                itemsPed.setCodConf(resultSet.getInt("CodConf"));
                itemsPed.setQdeDevFala(resultSet.getDouble("QdeDevFala"));
                itemsPed.setTotDevFalta(resultSet.getDouble("TotDevFalta"));
                itemsPed.setSDevFalta(resultSet.getString("SDevFalta"));
                itemsPed.setInserido(resultSet.getString("Inserido"));
                itemsPed.setLVenda(resultSet.getDouble("LVenda"));
                itemsPed.setCodEmb(resultSet.getInt("CodEmb"));
                itemsPed.setLPRUnit(resultSet.getDouble("LPRUnit"));
                itemsPed.setTravCom(resultSet.getString("TravCom"));
                itemsPed.setValIcms(resultSet.getDouble("ValIcms"));
                itemsPed.setPis(resultSet.getDouble("Pis"));
                itemsPed.setValPis(resultSet.getDouble("ValPis"));
                itemsPed.setCofins(resultSet.getDouble("Cofins"));
                itemsPed.setValCofins(resultSet.getDouble("ValCofins"));
                itemsPed.setIcmsST(resultSet.getDouble("IcmsST"));
                itemsPed.setValIcmsST(resultSet.getDouble("ValIcmsST"));
                itemsPed.setBasIcmsST(resultSet.getDouble("BasIcmsST"));
                itemsPed.setCfCod(resultSet.getString("CfCod"));
                itemsPed.setCofins(resultSet.getDouble("Cofins"));
                itemsPed.setValCofins(resultSet.getDouble("ValCofins"));
                itemsPed.setIcmsST(resultSet.getDouble("IcmsST"));
                itemsPed.setValIcmsST(resultSet.getDouble("ValIcmsST"));
                itemsPed.setBasIcmsST(resultSet.getDouble("BasIcmsST"));
                itemsPed.setCfCod(resultSet.getString("CfCod"));
                itemsPed.setDIcms(resultSet.getDouble("DIcms"));
                itemsPed.setValDIcms(resultSet.getDouble("ValDIcms"));
                itemsPed.setDpis(resultSet.getDouble("Dpis"));
                itemsPed.setValDPis(resultSet.getDouble("ValDPis"));
                itemsPed.setDCofins(resultSet.getDouble("DCofins"));
                itemsPed.setValdCofins(resultSet.getDouble("ValdCofins"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return itemsPed;
    }

    public ArrayList<ItemsPed> buscarTodos() throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ArrayList<ItemsPed> listaItens = null;

        try {

            stmt = conn.prepareStatement("SELECT * FROM ItensPed ORDER BY CodPed");
            resultSet = stmt.executeQuery();
            listaItens = new ArrayList<ItemsPed>();

            while (resultSet.next()) {
                ItemsPed itemsPed = new ItemsPed();
                itemsPed.setSeq(resultSet.getInt("Seq"));
                itemsPed.setTipoMov(resultSet.getString("TipoMov"));
                itemsPed.setCodPro(resultSet.getInt("CodPro"));
                itemsPed.setDesPro(resultSet.getString("DesPro"));
                itemsPed.setCodBarra(resultSet.getString("CodBarra"));
                itemsPed.setUnid(resultSet.getString("Unid"));
                itemsPed.setQuant(resultSet.getDouble("Quant"));
                itemsPed.setCusto(resultSet.getBigDecimal("Custo"));
                itemsPed.setPrUnit(resultSet.getDouble("PrUnit"));
                itemsPed.setPrTot(resultSet.getDouble("PrTot"));
                itemsPed.setIpi(resultSet.getDouble("IPI"));
                itemsPed.setIcms(resultSet.getDouble("ICMS"));
                itemsPed.setPeLiq(resultSet.getDouble("PeLiq"));
                itemsPed.setPeBru(resultSet.getDouble("PeBru"));
                itemsPed.setPerDes(resultSet.getDouble("PerDes"));
                itemsPed.setValDes(resultSet.getDouble("ValDes"));
                itemsPed.setClassFiscal(resultSet.getString("ClassFiscal"));
                itemsPed.setSitTrib(resultSet.getString("SitTrib"));
                itemsPed.setPrSem(resultSet.getDouble("PrSem"));
                itemsPed.setQdeCom(resultSet.getDouble("QdeCom"));
                itemsPed.setCortado(resultSet.getBoolean("Cortado"));
                itemsPed.setQdeCorte(resultSet.getDouble("QdeCorte"));
                itemsPed.setLiberado(resultSet.getBoolean("Liberado"));
                itemsPed.setObs(resultSet.getString("Obs"));
                itemsPed.setMotivo(resultSet.getString("Motivo"));
                itemsPed.setPrComissao(resultSet.getDouble("PrComissao"));
                itemsPed.setQComissao(resultSet.getDouble("QComissao"));
                itemsPed.setTotComissao(resultSet.getDouble("TotComissao"));
                itemsPed.setPerComissao(resultSet.getDouble("PerComissao"));
                itemsPed.setFixaComissao(resultSet.getString("FixaComissao"));
                itemsPed.setQdeConferido(resultSet.getDouble("QdeConferido"));
                itemsPed.setCaixa(resultSet.getInt("Caixa"));
                itemsPed.setNroMaster(resultSet.getInt("NroMaster"));
                itemsPed.setDataCF(resultSet.getString("DataCF"));
                itemsPed.setHora(resultSet.getString("Hora"));
                itemsPed.setCodConf(resultSet.getInt("CodConf"));
                itemsPed.setQdeDevFala(resultSet.getDouble("QdeDevFala"));
                itemsPed.setTotDevFalta(resultSet.getDouble("TotDevFalta"));
                itemsPed.setSDevFalta(resultSet.getString("SDevFalta"));
                itemsPed.setInserido(resultSet.getString("Inserido"));
                itemsPed.setLVenda(resultSet.getDouble("LVenda"));
                itemsPed.setCodEmb(resultSet.getInt("CodEmb"));
                itemsPed.setLPRUnit(resultSet.getDouble("LPRUnit"));
                itemsPed.setTravCom(resultSet.getString("TravCom"));
                itemsPed.setValIcms(resultSet.getDouble("ValIcms"));
                itemsPed.setPis(resultSet.getDouble("Pis"));
                itemsPed.setValPis(resultSet.getDouble("ValPis"));
                itemsPed.setCofins(resultSet.getDouble("Cofins"));
                itemsPed.setValCofins(resultSet.getDouble("ValCofins"));
                itemsPed.setIcmsST(resultSet.getDouble("IcmsST"));
                itemsPed.setValIcmsST(resultSet.getDouble("ValIcmsST"));
                itemsPed.setBasIcmsST(resultSet.getDouble("BasIcmsST"));
                itemsPed.setCfCod(resultSet.getString("CfCod"));
                itemsPed.setCofins(resultSet.getDouble("Cofins"));
                itemsPed.setValCofins(resultSet.getDouble("ValCofins"));
                itemsPed.setIcmsST(resultSet.getDouble("IcmsST"));
                itemsPed.setValIcmsST(resultSet.getDouble("ValIcmsST"));
                itemsPed.setBasIcmsST(resultSet.getDouble("BasIcmsST"));
                itemsPed.setCfCod(resultSet.getString("CfCod"));
                itemsPed.setDIcms(resultSet.getDouble("DIcms"));
                itemsPed.setValDIcms(resultSet.getDouble("ValDIcms"));
                itemsPed.setDpis(resultSet.getDouble("Dpis"));
                itemsPed.setValDPis(resultSet.getDouble("ValDPis"));
                itemsPed.setDCofins(resultSet.getDouble("DCofins"));
                itemsPed.setValdCofins(resultSet.getDouble("ValdCofins"));


                listaItens.add(itemsPed);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            listaItens = null;
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return listaItens;
    }
}
