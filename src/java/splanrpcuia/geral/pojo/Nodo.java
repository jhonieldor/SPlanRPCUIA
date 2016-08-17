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
@Table(name = "nodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nodo.findAll", query = "SELECT n FROM Nodo n"),
    @NamedQuery(name = "Nodo.findByIdNodo", query = "SELECT n FROM Nodo n WHERE n.idNodo = :idNodo"),
    @NamedQuery(name = "Nodo.findByNumero", query = "SELECT n FROM Nodo n WHERE n.numero = :numero"),
    @NamedQuery(name = "Nodo.findByIdentificacao", query = "SELECT n FROM Nodo n WHERE n.identificacao = :identificacao"),
    @NamedQuery(name = "Nodo.findByConexaoLagoa", query = "SELECT n FROM Nodo n WHERE n.conexaoLagoa = :conexaoLagoa"),
    @NamedQuery(name = "Nodo.findByConexaoPoco", query = "SELECT n FROM Nodo n WHERE n.conexaoPoco = :conexaoPoco"),
    @NamedQuery(name = "Nodo.findByConexaoCisterna", query = "SELECT n FROM Nodo n WHERE n.conexaoCisterna = :conexaoCisterna"),
    @NamedQuery(name = "Nodo.findByConexaoSistemaRecalque", query = "SELECT n FROM Nodo n WHERE n.conexaoSistemaRecalque = :conexaoSistemaRecalque"),
    @NamedQuery(name = "Nodo.findByConexaoCaptacao", query = "SELECT n FROM Nodo n WHERE n.conexaoCaptacao = :conexaoCaptacao"),
    @NamedQuery(name = "Nodo.findByConexaoColetor", query = "SELECT n FROM Nodo n WHERE n.conexaoColetor = :conexaoColetor"),
    @NamedQuery(name = "Nodo.findByConexaoJuncao", query = "SELECT n FROM Nodo n WHERE n.conexaoJuncao = :conexaoJuncao"),
    @NamedQuery(name = "Nodo.findByConexaoSistemaJuncao", query = "SELECT n FROM Nodo n WHERE n.conexaoSistemaJuncao = :conexaoSistemaJuncao"),
    @NamedQuery(name = "Nodo.findByConexaoEta", query = "SELECT n FROM Nodo n WHERE n.conexaoEta = :conexaoEta"),
    @NamedQuery(name = "Nodo.findByConexaoEstacaoTratamento", query = "SELECT n FROM Nodo n WHERE n.conexaoEstacaoTratamento = :conexaoEstacaoTratamento")})
