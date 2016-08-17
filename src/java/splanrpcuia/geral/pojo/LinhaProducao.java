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
@Table(name = "linha_producao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinhaProducao.findAll", query = "SELECT l FROM LinhaProducao l"),
    @NamedQuery(name = "LinhaProducao.findByIdLinha", query = "SELECT l FROM LinhaProducao l WHERE l.idLinha = :idLinha"),
    @NamedQuery(name = "LinhaProducao.findByNomeLinha", query = "SELECT l FROM LinhaProducao l WHERE l.nomeLinha = :nomeLinha")})
public class LinhaProducao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_linha")
    private Integer idLinha;
    @Size(max = 20)
    @Column(name = "nome_linha")
    private String nomeLinha;
    @OneToMany(mappedBy = "idLinha")
    private List<Transportador> transportadorList;
    @OneToMany(mappedBy = "idLinha")
    private List<PontoHidraulico> pontoHidraulicoList;
    @OneToMany(mappedBy = "idLinha")
    private List<EquipamentoSetor> equipamentoSetorList;
    @OneToMany(mappedBy = "idLinha")
    private List<PontoPneumatico> pontoPneumaticoList;
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetor;
    @OneToMany(mappedBy = "idLinha")
    private List<Hidrometro> hidrometroList;

    public LinhaProducao() {
    }

    public LinhaProducao(Integer idLinha) {
        this.idLinha = idLinha;
    }

    public Integer getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Integer idLinha) {
        this.idLinha = idLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    @XmlTransient
    public List<Transportador> getTransportadorList() {
        return transportadorList;
    }

    public void setTransportadorList(List<Transportador> transportadorList) {
        this.transportadorList = transportadorList;
    }

    @XmlTransient
    public List<PontoHidraulico> getPontoHidraulicoList() {
        return pontoHidraulicoList;
    }

    public void setPontoHidraulicoList(List<PontoHidraulico> pontoHidraulicoList) {
        this.pontoHidraulicoList = pontoHidraulicoList;
    }

    @XmlTransient
    public List<EquipamentoSetor> getEquipamentoSetorList() {
        return equipamentoSetorList;
    }

    public void setEquipamentoSetorList(List<EquipamentoSetor> equipamentoSetorList) {
        this.equipamentoSetorList = equipamentoSetorList;
    }

    @XmlTransient
    public List<PontoPneumatico> getPontoPneumaticoList() {
        return pontoPneumaticoList;
    }

    public void setPontoPneumaticoList(List<PontoPneumatico> pontoPneumaticoList) {
        this.pontoPneumaticoList = pontoPneumaticoList;
    }

    public Setor getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
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
        hash += (idLinha != null ? idLinha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaProducao)) {
            return false;
        }
        LinhaProducao other = (LinhaProducao) object;
        if ((this.idLinha == null && other.idLinha != null) || (this.idLinha != null && !this.idLinha.equals(other.idLinha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.LinhaProducao[ idLinha=" + idLinha + " ]";
    }
    
}
