/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrador
 */
@Entity
@Table(name = "espaco_instalacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspacoInstalacao.findAll", query = "SELECT e FROM EspacoInstalacao e"),
    @NamedQuery(name = "EspacoInstalacao.findByIdEspaco", query = "SELECT e FROM EspacoInstalacao e WHERE e.idEspaco = :idEspaco"),
    @NamedQuery(name = "EspacoInstalacao.findByEspaco", query = "SELECT e FROM EspacoInstalacao e WHERE e.espaco = :espaco"),
    @NamedQuery(name = "EspacoInstalacao.findByArea", query = "SELECT e FROM EspacoInstalacao e WHERE e.area = :area"),
    @NamedQuery(name = "EspacoInstalacao.findByLocalizacao", query = "SELECT e FROM EspacoInstalacao e WHERE e.localizacao = :localizacao")})
public class EspacoInstalacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_espaco")
    private Integer idEspaco;
    @Size(max = 100)
    @Column(name = "espaco")
    private String espaco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "area")
    private BigDecimal area;
    @Size(max = 200)
    @Column(name = "localizacao")
    private String localizacao;

    public EspacoInstalacao() {
    }

    public EspacoInstalacao(Integer idEspaco) {
        this.idEspaco = idEspaco;
    }

    public Integer getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Integer idEspaco) {
        this.idEspaco = idEspaco;
    }

    public String getEspaco() {
        return espaco;
    }

    public void setEspaco(String espaco) {
        this.espaco = espaco;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspaco != null ? idEspaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspacoInstalacao)) {
            return false;
        }
        EspacoInstalacao other = (EspacoInstalacao) object;
        if ((this.idEspaco == null && other.idEspaco != null) || (this.idEspaco != null && !this.idEspaco.equals(other.idEspaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.EspacoInstalacao[ idEspaco=" + idEspaco + " ]";
    }
    
}
