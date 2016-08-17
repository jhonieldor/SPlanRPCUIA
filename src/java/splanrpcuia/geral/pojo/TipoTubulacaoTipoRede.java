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
@Table(name = "tipo_tubulacao_tipo_rede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTubulacaoTipoRede.findAll", query = "SELECT t FROM TipoTubulacaoTipoRede t"),
    @NamedQuery(name = "TipoTubulacaoTipoRede.findByIdTipoTubulacao", query = "SELECT t FROM TipoTubulacaoTipoRede t WHERE t.tipoTubulacaoTipoRedePK.idTipoTubulacao = :idTipoTubulacao"),
    @NamedQuery(name = "TipoTubulacaoTipoRede.findByIdTipoRede", query = "SELECT t FROM TipoTubulacaoTipoRede t WHERE t.tipoTubulacaoTipoRedePK.idTipoRede = :idTipoRede")})
public class TipoTubulacaoTipoRede implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoTubulacaoTipoRedePK tipoTubulacaoTipoRedePK;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;

    public TipoTubulacaoTipoRede() {
    }

    public TipoTubulacaoTipoRede(TipoTubulacaoTipoRedePK tipoTubulacaoTipoRedePK) {
        this.tipoTubulacaoTipoRedePK = tipoTubulacaoTipoRedePK;
    }

    public TipoTubulacaoTipoRede(int idTipoTubulacao, int idTipoRede) {
        this.tipoTubulacaoTipoRedePK = new TipoTubulacaoTipoRedePK(idTipoTubulacao, idTipoRede);
    }

    public TipoTubulacaoTipoRedePK getTipoTubulacaoTipoRedePK() {
        return tipoTubulacaoTipoRedePK;
    }

    public void setTipoTubulacaoTipoRedePK(TipoTubulacaoTipoRedePK tipoTubulacaoTipoRedePK) {
        this.tipoTubulacaoTipoRedePK = tipoTubulacaoTipoRedePK;
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
        hash += (tipoTubulacaoTipoRedePK != null ? tipoTubulacaoTipoRedePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTubulacaoTipoRede)) {
            return false;
        }
        TipoTubulacaoTipoRede other = (TipoTubulacaoTipoRede) object;
        if ((this.tipoTubulacaoTipoRedePK == null && other.tipoTubulacaoTipoRedePK != null) || (this.tipoTubulacaoTipoRedePK != null && !this.tipoTubulacaoTipoRedePK.equals(other.tipoTubulacaoTipoRedePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoTubulacaoTipoRede[ tipoTubulacaoTipoRedePK=" + tipoTubulacaoTipoRedePK + " ]";
    }
    
}
