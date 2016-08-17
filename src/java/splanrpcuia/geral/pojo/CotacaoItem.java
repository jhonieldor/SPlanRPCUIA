/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "cotacao_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotacaoItem.findAll", query = "SELECT c FROM CotacaoItem c"),
    @NamedQuery(name = "CotacaoItem.findByIdCotacao", query = "SELECT c FROM CotacaoItem c WHERE c.idCotacao = :idCotacao"),
    @NamedQuery(name = "CotacaoItem.findByDataCotacao", query = "SELECT c FROM CotacaoItem c WHERE c.dataCotacao = :dataCotacao"),
    @NamedQuery(name = "CotacaoItem.findByValorUnitarioFornecedor", query = "SELECT c FROM CotacaoItem c WHERE c.valorUnitarioFornecedor = :valorUnitarioFornecedor"),
    @NamedQuery(name = "CotacaoItem.findByValorUnitarioAtual", query = "SELECT c FROM CotacaoItem c WHERE c.valorUnitarioAtual = :valorUnitarioAtual"),
    @NamedQuery(name = "CotacaoItem.findByValorUnitarioAnterior", query = "SELECT c FROM CotacaoItem c WHERE c.valorUnitarioAnterior = :valorUnitarioAnterior"),
    @NamedQuery(name = "CotacaoItem.findByPercentualAcrescimo", query = "SELECT c FROM CotacaoItem c WHERE c.percentualAcrescimo = :percentualAcrescimo"),
    @NamedQuery(name = "CotacaoItem.findByPercentualDesconto", query = "SELECT c FROM CotacaoItem c WHERE c.percentualDesconto = :percentualDesconto"),
    @NamedQuery(name = "CotacaoItem.findByQtdeMinima", query = "SELECT c FROM CotacaoItem c WHERE c.qtdeMinima = :qtdeMinima"),
    @NamedQuery(name = "CotacaoItem.findByQtdeMaxima", query = "SELECT c FROM CotacaoItem c WHERE c.qtdeMaxima = :qtdeMaxima")})
public class CotacaoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cotacao")
    private Integer idCotacao;
    @Column(name = "data_cotacao")
    @Temporal(TemporalType.DATE)
    private Date dataCotacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario_fornecedor")
    private BigDecimal valorUnitarioFornecedor;
    @Column(name = "valor_unitario_atual")
    private BigDecimal valorUnitarioAtual;
    @Column(name = "valor_unitario_anterior")
    private BigDecimal valorUnitarioAnterior;
    @Column(name = "percentual_acrescimo")
    private BigDecimal percentualAcrescimo;
    @Column(name = "percentual_desconto")
    private BigDecimal percentualDesconto;
    @Column(name = "qtde_minima")
    private BigDecimal qtdeMinima;
    @Column(name = "qtde_maxima")
    private BigDecimal qtdeMaxima;
    @OneToMany(mappedBy = "idCotacao")
    private List<ChecklistComponente> checklistComponenteList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne
    private Item idItem;

    public CotacaoItem() {
    }

    public CotacaoItem(Integer idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Integer getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Integer idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public BigDecimal getValorUnitarioFornecedor() {
        return valorUnitarioFornecedor;
    }

    public void setValorUnitarioFornecedor(BigDecimal valorUnitarioFornecedor) {
        this.valorUnitarioFornecedor = valorUnitarioFornecedor;
    }

    public BigDecimal getValorUnitarioAtual() {
        return valorUnitarioAtual;
    }

    public void setValorUnitarioAtual(BigDecimal valorUnitarioAtual) {
        this.valorUnitarioAtual = valorUnitarioAtual;
    }

    public BigDecimal getValorUnitarioAnterior() {
        return valorUnitarioAnterior;
    }

    public void setValorUnitarioAnterior(BigDecimal valorUnitarioAnterior) {
        this.valorUnitarioAnterior = valorUnitarioAnterior;
    }

    public BigDecimal getPercentualAcrescimo() {
        return percentualAcrescimo;
    }

    public void setPercentualAcrescimo(BigDecimal percentualAcrescimo) {
        this.percentualAcrescimo = percentualAcrescimo;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public BigDecimal getQtdeMinima() {
        return qtdeMinima;
    }

    public void setQtdeMinima(BigDecimal qtdeMinima) {
        this.qtdeMinima = qtdeMinima;
    }

    public BigDecimal getQtdeMaxima() {
        return qtdeMaxima;
    }

    public void setQtdeMaxima(BigDecimal qtdeMaxima) {
        this.qtdeMaxima = qtdeMaxima;
    }

    @XmlTransient
    public List<ChecklistComponente> getChecklistComponenteList() {
        return checklistComponenteList;
    }

    public void setChecklistComponenteList(List<ChecklistComponente> checklistComponenteList) {
        this.checklistComponenteList = checklistComponenteList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        hash += (idCotacao != null ? idCotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotacaoItem)) {
            return false;
        }
        CotacaoItem other = (CotacaoItem) object;
        if ((this.idCotacao == null && other.idCotacao != null) || (this.idCotacao != null && !this.idCotacao.equals(other.idCotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.CotacaoItem[ idCotacao=" + idCotacao + " ]";
    }
    
}
