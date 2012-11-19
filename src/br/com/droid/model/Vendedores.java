/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.droid.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByCodVen", query = "SELECT v FROM Vendedores v WHERE v.codVen = :codVen"),
    @NamedQuery(name = "Vendedores.findByPesVen", query = "SELECT v FROM Vendedores v WHERE v.pesVen = :pesVen"),
    @NamedQuery(name = "Vendedores.findByCNPJVen", query = "SELECT v FROM Vendedores v WHERE v.cNPJVen = :cNPJVen"),
    @NamedQuery(name = "Vendedores.findByInsVen", query = "SELECT v FROM Vendedores v WHERE v.insVen = :insVen"),
    @NamedQuery(name = "Vendedores.findByInativo", query = "SELECT v FROM Vendedores v WHERE v.inativo = :inativo"),
    @NamedQuery(name = "Vendedores.findByDatInativo", query = "SELECT v FROM Vendedores v WHERE v.datInativo = :datInativo"),
    @NamedQuery(name = "Vendedores.findByNomVen", query = "SELECT v FROM Vendedores v WHERE v.nomVen = :nomVen"),
    @NamedQuery(name = "Vendedores.findByApelido", query = "SELECT v FROM Vendedores v WHERE v.apelido = :apelido"),
    @NamedQuery(name = "Vendedores.findByEndVen", query = "SELECT v FROM Vendedores v WHERE v.endVen = :endVen"),
    @NamedQuery(name = "Vendedores.findByBaiVen", query = "SELECT v FROM Vendedores v WHERE v.baiVen = :baiVen"),
    @NamedQuery(name = "Vendedores.findByCEPVen", query = "SELECT v FROM Vendedores v WHERE v.cEPVen = :cEPVen"),
    @NamedQuery(name = "Vendedores.findByCodCidVen", query = "SELECT v FROM Vendedores v WHERE v.codCidVen = :codCidVen"),
    @NamedQuery(name = "Vendedores.findByDDDFonVen", query = "SELECT v FROM Vendedores v WHERE v.dDDFonVen = :dDDFonVen"),
    @NamedQuery(name = "Vendedores.findByFonVen", query = "SELECT v FROM Vendedores v WHERE v.fonVen = :fonVen"),
    @NamedQuery(name = "Vendedores.findByDD2FonVen", query = "SELECT v FROM Vendedores v WHERE v.dD2FonVen = :dD2FonVen"),
    @NamedQuery(name = "Vendedores.findByFon2Ven", query = "SELECT v FROM Vendedores v WHERE v.fon2Ven = :fon2Ven"),
    @NamedQuery(name = "Vendedores.findByDDDFaxVen", query = "SELECT v FROM Vendedores v WHERE v.dDDFaxVen = :dDDFaxVen"),
    @NamedQuery(name = "Vendedores.findByFaxVen", query = "SELECT v FROM Vendedores v WHERE v.faxVen = :faxVen"),
    @NamedQuery(name = "Vendedores.findByDDDCelVen", query = "SELECT v FROM Vendedores v WHERE v.dDDCelVen = :dDDCelVen"),
    @NamedQuery(name = "Vendedores.findByCelVen", query = "SELECT v FROM Vendedores v WHERE v.celVen = :celVen"),
    @NamedQuery(name = "Vendedores.findByConVen", query = "SELECT v FROM Vendedores v WHERE v.conVen = :conVen"),
    @NamedQuery(name = "Vendedores.findByEmailVen", query = "SELECT v FROM Vendedores v WHERE v.emailVen = :emailVen"),
    @NamedQuery(name = "Vendedores.findByAgVen", query = "SELECT v FROM Vendedores v WHERE v.agVen = :agVen"),
    @NamedQuery(name = "Vendedores.findByContaVen", query = "SELECT v FROM Vendedores v WHERE v.contaVen = :contaVen"),
    @NamedQuery(name = "Vendedores.findByCodBanVen", query = "SELECT v FROM Vendedores v WHERE v.codBanVen = :codBanVen"),
    @NamedQuery(name = "Vendedores.findByCadVen", query = "SELECT v FROM Vendedores v WHERE v.cadVen = :cadVen"),
    @NamedQuery(name = "Vendedores.findByObsVen", query = "SELECT v FROM Vendedores v WHERE v.obsVen = :obsVen"),
    @NamedQuery(name = "Vendedores.findByNomCid", query = "SELECT v FROM Vendedores v WHERE v.nomCid = :nomCid"),
    @NamedQuery(name = "Vendedores.findByNomEst", query = "SELECT v FROM Vendedores v WHERE v.nomEst = :nomEst")})
