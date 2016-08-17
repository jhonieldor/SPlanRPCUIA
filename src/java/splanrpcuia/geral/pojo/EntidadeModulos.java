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
@Table(name = "entidade_modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadeModulos.findAll", query = "SELECT e FROM EntidadeModulos e"),
    @NamedQuery(name = "EntidadeModulos.findByIdEntidade", query = "SELECT e FROM EntidadeModulos e WHERE e.idEntidade = :idEntidade"),
    @NamedQuery(name = "EntidadeModulos.findByEntidade", query = "SELECT e FROM EntidadeModulos e WHERE e.entidade = :entidade"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleEstoque", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleEstoque = :acessoControleEstoque"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleUsuarios", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleUsuarios = :acessoControleUsuarios"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleSimulacoes", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleSimulacoes = :acessoControleSimulacoes"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleRecursosHidricos", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleRecursosHidricos = :acessoControleRecursosHidricos"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleHidraulico", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleHidraulico = :acessoControleHidraulico"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoPcp", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoPcp = :acessoPcp"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoPcm", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoPcm = :acessoPcm"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleEletrico", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleEletrico = :acessoControleEletrico"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoAnaliseProjetos", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoAnaliseProjetos = :acessoAnaliseProjetos"),
    @NamedQuery(name = "EntidadeModulos.findByAcessoControleAutomacao", query = "SELECT e FROM EntidadeModulos e WHERE e.acessoControleAutomacao = :acessoControleAutomacao")})
