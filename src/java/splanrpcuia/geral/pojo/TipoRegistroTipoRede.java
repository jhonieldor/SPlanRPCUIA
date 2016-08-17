/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tipo_registro_tipo_rede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRegistroTipoRede.findAll", query = "SELECT t FROM TipoRegistroTipoRede t"),
    @NamedQuery(name = "TipoRegistroTipoRede.findByIdTipoRegistro", query = "SELECT t FROM TipoRegistroTipoRede t WHERE t.tipoRegistroTipoRedePK.idTipoRegistro = :idTipoRegistro"),
    @NamedQuery(name = "TipoRegistroTipoRede.findByIdTipoRede", query = "SELECT t FROM TipoRegistroTipoRede t WHERE t.tipoRegistroTipoRedePK.idTipoRede = :idTipoRede")})
public class TipoRegistroTipoRede implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoRegistroTipoRedePK tipoRegistroTipoRedePK;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_tipo_rede", referencedColumnName = "id_tipo_rede", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoRede tipoRede;
    @JoinColumn(name = "id_tipo_registro", referencedColumnName = "id_tipo_registro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoRegistro tipoRegistro;

    public TipoRegistroTipoRede() {
    }

    public TipoRegistroTipoRede(TipoRegistroTipoRedePK tipoRegistroTipoRedePK) {
        this.tipoRegistroTipoRedePK = tipoRegistroTipoRedePK;
    }

    public TipoRegistroTipoRede(int idTipoRegistro, int idTipoRede) {
        this.tipoRegistroTipoRedePK = new TipoRegistroTipoRedePK(idTipoRegistro, idTipoRede);
    }

    public TipoRegistroTipoRedePK getTipoRegistroTipoRedePK() {
        return tipoRegistroTipoRedePK;
    }

    public void setTipoRegistroTipoRedePK(TipoRegistroTipoRedePK tipoRegistroTipoRedePK) {
        this.tipoRegistroTipoRedePK = tipoRegistroTipoRedePK;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public TipoRede getTipoRede() {
        return tipoRede;
    }

    public void setTipoRede(TipoRede tipoRede) {
        this.tipoRede = tipoRede;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoRegistroTipoRedePK != null ? tipoRegistroTipoRedePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistroTipoRede)) {
            return false;
        }
        TipoRegistroTipoRede other = (TipoRegistroTipoRede) object;
        if ((this.tipoRegistroTipoRedePK == null && other.tipoRegistroTipoRedePK != null) || (this.tipoRegistroTipoRedePK != null && !this.tipoRegistroTipoRedePK.equals(other.tipoRegistroTipoRedePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoRegistroTipoRede[ tipoRegistroTipoRedePK=" + tipoRegistroTipoRedePK + " ]";
    }
    
}
