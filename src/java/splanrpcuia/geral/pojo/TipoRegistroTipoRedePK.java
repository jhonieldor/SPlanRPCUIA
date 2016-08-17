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
public class TipoRegistroTipoRedePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_registro")
    private int idTipoRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_rede")
    private int idTipoRede;

    public TipoRegistroTipoRedePK() {
    }

    public TipoRegistroTipoRedePK(int idTipoRegistro, int idTipoRede) {
        this.idTipoRegistro = idTipoRegistro;
        this.idTipoRede = idTipoRede;
    }

    public int getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(int idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
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
        hash += (int) idTipoRegistro;
        hash += (int) idTipoRede;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistroTipoRedePK)) {
            return false;
        }
        TipoRegistroTipoRedePK other = (TipoRegistroTipoRedePK) object;
        if (this.idTipoRegistro != other.idTipoRegistro) {
            return false;
        }
        if (this.idTipoRede != other.idTipoRede) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoRegistroTipoRedePK[ idTipoRegistro=" + idTipoRegistro + ", idTipoRede=" + idTipoRede + " ]";
    }
    
}
