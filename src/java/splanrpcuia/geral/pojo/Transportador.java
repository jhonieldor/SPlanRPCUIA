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
@Table(name = "transportador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportador.findAll", query = "SELECT t FROM Transportador t"),
    @NamedQuery(name = "Transportador.findByIdTransportador", query = "SELECT t FROM Transportador t WHERE t.idTransportador = :idTransportador"),
    @NamedQuery(name = "Transportador.findByNome", query = "SELECT t FROM Transportador t WHERE t.nome = :nome"),
    @NamedQuery(name = "Transportador.findByIdentificacao", query = "SELECT t FROM Transportador t WHERE t.identificacao = :identificacao")})
public class Transportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transportador")
    private Integer idTransportador;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 20)
    @Column(name = "identificacao")
    private String identificacao;
    @JoinColumn(name = "destino", referencedColumnName = "id_equipamento_setor")
    @ManyToOne
    private EquipamentoSetor destino;
    @JoinColumn(name = "origem", referencedColumnName = "id_equipamento_setor")
    @ManyToOne
    private EquipamentoSetor origem;
    @JoinColumn(name = "id_linha", referencedColumnName = "id_linha")
    @ManyToOne
    private LinhaProducao idLinha;
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetor;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo_transportador")
    @ManyToOne
    private TipoTransportador idTipo;
    @OneToMany(mappedBy = "idTransportador")
    private List<PontoHidraulico> pontoHidraulicoList;
    @OneToMany(mappedBy = "idTransportador")
    private List<PontoPneumatico> pontoPneumaticoList;

    public Transportador() {
    }

    public Transportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public Integer getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public EquipamentoSetor getDestino() {
        return destino;
    }

    public void setDestino(EquipamentoSetor destino) {
        this.destino = destino;
    }

    public EquipamentoSetor getOrigem() {
        return origem;
    }

    public void setOrigem(EquipamentoSetor origem) {
        this.origem = origem;
    }

    public LinhaProducao getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(LinhaProducao idLinha) {
        this.idLinha = idLinha;
    }

    public Setor getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
    }

    public TipoTransportador getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoTransportador idTipo) {
        this.idTipo = idTipo;
    }

    @XmlTransient
    public List<PontoHidraulico> getPontoHidraulicoList() {
        return pontoHidraulicoList;
    }

    public void setPontoHidraulicoList(List<PontoHidraulico> pontoHidraulicoList) {
        this.pontoHidraulicoList = pontoHidraulicoList;
    }

    @XmlTransient
    public List<PontoPneumatico> getPontoPneumaticoList() {
        return pontoPneumaticoList;
    }

    public void setPontoPneumaticoList(List<PontoPneumatico> pontoPneumaticoList) {
        this.pontoPneumaticoList = pontoPneumaticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransportador != null ? idTransportador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportador)) {
            return false;
        }
        Transportador other = (Transportador) object;
        if ((this.idTransportador == null && other.idTransportador != null) || (this.idTransportador != null && !this.idTransportador.equals(other.idTransportador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Transportador[ idTransportador=" + idTransportador + " ]";
    }
    
}
