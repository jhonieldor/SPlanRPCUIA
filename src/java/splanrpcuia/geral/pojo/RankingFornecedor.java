/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "ranking_fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RankingFornecedor.findAll", query = "SELECT r FROM RankingFornecedor r"),
    @NamedQuery(name = "RankingFornecedor.findByIdFornecedor", query = "SELECT r FROM RankingFornecedor r WHERE r.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "RankingFornecedor.findByRatingAtual", query = "SELECT r FROM RankingFornecedor r WHERE r.ratingAtual = :ratingAtual"),
    @NamedQuery(name = "RankingFornecedor.findByRatingAnterior", query = "SELECT r FROM RankingFornecedor r WHERE r.ratingAnterior = :ratingAnterior"),
    @NamedQuery(name = "RankingFornecedor.findByDataRating", query = "SELECT r FROM RankingFornecedor r WHERE r.dataRating = :dataRating")})
public class RankingFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating_atual")
    private BigDecimal ratingAtual;
    @Column(name = "rating_anterior")
    private BigDecimal ratingAnterior;
    @Column(name = "data_rating")
    @Temporal(TemporalType.DATE)
    private Date dataRating;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empresa empresa;

    public RankingFornecedor() {
    }

    public RankingFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public BigDecimal getRatingAtual() {
        return ratingAtual;
    }

    public void setRatingAtual(BigDecimal ratingAtual) {
        this.ratingAtual = ratingAtual;
    }

    public BigDecimal getRatingAnterior() {
        return ratingAnterior;
    }

    public void setRatingAnterior(BigDecimal ratingAnterior) {
        this.ratingAnterior = ratingAnterior;
    }

    public Date getDataRating() {
        return dataRating;
    }

    public void setDataRating(Date dataRating) {
        this.dataRating = dataRating;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RankingFornecedor)) {
            return false;
        }
        RankingFornecedor other = (RankingFornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.RankingFornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
