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
@Table(name = "rede_reuso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeReuso.findAll", query = "SELECT r FROM RedeReuso r"),
    @NamedQuery(name = "RedeReuso.findByIdRedeReuso", query = "SELECT r FROM RedeReuso r WHERE r.idRedeReuso = :idRedeReuso"),
    @NamedQuery(name = "RedeReuso.findByNomeRede", query = "SELECT r FROM RedeReuso r WHERE r.nomeRede = :nomeRede")})
public class RedeReuso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rede_reuso")
    private Integer idRedeReuso;
    @Size(max = 200)
    @Column(name = "nome_rede")
    private String nomeRede;

    public RedeReuso() {
    }

    public RedeReuso(Integer idRedeReuso) {
        this.idRedeReuso = idRedeReuso;
    }

    public Integer getIdRedeReuso() {
        return idRedeReuso;
    }

    public void setIdRedeReuso(Integer idRedeReuso) {
        this.idRedeReuso = idRedeReuso;
    }

    public String getNomeRede() {
        return nomeRede;
    }

    public void setNomeRede(String nomeRede) {
        this.nomeRede = nomeRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedeReuso != null ? idRedeReuso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeReuso)) {
            return false;
        }
        RedeReuso other = (RedeReuso) object;
        if ((this.idRedeReuso == null && other.idRedeReuso != null) || (this.idRedeReuso != null && !this.idRedeReuso.equals(other.idRedeReuso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.RedeReuso[ idRedeReuso=" + idRedeReuso + " ]";
    }
    
}
