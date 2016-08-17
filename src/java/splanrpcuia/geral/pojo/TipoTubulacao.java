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
@Table(name = "tipo_tubulacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTubulacao.findAll", query = "SELECT t FROM TipoTubulacao t"),
    @NamedQuery(name = "TipoTubulacao.findByIdTipoTubulacao", query = "SELECT t FROM TipoTubulacao t WHERE t.idTipoTubulacao = :idTipoTubulacao"),
    @NamedQuery(name = "TipoTubulacao.findByTipoTubulacao", query = "SELECT t FROM TipoTubulacao t WHERE t.tipoTubulacao = :tipoTubulacao"),
    @NamedQuery(name = "TipoTubulacao.findByRevestimento", query = "SELECT t FROM TipoTubulacao t WHERE t.revestimento = :revestimento")})
public class TipoTubulacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_tubulacao")
    private Integer idTipoTubulacao;
    @Size(max = 50)
    @Column(name = "tipo_tubulacao")
    private String tipoTubulacao;
    @Size(max = 100)
    @Column(name = "revestimento")
    private String revestimento;
    @OneToMany(mappedBy = "idTipoTubulacao")
    private List<Adutora> adutoraList;
    @OneToMany(mappedBy = "idTipoTubulacao")
    private List<TubulacaoRedeReuso> tubulacaoRedeReusoList;
    @OneToMany(mappedBy = "idTipoTubulacao")
    private List<TubulacaoHidraulica> tubulacaoHidraulicaList;
    @OneToMany(mappedBy = "idTipoTubulacao")
    private List<TipoJuncao> tipoJuncaoList;
    @OneToMany(mappedBy = "idTipoTubulacao")
    private List<TubulacaoPneumatica> tubulacaoPneumaticaList;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @OneToMany(mappedBy = "idTipoTubulacao")
    private List<Juncao> juncaoList;

    public TipoTubulacao() {
    }

    public TipoTubulacao(Integer idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    public Integer getIdTipoTubulacao() {
        return idTipoTubulacao;
    }

    public void setIdTipoTubulacao(Integer idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    public String getTipoTubulacao() {
        return tipoTubulacao;
    }

    public void setTipoTubulacao(String tipoTubulacao) {
        this.tipoTubulacao = tipoTubulacao;
    }

    public String getRevestimento() {
        return revestimento;
    }

    public void setRevestimento(String revestimento) {
        this.revestimento = revestimento;
    }

    @XmlTransient
    public List<Adutora> getAdutoraList() {
        return adutoraList;
    }

    public void setAdutoraList(List<Adutora> adutoraList) {
        this.adutoraList = adutoraList;
    }

    @XmlTransient
    public List<TubulacaoRedeReuso> getTubulacaoRedeReusoList() {
        return tubulacaoRedeReusoList;
    }

    public void setTubulacaoRedeReusoList(List<TubulacaoRedeReuso> tubulacaoRedeReusoList) {
        this.tubulacaoRedeReusoList = tubulacaoRedeReusoList;
    }

    @XmlTransient
    public List<TubulacaoHidraulica> getTubulacaoHidraulicaList() {
        return tubulacaoHidraulicaList;
    }

    public void setTubulacaoHidraulicaList(List<TubulacaoHidraulica> tubulacaoHidraulicaList) {
        this.tubulacaoHidraulicaList = tubulacaoHidraulicaList;
    }

    @XmlTransient
    public List<TipoJuncao> getTipoJuncaoList() {
        return tipoJuncaoList;
    }

    public void setTipoJuncaoList(List<TipoJuncao> tipoJuncaoList) {
        this.tipoJuncaoList = tipoJuncaoList;
    }

    @XmlTransient
    public List<TubulacaoPneumatica> getTubulacaoPneumaticaList() {
        return tubulacaoPneumaticaList;
    }

    public void setTubulacaoPneumaticaList(List<TubulacaoPneumatica> tubulacaoPneumaticaList) {
        this.tubulacaoPneumaticaList = tubulacaoPneumaticaList;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
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
        hash += (idTipoTubulacao != null ? idTipoTubulacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTubulacao)) {
            return false;
        }
        TipoTubulacao other = (TipoTubulacao) object;
        if ((this.idTipoTubulacao == null && other.idTipoTubulacao != null) || (this.idTipoTubulacao != null && !this.idTipoTubulacao.equals(other.idTipoTubulacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoTubulacao[ idTipoTubulacao=" + idTipoTubulacao + " ]";
    }
    
}
