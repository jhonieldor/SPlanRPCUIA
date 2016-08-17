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
@Table(name = "hidrometro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hidrometro.findAll", query = "SELECT h FROM Hidrometro h"),
    @NamedQuery(name = "Hidrometro.findByIdHidrometro", query = "SELECT h FROM Hidrometro h WHERE h.idHidrometro = :idHidrometro"),
    @NamedQuery(name = "Hidrometro.findByHidrometro", query = "SELECT h FROM Hidrometro h WHERE h.hidrometro = :hidrometro"),
    @NamedQuery(name = "Hidrometro.findBySerie", query = "SELECT h FROM Hidrometro h WHERE h.serie = :serie"),
    @NamedQuery(name = "Hidrometro.findByModelo", query = "SELECT h FROM Hidrometro h WHERE h.modelo = :modelo"),
    @NamedQuery(name = "Hidrometro.findByFabricante", query = "SELECT h FROM Hidrometro h WHERE h.fabricante = :fabricante")})
public class Hidrometro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hidrometro")
    private Integer idHidrometro;
    @Size(max = 50)
    @Column(name = "hidrometro")
    private String hidrometro;
    @Size(max = 50)
    @Column(name = "serie")
    private String serie;
    @Size(max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 20)
    @Column(name = "fabricante")
    private String fabricante;
    @OneToMany(mappedBy = "idHidrometro")
    private List<MonitoramentoHidrometro> monitoramentoHidrometroList;
    @JoinColumn(name = "id_equipamento", referencedColumnName = "id_equipamento_setor")
    @ManyToOne
    private EquipamentoSetor idEquipamento;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne
    private Item idItem;
    @JoinColumn(name = "id_linha", referencedColumnName = "id_linha")
    @ManyToOne
    private LinhaProducao idLinha;
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetor;

    public Hidrometro() {
    }

    public Hidrometro(Integer idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public Integer getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(Integer idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public String getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(String hidrometro) {
        this.hidrometro = hidrometro;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @XmlTransient
    public List<MonitoramentoHidrometro> getMonitoramentoHidrometroList() {
        return monitoramentoHidrometroList;
    }

    public void setMonitoramentoHidrometroList(List<MonitoramentoHidrometro> monitoramentoHidrometroList) {
        this.monitoramentoHidrometroList = monitoramentoHidrometroList;
    }

    public EquipamentoSetor getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(EquipamentoSetor idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHidrometro != null ? idHidrometro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hidrometro)) {
            return false;
        }
        Hidrometro other = (Hidrometro) object;
        if ((this.idHidrometro == null && other.idHidrometro != null) || (this.idHidrometro != null && !this.idHidrometro.equals(other.idHidrometro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Hidrometro[ idHidrometro=" + idHidrometro + " ]";
    }
    
}
