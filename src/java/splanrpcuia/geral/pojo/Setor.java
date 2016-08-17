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
import javax.persistence.ManyToMany;
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
@Table(name = "setor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s"),
    @NamedQuery(name = "Setor.findByIdSetor", query = "SELECT s FROM Setor s WHERE s.idSetor = :idSetor"),
    @NamedQuery(name = "Setor.findByNSetor", query = "SELECT s FROM Setor s WHERE s.nSetor = :nSetor"),
    @NamedQuery(name = "Setor.findByIdentificacao", query = "SELECT s FROM Setor s WHERE s.identificacao = :identificacao"),
    @NamedQuery(name = "Setor.findByNome", query = "SELECT s FROM Setor s WHERE s.nome = :nome"),
    @NamedQuery(name = "Setor.findByNomeEngUs", query = "SELECT s FROM Setor s WHERE s.nomeEngUs = :nomeEngUs"),
    @NamedQuery(name = "Setor.findByDescricao", query = "SELECT s FROM Setor s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Setor.findByAdministrativo", query = "SELECT s FROM Setor s WHERE s.administrativo = :administrativo"),
    @NamedQuery(name = "Setor.findBySanitario", query = "SELECT s FROM Setor s WHERE s.sanitario = :sanitario"),
    @NamedQuery(name = "Setor.findByAreaLimpa", query = "SELECT s FROM Setor s WHERE s.areaLimpa = :areaLimpa"),
    @NamedQuery(name = "Setor.findByEmbProdutoFechado", query = "SELECT s FROM Setor s WHERE s.embProdutoFechado = :embProdutoFechado"),
    @NamedQuery(name = "Setor.findByAreaSemProduto", query = "SELECT s FROM Setor s WHERE s.areaSemProduto = :areaSemProduto"),
    @NamedQuery(name = "Setor.findByAreaSuja", query = "SELECT s FROM Setor s WHERE s.areaSuja = :areaSuja"),
    @NamedQuery(name = "Setor.findBySetorProducao", query = "SELECT s FROM Setor s WHERE s.setorProducao = :setorProducao")})
