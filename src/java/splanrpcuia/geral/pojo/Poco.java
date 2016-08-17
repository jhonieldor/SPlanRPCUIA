/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "poco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poco.findAll", query = "SELECT p FROM Poco p"),
    @NamedQuery(name = "Poco.findByIdPoco", query = "SELECT p FROM Poco p WHERE p.idPoco = :idPoco"),
    @NamedQuery(name = "Poco.findByCapacidadeLitros", query = "SELECT p FROM Poco p WHERE p.capacidadeLitros = :capacidadeLitros"),
    @NamedQuery(name = "Poco.findByCapacidadeVolume", query = "SELECT p FROM Poco p WHERE p.capacidadeVolume = :capacidadeVolume"),
    @NamedQuery(name = "Poco.findByProfundidade", query = "SELECT p FROM Poco p WHERE p.profundidade = :profundidade"),
    @NamedQuery(name = "Poco.findByDiametro", query = "SELECT p FROM Poco p WHERE p.diametro = :diametro"),
    @NamedQuery(name = "Poco.findByLatitude", query = "SELECT p FROM Poco p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Poco.findByLongitude", query = "SELECT p FROM Poco p WHERE p.longitude = :longitude"),
    @NamedQuery(name = "Poco.findByDescricaoLocalizacao", query = "SELECT p FROM Poco p WHERE p.descricaoLocalizacao = :descricaoLocalizacao")})
public class Poco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_poco")
    private Integer idPoco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capacidade_litros")
    private BigDecimal capacidadeLitros;
    @Column(name = "capacidade_volume")
    private BigDecimal capacidadeVolume;
    @Column(name = "profundidade")
    private BigDecimal profundidade;
    @Column(name = "diametro")
    private BigDecimal diametro;
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Size(max = 80)
    @Column(name = "descricao_localizacao")
    private String descricaoLocalizacao;
    @OneToMany(mappedBy = "idPoco")
    private List<Nodo> nodoList;
    @OneToMany(mappedBy = "idPoco")
    private List<MonitoramentoPoco> monitoramentoPocoList;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;

    public Poco() {
    }

    public Poco(Integer idPoco) {
        this.idPoco = idPoco;
    }

    public Integer getIdPoco() {
        return idPoco;
    }

    public void setIdPoco(Integer idPoco) {
        this.idPoco = idPoco;
    }

    public BigDecimal getCapacidadeLitros() {
        return capacidadeLitros;
    }

    public void setCapacidadeLitros(BigDecimal capacidadeLitros) {
        this.capacidadeLitros = capacidadeLitros;
    }

    public BigDecimal getCapacidadeVolume() {
        return capacidadeVolume;
    }

    public void setCapacidadeVolume(BigDecimal capacidadeVolume) {
        this.capacidadeVolume = capacidadeVolume;
    }

    public BigDecimal getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(BigDecimal profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getDiametro() {
        return diametro;
    }

    public void setDiametro(BigDecimal diametro) {
        this.diametro = diametro;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getDescricaoLocalizacao() {
        return descricaoLocalizacao;
    }

    public void setDescricaoLocalizacao(String descricaoLocalizacao) {
        this.descricaoLocalizacao = descricaoLocalizacao;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    @XmlTransient
    public List<MonitoramentoPoco> getMonitoramentoPocoList() {
        return monitoramentoPocoList;
    }

    public void setMonitoramentoPocoList(List<MonitoramentoPoco> monitoramentoPocoList) {
        this.monitoramentoPocoList = monitoramentoPocoList;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoco != null ? idPoco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poco)) {
            return false;
        }
        Poco other = (Poco) object;
        if ((this.idPoco == null && other.idPoco != null) || (this.idPoco != null && !this.idPoco.equals(other.idPoco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Poco[ idPoco=" + idPoco + " ]";
    }
    
}
