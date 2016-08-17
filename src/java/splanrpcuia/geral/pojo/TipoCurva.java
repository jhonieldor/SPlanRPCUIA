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
@Table(name = "tipo_curva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCurva.findAll", query = "SELECT t FROM TipoCurva t"),
    @NamedQuery(name = "TipoCurva.findByIdTipoCurva", query = "SELECT t FROM TipoCurva t WHERE t.idTipoCurva = :idTipoCurva"),
    @NamedQuery(name = "TipoCurva.findByTipoCurva", query = "SELECT t FROM TipoCurva t WHERE t.tipoCurva = :tipoCurva")})
public class TipoCurva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_curva")
    private Integer idTipoCurva;
    @Size(max = 50)
    @Column(name = "tipo_curva")
    private String tipoCurva;

    public TipoCurva() {
    }

    public TipoCurva(Integer idTipoCurva) {
        this.idTipoCurva = idTipoCurva;
    }

    public Integer getIdTipoCurva() {
        return idTipoCurva;
    }

    public void setIdTipoCurva(Integer idTipoCurva) {
        this.idTipoCurva = idTipoCurva;
    }

    public String getTipoCurva() {
        return tipoCurva;
    }

    public void setTipoCurva(String tipoCurva) {
        this.tipoCurva = tipoCurva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCurva != null ? idTipoCurva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCurva)) {
            return false;
        }
        TipoCurva other = (TipoCurva) object;
        if ((this.idTipoCurva == null && other.idTipoCurva != null) || (this.idTipoCurva != null && !this.idTipoCurva.equals(other.idTipoCurva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoCurva[ idTipoCurva=" + idTipoCurva + " ]";
    }
    
}
