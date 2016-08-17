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
@Table(name = "maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m"),
    @NamedQuery(name = "Maquina.findByIdMaquina", query = "SELECT m FROM Maquina m WHERE m.idMaquina = :idMaquina")})
public class Maquina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_maquina")
    private Integer idMaquina;
    @OneToMany(mappedBy = "idMaquina")
    private List<ManualMaquina> manualMaquinaList;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_empresa")
    @ManyToOne
    private Empresa idFornecedor;
    @JoinColumn(name = "id_equipamento", referencedColumnName = "id_eq")
    @ManyToOne
    private Equipamento idEquipamento;
    @OneToMany(mappedBy = "idMaquina")
    private List<ItemMaquina> itemMaquinaList;

    public Maquina() {
    }

    public Maquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    @XmlTransient
    public List<ManualMaquina> getManualMaquinaList() {
        return manualMaquinaList;
    }

    public void setManualMaquinaList(List<ManualMaquina> manualMaquinaList) {
        this.manualMaquinaList = manualMaquinaList;
    }

    public Empresa getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Empresa idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Equipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @XmlTransient
    public List<ItemMaquina> getItemMaquinaList() {
        return itemMaquinaList;
    }

    public void setItemMaquinaList(List<ItemMaquina> itemMaquinaList) {
        this.itemMaquinaList = itemMaquinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquina != null ? idMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.idMaquina == null && other.idMaquina != null) || (this.idMaquina != null && !this.idMaquina.equals(other.idMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Maquina[ idMaquina=" + idMaquina + " ]";
    }
    
}
