/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c"),
    @NamedQuery(name = "Componente.findByIdComponente", query = "SELECT c FROM Componente c WHERE c.idComponente = :idComponente"),
    @NamedQuery(name = "Componente.findByIdentificacao", query = "SELECT c FROM Componente c WHERE c.identificacao = :identificacao"),
    @NamedQuery(name = "Componente.findByDescricao", query = "SELECT c FROM Componente c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Componente.findByVolume", query = "SELECT c FROM Componente c WHERE c.volume = :volume"),
    @NamedQuery(name = "Componente.findByCustoTotal", query = "SELECT c FROM Componente c WHERE c.custoTotal = :custoTotal")})
public class Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente")
    private Integer idComponente;
    @Size(max = 50)
    @Column(name = "identificacao")
    private String identificacao;
    @Size(max = 200)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume")
    private BigDecimal volume;
    @Column(name = "custo_total")
    private BigDecimal custoTotal;
    @OneToMany(mappedBy = "idComponente")
    private List<DesenhoComponente> desenhoComponenteList;
    @OneToMany(mappedBy = "idComponente")
    private List<DimRetangular> dimRetangularList;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema")
    @ManyToOne
    private Sistema idSistema;
    @JoinColumn(name = "id_tipo_componente", referencedColumnName = "id_tipo_componente")
    @ManyToOne
    private TipoComponente idTipoComponente;
    @OneToMany(mappedBy = "idComponente")
    private List<Checklist> checklistList;
    @OneToMany(mappedBy = "idComponente")
    private List<ProdutoComponente> produtoComponenteList;
    @OneToMany(mappedBy = "idComponente")
    private List<VariacaoSimuladaComponente> variacaoSimuladaComponenteList;
    @OneToMany(mappedBy = "idComponente")
    private List<DimEsferico> dimEsfericoList;

    public Componente() {
    }

    public Componente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(BigDecimal custoTotal) {
        this.custoTotal = custoTotal;
    }

    @XmlTransient
    public List<DesenhoComponente> getDesenhoComponenteList() {
        return desenhoComponenteList;
    }

    public void setDesenhoComponenteList(List<DesenhoComponente> desenhoComponenteList) {
        this.desenhoComponenteList = desenhoComponenteList;
    }

    @XmlTransient
    public List<DimRetangular> getDimRetangularList() {
        return dimRetangularList;
    }

    public void setDimRetangularList(List<DimRetangular> dimRetangularList) {
        this.dimRetangularList = dimRetangularList;
    }

    public Sistema getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Sistema idSistema) {
        this.idSistema = idSistema;
    }

    public TipoComponente getIdTipoComponente() {
        return idTipoComponente;
    }

    public void setIdTipoComponente(TipoComponente idTipoComponente) {
        this.idTipoComponente = idTipoComponente;
    }

    @XmlTransient
    public List<Checklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(List<Checklist> checklistList) {
        this.checklistList = checklistList;
    }

    @XmlTransient
    public List<ProdutoComponente> getProdutoComponenteList() {
        return produtoComponenteList;
    }

    public void setProdutoComponenteList(List<ProdutoComponente> produtoComponenteList) {
        this.produtoComponenteList = produtoComponenteList;
    }

    @XmlTransient
    public List<VariacaoSimuladaComponente> getVariacaoSimuladaComponenteList() {
        return variacaoSimuladaComponenteList;
    }

    public void setVariacaoSimuladaComponenteList(List<VariacaoSimuladaComponente> variacaoSimuladaComponenteList) {
        this.variacaoSimuladaComponenteList = variacaoSimuladaComponenteList;
    }

    @XmlTransient
    public List<DimEsferico> getDimEsfericoList() {
        return dimEsfericoList;
    }

    public void setDimEsfericoList(List<DimEsferico> dimEsfericoList) {
        this.dimEsfericoList = dimEsfericoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponente != null ? idComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.idComponente == null && other.idComponente != null) || (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Componente[ idComponente=" + idComponente + " ]";
    }
    
}
