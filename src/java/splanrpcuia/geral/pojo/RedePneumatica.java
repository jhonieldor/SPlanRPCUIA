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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "rede_pneumatica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedePneumatica.findAll", query = "SELECT r FROM RedePneumatica r"),
    @NamedQuery(name = "RedePneumatica.findByIdRedePneumatica", query = "SELECT r FROM RedePneumatica r WHERE r.idRedePneumatica = :idRedePneumatica"),
    @NamedQuery(name = "RedePneumatica.findByRedePneumatica", query = "SELECT r FROM RedePneumatica r WHERE r.redePneumatica = :redePneumatica")})
public class RedePneumatica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rede_pneumatica")
    private Integer idRedePneumatica;
    @Size(max = 20)
    @Column(name = "rede_pneumatica")
    private String redePneumatica;
    @JoinTable(name = "rede_pneumatica_setor", joinColumns = {
        @JoinColumn(name = "id_rede_pneumatica", referencedColumnName = "id_rede_pneumatica")}, inverseJoinColumns = {
        @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")})
    @ManyToMany
    private List<Setor> setorList;
    @JoinColumn(name = "id_compressor", referencedColumnName = "id_compressor")
    @ManyToOne
    private Compressor idCompressor;
    @OneToMany(mappedBy = "idRede")
    private List<PontoPneumatico> pontoPneumaticoList;
    @OneToMany(mappedBy = "idRede")
    private List<TubulacaoPneumatica> tubulacaoPneumaticaList;

    public RedePneumatica() {
    }

    public RedePneumatica(Integer idRedePneumatica) {
        this.idRedePneumatica = idRedePneumatica;
    }

    public Integer getIdRedePneumatica() {
        return idRedePneumatica;
    }

    public void setIdRedePneumatica(Integer idRedePneumatica) {
        this.idRedePneumatica = idRedePneumatica;
    }

    public String getRedePneumatica() {
        return redePneumatica;
    }

    public void setRedePneumatica(String redePneumatica) {
        this.redePneumatica = redePneumatica;
    }

    @XmlTransient
    public List<Setor> getSetorList() {
        return setorList;
    }

    public void setSetorList(List<Setor> setorList) {
        this.setorList = setorList;
    }

    public Compressor getIdCompressor() {
        return idCompressor;
    }

    public void setIdCompressor(Compressor idCompressor) {
        this.idCompressor = idCompressor;
    }

    @XmlTransient
    public List<PontoPneumatico> getPontoPneumaticoList() {
        return pontoPneumaticoList;
    }

    public void setPontoPneumaticoList(List<PontoPneumatico> pontoPneumaticoList) {
        this.pontoPneumaticoList = pontoPneumaticoList;
    }

    @XmlTransient
    public List<TubulacaoPneumatica> getTubulacaoPneumaticaList() {
        return tubulacaoPneumaticaList;
    }

    public void setTubulacaoPneumaticaList(List<TubulacaoPneumatica> tubulacaoPneumaticaList) {
        this.tubulacaoPneumaticaList = tubulacaoPneumaticaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedePneumatica != null ? idRedePneumatica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedePneumatica)) {
            return false;
        }
        RedePneumatica other = (RedePneumatica) object;
        if ((this.idRedePneumatica == null && other.idRedePneumatica != null) || (this.idRedePneumatica != null && !this.idRedePneumatica.equals(other.idRedePneumatica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.RedePneumatica[ idRedePneumatica=" + idRedePneumatica + " ]";
    }
    
}
