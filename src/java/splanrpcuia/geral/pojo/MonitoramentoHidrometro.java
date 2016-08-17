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
@Table(name = "monitoramento_hidrometro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonitoramentoHidrometro.findAll", query = "SELECT m FROM MonitoramentoHidrometro m"),
    @NamedQuery(name = "MonitoramentoHidrometro.findByIdControleHidrometro", query = "SELECT m FROM MonitoramentoHidrometro m WHERE m.idControleHidrometro = :idControleHidrometro"),
    @NamedQuery(name = "MonitoramentoHidrometro.findByDataMonitoramento", query = "SELECT m FROM MonitoramentoHidrometro m WHERE m.dataMonitoramento = :dataMonitoramento"),
    @NamedQuery(name = "MonitoramentoHidrometro.findByHorarioMonitoramento", query = "SELECT m FROM MonitoramentoHidrometro m WHERE m.horarioMonitoramento = :horarioMonitoramento"),
    @NamedQuery(name = "MonitoramentoHidrometro.findByVazaoRegistrada", query = "SELECT m FROM MonitoramentoHidrometro m WHERE m.vazaoRegistrada = :vazaoRegistrada")})
public class MonitoramentoHidrometro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle_hidrometro")
    private Integer idControleHidrometro;
    @Column(name = "data_monitoramento")
    @Temporal(TemporalType.DATE)
    private Date dataMonitoramento;
    @Column(name = "horario_monitoramento")
    @Temporal(TemporalType.DATE)
    private Date horarioMonitoramento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vazao_registrada")
    private BigDecimal vazaoRegistrada;
    @JoinColumn(name = "id_hidrometro", referencedColumnName = "id_hidrometro")
    @ManyToOne
    private Hidrometro idHidrometro;

    public MonitoramentoHidrometro() {
    }

    public MonitoramentoHidrometro(Integer idControleHidrometro) {
        this.idControleHidrometro = idControleHidrometro;
    }

    public Integer getIdControleHidrometro() {
        return idControleHidrometro;
    }

    public void setIdControleHidrometro(Integer idControleHidrometro) {
        this.idControleHidrometro = idControleHidrometro;
    }

    public Date getDataMonitoramento() {
        return dataMonitoramento;
    }

    public void setDataMonitoramento(Date dataMonitoramento) {
        this.dataMonitoramento = dataMonitoramento;
    }

    public Date getHorarioMonitoramento() {
        return horarioMonitoramento;
    }

    public void setHorarioMonitoramento(Date horarioMonitoramento) {
        this.horarioMonitoramento = horarioMonitoramento;
    }

    public BigDecimal getVazaoRegistrada() {
        return vazaoRegistrada;
    }

    public void setVazaoRegistrada(BigDecimal vazaoRegistrada) {
        this.vazaoRegistrada = vazaoRegistrada;
    }

    public Hidrometro getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(Hidrometro idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControleHidrometro != null ? idControleHidrometro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonitoramentoHidrometro)) {
            return false;
        }
        MonitoramentoHidrometro other = (MonitoramentoHidrometro) object;
        if ((this.idControleHidrometro == null && other.idControleHidrometro != null) || (this.idControleHidrometro != null && !this.idControleHidrometro.equals(other.idControleHidrometro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.MonitoramentoHidrometro[ idControleHidrometro=" + idControleHidrometro + " ]";
    }
    
}
