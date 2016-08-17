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
@Table(name = "cisterna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cisterna.findAll", query = "SELECT c FROM Cisterna c"),
    @NamedQuery(name = "Cisterna.findByIdCisterna", query = "SELECT c FROM Cisterna c WHERE c.idCisterna = :idCisterna"),
    @NamedQuery(name = "Cisterna.findByCisterna", query = "SELECT c FROM Cisterna c WHERE c.cisterna = :cisterna"),
    @NamedQuery(name = "Cisterna.findByDescricao", query = "SELECT c FROM Cisterna c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Cisterna.findByLatitude", query = "SELECT c FROM Cisterna c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Cisterna.findByLongitude", query = "SELECT c FROM Cisterna c WHERE c.longitude = :longitude")})
public class Cisterna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cisterna")
    private Integer idCisterna;
    @Size(max = 50)
    @Column(name = "cisterna")
    private String cisterna;
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
    @OneToMany(mappedBy = "idCisterna")
    private List<Nodo> nodoList;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;

    public Cisterna() {
    }

    public Cisterna(Integer idCisterna) {
        this.idCisterna = idCisterna;
    }

    public Integer getIdCisterna() {
        return idCisterna;
    }

    public void setIdCisterna(Integer idCisterna) {
        this.idCisterna = idCisterna;
    }

    public String getCisterna() {
        return cisterna;
    }

    public void setCisterna(String cisterna) {
        this.cisterna = cisterna;
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

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCisterna != null ? idCisterna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cisterna)) {
            return false;
        }
        Cisterna other = (Cisterna) object;
        if ((this.idCisterna == null && other.idCisterna != null) || (this.idCisterna != null && !this.idCisterna.equals(other.idCisterna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Cisterna[ idCisterna=" + idCisterna + " ]";
    }
    
}
