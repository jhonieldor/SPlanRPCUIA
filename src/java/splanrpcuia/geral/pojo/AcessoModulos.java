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
@Table(name = "acesso_modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoModulos.findAll", query = "SELECT a FROM AcessoModulos a"),
    @NamedQuery(name = "AcessoModulos.findByIdAcessoModulo", query = "SELECT a FROM AcessoModulos a WHERE a.idAcessoModulo = :idAcessoModulo"),
    @NamedQuery(name = "AcessoModulos.findByAcessaModulo", query = "SELECT a FROM AcessoModulos a WHERE a.acessaModulo = :acessaModulo"),
    @NamedQuery(name = "AcessoModulos.findByAlteraDados", query = "SELECT a FROM AcessoModulos a WHERE a.alteraDados = :alteraDados"),
    @NamedQuery(name = "AcessoModulos.findByIncluiDados", query = "SELECT a FROM AcessoModulos a WHERE a.incluiDados = :incluiDados"),
    @NamedQuery(name = "AcessoModulos.findByExcluiDados", query = "SELECT a FROM AcessoModulos a WHERE a.excluiDados = :excluiDados")})
public class AcessoModulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acesso_modulo")
    private Integer idAcessoModulo;
    @Column(name = "acessa_modulo")
    private Boolean acessaModulo;
    @Column(name = "altera_dados")
    private Boolean alteraDados;
    @Column(name = "inclui_dados")
    private Boolean incluiDados;
    @Column(name = "exclui_dados")
    private Boolean excluiDados;
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
    @ManyToOne
    private Modulo idModulo;
    @OneToMany(mappedBy = "idAcessoModulos")
    private List<NivelUsuario> nivelUsuarioList;

    public AcessoModulos() {
    }

    public AcessoModulos(Integer idAcessoModulo) {
        this.idAcessoModulo = idAcessoModulo;
    }

    public Integer getIdAcessoModulo() {
        return idAcessoModulo;
    }

    public void setIdAcessoModulo(Integer idAcessoModulo) {
        this.idAcessoModulo = idAcessoModulo;
    }

    public Boolean getAcessaModulo() {
        return acessaModulo;
    }

    public void setAcessaModulo(Boolean acessaModulo) {
        this.acessaModulo = acessaModulo;
    }

    public Boolean getAlteraDados() {
        return alteraDados;
    }

    public void setAlteraDados(Boolean alteraDados) {
        this.alteraDados = alteraDados;
    }

    public Boolean getIncluiDados() {
        return incluiDados;
    }

    public void setIncluiDados(Boolean incluiDados) {
        this.incluiDados = incluiDados;
    }

    public Boolean getExcluiDados() {
        return excluiDados;
    }

    public void setExcluiDados(Boolean excluiDados) {
        this.excluiDados = excluiDados;
    }

    public Modulo getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Modulo idModulo) {
        this.idModulo = idModulo;
    }

    @XmlTransient
    public List<NivelUsuario> getNivelUsuarioList() {
        return nivelUsuarioList;
    }

    public void setNivelUsuarioList(List<NivelUsuario> nivelUsuarioList) {
        this.nivelUsuarioList = nivelUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcessoModulo != null ? idAcessoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoModulos)) {
            return false;
        }
        AcessoModulos other = (AcessoModulos) object;
        if ((this.idAcessoModulo == null && other.idAcessoModulo != null) || (this.idAcessoModulo != null && !this.idAcessoModulo.equals(other.idAcessoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.AcessoModulos[ idAcessoModulo=" + idAcessoModulo + " ]";
    }
    
}
