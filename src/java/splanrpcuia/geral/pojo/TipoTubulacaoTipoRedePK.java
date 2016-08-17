/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrador
 */
@Embeddable
public class TipoTubulacaoTipoRedePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_tubulacao")
    private int idTipoTubulacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_rede")
    private int idTipoRede;

    public TipoTubulacaoTipoRedePK() {
    }

    public TipoTubulacaoTipoRedePK(int idTipoTubulacao, int idTipoRede) {
        this.idTipoTubulacao = idTipoTubulacao;
        this.idTipoRede = idTipoRede;
    }

    public int getIdTipoTubulacao() {
        return idTipoTubulacao;
    }

    public void setIdTipoTubulacao(int idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    public int getIdTipoRede() {
        return idTipoRede;
    }

    public void setIdTipoRede(int idTipoRede) {
        this.idTipoRede = idTipoRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTipoTubulacao;
        hash += (int) idTipoRede;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTubulacaoTipoRedePK)) {
            return false;
        }
        TipoTubulacaoTipoRedePK other = (TipoTubulacaoTipoRedePK) object;
        if (this.idTipoTubulacao != other.idTipoTubulacao) {
            return false;
        }
        if (this.idTipoRede != other.idTipoRede) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoTubulacaoTipoRedePK[ idTipoTubulacao=" + idTipoTubulacao + ", idTipoRede=" + idTipoRede + " ]";
    }
    
}
