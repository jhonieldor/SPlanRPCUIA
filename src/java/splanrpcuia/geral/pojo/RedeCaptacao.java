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
@Table(name = "rede_captacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeCaptacao.findAll", query = "SELECT r FROM RedeCaptacao r"),
    @NamedQuery(name = "RedeCaptacao.findByIdRede", query = "SELECT r FROM RedeCaptacao r WHERE r.idRede = :idRede"),
    @NamedQuery(name = "RedeCaptacao.findByNome", query = "SELECT r FROM RedeCaptacao r WHERE r.nome = :nome"),
    @NamedQuery(name = "RedeCaptacao.findByIdentificacao", query = "SELECT r FROM RedeCaptacao r WHERE r.identificacao = :identificacao")})
public class RedeCaptacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rede")
    private Integer idRede;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "identificacao")
    private String identificacao;
    @OneToMany(mappedBy = "idRede")
    private List<Adutora> adutoraList;
    @OneToMany(mappedBy = "idRede")
    private List<Nodo> nodoList;
    @OneToMany(mappedBy = "idRede")
    private List<Captacao> captacaoList;
    @OneToMany(mappedBy = "idRede")
    private List<SistemaRecalque> sistemaRecalqueList;
    @OneToMany(mappedBy = "idRede")
    private List<FonteAbastecimentoHidrico> fonteAbastecimentoHidricoList;
    @OneToMany(mappedBy = "idRede")
    private List<Poco> pocoList;
    @OneToMany(mappedBy = "idRede")
    private List<Cisterna> cisternaList;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema")
    @ManyToOne
    private SistemaCaptacao idSistema;
    @JoinColumn(name = "id_tipo_rede", referencedColumnName = "id_tipo_rede")
    @ManyToOne
    private TipoRede idTipoRede;
    @OneToMany(mappedBy = "idRede")
    private List<Valvula> valvulaList;

    public RedeCaptacao() {
    }

    public RedeCaptacao(Integer idRede) {
        this.idRede = idRede;
    }

    public Integer getIdRede() {
        return idRede;
    }

    public void setIdRede(Integer idRede) {
        this.idRede = idRede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    @XmlTransient
    public List<Adutora> getAdutoraList() {
        return adutoraList;
    }

    public void setAdutoraList(List<Adutora> adutoraList) {
        this.adutoraList = adutoraList;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    @XmlTransient
    public List<Captacao> getCaptacaoList() {
        return captacaoList;
    }

    public void setCaptacaoList(List<Captacao> captacaoList) {
        this.captacaoList = captacaoList;
    }

    @XmlTransient
    public List<SistemaRecalque> getSistemaRecalqueList() {
        return sistemaRecalqueList;
    }

    public void setSistemaRecalqueList(List<SistemaRecalque> sistemaRecalqueList) {
        this.sistemaRecalqueList = sistemaRecalqueList;
    }

    @XmlTransient
    public List<FonteAbastecimentoHidrico> getFonteAbastecimentoHidricoList() {
        return fonteAbastecimentoHidricoList;
    }

    public void setFonteAbastecimentoHidricoList(List<FonteAbastecimentoHidrico> fonteAbastecimentoHidricoList) {
        this.fonteAbastecimentoHidricoList = fonteAbastecimentoHidricoList;
    }

    @XmlTransient
    public List<Poco> getPocoList() {
        return pocoList;
    }

    public void setPocoList(List<Poco> pocoList) {
        this.pocoList = pocoList;
    }

    @XmlTransient
    public List<Cisterna> getCisternaList() {
        return cisternaList;
    }

    public void setCisternaList(List<Cisterna> cisternaList) {
        this.cisternaList = cisternaList;
    }

    public SistemaCaptacao getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(SistemaCaptacao idSistema) {
        this.idSistema = idSistema;
    }

    public TipoRede getIdTipoRede() {
        return idTipoRede;
    }

    public void setIdTipoRede(TipoRede idTipoRede) {
        this.idTipoRede = idTipoRede;
    }

    @XmlTransient
    public List<Valvula> getValvulaList() {
        return valvulaList;
    }

    public void setValvulaList(List<Valvula> valvulaList) {
        this.valvulaList = valvulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRede != null ? idRede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeCaptacao)) {
            return false;
        }
        RedeCaptacao other = (RedeCaptacao) object;
        if ((this.idRede == null && other.idRede != null) || (this.idRede != null && !this.idRede.equals(other.idRede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.RedeCaptacao[ idRede=" + idRede + " ]";
    }
    
}
