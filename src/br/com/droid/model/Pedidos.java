/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.droid.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M
 */
@Entity
@Table(catalog = "gdroid", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
    @NamedQuery(name = "Pedidos.findByCodPed", query = "SELECT p FROM Pedidos p WHERE p.codPed = :codPed"),
    @NamedQuery(name = "Pedidos.findBySPed", query = "SELECT p FROM Pedidos p WHERE p.sPed = :sPed"),
    @NamedQuery(name = "Pedidos.findByDataPed", query = "SELECT p FROM Pedidos p WHERE p.dataPed = :dataPed"),
    @NamedQuery(name = "Pedidos.findByDataEmi", query = "SELECT p FROM Pedidos p WHERE p.dataEmi = :dataEmi"),
    @NamedQuery(name = "Pedidos.findByDataSai", query = "SELECT p FROM Pedidos p WHERE p.dataSai = :dataSai"),
    @NamedQuery(name = "Pedidos.findByCodTpo", query = "SELECT p FROM Pedidos p WHERE p.codTpo = :codTpo"),
    @NamedQuery(name = "Pedidos.findByCodCli", query = "SELECT p FROM Pedidos p WHERE p.codCli = :codCli"),
    @NamedQuery(name = "Pedidos.findByCodVen", query = "SELECT p FROM Pedidos p WHERE p.codVen = :codVen"),
    @NamedQuery(name = "Pedidos.findByCodTra", query = "SELECT p FROM Pedidos p WHERE p.codTra = :codTra"),
    @NamedQuery(name = "Pedidos.findByPerDes1", query = "SELECT p FROM Pedidos p WHERE p.perDes1 = :perDes1"),
    @NamedQuery(name = "Pedidos.findByPerDes2", query = "SELECT p FROM Pedidos p WHERE p.perDes2 = :perDes2"),
    @NamedQuery(name = "Pedidos.findByPerDes3", query = "SELECT p FROM Pedidos p WHERE p.perDes3 = :perDes3"),
    @NamedQuery(name = "Pedidos.findByNroCarga", query = "SELECT p FROM Pedidos p WHERE p.nroCarga = :nroCarga"),
    @NamedQuery(name = "Pedidos.findByOrdPed", query = "SELECT p FROM Pedidos p WHERE p.ordPed = :ordPed"),
    @NamedQuery(name = "Pedidos.findBySeqEntrega", query = "SELECT p FROM Pedidos p WHERE p.seqEntrega = :seqEntrega"),
    @NamedQuery(name = "Pedidos.findByTransf", query = "SELECT p FROM Pedidos p WHERE p.transf = :transf"),
    @NamedQuery(name = "Pedidos.findByPerSem", query = "SELECT p FROM Pedidos p WHERE p.perSem = :perSem"),
    @NamedQuery(name = "Pedidos.findByTab", query = "SELECT p FROM Pedidos p WHERE p.tab = :tab"),
    @NamedQuery(name = "Pedidos.findByVol", query = "SELECT p FROM Pedidos p WHERE p.vol = :vol"),
    @NamedQuery(name = "Pedidos.findByVolume", query = "SELECT p FROM Pedidos p WHERE p.volume = :volume"),
    @NamedQuery(name = "Pedidos.findByTipCob", query = "SELECT p FROM Pedidos p WHERE p.tipCob = :tipCob"),
    @NamedQuery(name = "Pedidos.findByTotPed", query = "SELECT p FROM Pedidos p WHERE p.totPed = :totPed"),
    @NamedQuery(name = "Pedidos.findByTotPro", query = "SELECT p FROM Pedidos p WHERE p.totPro = :totPro"),
    @NamedQuery(name = "Pedidos.findByTotDes", query = "SELECT p FROM Pedidos p WHERE p.totDes = :totDes"),
    @NamedQuery(name = "Pedidos.findByTotBruto", query = "SELECT p FROM Pedidos p WHERE p.totBruto = :totBruto"),
    @NamedQuery(name = "Pedidos.findByTotFrete", query = "SELECT p FROM Pedidos p WHERE p.totFrete = :totFrete"),
    @NamedQuery(name = "Pedidos.findByTotBonif", query = "SELECT p FROM Pedidos p WHERE p.totBonif = :totBonif"),
    @NamedQuery(name = "Pedidos.findByTotBrinde", query = "SELECT p FROM Pedidos p WHERE p.totBrinde = :totBrinde"),
    @NamedQuery(name = "Pedidos.findByTotBonifB", query = "SELECT p FROM Pedidos p WHERE p.totBonifB = :totBonifB"),
    @NamedQuery(name = "Pedidos.findByTotBrindeB", query = "SELECT p FROM Pedidos p WHERE p.totBrindeB = :totBrindeB"),
    @NamedQuery(name = "Pedidos.findByValIPI", query = "SELECT p FROM Pedidos p WHERE p.valIPI = :valIPI"),
    @NamedQuery(name = "Pedidos.findByBaseIcmsCom", query = "SELECT p FROM Pedidos p WHERE p.baseIcmsCom = :baseIcmsCom"),
    @NamedQuery(name = "Pedidos.findByValIcmsCom", query = "SELECT p FROM Pedidos p WHERE p.valIcmsCom = :valIcmsCom"),
    @NamedQuery(name = "Pedidos.findByPesoLiq", query = "SELECT p FROM Pedidos p WHERE p.pesoLiq = :pesoLiq"),
    @NamedQuery(name = "Pedidos.findByPesoBru", query = "SELECT p FROM Pedidos p WHERE p.pesoBru = :pesoBru"),
    @NamedQuery(name = "Pedidos.findByTotLan", query = "SELECT p FROM Pedidos p WHERE p.totLan = :totLan"),
    @NamedQuery(name = "Pedidos.findByTotPec", query = "SELECT p FROM Pedidos p WHERE p.totPec = :totPec"),
    @NamedQuery(name = "Pedidos.findByTotIpi", query = "SELECT p FROM Pedidos p WHERE p.totIpi = :totIpi"),
    @NamedQuery(name = "Pedidos.findByBasIpi", query = "SELECT p FROM Pedidos p WHERE p.basIpi = :basIpi"),
    @NamedQuery(name = "Pedidos.findByBasIseIpi", query = "SELECT p FROM Pedidos p WHERE p.basIseIpi = :basIseIpi"),
    @NamedQuery(name = "Pedidos.findByTotCofins", query = "SELECT p FROM Pedidos p WHERE p.totCofins = :totCofins"),
    @NamedQuery(name = "Pedidos.findByBasCofins", query = "SELECT p FROM Pedidos p WHERE p.basCofins = :basCofins"),
    @NamedQuery(name = "Pedidos.findByBaseIseCofins", query = "SELECT p FROM Pedidos p WHERE p.baseIseCofins = :baseIseCofins"),
    @NamedQuery(name = "Pedidos.findByValSubIcms", query = "SELECT p FROM Pedidos p WHERE p.valSubIcms = :valSubIcms"),
    @NamedQuery(name = "Pedidos.findByBasSubIcms", query = "SELECT p FROM Pedidos p WHERE p.basSubIcms = :basSubIcms"),
    @NamedQuery(name = "Pedidos.findByDescSuf", query = "SELECT p FROM Pedidos p WHERE p.descSuf = :descSuf"),
    @NamedQuery(name = "Pedidos.findByDescIcms", query = "SELECT p FROM Pedidos p WHERE p.descIcms = :descIcms"),
    @NamedQuery(name = "Pedidos.findByBaseIcms", query = "SELECT p FROM Pedidos p WHERE p.baseIcms = :baseIcms"),
    @NamedQuery(name = "Pedidos.findByValIcms", query = "SELECT p FROM Pedidos p WHERE p.valIcms = :valIcms"),
    @NamedQuery(name = "Pedidos.findByTotNota", query = "SELECT p FROM Pedidos p WHERE p.totNota = :totNota"),
    @NamedQuery(name = "Pedidos.findByTotProCom", query = "SELECT p FROM Pedidos p WHERE p.totProCom = :totProCom"),
    @NamedQuery(name = "Pedidos.findByTotProSem", query = "SELECT p FROM Pedidos p WHERE p.totProSem = :totProSem"),
    @NamedQuery(name = "Pedidos.findByValIPICom", query = "SELECT p FROM Pedidos p WHERE p.valIPICom = :valIPICom"),
    @NamedQuery(name = "Pedidos.findByCanPed", query = "SELECT p FROM Pedidos p WHERE p.canPed = :canPed"),
    @NamedQuery(name = "Pedidos.findByDataCan", query = "SELECT p FROM Pedidos p WHERE p.dataCan = :dataCan"),
    @NamedQuery(name = "Pedidos.findByMotCan", query = "SELECT p FROM Pedidos p WHERE p.motCan = :motCan"),
    @NamedQuery(name = "Pedidos.findByFrete", query = "SELECT p FROM Pedidos p WHERE p.frete = :frete"),
    @NamedQuery(name = "Pedidos.findByQuant", query = "SELECT p FROM Pedidos p WHERE p.quant = :quant"),
    @NamedQuery(name = "Pedidos.findByEspecie", query = "SELECT p FROM Pedidos p WHERE p.especie = :especie"),
    @NamedQuery(name = "Pedidos.findByMarca", query = "SELECT p FROM Pedidos p WHERE p.marca = :marca"),
    @NamedQuery(name = "Pedidos.findByNF2Fec", query = "SELECT p FROM Pedidos p WHERE p.nF2Fec = :nF2Fec"),
    @NamedQuery(name = "Pedidos.findByDT2Fec", query = "SELECT p FROM Pedidos p WHERE p.dT2Fec = :dT2Fec"),
    @NamedQuery(name = "Pedidos.findByNtfPed", query = "SELECT p FROM Pedidos p WHERE p.ntfPed = :ntfPed"),
    @NamedQuery(name = "Pedidos.findByDatFec", query = "SELECT p FROM Pedidos p WHERE p.datFec = :datFec"),
    @NamedQuery(name = "Pedidos.findByEmitido", query = "SELECT p FROM Pedidos p WHERE p.emitido = :emitido"),
    @NamedQuery(name = "Pedidos.findByDatCon", query = "SELECT p FROM Pedidos p WHERE p.datCon = :datCon"),
    @NamedQuery(name = "Pedidos.findByAlerta", query = "SELECT p FROM Pedidos p WHERE p.alerta = :alerta"),
    @NamedQuery(name = "Pedidos.findBySeqRelacao", query = "SELECT p FROM Pedidos p WHERE p.seqRelacao = :seqRelacao"),
    @NamedQuery(name = "Pedidos.findByDatRelacao", query = "SELECT p FROM Pedidos p WHERE p.datRelacao = :datRelacao"),
    @NamedQuery(name = "Pedidos.findByLComissao", query = "SELECT p FROM Pedidos p WHERE p.lComissao = :lComissao"),
    @NamedQuery(name = "Pedidos.findByLVenda", query = "SELECT p FROM Pedidos p WHERE p.lVenda = :lVenda"),
    @NamedQuery(name = "Pedidos.findByLPrUnit", query = "SELECT p FROM Pedidos p WHERE p.lPrUnit = :lPrUnit"),
    @NamedQuery(name = "Pedidos.findByPComissao", query = "SELECT p FROM Pedidos p WHERE p.pComissao = :pComissao"),
    @NamedQuery(name = "Pedidos.findByPVenda", query = "SELECT p FROM Pedidos p WHERE p.pVenda = :pVenda"),
    @NamedQuery(name = "Pedidos.findByAlteraParam", query = "SELECT p FROM Pedidos p WHERE p.alteraParam = :alteraParam"),
    @NamedQuery(name = "Pedidos.findByAlteraMarg", query = "SELECT p FROM Pedidos p WHERE p.alteraMarg = :alteraMarg"),
    @NamedQuery(name = "Pedidos.findByCofins", query = "SELECT p FROM Pedidos p WHERE p.cofins = :cofins"),
    @NamedQuery(name = "Pedidos.findByPis", query = "SELECT p FROM Pedidos p WHERE p.pis = :pis"),
    @NamedQuery(name = "Pedidos.findByIrpj", query = "SELECT p FROM Pedidos p WHERE p.irpj = :irpj"),
    @NamedQuery(name = "Pedidos.findByInvest", query = "SELECT p FROM Pedidos p WHERE p.invest = :invest"),
    @NamedQuery(name = "Pedidos.findByFinan", query = "SELECT p FROM Pedidos p WHERE p.finan = :finan"),
    @NamedQuery(name = "Pedidos.findByInad", query = "SELECT p FROM Pedidos p WHERE p.inad = :inad"),
    @NamedQuery(name = "Pedidos.findByDProm", query = "SELECT p FROM Pedidos p WHERE p.dProm = :dProm"),
    @NamedQuery(name = "Pedidos.findByDMark", query = "SELECT p FROM Pedidos p WHERE p.dMark = :dMark"),
    @NamedQuery(name = "Pedidos.findByPerdas", query = "SELECT p FROM Pedidos p WHERE p.perdas = :perdas"),
    @NamedQuery(name = "Pedidos.findByFrota", query = "SELECT p FROM Pedidos p WHERE p.frota = :frota"),
    @NamedQuery(name = "Pedidos.findByMargem", query = "SELECT p FROM Pedidos p WHERE p.margem = :margem"),
    @NamedQuery(name = "Pedidos.findByStatus", query = "SELECT p FROM Pedidos p WHERE p.status = :status"),
    @NamedQuery(name = "Pedidos.findByMen1", query = "SELECT p FROM Pedidos p WHERE p.men1 = :men1"),
    @NamedQuery(name = "Pedidos.findByMen2", query = "SELECT p FROM Pedidos p WHERE p.men2 = :men2"),
    @NamedQuery(name = "Pedidos.findByMen3", query = "SELECT p FROM Pedidos p WHERE p.men3 = :men3"),
    @NamedQuery(name = "Pedidos.findByMen4", query = "SELECT p FROM Pedidos p WHERE p.men4 = :men4"),
    @NamedQuery(name = "Pedidos.findByMen5", query = "SELECT p FROM Pedidos p WHERE p.men5 = :men5"),
    @NamedQuery(name = "Pedidos.findByMen6", query = "SELECT p FROM Pedidos p WHERE p.men6 = :men6"),
    @NamedQuery(name = "Pedidos.findByTipIPI", query = "SELECT p FROM Pedidos p WHERE p.tipIPI = :tipIPI"),
    @NamedQuery(name = "Pedidos.findByTipST", query = "SELECT p FROM Pedidos p WHERE p.tipST = :tipST"),
    @NamedQuery(name = "Pedidos.findByObsCarreg", query = "SELECT p FROM Pedidos p WHERE p.obsCarreg = :obsCarreg"),
    @NamedQuery(name = "Pedidos.findByNr1dup", query = "SELECT p FROM Pedidos p WHERE p.nr1dup = :nr1dup"),
    @NamedQuery(name = "Pedidos.findByVl1dup", query = "SELECT p FROM Pedidos p WHERE p.vl1dup = :vl1dup"),
    @NamedQuery(name = "Pedidos.findByVl1s", query = "SELECT p FROM Pedidos p WHERE p.vl1s = :vl1s"),
    @NamedQuery(name = "Pedidos.findByVl1c", query = "SELECT p FROM Pedidos p WHERE p.vl1c = :vl1c"),
    @NamedQuery(name = "Pedidos.findByDv1dup", query = "SELECT p FROM Pedidos p WHERE p.dv1dup = :dv1dup"),
    @NamedQuery(name = "Pedidos.findByNr2dup", query = "SELECT p FROM Pedidos p WHERE p.nr2dup = :nr2dup"),
    @NamedQuery(name = "Pedidos.findByVl2dup", query = "SELECT p FROM Pedidos p WHERE p.vl2dup = :vl2dup"),
    @NamedQuery(name = "Pedidos.findByVl2s", query = "SELECT p FROM Pedidos p WHERE p.vl2s = :vl2s"),
    @NamedQuery(name = "Pedidos.findByVl2c", query = "SELECT p FROM Pedidos p WHERE p.vl2c = :vl2c"),
    @NamedQuery(name = "Pedidos.findByDv2dup", query = "SELECT p FROM Pedidos p WHERE p.dv2dup = :dv2dup"),
    @NamedQuery(name = "Pedidos.findByNr3dup", query = "SELECT p FROM Pedidos p WHERE p.nr3dup = :nr3dup"),
    @NamedQuery(name = "Pedidos.findByVl3dup", query = "SELECT p FROM Pedidos p WHERE p.vl3dup = :vl3dup"),
    @NamedQuery(name = "Pedidos.findByVl3s", query = "SELECT p FROM Pedidos p WHERE p.vl3s = :vl3s"),
    @NamedQuery(name = "Pedidos.findByVl3c", query = "SELECT p FROM Pedidos p WHERE p.vl3c = :vl3c"),
    @NamedQuery(name = "Pedidos.findByDv3dup", query = "SELECT p FROM Pedidos p WHERE p.dv3dup = :dv3dup"),
    @NamedQuery(name = "Pedidos.findByNr4dup", query = "SELECT p FROM Pedidos p WHERE p.nr4dup = :nr4dup"),
    @NamedQuery(name = "Pedidos.findByVl4dup", query = "SELECT p FROM Pedidos p WHERE p.vl4dup = :vl4dup"),
    @NamedQuery(name = "Pedidos.findByVl4s", query = "SELECT p FROM Pedidos p WHERE p.vl4s = :vl4s"),
    @NamedQuery(name = "Pedidos.findByVl4c", query = "SELECT p FROM Pedidos p WHERE p.vl4c = :vl4c"),
    @NamedQuery(name = "Pedidos.findByDv4dup", query = "SELECT p FROM Pedidos p WHERE p.dv4dup = :dv4dup"),
    @NamedQuery(name = "Pedidos.findByNr5dup", query = "SELECT p FROM Pedidos p WHERE p.nr5dup = :nr5dup"),
    @NamedQuery(name = "Pedidos.findByVl5dup", query = "SELECT p FROM Pedidos p WHERE p.vl5dup = :vl5dup"),
    @NamedQuery(name = "Pedidos.findByVl5s", query = "SELECT p FROM Pedidos p WHERE p.vl5s = :vl5s"),
    @NamedQuery(name = "Pedidos.findByVl5c", query = "SELECT p FROM Pedidos p WHERE p.vl5c = :vl5c"),
    @NamedQuery(name = "Pedidos.findByDv5dup", query = "SELECT p FROM Pedidos p WHERE p.dv5dup = :dv5dup"),
    @NamedQuery(name = "Pedidos.findByNr6dup", query = "SELECT p FROM Pedidos p WHERE p.nr6dup = :nr6dup"),
    @NamedQuery(name = "Pedidos.findByVl6dup", query = "SELECT p FROM Pedidos p WHERE p.vl6dup = :vl6dup"),
    @NamedQuery(name = "Pedidos.findByVl6s", query = "SELECT p FROM Pedidos p WHERE p.vl6s = :vl6s"),
    @NamedQuery(name = "Pedidos.findByVl6c", query = "SELECT p FROM Pedidos p WHERE p.vl6c = :vl6c"),
    @NamedQuery(name = "Pedidos.findByDv6dup", query = "SELECT p FROM Pedidos p WHERE p.dv6dup = :dv6dup"),
    @NamedQuery(name = "Pedidos.findByConferido", query = "SELECT p FROM Pedidos p WHERE p.conferido = :conferido"),
    @NamedQuery(name = "Pedidos.findByDatConferido", query = "SELECT p FROM Pedidos p WHERE p.datConferido = :datConferido"),
    @NamedQuery(name = "Pedidos.findByDatConfFim", query = "SELECT p FROM Pedidos p WHERE p.datConfFim = :datConfFim"),
    @NamedQuery(name = "Pedidos.findByCodConf", query = "SELECT p FROM Pedidos p WHERE p.codConf = :codConf"),
    @NamedQuery(name = "Pedidos.findByNotaAceita", query = "SELECT p FROM Pedidos p WHERE p.notaAceita = :notaAceita"),
    @NamedQuery(name = "Pedidos.findByDupAceita", query = "SELECT p FROM Pedidos p WHERE p.dupAceita = :dupAceita"),
    @NamedQuery(name = "Pedidos.findByFoiDevolvido", query = "SELECT p FROM Pedidos p WHERE p.foiDevolvido = :foiDevolvido"),
    @NamedQuery(name = "Pedidos.findByValDesconto", query = "SELECT p FROM Pedidos p WHERE p.valDesconto = :valDesconto"),
    @NamedQuery(name = "Pedidos.findByValDevolvido", query = "SELECT p FROM Pedidos p WHERE p.valDevolvido = :valDevolvido"),
    @NamedQuery(name = "Pedidos.findByValFaltas", query = "SELECT p FROM Pedidos p WHERE p.valFaltas = :valFaltas"),
    @NamedQuery(name = "Pedidos.findByValCheque", query = "SELECT p FROM Pedidos p WHERE p.valCheque = :valCheque"),
    @NamedQuery(name = "Pedidos.findByValDup", query = "SELECT p FROM Pedidos p WHERE p.valDup = :valDup"),
    @NamedQuery(name = "Pedidos.findByValCarteira", query = "SELECT p FROM Pedidos p WHERE p.valCarteira = :valCarteira"),
    @NamedQuery(name = "Pedidos.findByValDinheiro", query = "SELECT p FROM Pedidos p WHERE p.valDinheiro = :valDinheiro"),
    @NamedQuery(name = "Pedidos.findByValDif", query = "SELECT p FROM Pedidos p WHERE p.valDif = :valDif"),
    @NamedQuery(name = "Pedidos.findByValDeposito", query = "SELECT p FROM Pedidos p WHERE p.valDeposito = :valDeposito"),
    @NamedQuery(name = "Pedidos.findByTotalAcerto", query = "SELECT p FROM Pedidos p WHERE p.totalAcerto = :totalAcerto"),
    @NamedQuery(name = "Pedidos.findByModCond", query = "SELECT p FROM Pedidos p WHERE p.modCond = :modCond"),
    @NamedQuery(name = "Pedidos.findByCodNatAcerto", query = "SELECT p FROM Pedidos p WHERE p.codNatAcerto = :codNatAcerto"),
    @NamedQuery(name = "Pedidos.findByTipCobAcerto", query = "SELECT p FROM Pedidos p WHERE p.tipCobAcerto = :tipCobAcerto"),
    @NamedQuery(name = "Pedidos.findByObsAcerto", query = "SELECT p FROM Pedidos p WHERE p.obsAcerto = :obsAcerto"),
    @NamedQuery(name = "Pedidos.findByBaixado", query = "SELECT p FROM Pedidos p WHERE p.baixado = :baixado"),
    @NamedQuery(name = "Pedidos.findByDataBaixa", query = "SELECT p FROM Pedidos p WHERE p.dataBaixa = :dataBaixa"),
    @NamedQuery(name = "Pedidos.findByDataEntrega", query = "SELECT p FROM Pedidos p WHERE p.dataEntrega = :dataEntrega"),
    @NamedQuery(name = "Pedidos.findByCodNotaDev", query = "SELECT p FROM Pedidos p WHERE p.codNotaDev = :codNotaDev"),
    @NamedQuery(name = "Pedidos.findByMT1Ped", query = "SELECT p FROM Pedidos p WHERE p.mT1Ped = :mT1Ped"),
    @NamedQuery(name = "Pedidos.findByMT2Ped", query = "SELECT p FROM Pedidos p WHERE p.mT2Ped = :mT2Ped"),
    @NamedQuery(name = "Pedidos.findByPerPeso", query = "SELECT p FROM Pedidos p WHERE p.perPeso = :perPeso"),
    @NamedQuery(name = "Pedidos.findByMCom", query = "SELECT p FROM Pedidos p WHERE p.mCom = :mCom"),
    @NamedQuery(name = "Pedidos.findByDtCom", query = "SELECT p FROM Pedidos p WHERE p.dtCom = :dtCom"),
    @NamedQuery(name = "Pedidos.findByEmiNot", query = "SELECT p FROM Pedidos p WHERE p.emiNot = :emiNot"),
    @NamedQuery(name = "Pedidos.findByNroLote", query = "SELECT p FROM Pedidos p WHERE p.nroLote = :nroLote"),
    @NamedQuery(name = "Pedidos.findByLibGrup", query = "SELECT p FROM Pedidos p WHERE p.libGrup = :libGrup")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codPed;
    private Integer sPed;
    @Temporal(TemporalType.DATE)
    private String dataPed;
    @Temporal(TemporalType.DATE)
    private String dataEmi;
    @Temporal(TemporalType.DATE)
    private String dataSai;
    private Integer codTpo;
    private Integer codCli;
    private Integer codVen;
    private Integer codTra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 2147483647, scale = 0)
    private Double perDes1;
    @Column(precision = 2147483647, scale = 0)
    private Double perDes2;
    @Column(precision = 2147483647, scale = 0)
    private Double perDes3;
    private Long nroCarga;
    private Integer ordPed;
    @Column(precision = 2147483647, scale = 0)
    private Double seqEntrega;
    private String transf;
    @Column(precision = 2147483647, scale = 0)
    private Double perSem;
    private Integer tab;
    private Integer vol;
    @Size(max = 10)
    @Column(length = 10)
    private String volume;
    @Size(max = 3)
    @Column(length = 3)
    private String tipCob;
    @Column(precision = 2147483647, scale = 0)
    private Double totPed;
    @Column(precision = 2147483647, scale = 0)
    private Double totPro;
    @Column(precision = 2147483647, scale = 0)
    private Double totDes;
    @Column(precision = 2147483647, scale = 0)
    private Double totBruto;
    @Column(precision = 2147483647, scale = 0)
    private Double totFrete;
    @Column(precision = 2147483647, scale = 0)
    private Double totBonif;
    @Column(precision = 2147483647, scale = 0)
    private Double totBrinde;
    @Column(precision = 2147483647, scale = 0)
    private Double totBonifB;
    @Column(precision = 2147483647, scale = 0)
    private Double totBrindeB;
    @Column(precision = 2147483647, scale = 0)
    private Double valIPI;
    @Column(precision = 2147483647, scale = 0)
    private Double baseIcmsCom;
    @Column(precision = 2147483647, scale = 0)
    private Double valIcmsCom;
    @Column(precision = 2147483647, scale = 0)
    private Double pesoLiq;
    @Column(precision = 2147483647, scale = 0)
    private Double pesoBru;
    private Integer totLan;
    @Column(precision = 2147483647, scale = 0)
    private Double totPec;
    @Column(precision = 2147483647, scale = 0)
    private Double totIpi;
    @Column(precision = 2147483647, scale = 0)
    private Double basIpi;
    @Column(precision = 2147483647, scale = 0)
    private Double basIseIpi;
    @Column(precision = 2147483647, scale = 0)
    private Double totCofins;
    @Column(precision = 2147483647, scale = 0)
    private Double basCofins;
    @Column(precision = 2147483647, scale = 0)
    private Double baseIseCofins;
    @Column(precision = 2147483647, scale = 0)
    private Double valSubIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double basSubIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double descSuf;
    @Column(precision = 2147483647, scale = 0)
    private Double descIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double baseIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double valIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double totNota;
    @Column(precision = 2147483647, scale = 0)
    private Double totProCom;
    @Column(precision = 2147483647, scale = 0)
    private Double totProSem;
    @Column(precision = 2147483647, scale = 0)
    private Double valIPICom;
    private String canPed;
    @Temporal(TemporalType.DATE)
    private String dataCan;
    @Size(max = 50)
    @Column(length = 50)
    private String motCan;
    private String frete;
    @Column(precision = 2147483647, scale = 0)
    private Double quant;
    @Size(max = 20)
    @Column(length = 20)
    private String especie;
    @Size(max = 10)
    @Column(length = 10)
    private String marca;
    private Integer nF2Fec;
    @Temporal(TemporalType.DATE)
    private String dT2Fec;
    private Integer ntfPed;
    @Temporal(TemporalType.DATE)
    private String datFec;
    private String emitido;
    @Temporal(TemporalType.DATE)
    private String datCon;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String alerta;
    private Integer seqRelacao;
    @Temporal(TemporalType.DATE)
    private String datRelacao;
    @Column(precision = 2147483647, scale = 0)
    private Double lComissao;
    @Column(precision = 2147483647, scale = 0)
    private Double lVenda;
    @Column(precision = 2147483647, scale = 0)
    private Double lPrUnit;
    @Column(precision = 2147483647, scale = 0)
    private Double pComissao;
    @Column(precision = 2147483647, scale = 0)
    private Double pVenda;
    private String alteraParam;
    private String alteraMarg;
    @Column(precision = 2147483647, scale = 0)
    private Double cofins;
    @Column(precision = 2147483647, scale = 0)
    private Double pis;
    @Column(precision = 2147483647, scale = 0)
    private Double irpj;
    @Column(precision = 2147483647, scale = 0)
    private Double invest;
    @Column(precision = 2147483647, scale = 0)
    private Double finan;
    @Column(precision = 2147483647, scale = 0)
    private Double inad;
    @Column(precision = 2147483647, scale = 0)
    private Double dProm;
    @Column(precision = 2147483647, scale = 0)
    private Double dMark;
    @Column(precision = 2147483647, scale = 0)
    private Double perdas;
    @Column(precision = 2147483647, scale = 0)
    private Double frota;
    @Column(precision = 2147483647, scale = 0)
    private Double margem;
    private String status;
    @Size(max = 60)
    @Column(length = 60)
    private String men1;
    @Size(max = 60)
    @Column(length = 60)
    private String men2;
    @Size(max = 60)
    @Column(length = 60)
    private String men3;
    @Size(max = 60)
    @Column(length = 60)
    private String men4;
    @Size(max = 60)
    @Column(length = 60)
    private String men5;
    @Size(max = 60)
    @Column(length = 60)
    private String men6;
    private String tipIPI;
    private String tipST;
    @Size(max = 150)
    @Column(length = 150)
    private String obsCarreg;
    @Size(max = 10)
    @Column(length = 10)
    private String nr1dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl1dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl1s;
    @Column(precision = 2147483647, scale = 0)
    private Double vl1c;
    @Temporal(TemporalType.DATE)
    private String dv1dup;
    @Size(max = 10)
    @Column(length = 10)
    private String nr2dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl2dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl2s;
    @Column(precision = 2147483647, scale = 0)
    private Double vl2c;
    @Temporal(TemporalType.DATE)
    private String dv2dup;
    @Size(max = 10)
    @Column(length = 10)
    private String nr3dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl3dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl3s;
    @Column(precision = 2147483647, scale = 0)
    private Double vl3c;
    @Temporal(TemporalType.DATE)
    private String dv3dup;
    @Size(max = 10)
    @Column(length = 10)
    private String nr4dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl4dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl4s;
    @Column(precision = 2147483647, scale = 0)
    private Double vl4c;
    @Temporal(TemporalType.DATE)
    private String dv4dup;
    @Size(max = 10)
    @Column(length = 10)
    private String nr5dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl5dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl5s;
    @Column(precision = 2147483647, scale = 0)
    private Double vl5c;
    @Temporal(TemporalType.DATE)
    private String dv5dup;
    @Size(max = 10)
    @Column(length = 10)
    private String nr6dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl6dup;
    @Column(precision = 2147483647, scale = 0)
    private Double vl6s;
    @Column(precision = 2147483647, scale = 0)
    private Double vl6c;
    @Temporal(TemporalType.DATE)
    private String dv6dup;
    private String conferido;
    @Temporal(TemporalType.DATE)
    private String datConferido;
    @Temporal(TemporalType.DATE)
    private String datConfFim;
    private Integer codConf;
    private String notaAceita;
    private String dupAceita;
    private String foiDevolvido;
    @Column(precision = 2147483647, scale = 0)
    private Double valDesconto;
    @Column(precision = 2147483647, scale = 0)
    private Double valDevolvido;
    @Column(precision = 2147483647, scale = 0)
    private Double valFaltas;
    @Column(precision = 2147483647, scale = 0)
    private Double valCheque;
    @Column(precision = 2147483647, scale = 0)
    private Double valDup;
    @Column(precision = 2147483647, scale = 0)
    private Double valCarteira;
    @Column(precision = 2147483647, scale = 0)
    private Double valDinheiro;
    @Column(precision = 2147483647, scale = 0)
    private Double valDif;
    @Column(precision = 2147483647, scale = 0)
    private Double valDeposito;
    @Column(precision = 2147483647, scale = 0)
    private Double totalAcerto;
    private String modCond;
    private Integer codNatAcerto;
    @Size(max = 3)
    @Column(length = 3)
    private String tipCobAcerto;
    @Size(max = 100)
    @Column(length = 100)
    private String obsAcerto;
    private String baixado;
    @Temporal(TemporalType.DATE)
    private String dataBaixa;
    @Temporal(TemporalType.DATE)
    private String dataEntrega;
    private Integer codNotaDev;
    @Size(max = 60)
    @Column(length = 60)
    private String mT1Ped;
    @Size(max = 60)
    @Column(length = 60)
    private String mT2Ped;
    @Column(precision = 2147483647, scale = 0)
    private Double perPeso;
    private String mCom;
    @Temporal(TemporalType.DATE)
    private String dtCom;
    private String emiNot;
    private Integer nroLote;
    private String libGrup;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedidos")
    private ItemsPed itemsPed;

    public Pedidos() {
    }

    public Pedidos(Integer codPed) {
        this.codPed = codPed;
    }

    public Integer getCodPed() {
        return codPed;
    }

    public void setCodPed(Integer codPed) {
        this.codPed = codPed;
    }

    public Integer getSPed() {
        return sPed;
    }

    public void setSPed(Integer sPed) {
        this.sPed = sPed;
    }

    public String getDataPed() {
        return dataPed;
    }

    public void setDataPed(String dataPed) {
        this.dataPed = dataPed;
    }

    public String getDataEmi() {
        return dataEmi;
    }

    public void setDataEmi(String dataEmi) {
        this.dataEmi = dataEmi;
    }

    public String getDataSai() {
        return dataSai;
    }

    public void setDataSai(String dataSai) {
        this.dataSai = dataSai;
    }

    public Integer getCodTpo() {
        return codTpo;
    }

    public void setCodTpo(Integer codTpo) {
        this.codTpo = codTpo;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        this.codCli = codCli;
    }

    public Integer getCodVen() {
        return codVen;
    }

    public void setCodVen(Integer codVen) {
        this.codVen = codVen;
    }

    public Integer getCodTra() {
        return codTra;
    }

    public void setCodTra(Integer codTra) {
        this.codTra = codTra;
    }

    public Double getPerDes1() {
        return perDes1;
    }

    public void setPerDes1(Double perDes1) {
        this.perDes1 = perDes1;
    }

    public Double getPerDes2() {
        return perDes2;
    }

    public void setPerDes2(Double perDes2) {
        this.perDes2 = perDes2;
    }

    public Double getPerDes3() {
        return perDes3;
    }

    public void setPerDes3(Double perDes3) {
        this.perDes3 = perDes3;
    }

    public Long getNroCarga() {
        return nroCarga;
    }

    public void setNroCarga(Long nroCarga) {
        this.nroCarga = nroCarga;
    }

    public Integer getOrdPed() {
        return ordPed;
    }

    public void setOrdPed(Integer ordPed) {
        this.ordPed = ordPed;
    }

    public Double getSeqEntrega() {
        return seqEntrega;
    }

    public void setSeqEntrega(Double seqEntrega) {
        this.seqEntrega = seqEntrega;
    }

    public String getTransf() {
        return transf;
    }

    public void setTransf(String transf) {
        this.transf = transf;
    }

    public Double getPerSem() {
        return perSem;
    }

    public void setPerSem(Double perSem) {
        this.perSem = perSem;
    }

    public Integer getTab() {
        return tab;
    }

    public void setTab(Integer tab) {
        this.tab = tab;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTipCob() {
        return tipCob;
    }

    public void setTipCob(String tipCob) {
        this.tipCob = tipCob;
    }

    public Double getTotPed() {
        return totPed;
    }

    public void setTotPed(Double totPed) {
        this.totPed = totPed;
    }

    public Double getTotPro() {
        return totPro;
    }

    public void setTotPro(Double totPro) {
        this.totPro = totPro;
    }

    public Double getTotDes() {
        return totDes;
    }

    public void setTotDes(Double totDes) {
        this.totDes = totDes;
    }

    public Double getTotBruto() {
        return totBruto;
    }

    public void setTotBruto(Double totBruto) {
        this.totBruto = totBruto;
    }

    public Double getTotFrete() {
        return totFrete;
    }

    public void setTotFrete(Double totFrete) {
        this.totFrete = totFrete;
    }

    public Double getTotBonif() {
        return totBonif;
    }

    public void setTotBonif(Double totBonif) {
        this.totBonif = totBonif;
    }

    public Double getTotBrinde() {
        return totBrinde;
    }

    public void setTotBrinde(Double totBrinde) {
        this.totBrinde = totBrinde;
    }

    public Double getTotBonifB() {
        return totBonifB;
    }

    public void setTotBonifB(Double totBonifB) {
        this.totBonifB = totBonifB;
    }

    public Double getTotBrindeB() {
        return totBrindeB;
    }

    public void setTotBrindeB(Double totBrindeB) {
        this.totBrindeB = totBrindeB;
    }

    public Double getValIPI() {
        return valIPI;
    }

    public void setValIPI(Double valIPI) {
        this.valIPI = valIPI;
    }

    public Double getBaseIcmsCom() {
        return baseIcmsCom;
    }

    public void setBaseIcmsCom(Double baseIcmsCom) {
        this.baseIcmsCom = baseIcmsCom;
    }

    public Double getValIcmsCom() {
        return valIcmsCom;
    }

    public void setValIcmsCom(Double valIcmsCom) {
        this.valIcmsCom = valIcmsCom;
    }

    public Double getPesoLiq() {
        return pesoLiq;
    }

    public void setPesoLiq(Double pesoLiq) {
        this.pesoLiq = pesoLiq;
    }

    public Double getPesoBru() {
        return pesoBru;
    }

    public void setPesoBru(Double pesoBru) {
        this.pesoBru = pesoBru;
    }

    public Integer getTotLan() {
        return totLan;
    }

    public void setTotLan(Integer totLan) {
        this.totLan = totLan;
    }

    public Double getTotPec() {
        return totPec;
    }

    public void setTotPec(Double totPec) {
        this.totPec = totPec;
    }

    public Double getTotIpi() {
        return totIpi;
    }

    public void setTotIpi(Double totIpi) {
        this.totIpi = totIpi;
    }

    public Double getBasIpi() {
        return basIpi;
    }

    public void setBasIpi(Double basIpi) {
        this.basIpi = basIpi;
    }

    public Double getBasIseIpi() {
        return basIseIpi;
    }

    public void setBasIseIpi(Double basIseIpi) {
        this.basIseIpi = basIseIpi;
    }

    public Double getTotCofins() {
        return totCofins;
    }

    public void setTotCofins(Double totCofins) {
        this.totCofins = totCofins;
    }

    public Double getBasCofins() {
        return basCofins;
    }

    public void setBasCofins(Double basCofins) {
        this.basCofins = basCofins;
    }

    public Double getBaseIseCofins() {
        return baseIseCofins;
    }

    public void setBaseIseCofins(Double baseIseCofins) {
        this.baseIseCofins = baseIseCofins;
    }

    public Double getValSubIcms() {
        return valSubIcms;
    }

    public void setValSubIcms(Double valSubIcms) {
        this.valSubIcms = valSubIcms;
    }

    public Double getBasSubIcms() {
        return basSubIcms;
    }

    public void setBasSubIcms(Double basSubIcms) {
        this.basSubIcms = basSubIcms;
    }

    public Double getDescSuf() {
        return descSuf;
    }

    public void setDescSuf(Double descSuf) {
        this.descSuf = descSuf;
    }

    public Double getDescIcms() {
        return descIcms;
    }

    public void setDescIcms(Double descIcms) {
        this.descIcms = descIcms;
    }

    public Double getBaseIcms() {
        return baseIcms;
    }

    public void setBaseIcms(Double baseIcms) {
        this.baseIcms = baseIcms;
    }

    public Double getValIcms() {
        return valIcms;
    }

    public void setValIcms(Double valIcms) {
        this.valIcms = valIcms;
    }

    public Double getTotNota() {
        return totNota;
    }

    public void setTotNota(Double totNota) {
        this.totNota = totNota;
    }

    public Double getTotProCom() {
        return totProCom;
    }

    public void setTotProCom(Double totProCom) {
        this.totProCom = totProCom;
    }

    public Double getTotProSem() {
        return totProSem;
    }

    public void setTotProSem(Double totProSem) {
        this.totProSem = totProSem;
    }

    public Double getValIPICom() {
        return valIPICom;
    }

    public void setValIPICom(Double valIPICom) {
        this.valIPICom = valIPICom;
    }

    public String getCanPed() {
        return canPed;
    }

    public void setCanPed(String canPed) {
        this.canPed = canPed;
    }

    public String getDataCan() {
        return dataCan;
    }

    public void setDataCan(String dataCan) {
        this.dataCan = dataCan;
    }

    public String getMotCan() {
        return motCan;
    }

    public void setMotCan(String motCan) {
        this.motCan = motCan;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public Double getQuant() {
        return quant;
    }

    public void setQuant(Double quant) {
        this.quant = quant;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getNF2Fec() {
        return nF2Fec;
    }

    public void setNF2Fec(Integer nF2Fec) {
        this.nF2Fec = nF2Fec;
    }

    public String getDT2Fec() {
        return dT2Fec;
    }

    public void setDT2Fec(String dT2Fec) {
        this.dT2Fec = dT2Fec;
    }

    public Integer getNtfPed() {
        return ntfPed;
    }

    public void setNtfPed(Integer ntfPed) {
        this.ntfPed = ntfPed;
    }

    public String getDatFec() {
        return datFec;
    }

    public void setDatFec(String datFec) {
        this.datFec = datFec;
    }

    public String getEmitido() {
        return emitido;
    }

    public void setEmitido(String emitido) {
        this.emitido = emitido;
    }

    public String getDatCon() {
        return datCon;
    }

    public void setDatCon(String datCon) {
        this.datCon = datCon;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public Integer getSeqRelacao() {
        return seqRelacao;
    }

    public void setSeqRelacao(Integer seqRelacao) {
        this.seqRelacao = seqRelacao;
    }

    public String getDatRelacao() {
        return datRelacao;
    }

    public void setDatRelacao(String datRelacao) {
        this.datRelacao = datRelacao;
    }

    public Double getLComissao() {
        return lComissao;
    }

    public void setLComissao(Double lComissao) {
        this.lComissao = lComissao;
    }

    public Double getLVenda() {
        return lVenda;
    }

    public void setLVenda(Double lVenda) {
        this.lVenda = lVenda;
    }

    public Double getLPrUnit() {
        return lPrUnit;
    }

    public void setLPrUnit(Double lPrUnit) {
        this.lPrUnit = lPrUnit;
    }

    public Double getPComissao() {
        return pComissao;
    }

    public void setPComissao(Double pComissao) {
        this.pComissao = pComissao;
    }

    public Double getPVenda() {
        return pVenda;
    }

    public void setPVenda(Double pVenda) {
        this.pVenda = pVenda;
    }

    public String getAlteraParam() {
        return alteraParam;
    }

    public void setAlteraParam(String alteraParam) {
        this.alteraParam = alteraParam;
    }

    public String getAlteraMarg() {
        return alteraMarg;
    }

    public void setAlteraMarg(String alteraMarg) {
        this.alteraMarg = alteraMarg;
    }

    public Double getCofins() {
        return cofins;
    }

    public void setCofins(Double cofins) {
        this.cofins = cofins;
    }

    public Double getPis() {
        return pis;
    }

    public void setPis(Double pis) {
        this.pis = pis;
    }

    public Double getIrpj() {
        return irpj;
    }

    public void setIrpj(Double irpj) {
        this.irpj = irpj;
    }

    public Double getInvest() {
        return invest;
    }

    public void setInvest(Double invest) {
        this.invest = invest;
    }

    public Double getFinan() {
        return finan;
    }

    public void setFinan(Double finan) {
        this.finan = finan;
    }

    public Double getInad() {
        return inad;
    }

    public void setInad(Double inad) {
        this.inad = inad;
    }

    public Double getDProm() {
        return dProm;
    }

    public void setDProm(Double dProm) {
        this.dProm = dProm;
    }

    public Double getDMark() {
        return dMark;
    }

    public void setDMark(Double dMark) {
        this.dMark = dMark;
    }

    public Double getPerdas() {
        return perdas;
    }

    public void setPerdas(Double perdas) {
        this.perdas = perdas;
    }

    public Double getFrota() {
        return frota;
    }

    public void setFrota(Double frota) {
        this.frota = frota;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMen1() {
        return men1;
    }

    public void setMen1(String men1) {
        this.men1 = men1;
    }

    public String getMen2() {
        return men2;
    }

    public void setMen2(String men2) {
        this.men2 = men2;
    }

    public String getMen3() {
        return men3;
    }

    public void setMen3(String men3) {
        this.men3 = men3;
    }

    public String getMen4() {
        return men4;
    }

    public void setMen4(String men4) {
        this.men4 = men4;
    }

    public String getMen5() {
        return men5;
    }

    public void setMen5(String men5) {
        this.men5 = men5;
    }

    public String getMen6() {
        return men6;
    }

    public void setMen6(String men6) {
        this.men6 = men6;
    }

    public String getTipIPI() {
        return tipIPI;
    }

    public void setTipIPI(String tipIPI) {
        this.tipIPI = tipIPI;
    }

    public String getTipST() {
        return tipST;
    }

    public void setTipST(String tipST) {
        this.tipST = tipST;
    }

    public String getObsCarreg() {
        return obsCarreg;
    }

    public void setObsCarreg(String obsCarreg) {
        this.obsCarreg = obsCarreg;
    }

    public String getNr1dup() {
        return nr1dup;
    }

    public void setNr1dup(String nr1dup) {
        this.nr1dup = nr1dup;
    }

    public Double getVl1dup() {
        return vl1dup;
    }

    public void setVl1dup(Double vl1dup) {
        this.vl1dup = vl1dup;
    }

    public Double getVl1s() {
        return vl1s;
    }

    public void setVl1s(Double vl1s) {
        this.vl1s = vl1s;
    }

    public Double getVl1c() {
        return vl1c;
    }

    public void setVl1c(Double vl1c) {
        this.vl1c = vl1c;
    }

    public String getDv1dup() {
        return dv1dup;
    }

    public void setDv1dup(String dv1dup) {
        this.dv1dup = dv1dup;
    }

    public String getNr2dup() {
        return nr2dup;
    }

    public void setNr2dup(String nr2dup) {
        this.nr2dup = nr2dup;
    }

    public Double getVl2dup() {
        return vl2dup;
    }

    public void setVl2dup(Double vl2dup) {
        this.vl2dup = vl2dup;
    }

    public Double getVl2s() {
        return vl2s;
    }

    public void setVl2s(Double vl2s) {
        this.vl2s = vl2s;
    }

    public Double getVl2c() {
        return vl2c;
    }

    public void setVl2c(Double vl2c) {
        this.vl2c = vl2c;
    }

    public String getDv2dup() {
        return dv2dup;
    }

    public void setDv2dup(String dv2dup) {
        this.dv2dup = dv2dup;
    }

    public String getNr3dup() {
        return nr3dup;
    }

    public void setNr3dup(String nr3dup) {
        this.nr3dup = nr3dup;
    }

    public Double getVl3dup() {
        return vl3dup;
    }

    public void setVl3dup(Double vl3dup) {
        this.vl3dup = vl3dup;
    }

    public Double getVl3s() {
        return vl3s;
    }

    public void setVl3s(Double vl3s) {
        this.vl3s = vl3s;
    }

    public Double getVl3c() {
        return vl3c;
    }

    public void setVl3c(Double vl3c) {
        this.vl3c = vl3c;
    }

    public String getDv3dup() {
        return dv3dup;
    }

    public void setDv3dup(String dv3dup) {
        this.dv3dup = dv3dup;
    }

    public String getNr4dup() {
        return nr4dup;
    }

    public void setNr4dup(String nr4dup) {
        this.nr4dup = nr4dup;
    }

    public Double getVl4dup() {
        return vl4dup;
    }

    public void setVl4dup(Double vl4dup) {
        this.vl4dup = vl4dup;
    }

    public Double getVl4s() {
        return vl4s;
    }

    public void setVl4s(Double vl4s) {
        this.vl4s = vl4s;
    }

    public Double getVl4c() {
        return vl4c;
    }

    public void setVl4c(Double vl4c) {
        this.vl4c = vl4c;
    }

    public String getDv4dup() {
        return dv4dup;
    }

    public void setDv4dup(String dv4dup) {
        this.dv4dup = dv4dup;
    }

    public String getNr5dup() {
        return nr5dup;
    }

    public void setNr5dup(String nr5dup) {
        this.nr5dup = nr5dup;
    }

    public Double getVl5dup() {
        return vl5dup;
    }

    public void setVl5dup(Double vl5dup) {
        this.vl5dup = vl5dup;
    }

    public Double getVl5s() {
        return vl5s;
    }

    public void setVl5s(Double vl5s) {
        this.vl5s = vl5s;
    }

    public Double getVl5c() {
        return vl5c;
    }

    public void setVl5c(Double vl5c) {
        this.vl5c = vl5c;
    }

    public String getDv5dup() {
        return dv5dup;
    }

    public void setDv5dup(String dv5dup) {
        this.dv5dup = dv5dup;
    }

    public String getNr6dup() {
        return nr6dup;
    }

    public void setNr6dup(String nr6dup) {
        this.nr6dup = nr6dup;
    }

    public Double getVl6dup() {
        return vl6dup;
    }

    public void setVl6dup(Double vl6dup) {
        this.vl6dup = vl6dup;
    }

    public Double getVl6s() {
        return vl6s;
    }

    public void setVl6s(Double vl6s) {
        this.vl6s = vl6s;
    }

    public Double getVl6c() {
        return vl6c;
    }

    public void setVl6c(Double vl6c) {
        this.vl6c = vl6c;
    }

    public String getDv6dup() {
        return dv6dup;
    }

    public void setDv6dup(String dv6dup) {
        this.dv6dup = dv6dup;
    }

    public String getConferido() {
        return conferido;
    }

    public void setConferido(String conferido) {
        this.conferido = conferido;
    }

    public String getDatConferido() {
        return datConferido;
    }

    public void setDatConferido(String datConferido) {
        this.datConferido = datConferido;
    }

    public String getDatConfFim() {
        return datConfFim;
    }

    public void setDatConfFim(String datConfFim) {
        this.datConfFim = datConfFim;
    }

    public Integer getCodConf() {
        return codConf;
    }

    public void setCodConf(Integer codConf) {
        this.codConf = codConf;
    }

    public String getNotaAceita() {
        return notaAceita;
    }

    public void setNotaAceita(String notaAceita) {
        this.notaAceita = notaAceita;
    }

    public String getDupAceita() {
        return dupAceita;
    }

    public void setDupAceita(String dupAceita) {
        this.dupAceita = dupAceita;
    }

    public String getFoiDevolvido() {
        return foiDevolvido;
    }

    public void setFoiDevolvido(String foiDevolvido) {
        this.foiDevolvido = foiDevolvido;
    }

    public Double getValDesconto() {
        return valDesconto;
    }

    public void setValDesconto(Double valDesconto) {
        this.valDesconto = valDesconto;
    }

    public Double getValDevolvido() {
        return valDevolvido;
    }

    public void setValDevolvido(Double valDevolvido) {
        this.valDevolvido = valDevolvido;
    }

    public Double getValFaltas() {
        return valFaltas;
    }

    public void setValFaltas(Double valFaltas) {
        this.valFaltas = valFaltas;
    }

    public Double getValCheque() {
        return valCheque;
    }

    public void setValCheque(Double valCheque) {
        this.valCheque = valCheque;
    }

    public Double getValDup() {
        return valDup;
    }

    public void setValDup(Double valDup) {
        this.valDup = valDup;
    }

    public Double getValCarteira() {
        return valCarteira;
    }

    public void setValCarteira(Double valCarteira) {
        this.valCarteira = valCarteira;
    }

    public Double getValDinheiro() {
        return valDinheiro;
    }

    public void setValDinheiro(Double valDinheiro) {
        this.valDinheiro = valDinheiro;
    }

    public Double getValDif() {
        return valDif;
    }

    public void setValDif(Double valDif) {
        this.valDif = valDif;
    }

    public Double getValDeposito() {
        return valDeposito;
    }

    public void setValDeposito(Double valDeposito) {
        this.valDeposito = valDeposito;
    }

    public Double getTotalAcerto() {
        return totalAcerto;
    }

    public void setTotalAcerto(Double totalAcerto) {
        this.totalAcerto = totalAcerto;
    }

    public String getModCond() {
        return modCond;
    }

    public void setModCond(String modCond) {
        this.modCond = modCond;
    }

    public Integer getCodNatAcerto() {
        return codNatAcerto;
    }

    public void setCodNatAcerto(Integer codNatAcerto) {
        this.codNatAcerto = codNatAcerto;
    }

    public String getTipCobAcerto() {
        return tipCobAcerto;
    }

    public void setTipCobAcerto(String tipCobAcerto) {
        this.tipCobAcerto = tipCobAcerto;
    }

    public String getObsAcerto() {
        return obsAcerto;
    }

    public void setObsAcerto(String obsAcerto) {
        this.obsAcerto = obsAcerto;
    }

    public String getBaixado() {
        return baixado;
    }

    public void setBaixado(String baixado) {
        this.baixado = baixado;
    }

    public String getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(String dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Integer getCodNotaDev() {
        return codNotaDev;
    }

    public void setCodNotaDev(Integer codNotaDev) {
        this.codNotaDev = codNotaDev;
    }

    public String getMT1Ped() {
        return mT1Ped;
    }

    public void setMT1Ped(String mT1Ped) {
        this.mT1Ped = mT1Ped;
    }

    public String getMT2Ped() {
        return mT2Ped;
    }

    public void setMT2Ped(String mT2Ped) {
        this.mT2Ped = mT2Ped;
    }

    public Double getPerPeso() {
        return perPeso;
    }

    public void setPerPeso(Double perPeso) {
        this.perPeso = perPeso;
    }

    public String getMCom() {
        return mCom;
    }

    public void setMCom(String mCom) {
        this.mCom = mCom;
    }

    public String getDtCom() {
        return dtCom;
    }

    public void setDtCom(String dtCom) {
        this.dtCom = dtCom;
    }

    public String getEmiNot() {
        return emiNot;
    }

    public void setEmiNot(String emiNot) {
        this.emiNot = emiNot;
    }

    public Integer getNroLote() {
        return nroLote;
    }

    public void setNroLote(Integer nroLote) {
        this.nroLote = nroLote;
    }

    public String getLibGrup() {
        return libGrup;
    }

    public void setLibGrup(String libGrup) {
        this.libGrup = libGrup;
    }

    public ItemsPed getItemsPed() {
        return itemsPed;
    }

    public void setItemsPed(ItemsPed itemsPed) {
        this.itemsPed = itemsPed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPed != null ? codPed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.codPed == null && other.codPed != null) || (this.codPed != null && !this.codPed.equals(other.codPed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pedidos[ codPed=" + codPed + " ]";
    }
    
}
