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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByProduto", query = "SELECT p FROM Produto p WHERE p.produto = :produto"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByCondicoesClimaticas", query = "SELECT p FROM Produto p WHERE p.condicoesClimaticas = :condicoesClimaticas")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Size(max = 80)
    @Column(name = "produto")
    private String produto;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 200)
    @Column(name = "condicoes_climaticas")
    private String condicoesClimaticas;
    @OneToMany(mappedBy = "idProduto")
    private List<ProdutoComponente> produtoComponenteList;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo_produto")
    @ManyToOne
    private TipoProduto idTipo;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCondicoesClimaticas() {
        return condicoesClimaticas;
    }

    public void setCondicoesClimaticas(String condicoesClimaticas) {
        this.condicoesClimaticas = condicoesClimaticas;
    }

    @XmlTransient
    public List<ProdutoComponente> getProdutoComponenteList() {
        return produtoComponenteList;
    }

    public void setProdutoComponenteList(List<ProdutoComponente> produtoComponenteList) {
        this.produtoComponenteList = produtoComponenteList;
    }

    public TipoProduto getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoProduto idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
