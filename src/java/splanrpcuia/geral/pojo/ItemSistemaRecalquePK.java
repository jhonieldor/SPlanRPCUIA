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
public class ItemSistemaRecalquePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sistema_recalque")
    private int idSistemaRecalque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_item")
    private int idItem;

    public ItemSistemaRecalquePK() {
    }

    public ItemSistemaRecalquePK(int idSistemaRecalque, int idItem) {
        this.idSistemaRecalque = idSistemaRecalque;
        this.idItem = idItem;
    }

    public int getIdSistemaRecalque() {
        return idSistemaRecalque;
    }

    public void setIdSistemaRecalque(int idSistemaRecalque) {
        this.idSistemaRecalque = idSistemaRecalque;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSistemaRecalque;
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSistemaRecalquePK)) {
            return false;
        }
        ItemSistemaRecalquePK other = (ItemSistemaRecalquePK) object;
        if (this.idSistemaRecalque != other.idSistemaRecalque) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ItemSistemaRecalquePK[ idSistemaRecalque=" + idSistemaRecalque + ", idItem=" + idItem + " ]";
    }
    
}
