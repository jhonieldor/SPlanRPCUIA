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
@Table(name = "grupo_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoUsuarios.findAll", query = "SELECT g FROM GrupoUsuarios g"),
    @NamedQuery(name = "GrupoUsuarios.findByIdGrupo", query = "SELECT g FROM GrupoUsuarios g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "GrupoUsuarios.findByNomeGrupo", query = "SELECT g FROM GrupoUsuarios g WHERE g.nomeGrupo = :nomeGrupo")})
public class GrupoUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Size(max = 100)
    @Column(name = "nome_grupo")
    private String nomeGrupo;
    @OneToMany(mappedBy = "idGrupo")
    private List<Usuario> usuarioList;

    public GrupoUsuarios() {
    }

    public GrupoUsuarios(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuarios)) {
            return false;
        }
        GrupoUsuarios other = (GrupoUsuarios) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.GrupoUsuarios[ idGrupo=" + idGrupo + " ]";
    }
    
}
