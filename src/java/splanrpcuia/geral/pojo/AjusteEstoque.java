/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "ajuste_estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AjusteEstoque.findAll", query = "SELECT a FROM AjusteEstoque a"),
    @NamedQuery(name = "AjusteEstoque.findByIdAjusteEstoque", query = "SELECT a FROM AjusteEstoque a WHERE a.idAjusteEstoque = :idAjusteEstoque"),
    @NamedQuery(name = "AjusteEstoque.findByDataAjuste", query = "SELECT a FROM AjusteEstoque a WHERE a.dataAjuste = :dataAjuste"),
    @NamedQuery(name = "AjusteEstoque.findBySaldoAnterior", query = "SELECT a FROM AjusteEstoque a WHERE a.saldoAnterior = :saldoAnterior"),
    @NamedQuery(name = "AjusteEstoque.findBySaldoAtual", query = "SELECT a FROM AjusteEstoque a WHERE a.saldoAtual = :saldoAtual"),
    @NamedQuery(name = "AjusteEstoque.findByQtdeEmprestada", query = "SELECT a FROM AjusteEstoque a WHERE a.qtdeEmprestada = :qtdeEmprestada"),
    @NamedQuery(name = "AjusteEstoque.findByQtdeDevolucaoFornecedor", query = "SELECT a FROM AjusteEstoque a WHERE a.qtdeDevolucaoFornecedor = :qtdeDevolucaoFornecedor"),
    @NamedQuery(name = "AjusteEstoque.findByQtdeComercializada", query = "SELECT a FROM AjusteEstoque a WHERE a.qtdeComercializada = :qtdeComercializada")})
public class AjusteEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ajuste_estoque")
    private Integer idAjusteEstoque;
    @Column(name = "data_ajuste")
    @Temporal(TemporalType.DATE)
    private Date dataAjuste;
    @Column(name = "saldo_anterior")
    private Integer saldoAnterior;
    @Column(name = "saldo_atual")
    private Integer saldoAtual;
    @Column(name = "qtde_emprestada")
    private Integer qtdeEmprestada;
    @Column(name = "qtde_devolucao_fornecedor")
    private Integer qtdeDevolucaoFornecedor;
    @Column(name = "qtde_comercializada")
    private Integer qtdeComercializada;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne
    private Item idItem;

    public AjusteEstoque() {
    }

    public AjusteEstoque(Integer idAjusteEstoque) {
        this.idAjusteEstoque = idAjusteEstoque;
    }

    public Integer getIdAjusteEstoque() {
        return idAjusteEstoque;
    }

    public void setIdAjusteEstoque(Integer idAjusteEstoque) {
        this.idAjusteEstoque = idAjusteEstoque;
    }

    public Date getDataAjuste() {
        return dataAjuste;
    }

    public void setDataAjuste(Date dataAjuste) {
        this.dataAjuste = dataAjuste;
    }

    public Integer getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Integer saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Integer getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(Integer saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public Integer getQtdeEmprestada() {
        return qtdeEmprestada;
    }

    public void setQtdeEmprestada(Integer qtdeEmprestada) {
        this.qtdeEmprestada = qtdeEmprestada;
    }

    public Integer getQtdeDevolucaoFornecedor() {
        return qtdeDevolucaoFornecedor;
    }

    public void setQtdeDevolucaoFornecedor(Integer qtdeDevolucaoFornecedor) {
        this.qtdeDevolucaoFornecedor = qtdeDevolucaoFornecedor;
    }

    public Integer getQtdeComercializada() {
        return qtdeComercializada;
    }

    public void setQtdeComercializada(Integer qtdeComercializada) {
        this.qtdeComercializada = qtdeComercializada;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAjusteEstoque != null ? idAjusteEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AjusteEstoque)) {
            return false;
        }
        AjusteEstoque other = (AjusteEstoque) object;
        if ((this.idAjusteEstoque == null && other.idAjusteEstoque != null) || (this.idAjusteEstoque != null && !this.idAjusteEstoque.equals(other.idAjusteEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.AjusteEstoque[ idAjusteEstoque=" + idAjusteEstoque + " ]";
    }
    
}
