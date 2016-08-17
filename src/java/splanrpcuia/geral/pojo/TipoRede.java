/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipo_rede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRede.findAll", query = "SELECT t FROM TipoRede t"),
    @NamedQuery(name = "TipoRede.findByIdTipoRede", query = "SELECT t FROM TipoRede t WHERE t.idTipoRede = :idTipoRede"),
    @NamedQuery(name = "TipoRede.findByNome", query = "SELECT t FROM TipoRede t WHERE t.nome = :nome"),
    @NamedQuery(name = "TipoRede.findByTipo", query = "SELECT t FROM TipoRede t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TipoRede.findByDescricao", query = "SELECT t FROM TipoRede t WHERE t.descricao = :descricao")})
public class TipoRede implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_rede")
    private Integer idTipoRede;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRede")
    private List<TipoRegistroTipoRede> tipoRegistroTipoRedeList;
    @OneToMany(mappedBy = "idTipoRede")
    private List<RedeCaptacao> redeCaptacaoList;
    @OneToMany(mappedBy = "idTipoRede")
    private List<Juncao> juncaoList;
    @OneToMany(mappedBy = "idTipoRede")
    private List<RedeHidraulica> redeHidraulicaList;

    public TipoRede() {
    }

    public TipoRede(Integer idTipoRede) {
        this.idTipoRede = idTipoRede;
    }

    public Integer getIdTipoRede() {
        return idTipoRede;
    }

    public void setIdTipoRede(Integer idTipoRede) {
        this.idTipoRede = idTipoRede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<TipoRegistroTipoRede> getTipoRegistroTipoRedeList() {
        return tipoRegistroTipoRedeList;
    }

    public void setTipoRegistroTipoRedeList(List<TipoRegistroTipoRede> tipoRegistroTipoRedeList) {
        this.tipoRegistroTipoRedeList = tipoRegistroTipoRedeList;
    }

    @XmlTransient
    public List<RedeCaptacao> getRedeCaptacaoList() {
        return redeCaptacaoList;
    }

    public void setRedeCaptacaoList(List<RedeCaptacao> redeCaptacaoList) {
        this.redeCaptacaoList = redeCaptacaoList;
    }

    @XmlTransient
    public List<Juncao> getJuncaoList() {
        return juncaoList;
    }

    public void setJuncaoList(List<Juncao> juncaoList) {
        this.juncaoList = juncaoList;
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
        hash += (idTipoRede != null ? idTipoRede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRede)) {
            return false;
        }
        TipoRede other = (TipoRede) object;
        if ((this.idTipoRede == null && other.idTipoRede != null) || (this.idTipoRede != null && !this.idTipoRede.equals(other.idTipoRede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoRede[ idTipoRede=" + idTipoRede + " ]";
    }
    
}
