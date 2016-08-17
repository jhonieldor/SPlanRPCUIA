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
@Table(name = "grupo_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoItem.findAll", query = "SELECT g FROM GrupoItem g"),
    @NamedQuery(name = "GrupoItem.findByIdGrupo", query = "SELECT g FROM GrupoItem g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "GrupoItem.findByIdentificacao", query = "SELECT g FROM GrupoItem g WHERE g.identificacao = :identificacao"),
    @NamedQuery(name = "GrupoItem.findByNome", query = "SELECT g FROM GrupoItem g WHERE g.nome = :nome")})
public class GrupoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Size(max = 20)
    @Column(name = "identificacao")
    private String identificacao;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idGrupo")
    private List<Item> itemList;

    public GrupoItem() {
    }

    public GrupoItem(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
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
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
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
        if (!(object instanceof GrupoItem)) {
            return false;
        }
        GrupoItem other = (GrupoItem) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.GrupoItem[ idGrupo=" + idGrupo + " ]";
    }
    
}
