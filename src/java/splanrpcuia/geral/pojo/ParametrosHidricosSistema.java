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
@Table(name = "parametros_hidricos_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametrosHidricosSistema.findAll", query = "SELECT p FROM ParametrosHidricosSistema p"),
    @NamedQuery(name = "ParametrosHidricosSistema.findByIdParametrosHidricos", query = "SELECT p FROM ParametrosHidricosSistema p WHERE p.idParametrosHidricos = :idParametrosHidricos"),
    @NamedQuery(name = "ParametrosHidricosSistema.findByVolumeTotalAguaDisponivel", query = "SELECT p FROM ParametrosHidricosSistema p WHERE p.volumeTotalAguaDisponivel = :volumeTotalAguaDisponivel"),
    @NamedQuery(name = "ParametrosHidricosSistema.findByVazaoEntrada", query = "SELECT p FROM ParametrosHidricosSistema p WHERE p.vazaoEntrada = :vazaoEntrada"),
    @NamedQuery(name = "ParametrosHidricosSistema.findByVazaoSaida", query = "SELECT p FROM ParametrosHidricosSistema p WHERE p.vazaoSaida = :vazaoSaida")})
public class ParametrosHidricosSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametros_hidricos")
    private Integer idParametrosHidricos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume_total_agua_disponivel")
    private BigDecimal volumeTotalAguaDisponivel;
    @Column(name = "vazao_entrada")
    private BigDecimal vazaoEntrada;
    @Column(name = "vazao_saida")
    private BigDecimal vazaoSaida;
    @JoinColumn(name = "id_variacao_sistema", referencedColumnName = "id_variacao")
    @ManyToOne
    private VariacaoSimuladaSistema idVariacaoSistema;

    public ParametrosHidricosSistema() {
    }

    public ParametrosHidricosSistema(Integer idParametrosHidricos) {
        this.idParametrosHidricos = idParametrosHidricos;
    }

    public Integer getIdParametrosHidricos() {
        return idParametrosHidricos;
    }

    public void setIdParametrosHidricos(Integer idParametrosHidricos) {
        this.idParametrosHidricos = idParametrosHidricos;
    }

    public BigDecimal getVolumeTotalAguaDisponivel() {
        return volumeTotalAguaDisponivel;
    }

    public void setVolumeTotalAguaDisponivel(BigDecimal volumeTotalAguaDisponivel) {
        this.volumeTotalAguaDisponivel = volumeTotalAguaDisponivel;
    }

    public BigDecimal getVazaoEntrada() {
        return vazaoEntrada;
    }

    public void setVazaoEntrada(BigDecimal vazaoEntrada) {
        this.vazaoEntrada = vazaoEntrada;
    }

    public BigDecimal getVazaoSaida() {
        return vazaoSaida;
    }

    public void setVazaoSaida(BigDecimal vazaoSaida) {
        this.vazaoSaida = vazaoSaida;
    }

    public VariacaoSimuladaSistema getIdVariacaoSistema() {
        return idVariacaoSistema;
    }

    public void setIdVariacaoSistema(VariacaoSimuladaSistema idVariacaoSistema) {
        this.idVariacaoSistema = idVariacaoSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametrosHidricos != null ? idParametrosHidricos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosHidricosSistema)) {
            return false;
        }
        ParametrosHidricosSistema other = (ParametrosHidricosSistema) object;
        if ((this.idParametrosHidricos == null && other.idParametrosHidricos != null) || (this.idParametrosHidricos != null && !this.idParametrosHidricos.equals(other.idParametrosHidricos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ParametrosHidricosSistema[ idParametrosHidricos=" + idParametrosHidricos + " ]";
    }
    
}
