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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "checklist_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecklistComponente.findAll", query = "SELECT c FROM ChecklistComponente c"),
    @NamedQuery(name = "ChecklistComponente.findByIdChecklistComponente", query = "SELECT c FROM ChecklistComponente c WHERE c.idChecklistComponente = :idChecklistComponente"),
    @NamedQuery(name = "ChecklistComponente.findByDescricao", query = "SELECT c FROM ChecklistComponente c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "ChecklistComponente.findByValorUnitario", query = "SELECT c FROM ChecklistComponente c WHERE c.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "ChecklistComponente.findByQtde", query = "SELECT c FROM ChecklistComponente c WHERE c.qtde = :qtde")})
public class ChecklistComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_checklist_componente")
    private Integer idChecklistComponente;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Column(name = "qtde")
    private BigDecimal qtde;
    @JoinColumn(name = "id_checklist", referencedColumnName = "id_checklist")
    @ManyToOne
    private Checklist idChecklist;
    @JoinColumn(name = "id_cotacao", referencedColumnName = "id_cotacao")
    @ManyToOne
    private CotacaoItem idCotacao;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne
    private Item idItem;

    public ChecklistComponente() {
    }

    public ChecklistComponente(Integer idChecklistComponente) {
        this.idChecklistComponente = idChecklistComponente;
    }

    public Integer getIdChecklistComponente() {
        return idChecklistComponente;
    }

    public void setIdChecklistComponente(Integer idChecklistComponente) {
        this.idChecklistComponente = idChecklistComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQtde() {
        return qtde;
    }

    public void setQtde(BigDecimal qtde) {
        this.qtde = qtde;
    }

    public Checklist getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(Checklist idChecklist) {
        this.idChecklist = idChecklist;
    }

    public CotacaoItem getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(CotacaoItem idCotacao) {
        this.idCotacao = idCotacao;
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
        hash += (idChecklistComponente != null ? idChecklistComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistComponente)) {
            return false;
        }
        ChecklistComponente other = (ChecklistComponente) object;
        if ((this.idChecklistComponente == null && other.idChecklistComponente != null) || (this.idChecklistComponente != null && !this.idChecklistComponente.equals(other.idChecklistComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ChecklistComponente[ idChecklistComponente=" + idChecklistComponente + " ]";
    }
    
}
