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
@Table(name = "checklist_maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecklistMaquina.findAll", query = "SELECT c FROM ChecklistMaquina c"),
    @NamedQuery(name = "ChecklistMaquina.findByIdChecklistMaquina", query = "SELECT c FROM ChecklistMaquina c WHERE c.idChecklistMaquina = :idChecklistMaquina"),
    @NamedQuery(name = "ChecklistMaquina.findByNumero", query = "SELECT c FROM ChecklistMaquina c WHERE c.numero = :numero"),
    @NamedQuery(name = "ChecklistMaquina.findByCodigoFornecedor", query = "SELECT c FROM ChecklistMaquina c WHERE c.codigoFornecedor = :codigoFornecedor"),
    @NamedQuery(name = "ChecklistMaquina.findByCodigoEstoque", query = "SELECT c FROM ChecklistMaquina c WHERE c.codigoEstoque = :codigoEstoque"),
    @NamedQuery(name = "ChecklistMaquina.findByQuantidade", query = "SELECT c FROM ChecklistMaquina c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "ChecklistMaquina.findByValorTotal", query = "SELECT c FROM ChecklistMaquina c WHERE c.valorTotal = :valorTotal")})
public class ChecklistMaquina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_checklist_maquina")
    private Integer idChecklistMaquina;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "codigo_fornecedor")
    private Integer codigoFornecedor;
    @Column(name = "codigo_estoque")
    private Integer codigoEstoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @JoinColumn(name = "id_item_maquina", referencedColumnName = "id_item_maquina")
    @ManyToOne
    private ItemMaquina idItemMaquina;
    @JoinColumn(name = "id_manual", referencedColumnName = "id_manual")
    @ManyToOne
    private ManualMaquina idManual;

    public ChecklistMaquina() {
    }

    public ChecklistMaquina(Integer idChecklistMaquina) {
        this.idChecklistMaquina = idChecklistMaquina;
    }

    public Integer getIdChecklistMaquina() {
        return idChecklistMaquina;
    }

    public void setIdChecklistMaquina(Integer idChecklistMaquina) {
        this.idChecklistMaquina = idChecklistMaquina;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public Integer getCodigoEstoque() {
        return codigoEstoque;
    }

    public void setCodigoEstoque(Integer codigoEstoque) {
        this.codigoEstoque = codigoEstoque;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ItemMaquina getIdItemMaquina() {
        return idItemMaquina;
    }

    public void setIdItemMaquina(ItemMaquina idItemMaquina) {
        this.idItemMaquina = idItemMaquina;
    }

    public ManualMaquina getIdManual() {
        return idManual;
    }

    public void setIdManual(ManualMaquina idManual) {
        this.idManual = idManual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChecklistMaquina != null ? idChecklistMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistMaquina)) {
            return false;
        }
        ChecklistMaquina other = (ChecklistMaquina) object;
        if ((this.idChecklistMaquina == null && other.idChecklistMaquina != null) || (this.idChecklistMaquina != null && !this.idChecklistMaquina.equals(other.idChecklistMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ChecklistMaquina[ idChecklistMaquina=" + idChecklistMaquina + " ]";
    }
    
}
