/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipo_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRegistro.findAll", query = "SELECT t FROM TipoRegistro t"),
    @NamedQuery(name = "TipoRegistro.findByIdTipoRegistro", query = "SELECT t FROM TipoRegistro t WHERE t.idTipoRegistro = :idTipoRegistro"),
    @NamedQuery(name = "TipoRegistro.findByTipoRegistro", query = "SELECT t FROM TipoRegistro t WHERE t.tipoRegistro = :tipoRegistro")})
public class TipoRegistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_registro")
    private Integer idTipoRegistro;
    @Size(max = 50)
    @Column(name = "tipo_registro")
    private String tipoRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRegistro")
    private List<TipoRegistroTipoRede> tipoRegistroTipoRedeList;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;

    public TipoRegistro() {
    }

    public TipoRegistro(Integer idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    public Integer getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(Integer idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @XmlTransient
    public List<TipoRegistroTipoRede> getTipoRegistroTipoRedeList() {
        return tipoRegistroTipoRedeList;
    }

    public void setTipoRegistroTipoRedeList(List<TipoRegistroTipoRede> tipoRegistroTipoRedeList) {
        this.tipoRegistroTipoRedeList = tipoRegistroTipoRedeList;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRegistro != null ? idTipoRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistro)) {
            return false;
        }
        TipoRegistro other = (TipoRegistro) object;
        if ((this.idTipoRegistro == null && other.idTipoRegistro != null) || (this.idTipoRegistro != null && !this.idTipoRegistro.equals(other.idTipoRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoRegistro[ idTipoRegistro=" + idTipoRegistro + " ]";
    }
    
}
