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
@Table(name = "parametros_climaticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametrosClimaticos.findAll", query = "SELECT p FROM ParametrosClimaticos p"),
    @NamedQuery(name = "ParametrosClimaticos.findByIdParametros", query = "SELECT p FROM ParametrosClimaticos p WHERE p.idParametros = :idParametros"),
    @NamedQuery(name = "ParametrosClimaticos.findByTemperaturaGrausCelsius", query = "SELECT p FROM ParametrosClimaticos p WHERE p.temperaturaGrausCelsius = :temperaturaGrausCelsius"),
    @NamedQuery(name = "ParametrosClimaticos.findByUmidadeAr", query = "SELECT p FROM ParametrosClimaticos p WHERE p.umidadeAr = :umidadeAr"),
    @NamedQuery(name = "ParametrosClimaticos.findByVelocidadeVento", query = "SELECT p FROM ParametrosClimaticos p WHERE p.velocidadeVento = :velocidadeVento"),
    @NamedQuery(name = "ParametrosClimaticos.findByInsolacao", query = "SELECT p FROM ParametrosClimaticos p WHERE p.insolacao = :insolacao")})
public class ParametrosClimaticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametros")
    private Integer idParametros;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura_graus_celsius")
    private BigDecimal temperaturaGrausCelsius;
    @Column(name = "umidade_ar")
    private BigDecimal umidadeAr;
    @Column(name = "velocidade_vento")
    private BigDecimal velocidadeVento;
    @Column(name = "insolacao")
    private BigDecimal insolacao;
    @JoinColumn(name = "id_variacao", referencedColumnName = "id_variacao")
    @ManyToOne
    private VariacaoSimuladaSistema idVariacao;

    public ParametrosClimaticos() {
    }

    public ParametrosClimaticos(Integer idParametros) {
        this.idParametros = idParametros;
    }

    public Integer getIdParametros() {
        return idParametros;
    }

    public void setIdParametros(Integer idParametros) {
        this.idParametros = idParametros;
    }

    public BigDecimal getTemperaturaGrausCelsius() {
        return temperaturaGrausCelsius;
    }

    public void setTemperaturaGrausCelsius(BigDecimal temperaturaGrausCelsius) {
        this.temperaturaGrausCelsius = temperaturaGrausCelsius;
    }

    public BigDecimal getUmidadeAr() {
        return umidadeAr;
    }

    public void setUmidadeAr(BigDecimal umidadeAr) {
        this.umidadeAr = umidadeAr;
    }

    public BigDecimal getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(BigDecimal velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public BigDecimal getInsolacao() {
        return insolacao;
    }

    public void setInsolacao(BigDecimal insolacao) {
        this.insolacao = insolacao;
    }

    public VariacaoSimuladaSistema getIdVariacao() {
        return idVariacao;
    }

    public void setIdVariacao(VariacaoSimuladaSistema idVariacao) {
        this.idVariacao = idVariacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametros != null ? idParametros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosClimaticos)) {
            return false;
        }
        ParametrosClimaticos other = (ParametrosClimaticos) object;
        if ((this.idParametros == null && other.idParametros != null) || (this.idParametros != null && !this.idParametros.equals(other.idParametros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ParametrosClimaticos[ idParametros=" + idParametros + " ]";
    }
    
}
