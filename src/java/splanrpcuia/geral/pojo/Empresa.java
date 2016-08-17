/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByNome", query = "SELECT e FROM Empresa e WHERE e.nome = :nome"),
    @NamedQuery(name = "Empresa.findByLocalidade", query = "SELECT e FROM Empresa e WHERE e.localidade = :localidade"),
    @NamedQuery(name = "Empresa.findByUf", query = "SELECT e FROM Empresa e WHERE e.uf = :uf"),
    @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado"),
    @NamedQuery(name = "Empresa.findByPais", query = "SELECT e FROM Empresa e WHERE e.pais = :pais"),
    @NamedQuery(name = "Empresa.findByTerceirizada", query = "SELECT e FROM Empresa e WHERE e.terceirizada = :terceirizada")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "localidade")
    private String localidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "pais")
    private String pais;
    @Column(name = "terceirizada")
    private Boolean terceirizada;
    @JoinTable(name = "tipo_produto_fornecedores", joinColumns = {
        @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_empresa")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tipo_produto", referencedColumnName = "id_tipo_produto")})
    @ManyToMany
    private List<TipoProduto> tipoProdutoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empresa")
    private RankingFornecedor rankingFornecedor;
    @OneToMany(mappedBy = "idEmpresa")
    private List<CotacaoItem> cotacaoItemList;
    @JoinColumn(name = "tipo_empresa", referencedColumnName = "id_tipo")
    @ManyToOne
    private TipoEmpresa tipoEmpresa;
    @OneToMany(mappedBy = "idFornecedor")
    private List<Maquina> maquinaList;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Boolean getTerceirizada() {
        return terceirizada;
    }

    public void setTerceirizada(Boolean terceirizada) {
        this.terceirizada = terceirizada;
    }

    @XmlTransient
    public List<TipoProduto> getTipoProdutoList() {
        return tipoProdutoList;
    }

    public void setTipoProdutoList(List<TipoProduto> tipoProdutoList) {
        this.tipoProdutoList = tipoProdutoList;
    }

    public RankingFornecedor getRankingFornecedor() {
        return rankingFornecedor;
    }

    public void setRankingFornecedor(RankingFornecedor rankingFornecedor) {
        this.rankingFornecedor = rankingFornecedor;
    }

    @XmlTransient
    public List<CotacaoItem> getCotacaoItemList() {
        return cotacaoItemList;
    }

    public void setCotacaoItemList(List<CotacaoItem> cotacaoItemList) {
        this.cotacaoItemList = cotacaoItemList;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @XmlTransient
    public List<Maquina> getMaquinaList() {
        return maquinaList;
    }

    public void setMaquinaList(List<Maquina> maquinaList) {
        this.maquinaList = maquinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
