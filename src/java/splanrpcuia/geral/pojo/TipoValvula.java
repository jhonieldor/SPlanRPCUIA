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
@Table(name = "tipo_valvula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoValvula.findAll", query = "SELECT t FROM TipoValvula t"),
    @NamedQuery(name = "TipoValvula.findByIdTipoValvula", query = "SELECT t FROM TipoValvula t WHERE t.idTipoValvula = :idTipoValvula"),
    @NamedQuery(name = "TipoValvula.findByNomeTipo", query = "SELECT t FROM TipoValvula t WHERE t.nomeTipo = :nomeTipo"),
    @NamedQuery(name = "TipoValvula.findByDescricao", query = "SELECT t FROM TipoValvula t WHERE t.descricao = :descricao")})
public class TipoValvula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_valvula")
    private Integer idTipoValvula;
    @Size(max = 50)
    @Column(name = "nome_tipo")
    private String nomeTipo;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @ManyToOne
    private EntidadeModulos idEntidade;
    @OneToMany(mappedBy = "idTipoValvula")
    private List<Valvula> valvulaList;

    public TipoValvula() {
    }

    public TipoValvula(Integer idTipoValvula) {
        this.idTipoValvula = idTipoValvula;
    }

    public Integer getIdTipoValvula() {
        return idTipoValvula;
    }

    public void setIdTipoValvula(Integer idTipoValvula) {
        this.idTipoValvula = idTipoValvula;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
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

    @XmlTransient
    public List<Valvula> getValvulaList() {
        return valvulaList;
    }

    public void setValvulaList(List<Valvula> valvulaList) {
        this.valvulaList = valvulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoValvula != null ? idTipoValvula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoValvula)) {
            return false;
        }
        TipoValvula other = (TipoValvula) object;
        if ((this.idTipoValvula == null && other.idTipoValvula != null) || (this.idTipoValvula != null && !this.idTipoValvula.equals(other.idTipoValvula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TipoValvula[ idTipoValvula=" + idTipoValvula + " ]";
    }
    
}
