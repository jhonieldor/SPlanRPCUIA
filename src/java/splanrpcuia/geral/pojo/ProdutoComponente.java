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
@Table(name = "produto_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoComponente.findAll", query = "SELECT p FROM ProdutoComponente p"),
    @NamedQuery(name = "ProdutoComponente.findByIdProdutoComponente", query = "SELECT p FROM ProdutoComponente p WHERE p.idProdutoComponente = :idProdutoComponente"),
    @NamedQuery(name = "ProdutoComponente.findByPercentualVolumeComponente", query = "SELECT p FROM ProdutoComponente p WHERE p.percentualVolumeComponente = :percentualVolumeComponente"),
    @NamedQuery(name = "ProdutoComponente.findByQuantidade", query = "SELECT p FROM ProdutoComponente p WHERE p.quantidade = :quantidade")})
public class ProdutoComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto_componente")
    private Integer idProdutoComponente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentual_volume_componente")
    private BigDecimal percentualVolumeComponente;
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componente idComponente;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne
    private Produto idProduto;

    public ProdutoComponente() {
    }

    public ProdutoComponente(Integer idProdutoComponente) {
        this.idProdutoComponente = idProdutoComponente;
    }

    public Integer getIdProdutoComponente() {
        return idProdutoComponente;
    }

    public void setIdProdutoComponente(Integer idProdutoComponente) {
        this.idProdutoComponente = idProdutoComponente;
    }

    public BigDecimal getPercentualVolumeComponente() {
        return percentualVolumeComponente;
    }

    public void setPercentualVolumeComponente(BigDecimal percentualVolumeComponente) {
        this.percentualVolumeComponente = percentualVolumeComponente;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutoComponente != null ? idProdutoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoComponente)) {
            return false;
        }
        ProdutoComponente other = (ProdutoComponente) object;
        if ((this.idProdutoComponente == null && other.idProdutoComponente != null) || (this.idProdutoComponente != null && !this.idProdutoComponente.equals(other.idProdutoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ProdutoComponente[ idProdutoComponente=" + idProdutoComponente + " ]";
    }
    
}