public class EntidadeModulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entidade")
    private Integer idEntidade;
    @Size(max = 20)
    @Column(name = "entidade")
    private String entidade;
    @Column(name = "acesso_controle_estoque")
    private Boolean acessoControleEstoque;
    @Column(name = "acesso_controle_usuarios")
    private Boolean acessoControleUsuarios;
    @Column(name = "acesso_controle_simulacoes")
    private Boolean acessoControleSimulacoes;
    @Column(name = "acesso_controle_recursos_hidricos")
    private Boolean acessoControleRecursosHidricos;
    @Column(name = "acesso_controle_hidraulico")
    private Boolean acessoControleHidraulico;
    @Column(name = "acesso_pcp")
    private Boolean acessoPcp;
    @Column(name = "acesso_pcm")
    private Boolean acessoPcm;
    @Column(name = "acesso_controle_eletrico")
    private Boolean acessoControleEletrico;
    @Column(name = "acesso_analise_projetos")
    private Boolean acessoAnaliseProjetos;
    @Column(name = "acesso_controle_automacao")
    private Boolean acessoControleAutomacao;
    @OneToMany(mappedBy = "idEntidade")
    private List<ControleModulos> controleModulosList;
    @OneToMany(mappedBy = "idEntidade")
    private List<SistemaJuncao> sistemaJuncaoList;
    @OneToMany(mappedBy = "idEntidade")
    private List<TipoRegistroTipoRede> tipoRegistroTipoRedeList;
    @OneToMany(mappedBy = "idEntidade")
    private List<TipoTubulacaoTipoRede> tipoTubulacaoTipoRedeList;
    @OneToMany(mappedBy = "idEntidade")
    private List<SistemaRecalque> sistemaRecalqueList;
    @OneToMany(mappedBy = "idEntidade")
    private List<TipoValvula> tipoValvulaList;
    @OneToMany(mappedBy = "idEntidade")
    private List<ItemSistemaRecalque> itemSistemaRecalqueList;
    @OneToMany(mappedBy = "idEntidade")
    private List<TipoJuncao> tipoJuncaoList;
    @OneToMany(mappedBy = "idEntidade")
    private List<TipoRegistro> tipoRegistroList;
    @OneToMany(mappedBy = "idEntidade")
    private List<Valvula> valvulaList;
    @OneToMany(mappedBy = "idEntidade")
    private List<TipoTubulacao> tipoTubulacaoList;

    public EntidadeModulos() {
    }

    public EntidadeModulos(Integer idEntidade) {
        this.idEntidade = idEntidade;
    }

    public Integer getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Integer idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public Boolean getAcessoControleEstoque() {
        return acessoControleEstoque;
    }

    public void setAcessoControleEstoque(Boolean acessoControleEstoque) {
        this.acessoControleEstoque = acessoControleEstoque;
    }

    public Boolean getAcessoControleUsuarios() {
        return acessoControleUsuarios;
    }

    public void setAcessoControleUsuarios(Boolean acessoControleUsuarios) {
        this.acessoControleUsuarios = acessoControleUsuarios;
    }

    public Boolean getAcessoControleSimulacoes() {
        return acessoControleSimulacoes;
    }

    public void setAcessoControleSimulacoes(Boolean acessoControleSimulacoes) {
        this.acessoControleSimulacoes = acessoControleSimulacoes;
    }

    public Boolean getAcessoControleRecursosHidricos() {
        return acessoControleRecursosHidricos;
    }

    public void setAcessoControleRecursosHidricos(Boolean acessoControleRecursosHidricos) {
        this.acessoControleRecursosHidricos = acessoControleRecursosHidricos;
    }

    public Boolean getAcessoControleHidraulico() {
        return acessoControleHidraulico;
    }

    public void setAcessoControleHidraulico(Boolean acessoControleHidraulico) {
        this.acessoControleHidraulico = acessoControleHidraulico;
    }

    public Boolean getAcessoPcp() {
        return acessoPcp;
    }

    public void setAcessoPcp(Boolean acessoPcp) {
        this.acessoPcp = acessoPcp;
    }

    public Boolean getAcessoPcm() {
        return acessoPcm;
    }

    public void setAcessoPcm(Boolean acessoPcm) {
        this.acessoPcm = acessoPcm;
    }

    public Boolean getAcessoControleEletrico() {
        return acessoControleEletrico;
    }

    public void setAcessoControleEletrico(Boolean acessoControleEletrico) {
        this.acessoControleEletrico = acessoControleEletrico;
    }

    public Boolean getAcessoAnaliseProjetos() {
        return acessoAnaliseProjetos;
    }

    public void setAcessoAnaliseProjetos(Boolean acessoAnaliseProjetos) {
        this.acessoAnaliseProjetos = acessoAnaliseProjetos;
    }

    public Boolean getAcessoControleAutomacao() {
        return acessoControleAutomacao;
    }

    public void setAcessoControleAutomacao(Boolean acessoControleAutomacao) {
        this.acessoControleAutomacao = acessoControleAutomacao;
    }

    @XmlTransient
    public List<ControleModulos> getControleModulosList() {
        return controleModulosList;
    }

    public void setControleModulosList(List<ControleModulos> controleModulosList) {
        this.controleModulosList = controleModulosList;
    }

    @XmlTransient
    public List<SistemaJuncao> getSistemaJuncaoList() {
        return sistemaJuncaoList;
    }

    public void setSistemaJuncaoList(List<SistemaJuncao> sistemaJuncaoList) {
        this.sistemaJuncaoList = sistemaJuncaoList;
    }

    @XmlTransient
    public List<TipoRegistroTipoRede> getTipoRegistroTipoRedeList() {
        return tipoRegistroTipoRedeList;
    }

    public void setTipoRegistroTipoRedeList(List<TipoRegistroTipoRede> tipoRegistroTipoRedeList) {
        this.tipoRegistroTipoRedeList = tipoRegistroTipoRedeList;
    }

    @XmlTransient
    public List<TipoTubulacaoTipoRede> getTipoTubulacaoTipoRedeList() {
        return tipoTubulacaoTipoRedeList;
    }

    public void setTipoTubulacaoTipoRedeList(List<TipoTubulacaoTipoRede> tipoTubulacaoTipoRedeList) {
        this.tipoTubulacaoTipoRedeList = tipoTubulacaoTipoRedeList;
    }

    @XmlTransient
    public List<SistemaRecalque> getSistemaRecalqueList() {
        return sistemaRecalqueList;
    }

    public void setSistemaRecalqueList(List<SistemaRecalque> sistemaRecalqueList) {
        this.sistemaRecalqueList = sistemaRecalqueList;
    }

    @XmlTransient
    public List<TipoValvula> getTipoValvulaList() {
        return tipoValvulaList;
    }

    public void setTipoValvulaList(List<TipoValvula> tipoValvulaList) {
        this.tipoValvulaList = tipoValvulaList;
    }

    @XmlTransient
    public List<ItemSistemaRecalque> getItemSistemaRecalqueList() {
        return itemSistemaRecalqueList;
    }

    public void setItemSistemaRecalqueList(List<ItemSistemaRecalque> itemSistemaRecalqueList) {
        this.itemSistemaRecalqueList = itemSistemaRecalqueList;
    }

    @XmlTransient
    public List<TipoJuncao> getTipoJuncaoList() {
        return tipoJuncaoList;
    }

    public void setTipoJuncaoList(List<TipoJuncao> tipoJuncaoList) {
        this.tipoJuncaoList = tipoJuncaoList;
    }

    @XmlTransient
    public List<TipoRegistro> getTipoRegistroList() {
        return tipoRegistroList;
    }

    public void setTipoRegistroList(List<TipoRegistro> tipoRegistroList) {
        this.tipoRegistroList = tipoRegistroList;
    }

    @XmlTransient
    public List<Valvula> getValvulaList() {
        return valvulaList;
    }

    public void setValvulaList(List<Valvula> valvulaList) {
        this.valvulaList = valvulaList;
    }

    @XmlTransient
    public List<TipoTubulacao> getTipoTubulacaoList() {
        return tipoTubulacaoList;
    }

    public void setTipoTubulacaoList(List<TipoTubulacao> tipoTubulacaoList) {
        this.tipoTubulacaoList = tipoTubulacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidade != null ? idEntidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadeModulos)) {
            return false;
        }
        EntidadeModulos other = (EntidadeModulos) object;
        if ((this.idEntidade == null && other.idEntidade != null) || (this.idEntidade != null && !this.idEntidade.equals(other.idEntidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.EntidadeModulos[ idEntidade=" + idEntidade + " ]";
    }
    
}
