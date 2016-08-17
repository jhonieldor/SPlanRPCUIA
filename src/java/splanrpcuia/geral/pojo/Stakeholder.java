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
@Table(name = "stakeholder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stakeholder.findAll", query = "SELECT s FROM Stakeholder s"),
    @NamedQuery(name = "Stakeholder.findByIdStakeholder", query = "SELECT s FROM Stakeholder s WHERE s.idStakeholder = :idStakeholder"),
    @NamedQuery(name = "Stakeholder.findByIdEmpresa", query = "SELECT s FROM Stakeholder s WHERE s.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Stakeholder.findByNome", query = "SELECT s FROM Stakeholder s WHERE s.nome = :nome"),
    @NamedQuery(name = "Stakeholder.findByOcupacao", query = "SELECT s FROM Stakeholder s WHERE s.ocupacao = :ocupacao")})
public class Stakeholder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stakeholder")
    private Integer idStakeholder;
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "ocupacao")
    private String ocupacao;
    @OneToMany(mappedBy = "idStakeholder")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "responsavel")
    private List<Setor> setorList;

    public Stakeholder() {
    }

    public Stakeholder(Integer idStakeholder) {
        this.idStakeholder = idStakeholder;
    }

    public Integer getIdStakeholder() {
        return idStakeholder;
    }

    public void setIdStakeholder(Integer idStakeholder) {
        this.idStakeholder = idStakeholder;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Setor> getSetorList() {
        return setorList;
    }

    public void setSetorList(List<Setor> setorList) {
        this.setorList = setorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStakeholder != null ? idStakeholder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stakeholder)) {
            return false;
        }
        Stakeholder other = (Stakeholder) object;
        if ((this.idStakeholder == null && other.idStakeholder != null) || (this.idStakeholder != null && !this.idStakeholder.equals(other.idStakeholder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Stakeholder[ idStakeholder=" + idStakeholder + " ]";
    }
    
}