public class Nodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nodo")
    private Integer idNodo;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 50)
    @Column(name = "identificacao")
    private String identificacao;
    @Column(name = "conexao_lagoa")
    private Boolean conexaoLagoa;
    @Column(name = "conexao_poco")
    private Boolean conexaoPoco;
    @Column(name = "conexao_cisterna")
    private Boolean conexaoCisterna;
    @Column(name = "conexao_sistema_recalque")
    private Boolean conexaoSistemaRecalque;
    @Column(name = "conexao_captacao")
    private Boolean conexaoCaptacao;
    @Column(name = "conexao_coletor")
    private Boolean conexaoColetor;
    @Column(name = "conexao_juncao")
    private Boolean conexaoJuncao;
    @Column(name = "conexao_sistema_juncao")
    private Boolean conexaoSistemaJuncao;
    @Column(name = "conexao_eta")
    private Boolean conexaoEta;
    @Column(name = "conexao_estacao_tratamento")
    private Boolean conexaoEstacaoTratamento;
    @OneToMany(mappedBy = "destino")
    private List<Adutora> adutoraList;
    @OneToMany(mappedBy = "fonte")
    private List<Adutora> adutoraList1;
    @JoinColumn(name = "id_captacao", referencedColumnName = "id_captacao")
    @ManyToOne
    private Captacao idCaptacao;
    @JoinColumn(name = "id_cisterna", referencedColumnName = "id_cisterna")
    @ManyToOne
    private Cisterna idCisterna;
    @JoinColumn(name = "id_coletor", referencedColumnName = "id_coletor")
    @ManyToOne
    private Coletor idColetor;
    @JoinColumn(name = "id_estacao", referencedColumnName = "id_estacao")
    @ManyToOne
    private EstacaoTratamento idEstacao;
    @JoinColumn(name = "id_juncao", referencedColumnName = "id_juncao")
    @ManyToOne
    private Juncao idJuncao;
    @JoinColumn(name = "id_lagoa", referencedColumnName = "id_lagoa")
    @ManyToOne
    private Lagoa idLagoa;
    @JoinColumn(name = "id_poco", referencedColumnName = "id_poco")
    @ManyToOne
    private Poco idPoco;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;
    @JoinColumn(name = "id_sistema_juncao", referencedColumnName = "id_sistema_juncao")
    @ManyToOne
    private SistemaJuncao idSistemaJuncao;
    @JoinColumn(name = "id_sistema_recalque", referencedColumnName = "id_sistema_recalque")
    @ManyToOne
    private SistemaRecalque idSistemaRecalque;
    @OneToMany(mappedBy = "destino")
    private List<TubulacaoRedeReuso> tubulacaoRedeReusoList;
    @OneToMany(mappedBy = "origem")
    private List<TubulacaoRedeReuso> tubulacaoRedeReusoList1;
    @OneToMany(mappedBy = "destino")
    private List<TubulacaoHidraulica> tubulacaoHidraulicaList;
    @OneToMany(mappedBy = "origem")
    private List<TubulacaoHidraulica> tubulacaoHidraulicaList1;
    @OneToMany(mappedBy = "destino")
    private List<TubulacaoPneumatica> tubulacaoPneumaticaList;
    @OneToMany(mappedBy = "origem")
    private List<TubulacaoPneumatica> tubulacaoPneumaticaList1;
    @OneToMany(mappedBy = "idNodo")
    private List<Valvula> valvulaList;

    public Nodo() {
    }

    public Nodo(Integer idNodo) {
        this.idNodo = idNodo;
    }

    public Integer getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(Integer idNodo) {
        this.idNodo = idNodo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Boolean getConexaoLagoa() {
        return conexaoLagoa;
    }

    public void setConexaoLagoa(Boolean conexaoLagoa) {
        this.conexaoLagoa = conexaoLagoa;
    }

    public Boolean getConexaoPoco() {
        return conexaoPoco;
    }

    public void setConexaoPoco(Boolean conexaoPoco) {
        this.conexaoPoco = conexaoPoco;
    }

    public Boolean getConexaoCisterna() {
        return conexaoCisterna;
    }

    public void setConexaoCisterna(Boolean conexaoCisterna) {
        this.conexaoCisterna = conexaoCisterna;
    }

    public Boolean getConexaoSistemaRecalque() {
        return conexaoSistemaRecalque;
    }

    public void setConexaoSistemaRecalque(Boolean conexaoSistemaRecalque) {
        this.conexaoSistemaRecalque = conexaoSistemaRecalque;
    }

    public Boolean getConexaoCaptacao() {
        return conexaoCaptacao;
    }

    public void setConexaoCaptacao(Boolean conexaoCaptacao) {
        this.conexaoCaptacao = conexaoCaptacao;
    }

    public Boolean getConexaoColetor() {
        return conexaoColetor;
    }

    public void setConexaoColetor(Boolean conexaoColetor) {
        this.conexaoColetor = conexaoColetor;
    }

    public Boolean getConexaoJuncao() {
        return conexaoJuncao;
    }

    public void setConexaoJuncao(Boolean conexaoJuncao) {
        this.conexaoJuncao = conexaoJuncao;
    }

    public Boolean getConexaoSistemaJuncao() {
        return conexaoSistemaJuncao;
    }

    public void setConexaoSistemaJuncao(Boolean conexaoSistemaJuncao) {
        this.conexaoSistemaJuncao = conexaoSistemaJuncao;
    }

    public Boolean getConexaoEta() {
        return conexaoEta;
    }

    public void setConexaoEta(Boolean conexaoEta) {
        this.conexaoEta = conexaoEta;
    }

    public Boolean getConexaoEstacaoTratamento() {
        return conexaoEstacaoTratamento;
    }

    public void setConexaoEstacaoTratamento(Boolean conexaoEstacaoTratamento) {
        this.conexaoEstacaoTratamento = conexaoEstacaoTratamento;
    }

    @XmlTransient
    public List<Adutora> getAdutoraList() {
        return adutoraList;
    }

    public void setAdutoraList(List<Adutora> adutoraList) {
        this.adutoraList = adutoraList;
    }

    @XmlTransient
    public List<Adutora> getAdutoraList1() {
        return adutoraList1;
    }

    public void setAdutoraList1(List<Adutora> adutoraList1) {
        this.adutoraList1 = adutoraList1;
    }

    public Captacao getIdCaptacao() {
        return idCaptacao;
    }

    public void setIdCaptacao(Captacao idCaptacao) {
        this.idCaptacao = idCaptacao;
    }

    public Cisterna getIdCisterna() {
        return idCisterna;
    }

    public void setIdCisterna(Cisterna idCisterna) {
        this.idCisterna = idCisterna;
    }

    public Coletor getIdColetor() {
        return idColetor;
    }

    public void setIdColetor(Coletor idColetor) {
        this.idColetor = idColetor;
    }

    public EstacaoTratamento getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(EstacaoTratamento idEstacao) {
        this.idEstacao = idEstacao;
    }

    public Juncao getIdJuncao() {
        return idJuncao;
    }

    public void setIdJuncao(Juncao idJuncao) {
        this.idJuncao = idJuncao;
    }

    public Lagoa getIdLagoa() {
        return idLagoa;
    }

    public void setIdLagoa(Lagoa idLagoa) {
        this.idLagoa = idLagoa;
    }

    public Poco getIdPoco() {
        return idPoco;
    }

    public void setIdPoco(Poco idPoco) {
        this.idPoco = idPoco;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
        this.idRede = idRede;
    }

    public SistemaJuncao getIdSistemaJuncao() {
        return idSistemaJuncao;
    }

    public void setIdSistemaJuncao(SistemaJuncao idSistemaJuncao) {
        this.idSistemaJuncao = idSistemaJuncao;
    }

    public SistemaRecalque getIdSistemaRecalque() {
        return idSistemaRecalque;
    }

    public void setIdSistemaRecalque(SistemaRecalque idSistemaRecalque) {
        this.idSistemaRecalque = idSistemaRecalque;
    }

    @XmlTransient
    public List<TubulacaoRedeReuso> getTubulacaoRedeReusoList() {
        return tubulacaoRedeReusoList;
    }

    public void setTubulacaoRedeReusoList(List<TubulacaoRedeReuso> tubulacaoRedeReusoList) {
        this.tubulacaoRedeReusoList = tubulacaoRedeReusoList;
    }

    @XmlTransient
    public List<TubulacaoRedeReuso> getTubulacaoRedeReusoList1() {
        return tubulacaoRedeReusoList1;
    }

    public void setTubulacaoRedeReusoList1(List<TubulacaoRedeReuso> tubulacaoRedeReusoList1) {
        this.tubulacaoRedeReusoList1 = tubulacaoRedeReusoList1;
    }

    @XmlTransient
    public List<TubulacaoHidraulica> getTubulacaoHidraulicaList() {
        return tubulacaoHidraulicaList;
    }

    public void setTubulacaoHidraulicaList(List<TubulacaoHidraulica> tubulacaoHidraulicaList) {
        this.tubulacaoHidraulicaList = tubulacaoHidraulicaList;
    }

    @XmlTransient
    public List<TubulacaoHidraulica> getTubulacaoHidraulicaList1() {
        return tubulacaoHidraulicaList1;
    }

    public void setTubulacaoHidraulicaList1(List<TubulacaoHidraulica> tubulacaoHidraulicaList1) {
        this.tubulacaoHidraulicaList1 = tubulacaoHidraulicaList1;
    }

    @XmlTransient
    public List<TubulacaoPneumatica> getTubulacaoPneumaticaList() {
        return tubulacaoPneumaticaList;
    }

    public void setTubulacaoPneumaticaList(List<TubulacaoPneumatica> tubulacaoPneumaticaList) {
        this.tubulacaoPneumaticaList = tubulacaoPneumaticaList;
    }

    @XmlTransient
    public List<TubulacaoPneumatica> getTubulacaoPneumaticaList1() {
        return tubulacaoPneumaticaList1;
    }

    public void setTubulacaoPneumaticaList1(List<TubulacaoPneumatica> tubulacaoPneumaticaList1) {
        this.tubulacaoPneumaticaList1 = tubulacaoPneumaticaList1;
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
        hash += (idNodo != null ? idNodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nodo)) {
            return false;
        }
        Nodo other = (Nodo) object;
        if ((this.idNodo == null && other.idNodo != null) || (this.idNodo != null && !this.idNodo.equals(other.idNodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Nodo[ idNodo=" + idNodo + " ]";
    }
    
}
