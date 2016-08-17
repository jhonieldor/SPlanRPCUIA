/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "sistema_recalque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaRecalque.findAll", query = "SELECT s FROM SistemaRecalque s"),
    @NamedQuery(name = "SistemaRecalque.findByIdSistemaRecalque", query = "SELECT s FROM SistemaRecalque s WHERE s.idSistemaRecalque = :idSistemaRecalque"),
    @NamedQuery(name = "SistemaRecalque.findBySistemaRecalque", query = "SELECT s FROM SistemaRecalque s WHERE s.sistemaRecalque = :sistemaRecalque"),
    @NamedQuery(name = "SistemaRecalque.findByDescricao", query = "SELECT s FROM SistemaRecalque s WHERE s.descricao = :descricao")})
public class SistemaRecalque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistema_recalque")
    private Integer idSistemaRecalque;
    @Size(max = 50)
    @Column(name = "sistema_recalque")
    private String sistemaRecalque;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Lob
    @Column(name = "latitude_longitude")
    private Object latitudeLongitude;
    @OneToMany(mappedBy = "idSistemaRecalque")
    private List<Nodo> nodoList;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemaRecalque")
    private List<ItemSistemaRecalque> itemSistemaRecalqueList;

    public SistemaRecalque() {
    }

    public SistemaRecalque(Integer idSistemaRecalque) {
        this.idSistemaRecalque = idSistemaRecalque;
    }

    public Integer getIdSistemaRecalque() {
        return idSistemaRecalque;
    }

    public void setIdSistemaRecalque(Integer idSistemaRecalque) {
        this.idSistemaRecalque = idSistemaRecalque;
    }

    public String getSistemaRecalque() {
        return sistemaRecalque;
    }

    public void setSistemaRecalque(String sistemaRecalque) {
        this.sistemaRecalque = sistemaRecalque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Object getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public void setLatitudeLongitude(Object latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    @XmlTransient
    public List<ItemSistemaRecalque> getItemSistemaRecalqueList() {
        return itemSistemaRecalqueList;
    }

    public void setItemSistemaRecalqueList(List<ItemSistemaRecalque> itemSistemaRecalqueList) {
        this.itemSistemaRecalqueList = itemSistemaRecalqueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistemaRecalque != null ? idSistemaRecalque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaRecalque)) {
            return false;
        }
        SistemaRecalque other = (SistemaRecalque) object;
        if ((this.idSistemaRecalque == null && other.idSistemaRecalque != null) || (this.idSistemaRecalque != null && !this.idSistemaRecalque.equals(other.idSistemaRecalque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SistemaRecalque[ idSistemaRecalque=" + idSistemaRecalque + " ]";
    }
    
}
