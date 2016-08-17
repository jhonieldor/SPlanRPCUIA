/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "fonte_reservatorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FonteReservatorio.findAll", query = "SELECT f FROM FonteReservatorio f"),
    @NamedQuery(name = "FonteReservatorio.findByIdReservatorio", query = "SELECT f FROM FonteReservatorio f WHERE f.fonteReservatorioPK.idReservatorio = :idReservatorio"),
    @NamedQuery(name = "FonteReservatorio.findByIdFonte", query = "SELECT f FROM FonteReservatorio f WHERE f.fonteReservatorioPK.idFonte = :idFonte")})
public class FonteReservatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FonteReservatorioPK fonteReservatorioPK;
    @JoinColumn(name = "id_fonte", referencedColumnName = "id_fonte", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FonteAbastecimentoHidrico fonteAbastecimentoHidrico;
    @JoinColumn(name = "id_reservatorio", referencedColumnName = "id_reservatorio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservatorio reservatorio;
    @OneToMany(mappedBy = "fonteReservatorio")
    private List<RedeHidraulica> redeHidraulicaList;

    public FonteReservatorio() {
    }

    public FonteReservatorio(FonteReservatorioPK fonteReservatorioPK) {
        this.fonteReservatorioPK = fonteReservatorioPK;
    }

    public FonteReservatorio(int idReservatorio, int idFonte) {
        this.fonteReservatorioPK = new FonteReservatorioPK(idReservatorio, idFonte);
    }

    public FonteReservatorioPK getFonteReservatorioPK() {
        return fonteReservatorioPK;
    }

    public void setFonteReservatorioPK(FonteReservatorioPK fonteReservatorioPK) {
        this.fonteReservatorioPK = fonteReservatorioPK;
    }

    public FonteAbastecimentoHidrico getFonteAbastecimentoHidrico() {
        return fonteAbastecimentoHidrico;
    }

    public void setFonteAbastecimentoHidrico(FonteAbastecimentoHidrico fonteAbastecimentoHidrico) {
        this.fonteAbastecimentoHidrico = fonteAbastecimentoHidrico;
    }

    public Reservatorio getReservatorio() {
        return reservatorio;
    }

    public void setReservatorio(Reservatorio reservatorio) {
        this.reservatorio = reservatorio;
    }

    @XmlTransient
    public List<RedeHidraulica> getRedeHidraulicaList() {
        return redeHidraulicaList;
    }

    public void setRedeHidraulicaList(List<RedeHidraulica> redeHidraulicaList) {
        this.redeHidraulicaList = redeHidraulicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fonteReservatorioPK != null ? fonteReservatorioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FonteReservatorio)) {
            return false;
        }
        FonteReservatorio other = (FonteReservatorio) object;
        if ((this.fonteReservatorioPK == null && other.fonteReservatorioPK != null) || (this.fonteReservatorioPK != null && !this.fonteReservatorioPK.equals(other.fonteReservatorioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.FonteReservatorio[ fonteReservatorioPK=" + fonteReservatorioPK + " ]";
    }
    
}