public class Vendedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codVen;
    private String pesVen;
    @Size(max = 20)
    @Column(length = 20)
    private String cNPJVen;
    @Size(max = 20)
    @Column(length = 20)
    private String insVen;
    private Boolean inativo;
    @Temporal(TemporalType.DATE)
    private String datInativo;
    @Size(max = 50)
    @Column(length = 50)
    private String nomVen;
    @Size(max = 30)
    @Column(length = 30)
    private String apelido;
    @Size(max = 70)
    @Column(length = 70)
    private String endVen;
    @Size(max = 40)
    @Column(length = 40)
    private String baiVen;
    @Size(max = 8)
    @Column(length = 8)
    private String cEPVen;
    private Integer codCidVen;
    @Size(max = 2)
    @Column(length = 2)
    private String dDDFonVen;
    @Size(max = 10)
    @Column(length = 10)
    private String fonVen;
    @Size(max = 10)
    @Column(length = 10)
    private String dD2FonVen;
    @Size(max = 10)
    @Column(length = 10)
    private String fon2Ven;
    @Size(max = 2)
    @Column(length = 2)
    private String dDDFaxVen;
    @Size(max = 10)
    @Column(length = 10)
    private String faxVen;
    @Size(max = 2)
    @Column(length = 2)
    private String dDDCelVen;
    @Size(max = 10)
    @Column(length = 10)
    private String celVen;
    @Size(max = 30)
    @Column(length = 30)
    private String conVen;
    @Size(max = 150)
    @Column(length = 150)
    private String emailVen;
    @Size(max = 10)
    @Column(length = 10)
    private String agVen;
    @Size(max = 15)
    @Column(length = 15)
    private String contaVen;
    private Integer codBanVen;
    @Temporal(TemporalType.DATE)
    private String cadVen;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String obsVen;
    @Size(max = 50)
    @Column(length = 50)
    private String nomCid;
    @Size(max = 2)
    @Column(length = 2)
    private String nomEst;

    public Vendedores() {
    }

    public Vendedores(Integer codVen) {
        this.codVen = codVen;
    }

    public Integer getCodVen() {
        return codVen;
    }

    public void setCodVen(Integer codVen) {
        this.codVen = codVen;
    }

    public String getPesVen() {
        return pesVen;
    }

    public void setPesVen(String pesVen) {
        this.pesVen = pesVen;
    }

    public String getCNPJVen() {
        return cNPJVen;
    }

    public void setCNPJVen(String cNPJVen) {
        this.cNPJVen = cNPJVen;
    }

    public String getInsVen() {
        return insVen;
    }

    public void setInsVen(String insVen) {
        this.insVen = insVen;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public String getDatInativo() {
        return datInativo;
    }

    public void setDatInativo(String datInativo) {
        this.datInativo = datInativo;
    }

    public String getNomVen() {
        return nomVen;
    }

    public void setNomVen(String nomVen) {
        this.nomVen = nomVen;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEndVen() {
        return endVen;
    }

    public void setEndVen(String endVen) {
        this.endVen = endVen;
    }

    public String getBaiVen() {
        return baiVen;
    }

    public void setBaiVen(String baiVen) {
        this.baiVen = baiVen;
    }

    public String getCEPVen() {
        return cEPVen;
    }

    public void setCEPVen(String cEPVen) {
        this.cEPVen = cEPVen;
    }

    public Integer getCodCidVen() {
        return codCidVen;
    }

    public void setCodCidVen(Integer codCidVen) {
        this.codCidVen = codCidVen;
    }

    public String getDDDFonVen() {
        return dDDFonVen;
    }

    public void setDDDFonVen(String dDDFonVen) {
        this.dDDFonVen = dDDFonVen;
    }

    public String getFonVen() {
        return fonVen;
    }

    public void setFonVen(String fonVen) {
        this.fonVen = fonVen;
    }

    public String getDD2FonVen() {
        return dD2FonVen;
    }

    public void setDD2FonVen(String dD2FonVen) {
        this.dD2FonVen = dD2FonVen;
    }

    public String getFon2Ven() {
        return fon2Ven;
    }

    public void setFon2Ven(String fon2Ven) {
        this.fon2Ven = fon2Ven;
    }

    public String getDDDFaxVen() {
        return dDDFaxVen;
    }

    public void setDDDFaxVen(String dDDFaxVen) {
        this.dDDFaxVen = dDDFaxVen;
    }

    public String getFaxVen() {
        return faxVen;
    }

    public void setFaxVen(String faxVen) {
        this.faxVen = faxVen;
    }

    public String getDDDCelVen() {
        return dDDCelVen;
    }

    public void setDDDCelVen(String dDDCelVen) {
        this.dDDCelVen = dDDCelVen;
    }

    public String getCelVen() {
        return celVen;
    }

    public void setCelVen(String celVen) {
        this.celVen = celVen;
    }

    public String getConVen() {
        return conVen;
    }

    public void setConVen(String conVen) {
        this.conVen = conVen;
    }

    public String getEmailVen() {
        return emailVen;
    }

    public void setEmailVen(String emailVen) {
        this.emailVen = emailVen;
    }

    public String getAgVen() {
        return agVen;
    }

    public void setAgVen(String agVen) {
        this.agVen = agVen;
    }

    public String getContaVen() {
        return contaVen;
    }

    public void setContaVen(String contaVen) {
        this.contaVen = contaVen;
    }

    public Integer getCodBanVen() {
        return codBanVen;
    }

    public void setCodBanVen(Integer codBanVen) {
        this.codBanVen = codBanVen;
    }

    public String getCadVen() {
        return cadVen;
    }

    public void setCadVen(String cadVen) {
        this.cadVen = cadVen;
    }

    public String getObsVen() {
        return obsVen;
    }

    public void setObsVen(String obsVen) {
        this.obsVen = obsVen;
    }

    public String getNomCid() {
        return nomCid;
    }

    public void setNomCid(String nomCid) {
        this.nomCid = nomCid;
    }

    public String getNomEst() {
        return nomEst;
    }

    public void setNomEst(String nomEst) {
        this.nomEst = nomEst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVen != null ? codVen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.codVen == null && other.codVen != null) || (this.codVen != null && !this.codVen.equals(other.codVen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vendedores[ codVen=" + codVen + " ]";
    }
    
}
