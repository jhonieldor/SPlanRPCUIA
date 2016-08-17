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
@Table(name = "categoria_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaItem.findAll", query = "SELECT c FROM CategoriaItem c"),
    @NamedQuery(name = "CategoriaItem.findByIdCategoriaItem", query = "SELECT c FROM CategoriaItem c WHERE c.idCategoriaItem = :idCategoriaItem"),
    @NamedQuery(name = "CategoriaItem.findByNomeCategoria", query = "SELECT c FROM CategoriaItem c WHERE c.nomeCategoria = :nomeCategoria")})
public class CategoriaItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_item")
    private Integer idCategoriaItem;
    @Size(max = 50)
    @Column(name = "nome_categoria")
    private String nomeCategoria;
    @OneToMany(mappedBy = "idCategoria")
    private List<Item> itemList;
    @OneToMany(mappedBy = "idCategoria")
    private List<SubcategoriaItem> subcategoriaItemList;

    public CategoriaItem() {
    }

    public CategoriaItem(Integer idCategoriaItem) {
        this.idCategoriaItem = idCategoriaItem;
    }

    public Integer getIdCategoriaItem() {
        return idCategoriaItem;
    }

    public void setIdCategoriaItem(Integer idCategoriaItem) {
        this.idCategoriaItem = idCategoriaItem;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<SubcategoriaItem> getSubcategoriaItemList() {
        return subcategoriaItemList;
    }

    public void setSubcategoriaItemList(List<SubcategoriaItem> subcategoriaItemList) {
        this.subcategoriaItemList = subcategoriaItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaItem != null ? idCategoriaItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaItem)) {
            return false;
        }
        CategoriaItem other = (CategoriaItem) object;
        if ((this.idCategoriaItem == null && other.idCategoriaItem != null) || (this.idCategoriaItem != null && !this.idCategoriaItem.equals(other.idCategoriaItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.CategoriaItem[ idCategoriaItem=" + idCategoriaItem + " ]";
    }
    
}
