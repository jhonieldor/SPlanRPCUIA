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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "checklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checklist.findAll", query = "SELECT c FROM Checklist c"),
    @NamedQuery(name = "Checklist.findByIdChecklist", query = "SELECT c FROM Checklist c WHERE c.idChecklist = :idChecklist")})
public class Checklist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_checklist")
    private Integer idChecklist;
    @OneToMany(mappedBy = "idChecklist")
    private List<ChecklistComponente> checklistComponenteList;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componente idComponente;

    public Checklist() {
    }

    public Checklist(Integer idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Integer getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(Integer idChecklist) {
        this.idChecklist = idChecklist;
    }

    @XmlTransient
    public List<ChecklistComponente> getChecklistComponenteList() {
        return checklistComponenteList;
    }

    public void setChecklistComponenteList(List<ChecklistComponente> checklistComponenteList) {
        this.checklistComponenteList = checklistComponenteList;
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
        hash += (idChecklist != null ? idChecklist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checklist)) {
            return false;
        }
        Checklist other = (Checklist) object;
        if ((this.idChecklist == null && other.idChecklist != null) || (this.idChecklist != null && !this.idChecklist.equals(other.idChecklist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Checklist[ idChecklist=" + idChecklist + " ]";
    }
    
}
