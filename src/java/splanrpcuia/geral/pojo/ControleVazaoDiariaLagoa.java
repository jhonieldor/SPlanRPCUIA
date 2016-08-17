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
@Table(name = "controle_vazao_diaria_lagoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControleVazaoDiariaLagoa.findAll", query = "SELECT c FROM ControleVazaoDiariaLagoa c"),
    @NamedQuery(name = "ControleVazaoDiariaLagoa.findByIdControleVazao", query = "SELECT c FROM ControleVazaoDiariaLagoa c WHERE c.idControleVazao = :idControleVazao"),
    @NamedQuery(name = "ControleVazaoDiariaLagoa.findByDataControle", query = "SELECT c FROM ControleVazaoDiariaLagoa c WHERE c.dataControle = :dataControle"),
    @NamedQuery(name = "ControleVazaoDiariaLagoa.findByVazaoMediaEntrada", query = "SELECT c FROM ControleVazaoDiariaLagoa c WHERE c.vazaoMediaEntrada = :vazaoMediaEntrada")})
public class ControleVazaoDiariaLagoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle_vazao")
    private Integer idControleVazao;
    @Column(name = "data_controle")
    @Temporal(TemporalType.DATE)
    private Date dataControle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vazao_media_entrada")
    private BigDecimal vazaoMediaEntrada;
    @JoinColumn(name = "id_lagoa", referencedColumnName = "id_lagoa")
    @ManyToOne
    private Lagoa idLagoa;

    public ControleVazaoDiariaLagoa() {
    }

    public ControleVazaoDiariaLagoa(Integer idControleVazao) {
        this.idControleVazao = idControleVazao;
    }

    public Integer getIdControleVazao() {
        return idControleVazao;
    }

    public void setIdControleVazao(Integer idControleVazao) {
        this.idControleVazao = idControleVazao;
    }

    public Date getDataControle() {
        return dataControle;
    }

    public void setDataControle(Date dataControle) {
        this.dataControle = dataControle;
    }

    public BigDecimal getVazaoMediaEntrada() {
        return vazaoMediaEntrada;
    }

    public void setVazaoMediaEntrada(BigDecimal vazaoMediaEntrada) {
        this.vazaoMediaEntrada = vazaoMediaEntrada;
    }

    public Lagoa getIdLagoa() {
        return idLagoa;
    }

    public void setIdLagoa(Lagoa idLagoa) {
        this.idLagoa = idLagoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControleVazao != null ? idControleVazao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControleVazaoDiariaLagoa)) {
            return false;
        }
        ControleVazaoDiariaLagoa other = (ControleVazaoDiariaLagoa) object;
        if ((this.idControleVazao == null && other.idControleVazao != null) || (this.idControleVazao != null && !this.idControleVazao.equals(other.idControleVazao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ControleVazaoDiariaLagoa[ idControleVazao=" + idControleVazao + " ]";
    }
    
}
