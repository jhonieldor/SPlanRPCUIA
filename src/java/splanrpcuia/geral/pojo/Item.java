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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIdItem", query = "SELECT i FROM Item i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "Item.findByNome", query = "SELECT i FROM Item i WHERE i.nome = :nome"),
    @NamedQuery(name = "Item.findByFabricante", query = "SELECT i FROM Item i WHERE i.fabricante = :fabricante"),
    @NamedQuery(name = "Item.findByDescricao", query = "SELECT i FROM Item i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Item.findByCodigoBarras", query = "SELECT i FROM Item i WHERE i.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "Item.findByAtivo", query = "SELECT i FROM Item i WHERE i.ativo = :ativo")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "fabricante")
    private String fabricante;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 20)
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "ativo")
    private Boolean ativo;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria_item")
    @ManyToOne
    private CategoriaItem idCategoria;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private GrupoItem idGrupo;
    @JoinColumn(name = "marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca marca;
    @JoinColumn(name = "id_subcategoria", referencedColumnName = "id_subcategoria_item")
    @ManyToOne
    private SubcategoriaItem idSubcategoria;
    @JoinColumn(name = "tipo_item", referencedColumnName = "id_tipo")
    @ManyToOne
    private TipoItem tipoItem;
    @OneToMany(mappedBy = "idItem")
    private List<LocalizacaoItem> localizacaoItemList;
    @OneToMany(mappedBy = "idItem")
    private List<ChecklistComponente> checklistComponenteList;
    @OneToMany(mappedBy = "idItem")
    private List<CotacaoItem> cotacaoItemList;
    @OneToMany(mappedBy = "idItem")
    private List<AjusteEstoque> ajusteEstoqueList;
    @OneToMany(mappedBy = "idItem")
    private List<ItemMaquina> itemMaquinaList;
    @OneToMany(mappedBy = "idItem")
    private List<Hidrometro> hidrometroList;

    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public CategoriaItem getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaItem idCategoria) {
        this.idCategoria = idCategoria;
    }

    public GrupoItem getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(GrupoItem idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public SubcategoriaItem getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(SubcategoriaItem idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    @XmlTransient
    public List<LocalizacaoItem> getLocalizacaoItemList() {
        return localizacaoItemList;
    }

    public void setLocalizacaoItemList(List<LocalizacaoItem> localizacaoItemList) {
        this.localizacaoItemList = localizacaoItemList;
    }

    @XmlTransient
    public List<ChecklistComponente> getChecklistComponenteList() {
        return checklistComponenteList;
    }

    public void setChecklistComponenteList(List<ChecklistComponente> checklistComponenteList) {
        this.checklistComponenteList = checklistComponenteList;
    }

    @XmlTransient
    public List<CotacaoItem> getCotacaoItemList() {
        return cotacaoItemList;
    }

    public void setCotacaoItemList(List<CotacaoItem> cotacaoItemList) {
        this.cotacaoItemList = cotacaoItemList;
    }

    @XmlTransient
    public List<AjusteEstoque> getAjusteEstoqueList() {
        return ajusteEstoqueList;
    }

    public void setAjusteEstoqueList(List<AjusteEstoque> ajusteEstoqueList) {
        this.ajusteEstoqueList = ajusteEstoqueList;
    }

    @XmlTransient
    public List<ItemMaquina> getItemMaquinaList() {
        return itemMaquinaList;
    }

    public void setItemMaquinaList(List<ItemMaquina> itemMaquinaList) {
        this.itemMaquinaList = itemMaquinaList;
    }

    @XmlTransient
    public List<Hidrometro> getHidrometroList() {
        return hidrometroList;
    }

    public void setHidrometroList(List<Hidrometro> hidrometroList) {
        this.hidrometroList = hidrometroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Item[ idItem=" + idItem + " ]";
    }
    
}
