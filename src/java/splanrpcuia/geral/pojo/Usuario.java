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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsuarioLogin", query = "SELECT u FROM Usuario u WHERE u.usuarioLogin = :usuarioLogin"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 50)
    @Column(name = "usuario_login")
    private String usuarioLogin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "senha")
    private String senha;
    @OneToMany(mappedBy = "idUsuario")
    private List<Sistema> sistemaList;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private GrupoUsuarios idGrupo;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne
    private NivelUsuario idNivel;
    @JoinColumn(name = "id_stakeholder", referencedColumnName = "id_stakeholder")
    @ManyToOne
    private Stakeholder idStakeholder;
    @OneToMany(mappedBy = "idUsuario")
    private List<DesenhoComponente> desenhoComponenteList;
    @OneToMany(mappedBy = "idUsuario")
    private List<SimulacaoSistema> simulacaoSistemaList;
    @OneToMany(mappedBy = "idUsuario")
    private List<DesenhoSistema> desenhoSistemaList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<Sistema> getSistemaList() {
        return sistemaList;
    }

    public void setSistemaList(List<Sistema> sistemaList) {
        this.sistemaList = sistemaList;
    }

    public GrupoUsuarios getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(GrupoUsuarios idGrupo) {
        this.idGrupo = idGrupo;
    }

    public NivelUsuario getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(NivelUsuario idNivel) {
        this.idNivel = idNivel;
    }

    public Stakeholder getIdStakeholder() {
        return idStakeholder;
    }

    public void setIdStakeholder(Stakeholder idStakeholder) {
        this.idStakeholder = idStakeholder;
    }

    @XmlTransient
    public List<DesenhoComponente> getDesenhoComponenteList() {
        return desenhoComponenteList;
    }

    public void setDesenhoComponenteList(List<DesenhoComponente> desenhoComponenteList) {
        this.desenhoComponenteList = desenhoComponenteList;
    }

    @XmlTransient
    public List<SimulacaoSistema> getSimulacaoSistemaList() {
        return simulacaoSistemaList;
    }

    public void setSimulacaoSistemaList(List<SimulacaoSistema> simulacaoSistemaList) {
        this.simulacaoSistemaList = simulacaoSistemaList;
    }

    @XmlTransient
    public List<DesenhoSistema> getDesenhoSistemaList() {
        return desenhoSistemaList;
    }

    public void setDesenhoSistemaList(List<DesenhoSistema> desenhoSistemaList) {
        this.desenhoSistemaList = desenhoSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
