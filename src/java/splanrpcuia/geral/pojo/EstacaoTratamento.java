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
import javax.persistence.Lob;
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
@Table(name = "estacao_tratamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstacaoTratamento.findAll", query = "SELECT e FROM EstacaoTratamento e"),
    @NamedQuery(name = "EstacaoTratamento.findByIdEstacao", query = "SELECT e FROM EstacaoTratamento e WHERE e.idEstacao = :idEstacao"),
    @NamedQuery(name = "EstacaoTratamento.findByEstacao", query = "SELECT e FROM EstacaoTratamento e WHERE e.estacao = :estacao"),
    @NamedQuery(name = "EstacaoTratamento.findByDescricao", query = "SELECT e FROM EstacaoTratamento e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "EstacaoTratamento.findByLatitude", query = "SELECT e FROM EstacaoTratamento e WHERE e.latitude = :latitude"),
    @NamedQuery(name = "EstacaoTratamento.findByLongitude", query = "SELECT e FROM EstacaoTratamento e WHERE e.longitude = :longitude")})
public class EstacaoTratamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estacao")
    private Integer idEstacao;
    @Size(max = 50)
    @Column(name = "estacao")
    private String estacao;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Lob
    @Column(name = "latitude_longitude")
    private Object latitudeLongitude;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @OneToMany(mappedBy = "idEstacao")
    private List<Nodo> nodoList;

    public EstacaoTratamento() {
    }

    public EstacaoTratamento(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public Integer getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Object getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public void setLatitudeLongitude(Object latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstacao != null ? idEstacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacaoTratamento)) {
            return false;
        }
        EstacaoTratamento other = (EstacaoTratamento) object;
        if ((this.idEstacao == null && other.idEstacao != null) || (this.idEstacao != null && !this.idEstacao.equals(other.idEstacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.EstacaoTratamento[ idEstacao=" + idEstacao + " ]";
    }
    
}
