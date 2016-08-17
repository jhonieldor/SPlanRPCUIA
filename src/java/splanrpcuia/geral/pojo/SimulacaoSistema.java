/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
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
@Table(name = "simulacao_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SimulacaoSistema.findAll", query = "SELECT s FROM SimulacaoSistema s"),
    @NamedQuery(name = "SimulacaoSistema.findByIdSimulacao", query = "SELECT s FROM SimulacaoSistema s WHERE s.idSimulacao = :idSimulacao"),
    @NamedQuery(name = "SimulacaoSistema.findByDataSimulacao", query = "SELECT s FROM SimulacaoSistema s WHERE s.dataSimulacao = :dataSimulacao")})
public class SimulacaoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_simulacao")
    private Integer idSimulacao;
    @Column(name = "data_simulacao")
    @Temporal(TemporalType.DATE)
    private Date dataSimulacao;
    @OneToMany(mappedBy = "idSimulacao")
    private List<SimulacaoTemperaturaAmbiente> simulacaoTemperaturaAmbienteList;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema")
    @ManyToOne
    private Sistema idSistema;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public SimulacaoSistema() {
    }

    public SimulacaoSistema(Integer idSimulacao) {
        this.idSimulacao = idSimulacao;
    }

    public Integer getIdSimulacao() {
        return idSimulacao;
    }

    public void setIdSimulacao(Integer idSimulacao) {
        this.idSimulacao = idSimulacao;
    }

    public Date getDataSimulacao() {
        return dataSimulacao;
    }

    public void setDataSimulacao(Date dataSimulacao) {
        this.dataSimulacao = dataSimulacao;
    }

    @XmlTransient
    public List<SimulacaoTemperaturaAmbiente> getSimulacaoTemperaturaAmbienteList() {
        return simulacaoTemperaturaAmbienteList;
    }

    public void setSimulacaoTemperaturaAmbienteList(List<SimulacaoTemperaturaAmbiente> simulacaoTemperaturaAmbienteList) {
        this.simulacaoTemperaturaAmbienteList = simulacaoTemperaturaAmbienteList;
    }

    public Sistema getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Sistema idSistema) {
        this.idSistema = idSistema;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSimulacao != null ? idSimulacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SimulacaoSistema)) {
            return false;
        }
        SimulacaoSistema other = (SimulacaoSistema) object;
        if ((this.idSimulacao == null && other.idSimulacao != null) || (this.idSimulacao != null && !this.idSimulacao.equals(other.idSimulacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.SimulacaoSistema[ idSimulacao=" + idSimulacao + " ]";
    }
    
}
