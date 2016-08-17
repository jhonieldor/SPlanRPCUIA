/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "captacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Captacao.findAll", query = "SELECT c FROM Captacao c"),
    @NamedQuery(name = "Captacao.findByIdCaptacao", query = "SELECT c FROM Captacao c WHERE c.idCaptacao = :idCaptacao"),
    @NamedQuery(name = "Captacao.findByNome", query = "SELECT c FROM Captacao c WHERE c.nome = :nome"),
    @NamedQuery(name = "Captacao.findByDescricaoLocalizacao", query = "SELECT c FROM Captacao c WHERE c.descricaoLocalizacao = :descricaoLocalizacao"),
    @NamedQuery(name = "Captacao.findByCapacidade", query = "SELECT c FROM Captacao c WHERE c.capacidade = :capacidade"),
    @NamedQuery(name = "Captacao.findByLatitude", query = "SELECT c FROM Captacao c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Captacao.findByLongitude", query = "SELECT c FROM Captacao c WHERE c.longitude = :longitude")})
public class Captacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_captacao")
    private Integer idCaptacao;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 80)
    @Column(name = "descricao_localizacao")
    private String descricaoLocalizacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capacidade")
    private BigDecimal capacidade;
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @OneToMany(mappedBy = "idCaptacao")
    private List<Nodo> nodoList;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;

    public Captacao() {
    }

    public Captacao(Integer idCaptacao) {
        this.idCaptacao = idCaptacao;
    }

    public Integer getIdCaptacao() {
        return idCaptacao;
    }

    public void setIdCaptacao(Integer idCaptacao) {
        this.idCaptacao = idCaptacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoLocalizacao() {
        return descricaoLocalizacao;
    }

    public void setDescricaoLocalizacao(String descricaoLocalizacao) {
        this.descricaoLocalizacao = descricaoLocalizacao;
    }

    public BigDecimal getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(BigDecimal capacidade) {
        this.capacidade = capacidade;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaptacao != null ? idCaptacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Captacao)) {
            return false;
        }
        Captacao other = (Captacao) object;
        if ((this.idCaptacao == null && other.idCaptacao != null) || (this.idCaptacao != null && !this.idCaptacao.equals(other.idCaptacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Captacao[ idCaptacao=" + idCaptacao + " ]";
    }
    
}
