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
import javax.persistence.JoinColumn;
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
@Table(name = "sub_unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubUnidade.findAll", query = "SELECT s FROM SubUnidade s"),
    @NamedQuery(name = "SubUnidade.findByIdUnidadePredial", query = "SELECT s FROM SubUnidade s WHERE s.idUnidadePredial = :idUnidadePredial"),
    @NamedQuery(name = "SubUnidade.findByNome", query = "SELECT s FROM SubUnidade s WHERE s.nome = :nome")})
public class SubUnidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidade_predial")
    private Integer idUnidadePredial;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
    @ManyToOne
    private Unidade idUnidade;
    @OneToMany(mappedBy = "idSubunidade")
    private List<RedeHidraulica> redeHidraulicaList;

    public SubUnidade() {
    }

    public SubUnidade(Integer idUnidadePredial) {
        this.idUnidadePredial = idUnidadePredial;
    }

    public Integer getIdUnidadePredial() {
        return idUnidadePredial;
    }

    public void setIdUnidadePredial(Integer idUnidadePredial) {
        this.idUnidadePredial = idUnidadePredial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Unidade getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Unidade idUnidade) {
        this.idUnidade = idUnidade;
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
        hash += (idUnidadePredial != null ? idUnidadePredial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubUnidade)) {
            return false;
        }
        SubUnidade other = (SubUnidade) object;
        if ((this.idUnidadePredial == null && other.idUnidadePredial != null) || (this.idUnidadePredial != null && !this.idUnidadePredial.equals(other.idUnidadePredial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SubUnidade[ idUnidadePredial=" + idUnidadePredial + " ]";
    }
    
}
