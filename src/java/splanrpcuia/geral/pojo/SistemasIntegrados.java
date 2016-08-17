/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "sistemas_integrados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemasIntegrados.findAll", query = "SELECT s FROM SistemasIntegrados s"),
    @NamedQuery(name = "SistemasIntegrados.findByIdSistemasIntegrados", query = "SELECT s FROM SistemasIntegrados s WHERE s.idSistemasIntegrados = :idSistemasIntegrados")})
public class SistemasIntegrados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistemas_integrados")
    private Integer idSistemasIntegrados;
    @JoinColumn(name = "id_sistema_integrado", referencedColumnName = "id_sistema")
    @ManyToOne
    private Sistema idSistemaIntegrado;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema")
    @ManyToOne
    private Sistema idSistema;

    public SistemasIntegrados() {
    }

    public SistemasIntegrados(Integer idSistemasIntegrados) {
        this.idSistemasIntegrados = idSistemasIntegrados;
    }

    public Integer getIdSistemasIntegrados() {
        return idSistemasIntegrados;
    }

    public void setIdSistemasIntegrados(Integer idSistemasIntegrados) {
        this.idSistemasIntegrados = idSistemasIntegrados;
    }

    public Sistema getIdSistemaIntegrado() {
        return idSistemaIntegrado;
    }

    public void setIdSistemaIntegrado(Sistema idSistemaIntegrado) {
        this.idSistemaIntegrado = idSistemaIntegrado;
    }

    public Sistema getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Sistema idSistema) {
        this.idSistema = idSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistemasIntegrados != null ? idSistemasIntegrados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemasIntegrados)) {
            return false;
        }
        SistemasIntegrados other = (SistemasIntegrados) object;
        if ((this.idSistemasIntegrados == null && other.idSistemasIntegrados != null) || (this.idSistemasIntegrados != null && !this.idSistemasIntegrados.equals(other.idSistemasIntegrados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SistemasIntegrados[ idSistemasIntegrados=" + idSistemasIntegrados + " ]";
    }
    
}
