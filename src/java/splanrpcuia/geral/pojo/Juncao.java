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
@Table(name = "juncao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juncao.findAll", query = "SELECT j FROM Juncao j"),
    @NamedQuery(name = "Juncao.findByIdJuncao", query = "SELECT j FROM Juncao j WHERE j.idJuncao = :idJuncao"),
    @NamedQuery(name = "Juncao.findByNomeJuncao", query = "SELECT j FROM Juncao j WHERE j.nomeJuncao = :nomeJuncao"),
    @NamedQuery(name = "Juncao.findByDescricao", query = "SELECT j FROM Juncao j WHERE j.descricao = :descricao")})
public class Juncao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_juncao")
    private Integer idJuncao;
    @Size(max = 20)
    @Column(name = "nome_juncao")
    private String nomeJuncao;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idJuncao")
    private List<Nodo> nodoList;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeHidraulica idRede;
    @JoinColumn(name = "id_tipo_juncao", referencedColumnName = "id_tipo_juncao")
    @ManyToOne
    private TipoJuncao idTipoJuncao;
    @JoinColumn(name = "id_tipo_rede", referencedColumnName = "id_tipo_rede")
    @ManyToOne
    private TipoRede idTipoRede;
    @JoinColumn(name = "id_tipo_tubulacao", referencedColumnName = "id_tipo_tubulacao")
    @ManyToOne
    private TipoTubulacao idTipoTubulacao;

    public Juncao() {
    }

    public Juncao(Integer idJuncao) {
        this.idJuncao = idJuncao;
    }

    public Integer getIdJuncao() {
        return idJuncao;
    }

    public void setIdJuncao(Integer idJuncao) {
        this.idJuncao = idJuncao;
    }

    public String getNomeJuncao() {
        return nomeJuncao;
    }

    public void setNomeJuncao(String nomeJuncao) {
        this.nomeJuncao = nomeJuncao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    public RedeHidraulica getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeHidraulica idRede) {
        this.idRede = idRede;
    }

    public TipoJuncao getIdTipoJuncao() {
        return idTipoJuncao;
    }

    public void setIdTipoJuncao(TipoJuncao idTipoJuncao) {
        this.idTipoJuncao = idTipoJuncao;
    }

    public TipoRede getIdTipoRede() {
        return idTipoRede;
    }

    public void setIdTipoRede(TipoRede idTipoRede) {
        this.idTipoRede = idTipoRede;
    }

    public TipoTubulacao getIdTipoTubulacao() {
        return idTipoTubulacao;
    }

    public void setIdTipoTubulacao(TipoTubulacao idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuncao != null ? idJuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juncao)) {
            return false;
        }
        Juncao other = (Juncao) object;
        if ((this.idJuncao == null && other.idJuncao != null) || (this.idJuncao != null && !this.idJuncao.equals(other.idJuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Juncao[ idJuncao=" + idJuncao + " ]";
    }
    
}
