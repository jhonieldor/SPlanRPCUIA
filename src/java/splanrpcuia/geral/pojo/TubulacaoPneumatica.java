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
@Table(name = "tubulacao_pneumatica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TubulacaoPneumatica.findAll", query = "SELECT t FROM TubulacaoPneumatica t"),
    @NamedQuery(name = "TubulacaoPneumatica.findByIdTubulacao", query = "SELECT t FROM TubulacaoPneumatica t WHERE t.idTubulacao = :idTubulacao"),
    @NamedQuery(name = "TubulacaoPneumatica.findByComprimento", query = "SELECT t FROM TubulacaoPneumatica t WHERE t.comprimento = :comprimento"),
    @NamedQuery(name = "TubulacaoPneumatica.findByInclinacao", query = "SELECT t FROM TubulacaoPneumatica t WHERE t.inclinacao = :inclinacao"),
    @NamedQuery(name = "TubulacaoPneumatica.findByBitola", query = "SELECT t FROM TubulacaoPneumatica t WHERE t.bitola = :bitola")})
public class TubulacaoPneumatica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tubulacao")
    private Integer idTubulacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comprimento")
    private Double comprimento;
    @Column(name = "inclinacao")
    private Double inclinacao;
    @Size(max = 50)
    @Column(name = "bitola")
    private String bitola;
    @OneToMany(mappedBy = "idTubulacao")
    private List<PontoPneumatico> pontoPneumaticoList;
    @JoinColumn(name = "destino", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo destino;
    @JoinColumn(name = "origem", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo origem;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede_pneumatica")
    @ManyToOne
    private RedePneumatica idRede;
    @JoinColumn(name = "id_tipo_tubulacao", referencedColumnName = "id_tipo_tubulacao")
    @ManyToOne
    private TipoTubulacao idTipoTubulacao;

    public TubulacaoPneumatica() {
    }

    public TubulacaoPneumatica(Integer idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    public Integer getIdTubulacao() {
        return idTubulacao;
    }

    public void setIdTubulacao(Integer idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getInclinacao() {
        return inclinacao;
    }

    public void setInclinacao(Double inclinacao) {
        this.inclinacao = inclinacao;
    }

    public String getBitola() {
        return bitola;
    }

    public void setBitola(String bitola) {
        this.bitola = bitola;
    }

    @XmlTransient
    public List<PontoPneumatico> getPontoPneumaticoList() {
        return pontoPneumaticoList;
    }

    public void setPontoPneumaticoList(List<PontoPneumatico> pontoPneumaticoList) {
        this.pontoPneumaticoList = pontoPneumaticoList;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public Nodo getOrigem() {
        return origem;
    }

    public void setOrigem(Nodo origem) {
        this.origem = origem;
    }

    public RedePneumatica getIdRede() {
        return idRede;
    }

    public void setIdRede(RedePneumatica idRede) {
        this.idRede = idRede;
    }

    public TipoTubulacao getIdTipoTubulacao() {
        return idTipoTubulacao;
    }

    public void setIdTipoTubulacao(TipoTubulacao idTipoTubulacao) {
        this.idTipoTubulacao = idTipoTubulacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTubulacao != null ? idTubulacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TubulacaoPneumatica)) {
            return false;
        }
        TubulacaoPneumatica other = (TubulacaoPneumatica) object;
        if ((this.idTubulacao == null && other.idTubulacao != null) || (this.idTubulacao != null && !this.idTubulacao.equals(other.idTubulacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.TubulacaoPneumatica[ idTubulacao=" + idTubulacao + " ]";
    }
    
}
