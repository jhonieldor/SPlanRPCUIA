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
@Table(name = "nivel_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelUsuario.findAll", query = "SELECT n FROM NivelUsuario n"),
    @NamedQuery(name = "NivelUsuario.findByIdNivel", query = "SELECT n FROM NivelUsuario n WHERE n.idNivel = :idNivel"),
    @NamedQuery(name = "NivelUsuario.findByNivel", query = "SELECT n FROM NivelUsuario n WHERE n.nivel = :nivel"),
    @NamedQuery(name = "NivelUsuario.findByControlaUsuarios", query = "SELECT n FROM NivelUsuario n WHERE n.controlaUsuarios = :controlaUsuarios"),
    @NamedQuery(name = "NivelUsuario.findByControlaGrupo", query = "SELECT n FROM NivelUsuario n WHERE n.controlaGrupo = :controlaGrupo")})
public class NivelUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel")
    private Integer idNivel;
    @Size(max = 20)
    @Column(name = "nivel")
    private String nivel;
    @Column(name = "controla_usuarios")
    private Boolean controlaUsuarios;
    @Column(name = "controla_grupo")
    private Boolean controlaGrupo;
    @OneToMany(mappedBy = "idNivel")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_acesso_modulos", referencedColumnName = "id_acesso_modulo")
    @ManyToOne
    private AcessoModulos idAcessoModulos;

    public NivelUsuario() {
    }

    public NivelUsuario(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Boolean getControlaUsuarios() {
        return controlaUsuarios;
    }

    public void setControlaUsuarios(Boolean controlaUsuarios) {
        this.controlaUsuarios = controlaUsuarios;
    }

    public Boolean getControlaGrupo() {
        return controlaGrupo;
    }

    public void setControlaGrupo(Boolean controlaGrupo) {
        this.controlaGrupo = controlaGrupo;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public AcessoModulos getIdAcessoModulos() {
        return idAcessoModulos;
    }

    public void setIdAcessoModulos(AcessoModulos idAcessoModulos) {
        this.idAcessoModulos = idAcessoModulos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelUsuario)) {
            return false;
        }
        NivelUsuario other = (NivelUsuario) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.NivelUsuario[ idNivel=" + idNivel + " ]";
    }
    
}
