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
@Table(name = "tipo_reservatorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReservatorio.findAll", query = "SELECT t FROM TipoReservatorio t"),
    @NamedQuery(name = "TipoReservatorio.findByIdTipoReservatorio", query = "SELECT t FROM TipoReservatorio t WHERE t.idTipoReservatorio = :idTipoReservatorio"),
    @NamedQuery(name = "TipoReservatorio.findByTipoReservatorio", query = "SELECT t FROM TipoReservatorio t WHERE t.tipoReservatorio = :tipoReservatorio")})
public class TipoReservatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_reservatorio")
    private Integer idTipoReservatorio;
    @Size(max = 200)
    @Column(name = "tipo_reservatorio")
    private String tipoReservatorio;
    @OneToMany(mappedBy = "idTipoReservatorio")
    private List<Reservatorio> reservatorioList;

    public TipoReservatorio() {
    }

    public TipoReservatorio(Integer idTipoReservatorio) {
        this.idTipoReservatorio = idTipoReservatorio;
    }

    public Integer getIdTipoReservatorio() {
        return idTipoReservatorio;
    }

    public void setIdTipoReservatorio(Integer idTipoReservatorio) {
        this.idTipoReservatorio = idTipoReservatorio;
    }

    public String getTipoReservatorio() {
        return tipoReservatorio;
    }

    public void setTipoReservatorio(String tipoReservatorio) {
        this.tipoReservatorio = tipoReservatorio;
    }

    @XmlTransient
    public List<Reservatorio> getReservatorioList() {
        return reservatorioList;
    }

    public void setReservatorioList(List<Reservatorio> reservatorioList) {
        this.reservatorioList = reservatorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoReservatorio != null ? idTipoReservatorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReservatorio)) {
            return false;
        }
        TipoReservatorio other = (TipoReservatorio) object;
        if ((this.idTipoReservatorio == null && other.idTipoReservatorio != null) || (this.idTipoReservatorio != null && !this.idTipoReservatorio.equals(other.idTipoReservatorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoReservatorio[ idTipoReservatorio=" + idTipoReservatorio + " ]";
    }
    
}
