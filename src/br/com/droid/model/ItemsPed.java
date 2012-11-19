/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.droid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "ItemsPed.findAll", query = "SELECT i FROM ItemsPed i"),
    @NamedQuery(name = "ItemsPed.findByCodPed", query = "SELECT i FROM ItemsPed i WHERE i.codPed = :codPed"),
    @NamedQuery(name = "ItemsPed.findBySeq", query = "SELECT i FROM ItemsPed i WHERE i.seq = :seq"),
    @NamedQuery(name = "ItemsPed.findByTipoMov", query = "SELECT i FROM ItemsPed i WHERE i.tipoMov = :tipoMov"),
    @NamedQuery(name = "ItemsPed.findByDesPro", query = "SELECT i FROM ItemsPed i WHERE i.desPro = :desPro"),
    @NamedQuery(name = "ItemsPed.findByCodBarra", query = "SELECT i FROM ItemsPed i WHERE i.codBarra = :codBarra"),
    @NamedQuery(name = "ItemsPed.findByUnid", query = "SELECT i FROM ItemsPed i WHERE i.unid = :unid"),
    @NamedQuery(name = "ItemsPed.findByQuant", query = "SELECT i FROM ItemsPed i WHERE i.quant = :quant"),
    @NamedQuery(name = "ItemsPed.findByCusto", query = "SELECT i FROM ItemsPed i WHERE i.custo = :custo"),
    @NamedQuery(name = "ItemsPed.findByPrUnit", query = "SELECT i FROM ItemsPed i WHERE i.prUnit = :prUnit"),
    @NamedQuery(name = "ItemsPed.findByPrTot", query = "SELECT i FROM ItemsPed i WHERE i.prTot = :prTot"),
    @NamedQuery(name = "ItemsPed.findByIpi", query = "SELECT i FROM ItemsPed i WHERE i.ipi = :ipi"),
    @NamedQuery(name = "ItemsPed.findByIcms", query = "SELECT i FROM ItemsPed i WHERE i.icms = :icms"),
    @NamedQuery(name = "ItemsPed.findByPeLiq", query = "SELECT i FROM ItemsPed i WHERE i.peLiq = :peLiq"),
    @NamedQuery(name = "ItemsPed.findByPeBru", query = "SELECT i FROM ItemsPed i WHERE i.peBru = :peBru"),
    @NamedQuery(name = "ItemsPed.findByPerDes", query = "SELECT i FROM ItemsPed i WHERE i.perDes = :perDes"),
    @NamedQuery(name = "ItemsPed.findByValDes", query = "SELECT i FROM ItemsPed i WHERE i.valDes = :valDes"),
    @NamedQuery(name = "ItemsPed.findByClassFiscal", query = "SELECT i FROM ItemsPed i WHERE i.classFiscal = :classFiscal"),
    @NamedQuery(name = "ItemsPed.findBySitTrib", query = "SELECT i FROM ItemsPed i WHERE i.sitTrib = :sitTrib"),
    @NamedQuery(name = "ItemsPed.findByPrSem", query = "SELECT i FROM ItemsPed i WHERE i.prSem = :prSem"),
    @NamedQuery(name = "ItemsPed.findByValSem", query = "SELECT i FROM ItemsPed i WHERE i.valSem = :valSem"),
    @NamedQuery(name = "ItemsPed.findByTotSem", query = "SELECT i FROM ItemsPed i WHERE i.totSem = :totSem"),
    @NamedQuery(name = "ItemsPed.findByPrCom", query = "SELECT i FROM ItemsPed i WHERE i.prCom = :prCom"),
    @NamedQuery(name = "ItemsPed.findByValCom", query = "SELECT i FROM ItemsPed i WHERE i.valCom = :valCom"),
    @NamedQuery(name = "ItemsPed.findByTotCom", query = "SELECT i FROM ItemsPed i WHERE i.totCom = :totCom"),
    @NamedQuery(name = "ItemsPed.findByValIPI", query = "SELECT i FROM ItemsPed i WHERE i.valIPI = :valIPI"),
    @NamedQuery(name = "ItemsPed.findByQdeSem", query = "SELECT i FROM ItemsPed i WHERE i.qdeSem = :qdeSem"),
    @NamedQuery(name = "ItemsPed.findByQdeCom", query = "SELECT i FROM ItemsPed i WHERE i.qdeCom = :qdeCom"),
    @NamedQuery(name = "ItemsPed.findByCortado", query = "SELECT i FROM ItemsPed i WHERE i.cortado = :cortado"),
    @NamedQuery(name = "ItemsPed.findByQdeCorte", query = "SELECT i FROM ItemsPed i WHERE i.qdeCorte = :qdeCorte"),
    @NamedQuery(name = "ItemsPed.findByLiberado", query = "SELECT i FROM ItemsPed i WHERE i.liberado = :liberado"),
    @NamedQuery(name = "ItemsPed.findByObs", query = "SELECT i FROM ItemsPed i WHERE i.obs = :obs"),
    @NamedQuery(name = "ItemsPed.findByMotivo", query = "SELECT i FROM ItemsPed i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "ItemsPed.findByPrComissao", query = "SELECT i FROM ItemsPed i WHERE i.prComissao = :prComissao"),
    @NamedQuery(name = "ItemsPed.findByQComissao", query = "SELECT i FROM ItemsPed i WHERE i.qComissao = :qComissao"),
    @NamedQuery(name = "ItemsPed.findByTotComissao", query = "SELECT i FROM ItemsPed i WHERE i.totComissao = :totComissao"),
    @NamedQuery(name = "ItemsPed.findByPerComissao", query = "SELECT i FROM ItemsPed i WHERE i.perComissao = :perComissao"),
    @NamedQuery(name = "ItemsPed.findByFixaComissao", query = "SELECT i FROM ItemsPed i WHERE i.fixaComissao = :fixaComissao"),
    @NamedQuery(name = "ItemsPed.findByQdeConferido", query = "SELECT i FROM ItemsPed i WHERE i.qdeConferido = :qdeConferido"),
    @NamedQuery(name = "ItemsPed.findByCaixa", query = "SELECT i FROM ItemsPed i WHERE i.caixa = :caixa"),
    @NamedQuery(name = "ItemsPed.findByNroMaster", query = "SELECT i FROM ItemsPed i WHERE i.nroMaster = :nroMaster"),
    @NamedQuery(name = "ItemsPed.findByDataCF", query = "SELECT i FROM ItemsPed i WHERE i.dataCF = :dataCF"),
    @NamedQuery(name = "ItemsPed.findByHora", query = "SELECT i FROM ItemsPed i WHERE i.hora = :hora"),
    @NamedQuery(name = "ItemsPed.findByCodConf", query = "SELECT i FROM ItemsPed i WHERE i.codConf = :codConf"),
    @NamedQuery(name = "ItemsPed.findByQdeDevFala", query = "SELECT i FROM ItemsPed i WHERE i.qdeDevFala = :qdeDevFala"),
    @NamedQuery(name = "ItemsPed.findByTotDevFalta", query = "SELECT i FROM ItemsPed i WHERE i.totDevFalta = :totDevFalta"),
    @NamedQuery(name = "ItemsPed.findBySDevFalta", query = "SELECT i FROM ItemsPed i WHERE i.sDevFalta = :sDevFalta"),
    @NamedQuery(name = "ItemsPed.findByDevFalta", query = "SELECT i FROM ItemsPed i WHERE i.devFalta = :devFalta"),
    @NamedQuery(name = "ItemsPed.findByInserido", query = "SELECT i FROM ItemsPed i WHERE i.inserido = :inserido"),
    @NamedQuery(name = "ItemsPed.findByLVenda", query = "SELECT i FROM ItemsPed i WHERE i.lVenda = :lVenda"),
    @NamedQuery(name = "ItemsPed.findByCodEmb", query = "SELECT i FROM ItemsPed i WHERE i.codEmb = :codEmb"),
    @NamedQuery(name = "ItemsPed.findByLPRUnit", query = "SELECT i FROM ItemsPed i WHERE i.lPRUnit = :lPRUnit"),
    @NamedQuery(name = "ItemsPed.findByTravCom", query = "SELECT i FROM ItemsPed i WHERE i.travCom = :travCom"),
    @NamedQuery(name = "ItemsPed.findByValIcms", query = "SELECT i FROM ItemsPed i WHERE i.valIcms = :valIcms"),
    @NamedQuery(name = "ItemsPed.findByPis", query = "SELECT i FROM ItemsPed i WHERE i.pis = :pis"),
    @NamedQuery(name = "ItemsPed.findByValPis", query = "SELECT i FROM ItemsPed i WHERE i.valPis = :valPis"),
    @NamedQuery(name = "ItemsPed.findByCofins", query = "SELECT i FROM ItemsPed i WHERE i.cofins = :cofins"),
    @NamedQuery(name = "ItemsPed.findByValCofins", query = "SELECT i FROM ItemsPed i WHERE i.valCofins = :valCofins"),
    @NamedQuery(name = "ItemsPed.findByIcmsST", query = "SELECT i FROM ItemsPed i WHERE i.icmsST = :icmsST"),
    @NamedQuery(name = "ItemsPed.findByValIcmsST", query = "SELECT i FROM ItemsPed i WHERE i.valIcmsST = :valIcmsST"),
    @NamedQuery(name = "ItemsPed.findByBasIcmsST", query = "SELECT i FROM ItemsPed i WHERE i.basIcmsST = :basIcmsST"),
    @NamedQuery(name = "ItemsPed.findByCfCod", query = "SELECT i FROM ItemsPed i WHERE i.cfCod = :cfCod"),
    @NamedQuery(name = "ItemsPed.findByDIcms", query = "SELECT i FROM ItemsPed i WHERE i.dIcms = :dIcms"),
    @NamedQuery(name = "ItemsPed.findByValDIcms", query = "SELECT i FROM ItemsPed i WHERE i.valDIcms = :valDIcms"),
    @NamedQuery(name = "ItemsPed.findByDpis", query = "SELECT i FROM ItemsPed i WHERE i.dpis = :dpis"),
    @NamedQuery(name = "ItemsPed.findByValDPis", query = "SELECT i FROM ItemsPed i WHERE i.valDPis = :valDPis"),
    @NamedQuery(name = "ItemsPed.findByDCofins", query = "SELECT i FROM ItemsPed i WHERE i.dCofins = :dCofins"),
    @NamedQuery(name = "ItemsPed.findByValdCofins", query = "SELECT i FROM ItemsPed i WHERE i.valdCofins = :valdCofins")})
