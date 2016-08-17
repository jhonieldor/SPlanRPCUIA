/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "localizacao_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalizacaoItem.findAll", query = "SELECT l FROM LocalizacaoItem l"),
    @NamedQuery(name = "LocalizacaoItem.findByIdLocalizacao", query = "SELECT l FROM LocalizacaoItem l WHERE l.idLocalizacao = :idLocalizacao"),
    @NamedQuery(name = "LocalizacaoItem.findByRua", query = "SELECT l FROM LocalizacaoItem l WHERE l.rua = :rua"),
    @NamedQuery(name = "LocalizacaoItem.findByPrateleira", query = "SELECT l FROM LocalizacaoItem l WHERE l.prateleira = :prateleira"),
    @NamedQuery(name = "LocalizacaoItem.findByLocaBox", query = "SELECT l FROM LocalizacaoItem l WHERE l.locaBox = :locaBox")})
public class LocalizacaoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_localizacao")
    private Integer idLocalizacao;
    @Size(max = 10)
    @Column(name = "rua")
    private String rua;
    @Size(max = 10)
    @Column(name = "prateleira")
    private String prateleira;
    @Size(max = 10)
    @Column(name = "loca_box")
    private String locaBox;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne
    private Item idItem;

    public LocalizacaoItem() {
    }

    public LocalizacaoItem(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public Integer getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getLocaBox() {
        return locaBox;
    }

    public void setLocaBox(String locaBox) {
        this.locaBox = locaBox;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalizacao != null ? idLocalizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalizacaoItem)) {
            return false;
        }
        LocalizacaoItem other = (LocalizacaoItem) object;
        if ((this.idLocalizacao == null && other.idLocalizacao != null) || (this.idLocalizacao != null && !this.idLocalizacao.equals(other.idLocalizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.LocalizacaoItem[ idLocalizacao=" + idLocalizacao + " ]";
    }
    
}
