package br.com.droid.dao;

import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO extends ConnectionFactory {

    public int verificaCadastrado(String DesPro) throws ClassNotFoundException {

        int id = 0;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        try {
            stmt = conn
                    .prepareStatement("SELECT CodPro FROM Produtos WHERE DesPro = ?");
            stmt.setString(1, DesPro);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("CodPro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return id;
    }

    public int inserir(Produtos produtos) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int sucesso = 0;
        int prodsCadastrados = verificaCadastrado(produtos.getDesPro());

        if (prodsCadastrados == 0) {
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO Produtos("
                        + "CodPro, CodBarra, CodGrupo, CodSubGrupo, CodFabrica, "
                        + "DesPro, Unid, PesoLiq, PesoBru, SitTrib, Icms, IPI, "
                        + "Frete, ClassFiscal, CustFab, CustEng, CustEnt, CustMed, "
                        + "CustTot, DespFixa, PrVen1, PrVen2, PrVen3, PrVen4, "
                        + "Tipo, TipoProduto, ProdVenda, MComp, MDiam, MLarg, "
                        + "MEsp, CamTeflon, PesoTeflon, CalArea, EstMinimo, Tamanho, "
                        + "FatorTransf, UltValor, UltCompra, UltCodNat, Ed, MCheck,"
                        + "QdeUnid, UnidQde, MEng, DatEng, EhKit, MVal, DatVal, "
                        + "AltEmb, LarEmb, ComEmb, CubEmb, QdeEmb, Obs, AltCorpo, "
                        + "LarCorpo, ComCorpo, CubCorpo, LitCorpo, TipoFicha, "
                        + "Medida, Ficha, Tempo, Inativo, CIPI, CSTIPI, CSTPIS, "
                        + "PIS, CSTCOFINS, COFINS, ORIG, NCM, Cavidades, LargPlFund, "
                        + "Perda, EspDesb, Fator, PerdaLarg, NroCorte, SeqProd, "
                        + "Box, Andar, CodFor, ProdVendaNot)"
                        + "VALUES (?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?, ?, ?, "
                        + " ?, ?, ?, ?);");
                stmt.setInt(1, produtos.getCodPro());
                stmt.setString(2, produtos.getCodBarra());
                stmt.setInt(3, produtos.getCodGrupo());
                stmt.setInt(4, produtos.getCodSubGrupo());
                stmt.setInt(5, produtos.getCodFabrica());
                stmt.setString(6, produtos.getDesPro());
                stmt.setString(7, produtos.getUnid());
                stmt.setDouble(8, produtos.getPesoLiq());
                stmt.setDouble(9, produtos.getPesoBru());
                stmt.setString(10, produtos.getSitTrib());
                stmt.setDouble(11, produtos.getIcms());
                stmt.setDouble(12, produtos.getIpi());
                stmt.setDouble(13, produtos.getFrete());
                stmt.setString(14, produtos.getClassFiscal());
                stmt.setDouble(15, produtos.getCustFab());
                stmt.setDouble(16, produtos.getCustEng());
                stmt.setBigDecimal(17, produtos.getCustEnt());
                stmt.setDouble(18, produtos.getCustMed());
                stmt.setDouble(19, produtos.getCustTot());
                stmt.setDouble(20, produtos.getDespFixa());
                stmt.setDouble(21, produtos.getPrVen1());
                stmt.setDouble(22, produtos.getPrVen2());
                stmt.setDouble(23, produtos.getPrVen3());
                stmt.setDouble(24, produtos.getPrVen4());
                stmt.setString(25, produtos.getTipo());
                stmt.setString(26, produtos.getTipoProduto());
                stmt.setBoolean(27, produtos.getProdVenda());
                stmt.setDouble(28, produtos.getMComp());
                stmt.setDouble(29, produtos.getMDiam());
                stmt.setDouble(30, produtos.getMLarg());
                stmt.setDouble(31, produtos.getMEsp());
                stmt.setInt(32, produtos.getCamTeflon());
                stmt.setDouble(33, produtos.getPesoTeflon());
                stmt.setDouble(34, produtos.getCalArea());
                stmt.setDouble(35, produtos.getEstMinimo());
                stmt.setString(36, produtos.getTamanho());
                stmt.setBigDecimal(37, produtos.getFatorTransf());
                stmt.setBigDecimal(38, produtos.getUltValor());
                stmt.setString(39, produtos.getUltCompra());
                stmt.setInt(40, produtos.getUltCodNat());
                stmt.setString(41, produtos.getEd());
                stmt.setBoolean(42, produtos.getMCheck());
                stmt.setDouble(43, produtos.getQdeUnid());
                stmt.setString(44, produtos.getUnidQde());
                stmt.setString(45, produtos.getMEng());
                stmt.setString(46, produtos.getDatEng());
                stmt.setString(47, produtos.getEhKit());
                stmt.setString(48, produtos.getMVal());
                stmt.setString(49, produtos.getDatVal());
                stmt.setDouble(50, produtos.getAltEmb());
                stmt.setDouble(51, produtos.getLarEmb());
                stmt.setDouble(52, produtos.getComEmb());
                stmt.setDouble(53, produtos.getCubEmb());
                stmt.setDouble(54, produtos.getQdeEmb());
                stmt.setString(55, produtos.getObs());
                stmt.setDouble(56, produtos.getAltCorpo());
                stmt.setDouble(57, produtos.getLarCorpo());
                stmt.setDouble(58, produtos.getComCorpo());
                stmt.setDouble(59, produtos.getLitCorpo());
                stmt.setString(61, produtos.getTipoFicha());
                stmt.setBoolean(62, produtos.getMedida());
                stmt.setBoolean(63, produtos.getFicha());
                stmt.setBoolean(64, produtos.getTempo());
                stmt.setBoolean(65, produtos.getInativo());
                stmt.setString(66, produtos.getCipi());
                stmt.setString(67, produtos.getCstipi());
                stmt.setString(68, produtos.getCstpis());
                stmt.setDouble(69, produtos.getPis());
                stmt.setString(70, produtos.getCstcofins());
                stmt.setDouble(71, produtos.getCofins());
                stmt.setString(72, produtos.getOrig());
                stmt.setString(73, produtos.getNcm());
                stmt.setInt(74, produtos.getCavidades());
                stmt.setInt(75, produtos.getLargPlFund());
                stmt.setDouble(76, produtos.getPerda());
                stmt.setDouble(77, produtos.getEspDesb());
                stmt.setInt(78, produtos.getFator());
                stmt.setDouble(79, produtos.getPerdaLarg());
                stmt.setDouble(80, produtos.getNroCorte());
                stmt.setInt(81, produtos.getSeqProd());
                stmt.setInt(82, produtos.getBox());
                stmt.setString(83, produtos.getAndar());
                stmt.setInt(84, produtos.getCodFor());
                stmt.setBoolean(85, produtos.getProdVendaNot());





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

    public int alterar(Produtos produtos) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        PreparedStatement stmt = null;
        int sucesso = 0;
        try {
            stmt = conn
                    .prepareStatement("UPDATE Produtos  SET DesPro = ?, Unid = ?, PesoLiq = ?, PesoBru = ?, SitTrib = ?, Icms = ?, IPI = ?, "
                        + "Frete = ?, ClassFiscal = ?, CustFab = ?, CustEng = ?, CustEnt = ?, CustMed = ?, "
                        + "CustTot = ?, DespFixa = ?, PrVen1 = ?, PrVen2 = ?, PrVen3 = ?, PrVen4 = ?, "
                        + "Tipo = ?, TipoProduto = ?, ProdVenda = ?, MComp = ?, MDiam = ?, MLarg = ?, "
                        + "MEsp = ?, CamTeflon = ?, PesoTeflon = ?, CalArea = ?, EstMinimo = ?, Tamanho = ?, "
                        + "FatorTransf = ?, UltValor = ?, UltCompra = ?, UltCodNat = ?, Ed = ?, MCheck = ?,"
                        + "QdeUnid = ?, UnidQde = ?, MEng = ?, DatEng = ?, EhKit = ?, MVal = ?, DatVal = ?, "
                        + "AltEmb = ?, LarEmb = ?, ComEmb = ?, CubEmb = ?, QdeEmb = ?, Obs = ?, AltCorpo = ?, "
                        + "LarCorpo = ?, ComCorpo = ?, CubCorpo = ?, LitCorpo = ?, TipoFicha = ?, "
                        + "Medida = ?, Ficha = ?, Tempo = ?, Inativo = ?, CIPI = ?, CSTIPI = ?, CSTPIS = ?, "
                        + "PIS = ?, CSTCOFINS = ?, COFINS = ?, ORIG = ?, NCM = ?, Cavidades = ?, LargPlFund = ?, "
                        + "Perda = ?, EspDesb = ?, Fator = ?, PerdaLarg = ?, NroCorte = ?, SeqProd = ?, "
                        + "Box = ?, Andar = ?, CodFor = ?, ProdVendaNot = ?)");
                stmt.setInt(1, produtos.getCodPro());
                stmt.setString(2, produtos.getCodBarra());
                stmt.setInt(3, produtos.getCodGrupo());
                stmt.setInt(4, produtos.getCodSubGrupo());
                stmt.setInt(5, produtos.getCodFabrica());
                stmt.setString(6, produtos.getDesPro());
                stmt.setString(7, produtos.getUnid());
                stmt.setDouble(8, produtos.getPesoLiq());
                stmt.setDouble(9, produtos.getPesoBru());
                stmt.setString(10, produtos.getSitTrib());
                stmt.setDouble(11, produtos.getIcms());
                stmt.setDouble(12, produtos.getIpi());
                stmt.setDouble(13, produtos.getFrete());
                stmt.setString(14, produtos.getClassFiscal());
                stmt.setDouble(15, produtos.getCustFab());
                stmt.setDouble(16, produtos.getCustEng());
                stmt.setBigDecimal(17, produtos.getCustEnt());
                stmt.setDouble(18, produtos.getCustMed());
                stmt.setDouble(19, produtos.getCustTot());
                stmt.setDouble(20, produtos.getDespFixa());
                stmt.setDouble(21, produtos.getPrVen1());
                stmt.setDouble(22, produtos.getPrVen2());
                stmt.setDouble(23, produtos.getPrVen3());
                stmt.setDouble(24, produtos.getPrVen4());
                stmt.setString(25, produtos.getTipo());
                stmt.setString(26, produtos.getTipoProduto());
                stmt.setBoolean(27, produtos.getProdVenda());
                stmt.setDouble(28, produtos.getMComp());
                stmt.setDouble(29, produtos.getMDiam());
                stmt.setDouble(30, produtos.getMLarg());
                stmt.setDouble(31, produtos.getMEsp());
                stmt.setInt(32, produtos.getCamTeflon());
                stmt.setDouble(33, produtos.getPesoTeflon());
                stmt.setDouble(34, produtos.getCalArea());
                stmt.setDouble(35, produtos.getEstMinimo());
                stmt.setString(36, produtos.getTamanho());
                stmt.setBigDecimal(37, produtos.getFatorTransf());
                stmt.setBigDecimal(38, produtos.getUltValor());
                stmt.setString(39, produtos.getUltCompra());
                stmt.setInt(40, produtos.getUltCodNat());
                stmt.setString(41, produtos.getEd());
                stmt.setBoolean(42, produtos.getMCheck());
                stmt.setDouble(43, produtos.getQdeUnid());
                stmt.setString(44, produtos.getUnidQde());
                stmt.setString(45, produtos.getMEng());
                stmt.setString(46, produtos.getDatEng());
                stmt.setString(47, produtos.getEhKit());
                stmt.setString(48, produtos.getMVal());
                stmt.setString(49, produtos.getDatVal());
                stmt.setDouble(50, produtos.getAltEmb());
                stmt.setDouble(51, produtos.getLarEmb());
                stmt.setDouble(52, produtos.getComEmb());
                stmt.setDouble(53, produtos.getCubEmb());
                stmt.setDouble(54, produtos.getQdeEmb());
                stmt.setString(55, produtos.getObs());
                stmt.setDouble(56, produtos.getAltCorpo());
                stmt.setDouble(57, produtos.getLarCorpo());
                stmt.setDouble(58, produtos.getComCorpo());
                stmt.setDouble(59, produtos.getLitCorpo());
                stmt.setString(61, produtos.getTipoFicha());
                stmt.setBoolean(62, produtos.getMedida());
                stmt.setBoolean(63, produtos.getFicha());
                stmt.setBoolean(64, produtos.getTempo());
                stmt.setBoolean(65, produtos.getInativo());
                stmt.setString(66, produtos.getCipi());
                stmt.setString(67, produtos.getCstipi());
                stmt.setString(68, produtos.getCstpis());
                stmt.setDouble(69, produtos.getPis());
                stmt.setString(70, produtos.getCstcofins());
                stmt.setDouble(71, produtos.getCofins());
                stmt.setString(72, produtos.getOrig());
                stmt.setString(73, produtos.getNcm());
                stmt.setInt(74, produtos.getCavidades());
                stmt.setInt(75, produtos.getLargPlFund());
                stmt.setDouble(76, produtos.getPerda());
                stmt.setDouble(77, produtos.getEspDesb());
                stmt.setInt(78, produtos.getFator());
                stmt.setDouble(79, produtos.getPerdaLarg());
                stmt.setDouble(80, produtos.getNroCorte());
                stmt.setInt(81, produtos.getSeqProd());
                stmt.setInt(82, produtos.getBox());
                stmt.setString(83, produtos.getAndar());
                stmt.setInt(84, produtos.getCodFor());
                stmt.setBoolean(85, produtos.getProdVendaNot());
                
            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("PRODUTOS ALTERADO!");
            } else {
                System.out.println("PRODUTOS NÃO EXISTE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO ALTERAR PRODUTOS!");
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
            stmt = conn.prepareStatement("DELETE FROM Produtos WHERE CodPro = ?");
            stmt.setInt(1, id);
            excluidos = stmt.executeUpdate();

            if (excluidos > 0) {
                System.out.println("PRODUTOS REMOVIDO!");
            } else {
                System.out.println("PRODUTOS NÃO EXISTE!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO DELETAR PRODUTOS!");
        } finally {
            closeConnection(conn, stmt);
        }
        return excluidos;
    }

    public Produtos buscar(int id) throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        Produtos produtos = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Produtos WHERE CodPro = ?");
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {




                produtos = new Produtos();
                produtos.setCodPro(resultSet.getInt("CodPro"));
                produtos.setCodBarra(resultSet.getString("CodBarra"));
                produtos.setCodGrupo(resultSet.getInt("CodGrupo"));
                produtos.setCodSubGrupo(resultSet.getInt("CodSubGrupo"));
                produtos.setCodFabrica(resultSet.getInt("CodFabrica"));
                produtos.setDesPro(resultSet.getString("DesPro"));
                produtos.setUnid(resultSet.getString("Unid"));
                produtos.setPesoLiq(resultSet.getDouble("PesoLiq"));
                produtos.setPesoBru(resultSet.getDouble("PesoBru"));
                produtos.setSitTrib(resultSet.getString("SitTrib"));
                produtos.setIcms(resultSet.getDouble("Icms"));
                produtos.setIpi(resultSet.getDouble("IPI"));
                produtos.setFrete(resultSet.getDouble("Frete"));
                produtos.setClassFiscal(resultSet.getString("ClassFiscal"));
                produtos.setCustFab(resultSet.getDouble("CustFab"));
                produtos.setCustEng(resultSet.getDouble("CustEng"));
                produtos.setCustEnt(resultSet.getBigDecimal("CustEnt"));
                produtos.setCustMed(resultSet.getDouble("CustMed"));
                produtos.setCustTot(resultSet.getDouble("CustTot"));
                produtos.setDespFixa(resultSet.getDouble("DespFixa"));
                produtos.setPrVen1(resultSet.getDouble("PrVen1"));
                produtos.setPrVen2(resultSet.getDouble("PrVen2"));
                produtos.setPrVen3(resultSet.getDouble("PrVen3"));
                produtos.setPrVen4(resultSet.getDouble("PrVen4"));
                produtos.setTipo(resultSet.getString("Tipo"));
                produtos.setTipoProduto(resultSet.getString("TipoProduto"));
                produtos.setProdVenda(resultSet.getBoolean("ProdVenda"));
                produtos.setMComp(resultSet.getDouble("MComp"));
                produtos.setMDiam(resultSet.getDouble("MDiam"));
                produtos.setMLarg(resultSet.getDouble("MLarg"));
                produtos.setMEsp(resultSet.getDouble("MEsp"));
                produtos.setCamTeflon(resultSet.getInt("CamTeflon"));
                produtos.setPesoTeflon(resultSet.getDouble("PesoTeflon"));
                produtos.setCalArea(resultSet.getDouble("CalArea"));
                produtos.setEstMinimo(resultSet.getDouble("EstMinimo"));
                produtos.setTamanho(resultSet.getString("Tamanho"));
                produtos.setFatorTransf(resultSet.getBigDecimal("FatorTransf"));
                produtos.setUltValor(resultSet.getBigDecimal("UltValor"));
                produtos.setUltCompra(resultSet.getString("UltCompra"));
                produtos.setUltCodNat(resultSet.getInt("UltCodNat"));
                produtos.setEd(resultSet.getString("Ed"));
                produtos.setMCheck(resultSet.getBoolean("MCheck"));
                produtos.setQdeUnid(resultSet.getDouble("QdeUnid"));
                produtos.setUnidQde(resultSet.getString("UnidQde"));
                produtos.setMEng(resultSet.getString("MEng"));
                produtos.setDatEng(resultSet.getString("DatEng"));
                produtos.setEhKit(resultSet.getString("EhKit"));
                produtos.setMVal(resultSet.getString("MVal"));
                produtos.setDatVal(resultSet.getString("DatVal"));
                produtos.setAltEmb(resultSet.getDouble("AltEmb"));
                produtos.setLarEmb(resultSet.getDouble("LarEmb"));
                produtos.setComEmb(resultSet.getDouble("ComEmb"));
                produtos.setCubEmb(resultSet.getDouble("CubEmb"));
                produtos.setQdeEmb(resultSet.getDouble("QdeEmb"));
                produtos.setObs(resultSet.getString("Obs"));
                produtos.setAltCorpo(resultSet.getDouble("AltCorpo"));
                produtos.setLarCorpo(resultSet.getDouble("LarCorpo"));
                produtos.setComCorpo(resultSet.getDouble("ComCorpo"));
                produtos.setCubCorpo(resultSet.getDouble("CubCorpo"));
                produtos.setLitCorpo(resultSet.getDouble("LitCorpo"));
                produtos.setTipoFicha(resultSet.getString("TipoFicha"));
                produtos.setMedida(resultSet.getBoolean("Medida"));
                produtos.setFicha(resultSet.getBoolean("Ficha"));
                produtos.setTempo(resultSet.getBoolean("Tempo"));
                produtos.setInativo(resultSet.getBoolean("Inativo"));
                produtos.setCipi(resultSet.getString("CIPI"));
                produtos.setCstipi(resultSet.getString("CSTIPI"));
                produtos.setCstpis(resultSet.getString("CSTPIS"));
                produtos.setPis(resultSet.getDouble("PIS"));
                produtos.setCstcofins(resultSet.getString("CSTCOFINS"));
                produtos.setCofins(resultSet.getDouble("COFINS"));
                produtos.setOrig(resultSet.getString("ORIG"));
                produtos.setNcm(resultSet.getString("NCM"));
                produtos.setCavidades(resultSet.getInt("Cavidades"));
                produtos.setLargPlFund(resultSet.getInt("LargPlFund"));
                produtos.setPerda(resultSet.getDouble("Perda"));
                produtos.setEspDesb(resultSet.getDouble("EspDesb"));
                produtos.setFator(resultSet.getInt("Fator"));
                produtos.setPerdaLarg(resultSet.getDouble("PerdaLarg"));
                produtos.setNroCorte(resultSet.getDouble("NroCorte"));
                produtos.setBox(resultSet.getInt("BoxProd"));
                produtos.setAndar(resultSet.getString("Andar"));
                produtos.setCodFor(resultSet.getInt("CodFor"));
                produtos.setProdVendaNot(resultSet.getBoolean("ProdVendaNot"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return produtos;
    }

    public ArrayList<Produtos> buscarTodos() throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ArrayList<Produtos> listaProdutos = null;

        try {

            stmt = conn.prepareStatement("SELECT * FROM Produtos ORDER BY CodPro");
            resultSet = stmt.executeQuery();
            listaProdutos = new ArrayList<Produtos>();

            while (resultSet.next()) {
                Produtos produtos = new Produtos();
                produtos.setCodPro(resultSet.getInt("CodPro"));
                produtos.setCodBarra(resultSet.getString("CodBarra"));
                produtos.setCodGrupo(resultSet.getInt("CodGrupo"));
                produtos.setCodSubGrupo(resultSet.getInt("CodSubGrupo"));
                produtos.setCodFabrica(resultSet.getInt("CodFabrica"));
                produtos.setDesPro(resultSet.getString("DesPro"));
                produtos.setUnid(resultSet.getString("Unid"));
                produtos.setPesoLiq(resultSet.getDouble("PesoLiq"));
                produtos.setPesoBru(resultSet.getDouble("PesoBru"));
                produtos.setSitTrib(resultSet.getString("SitTrib"));
                produtos.setIcms(resultSet.getDouble("Icms"));
                produtos.setIpi(resultSet.getDouble("IPI"));
                produtos.setFrete(resultSet.getDouble("Frete"));
                produtos.setClassFiscal(resultSet.getString("ClassFiscal"));
                produtos.setCustFab(resultSet.getDouble("CustFab"));
                produtos.setCustEng(resultSet.getDouble("CustEng"));
                produtos.setCustEnt(resultSet.getBigDecimal("CustEnt"));
                produtos.setCustMed(resultSet.getDouble("CustMed"));
                produtos.setCustTot(resultSet.getDouble("CustTot"));
                produtos.setDespFixa(resultSet.getDouble("DespFixa"));
                produtos.setPrVen1(resultSet.getDouble("PrVen1"));
                produtos.setPrVen2(resultSet.getDouble("PrVen2"));
                produtos.setPrVen3(resultSet.getDouble("PrVen3"));
                produtos.setPrVen4(resultSet.getDouble("PrVen4"));
                produtos.setTipo(resultSet.getString("Tipo"));
                produtos.setTipoProduto(resultSet.getString("TipoProduto"));
                produtos.setProdVenda(resultSet.getBoolean("ProdVenda"));
                produtos.setMComp(resultSet.getDouble("MComp"));
                produtos.setMDiam(resultSet.getDouble("MDiam"));
                produtos.setMLarg(resultSet.getDouble("MLarg"));
                produtos.setMEsp(resultSet.getDouble("MEsp"));
                produtos.setCamTeflon(resultSet.getInt("CamTeflon"));
                produtos.setPesoTeflon(resultSet.getDouble("PesoTeflon"));
                produtos.setCalArea(resultSet.getDouble("CalArea"));
                produtos.setEstMinimo(resultSet.getDouble("EstMinimo"));
                produtos.setTamanho(resultSet.getString("Tamanho"));
                produtos.setFatorTransf(resultSet.getBigDecimal("FatorTransf"));
                produtos.setUltValor(resultSet.getBigDecimal("UltValor"));
                produtos.setUltCompra(resultSet.getString("UltCompra"));
                produtos.setUltCodNat(resultSet.getInt("UltCodNat"));
                produtos.setEd(resultSet.getString("Ed"));
                produtos.setMCheck(resultSet.getBoolean("MCheck"));
                produtos.setQdeUnid(resultSet.getDouble("QdeUnid"));
                produtos.setUnidQde(resultSet.getString("UnidQde"));
                produtos.setMEng(resultSet.getString("MEng"));
                produtos.setDatEng(resultSet.getString("DatEng"));
                produtos.setEhKit(resultSet.getString("EhKit"));
                produtos.setMVal(resultSet.getString("MVal"));
                produtos.setDatVal(resultSet.getString("DatVal"));
                produtos.setAltEmb(resultSet.getDouble("AltEmb"));
                produtos.setLarEmb(resultSet.getDouble("LarEmb"));
                produtos.setComEmb(resultSet.getDouble("ComEmb"));
                produtos.setCubEmb(resultSet.getDouble("CubEmb"));
                produtos.setQdeEmb(resultSet.getDouble("QdeEmb"));
                produtos.setObs(resultSet.getString("Obs"));
                produtos.setAltCorpo(resultSet.getDouble("AltCorpo"));
                produtos.setLarCorpo(resultSet.getDouble("LarCorpo"));
                produtos.setComCorpo(resultSet.getDouble("ComCorpo"));
                produtos.setCubCorpo(resultSet.getDouble("CubCorpo"));
                produtos.setLitCorpo(resultSet.getDouble("LitCorpo"));
                produtos.setTipoFicha(resultSet.getString("TipoFicha"));
                produtos.setMedida(resultSet.getBoolean("Medida"));
                produtos.setFicha(resultSet.getBoolean("Ficha"));
                produtos.setTempo(resultSet.getBoolean("Tempo"));
                produtos.setInativo(resultSet.getBoolean("Inativo"));
                produtos.setCipi(resultSet.getString("CIPI"));
                produtos.setCstipi(resultSet.getString("CSTIPI"));
                produtos.setCstpis(resultSet.getString("CSTPIS"));
                produtos.setPis(resultSet.getDouble("PIS"));
                produtos.setCstcofins(resultSet.getString("CSTCOFINS"));
                produtos.setCofins(resultSet.getDouble("COFINS"));
                produtos.setOrig(resultSet.getString("ORIG"));
                produtos.setNcm(resultSet.getString("NCM"));
                produtos.setCavidades(resultSet.getInt("Cavidades"));
                produtos.setLargPlFund(resultSet.getInt("LargPlFund"));
                produtos.setPerda(resultSet.getDouble("Perda"));
                produtos.setEspDesb(resultSet.getDouble("EspDesb"));
                produtos.setFator(resultSet.getInt("Fator"));
                produtos.setPerdaLarg(resultSet.getDouble("PerdaLarg"));
                produtos.setNroCorte(resultSet.getDouble("NroCorte"));
                produtos.setBox(resultSet.getInt("BoxProd"));
                produtos.setAndar(resultSet.getString("Andar"));
                produtos.setCodFor(resultSet.getInt("CodFor"));
                produtos.setProdVendaNot(resultSet.getBoolean("ProdVendaNot"));


                listaProdutos.add(produtos);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            listaProdutos = null;
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return listaProdutos;
    }
}
