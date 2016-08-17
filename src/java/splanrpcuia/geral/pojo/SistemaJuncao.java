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
import javax.persistence.Lob;
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
@Table(name = "sistema_juncao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaJuncao.findAll", query = "SELECT s FROM SistemaJuncao s"),
    @NamedQuery(name = "SistemaJuncao.findByIdSistemaJuncao", query = "SELECT s FROM SistemaJuncao s WHERE s.idSistemaJuncao = :idSistemaJuncao"),
    @NamedQuery(name = "SistemaJuncao.findByNome", query = "SELECT s FROM SistemaJuncao s WHERE s.nome = :nome"),
    @NamedQuery(name = "SistemaJuncao.findByDescricao", query = "SELECT s FROM SistemaJuncao s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "SistemaJuncao.findByLatitude", query = "SELECT s FROM SistemaJuncao s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "SistemaJuncao.findByLongitude", query = "SELECT s FROM SistemaJuncao s WHERE s.longitude = :longitude")})
public class SistemaJuncao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistema_juncao")
    private Integer idSistemaJuncao;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
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
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_tipo_juncao", referencedColumnName = "id_tipo_juncao")
    @ManyToOne
    private TipoJuncao idTipoJuncao;
    @OneToMany(mappedBy = "idSistemaJuncao")
    private List<Nodo> nodoList;

    public SistemaJuncao() {
    }

    public SistemaJuncao(Integer idSistemaJuncao) {
        this.idSistemaJuncao = idSistemaJuncao;
    }

    public Integer getIdSistemaJuncao() {
        return idSistemaJuncao;
    }

    public void setIdSistemaJuncao(Integer idSistemaJuncao) {
        this.idSistemaJuncao = idSistemaJuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public TipoJuncao getIdTipoJuncao() {
        return idTipoJuncao;
    }

    public void setIdTipoJuncao(TipoJuncao idTipoJuncao) {
        this.idTipoJuncao = idTipoJuncao;
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
        hash += (idSistemaJuncao != null ? idSistemaJuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaJuncao)) {
            return false;
        }
        SistemaJuncao other = (SistemaJuncao) object;
        if ((this.idSistemaJuncao == null && other.idSistemaJuncao != null) || (this.idSistemaJuncao != null && !this.idSistemaJuncao.equals(other.idSistemaJuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SistemaJuncao[ idSistemaJuncao=" + idSistemaJuncao + " ]";
    }
    
}
