/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
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
@Table(name = "variacao_simulada_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariacaoSimuladaComponente.findAll", query = "SELECT v FROM VariacaoSimuladaComponente v"),
    @NamedQuery(name = "VariacaoSimuladaComponente.findByIdVariacao", query = "SELECT v FROM VariacaoSimuladaComponente v WHERE v.idVariacao = :idVariacao"),
    @NamedQuery(name = "VariacaoSimuladaComponente.findByHorarioSimulado", query = "SELECT v FROM VariacaoSimuladaComponente v WHERE v.horarioSimulado = :horarioSimulado")})
public class VariacaoSimuladaComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_variacao")
    private Integer idVariacao;
    @Column(name = "horario_simulado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioSimulado;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componente idComponente;

    public VariacaoSimuladaComponente() {
    }

    public VariacaoSimuladaComponente(Integer idVariacao) {
        this.idVariacao = idVariacao;
    }

    public Integer getIdVariacao() {
        return idVariacao;
    }

    public void setIdVariacao(Integer idVariacao) {
        this.idVariacao = idVariacao;
    }

    public Date getHorarioSimulado() {
        return horarioSimulado;
    }

    public void setHorarioSimulado(Date horarioSimulado) {
        this.horarioSimulado = horarioSimulado;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariacao != null ? idVariacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariacaoSimuladaComponente)) {
            return false;
        }
        VariacaoSimuladaComponente other = (VariacaoSimuladaComponente) object;
        if ((this.idVariacao == null && other.idVariacao != null) || (this.idVariacao != null && !this.idVariacao.equals(other.idVariacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.VariacaoSimuladaComponente[ idVariacao=" + idVariacao + " ]";
    }
    
}