public class ItemsPed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codPed;
    private Integer seq;
    private String tipoMov;
    @Size(max = 45)
    @Column(length = 45)
    private String desPro;
    @Size(max = 14)
    @Column(length = 14)
    private String codBarra;
    @Size(max = 3)
    @Column(length = 3)
    private String unid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 2147483647, scale = 0)
    private Double quant;
    @Column(precision = 20, scale = 6)
    private BigDecimal custo;
    @Column(precision = 2147483647, scale = 0)
    private Double prUnit;
    @Column(precision = 2147483647, scale = 0)
    private Double prTot;
    @Column(precision = 2147483647, scale = 0)
    private Double ipi;
    @Column(precision = 2147483647, scale = 0)
    private Double icms;
    @Column(precision = 2147483647, scale = 0)
    private Double peLiq;
    @Column(precision = 2147483647, scale = 0)
    private Double peBru;
    @Column(precision = 2147483647, scale = 0)
    private Double perDes;
    @Column(precision = 2147483647, scale = 0)
    private Double valDes;
    @Size(max = 1)
    @Column(length = 1)
    private String classFiscal;
    @Size(max = 3)
    @Column(length = 3)
    private String sitTrib;
    @Column(precision = 2147483647, scale = 0)
    private Double prSem;
    @Column(precision = 2147483647, scale = 0)
    private Double valSem;
    @Column(precision = 2147483647, scale = 0)
    private Double totSem;
    @Column(precision = 2147483647, scale = 0)
    private Double prCom;
    @Column(precision = 2147483647, scale = 0)
    private Double valCom;
    @Column(precision = 2147483647, scale = 0)
    private Double totCom;
    @Column(precision = 2147483647, scale = 0)
    private Double valIPI;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeSem;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeCom;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean cortado;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeCorte;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean liberado;
    @Size(max = 30)
    @Column(length = 30)
    private String obs;
    @Size(max = 2)
    @Column(length = 2)
    private String motivo;
    @Column(precision = 2147483647, scale = 0)
    private Double prComissao;
    @Column(precision = 2147483647, scale = 0)
    private Double qComissao;
    @Column(precision = 2147483647, scale = 0)
    private Double totComissao;
    @Column(precision = 2147483647, scale = 0)
    private Double perComissao;
    private String fixaComissao;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeConferido;
    private Integer caixa;
    private Integer nroMaster;
    @Temporal(TemporalType.DATE)
    private String dataCF;
    @Size(max = 5)
    @Column(length = 5)
    private String hora;
    private Integer codConf;
    @Column(precision = 2147483647, scale = 0)
    private Double qdeDevFala;
    @Column(precision = 2147483647, scale = 0)
    private Double totDevFalta;
    private String sDevFalta;
    private String devFalta;
    private String inserido;
    @Column(precision = 2147483647, scale = 0)
    private Double lVenda;
    private Integer codEmb;
    @Column(precision = 2147483647, scale = 0)
    private Double lPRUnit;
    private String travCom;
    @Column(precision = 2147483647, scale = 0)
    private Double valIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double pis;
    @Column(precision = 2147483647, scale = 0)
    private Double valPis;
    @Column(precision = 2147483647, scale = 0)
    private Double cofins;
    @Column(precision = 2147483647, scale = 0)
    private Double valCofins;
    @Column(precision = 2147483647, scale = 0)
    private Double icmsST;
    @Column(precision = 2147483647, scale = 0)
    private Double valIcmsST;
    @Column(precision = 2147483647, scale = 0)
    private Double basIcmsST;
    @Size(max = 5)
    @Column(length = 5)
    private String cfCod;
    @Column(precision = 2147483647, scale = 0)
    private Double dIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double valDIcms;
    @Column(precision = 2147483647, scale = 0)
    private Double dpis;
    @Column(precision = 2147483647, scale = 0)
    private Double valDPis;
    @Column(precision = 2147483647, scale = 0)
    private Double dCofins;
    @Column(precision = 2147483647, scale = 0)
    private Double valdCofins;
    @JoinColumn(name = "CodPro", referencedColumnName = "CodPro")
    @ManyToOne
    private Integer codPro; // mais pode fazer isso ?claro pq ele é uma FKcerto 
    @JoinColumn(name = "CodPed", referencedColumnName = "CodPed", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pedidos pedidos;

    public ItemsPed() {
    }

    public ItemsPed(Integer codPed) {
        this.codPed = codPed;
    }

    public ItemsPed(Integer codPed, boolean cortado, boolean liberado) {
        this.codPed = codPed;
        this.cortado = cortado;
        this.liberado = liberado;
    }

    public Integer getCodPed() {
        return codPed;
    }

    public void setCodPed(Integer codPed) {
        this.codPed = codPed;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getDesPro() {
        return desPro;
    }

    public void setDesPro(String desPro) {
        this.desPro = desPro;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public Double getQuant() {
        return quant;
    }

    public void setQuant(Double quant) {
        this.quant = quant;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Double getPrUnit() {
        return prUnit;
    }

    public void setPrUnit(Double prUnit) {
        this.prUnit = prUnit;
    }

    public Double getPrTot() {
        return prTot;
    }

    public void setPrTot(Double prTot) {
        this.prTot = prTot;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }

    public Double getIcms() {
        return icms;
    }

    public void setIcms(Double icms) {
        this.icms = icms;
    }

    public Double getPeLiq() {
        return peLiq;
    }

    public void setPeLiq(Double peLiq) {
        this.peLiq = peLiq;
    }

    public Double getPeBru() {
        return peBru;
    }

    public void setPeBru(Double peBru) {
        this.peBru = peBru;
    }

    public Double getPerDes() {
        return perDes;
    }

    public void setPerDes(Double perDes) {
        this.perDes = perDes;
    }

    public Double getValDes() {
        return valDes;
    }

    public void setValDes(Double valDes) {
        this.valDes = valDes;
    }

    public String getClassFiscal() {
        return classFiscal;
    }

    public void setClassFiscal(String classFiscal) {
        this.classFiscal = classFiscal;
    }

    public String getSitTrib() {
        return sitTrib;
    }

    public void setSitTrib(String sitTrib) {
        this.sitTrib = sitTrib;
    }

    public Double getPrSem() {
        return prSem;
    }

    public void setPrSem(Double prSem) {
        this.prSem = prSem;
    }

    public Double getValSem() {
        return valSem;
    }

    public void setValSem(Double valSem) {
        this.valSem = valSem;
    }

    public Double getTotSem() {
        return totSem;
    }

    public void setTotSem(Double totSem) {
        this.totSem = totSem;
    }

    public Double getPrCom() {
        return prCom;
    }

    public void setPrCom(Double prCom) {
        this.prCom = prCom;
    }

    public Double getValCom() {
        return valCom;
    }

    public void setValCom(Double valCom) {
        this.valCom = valCom;
    }

    public Double getTotCom() {
        return totCom;
    }

    public void setTotCom(Double totCom) {
        this.totCom = totCom;
    }

    public Double getValIPI() {
        return valIPI;
    }

    public void setValIPI(Double valIPI) {
        this.valIPI = valIPI;
    }

    public Double getQdeSem() {
        return qdeSem;
    }

    public void setQdeSem(Double qdeSem) {
        this.qdeSem = qdeSem;
    }

    public Double getQdeCom() {
        return qdeCom;
    }

    public void setQdeCom(Double qdeCom) {
        this.qdeCom = qdeCom;
    }

    public boolean getCortado() {
        return cortado;
    }

    public void setCortado(boolean cortado) {
        this.cortado = cortado;
    }

    public Double getQdeCorte() {
        return qdeCorte;
    }

    public void setQdeCorte(Double qdeCorte) {
        this.qdeCorte = qdeCorte;
    }

    public boolean getLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getPrComissao() {
        return prComissao;
    }

    public void setPrComissao(Double prComissao) {
        this.prComissao = prComissao;
    }

    public Double getQComissao() {
        return qComissao;
    }

    public void setQComissao(Double qComissao) {
        this.qComissao = qComissao;
    }

    public Double getTotComissao() {
        return totComissao;
    }

    public void setTotComissao(Double totComissao) {
        this.totComissao = totComissao;
    }

    public Double getPerComissao() {
        return perComissao;
    }

    public void setPerComissao(Double perComissao) {
        this.perComissao = perComissao;
    }

    public String getFixaComissao() {
        return fixaComissao;
    }

    public void setFixaComissao(String fixaComissao) {
        this.fixaComissao = fixaComissao;
    }

    public Double getQdeConferido() {
        return qdeConferido;
    }

    public void setQdeConferido(Double qdeConferido) {
        this.qdeConferido = qdeConferido;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }

    public Integer getNroMaster() {
        return nroMaster;
    }

    public void setNroMaster(Integer nroMaster) {
        this.nroMaster = nroMaster;
    }

    public String getDataCF() {
        return dataCF;
    }

    public void setDataCF(String dataCF) {
        this.dataCF = dataCF;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getCodConf() {
        return codConf;
    }

    public void setCodConf(Integer codConf) {
        this.codConf = codConf;
    }

    public Double getQdeDevFala() {
        return qdeDevFala;
    }

    public void setQdeDevFala(Double qdeDevFala) {
        this.qdeDevFala = qdeDevFala;
    }

    public Double getTotDevFalta() {
        return totDevFalta;
    }

    public void setTotDevFalta(Double totDevFalta) {
        this.totDevFalta = totDevFalta;
    }

    public String getSDevFalta() {
        return sDevFalta;
    }

    public void setSDevFalta(String sDevFalta) {
        this.sDevFalta = sDevFalta;
    }

    public String getDevFalta() {
        return devFalta;
    }

    public void setDevFalta(String devFalta) {
        this.devFalta = devFalta;
    }

    public String getInserido() {
        return inserido;
    }

    public void setInserido(String inserido) {
        this.inserido = inserido;
    }

    public Double getLVenda() {
        return lVenda;
    }

    public void setLVenda(Double lVenda) {
        this.lVenda = lVenda;
    }

    public Integer getCodEmb() {
        return codEmb;
    }

    public void setCodEmb(Integer codEmb) {
        this.codEmb = codEmb;
    }

    public Double getLPRUnit() {
        return lPRUnit;
    }

    public void setLPRUnit(Double lPRUnit) {
        this.lPRUnit = lPRUnit;
    }

    public String getTravCom() {
        return travCom;
    }

    public void setTravCom(String travCom) {
        this.travCom = travCom;
    }

    public Double getValIcms() {
        return valIcms;
    }

    public void setValIcms(Double valIcms) {
        this.valIcms = valIcms;
    }

    public Double getPis() {
        return pis;
    }

    public void setPis(Double pis) {
        this.pis = pis;
    }

    public Double getValPis() {
        return valPis;
    }

    public void setValPis(Double valPis) {
        this.valPis = valPis;
    }

    public Double getCofins() {
        return cofins;
    }

    public void setCofins(Double cofins) {
        this.cofins = cofins;
    }

    public Double getValCofins() {
        return valCofins;
    }

    public void setValCofins(Double valCofins) {
        this.valCofins = valCofins;
    }

    public Double getIcmsST() {
        return icmsST;
    }

    public void setIcmsST(Double icmsST) {
        this.icmsST = icmsST;
    }

    public Double getValIcmsST() {
        return valIcmsST;
    }

    public void setValIcmsST(Double valIcmsST) {
        this.valIcmsST = valIcmsST;
    }

    public Double getBasIcmsST() {
        return basIcmsST;
    }

    public void setBasIcmsST(Double basIcmsST) {
        this.basIcmsST = basIcmsST;
    }

    public String getCfCod() {
        return cfCod;
    }

    public void setCfCod(String cfCod) {
        this.cfCod = cfCod;
    }

    public Double getDIcms() {
        return dIcms;
    }

    public void setDIcms(Double dIcms) {
        this.dIcms = dIcms;
    }

    public Double getValDIcms() {
        return valDIcms;
    }

    public void setValDIcms(Double valDIcms) {
        this.valDIcms = valDIcms;
    }

    public Double getDpis() {
        return dpis;
    }

    public void setDpis(Double dpis) {
        this.dpis = dpis;
    }

    public Double getValDPis() {
        return valDPis;
    }

    public void setValDPis(Double valDPis) {
        this.valDPis = valDPis;
    }

    public Double getDCofins() {
        return dCofins;
    }

    public void setDCofins(Double dCofins) {
        this.dCofins = dCofins;
    }

    public Double getValdCofins() {
        return valdCofins;
    }

    public void setValdCofins(Double valdCofins) {
        this.valdCofins = valdCofins;
    }

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        this.codPro = codPro;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
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
        if (!(object instanceof ItemsPed)) {
            return false;
        }
        ItemsPed other = (ItemsPed) object;
        if ((this.codPed == null && other.codPed != null) || (this.codPed != null && !this.codPed.equals(other.codPed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ItemsPed[ codPed=" + codPed + " ]";
    }
    
}
