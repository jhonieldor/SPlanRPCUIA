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
@Table(name = "tipo_juncao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoJuncao.findAll", query = "SELECT t FROM TipoJuncao t"),
    @NamedQuery(name = "TipoJuncao.findByIdTipoJuncao", query = "SELECT t FROM TipoJuncao t WHERE t.idTipoJuncao = :idTipoJuncao"),
    @NamedQuery(name = "TipoJuncao.findByTipoJuncao", query = "SELECT t FROM TipoJuncao t WHERE t.tipoJuncao = :tipoJuncao")})
public class TipoJuncao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_juncao")
    private Integer idTipoJuncao;
    @Size(max = 50)
    @Column(name = "tipo_juncao")
    private String tipoJuncao;
    @OneToMany(mappedBy = "idTipoJuncao")
    private List<SistemaJuncao> sistemaJuncaoList;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_tipo_tubulacao", referencedColumnName = "id_tipo_tubulacao")
    @ManyToOne
    private TipoTubulacao idTipoTubulacao;
    @OneToMany(mappedBy = "idTipoJuncao")
    private List<Juncao> juncaoList;

    public TipoJuncao() {
    }

    public TipoJuncao(Integer idTipoJuncao) {
        this.idTipoJuncao = idTipoJuncao;
    }

    public Integer getIdTipoJuncao() {
        return idTipoJuncao;
    }

    public void setIdTipoJuncao(Integer idTipoJuncao) {
        this.idTipoJuncao = idTipoJuncao;
    }

    public String getTipoJuncao() {
        return tipoJuncao;
    }

    public void setTipoJuncao(String tipoJuncao) {
        this.tipoJuncao = tipoJuncao;
    }

    @XmlTransient
    public List<SistemaJuncao> getSistemaJuncaoList() {
        return sistemaJuncaoList;
    }

    public void setSistemaJuncaoList(List<SistemaJuncao> sistemaJuncaoList) {
        this.sistemaJuncaoList = sistemaJuncaoList;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public TipoTubulacao getIdTipoTubulacao() {
        return idTipoTubulacao;
    }

    public void setIdTipoTubulacao(TipoTubulacao idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    @XmlTransient
    public List<Juncao> getJuncaoList() {
        return juncaoList;
    }

    public void setJuncaoList(List<Juncao> juncaoList) {
        this.juncaoList = juncaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoJuncao != null ? idTipoJuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoJuncao)) {
            return false;
        }
        TipoJuncao other = (TipoJuncao) object;
        if ((this.idTipoJuncao == null && other.idTipoJuncao != null) || (this.idTipoJuncao != null && !this.idTipoJuncao.equals(other.idTipoJuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoJuncao[ idTipoJuncao=" + idTipoJuncao + " ]";
    }
    
}
