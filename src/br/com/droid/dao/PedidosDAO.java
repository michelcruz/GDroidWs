package br.com.droid.dao;

import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosDAO extends ConnectionFactory {

    public int verificaCadastrado(Integer CodPed) throws ClassNotFoundException {

        int id = 0;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        try {
            stmt = conn
                    .prepareStatement("SELECT CodPed FROM Pedidos WHERE CodPed = ?");
            stmt.setInt(1, CodPed);
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

    public int inserir(Pedidos pedidos) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        int sucesso = 0;
        int prodsCadastrados = verificaCadastrado(pedidos.getCodPed());

        if (prodsCadastrados == 0) {
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("INSERT INTO Produtos("
                        + "CodPed, SPed, DataPed, DataEmi, DataSai, CodTpo,"
                        + "CodCli, CodVen, CodTra, PerDes1, PerDes2, PerDes3, "
                        + "NroCarga, OrdPed, SeqEntrega, Transf, PerSem, Tab, "
                        + "Vol, Volume, TipCob, TotPed, TotPro, TotDes, TotBruto,"
                        + "TotFrete, TotBonif, TotBrinde, TotBonifB, TotBrindeB, "
                        + "ValIPI, BaseIcmsCom, ValIcmsCom, PesoLiq, PesoBru, "
                        + "TotLan, TotPec, TotIpi, BasIpi, BasIseIpi, TotCofins, "
                        + "BasCofins, BaseIseCofins, ValSubIcms, BasSubIcms, DescSuf, "
                        + "DescIcms, BaseIcms, ValIcms, TotNota, TotProCom, TotProSem,"
                        + "ValIPICom, CanPed, DataCan, MotCan, Frete, Quant, "
                        + "Especie, Marca, NF2Fec, DT2Fec, NtfPed, DatFec, Emitido, "
                        + "DatCon, Alerta, SeqRelacao, DatRelacao, LComissao, "
                        + "LVenda, LPrUnit, PComissao, PVenda, AlteraParam, AlteraMarg, "
                        + "Cofins, Pis, Irpj, Invest, Finan, Inad, DProm, "
                        + "DMark, Perdas, Frota, Margem, Status, Men1, Men2, "
                        + "Men3, Men4, Men5, Men6, TipIPI, TipST, ObsCarreg, "
                        + "NR1DUP, VL1DUP, VL1S, VL1C, DV1DUP, NR2DUP, VL2DUP, "
                        + "VL2S, VL2C, DV2DUP, NR3DUP, VL3DUP, VL3S, VL3C,"
                        + "DV3DUP, NR4DUP, VL4DUP, VL4S, VL4C, DV4DUP, NR5DUP, "
                        + "VL5DUP, VL5S, VL5C, DV5DUP, NR6DUP, VL6DUP, VL6S,"
                        + "VL6C, DV6DUP, Conferido, DatConferido, DatConfFim, "
                        + "CodConf, NotaAceita, DupAceita, FoiDevolvido, ValDesconto, "
                        + "ValDevolvido, ValFaltas, ValCheque, ValDup, ValCarteira,"
                        + "ValDinheiro, ValDif, ValDeposito, TotalAcerto, ModCond, "
                        + "CodNatAcerto, TipCobAcerto, ObsAcerto, Baixado, DataBaixa, "
                        + "DataEntrega, CodNotaDev, MT1Ped, MT2Ped, PerPeso, MCom, "
                        + "DtCom, EmiNot, NroLote, LibGrup)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,);");
                stmt.setInt(1, pedidos.getSPed());
                stmt.setString(2, pedidos.getDataPed());
                stmt.setString(3, pedidos.getDataEmi());
                stmt.setString(4, pedidos.getDataSai());
                stmt.setInt(5, pedidos.getCodTpo());
                stmt.setInt(6, pedidos.getCodCli());
                stmt.setInt(7, pedidos.getCodVen());
                stmt.setDouble(8, pedidos.getCodTra());
                stmt.setDouble(9, pedidos.getPerDes1());
                stmt.setDouble(10, pedidos.getPerDes2());
                stmt.setDouble(11, pedidos.getPerDes3());
                stmt.setDouble(12, pedidos.getNroCarga());
                stmt.setDouble(13, pedidos.getOrdPed());
                stmt.setDouble(14, pedidos.getSeqEntrega());
                stmt.setString(15, pedidos.getTransf());
                stmt.setDouble(16, pedidos.getPerSem());
                stmt.setInt(17, pedidos.getTab());
                stmt.setInt(18, pedidos.getVol());
                stmt.setString(19, pedidos.getVolume());
                stmt.setString(20, pedidos.getTipCob());
                stmt.setDouble(21, pedidos.getTotPed());
                stmt.setDouble(22, pedidos.getTotPro());
                stmt.setDouble(23, pedidos.getTotDes());
                stmt.setDouble(24, pedidos.getTotBruto());
                stmt.setDouble(25, pedidos.getTotFrete());
                stmt.setDouble(26, pedidos.getTotBonif());
                stmt.setDouble(27, pedidos.getTotBrinde());
                stmt.setDouble(28, pedidos.getTotBonifB());
                stmt.setDouble(29, pedidos.getTotBrindeB());
                stmt.setDouble(30, pedidos.getValIPI());
                stmt.setDouble(31, pedidos.getBaseIcmsCom());
                stmt.setDouble(32, pedidos.getValIcmsCom());
                stmt.setDouble(33, pedidos.getPesoLiq());
                stmt.setDouble(34, pedidos.getPesoBru());
                stmt.setInt(35, pedidos.getTotLan());
                stmt.setDouble(36, pedidos.getTotPec());
                stmt.setDouble(37, pedidos.getTotIpi());
                stmt.setDouble(38, pedidos.getBasIpi());
                stmt.setDouble(39, pedidos.getBasIseIpi());
                stmt.setDouble(40, pedidos.getTotCofins());
                stmt.setDouble(41, pedidos.getBasCofins());
                stmt.setDouble(42, pedidos.getBaseIseCofins());
                stmt.setDouble(43, pedidos.getValSubIcms());
                stmt.setDouble(44, pedidos.getBasSubIcms());
                stmt.setDouble(45, pedidos.getDescSuf());
                stmt.setDouble(46, pedidos.getDescIcms());
                stmt.setDouble(47, pedidos.getBaseIcms());
                stmt.setDouble(48, pedidos.getValIcms());
                stmt.setDouble(49, pedidos.getTotNota());
                stmt.setDouble(50, pedidos.getTotProCom());
                stmt.setDouble(51, pedidos.getTotProSem());
                stmt.setDouble(52, pedidos.getValIPICom());
                stmt.setString(53, pedidos.getCanPed());
                stmt.setString(54, pedidos.getDataCan());
                stmt.setString(55, pedidos.getMotCan());
                stmt.setString(56, pedidos.getFrete());
                stmt.setDouble(57, pedidos.getQuant());
                stmt.setString(58, pedidos.getEspecie());
                stmt.setString(59, pedidos.getMarca());
                stmt.setInt(60, pedidos.getNF2Fec());
                stmt.setString(61, pedidos.getDT2Fec());
                stmt.setInt(62, pedidos.getNtfPed());
                stmt.setString(63, pedidos.getDatFec());
                stmt.setString(64, pedidos.getEmitido());
                stmt.setString(65, pedidos.getDatCon());
                stmt.setString(66, pedidos.getAlerta());
                stmt.setInt(67, pedidos.getSeqRelacao());
                stmt.setString(68, pedidos.getDatRelacao());
                stmt.setDouble(69, pedidos.getLComissao());
                stmt.setDouble(70, pedidos.getLVenda());
                stmt.setDouble(71, pedidos.getLPrUnit());
                stmt.setDouble(72, pedidos.getPComissao());
                stmt.setDouble(73, pedidos.getPVenda());
                stmt.setString(74, pedidos.getAlteraParam());
                stmt.setString(75, pedidos.getAlteraMarg());
                stmt.setDouble(76, pedidos.getCofins());
                stmt.setDouble(77, pedidos.getPis());
                stmt.setDouble(78, pedidos.getIrpj());
                stmt.setDouble(79, pedidos.getInvest());
                stmt.setDouble(70, pedidos.getFinan());
                stmt.setDouble(71, pedidos.getInad());
                stmt.setDouble(72, pedidos.getDProm());
                stmt.setDouble(73, pedidos.getDMark());
                stmt.setDouble(74, pedidos.getPerdas());
                stmt.setDouble(75, pedidos.getFrota());
                stmt.setDouble(76, pedidos.getMargem());
                stmt.setString(77, pedidos.getStatus());
                stmt.setString(78, pedidos.getMen1());
                stmt.setString(79, pedidos.getMen2());
                stmt.setString(80, pedidos.getMen3());
                stmt.setString(81, pedidos.getMen4());
                stmt.setString(82, pedidos.getMen5());
                stmt.setString(83, pedidos.getMen6());
                stmt.setString(84, pedidos.getTipIPI());
                stmt.setString(85, pedidos.getTipST());
                stmt.setString(86, pedidos.getObsCarreg());
                stmt.setString(87, pedidos.getNr1dup());
                stmt.setDouble(88, pedidos.getVl1dup());
                stmt.setDouble(89, pedidos.getVl1s());
                stmt.setDouble(90, pedidos.getVl1c());
                stmt.setString(91, pedidos.getNr2dup());
                stmt.setDouble(92, pedidos.getVl2dup());
                stmt.setDouble(93, pedidos.getVl2s());
                stmt.setDouble(94, pedidos.getVl2c());
                stmt.setString(95, pedidos.getDv2dup());
                stmt.setString(96, pedidos.getNr3dup());
                stmt.setDouble(97, pedidos.getVl3dup());
                stmt.setDouble(98, pedidos.getVl3s());
                stmt.setDouble(99, pedidos.getVl3c());
                stmt.setString(100, pedidos.getDv3dup());
                stmt.setString(101, pedidos.getNr4dup());
                stmt.setDouble(102, pedidos.getVl4dup());
                stmt.setDouble(103, pedidos.getVl4s());
                stmt.setDouble(104, pedidos.getVl4c());
                stmt.setString(105, pedidos.getDv4dup());
                stmt.setString(106, pedidos.getNr5dup());
                stmt.setDouble(107, pedidos.getVl5dup());
                stmt.setDouble(108, pedidos.getVl5s());
                stmt.setDouble(109, pedidos.getVl5c());
                stmt.setString(110, pedidos.getDv5dup());
                stmt.setString(111, pedidos.getNr5dup());
                stmt.setDouble(112, pedidos.getVl6s());
                stmt.setDouble(113, pedidos.getVl6c());
                stmt.setString(114, pedidos.getDv6dup());
                stmt.setString(115, pedidos.getConferido());
                stmt.setString(116, pedidos.getDatConferido());
                stmt.setString(117, pedidos.getDatConfFim());
                stmt.setInt(118, pedidos.getCodConf());
                stmt.setString(119, pedidos.getNotaAceita());
                stmt.setString(120, pedidos.getDupAceita());
                stmt.setString(121, pedidos.getFoiDevolvido());
                stmt.setDouble(122, pedidos.getValDesconto());
                stmt.setDouble(123, pedidos.getValDevolvido());
                stmt.setDouble(124, pedidos.getValFaltas());
                stmt.setDouble(125, pedidos.getValCheque());
                stmt.setDouble(126, pedidos.getValDup());
                stmt.setDouble(127, pedidos.getValCarteira());
                stmt.setDouble(128, pedidos.getValFaltas());
                stmt.setDouble(129, pedidos.getValCheque());
                stmt.setDouble(130, pedidos.getValDup());
                stmt.setDouble(131, pedidos.getValCarteira());
                stmt.setDouble(132, pedidos.getValDinheiro());
                stmt.setDouble(133, pedidos.getValDif());
                stmt.setDouble(134, pedidos.getValDeposito());
                stmt.setDouble(135, pedidos.getTotalAcerto());
                stmt.setString(136, pedidos.getModCond());
                stmt.setInt(137, pedidos.getCodNatAcerto());
                stmt.setString(138, pedidos.getTipCobAcerto());
                stmt.setString(139, pedidos.getObsAcerto());
                stmt.setString(140, pedidos.getBaixado());
                stmt.setString(141, pedidos.getDataBaixa());
                stmt.setString(142, pedidos.getDataEntrega());
                stmt.setInt(143, pedidos.getCodNotaDev());
                stmt.setString(144, pedidos.getMT1Ped());
                stmt.setString(145, pedidos.getMT2Ped());
                stmt.setDouble(146, pedidos.getPerPeso());
                stmt.setString(147, pedidos.getMCom());
                stmt.setString(148, pedidos.getDtCom());
                stmt.setString(149, pedidos.getEmiNot());
                stmt.setInt(150, pedidos.getNroLote());
                stmt.setString(151, pedidos.getLibGrup());






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

    public int alterar(Pedidos pedidos) throws ClassNotFoundException {

        Connection conn = null;
        conn = getConnection();
        PreparedStatement stmt = null;
        int sucesso = 0;
        try {
            stmt = conn
                    .prepareStatement("UPDATE Produtos  SET "
                    + "CodPed = ?, SPed = ?, DataPed = ?, DataEmi = ?, DataSai = ?, CodTpo = ?,"
                    + "CodCli = ?, CodVen = ?, CodTra = ?, PerDes1 = ?, PerDes2 = ?, PerDes3 = ?, "
                    + "NroCarga = ?, OrdPed = ?, SeqEntrega = ?, Transf = ?, PerSem = ?, Tab = ?, "
                    + "Vol = ?, Volume = ?, TipCob = ?, TotPed = ?, TotPro = ?, TotDes = ?, TotBruto = ?,"
                    + "TotFrete = ?, TotBonif = ?, TotBrinde = ?, TotBonifB = ?, TotBrindeB = ?, "
                    + "ValIPI = ?, BaseIcmsCom = ?, ValIcmsCom = ?, PesoLiq = ?, PesoBru = ?, "
                    + "TotLan = ?, TotPec = ?, TotIpi = ?, BasIpi = ?, BasIseIpi = ?, TotCofins = ?, "
                    + "BasCofins = ?, BaseIseCofins = ?, ValSubIcms = ?, BasSubIcms = ?, DescSuf = ?, "
                    + "DescIcms = ?, BaseIcms = ?, ValIcms = ?, TotNota = ?, TotProCom = ?, TotProSem = ?,"
                    + "ValIPICom = ?, CanPed = ?, DataCan = ?, MotCan = ?, Frete = ?, Quant = ?, "
                    + "Especie = ?, Marca = ?, NF2Fec = ?, DT2Fec = ?, NtfPed = ?, DatFec = ?, Emitido = ?, "
                    + "DatCon = ?, Alerta = ?, SeqRelacao = ?, DatRelacao = ?, LComissao = ?, "
                    + "LVenda = ?, LPrUnit = ?, PComissao = ?, PVenda = ?, AlteraParam = ?, AlteraMarg = ?, "
                    + "Cofins = ?, Pis = ?, Irpj = ?, Invest = ?, Finan = ?, Inad = ?, DProm = ?, "
                    + "DMark = ?, Perdas = ?, Frota = ?, Margem = ?, Status = ?, Men1 = ?, Men2 = ?, "
                    + "Men3 = ?, Men4 = ?, Men5 = ?, Men6 = ?, TipIPI = ?, TipST = ?, ObsCarreg = ?, "
                    + "NR1DUP = ?, VL1DUP = ?, VL1S = ?, VL1C = ?, DV1DUP = ?, NR2DUP = ?, VL2DUP = ?, "
                    + "VL2S = ?, VL2C = ?, DV2DUP = ?, NR3DUP = ?, VL3DUP = ?, VL3S = ?, VL3C = ?,"
                    + "DV3DUP = ?, NR4DUP = ?, VL4DUP = ?, VL4S = ?, VL4C = ?, DV4DUP = ?, NR5DUP = ?, "
                    + "VL5DUP = ?, VL5S = ?, VL5C = ?, DV5DUP = ?, NR6DUP = ?, VL6DUP = ?, VL6S = ?,"
                    + "VL6C = ?, DV6DUP = ?, Conferido = ?, DatConferido = ?, DatConfFim = ?, "
                    + "CodConf = ?, NotaAceita = ?, DupAceita = ?, FoiDevolvido = ?, ValDesconto = ?, "
                    + "ValDevolvido = ?, ValFaltas = ?, ValCheque = ?, ValDup = ?, ValCarteira = ?,"
                    + "ValDinheiro = ?, ValDif = ?, ValDeposito = ?, TotalAcerto = ?, ModCond = ?, "
                    + "CodNatAcerto = ?, TipCobAcerto = ?, ObsAcerto = ?, Baixado = ?, DataBaixa = ?, "
                    + "DataEntrega = ?, CodNotaDev = ?, MT1Ped = ?, MT2Ped = ?, PerPeso = ?, MCom = ?, "
                    + "DtCom = ?, EmiNot = ?, NroLote = ?, LibGrup = ?)");
            stmt.setInt(1, pedidos.getSPed());
            stmt.setString(2, pedidos.getDataPed());
            stmt.setString(3, pedidos.getDataEmi());
            stmt.setString(4, pedidos.getDataSai());
            stmt.setInt(5, pedidos.getCodTpo());
            stmt.setInt(6, pedidos.getCodCli());
            stmt.setInt(7, pedidos.getCodVen());
            stmt.setDouble(8, pedidos.getCodTra());
            stmt.setDouble(9, pedidos.getPerDes1());
            stmt.setDouble(10, pedidos.getPerDes2());
            stmt.setDouble(11, pedidos.getPerDes3());
            stmt.setDouble(12, pedidos.getNroCarga());
            stmt.setDouble(13, pedidos.getOrdPed());
            stmt.setDouble(14, pedidos.getSeqEntrega());
            stmt.setString(15, pedidos.getTransf());
            stmt.setDouble(16, pedidos.getPerSem());
            stmt.setInt(17, pedidos.getTab());
            stmt.setInt(18, pedidos.getVol());
            stmt.setString(19, pedidos.getVolume());
            stmt.setString(20, pedidos.getTipCob());
            stmt.setDouble(21, pedidos.getTotPed());
            stmt.setDouble(22, pedidos.getTotPro());
            stmt.setDouble(23, pedidos.getTotDes());
            stmt.setDouble(24, pedidos.getTotBruto());
            stmt.setDouble(25, pedidos.getTotFrete());
            stmt.setDouble(26, pedidos.getTotBonif());
            stmt.setDouble(27, pedidos.getTotBrinde());
            stmt.setDouble(28, pedidos.getTotBonifB());
            stmt.setDouble(29, pedidos.getTotBrindeB());
            stmt.setDouble(30, pedidos.getValIPI());
            stmt.setDouble(31, pedidos.getBaseIcmsCom());
            stmt.setDouble(32, pedidos.getValIcmsCom());
            stmt.setDouble(33, pedidos.getPesoLiq());
            stmt.setDouble(34, pedidos.getPesoBru());
            stmt.setInt(35, pedidos.getTotLan());
            stmt.setDouble(36, pedidos.getTotPec());
            stmt.setDouble(37, pedidos.getTotIpi());
            stmt.setDouble(38, pedidos.getBasIpi());
            stmt.setDouble(39, pedidos.getBasIseIpi());
            stmt.setDouble(40, pedidos.getTotCofins());
            stmt.setDouble(41, pedidos.getBasCofins());
            stmt.setDouble(42, pedidos.getBaseIseCofins());
            stmt.setDouble(43, pedidos.getValSubIcms());
            stmt.setDouble(44, pedidos.getBasSubIcms());
            stmt.setDouble(45, pedidos.getDescSuf());
            stmt.setDouble(46, pedidos.getDescIcms());
            stmt.setDouble(47, pedidos.getBaseIcms());
            stmt.setDouble(48, pedidos.getValIcms());
            stmt.setDouble(49, pedidos.getTotNota());
            stmt.setDouble(50, pedidos.getTotProCom());
            stmt.setDouble(51, pedidos.getTotProSem());
            stmt.setDouble(52, pedidos.getValIPICom());
            stmt.setString(53, pedidos.getCanPed());
            stmt.setString(54, pedidos.getDataCan());
            stmt.setString(55, pedidos.getMotCan());
            stmt.setString(56, pedidos.getFrete());
            stmt.setDouble(57, pedidos.getQuant());
            stmt.setString(58, pedidos.getEspecie());
            stmt.setString(59, pedidos.getMarca());
            stmt.setInt(60, pedidos.getNF2Fec());
            stmt.setString(61, pedidos.getDT2Fec());
            stmt.setInt(62, pedidos.getNtfPed());
            stmt.setString(63, pedidos.getDatFec());
            stmt.setString(64, pedidos.getEmitido());
            stmt.setString(65, pedidos.getDatCon());
            stmt.setString(66, pedidos.getAlerta());
            stmt.setInt(67, pedidos.getSeqRelacao());
            stmt.setString(68, pedidos.getDatRelacao());
            stmt.setDouble(69, pedidos.getLComissao());
            stmt.setDouble(70, pedidos.getLVenda());
            stmt.setDouble(71, pedidos.getLPrUnit());
            stmt.setDouble(72, pedidos.getPComissao());
            stmt.setDouble(73, pedidos.getPVenda());
            stmt.setString(74, pedidos.getAlteraParam());
            stmt.setString(75, pedidos.getAlteraMarg());
            stmt.setDouble(76, pedidos.getCofins());
            stmt.setDouble(77, pedidos.getPis());
            stmt.setDouble(78, pedidos.getIrpj());
            stmt.setDouble(79, pedidos.getInvest());
            stmt.setDouble(70, pedidos.getFinan());
            stmt.setDouble(71, pedidos.getInad());
            stmt.setDouble(72, pedidos.getDProm());
            stmt.setDouble(73, pedidos.getDMark());
            stmt.setDouble(74, pedidos.getPerdas());
            stmt.setDouble(75, pedidos.getFrota());
            stmt.setDouble(76, pedidos.getMargem());
            stmt.setString(77, pedidos.getStatus());
            stmt.setString(78, pedidos.getMen1());
            stmt.setString(79, pedidos.getMen2());
            stmt.setString(80, pedidos.getMen3());
            stmt.setString(81, pedidos.getMen4());
            stmt.setString(82, pedidos.getMen5());
            stmt.setString(83, pedidos.getMen6());
            stmt.setString(84, pedidos.getTipIPI());
            stmt.setString(85, pedidos.getTipST());
            stmt.setString(86, pedidos.getObsCarreg());
            stmt.setString(87, pedidos.getNr1dup());
            stmt.setDouble(88, pedidos.getVl1dup());
            stmt.setDouble(89, pedidos.getVl1s());
            stmt.setDouble(90, pedidos.getVl1c());
            stmt.setString(91, pedidos.getNr2dup());
            stmt.setDouble(92, pedidos.getVl2dup());
            stmt.setDouble(93, pedidos.getVl2s());
            stmt.setDouble(94, pedidos.getVl2c());
            stmt.setString(95, pedidos.getDv2dup());
            stmt.setString(96, pedidos.getNr3dup());
            stmt.setDouble(97, pedidos.getVl3dup());
            stmt.setDouble(98, pedidos.getVl3s());
            stmt.setDouble(99, pedidos.getVl3c());
            stmt.setString(100, pedidos.getDv3dup());
            stmt.setString(101, pedidos.getNr4dup());
            stmt.setDouble(102, pedidos.getVl4dup());
            stmt.setDouble(103, pedidos.getVl4s());
            stmt.setDouble(104, pedidos.getVl4c());
            stmt.setString(105, pedidos.getDv4dup());
            stmt.setString(106, pedidos.getNr5dup());
            stmt.setDouble(107, pedidos.getVl5dup());
            stmt.setDouble(108, pedidos.getVl5s());
            stmt.setDouble(109, pedidos.getVl5c());
            stmt.setString(110, pedidos.getDv5dup());
            stmt.setString(111, pedidos.getNr5dup());
            stmt.setDouble(112, pedidos.getVl6s());
            stmt.setDouble(113, pedidos.getVl6c());
            stmt.setString(114, pedidos.getDv6dup());
            stmt.setString(115, pedidos.getConferido());
            stmt.setString(116, pedidos.getDatConferido());
            stmt.setString(117, pedidos.getDatConfFim());
            stmt.setInt(118, pedidos.getCodConf());
            stmt.setString(119, pedidos.getNotaAceita());
            stmt.setString(120, pedidos.getDupAceita());
            stmt.setString(121, pedidos.getFoiDevolvido());
            stmt.setDouble(122, pedidos.getValDesconto());
            stmt.setDouble(123, pedidos.getValDevolvido());
            stmt.setDouble(124, pedidos.getValFaltas());
            stmt.setDouble(125, pedidos.getValCheque());
            stmt.setDouble(126, pedidos.getValDup());
            stmt.setDouble(127, pedidos.getValCarteira());
            stmt.setDouble(128, pedidos.getValFaltas());
            stmt.setDouble(129, pedidos.getValCheque());
            stmt.setDouble(130, pedidos.getValDup());
            stmt.setDouble(131, pedidos.getValCarteira());
            stmt.setDouble(132, pedidos.getValDinheiro());
            stmt.setDouble(133, pedidos.getValDif());
            stmt.setDouble(134, pedidos.getValDeposito());
            stmt.setDouble(135, pedidos.getTotalAcerto());
            stmt.setString(136, pedidos.getModCond());
            stmt.setInt(137, pedidos.getCodNatAcerto());
            stmt.setString(138, pedidos.getTipCobAcerto());
            stmt.setString(139, pedidos.getObsAcerto());
            stmt.setString(140, pedidos.getBaixado());
            stmt.setString(141, pedidos.getDataBaixa());
            stmt.setString(142, pedidos.getDataEntrega());
            stmt.setInt(143, pedidos.getCodNotaDev());
            stmt.setString(144, pedidos.getMT1Ped());
            stmt.setString(145, pedidos.getMT2Ped());
            stmt.setDouble(146, pedidos.getPerPeso());
            stmt.setString(147, pedidos.getMCom());
            stmt.setString(148, pedidos.getDtCom());
            stmt.setString(149, pedidos.getEmiNot());
            stmt.setInt(150, pedidos.getNroLote());
            stmt.setString(151, pedidos.getLibGrup());

            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("PEDIDOS ALTERADO!");
            } else {
                System.out.println("PEDIDOS NÃO EXISTE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO ALTERAR PEDIDOS!");
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
            stmt = conn.prepareStatement("DELETE FROM Pedidos WHERE CodPed = ?");
            stmt.setInt(1, id);
            excluidos = stmt.executeUpdate();

            if (excluidos > 0) {
                System.out.println("PEDIDOS REMOVIDO!");
            } else {
                System.out.println("PEDIDOS NÃO EXISTE!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO DELETAR PEDIDOS!");
        } finally {
            closeConnection(conn, stmt);
        }
        return excluidos;
    }

    public Pedidos buscar(int id) throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        Pedidos pedidos = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Pedidos WHERE CodPed = ?");
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {




                pedidos = new Pedidos();

                pedidos.setSPed(resultSet.getInt("CodPro"));
                pedidos.setDataPed(resultSet.getString("DataPed"));
                pedidos.setDataEmi(resultSet.getString("DataEmi"));
                pedidos.setDataSai(resultSet.getString("DataSai"));
                pedidos.setCodTpo(resultSet.getInt("CodTpo"));
                pedidos.setCodTpo(resultSet.getInt("CodTpo"));
                pedidos.setCodVen(resultSet.getInt("CodVen"));
                pedidos.setCodTra(resultSet.getInt("CodTra"));
                pedidos.setPerDes1(resultSet.getDouble("PerDes1"));
                pedidos.setPerDes2(resultSet.getDouble("PerDes2"));
                pedidos.setPerDes3(resultSet.getDouble("PerDes3"));
                pedidos.setNroCarga(resultSet.getLong("NroCarga"));
                pedidos.setOrdPed(resultSet.getInt("OrdPed"));
                pedidos.setSeqEntrega(resultSet.getDouble("SeqEntrega"));
                pedidos.setTransf(resultSet.getString("Transf"));
                pedidos.setPerSem(resultSet.getDouble("PerSem"));
                pedidos.setTab(resultSet.getInt("Tab"));
                pedidos.setVol(resultSet.getInt("Vol"));
                pedidos.setVolume(resultSet.getString("Volume"));
                pedidos.setTipCob(resultSet.getString("TipCob"));
                pedidos.setTotPed(resultSet.getDouble("TotPed"));
                pedidos.setTotPro(resultSet.getDouble("TotPro"));
                pedidos.setTotDes(resultSet.getDouble("TotDes"));
                pedidos.setTotBruto(resultSet.getDouble("TotBruto"));
                pedidos.setTotFrete(resultSet.getDouble("TotFrete"));
                pedidos.setTotBonif(resultSet.getDouble("TotBonif"));
                pedidos.setTotBrinde(resultSet.getDouble("TotBrinde"));
                pedidos.setTotBonifB(resultSet.getDouble("TotBonifB"));
                pedidos.setTotBrindeB(resultSet.getDouble("TotBrindeB"));
                pedidos.setValIPI(resultSet.getDouble("ValIPI"));
                pedidos.setBaseIcmsCom(resultSet.getDouble("BaseIcmsCom"));
                pedidos.setValIcmsCom(resultSet.getDouble("ValIcmsCom"));
                pedidos.setPesoLiq(resultSet.getDouble("PesoLiq"));
                pedidos.setPesoBru(resultSet.getDouble("PesoBru"));
                pedidos.setTotLan(resultSet.getInt("TotLan"));
                pedidos.setTotPec(resultSet.getDouble("TotPec"));
                pedidos.setTotIpi(resultSet.getDouble("TotIpi"));
                pedidos.setBasIpi(resultSet.getDouble("BasIpi"));
                pedidos.setBasIseIpi(resultSet.getDouble("BasIseIpi"));
                pedidos.setTotCofins(resultSet.getDouble("TotCofins"));
                pedidos.setBasCofins(resultSet.getDouble("BasCofins"));
                pedidos.setBaseIseCofins(resultSet.getDouble("BaseIseCofins"));
                pedidos.setValSubIcms(resultSet.getDouble("ValSubIcms"));
                pedidos.setBasSubIcms(resultSet.getDouble("BasSubIcms"));
                pedidos.setDescSuf(resultSet.getDouble("DescSuf"));
                pedidos.setDescIcms(resultSet.getDouble("DescIcms"));
                pedidos.setBaseIcms(resultSet.getDouble("BaseIcms"));
                pedidos.setValIcms(resultSet.getDouble("ValIcms"));
                pedidos.setTotNota(resultSet.getDouble("TotNota"));
                pedidos.setTotProCom(resultSet.getDouble("TotProCom"));
                pedidos.setTotProSem(resultSet.getDouble("TotProSem"));
                pedidos.setValIPICom(resultSet.getDouble("ValIPICom"));
                pedidos.setCanPed(resultSet.getString("CanPed"));
                pedidos.setDataCan(resultSet.getString("DataCan"));
                pedidos.setMotCan(resultSet.getString("MotCan"));
                pedidos.setFrete(resultSet.getString("Frete"));
                pedidos.setQuant(resultSet.getDouble("Quant"));
                pedidos.setEspecie(resultSet.getString("Especie"));
                pedidos.setMarca(resultSet.getString("Marca"));
                pedidos.setNF2Fec(resultSet.getInt("NF2Fec"));
                pedidos.setDT2Fec(resultSet.getString("DT2Fec"));
                pedidos.setNtfPed(resultSet.getInt("NtfPed"));
                pedidos.setDatFec(resultSet.getString("DatFec"));
                pedidos.setEmitido(resultSet.getString("Emitido"));
                pedidos.setDatCon(resultSet.getString("DatCon"));
                pedidos.setAlerta(resultSet.getString("Alerta"));
                pedidos.setSeqRelacao(resultSet.getInt("SeqRelacao"));
                pedidos.setDatRelacao(resultSet.getString("DatRelacao"));
                pedidos.setLComissao(resultSet.getDouble("LComissao"));
                pedidos.setLVenda(resultSet.getDouble("LVenda"));
                pedidos.setLPrUnit(resultSet.getDouble("LPrUnit"));
                pedidos.setPComissao(resultSet.getDouble("PComissao"));
                pedidos.setPVenda(resultSet.getDouble("PVenda"));
                pedidos.setAlteraParam(resultSet.getString("AlteraParam"));
                pedidos.setAlteraMarg(resultSet.getString("AlteraMarg"));
                pedidos.setCofins(resultSet.getDouble("Cofins"));
                pedidos.setPis(resultSet.getDouble("Pis"));
                pedidos.setIrpj(resultSet.getDouble("Irpj"));
                pedidos.setInvest(resultSet.getDouble("Invest"));
                pedidos.setFinan(resultSet.getDouble("Finan"));
                pedidos.setInad(resultSet.getDouble("Inad"));
                pedidos.setDProm(resultSet.getDouble("DProm"));
                pedidos.setDMark(resultSet.getDouble("DMark"));
                pedidos.setPerdas(resultSet.getDouble("Perdas"));
                pedidos.setFrota(resultSet.getDouble("Frota"));
                pedidos.setMargem(resultSet.getDouble("Margem"));
                pedidos.setStatus(resultSet.getString("Status"));
                pedidos.setMen1(resultSet.getString("Men1"));
                pedidos.setMen2(resultSet.getString("Men2"));
                pedidos.setMen3(resultSet.getString("Men3"));
                pedidos.setMen4(resultSet.getString("Men4"));
                pedidos.setMen5(resultSet.getString("Men5"));
                pedidos.setMen6(resultSet.getString("Men6"));
                pedidos.setTipIPI(resultSet.getString("TipIPI"));
                pedidos.setTipST(resultSet.getString("TipST"));
                pedidos.setObsCarreg(resultSet.getString("ObsCarreg"));
                pedidos.setNr1dup(resultSet.getString("NR1DUP"));
                pedidos.setVl1dup(resultSet.getDouble("VL1DUP"));
                pedidos.setVl1s(resultSet.getDouble("VL1S"));
                pedidos.setVl1c(resultSet.getDouble("VL1C"));
                pedidos.setNr2dup(resultSet.getString("NR2DUP"));
                pedidos.setVl2dup(resultSet.getDouble("VL2DUP"));
                pedidos.setVl2s(resultSet.getDouble("VL2S"));
                pedidos.setVl2c(resultSet.getDouble("VL2C"));
                pedidos.setDv2dup(resultSet.getString("DV2DUP"));
                pedidos.setNr3dup(resultSet.getString("NR3DUP"));
                pedidos.setVl3dup(resultSet.getDouble("VL3DUP"));
                pedidos.setVl3s(resultSet.getDouble("VL3S"));
                pedidos.setVl3c(resultSet.getDouble("VL3C"));
                pedidos.setDv3dup(resultSet.getString("DV3DUP"));
                pedidos.setNr4dup(resultSet.getString("NR4DUP"));
                pedidos.setVl4dup(resultSet.getDouble("VL4DUP"));
                pedidos.setVl4s(resultSet.getDouble("VL4S"));
                pedidos.setVl4c(resultSet.getDouble("VL4C"));
                pedidos.setDv4dup(resultSet.getString("DV4DUP"));
                pedidos.setNr5dup(resultSet.getString("NR5DUP"));
                pedidos.setVl5dup(resultSet.getDouble("VL5DUP"));
                pedidos.setVl5s(resultSet.getDouble("VL5S"));
                pedidos.setVl5c(resultSet.getDouble("VL5C"));
                pedidos.setDv5dup(resultSet.getString("DV5DUP"));
                pedidos.setNr5dup(resultSet.getString("NR5DUP"));
                pedidos.setVl6s(resultSet.getDouble("VL16S"));
                pedidos.setVl6c(resultSet.getDouble("VL6C"));
                pedidos.setDv6dup(resultSet.getString("DV6DUP"));
                pedidos.setConferido(resultSet.getString("Conferido"));
                pedidos.setDatConferido(resultSet.getString("DatConferido"));
                pedidos.setDatConfFim(resultSet.getString("DatConfFim"));
                pedidos.setCodConf(resultSet.getInt("CodConf"));
                pedidos.setNotaAceita(resultSet.getString("NotaAceita"));
                pedidos.setDupAceita(resultSet.getString("DupAceita"));
                pedidos.setFoiDevolvido(resultSet.getString("FoiDevolvido"));
                pedidos.setValDesconto(resultSet.getDouble("ValDesconto"));
                pedidos.setValDevolvido(resultSet.getDouble("ValDevolvido"));
                pedidos.setValFaltas(resultSet.getDouble("ValFaltas"));
                pedidos.setValCheque(resultSet.getDouble("ValCheque"));
                pedidos.setValDup(resultSet.getDouble("ValDup"));
                pedidos.setValCarteira(resultSet.getDouble("ValCarteira"));
                pedidos.setValFaltas(resultSet.getDouble("ValFaltas"));
                pedidos.setValCheque(resultSet.getDouble("ValCheque"));
                pedidos.setValDup(resultSet.getDouble("ValDup"));
                pedidos.setValCarteira(resultSet.getDouble("ValCarteira"));
                pedidos.setValDinheiro(resultSet.getDouble("ValDinheiro"));
                pedidos.setValDif(resultSet.getDouble("ValDif"));
                pedidos.setValDeposito(resultSet.getDouble("ValDeposito"));
                pedidos.setTotalAcerto(resultSet.getDouble("TotalAcerto"));
                pedidos.setModCond(resultSet.getString("ModCond"));
                pedidos.setCodNatAcerto(resultSet.getInt("CodNatAcerto"));
                pedidos.setTipCobAcerto(resultSet.getString("TipCobAcerto"));
                pedidos.setObsAcerto(resultSet.getString("ObsAcerto"));
                pedidos.setBaixado(resultSet.getString("Baixado"));
                pedidos.setDataBaixa(resultSet.getString("DataBaixa"));
                pedidos.setDataEntrega(resultSet.getString("DataEntrega"));
                pedidos.setCodNotaDev(resultSet.getInt("CodNotaDev"));
                pedidos.setMT1Ped(resultSet.getString("MT1Ped"));
                pedidos.setMT2Ped(resultSet.getString("tMT2Ped"));
                pedidos.setPerPeso(resultSet.getDouble("PerPeso"));
                pedidos.setMCom(resultSet.getString("MCom"));
                pedidos.setDtCom(resultSet.getString("DtCom"));
                pedidos.setEmiNot(resultSet.getString("EmiNot"));
                pedidos.setNroLote(resultSet.getInt("NroLote"));
                pedidos.setLibGrup(resultSet.getString("LibGrup"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return pedidos;
    }

    public ArrayList<Pedidos> buscarTodos() throws ClassNotFoundException {

        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        conn = getConnection();
        ArrayList<Pedidos> listaPedidos = null;

        try {

            stmt = conn.prepareStatement("SELECT * FROM Pedidos ORDER BY CodPed");
            resultSet = stmt.executeQuery();
            listaPedidos = new ArrayList<Pedidos>();

            while (resultSet.next()) {
                Pedidos pedidos = new Pedidos();
                pedidos.setSPed(resultSet.getInt("CodPro"));
                pedidos.setDataPed(resultSet.getString("DataPed"));
                pedidos.setDataEmi(resultSet.getString("DataEmi"));
                pedidos.setDataSai(resultSet.getString("DataSai"));
                pedidos.setCodTpo(resultSet.getInt("CodTpo"));
                pedidos.setCodTpo(resultSet.getInt("CodTpo"));
                pedidos.setCodVen(resultSet.getInt("CodVen"));
                pedidos.setCodTra(resultSet.getInt("CodTra"));
                pedidos.setPerDes1(resultSet.getDouble("PerDes1"));
                pedidos.setPerDes2(resultSet.getDouble("PerDes2"));
                pedidos.setPerDes3(resultSet.getDouble("PerDes3"));
                pedidos.setNroCarga(resultSet.getLong("NroCarga"));
                pedidos.setOrdPed(resultSet.getInt("OrdPed"));
                pedidos.setSeqEntrega(resultSet.getDouble("SeqEntrega"));
                pedidos.setTransf(resultSet.getString("Transf"));
                pedidos.setPerSem(resultSet.getDouble("PerSem"));
                pedidos.setTab(resultSet.getInt("Tab"));
                pedidos.setVol(resultSet.getInt("Vol"));
                pedidos.setVolume(resultSet.getString("Volume"));
                pedidos.setTipCob(resultSet.getString("TipCob"));
                pedidos.setTotPed(resultSet.getDouble("TotPed"));
                pedidos.setTotPro(resultSet.getDouble("TotPro"));
                pedidos.setTotDes(resultSet.getDouble("TotDes"));
                pedidos.setTotBruto(resultSet.getDouble("TotBruto"));
                pedidos.setTotFrete(resultSet.getDouble("TotFrete"));
                pedidos.setTotBonif(resultSet.getDouble("TotBonif"));
                pedidos.setTotBrinde(resultSet.getDouble("TotBrinde"));
                pedidos.setTotBonifB(resultSet.getDouble("TotBonifB"));
                pedidos.setTotBrindeB(resultSet.getDouble("TotBrindeB"));
                pedidos.setValIPI(resultSet.getDouble("ValIPI"));
                pedidos.setBaseIcmsCom(resultSet.getDouble("BaseIcmsCom"));
                pedidos.setValIcmsCom(resultSet.getDouble("ValIcmsCom"));
                pedidos.setPesoLiq(resultSet.getDouble("PesoLiq"));
                pedidos.setPesoBru(resultSet.getDouble("PesoBru"));
                pedidos.setTotLan(resultSet.getInt("TotLan"));
                pedidos.setTotPec(resultSet.getDouble("TotPec"));
                pedidos.setTotIpi(resultSet.getDouble("TotIpi"));
                pedidos.setBasIpi(resultSet.getDouble("BasIpi"));
                pedidos.setBasIseIpi(resultSet.getDouble("BasIseIpi"));
                pedidos.setTotCofins(resultSet.getDouble("TotCofins"));
                pedidos.setBasCofins(resultSet.getDouble("BasCofins"));
                pedidos.setBaseIseCofins(resultSet.getDouble("BaseIseCofins"));
                pedidos.setValSubIcms(resultSet.getDouble("ValSubIcms"));
                pedidos.setBasSubIcms(resultSet.getDouble("BasSubIcms"));
                pedidos.setDescSuf(resultSet.getDouble("DescSuf"));
                pedidos.setDescIcms(resultSet.getDouble("DescIcms"));
                pedidos.setBaseIcms(resultSet.getDouble("BaseIcms"));
                pedidos.setValIcms(resultSet.getDouble("ValIcms"));
                pedidos.setTotNota(resultSet.getDouble("TotNota"));
                pedidos.setTotProCom(resultSet.getDouble("TotProCom"));
                pedidos.setTotProSem(resultSet.getDouble("TotProSem"));
                pedidos.setValIPICom(resultSet.getDouble("ValIPICom"));
                pedidos.setCanPed(resultSet.getString("CanPed"));
                pedidos.setDataCan(resultSet.getString("DataCan"));
                pedidos.setMotCan(resultSet.getString("MotCan"));
                pedidos.setFrete(resultSet.getString("Frete"));
                pedidos.setQuant(resultSet.getDouble("Quant"));
                pedidos.setEspecie(resultSet.getString("Especie"));
                pedidos.setMarca(resultSet.getString("Marca"));
                pedidos.setNF2Fec(resultSet.getInt("NF2Fec"));
                pedidos.setDT2Fec(resultSet.getString("DT2Fec"));
                pedidos.setNtfPed(resultSet.getInt("NtfPed"));
                pedidos.setDatFec(resultSet.getString("DatFec"));
                pedidos.setEmitido(resultSet.getString("Emitido"));
                pedidos.setDatCon(resultSet.getString("DatCon"));
                pedidos.setAlerta(resultSet.getString("Alerta"));
                pedidos.setSeqRelacao(resultSet.getInt("SeqRelacao"));
                pedidos.setDatRelacao(resultSet.getString("DatRelacao"));
                pedidos.setLComissao(resultSet.getDouble("LComissao"));
                pedidos.setLVenda(resultSet.getDouble("LVenda"));
                pedidos.setLPrUnit(resultSet.getDouble("LPrUnit"));
                pedidos.setPComissao(resultSet.getDouble("PComissao"));
                pedidos.setPVenda(resultSet.getDouble("PVenda"));
                pedidos.setAlteraParam(resultSet.getString("AlteraParam"));
                pedidos.setAlteraMarg(resultSet.getString("AlteraMarg"));
                pedidos.setCofins(resultSet.getDouble("Cofins"));
                pedidos.setPis(resultSet.getDouble("Pis"));
                pedidos.setIrpj(resultSet.getDouble("Irpj"));
                pedidos.setInvest(resultSet.getDouble("Invest"));
                pedidos.setFinan(resultSet.getDouble("Finan"));
                pedidos.setInad(resultSet.getDouble("Inad"));
                pedidos.setDProm(resultSet.getDouble("DProm"));
                pedidos.setDMark(resultSet.getDouble("DMark"));
                pedidos.setPerdas(resultSet.getDouble("Perdas"));
                pedidos.setFrota(resultSet.getDouble("Frota"));
                pedidos.setMargem(resultSet.getDouble("Margem"));
                pedidos.setStatus(resultSet.getString("Status"));
                pedidos.setMen1(resultSet.getString("Men1"));
                pedidos.setMen2(resultSet.getString("Men2"));
                pedidos.setMen3(resultSet.getString("Men3"));
                pedidos.setMen4(resultSet.getString("Men4"));
                pedidos.setMen5(resultSet.getString("Men5"));
                pedidos.setMen6(resultSet.getString("Men6"));
                pedidos.setTipIPI(resultSet.getString("TipIPI"));
                pedidos.setTipST(resultSet.getString("TipST"));
                pedidos.setObsCarreg(resultSet.getString("ObsCarreg"));
                pedidos.setNr1dup(resultSet.getString("NR1DUP"));
                pedidos.setVl1dup(resultSet.getDouble("VL1DUP"));
                pedidos.setVl1s(resultSet.getDouble("VL1S"));
                pedidos.setVl1c(resultSet.getDouble("VL1C"));
                pedidos.setNr2dup(resultSet.getString("NR2DUP"));
                pedidos.setVl2dup(resultSet.getDouble("VL2DUP"));
                pedidos.setVl2s(resultSet.getDouble("VL2S"));
                pedidos.setVl2c(resultSet.getDouble("VL2C"));
                pedidos.setDv2dup(resultSet.getString("DV2DUP"));
                pedidos.setNr3dup(resultSet.getString("NR3DUP"));
                pedidos.setVl3dup(resultSet.getDouble("VL3DUP"));
                pedidos.setVl3s(resultSet.getDouble("VL3S"));
                pedidos.setVl3c(resultSet.getDouble("VL3C"));
                pedidos.setDv3dup(resultSet.getString("DV3DUP"));
                pedidos.setNr4dup(resultSet.getString("NR4DUP"));
                pedidos.setVl4dup(resultSet.getDouble("VL4DUP"));
                pedidos.setVl4s(resultSet.getDouble("VL4S"));
                pedidos.setVl4c(resultSet.getDouble("VL4C"));
                pedidos.setDv4dup(resultSet.getString("DV4DUP"));
                pedidos.setNr5dup(resultSet.getString("NR5DUP"));
                pedidos.setVl5dup(resultSet.getDouble("VL5DUP"));
                pedidos.setVl5s(resultSet.getDouble("VL5S"));
                pedidos.setVl5c(resultSet.getDouble("VL5C"));
                pedidos.setDv5dup(resultSet.getString("DV5DUP"));
                pedidos.setNr5dup(resultSet.getString("NR5DUP"));
                pedidos.setVl6s(resultSet.getDouble("VL16S"));
                pedidos.setVl6c(resultSet.getDouble("VL6C"));
                pedidos.setDv6dup(resultSet.getString("DV6DUP"));
                pedidos.setConferido(resultSet.getString("Conferido"));
                pedidos.setDatConferido(resultSet.getString("DatConferido"));
                pedidos.setDatConfFim(resultSet.getString("DatConfFim"));
                pedidos.setCodConf(resultSet.getInt("CodConf"));
                pedidos.setNotaAceita(resultSet.getString("NotaAceita"));
                pedidos.setDupAceita(resultSet.getString("DupAceita"));
                pedidos.setFoiDevolvido(resultSet.getString("FoiDevolvido"));
                pedidos.setValDesconto(resultSet.getDouble("ValDesconto"));
                pedidos.setValDevolvido(resultSet.getDouble("ValDevolvido"));
                pedidos.setValFaltas(resultSet.getDouble("ValFaltas"));
                pedidos.setValCheque(resultSet.getDouble("ValCheque"));
                pedidos.setValDup(resultSet.getDouble("ValDup"));
                pedidos.setValCarteira(resultSet.getDouble("ValCarteira"));
                pedidos.setValFaltas(resultSet.getDouble("ValFaltas"));
                pedidos.setValCheque(resultSet.getDouble("ValCheque"));
                pedidos.setValDup(resultSet.getDouble("ValDup"));
                pedidos.setValCarteira(resultSet.getDouble("ValCarteira"));
                pedidos.setValDinheiro(resultSet.getDouble("ValDinheiro"));
                pedidos.setValDif(resultSet.getDouble("ValDif"));
                pedidos.setValDeposito(resultSet.getDouble("ValDeposito"));
                pedidos.setTotalAcerto(resultSet.getDouble("TotalAcerto"));
                pedidos.setModCond(resultSet.getString("ModCond"));
                pedidos.setCodNatAcerto(resultSet.getInt("CodNatAcerto"));
                pedidos.setTipCobAcerto(resultSet.getString("TipCobAcerto"));
                pedidos.setObsAcerto(resultSet.getString("ObsAcerto"));
                pedidos.setBaixado(resultSet.getString("Baixado"));
                pedidos.setDataBaixa(resultSet.getString("DataBaixa"));
                pedidos.setDataEntrega(resultSet.getString("DataEntrega"));
                pedidos.setCodNotaDev(resultSet.getInt("CodNotaDev"));
                pedidos.setMT1Ped(resultSet.getString("MT1Ped"));
                pedidos.setMT2Ped(resultSet.getString("tMT2Ped"));
                pedidos.setPerPeso(resultSet.getDouble("PerPeso"));
                pedidos.setMCom(resultSet.getString("MCom"));
                pedidos.setDtCom(resultSet.getString("DtCom"));
                pedidos.setEmiNot(resultSet.getString("EmiNot"));
                pedidos.setNroLote(resultSet.getInt("NroLote"));
                pedidos.setLibGrup(resultSet.getString("LibGrup"));


                listaPedidos.add(pedidos);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            listaPedidos = null;
        } finally {
            closeConnection(conn, stmt, resultSet);
        }
        return listaPedidos;
    }
}
