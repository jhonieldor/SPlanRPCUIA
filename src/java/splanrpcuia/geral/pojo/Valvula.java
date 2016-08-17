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
@Table(name = "valvula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valvula.findAll", query = "SELECT v FROM Valvula v"),
    @NamedQuery(name = "Valvula.findByIdValvula", query = "SELECT v FROM Valvula v WHERE v.idValvula = :idValvula"),
    @NamedQuery(name = "Valvula.findByNome", query = "SELECT v FROM Valvula v WHERE v.nome = :nome"),
    @NamedQuery(name = "Valvula.findByDescricao", query = "SELECT v FROM Valvula v WHERE v.descricao = :descricao")})
public class Valvula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valvula")
    private Integer idValvula;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @JoinColumn(name = "id_nodo", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo idNodo;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;
    @JoinColumn(name = "id_tipo_valvula", referencedColumnName = "id_tipo_valvula")
    @ManyToOne
    private TipoValvula idTipoValvula;

    public Valvula() {
    }

    public Valvula(Integer idValvula) {
        this.idValvula = idValvula;
    }

    public Integer getIdValvula() {
        return idValvula;
    }

    public void setIdValvula(Integer idValvula) {
        this.idValvula = idValvula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EntidadeModulos getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeModulos idEntidade) {
        this.idEntidade = idEntidade;
    }

    public Nodo getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(Nodo idNodo) {
        this.idNodo = idNodo;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    public TipoValvula getIdTipoValvula() {
        return idTipoValvula;
    }

    public void setIdTipoValvula(TipoValvula idTipoValvula) {
        this.idTipoValvula = idTipoValvula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValvula != null ? idValvula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valvula)) {
            return false;
        }
        Valvula other = (Valvula) object;
        if ((this.idValvula == null && other.idValvula != null) || (this.idValvula != null && !this.idValvula.equals(other.idValvula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Valvula[ idValvula=" + idValvula + " ]";
    }
    
}
