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
@Table(name = "fonte_abastecimento_hidrico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FonteAbastecimentoHidrico.findAll", query = "SELECT f FROM FonteAbastecimentoHidrico f"),
    @NamedQuery(name = "FonteAbastecimentoHidrico.findByIdFonte", query = "SELECT f FROM FonteAbastecimentoHidrico f WHERE f.idFonte = :idFonte")})
public class FonteAbastecimentoHidrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fonte")
    private Integer idFonte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fonteAbastecimentoHidrico")
    private List<FonteReservatorio> fonteReservatorioList;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;

    public FonteAbastecimentoHidrico() {
    }

    public FonteAbastecimentoHidrico(Integer idFonte) {
        this.idFonte = idFonte;
    }

    public Integer getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(Integer idFonte) {
        this.idFonte = idFonte;
    }

    @XmlTransient
    public List<FonteReservatorio> getFonteReservatorioList() {
        return fonteReservatorioList;
    }

    public void setFonteReservatorioList(List<FonteReservatorio> fonteReservatorioList) {
        this.fonteReservatorioList = fonteReservatorioList;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFonte != null ? idFonte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FonteAbastecimentoHidrico)) {
            return false;
        }
        FonteAbastecimentoHidrico other = (FonteAbastecimentoHidrico) object;
        if ((this.idFonte == null && other.idFonte != null) || (this.idFonte != null && !this.idFonte.equals(other.idFonte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.FonteAbastecimentoHidrico[ idFonte=" + idFonte + " ]";
    }
    
}
