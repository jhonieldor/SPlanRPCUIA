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
@Table(name = "equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT e FROM Equipamento e"),
    @NamedQuery(name = "Equipamento.findByIdEq", query = "SELECT e FROM Equipamento e WHERE e.idEq = :idEq"),
    @NamedQuery(name = "Equipamento.findByIdentificacao", query = "SELECT e FROM Equipamento e WHERE e.identificacao = :identificacao"),
    @NamedQuery(name = "Equipamento.findByNome", query = "SELECT e FROM Equipamento e WHERE e.nome = :nome")})
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_eq")
    private Integer idEq;
    @Size(max = 10)
    @Column(name = "identificacao")
    private String identificacao;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idEq")
    private List<EquipamentoSetor> equipamentoSetorList;
    @OneToMany(mappedBy = "idEquipamento")
    private List<Maquina> maquinaList;

    public Equipamento() {
    }

    public Equipamento(Integer idEq) {
        this.idEq = idEq;
    }

    public Integer getIdEq() {
        return idEq;
    }

    public void setIdEq(Integer idEq) {
        this.idEq = idEq;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<EquipamentoSetor> getEquipamentoSetorList() {
        return equipamentoSetorList;
    }

    public void setEquipamentoSetorList(List<EquipamentoSetor> equipamentoSetorList) {
        this.equipamentoSetorList = equipamentoSetorList;
    }

    @XmlTransient
    public List<Maquina> getMaquinaList() {
        return maquinaList;
    }

    public void setMaquinaList(List<Maquina> maquinaList) {
        this.maquinaList = maquinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEq != null ? idEq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
        if ((this.idEq == null && other.idEq != null) || (this.idEq != null && !this.idEq.equals(other.idEq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Equipamento[ idEq=" + idEq + " ]";
    }
    
}
