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
@Table(name = "lagoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lagoa.findAll", query = "SELECT l FROM Lagoa l"),
    @NamedQuery(name = "Lagoa.findByIdLagoa", query = "SELECT l FROM Lagoa l WHERE l.idLagoa = :idLagoa"),
    @NamedQuery(name = "Lagoa.findByLagoa", query = "SELECT l FROM Lagoa l WHERE l.lagoa = :lagoa"),
    @NamedQuery(name = "Lagoa.findByDescricao", query = "SELECT l FROM Lagoa l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "Lagoa.findByLatitude", query = "SELECT l FROM Lagoa l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "Lagoa.findByLongitude", query = "SELECT l FROM Lagoa l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "Lagoa.findByArea", query = "SELECT l FROM Lagoa l WHERE l.area = :area"),
    @NamedQuery(name = "Lagoa.findByVolume", query = "SELECT l FROM Lagoa l WHERE l.volume = :volume"),
    @NamedQuery(name = "Lagoa.findByProfundidade", query = "SELECT l FROM Lagoa l WHERE l.profundidade = :profundidade"),
    @NamedQuery(name = "Lagoa.findByComprimento", query = "SELECT l FROM Lagoa l WHERE l.comprimento = :comprimento"),
    @NamedQuery(name = "Lagoa.findByLargura", query = "SELECT l FROM Lagoa l WHERE l.largura = :largura")})
public class Lagoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lagoa")
    private Integer idLagoa;
    @Size(max = 50)
    @Column(name = "lagoa")
    private String lagoa;
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
    @Column(name = "area")
    private BigDecimal area;
    @Column(name = "volume")
    private BigDecimal volume;
    @Column(name = "profundidade")
    private BigDecimal profundidade;
    @Column(name = "comprimento")
    private BigDecimal comprimento;
    @Column(name = "largura")
    private BigDecimal largura;
    @OneToMany(mappedBy = "idLagoa")
    private List<Nodo> nodoList;
    @OneToMany(mappedBy = "idLagoa")
    private List<ControleVazaoDiariaLagoa> controleVazaoDiariaLagoaList;
    @JoinColumn(name = "id_tipo_lagoa", referencedColumnName = "id_tipo_lagoa")
    @ManyToOne
    private TipoLagoa idTipoLagoa;

    public Lagoa() {
    }

    public Lagoa(Integer idLagoa) {
        this.idLagoa = idLagoa;
    }

    public Integer getIdLagoa() {
        return idLagoa;
    }

    public void setIdLagoa(Integer idLagoa) {
        this.idLagoa = idLagoa;
    }

    public String getLagoa() {
        return lagoa;
    }

    public void setLagoa(String lagoa) {
        this.lagoa = lagoa;
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

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(BigDecimal profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public void setComprimento(BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    @XmlTransient
    public List<ControleVazaoDiariaLagoa> getControleVazaoDiariaLagoaList() {
        return controleVazaoDiariaLagoaList;
    }

    public void setControleVazaoDiariaLagoaList(List<ControleVazaoDiariaLagoa> controleVazaoDiariaLagoaList) {
        this.controleVazaoDiariaLagoaList = controleVazaoDiariaLagoaList;
    }

    public TipoLagoa getIdTipoLagoa() {
        return idTipoLagoa;
    }

    public void setIdTipoLagoa(TipoLagoa idTipoLagoa) {
        this.idTipoLagoa = idTipoLagoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLagoa != null ? idLagoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lagoa)) {
            return false;
        }
        Lagoa other = (Lagoa) object;
        if ((this.idLagoa == null && other.idLagoa != null) || (this.idLagoa != null && !this.idLagoa.equals(other.idLagoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Lagoa[ idLagoa=" + idLagoa + " ]";
    }
    
}
