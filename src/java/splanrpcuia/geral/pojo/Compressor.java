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
@Table(name = "compressor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compressor.findAll", query = "SELECT c FROM Compressor c"),
    @NamedQuery(name = "Compressor.findByIdCompressor", query = "SELECT c FROM Compressor c WHERE c.idCompressor = :idCompressor"),
    @NamedQuery(name = "Compressor.findByNomeCompressor", query = "SELECT c FROM Compressor c WHERE c.nomeCompressor = :nomeCompressor"),
    @NamedQuery(name = "Compressor.findByDescricao", query = "SELECT c FROM Compressor c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Compressor.findByIdItem", query = "SELECT c FROM Compressor c WHERE c.idItem = :idItem")})
public class Compressor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compressor")
    private Integer idCompressor;
    @Size(max = 50)
    @Column(name = "nome_compressor")
    private String nomeCompressor;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "id_item")
    private Integer idItem;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema_pneumatico")
    @ManyToOne
    private SistemaPneumatico idSistema;
    @OneToMany(mappedBy = "idCompressor")
    private List<RedePneumatica> redePneumaticaList;

    public Compressor() {
    }

    public Compressor(Integer idCompressor) {
        this.idCompressor = idCompressor;
    }

    public Integer getIdCompressor() {
        return idCompressor;
    }

    public void setIdCompressor(Integer idCompressor) {
        this.idCompressor = idCompressor;
    }

    public String getNomeCompressor() {
        return nomeCompressor;
    }

    public void setNomeCompressor(String nomeCompressor) {
        this.nomeCompressor = nomeCompressor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public SistemaPneumatico getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(SistemaPneumatico idSistema) {
        this.idSistema = idSistema;
    }

    @XmlTransient
    public List<RedePneumatica> getRedePneumaticaList() {
        return redePneumaticaList;
    }

    public void setRedePneumaticaList(List<RedePneumatica> redePneumaticaList) {
        this.redePneumaticaList = redePneumaticaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompressor != null ? idCompressor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compressor)) {
            return false;
        }
        Compressor other = (Compressor) object;
        if ((this.idCompressor == null && other.idCompressor != null) || (this.idCompressor != null && !this.idCompressor.equals(other.idCompressor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Compressor[ idCompressor=" + idCompressor + " ]";
    }
    
}
