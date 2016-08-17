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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "controle_modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControleModulos.findAll", query = "SELECT c FROM ControleModulos c"),
    @NamedQuery(name = "ControleModulos.findByIdControleModulos", query = "SELECT c FROM ControleModulos c WHERE c.idControleModulos = :idControleModulos")})
public class ControleModulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle_modulos")
    private Integer idControleModulos;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
    @ManyToOne
    private Modulo idModulo;

    public ControleModulos() {
    }

    public ControleModulos(Integer idControleModulos) {
        this.idControleModulos = idControleModulos;
    }

    public Integer getIdControleModulos() {
        return idControleModulos;
    }

    public void setIdControleModulos(Integer idControleModulos) {
        this.idControleModulos = idControleModulos;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public Modulo getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Modulo idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControleModulos != null ? idControleModulos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControleModulos)) {
            return false;
        }
        ControleModulos other = (ControleModulos) object;
        if ((this.idControleModulos == null && other.idControleModulos != null) || (this.idControleModulos != null && !this.idControleModulos.equals(other.idControleModulos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ControleModulos[ idControleModulos=" + idControleModulos + " ]";
    }
    
}
