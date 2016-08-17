/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "dim_retangular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimRetangular.findAll", query = "SELECT d FROM DimRetangular d"),
    @NamedQuery(name = "DimRetangular.findByIdDim", query = "SELECT d FROM DimRetangular d WHERE d.idDim = :idDim"),
    @NamedQuery(name = "DimRetangular.findByLargura", query = "SELECT d FROM DimRetangular d WHERE d.largura = :largura"),
    @NamedQuery(name = "DimRetangular.findByComprimento", query = "SELECT d FROM DimRetangular d WHERE d.comprimento = :comprimento"),
    @NamedQuery(name = "DimRetangular.findByAltura", query = "SELECT d FROM DimRetangular d WHERE d.altura = :altura")})
public class DimRetangular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dim")
    private Integer idDim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "largura")
    private BigDecimal largura;
    @Column(name = "comprimento")
    private BigDecimal comprimento;
    @Column(name = "altura")
    private BigDecimal altura;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componente idComponente;

    public DimRetangular() {
    }

    public DimRetangular(Integer idDim) {
        this.idDim = idDim;
    }

    public Integer getIdDim() {
        return idDim;
    }

    public void setIdDim(Integer idDim) {
        this.idDim = idDim;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public void setComprimento(BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDim != null ? idDim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimRetangular)) {
            return false;
        }
        DimRetangular other = (DimRetangular) object;
        if ((this.idDim == null && other.idDim != null) || (this.idDim != null && !this.idDim.equals(other.idDim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.DimRetangular[ idDim=" + idDim + " ]";
    }
    
}
