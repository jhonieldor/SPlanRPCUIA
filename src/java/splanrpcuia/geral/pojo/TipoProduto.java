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
import javax.persistence.ManyToMany;
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
@Table(name = "tipo_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduto.findAll", query = "SELECT t FROM TipoProduto t"),
    @NamedQuery(name = "TipoProduto.findByIdTipoProduto", query = "SELECT t FROM TipoProduto t WHERE t.idTipoProduto = :idTipoProduto"),
    @NamedQuery(name = "TipoProduto.findByTipoProduto", query = "SELECT t FROM TipoProduto t WHERE t.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "TipoProduto.findByDescricao", query = "SELECT t FROM TipoProduto t WHERE t.descricao = :descricao")})
public class TipoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_produto")
    private Integer idTipoProduto;
    @Size(max = 80)
    @Column(name = "tipo_produto")
    private String tipoProduto;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "tipoProdutoList")
    private List<Empresa> empresaList;
    @OneToMany(mappedBy = "idTipo")
    private List<Produto> produtoList;

    public TipoProduto() {
    }

    public TipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public Integer getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProduto != null ? idTipoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.idTipoProduto == null && other.idTipoProduto != null) || (this.idTipoProduto != null && !this.idTipoProduto.equals(other.idTipoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoProduto[ idTipoProduto=" + idTipoProduto + " ]";
    }
    
}
