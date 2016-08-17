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
@Table(name = "unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u"),
    @NamedQuery(name = "Unidade.findByIdUnidade", query = "SELECT u FROM Unidade u WHERE u.idUnidade = :idUnidade"),
    @NamedQuery(name = "Unidade.findByNome", query = "SELECT u FROM Unidade u WHERE u.nome = :nome"),
    @NamedQuery(name = "Unidade.findByEndereco", query = "SELECT u FROM Unidade u WHERE u.endereco = :endereco"),
    @NamedQuery(name = "Unidade.findByCidade", query = "SELECT u FROM Unidade u WHERE u.cidade = :cidade"),
    @NamedQuery(name = "Unidade.findByEstado", query = "SELECT u FROM Unidade u WHERE u.estado = :estado"),
    @NamedQuery(name = "Unidade.findByUf", query = "SELECT u FROM Unidade u WHERE u.uf = :uf")})
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidade")
    private Integer idUnidade;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 20)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @OneToMany(mappedBy = "idUnidade")
    private List<Setor> setorList;
    @OneToMany(mappedBy = "idUnidade")
    private List<SubUnidade> subUnidadeList;
    @OneToMany(mappedBy = "idUnidade")
    private List<SistemaPneumatico> sistemaPneumaticoList;

    public Unidade() {
    }

    public Unidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @XmlTransient
    public List<Setor> getSetorList() {
        return setorList;
    }

    public void setSetorList(List<Setor> setorList) {
        this.setorList = setorList;
    }

    @XmlTransient
    public List<SubUnidade> getSubUnidadeList() {
        return subUnidadeList;
    }

    public void setSubUnidadeList(List<SubUnidade> subUnidadeList) {
        this.subUnidadeList = subUnidadeList;
    }

    @XmlTransient
    public List<SistemaPneumatico> getSistemaPneumaticoList() {
        return sistemaPneumaticoList;
    }

    public void setSistemaPneumaticoList(List<SistemaPneumatico> sistemaPneumaticoList) {
        this.sistemaPneumaticoList = sistemaPneumaticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidade != null ? idUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.idUnidade == null && other.idUnidade != null) || (this.idUnidade != null && !this.idUnidade.equals(other.idUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Unidade[ idUnidade=" + idUnidade + " ]";
    }
    
}
