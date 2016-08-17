/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByIdModulo", query = "SELECT m FROM Modulo m WHERE m.idModulo = :idModulo"),
    @NamedQuery(name = "Modulo.findByModulo", query = "SELECT m FROM Modulo m WHERE m.modulo = :modulo")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modulo")
    private Integer idModulo;
    @Size(max = 20)
    @Column(name = "modulo")
    private String modulo;
    @OneToMany(mappedBy = "idModulo")
    private List<ControleModulos> controleModulosList;
    @OneToMany(mappedBy = "idModulo")
    private List<MonitoramentoPoco> monitoramentoPocoList;
    @OneToMany(mappedBy = "idModulo")
    private List<AcessoModulos> acessoModulosList;

    public Modulo() {
    }

    public Modulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @XmlTransient
    public List<ControleModulos> getControleModulosList() {
        return controleModulosList;
    }

    public void setControleModulosList(List<ControleModulos> controleModulosList) {
        this.controleModulosList = controleModulosList;
    }

    @XmlTransient
    public List<MonitoramentoPoco> getMonitoramentoPocoList() {
        return monitoramentoPocoList;
    }

    public void setMonitoramentoPocoList(List<MonitoramentoPoco> monitoramentoPocoList) {
        this.monitoramentoPocoList = monitoramentoPocoList;
    }

    @XmlTransient
    public List<AcessoModulos> getAcessoModulosList() {
        return acessoModulosList;
    }

    public void setAcessoModulosList(List<AcessoModulos> acessoModulosList) {
        this.acessoModulosList = acessoModulosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Modulo[ idModulo=" + idModulo + " ]";
    }
    
}
