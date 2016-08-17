/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "subsetor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subsetor.findAll", query = "SELECT s FROM Subsetor s"),
    @NamedQuery(name = "Subsetor.findByIdSubsetor", query = "SELECT s FROM Subsetor s WHERE s.idSubsetor = :idSubsetor"),
    @NamedQuery(name = "Subsetor.findByNome", query = "SELECT s FROM Subsetor s WHERE s.nome = :nome")})
public class Subsetor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subsetor")
    private Integer idSubsetor;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetor;

    public Subsetor() {
    }

    public Subsetor(Integer idSubsetor) {
        this.idSubsetor = idSubsetor;
    }

    public Integer getIdSubsetor() {
        return idSubsetor;
    }

    public void setIdSubsetor(Integer idSubsetor) {
        this.idSubsetor = idSubsetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (idSubsetor != null ? idSubsetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subsetor)) {
            return false;
        }
        Subsetor other = (Subsetor) object;
        if ((this.idSubsetor == null && other.idSubsetor != null) || (this.idSubsetor != null && !this.idSubsetor.equals(other.idSubsetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Subsetor[ idSubsetor=" + idSubsetor + " ]";
    }
    
}
