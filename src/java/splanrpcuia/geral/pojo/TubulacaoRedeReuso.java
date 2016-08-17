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
@Table(name = "tubulacao_rede_reuso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TubulacaoRedeReuso.findAll", query = "SELECT t FROM TubulacaoRedeReuso t"),
    @NamedQuery(name = "TubulacaoRedeReuso.findByIdTubulacao", query = "SELECT t FROM TubulacaoRedeReuso t WHERE t.idTubulacao = :idTubulacao"),
    @NamedQuery(name = "TubulacaoRedeReuso.findByIdRede", query = "SELECT t FROM TubulacaoRedeReuso t WHERE t.idRede = :idRede"),
    @NamedQuery(name = "TubulacaoRedeReuso.findByDistancia", query = "SELECT t FROM TubulacaoRedeReuso t WHERE t.distancia = :distancia"),
    @NamedQuery(name = "TubulacaoRedeReuso.findByInclinacao", query = "SELECT t FROM TubulacaoRedeReuso t WHERE t.inclinacao = :inclinacao"),
    @NamedQuery(name = "TubulacaoRedeReuso.findByBitola", query = "SELECT t FROM TubulacaoRedeReuso t WHERE t.bitola = :bitola")})
public class TubulacaoRedeReuso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tubulacao")
    private Integer idTubulacao;
    @Column(name = "id_rede")
    private Integer idRede;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "distancia")
    private BigDecimal distancia;
    @Column(name = "inclinacao")
    private BigDecimal inclinacao;
    @Size(max = 20)
    @Column(name = "bitola")
    private String bitola;
    @JoinColumn(name = "destino", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo destino;
    @JoinColumn(name = "origem", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo origem;
    @JoinColumn(name = "id_tipo_tubulacao", referencedColumnName = "id_tipo_tubulacao")
    @ManyToOne
    private TipoTubulacao idTipoTubulacao;

    public TubulacaoRedeReuso() {
    }

    public TubulacaoRedeReuso(Integer idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    public Integer getIdTubulacao() {
        return idTubulacao;
    }

    public void setIdTubulacao(Integer idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    public Integer getIdRede() {
        return idRede;
    }

    public void setIdRede(Integer idRede) {
        this.idRede = idRede;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public BigDecimal getInclinacao() {
        return inclinacao;
    }

    public void setInclinacao(BigDecimal inclinacao) {
        this.inclinacao = inclinacao;
    }

    public String getBitola() {
        return bitola;
    }

    public void setBitola(String bitola) {
        this.bitola = bitola;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public Nodo getOrigem() {
        return origem;
    }

    public void setOrigem(Nodo origem) {
        this.origem = origem;
    }

    public TipoTubulacao getIdTipoTubulacao() {
        return idTipoTubulacao;
    }

    public void setIdTipoTubulacao(TipoTubulacao idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTubulacao != null ? idTubulacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TubulacaoRedeReuso)) {
            return false;
        }
        TubulacaoRedeReuso other = (TubulacaoRedeReuso) object;
        if ((this.idTubulacao == null && other.idTubulacao != null) || (this.idTubulacao != null && !this.idTubulacao.equals(other.idTubulacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TubulacaoRedeReuso[ idTubulacao=" + idTubulacao + " ]";
    }
    
}
