/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.droid.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findByCodGrupo", query = "SELECT g FROM Grupos g WHERE g.codGrupo = :codGrupo"),
    @NamedQuery(name = "Grupos.findByDesGrupo", query = "SELECT g FROM Grupos g WHERE g.desGrupo = :desGrupo"),
    @NamedQuery(name = "Grupos.findByGeraCom", query = "SELECT g FROM Grupos g WHERE g.geraCom = :geraCom"),
    @NamedQuery(name = "Grupos.findByMargem", query = "SELECT g FROM Grupos g WHERE g.margem = :margem"),
    @NamedQuery(name = "Grupos.findByPDes", query = "SELECT g FROM Grupos g WHERE g.pDes = :pDes")})
public class Grupos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codGrupo;
    @Size(max = 30)
    @Column(length = 30)
    private String desGrupo;
    private String geraCom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 2147483647, scale = 0)
    private Double margem;
    @Column(precision = 2147483647, scale = 0)
    private Double pDes;
    @OneToMany(mappedBy = "codGrupo")
    private List<Produtos> produtosList;

    public Grupos() {
    }

    public Grupos(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getDesGrupo() {
        return desGrupo;
    }

    public void setDesGrupo(String desGrupo) {
        this.desGrupo = desGrupo;
    }

    public String getGeraCom() {
        return geraCom;
    }

    public void setGeraCom(String geraCom) {
        this.geraCom = geraCom;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    public Double getPDes() {
        return pDes;
    }

    public void setPDes(Double pDes) {
        this.pDes = pDes;
    }

    @XmlTransient
    public List<Produtos> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produtos> produtosList) {
        this.produtosList = produtosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupo != null ? codGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.codGrupo == null && other.codGrupo != null) || (this.codGrupo != null && !this.codGrupo.equals(other.codGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Grupos[ codGrupo=" + codGrupo + " ]";
    }
}
