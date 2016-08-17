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
@Table(name = "tipo_transportador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransportador.findAll", query = "SELECT t FROM TipoTransportador t"),
    @NamedQuery(name = "TipoTransportador.findByIdTipoTransportador", query = "SELECT t FROM TipoTransportador t WHERE t.idTipoTransportador = :idTipoTransportador"),
    @NamedQuery(name = "TipoTransportador.findByTipoTransportador", query = "SELECT t FROM TipoTransportador t WHERE t.tipoTransportador = :tipoTransportador"),
    @NamedQuery(name = "TipoTransportador.findByTransporteAereo", query = "SELECT t FROM TipoTransportador t WHERE t.transporteAereo = :transporteAereo"),
    @NamedQuery(name = "TipoTransportador.findByCalha", query = "SELECT t FROM TipoTransportador t WHERE t.calha = :calha"),
    @NamedQuery(name = "TipoTransportador.findByEsteira", query = "SELECT t FROM TipoTransportador t WHERE t.esteira = :esteira"),
    @NamedQuery(name = "TipoTransportador.findByAutomatico", query = "SELECT t FROM TipoTransportador t WHERE t.automatico = :automatico")})
public class TipoTransportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_transportador")
    private Integer idTipoTransportador;
    @Size(max = 100)
    @Column(name = "tipo_transportador")
    private String tipoTransportador;
    @Column(name = "transporte_aereo")
    private Boolean transporteAereo;
    @Column(name = "calha")
    private Boolean calha;
    @Column(name = "esteira")
    private Boolean esteira;
    @Column(name = "automatico")
    private Boolean automatico;
    @OneToMany(mappedBy = "idTipo")
    private List<Transportador> transportadorList;

    public TipoTransportador() {
    }

    public TipoTransportador(Integer idTipoTransportador) {
        this.idTipoTransportador = idTipoTransportador;
    }

    public Integer getIdTipoTransportador() {
        return idTipoTransportador;
    }

    public void setIdTipoTransportador(Integer idTipoTransportador) {
        this.idTipoTransportador = idTipoTransportador;
    }

    public String getTipoTransportador() {
        return tipoTransportador;
    }

    public void setTipoTransportador(String tipoTransportador) {
        this.tipoTransportador = tipoTransportador;
    }

    public Boolean getTransporteAereo() {
        return transporteAereo;
    }

    public void setTransporteAereo(Boolean transporteAereo) {
        this.transporteAereo = transporteAereo;
    }

    public Boolean getCalha() {
        return calha;
    }

    public void setCalha(Boolean calha) {
        this.calha = calha;
    }

    public Boolean getEsteira() {
        return esteira;
    }

    public void setEsteira(Boolean esteira) {
        this.esteira = esteira;
    }

    public Boolean getAutomatico() {
        return automatico;
    }

    public void setAutomatico(Boolean automatico) {
        this.automatico = automatico;
    }

    @XmlTransient
    public List<Transportador> getTransportadorList() {
        return transportadorList;
    }

    public void setTransportadorList(List<Transportador> transportadorList) {
        this.transportadorList = transportadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransportador != null ? idTipoTransportador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransportador)) {
            return false;
        }
        TipoTransportador other = (TipoTransportador) object;
        if ((this.idTipoTransportador == null && other.idTipoTransportador != null) || (this.idTipoTransportador != null && !this.idTipoTransportador.equals(other.idTipoTransportador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoTransportador[ idTipoTransportador=" + idTipoTransportador + " ]";
    }
    
}
