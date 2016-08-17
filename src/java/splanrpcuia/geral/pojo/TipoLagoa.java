/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

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
 * @author Administrador
 */
@Entity
@Table(name = "tipo_lagoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLagoa.findAll", query = "SELECT t FROM TipoLagoa t"),
    @NamedQuery(name = "TipoLagoa.findByIdTipoLagoa", query = "SELECT t FROM TipoLagoa t WHERE t.idTipoLagoa = :idTipoLagoa"),
    @NamedQuery(name = "TipoLagoa.findByTipoLagoa", query = "SELECT t FROM TipoLagoa t WHERE t.tipoLagoa = :tipoLagoa")})
public class TipoLagoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_lagoa")
    private Integer idTipoLagoa;
    @Size(max = 50)
    @Column(name = "tipo_lagoa")
    private String tipoLagoa;
    @OneToMany(mappedBy = "idTipoLagoa")
    private List<Lagoa> lagoaList;

    public TipoLagoa() {
    }

    public TipoLagoa(Integer idTipoLagoa) {
        this.idTipoLagoa = idTipoLagoa;
    }

    public Integer getIdTipoLagoa() {
        return idTipoLagoa;
    }

    public void setIdTipoLagoa(Integer idTipoLagoa) {
        this.idTipoLagoa = idTipoLagoa;
    }

    public String getTipoLagoa() {
        return tipoLagoa;
    }

    public void setTipoLagoa(String tipoLagoa) {
        this.tipoLagoa = tipoLagoa;
    }

    @XmlTransient
    public List<Lagoa> getLagoaList() {
        return lagoaList;
    }

    public void setLagoaList(List<Lagoa> lagoaList) {
        this.lagoaList = lagoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLagoa != null ? idTipoLagoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLagoa)) {
            return false;
        }
        TipoLagoa other = (TipoLagoa) object;
        if ((this.idTipoLagoa == null && other.idTipoLagoa != null) || (this.idTipoLagoa != null && !this.idTipoLagoa.equals(other.idTipoLagoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoLagoa[ idTipoLagoa=" + idTipoLagoa + " ]";
    }
    
}
