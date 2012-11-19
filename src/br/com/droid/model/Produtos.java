/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.droid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M
 */
@Entity
@Table(catalog = "gdroid", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByCodPro", query = "SELECT p FROM Produtos p WHERE p.codPro = :codPro"),
    @NamedQuery(name = "Produtos.findByCodBarra", query = "SELECT p FROM Produtos p WHERE p.codBarra = :codBarra"),
    @NamedQuery(name = "Produtos.findByCodSubGrupo", query = "SELECT p FROM Produtos p WHERE p.codSubGrupo = :codSubGrupo"),
    @NamedQuery(name = "Produtos.findByCodFabrica", query = "SELECT p FROM Produtos p WHERE p.codFabrica = :codFabrica"),
    @NamedQuery(name = "Produtos.findByDesPro", query = "SELECT p FROM Produtos p WHERE p.desPro = :desPro"),
    @NamedQuery(name = "Produtos.findByUnid", query = "SELECT p FROM Produtos p WHERE p.unid = :unid"),
    @NamedQuery(name = "Produtos.findByPesoLiq", query = "SELECT p FROM Produtos p WHERE p.pesoLiq = :pesoLiq"),
    @NamedQuery(name = "Produtos.findByPesoBru", query = "SELECT p FROM Produtos p WHERE p.pesoBru = :pesoBru"),
    @NamedQuery(name = "Produtos.findBySitTrib", query = "SELECT p FROM Produtos p WHERE p.sitTrib = :sitTrib"),
    @NamedQuery(name = "Produtos.findByIcms", query = "SELECT p FROM Produtos p WHERE p.icms = :icms"),
    @NamedQuery(name = "Produtos.findByIpi", query = "SELECT p FROM Produtos p WHERE p.ipi = :ipi"),
    @NamedQuery(name = "Produtos.findByFrete", query = "SELECT p FROM Produtos p WHERE p.frete = :frete"),
    @NamedQuery(name = "Produtos.findByClassFiscal", query = "SELECT p FROM Produtos p WHERE p.classFiscal = :classFiscal"),
    @NamedQuery(name = "Produtos.findByCustFab", query = "SELECT p FROM Produtos p WHERE p.custFab = :custFab"),
    @NamedQuery(name = "Produtos.findByCustEng", query = "SELECT p FROM Produtos p WHERE p.custEng = :custEng"),
    @NamedQuery(name = "Produtos.findByCustEnt", query = "SELECT p FROM Produtos p WHERE p.custEnt = :custEnt"),
    @NamedQuery(name = "Produtos.findByCustMed", query = "SELECT p FROM Produtos p WHERE p.custMed = :custMed"),
    @NamedQuery(name = "Produtos.findByCustTot", query = "SELECT p FROM Produtos p WHERE p.custTot = :custTot"),
    @NamedQuery(name = "Produtos.findByDespFixa", query = "SELECT p FROM Produtos p WHERE p.despFixa = :despFixa"),
    @NamedQuery(name = "Produtos.findByPrVen1", query = "SELECT p FROM Produtos p WHERE p.prVen1 = :prVen1"),
    @NamedQuery(name = "Produtos.findByPrVen2", query = "SELECT p FROM Produtos p WHERE p.prVen2 = :prVen2"),
    @NamedQuery(name = "Produtos.findByPrVen3", query = "SELECT p FROM Produtos p WHERE p.prVen3 = :prVen3"),
    @NamedQuery(name = "Produtos.findByPrVen4", query = "SELECT p FROM Produtos p WHERE p.prVen4 = :prVen4"),
    @NamedQuery(name = "Produtos.findByTipo", query = "SELECT p FROM Produtos p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Produtos.findByTipoProduto", query = "SELECT p FROM Produtos p WHERE p.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "Produtos.findByProdVenda", query = "SELECT p FROM Produtos p WHERE p.prodVenda = :prodVenda"),
    @NamedQuery(name = "Produtos.findByMComp", query = "SELECT p FROM Produtos p WHERE p.mComp = :mComp"),
    @NamedQuery(name = "Produtos.findByMDiam", query = "SELECT p FROM Produtos p WHERE p.mDiam = :mDiam"),
    @NamedQuery(name = "Produtos.findByMLarg", query = "SELECT p FROM Produtos p WHERE p.mLarg = :mLarg"),
    @NamedQuery(name = "Produtos.findByMEsp", query = "SELECT p FROM Produtos p WHERE p.mEsp = :mEsp"),
    @NamedQuery(name = "Produtos.findByCamTeflon", query = "SELECT p FROM Produtos p WHERE p.camTeflon = :camTeflon"),
    @NamedQuery(name = "Produtos.findByPesoTeflon", query = "SELECT p FROM Produtos p WHERE p.pesoTeflon = :pesoTeflon"),
    @NamedQuery(name = "Produtos.findByCalArea", query = "SELECT p FROM Produtos p WHERE p.calArea = :calArea"),
    @NamedQuery(name = "Produtos.findByEstMinimo", query = "SELECT p FROM Produtos p WHERE p.estMinimo = :estMinimo"),
    @NamedQuery(name = "Produtos.findByTamanho", query = "SELECT p FROM Produtos p WHERE p.tamanho = :tamanho"),
    @NamedQuery(name = "Produtos.findByFatorTransf", query = "SELECT p FROM Produtos p WHERE p.fatorTransf = :fatorTransf"),
    @NamedQuery(name = "Produtos.findByUltValor", query = "SELECT p FROM Produtos p WHERE p.ultValor = :ultValor"),
    @NamedQuery(name = "Produtos.findByUltCompra", query = "SELECT p FROM Produtos p WHERE p.ultCompra = :ultCompra"),
    @NamedQuery(name = "Produtos.findByUltCodNat", query = "SELECT p FROM Produtos p WHERE p.ultCodNat = :ultCodNat"),
    @NamedQuery(name = "Produtos.findByEd", query = "SELECT p FROM Produtos p WHERE p.ed = :ed"),
    @NamedQuery(name = "Produtos.findByMCheck", query = "SELECT p FROM Produtos p WHERE p.mCheck = :mCheck"),
    @NamedQuery(name = "Produtos.findByQdeUnid", query = "SELECT p FROM Produtos p WHERE p.qdeUnid = :qdeUnid"),
    @NamedQuery(name = "Produtos.findByUnidQde", query = "SELECT p FROM Produtos p WHERE p.unidQde = :unidQde"),
    @NamedQuery(name = "Produtos.findByMEng", query = "SELECT p FROM Produtos p WHERE p.mEng = :mEng"),
    @NamedQuery(name = "Produtos.findByDatEng", query = "SELECT p FROM Produtos p WHERE p.datEng = :datEng"),
    @NamedQuery(name = "Produtos.findByEhKit", query = "SELECT p FROM Produtos p WHERE p.ehKit = :ehKit"),
    @NamedQuery(name = "Produtos.findByMVal", query = "SELECT p FROM Produtos p WHERE p.mVal = :mVal"),
    @NamedQuery(name = "Produtos.findByDatVal", query = "SELECT p FROM Produtos p WHERE p.datVal = :datVal"),
    @NamedQuery(name = "Produtos.findByAltEmb", query = "SELECT p FROM Produtos p WHERE p.altEmb = :altEmb"),
    @NamedQuery(name = "Produtos.findByLarEmb", query = "SELECT p FROM Produtos p WHERE p.larEmb = :larEmb"),
    @NamedQuery(name = "Produtos.findByComEmb", query = "SELECT p FROM Produtos p WHERE p.comEmb = :comEmb"),
    @NamedQuery(name = "Produtos.findByCubEmb", query = "SELECT p FROM Produtos p WHERE p.cubEmb = :cubEmb"),
    @NamedQuery(name = "Produtos.findByQdeEmb", query = "SELECT p FROM Produtos p WHERE p.qdeEmb = :qdeEmb"),
    @NamedQuery(name = "Produtos.findByObs", query = "SELECT p FROM Produtos p WHERE p.obs = :obs"),
    @NamedQuery(name = "Produtos.findByAltCorpo", query = "SELECT p FROM Produtos p WHERE p.altCorpo = :altCorpo"),
    @NamedQuery(name = "Produtos.findByLarCorpo", query = "SELECT p FROM Produtos p WHERE p.larCorpo = :larCorpo"),
    @NamedQuery(name = "Produtos.findByComCorpo", query = "SELECT p FROM Produtos p WHERE p.comCorpo = :comCorpo"),
    @NamedQuery(name = "Produtos.findByCubCorpo", query = "SELECT p FROM Produtos p WHERE p.cubCorpo = :cubCorpo"),
    @NamedQuery(name = "Produtos.findByLitCorpo", query = "SELECT p FROM Produtos p WHERE p.litCorpo = :litCorpo"),
    @NamedQuery(name = "Produtos.findByTipoFicha", query = "SELECT p FROM Produtos p WHERE p.tipoFicha = :tipoFicha"),
    @NamedQuery(name = "Produtos.findByMedida", query = "SELECT p FROM Produtos p WHERE p.medida = :medida"),
    @NamedQuery(name = "Produtos.findByFicha", query = "SELECT p FROM Produtos p WHERE p.ficha = :ficha"),
    @NamedQuery(name = "Produtos.findByTempo", query = "SELECT p FROM Produtos p WHERE p.tempo = :tempo"),
    @NamedQuery(name = "Produtos.findByInativo", query = "SELECT p FROM Produtos p WHERE p.inativo = :inativo"),
    @NamedQuery(name = "Produtos.findByCipi", query = "SELECT p FROM Produtos p WHERE p.cipi = :cipi"),
    @NamedQuery(name = "Produtos.findByCstipi", query = "SELECT p FROM Produtos p WHERE p.cstipi = :cstipi"),
    @NamedQuery(name = "Produtos.findByCstpis", query = "SELECT p FROM Produtos p WHERE p.cstpis = :cstpis"),
    @NamedQuery(name = "Produtos.findByPis", query = "SELECT p FROM Produtos p WHERE p.pis = :pis"),
    @NamedQuery(name = "Produtos.findByCstcofins", query = "SELECT p FROM Produtos p WHERE p.cstcofins = :cstcofins"),
    @NamedQuery(name = "Produtos.findByCofins", query = "SELECT p FROM Produtos p WHERE p.cofins = :cofins"),
    @NamedQuery(name = "Produtos.findByOrig", query = "SELECT p FROM Produtos p WHERE p.orig = :orig"),
    @NamedQuery(name = "Produtos.findByNcm", query = "SELECT p FROM Produtos p WHERE p.ncm = :ncm"),
    @NamedQuery(name = "Produtos.findByCavidades", query = "SELECT p FROM Produtos p WHERE p.cavidades = :cavidades"),
    @NamedQuery(name = "Produtos.findByLargPlFund", query = "SELECT p FROM Produtos p WHERE p.largPlFund = :largPlFund"),
    @NamedQuery(name = "Produtos.findByPerda", query = "SELECT p FROM Produtos p WHERE p.perda = :perda"),
    @NamedQuery(name = "Produtos.findByEspDesb", query = "SELECT p FROM Produtos p WHERE p.espDesb = :espDesb"),
    @NamedQuery(name = "Produtos.findByFator", query = "SELECT p FROM Produtos p WHERE p.fator = :fator"),
    @NamedQuery(name = "Produtos.findByPerdaLarg", query = "SELECT p FROM Produtos p WHERE p.perdaLarg = :perdaLarg"),
    @NamedQuery(name = "Produtos.findByNroCorte", query = "SELECT p FROM Produtos p WHERE p.nroCorte = :nroCorte"),
    @NamedQuery(name = "Produtos.findBySeqProd", query = "SELECT p FROM Produtos p WHERE p.seqProd = :seqProd"),
    @NamedQuery(name = "Produtos.findByBox", query = "SELECT p FROM Produtos p WHERE p.box = :box"),
    @NamedQuery(name = "Produtos.findByAndar", query = "SELECT p FROM Produtos p WHERE p.andar = :andar"),
    @NamedQuery(name = "Produtos.findByCodFor", query = "SELECT p FROM Produtos p WHERE p.codFor = :codFor"),
    @NamedQuery(name = "Produtos.findByProdVendaNot", query = "SELECT p FROM Produtos p WHERE p.prodVendaNot = :prodVendaNot")})
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codPro;
    @Size(max = 14)
    @Column(length = 14)
    private String codBarra;
    private Integer codSubGrupo;
    private Integer codFabrica;
    @Size(max = 45)
    @Column(length = 45)
    private String desPro;
    @Size(max = 3)
    @Column(length = 3)
    private String unid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 2147483647, scale = 0)
    private Double pesoLiq;
    @Column(precision = 2147483647, scale = 0)
    private Double pesoBru;
    @Size(max = 3)
    @Column(length = 3)
    private String sitTrib;
    @Column(precision = 2147483647, scale = 0)
    private Double icms;
    @Column(precision = 2147483647, scale = 0)
    private Double ipi;
    @Column(precision = 2147483647, scale = 0)
    private Double frete;
    @Size(max = 1)
    @Column(length = 1)
    private String classFiscal;
    @Column(precision = 2147483647, scale = 0)
    private Double custFab;
    @Column(precision = 2147483647, scale = 0)
    private Double custEng;
    @Column(precision = 18, scale = 6)
    private BigDecimal custEnt;
    @Column(precision = 2147483647, scale = 0)
    private Double custMed;
    @Column(precision = 2147483647, scale = 0)
    private Double custTot;
    @Column(precision = 2147483647, scale = 0)
    private Double despFixa;
    @Column(precision = 2147483647, scale = 0)
    private Double prVen1;
    @Column(precision = 2147483647, scale = 0)
    private Double prVen2;
    @Column(precision = 2147483647, scale = 0)
    private Double prVen3;
    @Column(precision = 2147483647, scale = 0)
    private Double prVen4;
    @Size(max = 2)
    @Column(length = 2)
    private String tipo;
    @Size(max = 2)
    @Column(length = 2)
    private String tipoProduto;
    private Boolean prodVenda;
    @Column(precision = 17, scale = 17)
    private Double mComp;
    @Column(precision = 17, scale = 17)
    private Double mDiam;
    @Column(precision = 17, scale = 17)
    private Double mLarg;
    @Column(precision = 17, scale = 17)
    private Double mEsp;
    private Integer camTeflon;
    @Column(precision = 17, scale = 17)
    private Double pesoTeflon;
    @Column(precision = 17, scale = 17)
    private Double calArea;
    @Column(precision = 2147483647, scale = 0)
    private Double estMinimo;
    @Size(max = 30)
    @Column(length = 30)
    private String tamanho;
    @Column(precision = 18, scale = 5)
    private BigDecimal fatorTransf;
    @Column(precision = 18, scale = 6)
    private BigDecimal ultValor;
    @Temporal(TemporalType.DATE)
    private String ultCompra;
    private Integer ultCodNat;
    private String ed;
    private Boolean mCheck;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeUnid;
    @Size(max = 3)
    @Column(length = 3)
    private String unidQde;
    private String mEng;
    @Temporal(TemporalType.DATE)
    private String datEng;
    private String ehKit;
    private String mVal;
    @Temporal(TemporalType.DATE)
    private String datVal;
    @Column(precision = 2147483647, scale = 0)
    private Double altEmb;
    @Column(precision = 2147483647, scale = 0)
    private Double larEmb;
    @Column(precision = 2147483647, scale = 0)
    private Double comEmb;
    @Column(precision = 2147483647, scale = 0)
    private Double cubEmb;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeEmb;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String obs;
    @Column(precision = 2147483647, scale = 0)
    private Double altCorpo;
    @Column(precision = 2147483647, scale = 0)
    private Double larCorpo;
    @Column(precision = 2147483647, scale = 0)
    private Double comCorpo;
    @Column(precision = 2147483647, scale = 0)
    private Double cubCorpo;
    @Column(precision = 2147483647, scale = 0)
    private Double litCorpo;
    private String tipoFicha;
    private Boolean medida;
    private Boolean ficha;
    private Boolean tempo;
    private Boolean inativo;
    @Size(max = 3)
    @Column(length = 3)
    private String cipi;
    @Size(max = 2)
    @Column(length = 2)
    private String cstipi;
    @Size(max = 2)
    @Column(length = 2)
    private String cstpis;
    @Column(precision = 2147483647, scale = 0)
    private Double pis;
    @Size(max = 2)
    @Column(length = 2)
    private String cstcofins;
    @Column(precision = 2147483647, scale = 0)
    private Double cofins;
    private String orig;
    @Size(max = 8)
    @Column(length = 8)
    private String ncm;
    private Integer cavidades;
    private Integer largPlFund;
    @Column(precision = 2147483647, scale = 0)
    private Double perda;
    @Column(precision = 2147483647, scale = 0)
    private Double espDesb;
    private Integer fator;
    @Column(precision = 2147483647, scale = 0)
    private Double perdaLarg;
    @Column(precision = 2147483647, scale = 0)
    private Double nroCorte;
    private Integer seqProd;
    private Integer box;
    @Size(max = 2)
    @Column(length = 2)
    private String andar;
    private Integer codFor;
    private Boolean prodVendaNot;
    @JoinColumn(name = "CodGrupo", referencedColumnName = "CodGrupo")
    @ManyToOne
    private Integer codGrupo;
    @OneToMany(mappedBy = "codPro")
    private List<ItemsPed> itemsPedList;

    public Produtos() {
    }

    public Produtos(Integer codPro) {
        this.codPro = codPro;
    }

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        this.codPro = codPro;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public Integer getCodSubGrupo() {
        return codSubGrupo;
    }

    public void setCodSubGrupo(Integer codSubGrupo) {
        this.codSubGrupo = codSubGrupo;
    }

    public Integer getCodFabrica() {
        return codFabrica;
    }

    public void setCodFabrica(Integer codFabrica) {
        this.codFabrica = codFabrica;
    }

    public String getDesPro() {
        return desPro;
    }

    public void setDesPro(String desPro) {
        this.desPro = desPro;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
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

    public String getSitTrib() {
        return sitTrib;
    }

    public void setSitTrib(String sitTrib) {
        this.sitTrib = sitTrib;
    }

    public Double getIcms() {
        return icms;
    }

    public void setIcms(Double icms) {
        this.icms = icms;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public String getClassFiscal() {
        return classFiscal;
    }

    public void setClassFiscal(String classFiscal) {
        this.classFiscal = classFiscal;
    }

    public Double getCustFab() {
        return custFab;
    }

    public void setCustFab(Double custFab) {
        this.custFab = custFab;
    }

    public Double getCustEng() {
        return custEng;
    }

    public void setCustEng(Double custEng) {
        this.custEng = custEng;
    }

    public BigDecimal getCustEnt() {
        return custEnt;
    }

    public void setCustEnt(BigDecimal custEnt) {
        this.custEnt = custEnt;
    }

    public Double getCustMed() {
        return custMed;
    }

    public void setCustMed(Double custMed) {
        this.custMed = custMed;
    }

    public Double getCustTot() {
        return custTot;
    }

    public void setCustTot(Double custTot) {
        this.custTot = custTot;
    }

    public Double getDespFixa() {
        return despFixa;
    }

    public void setDespFixa(Double despFixa) {
        this.despFixa = despFixa;
    }

    public Double getPrVen1() {
        return prVen1;
    }

    public void setPrVen1(Double prVen1) {
        this.prVen1 = prVen1;
    }

    public Double getPrVen2() {
        return prVen2;
    }

    public void setPrVen2(Double prVen2) {
        this.prVen2 = prVen2;
    }

    public Double getPrVen3() {
        return prVen3;
    }

    public void setPrVen3(Double prVen3) {
        this.prVen3 = prVen3;
    }

    public Double getPrVen4() {
        return prVen4;
    }

    public void setPrVen4(Double prVen4) {
        this.prVen4 = prVen4;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Boolean getProdVenda() {
        return prodVenda;
    }

    public void setProdVenda(Boolean prodVenda) {
        this.prodVenda = prodVenda;
    }

    public Double getMComp() {
        return mComp;
    }

    public void setMComp(Double mComp) {
        this.mComp = mComp;
    }

    public Double getMDiam() {
        return mDiam;
    }

    public void setMDiam(Double mDiam) {
        this.mDiam = mDiam;
    }

    public Double getMLarg() {
        return mLarg;
    }

    public void setMLarg(Double mLarg) {
        this.mLarg = mLarg;
    }

    public Double getMEsp() {
        return mEsp;
    }

    public void setMEsp(Double mEsp) {
        this.mEsp = mEsp;
    }

    public Integer getCamTeflon() {
        return camTeflon;
    }

    public void setCamTeflon(Integer camTeflon) {
        this.camTeflon = camTeflon;
    }

    public Double getPesoTeflon() {
        return pesoTeflon;
    }

    public void setPesoTeflon(Double pesoTeflon) {
        this.pesoTeflon = pesoTeflon;
    }

    public Double getCalArea() {
        return calArea;
    }

    public void setCalArea(Double calArea) {
        this.calArea = calArea;
    }

    public Double getEstMinimo() {
        return estMinimo;
    }

    public void setEstMinimo(Double estMinimo) {
        this.estMinimo = estMinimo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getFatorTransf() {
        return fatorTransf;
    }

    public void setFatorTransf(BigDecimal fatorTransf) {
        this.fatorTransf = fatorTransf;
    }

    public BigDecimal getUltValor() {
        return ultValor;
    }

    public void setUltValor(BigDecimal ultValor) {
        this.ultValor = ultValor;
    }

    public String getUltCompra() {
        return ultCompra;
    }

    public void setUltCompra(String ultCompra) {
        this.ultCompra = ultCompra;
    }

    public Integer getUltCodNat() {
        return ultCodNat;
    }

    public void setUltCodNat(Integer ultCodNat) {
        this.ultCodNat = ultCodNat;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public Boolean getMCheck() {
        return mCheck;
    }

    public void setMCheck(Boolean mCheck) {
        this.mCheck = mCheck;
    }

    public Double getQdeUnid() {
        return qdeUnid;
    }

    public void setQdeUnid(Double qdeUnid) {
        this.qdeUnid = qdeUnid;
    }

    public String getUnidQde() {
        return unidQde;
    }

    public void setUnidQde(String unidQde) {
        this.unidQde = unidQde;
    }

    public String getMEng() {
        return mEng;
    }

    public void setMEng(String mEng) {
        this.mEng = mEng;
    }

    public String getDatEng() {
        return datEng;
    }

    public void setDatEng(String datEng) {
        this.datEng = datEng;
    }

    public String getEhKit() {
        return ehKit;
    }

    public void setEhKit(String ehKit) {
        this.ehKit = ehKit;
    }

    public String getMVal() {
        return mVal;
    }

    public void setMVal(String mVal) {
        this.mVal = mVal;
    }

    public String getDatVal() {
        return datVal;
    }

    public void setDatVal(String datVal) {
        this.datVal = datVal;
    }

    public Double getAltEmb() {
        return altEmb;
    }

    public void setAltEmb(Double altEmb) {
        this.altEmb = altEmb;
    }

    public Double getLarEmb() {
        return larEmb;
    }

    public void setLarEmb(Double larEmb) {
        this.larEmb = larEmb;
    }

    public Double getComEmb() {
        return comEmb;
    }

    public void setComEmb(Double comEmb) {
        this.comEmb = comEmb;
    }

    public Double getCubEmb() {
        return cubEmb;
    }

    public void setCubEmb(Double cubEmb) {
        this.cubEmb = cubEmb;
    }

    public Double getQdeEmb() {
        return qdeEmb;
    }

    public void setQdeEmb(Double qdeEmb) {
        this.qdeEmb = qdeEmb;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Double getAltCorpo() {
        return altCorpo;
    }

    public void setAltCorpo(Double altCorpo) {
        this.altCorpo = altCorpo;
    }

    public Double getLarCorpo() {
        return larCorpo;
    }

    public void setLarCorpo(Double larCorpo) {
        this.larCorpo = larCorpo;
    }

    public Double getComCorpo() {
        return comCorpo;
    }

    public void setComCorpo(Double comCorpo) {
        this.comCorpo = comCorpo;
    }

    public Double getCubCorpo() {
        return cubCorpo;
    }

    public void setCubCorpo(Double cubCorpo) {
        this.cubCorpo = cubCorpo;
    }

    public Double getLitCorpo() {
        return litCorpo;
    }

    public void setLitCorpo(Double litCorpo) {
        this.litCorpo = litCorpo;
    }

    public String getTipoFicha() {
        return tipoFicha;
    }

    public void setTipoFicha(String tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    public Boolean getMedida() {
        return medida;
    }

    public void setMedida(Boolean medida) {
        this.medida = medida;
    }

    public Boolean getFicha() {
        return ficha;
    }

    public void setFicha(Boolean ficha) {
        this.ficha = ficha;
    }

    public Boolean getTempo() {
        return tempo;
    }

    public void setTempo(Boolean tempo) {
        this.tempo = tempo;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public String getCipi() {
        return cipi;
    }

    public void setCipi(String cipi) {
        this.cipi = cipi;
    }

    public String getCstipi() {
        return cstipi;
    }

    public void setCstipi(String cstipi) {
        this.cstipi = cstipi;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public Double getPis() {
        return pis;
    }

    public void setPis(Double pis) {
        this.pis = pis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public Double getCofins() {
        return cofins;
    }

    public void setCofins(Double cofins) {
        this.cofins = cofins;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Integer getCavidades() {
        return cavidades;
    }

    public void setCavidades(Integer cavidades) {
        this.cavidades = cavidades;
    }

    public Integer getLargPlFund() {
        return largPlFund;
    }

    public void setLargPlFund(Integer largPlFund) {
        this.largPlFund = largPlFund;
    }

    public Double getPerda() {
        return perda;
    }

    public void setPerda(Double perda) {
        this.perda = perda;
    }

    public Double getEspDesb() {
        return espDesb;
    }

    public void setEspDesb(Double espDesb) {
        this.espDesb = espDesb;
    }

    public Integer getFator() {
        return fator;
    }

    public void setFator(Integer fator) {
        this.fator = fator;
    }

    public Double getPerdaLarg() {
        return perdaLarg;
    }

    public void setPerdaLarg(Double perdaLarg) {
        this.perdaLarg = perdaLarg;
    }

    public Double getNroCorte() {
        return nroCorte;
    }

    public void setNroCorte(Double nroCorte) {
        this.nroCorte = nroCorte;
    }

    public Integer getSeqProd() {
        return seqProd;
    }

    public void setSeqProd(Integer seqProd) {
        this.seqProd = seqProd;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Integer getCodFor() {
        return codFor;
    }

    public void setCodFor(Integer codFor) {
        this.codFor = codFor;
    }

    public Boolean getProdVendaNot() {
        return prodVendaNot;
    }

    public void setProdVendaNot(Boolean prodVendaNot) {
        this.prodVendaNot = prodVendaNot;
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    @XmlTransient
    public List<ItemsPed> getItemsPedList() {
        return itemsPedList;
    }

    public void setItemsPedList(List<ItemsPed> itemsPedList) {
        this.itemsPedList = itemsPedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPro != null ? codPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Produtos[ codPro=" + codPro + " ]";
    }
    
}
