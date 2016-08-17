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
@Table(name = "subcategoria_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubcategoriaItem.findAll", query = "SELECT s FROM SubcategoriaItem s"),
    @NamedQuery(name = "SubcategoriaItem.findByIdSubcategoriaItem", query = "SELECT s FROM SubcategoriaItem s WHERE s.idSubcategoriaItem = :idSubcategoriaItem"),
    @NamedQuery(name = "SubcategoriaItem.findByNomeSubcategoria", query = "SELECT s FROM SubcategoriaItem s WHERE s.nomeSubcategoria = :nomeSubcategoria")})
public class SubcategoriaItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subcategoria_item")
    private Integer idSubcategoriaItem;
    @Size(max = 50)
    @Column(name = "nome_subcategoria")
    private String nomeSubcategoria;
    @OneToMany(mappedBy = "idSubcategoria")
    private List<Item> itemList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria_item")
    @ManyToOne
    private CategoriaItem idCategoria;

    public SubcategoriaItem() {
    }

    public SubcategoriaItem(Integer idSubcategoriaItem) {
        this.idSubcategoriaItem = idSubcategoriaItem;
    }

    public Integer getIdSubcategoriaItem() {
        return idSubcategoriaItem;
    }

    public void setIdSubcategoriaItem(Integer idSubcategoriaItem) {
        this.idSubcategoriaItem = idSubcategoriaItem;
    }

    public String getNomeSubcategoria() {
        return nomeSubcategoria;
    }

    public void setNomeSubcategoria(String nomeSubcategoria) {
        this.nomeSubcategoria = nomeSubcategoria;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public CategoriaItem getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaItem idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcategoriaItem != null ? idSubcategoriaItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcategoriaItem)) {
            return false;
        }
        SubcategoriaItem other = (SubcategoriaItem) object;
        if ((this.idSubcategoriaItem == null && other.idSubcategoriaItem != null) || (this.idSubcategoriaItem != null && !this.idSubcategoriaItem.equals(other.idSubcategoriaItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SubcategoriaItem[ idSubcategoriaItem=" + idSubcategoriaItem + " ]";
    }
    
}
