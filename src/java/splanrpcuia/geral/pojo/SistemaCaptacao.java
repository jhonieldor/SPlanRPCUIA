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
@Table(name = "sistema_captacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaCaptacao.findAll", query = "SELECT s FROM SistemaCaptacao s"),
    @NamedQuery(name = "SistemaCaptacao.findByIdSistema", query = "SELECT s FROM SistemaCaptacao s WHERE s.idSistema = :idSistema"),
    @NamedQuery(name = "SistemaCaptacao.findByNome", query = "SELECT s FROM SistemaCaptacao s WHERE s.nome = :nome")})
public class SistemaCaptacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistema")
    private Integer idSistema;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idSistema")
    private List<RedeCaptacao> redeCaptacaoList;

    public SistemaCaptacao() {
    }

    public SistemaCaptacao(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<RedeCaptacao> getRedeCaptacaoList() {
        return redeCaptacaoList;
    }

    public void setRedeCaptacaoList(List<RedeCaptacao> redeCaptacaoList) {
        this.redeCaptacaoList = redeCaptacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistema != null ? idSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaCaptacao)) {
            return false;
        }
        SistemaCaptacao other = (SistemaCaptacao) object;
        if ((this.idSistema == null && other.idSistema != null) || (this.idSistema != null && !this.idSistema.equals(other.idSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SistemaCaptacao[ idSistema=" + idSistema + " ]";
    }
    
}
