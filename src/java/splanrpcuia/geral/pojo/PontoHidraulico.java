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
@Table(name = "ponto_hidraulico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PontoHidraulico.findAll", query = "SELECT p FROM PontoHidraulico p"),
    @NamedQuery(name = "PontoHidraulico.findByIdPonto", query = "SELECT p FROM PontoHidraulico p WHERE p.idPonto = :idPonto"),
    @NamedQuery(name = "PontoHidraulico.findByIdentificacao", query = "SELECT p FROM PontoHidraulico p WHERE p.identificacao = :identificacao"),
    @NamedQuery(name = "PontoHidraulico.findByDescricaoPosicao", query = "SELECT p FROM PontoHidraulico p WHERE p.descricaoPosicao = :descricaoPosicao"),
    @NamedQuery(name = "PontoHidraulico.findByBitola", query = "SELECT p FROM PontoHidraulico p WHERE p.bitola = :bitola"),
    @NamedQuery(name = "PontoHidraulico.findByConexaoEquipamento", query = "SELECT p FROM PontoHidraulico p WHERE p.conexaoEquipamento = :conexaoEquipamento"),
    @NamedQuery(name = "PontoHidraulico.findByPontoAtivo", query = "SELECT p FROM PontoHidraulico p WHERE p.pontoAtivo = :pontoAtivo"),
    @NamedQuery(name = "PontoHidraulico.findByProxLinha", query = "SELECT p FROM PontoHidraulico p WHERE p.proxLinha = :proxLinha"),
    @NamedQuery(name = "PontoHidraulico.findByContatoProduto", query = "SELECT p FROM PontoHidraulico p WHERE p.contatoProduto = :contatoProduto"),
    @NamedQuery(name = "PontoHidraulico.findByExigenciaSif", query = "SELECT p FROM PontoHidraulico p WHERE p.exigenciaSif = :exigenciaSif")})
public class PontoHidraulico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ponto")
    private Integer idPonto;
    @Size(max = 20)
    @Column(name = "identificacao")
    private String identificacao;
    @Size(max = 50)
    @Column(name = "descricao_posicao")
    private String descricaoPosicao;
    @Size(max = 20)
    @Column(name = "bitola")
    private String bitola;
    @Column(name = "conexao_equipamento")
    private Boolean conexaoEquipamento;
    @Column(name = "ponto_ativo")
    private Boolean pontoAtivo;
    @Column(name = "prox_linha")
    private Boolean proxLinha;
    @Column(name = "contato_produto")
    private Boolean contatoProduto;
    @Column(name = "exigencia_sif")
    private Boolean exigenciaSif;
    @JoinColumn(name = "id_equipamento_setor", referencedColumnName = "id_equipamento_setor")
    @ManyToOne
    private EquipamentoSetor idEquipamentoSetor;
    @JoinColumn(name = "id_linha", referencedColumnName = "id_linha")
    @ManyToOne
    private LinhaProducao idLinha;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeHidraulica idRede;
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetor;
    @JoinColumn(name = "id_transportador", referencedColumnName = "id_transportador")
    @ManyToOne
    private Transportador idTransportador;
    @JoinColumn(name = "id_tubulacao", referencedColumnName = "id_tubulacao")
    @ManyToOne
    private TubulacaoHidraulica idTubulacao;

    public PontoHidraulico() {
    }

    public PontoHidraulico(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDescricaoPosicao() {
        return descricaoPosicao;
    }

    public void setDescricaoPosicao(String descricaoPosicao) {
        this.descricaoPosicao = descricaoPosicao;
    }

    public String getBitola() {
        return bitola;
    }

    public void setBitola(String bitola) {
        this.bitola = bitola;
    }

    public Boolean getConexaoEquipamento() {
        return conexaoEquipamento;
    }

    public void setConexaoEquipamento(Boolean conexaoEquipamento) {
        this.conexaoEquipamento = conexaoEquipamento;
    }

    public Boolean getPontoAtivo() {
        return pontoAtivo;
    }

    public void setPontoAtivo(Boolean pontoAtivo) {
        this.pontoAtivo = pontoAtivo;
    }

    public Boolean getProxLinha() {
        return proxLinha;
    }

    public void setProxLinha(Boolean proxLinha) {
        this.proxLinha = proxLinha;
    }

    public Boolean getContatoProduto() {
        return contatoProduto;
    }

    public void setContatoProduto(Boolean contatoProduto) {
        this.contatoProduto = contatoProduto;
    }

    public Boolean getExigenciaSif() {
        return exigenciaSif;
    }

    public void setExigenciaSif(Boolean exigenciaSif) {
        this.exigenciaSif = exigenciaSif;
    }

    public EquipamentoSetor getIdEquipamentoSetor() {
        return idEquipamentoSetor;
    }

    public void setIdEquipamentoSetor(EquipamentoSetor idEquipamentoSetor) {
        this.idEquipamentoSetor = idEquipamentoSetor;
    }

    public LinhaProducao getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(LinhaProducao idLinha) {
        this.idLinha = idLinha;
    }

    public RedeHidraulica getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeHidraulica idRede) {
        this.idRede = idRede;
    }

    public Setor getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
    }

    public Transportador getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(Transportador idTransportador) {
        this.idTransportador = idTransportador;
    }

    public TubulacaoHidraulica getIdTubulacao() {
        return idTubulacao;
    }

    public void setIdTubulacao(TubulacaoHidraulica idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPonto != null ? idPonto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PontoHidraulico)) {
            return false;
        }
        PontoHidraulico other = (PontoHidraulico) object;
        if ((this.idPonto == null && other.idPonto != null) || (this.idPonto != null && !this.idPonto.equals(other.idPonto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.PontoHidraulico[ idPonto=" + idPonto + " ]";
    }
    
}
