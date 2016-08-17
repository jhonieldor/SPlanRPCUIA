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
@Table(name = "monitoramento_poco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonitoramentoPoco.findAll", query = "SELECT m FROM MonitoramentoPoco m"),
    @NamedQuery(name = "MonitoramentoPoco.findByIdMonitoramentoPoco", query = "SELECT m FROM MonitoramentoPoco m WHERE m.idMonitoramentoPoco = :idMonitoramentoPoco"),
    @NamedQuery(name = "MonitoramentoPoco.findByDataMonitoramento", query = "SELECT m FROM MonitoramentoPoco m WHERE m.dataMonitoramento = :dataMonitoramento"),
    @NamedQuery(name = "MonitoramentoPoco.findByHorarioMonitoramento", query = "SELECT m FROM MonitoramentoPoco m WHERE m.horarioMonitoramento = :horarioMonitoramento"),
    @NamedQuery(name = "MonitoramentoPoco.findByNivelAgua", query = "SELECT m FROM MonitoramentoPoco m WHERE m.nivelAgua = :nivelAgua"),
    @NamedQuery(name = "MonitoramentoPoco.findByVolumeAguaDisponivel", query = "SELECT m FROM MonitoramentoPoco m WHERE m.volumeAguaDisponivel = :volumeAguaDisponivel"),
    @NamedQuery(name = "MonitoramentoPoco.findByLitrosAguaDisponivel", query = "SELECT m FROM MonitoramentoPoco m WHERE m.litrosAguaDisponivel = :litrosAguaDisponivel")})
public class MonitoramentoPoco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_monitoramento_poco")
    private Integer idMonitoramentoPoco;
    @Column(name = "data_monitoramento")
    @Temporal(TemporalType.DATE)
    private Date dataMonitoramento;
    @Column(name = "horario_monitoramento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioMonitoramento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nivel_agua")
    private BigDecimal nivelAgua;
    @Column(name = "volume_agua_disponivel")
    private BigDecimal volumeAguaDisponivel;
    @Column(name = "litros_agua_disponivel")
    private BigDecimal litrosAguaDisponivel;
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
    @ManyToOne
    private Modulo idModulo;
    @JoinColumn(name = "id_poco", referencedColumnName = "id_poco")
    @ManyToOne
    private Poco idPoco;

    public MonitoramentoPoco() {
    }

    public MonitoramentoPoco(Integer idMonitoramentoPoco) {
        this.idMonitoramentoPoco = idMonitoramentoPoco;
    }

    public Integer getIdMonitoramentoPoco() {
        return idMonitoramentoPoco;
    }

    public void setIdMonitoramentoPoco(Integer idMonitoramentoPoco) {
        this.idMonitoramentoPoco = idMonitoramentoPoco;
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

    public BigDecimal getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(BigDecimal nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public BigDecimal getVolumeAguaDisponivel() {
        return volumeAguaDisponivel;
    }

    public void setVolumeAguaDisponivel(BigDecimal volumeAguaDisponivel) {
        this.volumeAguaDisponivel = volumeAguaDisponivel;
    }

    public BigDecimal getLitrosAguaDisponivel() {
        return litrosAguaDisponivel;
    }

    public void setLitrosAguaDisponivel(BigDecimal litrosAguaDisponivel) {
        this.litrosAguaDisponivel = litrosAguaDisponivel;
    }

    public Modulo getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Modulo idModulo) {
        this.idModulo = idModulo;
    }

    public Poco getIdPoco() {
        return idPoco;
    }

    public void setIdPoco(Poco idPoco) {
        this.idPoco = idPoco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMonitoramentoPoco != null ? idMonitoramentoPoco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonitoramentoPoco)) {
            return false;
        }
        MonitoramentoPoco other = (MonitoramentoPoco) object;
        if ((this.idMonitoramentoPoco == null && other.idMonitoramentoPoco != null) || (this.idMonitoramentoPoco != null && !this.idMonitoramentoPoco.equals(other.idMonitoramentoPoco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.MonitoramentoPoco[ idMonitoramentoPoco=" + idMonitoramentoPoco + " ]";
    }
    
}
