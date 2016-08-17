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
public class FonteReservatorioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reservatorio")
    private int idReservatorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fonte")
    private int idFonte;

    public FonteReservatorioPK() {
    }

    public FonteReservatorioPK(int idReservatorio, int idFonte) {
        this.idReservatorio = idReservatorio;
        this.idFonte = idFonte;
    }

    public int getIdReservatorio() {
        return idReservatorio;
    }

    public void setIdReservatorio(int idReservatorio) {
        this.idReservatorio = idReservatorio;
    }

    public int getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(int idFonte) {
        this.idFonte = idFonte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReservatorio;
        hash += (int) idFonte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FonteReservatorioPK)) {
            return false;
        }
        FonteReservatorioPK other = (FonteReservatorioPK) object;
        if (this.idReservatorio != other.idReservatorio) {
            return false;
        }
        if (this.idFonte != other.idFonte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.FonteReservatorioPK[ idReservatorio=" + idReservatorio + ", idFonte=" + idFonte + " ]";
    }
    
}
