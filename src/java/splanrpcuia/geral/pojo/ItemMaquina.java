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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "item_maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemMaquina.findAll", query = "SELECT i FROM ItemMaquina i"),
    @NamedQuery(name = "ItemMaquina.findByIdItemMaquina", query = "SELECT i FROM ItemMaquina i WHERE i.idItemMaquina = :idItemMaquina")})
public class ItemMaquina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_maquina")
    private Integer idItemMaquina;
    @OneToMany(mappedBy = "idItemMaquina")
    private List<ChecklistMaquina> checklistMaquinaList;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne
    private Item idItem;
    @JoinColumn(name = "id_maquina", referencedColumnName = "id_maquina")
    @ManyToOne
    private Maquina idMaquina;

    public ItemMaquina() {
    }

    public ItemMaquina(Integer idItemMaquina) {
        this.idItemMaquina = idItemMaquina;
    }

    public Integer getIdItemMaquina() {
        return idItemMaquina;
    }

    public void setIdItemMaquina(Integer idItemMaquina) {
        this.idItemMaquina = idItemMaquina;
    }

    @XmlTransient
    public List<ChecklistMaquina> getChecklistMaquinaList() {
        return checklistMaquinaList;
    }

    public void setChecklistMaquinaList(List<ChecklistMaquina> checklistMaquinaList) {
        this.checklistMaquinaList = checklistMaquinaList;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemMaquina != null ? idItemMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemMaquina)) {
            return false;
        }
        ItemMaquina other = (ItemMaquina) object;
        if ((this.idItemMaquina == null && other.idItemMaquina != null) || (this.idItemMaquina != null && !this.idItemMaquina.equals(other.idItemMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ItemMaquina[ idItemMaquina=" + idItemMaquina + " ]";
    }
    
}
