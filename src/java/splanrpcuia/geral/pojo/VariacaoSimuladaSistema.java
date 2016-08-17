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
@Table(name = "variacao_simulada_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariacaoSimuladaSistema.findAll", query = "SELECT v FROM VariacaoSimuladaSistema v"),
    @NamedQuery(name = "VariacaoSimuladaSistema.findByIdVariacao", query = "SELECT v FROM VariacaoSimuladaSistema v WHERE v.idVariacao = :idVariacao"),
    @NamedQuery(name = "VariacaoSimuladaSistema.findByHorarioSimulado", query = "SELECT v FROM VariacaoSimuladaSistema v WHERE v.horarioSimulado = :horarioSimulado")})
public class VariacaoSimuladaSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_variacao")
    private Integer idVariacao;
    @Column(name = "horario_simulado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioSimulado;
    @OneToMany(mappedBy = "idVariacaoSistema")
    private List<ParametrosHidricosSistema> parametrosHidricosSistemaList;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema")
    @ManyToOne
    private Sistema idSistema;
    @OneToMany(mappedBy = "idVariacao")
    private List<ParametrosClimaticos> parametrosClimaticosList;

    public VariacaoSimuladaSistema() {
    }

    public VariacaoSimuladaSistema(Integer idVariacao) {
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

    @XmlTransient
    public List<ParametrosHidricosSistema> getParametrosHidricosSistemaList() {
        return parametrosHidricosSistemaList;
    }

    public void setParametrosHidricosSistemaList(List<ParametrosHidricosSistema> parametrosHidricosSistemaList) {
        this.parametrosHidricosSistemaList = parametrosHidricosSistemaList;
    }

    public Sistema getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Sistema idSistema) {
        this.idSistema = idSistema;
    }

    @XmlTransient
    public List<ParametrosClimaticos> getParametrosClimaticosList() {
        return parametrosClimaticosList;
    }

    public void setParametrosClimaticosList(List<ParametrosClimaticos> parametrosClimaticosList) {
        this.parametrosClimaticosList = parametrosClimaticosList;
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
        if (!(object instanceof VariacaoSimuladaSistema)) {
            return false;
        }
        VariacaoSimuladaSistema other = (VariacaoSimuladaSistema) object;
        if ((this.idVariacao == null && other.idVariacao != null) || (this.idVariacao != null && !this.idVariacao.equals(other.idVariacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.VariacaoSimuladaSistema[ idVariacao=" + idVariacao + " ]";
    }
    
}
