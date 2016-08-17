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
@Table(name = "rede_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeLancamento.findAll", query = "SELECT r FROM RedeLancamento r"),
    @NamedQuery(name = "RedeLancamento.findByIdRedeLancamento", query = "SELECT r FROM RedeLancamento r WHERE r.idRedeLancamento = :idRedeLancamento"),
    @NamedQuery(name = "RedeLancamento.findByRedeLancamento", query = "SELECT r FROM RedeLancamento r WHERE r.redeLancamento = :redeLancamento")})
public class RedeLancamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rede_lancamento")
    private Integer idRedeLancamento;
    @Size(max = 50)
    @Column(name = "rede_lancamento")
    private String redeLancamento;

    public RedeLancamento() {
    }

    public RedeLancamento(Integer idRedeLancamento) {
        this.idRedeLancamento = idRedeLancamento;
    }

    public Integer getIdRedeLancamento() {
        return idRedeLancamento;
    }

    public void setIdRedeLancamento(Integer idRedeLancamento) {
        this.idRedeLancamento = idRedeLancamento;
    }

    public String getRedeLancamento() {
        return redeLancamento;
    }

    public void setRedeLancamento(String redeLancamento) {
        this.redeLancamento = redeLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedeLancamento != null ? idRedeLancamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeLancamento)) {
            return false;
        }
        RedeLancamento other = (RedeLancamento) object;
        if ((this.idRedeLancamento == null && other.idRedeLancamento != null) || (this.idRedeLancamento != null && !this.idRedeLancamento.equals(other.idRedeLancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.RedeLancamento[ idRedeLancamento=" + idRedeLancamento + " ]";
    }
    
}
