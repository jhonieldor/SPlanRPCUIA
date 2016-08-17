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
@Table(name = "tipo_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSistema.findAll", query = "SELECT t FROM TipoSistema t"),
    @NamedQuery(name = "TipoSistema.findByIdTipoSistema", query = "SELECT t FROM TipoSistema t WHERE t.idTipoSistema = :idTipoSistema"),
    @NamedQuery(name = "TipoSistema.findByTipoSistema", query = "SELECT t FROM TipoSistema t WHERE t.tipoSistema = :tipoSistema"),
    @NamedQuery(name = "TipoSistema.findBySegmentacao", query = "SELECT t FROM TipoSistema t WHERE t.segmentacao = :segmentacao")})
public class TipoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_sistema")
    private Integer idTipoSistema;
    @Size(max = 50)
    @Column(name = "tipo_sistema")
    private String tipoSistema;
    @Size(max = 100)
    @Column(name = "segmentacao")
    private String segmentacao;
    @OneToMany(mappedBy = "tipoSistema")
    private List<Sistema> sistemaList;

    public TipoSistema() {
    }

    public TipoSistema(Integer idTipoSistema) {
        this.idTipoSistema = idTipoSistema;
    }

    public Integer getIdTipoSistema() {
        return idTipoSistema;
    }

    public void setIdTipoSistema(Integer idTipoSistema) {
        this.idTipoSistema = idTipoSistema;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public String getSegmentacao() {
        return segmentacao;
    }

    public void setSegmentacao(String segmentacao) {
        this.segmentacao = segmentacao;
    }

    @XmlTransient
    public List<Sistema> getSistemaList() {
        return sistemaList;
    }

    public void setSistemaList(List<Sistema> sistemaList) {
        this.sistemaList = sistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSistema != null ? idTipoSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSistema)) {
            return false;
        }
        TipoSistema other = (TipoSistema) object;
        if ((this.idTipoSistema == null && other.idTipoSistema != null) || (this.idTipoSistema != null && !this.idTipoSistema.equals(other.idTipoSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoSistema[ idTipoSistema=" + idTipoSistema + " ]";
    }
    
}
