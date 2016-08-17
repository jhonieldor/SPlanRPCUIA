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
@Table(name = "simulacao_temperatura_ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SimulacaoTemperaturaAmbiente.findAll", query = "SELECT s FROM SimulacaoTemperaturaAmbiente s"),
    @NamedQuery(name = "SimulacaoTemperaturaAmbiente.findByIdTemperaturaAmbiente", query = "SELECT s FROM SimulacaoTemperaturaAmbiente s WHERE s.idTemperaturaAmbiente = :idTemperaturaAmbiente"),
    @NamedQuery(name = "SimulacaoTemperaturaAmbiente.findByTemperaturaGrausCelsius", query = "SELECT s FROM SimulacaoTemperaturaAmbiente s WHERE s.temperaturaGrausCelsius = :temperaturaGrausCelsius"),
    @NamedQuery(name = "SimulacaoTemperaturaAmbiente.findByTemperaturaFarehnheit", query = "SELECT s FROM SimulacaoTemperaturaAmbiente s WHERE s.temperaturaFarehnheit = :temperaturaFarehnheit"),
    @NamedQuery(name = "SimulacaoTemperaturaAmbiente.findByNivelInsolacao", query = "SELECT s FROM SimulacaoTemperaturaAmbiente s WHERE s.nivelInsolacao = :nivelInsolacao"),
    @NamedQuery(name = "SimulacaoTemperaturaAmbiente.findByHorario", query = "SELECT s FROM SimulacaoTemperaturaAmbiente s WHERE s.horario = :horario")})
public class SimulacaoTemperaturaAmbiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_temperatura_ambiente")
    private Integer idTemperaturaAmbiente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura_graus_celsius")
    private BigDecimal temperaturaGrausCelsius;
    @Column(name = "temperatura_farehnheit")
    private BigDecimal temperaturaFarehnheit;
    @Column(name = "nivel_insolacao")
    private BigDecimal nivelInsolacao;
    @Column(name = "horario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @JoinColumn(name = "id_simulacao", referencedColumnName = "id_simulacao")
    @ManyToOne
    private SimulacaoSistema idSimulacao;

    public SimulacaoTemperaturaAmbiente() {
    }

    public SimulacaoTemperaturaAmbiente(Integer idTemperaturaAmbiente) {
        this.idTemperaturaAmbiente = idTemperaturaAmbiente;
    }

    public Integer getIdTemperaturaAmbiente() {
        return idTemperaturaAmbiente;
    }

    public void setIdTemperaturaAmbiente(Integer idTemperaturaAmbiente) {
        this.idTemperaturaAmbiente = idTemperaturaAmbiente;
    }

    public BigDecimal getTemperaturaGrausCelsius() {
        return temperaturaGrausCelsius;
    }

    public void setTemperaturaGrausCelsius(BigDecimal temperaturaGrausCelsius) {
        this.temperaturaGrausCelsius = temperaturaGrausCelsius;
    }

    public BigDecimal getTemperaturaFarehnheit() {
        return temperaturaFarehnheit;
    }

    public void setTemperaturaFarehnheit(BigDecimal temperaturaFarehnheit) {
        this.temperaturaFarehnheit = temperaturaFarehnheit;
    }

    public BigDecimal getNivelInsolacao() {
        return nivelInsolacao;
    }

    public void setNivelInsolacao(BigDecimal nivelInsolacao) {
        this.nivelInsolacao = nivelInsolacao;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public SimulacaoSistema getIdSimulacao() {
        return idSimulacao;
    }

    public void setIdSimulacao(SimulacaoSistema idSimulacao) {
        this.idSimulacao = idSimulacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemperaturaAmbiente != null ? idTemperaturaAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SimulacaoTemperaturaAmbiente)) {
            return false;
        }
        SimulacaoTemperaturaAmbiente other = (SimulacaoTemperaturaAmbiente) object;
        if ((this.idTemperaturaAmbiente == null && other.idTemperaturaAmbiente != null) || (this.idTemperaturaAmbiente != null && !this.idTemperaturaAmbiente.equals(other.idTemperaturaAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SimulacaoTemperaturaAmbiente[ idTemperaturaAmbiente=" + idTemperaturaAmbiente + " ]";
    }
    
}