public class Setor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_setor")
    private Integer idSetor;
    @Column(name = "n_setor")
    private Integer nSetor;
    @Size(max = 50)
    @Column(name = "identificacao")
    private String identificacao;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "nome_eng_us")
    private String nomeEngUs;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "administrativo")
    private Boolean administrativo;
    @Column(name = "sanitario")
    private Boolean sanitario;
    @Column(name = "area_limpa")
    private Boolean areaLimpa;
    @Column(name = "emb_produto_fechado")
    private Boolean embProdutoFechado;
    @Column(name = "area_sem_produto")
    private Boolean areaSemProduto;
    @Column(name = "area_suja")
    private Boolean areaSuja;
    @Column(name = "setor_producao")
    private Boolean setorProducao;
    @ManyToMany(mappedBy = "setorList")
    private List<RedePneumatica> redePneumaticaList;
    @OneToMany(mappedBy = "idSetor")
    private List<Transportador> transportadorList;
    @JoinColumn(name = "responsavel", referencedColumnName = "id_stakeholder")
    @ManyToOne
    private Stakeholder responsavel;
    @JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
    @ManyToOne
    private Unidade idUnidade;
    @OneToMany(mappedBy = "idSetor")
    private List<PontoHidraulico> pontoHidraulicoList;
    @OneToMany(mappedBy = "idSetor")
    private List<EquipamentoSetor> equipamentoSetorList;
    @OneToMany(mappedBy = "idSetor")
    private List<PontoPneumatico> pontoPneumaticoList;
    @OneToMany(mappedBy = "idSetor")
    private List<LinhaProducao> linhaProducaoList;
    @OneToMany(mappedBy = "idSetor")
    private List<Subsetor> subsetorList;
    @OneToMany(mappedBy = "idSetor")
    private List<Hidrometro> hidrometroList;

    public Setor() {
    }

    public Setor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Integer getNSetor() {
        return nSetor;
    }

    public void setNSetor(Integer nSetor) {
        this.nSetor = nSetor;
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

    public String getNomeEngUs() {
        return nomeEngUs;
    }

    public void setNomeEngUs(String nomeEngUs) {
        this.nomeEngUs = nomeEngUs;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Boolean administrativo) {
        this.administrativo = administrativo;
    }

    public Boolean getSanitario() {
        return sanitario;
    }

    public void setSanitario(Boolean sanitario) {
        this.sanitario = sanitario;
    }

    public Boolean getAreaLimpa() {
        return areaLimpa;
    }

    public void setAreaLimpa(Boolean areaLimpa) {
        this.areaLimpa = areaLimpa;
    }

    public Boolean getEmbProdutoFechado() {
        return embProdutoFechado;
    }

    public void setEmbProdutoFechado(Boolean embProdutoFechado) {
        this.embProdutoFechado = embProdutoFechado;
    }

    public Boolean getAreaSemProduto() {
        return areaSemProduto;
    }

    public void setAreaSemProduto(Boolean areaSemProduto) {
        this.areaSemProduto = areaSemProduto;
    }

    public Boolean getAreaSuja() {
        return areaSuja;
    }

    public void setAreaSuja(Boolean areaSuja) {
        this.areaSuja = areaSuja;
    }

    public Boolean getSetorProducao() {
        return setorProducao;
    }

    public void setSetorProducao(Boolean setorProducao) {
        this.setorProducao = setorProducao;
    }

    @XmlTransient
    public List<RedePneumatica> getRedePneumaticaList() {
        return redePneumaticaList;
    }

    public void setRedePneumaticaList(List<RedePneumatica> redePneumaticaList) {
        this.redePneumaticaList = redePneumaticaList;
    }

    @XmlTransient
    public List<Transportador> getTransportadorList() {
        return transportadorList;
    }

    public void setTransportadorList(List<Transportador> transportadorList) {
        this.transportadorList = transportadorList;
    }

    public Stakeholder getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Stakeholder responsavel) {
        this.responsavel = responsavel;
    }

    public Unidade getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Unidade idUnidade) {
        this.idUnidade = idUnidade;
    }

    @XmlTransient
    public List<PontoHidraulico> getPontoHidraulicoList() {
        return pontoHidraulicoList;
    }

    public void setPontoHidraulicoList(List<PontoHidraulico> pontoHidraulicoList) {
        this.pontoHidraulicoList = pontoHidraulicoList;
    }

    @XmlTransient
    public List<EquipamentoSetor> getEquipamentoSetorList() {
        return equipamentoSetorList;
    }

    public void setEquipamentoSetorList(List<EquipamentoSetor> equipamentoSetorList) {
        this.equipamentoSetorList = equipamentoSetorList;
    }

    @XmlTransient
    public List<PontoPneumatico> getPontoPneumaticoList() {
        return pontoPneumaticoList;
    }

    public void setPontoPneumaticoList(List<PontoPneumatico> pontoPneumaticoList) {
        this.pontoPneumaticoList = pontoPneumaticoList;
    }

    @XmlTransient
    public List<LinhaProducao> getLinhaProducaoList() {
        return linhaProducaoList;
    }

    public void setLinhaProducaoList(List<LinhaProducao> linhaProducaoList) {
        this.linhaProducaoList = linhaProducaoList;
    }

    @XmlTransient
    public List<Subsetor> getSubsetorList() {
        return subsetorList;
    }

    public void setSubsetorList(List<Subsetor> subsetorList) {
        this.subsetorList = subsetorList;
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
        hash += (idSetor != null ? idSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.idSetor == null && other.idSetor != null) || (this.idSetor != null && !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Setor[ idSetor=" + idSetor + " ]";
    }
    
}
