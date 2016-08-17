/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "item_sistema_recalque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSistemaRecalque.findAll", query = "SELECT i FROM ItemSistemaRecalque i"),
    @NamedQuery(name = "ItemSistemaRecalque.findByIdSistemaRecalque", query = "SELECT i FROM ItemSistemaRecalque i WHERE i.itemSistemaRecalquePK.idSistemaRecalque = :idSistemaRecalque"),
    @NamedQuery(name = "ItemSistemaRecalque.findByIdItem", query = "SELECT i FROM ItemSistemaRecalque i WHERE i.itemSistemaRecalquePK.idItem = :idItem"),
    @NamedQuery(name = "ItemSistemaRecalque.findByQtde", query = "SELECT i FROM ItemSistemaRecalque i WHERE i.qtde = :qtde"),
    @NamedQuery(name = "ItemSistemaRecalque.findByDetalhes", query = "SELECT i FROM ItemSistemaRecalque i WHERE i.detalhes = :detalhes")})
public class ItemSistemaRecalque implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemSistemaRecalquePK itemSistemaRecalquePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtde")
    private BigDecimal qtde;
    @Size(max = 200)
    @Column(name = "detalhes")
    private String detalhes;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_sistema_recalque", referencedColumnName = "id_sistema_recalque", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SistemaRecalque sistemaRecalque;

    public ItemSistemaRecalque() {
    }

    public ItemSistemaRecalque(ItemSistemaRecalquePK itemSistemaRecalquePK) {
        this.itemSistemaRecalquePK = itemSistemaRecalquePK;
    }

    public ItemSistemaRecalque(int idSistemaRecalque, int idItem) {
        this.itemSistemaRecalquePK = new ItemSistemaRecalquePK(idSistemaRecalque, idItem);
    }

    public ItemSistemaRecalquePK getItemSistemaRecalquePK() {
        return itemSistemaRecalquePK;
    }

    public void setItemSistemaRecalquePK(ItemSistemaRecalquePK itemSistemaRecalquePK) {
        this.itemSistemaRecalquePK = itemSistemaRecalquePK;
    }

    public BigDecimal getQtde() {
        return qtde;
    }

    public void setQtde(BigDecimal qtde) {
        this.qtde = qtde;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public SistemaRecalque getSistemaRecalque() {
        return sistemaRecalque;
    }

    public void setSistemaRecalque(SistemaRecalque sistemaRecalque) {
        this.sistemaRecalque = sistemaRecalque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemSistemaRecalquePK != null ? itemSistemaRecalquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSistemaRecalque)) {
            return false;
        }
        ItemSistemaRecalque other = (ItemSistemaRecalque) object;
        if ((this.itemSistemaRecalquePK == null && other.itemSistemaRecalquePK != null) || (this.itemSistemaRecalquePK != null && !this.itemSistemaRecalquePK.equals(other.itemSistemaRecalquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ItemSistemaRecalque[ itemSistemaRecalquePK=" + itemSistemaRecalquePK + " ]";
    }
    
}
