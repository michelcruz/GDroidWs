/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.droid.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCodCli", query = "SELECT c FROM Clientes c WHERE c.codCli = :codCli"),
    @NamedQuery(name = "Clientes.findByCNPJCli", query = "SELECT c FROM Clientes c WHERE c.cNPJCli = :cNPJCli"),
    @NamedQuery(name = "Clientes.findByInsCli", query = "SELECT c FROM Clientes c WHERE c.insCli = :insCli"),
    @NamedQuery(name = "Clientes.findBySufra", query = "SELECT c FROM Clientes c WHERE c.sufra = :sufra"),
    @NamedQuery(name = "Clientes.findByRazCli", query = "SELECT c FROM Clientes c WHERE c.razCli = :razCli"),
    @NamedQuery(name = "Clientes.findByEndCli", query = "SELECT c FROM Clientes c WHERE c.endCli = :endCli"),
    @NamedQuery(name = "Clientes.findByNumCli", query = "SELECT c FROM Clientes c WHERE c.numCli = :numCli"),
    @NamedQuery(name = "Clientes.findByBaiCli", query = "SELECT c FROM Clientes c WHERE c.baiCli = :baiCli"),
    @NamedQuery(name = "Clientes.findByCEPCli", query = "SELECT c FROM Clientes c WHERE c.cEPCli = :cEPCli"),
    @NamedQuery(name = "Clientes.findByDDDFonCli", query = "SELECT c FROM Clientes c WHERE c.dDDFonCli = :dDDFonCli"),
    @NamedQuery(name = "Clientes.findByFonCli", query = "SELECT c FROM Clientes c WHERE c.fonCli = :fonCli"),
    @NamedQuery(name = "Clientes.findByDDDFaxCli", query = "SELECT c FROM Clientes c WHERE c.dDDFaxCli = :dDDFaxCli"),
    @NamedQuery(name = "Clientes.findByFaxCli", query = "SELECT c FROM Clientes c WHERE c.faxCli = :faxCli"),
    @NamedQuery(name = "Clientes.findByEmailCli", query = "SELECT c FROM Clientes c WHERE c.emailCli = :emailCli"),
    @NamedQuery(name = "Clientes.findByObsCli", query = "SELECT c FROM Clientes c WHERE c.obsCli = :obsCli"),
    @NamedQuery(name = "Clientes.findByAlerta", query = "SELECT c FROM Clientes c WHERE c.alerta = :alerta"),
    @NamedQuery(name = "Clientes.findByNomCid", query = "SELECT c FROM Clientes c WHERE c.nomCid = :nomCid"),
    @NamedQuery(name = "Clientes.findByNomEst", query = "SELECT c FROM Clientes c WHERE c.nomEst = :nomEst"),
    @NamedQuery(name = "Clientes.findByCodContabil", query = "SELECT c FROM Clientes c WHERE c.codContabil = :codContabil"),
    @NamedQuery(name = "Clientes.findByAtivCob", query = "SELECT c FROM Clientes c WHERE c.ativCob = :ativCob"),
    @NamedQuery(name = "Clientes.findByEndCob", query = "SELECT c FROM Clientes c WHERE c.endCob = :endCob"),
    @NamedQuery(name = "Clientes.findByNumCob", query = "SELECT c FROM Clientes c WHERE c.numCob = :numCob"),
    @NamedQuery(name = "Clientes.findByBaiCob", query = "SELECT c FROM Clientes c WHERE c.baiCob = :baiCob"),
    @NamedQuery(name = "Clientes.findByCEPCob", query = "SELECT c FROM Clientes c WHERE c.cEPCob = :cEPCob"),
    @NamedQuery(name = "Clientes.findByTipoVenda", query = "SELECT c FROM Clientes c WHERE c.tipoVenda = :tipoVenda")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codCli;
    @Size(max = 19)
    @Column(length = 19)
    private String cNPJCli;
    @Size(max = 20)
    @Column(length = 20)
    private String insCli;
    @Size(max = 20)
    @Column(length = 20)
    private String sufra;
    @Size(max = 50)
    @Column(length = 50)
    private String razCli;
    @Size(max = 70)
    @Column(length = 70)
    private String endCli;
    @Size(max = 15)
    @Column(length = 15)
    private String numCli;
    @Size(max = 40)
    @Column(length = 40)
    private String baiCli;
    @Size(max = 8)
    @Column(length = 8)
    private String cEPCli;
    @Size(max = 2)
    @Column(length = 2)
    private String dDDFonCli;
    @Size(max = 10)
    @Column(length = 10)
    private String fonCli;
    @Size(max = 2)
    @Column(length = 2)
    private String dDDFaxCli;
    @Size(max = 10)
    @Column(length = 10)
    private String faxCli;
    @Size(max = 150)
    @Column(length = 150)
    private String emailCli;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String obsCli;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String alerta;
    @Size(max = 80)
    @Column(length = 80)
    private String nomCid;
    @Size(max = 2)
    @Column(length = 2)
    private String nomEst;
    @Size(max = 15)
    @Column(length = 15)
    private String codContabil;
    private Serializable ativCob;
    @Size(max = 70)
    @Column(length = 70)
    private String endCob;
    @Size(max = 15)
    @Column(length = 15)
    private String numCob;
    @Size(max = 40)
    @Column(length = 40)
    private String baiCob;
    @Size(max = 8)
    @Column(length = 8)
    private String cEPCob;
    @Size(max = 40)
    @Column(length = 40)
    private String tipoVenda;

    public Clientes() {
    }

    public Clientes(Integer codCli) {
        this.codCli = codCli;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        this.codCli = codCli;
    }

    public String getCNPJCli() {
        return cNPJCli;
    }

    public void setCNPJCli(String cNPJCli) {
        this.cNPJCli = cNPJCli;
    }

    public String getInsCli() {
        return insCli;
    }

    public void setInsCli(String insCli) {
        this.insCli = insCli;
    }

    public String getSufra() {
        return sufra;
    }

    public void setSufra(String sufra) {
        this.sufra = sufra;
    }

    public String getRazCli() {
        return razCli;
    }

    public void setRazCli(String razCli) {
        this.razCli = razCli;
    }

    public String getEndCli() {
        return endCli;
    }

    public void setEndCli(String endCli) {
        this.endCli = endCli;
    }

    public String getNumCli() {
        return numCli;
    }

    public void setNumCli(String numCli) {
        this.numCli = numCli;
    }

    public String getBaiCli() {
        return baiCli;
    }

    public void setBaiCli(String baiCli) {
        this.baiCli = baiCli;
    }

    public String getCEPCli() {
        return cEPCli;
    }

    public void setCEPCli(String cEPCli) {
        this.cEPCli = cEPCli;
    }

    public String getDDDFonCli() {
        return dDDFonCli;
    }

    public void setDDDFonCli(String dDDFonCli) {
        this.dDDFonCli = dDDFonCli;
    }

    public String getFonCli() {
        return fonCli;
    }

    public void setFonCli(String fonCli) {
        this.fonCli = fonCli;
    }

    public String getDDDFaxCli() {
        return dDDFaxCli;
    }

    public void setDDDFaxCli(String dDDFaxCli) {
        this.dDDFaxCli = dDDFaxCli;
    }

    public String getFaxCli() {
        return faxCli;
    }

    public void setFaxCli(String faxCli) {
        this.faxCli = faxCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getObsCli() {
        return obsCli;
    }

    public void setObsCli(String obsCli) {
        this.obsCli = obsCli;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
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

    public String getCodContabil() {
        return codContabil;
    }

    public void setCodContabil(String codContabil) {
        this.codContabil = codContabil;
    }

    public Serializable getAtivCob() {
        return ativCob;
    }

    public void setAtivCob(Serializable ativCob) {
        this.ativCob = ativCob;
    }

    public String getEndCob() {
        return endCob;
    }

    public void setEndCob(String endCob) {
        this.endCob = endCob;
    }

    public String getNumCob() {
        return numCob;
    }

    public void setNumCob(String numCob) {
        this.numCob = numCob;
    }

    public String getBaiCob() {
        return baiCob;
    }

    public void setBaiCob(String baiCob) {
        this.baiCob = baiCob;
    }

    public String getCEPCob() {
        return cEPCob;
    }

    public void setCEPCob(String cEPCob) {
        this.cEPCob = cEPCob;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCli != null ? codCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codCli == null && other.codCli != null) || (this.codCli != null && !this.codCli.equals(other.codCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Clientes[ codCli=" + codCli + " ]";
    }
    
}
