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
@Table(name = "sistema_pneumatico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaPneumatico.findAll", query = "SELECT s FROM SistemaPneumatico s"),
    @NamedQuery(name = "SistemaPneumatico.findByIdSistemaPneumatico", query = "SELECT s FROM SistemaPneumatico s WHERE s.idSistemaPneumatico = :idSistemaPneumatico"),
    @NamedQuery(name = "SistemaPneumatico.findBySistemaPneumatico", query = "SELECT s FROM SistemaPneumatico s WHERE s.sistemaPneumatico = :sistemaPneumatico"),
    @NamedQuery(name = "SistemaPneumatico.findByDescricao", query = "SELECT s FROM SistemaPneumatico s WHERE s.descricao = :descricao")})
public class SistemaPneumatico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistema_pneumatico")
    private Integer idSistemaPneumatico;
    @Size(max = 50)
    @Column(name = "sistema_pneumatico")
    private String sistemaPneumatico;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idSistema")
    private List<Compressor> compressorList;
    @JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
    @ManyToOne
    private Unidade idUnidade;

    public SistemaPneumatico() {
    }

    public SistemaPneumatico(Integer idSistemaPneumatico) {
        this.idSistemaPneumatico = idSistemaPneumatico;
    }

    public Integer getIdSistemaPneumatico() {
        return idSistemaPneumatico;
    }

    public void setIdSistemaPneumatico(Integer idSistemaPneumatico) {
        this.idSistemaPneumatico = idSistemaPneumatico;
    }

    public String getSistemaPneumatico() {
        return sistemaPneumatico;
    }

    public void setSistemaPneumatico(String sistemaPneumatico) {
        this.sistemaPneumatico = sistemaPneumatico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Compressor> getCompressorList() {
        return compressorList;
    }

    public void setCompressorList(List<Compressor> compressorList) {
        this.compressorList = compressorList;
    }

    public Unidade getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Unidade idUnidade) {
        this.idUnidade = idUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistemaPneumatico != null ? idSistemaPneumatico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaPneumatico)) {
            return false;
        }
        SistemaPneumatico other = (SistemaPneumatico) object;
        if ((this.idSistemaPneumatico == null && other.idSistemaPneumatico != null) || (this.idSistemaPneumatico != null && !this.idSistemaPneumatico.equals(other.idSistemaPneumatico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SistemaPneumatico[ idSistemaPneumatico=" + idSistemaPneumatico + " ]";
    }
    
}
