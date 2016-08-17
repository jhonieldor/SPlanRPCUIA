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
@Table(name = "coletor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coletor.findAll", query = "SELECT c FROM Coletor c"),
    @NamedQuery(name = "Coletor.findByIdColetor", query = "SELECT c FROM Coletor c WHERE c.idColetor = :idColetor"),
    @NamedQuery(name = "Coletor.findByNomeColetor", query = "SELECT c FROM Coletor c WHERE c.nomeColetor = :nomeColetor"),
    @NamedQuery(name = "Coletor.findByDescricao", query = "SELECT c FROM Coletor c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Coletor.findByLatitude", query = "SELECT c FROM Coletor c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Coletor.findByLongitude", query = "SELECT c FROM Coletor c WHERE c.longitude = :longitude")})
public class Coletor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_coletor")
    private Integer idColetor;
    @Size(max = 20)
    @Column(name = "nome_coletor")
    private String nomeColetor;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Lob
    @Column(name = "latitude_longitude")
    private Object latitudeLongitude;
    @OneToMany(mappedBy = "idColetor")
    private List<Nodo> nodoList;

    public Coletor() {
    }

    public Coletor(Integer idColetor) {
        this.idColetor = idColetor;
    }

    public Integer getIdColetor() {
        return idColetor;
    }

    public void setIdColetor(Integer idColetor) {
        this.idColetor = idColetor;
    }

    public String getNomeColetor() {
        return nomeColetor;
    }

    public void setNomeColetor(String nomeColetor) {
        this.nomeColetor = nomeColetor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Object getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public void setLatitudeLongitude(Object latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
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
        hash += (idColetor != null ? idColetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coletor)) {
            return false;
        }
        Coletor other = (Coletor) object;
        if ((this.idColetor == null && other.idColetor != null) || (this.idColetor != null && !this.idColetor.equals(other.idColetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Coletor[ idColetor=" + idColetor + " ]";
    }
    
}
