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
@Table(name = "equipamento_setor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipamentoSetor.findAll", query = "SELECT e FROM EquipamentoSetor e"),
    @NamedQuery(name = "EquipamentoSetor.findByIdEquipamentoSetor", query = "SELECT e FROM EquipamentoSetor e WHERE e.idEquipamentoSetor = :idEquipamentoSetor"),
    @NamedQuery(name = "EquipamentoSetor.findByHandleCad", query = "SELECT e FROM EquipamentoSetor e WHERE e.handleCad = :handleCad")})
public class EquipamentoSetor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipamento_setor")
    private Integer idEquipamentoSetor;
    @Size(max = 50)
    @Column(name = "handle_cad")
    private String handleCad;
    @OneToMany(mappedBy = "destino")
    private List<Transportador> transportadorList;
    @OneToMany(mappedBy = "origem")
    private List<Transportador> transportadorList1;
    @OneToMany(mappedBy = "idEquipamentoSetor")
    private List<PontoHidraulico> pontoHidraulicoList;
    @JoinColumn(name = "id_eq", referencedColumnName = "id_eq")
    @ManyToOne
    private Equipamento idEq;
    @JoinColumn(name = "id_linha", referencedColumnName = "id_linha")
    @ManyToOne
    private LinhaProducao idLinha;
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetor;
    @OneToMany(mappedBy = "idEquipamentoSetor")
    private List<PontoPneumatico> pontoPneumaticoList;
    @OneToMany(mappedBy = "idEquipamento")
    private List<Hidrometro> hidrometroList;

    public EquipamentoSetor() {
    }

    public EquipamentoSetor(Integer idEquipamentoSetor) {
        this.idEquipamentoSetor = idEquipamentoSetor;
    }

    public Integer getIdEquipamentoSetor() {
        return idEquipamentoSetor;
    }

    public void setIdEquipamentoSetor(Integer idEquipamentoSetor) {
        this.idEquipamentoSetor = idEquipamentoSetor;
    }

    public String getHandleCad() {
        return handleCad;
    }

    public void setHandleCad(String handleCad) {
        this.handleCad = handleCad;
    }

    @XmlTransient
    public List<Transportador> getTransportadorList() {
        return transportadorList;
    }

    public void setTransportadorList(List<Transportador> transportadorList) {
        this.transportadorList = transportadorList;
    }

    @XmlTransient
    public List<Transportador> getTransportadorList1() {
        return transportadorList1;
    }

    public void setTransportadorList1(List<Transportador> transportadorList1) {
        this.transportadorList1 = transportadorList1;
    }

    @XmlTransient
    public List<PontoHidraulico> getPontoHidraulicoList() {
        return pontoHidraulicoList;
    }

    public void setPontoHidraulicoList(List<PontoHidraulico> pontoHidraulicoList) {
        this.pontoHidraulicoList = pontoHidraulicoList;
    }

    public Equipamento getIdEq() {
        return idEq;
    }

    public void setIdEq(Equipamento idEq) {
        this.idEq = idEq;
    }

    public LinhaProducao getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(LinhaProducao idLinha) {
        this.idLinha = idLinha;
    }

    public Setor getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
    }

    @XmlTransient
    public List<PontoPneumatico> getPontoPneumaticoList() {
        return pontoPneumaticoList;
    }

    public void setPontoPneumaticoList(List<PontoPneumatico> pontoPneumaticoList) {
        this.pontoPneumaticoList = pontoPneumaticoList;
    }

    @XmlTransient
    public List<Hidrometro> getHidrometroList() {
        return hidrometroList;
    }

    public void setHidrometroList(List<Hidrometro> hidrometroList) {
        this.hidrometroList = hidrometroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipamentoSetor != null ? idEquipamentoSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoSetor)) {
            return false;
        }
        EquipamentoSetor other = (EquipamentoSetor) object;
        if ((this.idEquipamentoSetor == null && other.idEquipamentoSetor != null) || (this.idEquipamentoSetor != null && !this.idEquipamentoSetor.equals(other.idEquipamentoSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.EquipamentoSetor[ idEquipamentoSetor=" + idEquipamentoSetor + " ]";
    }
    
}
