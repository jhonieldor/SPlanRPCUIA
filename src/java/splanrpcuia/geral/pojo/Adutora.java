/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "adutora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adutora.findAll", query = "SELECT a FROM Adutora a"),
    @NamedQuery(name = "Adutora.findByIdTubulacao", query = "SELECT a FROM Adutora a WHERE a.idTubulacao = :idTubulacao"),
    @NamedQuery(name = "Adutora.findByTubulacao", query = "SELECT a FROM Adutora a WHERE a.tubulacao = :tubulacao"),
    @NamedQuery(name = "Adutora.findByComprimento", query = "SELECT a FROM Adutora a WHERE a.comprimento = :comprimento"),
    @NamedQuery(name = "Adutora.findByNivelOrigem", query = "SELECT a FROM Adutora a WHERE a.nivelOrigem = :nivelOrigem"),
    @NamedQuery(name = "Adutora.findByNivelDestino", query = "SELECT a FROM Adutora a WHERE a.nivelDestino = :nivelDestino")})
public class Adutora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tubulacao")
    private Integer idTubulacao;
    @Size(max = 50)
    @Column(name = "tubulacao")
    private String tubulacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comprimento")
    private BigDecimal comprimento;
    @Column(name = "nivel_origem")
    private BigDecimal nivelOrigem;
    @Column(name = "nivel_destino")
    private BigDecimal nivelDestino;
    @JoinColumn(name = "destino", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo destino;
    @JoinColumn(name = "fonte", referencedColumnName = "id_nodo")
    @ManyToOne
    private Nodo fonte;
    @JoinColumn(name = "id_rede", referencedColumnName = "id_rede")
    @ManyToOne
    private RedeCaptacao idRede;
    @JoinColumn(name = "id_tipo_tubulacao", referencedColumnName = "id_tipo_tubulacao")
    @ManyToOne
    private TipoTubulacao idTipoTubulacao;

    public Adutora() {
    }

    public Adutora(Integer idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    public Integer getIdTubulacao() {
        return idTubulacao;
    }

    public void setIdTubulacao(Integer idTubulacao) {
        this.idTubulacao = idTubulacao;
    }

    public String getTubulacao() {
        return tubulacao;
    }

    public void setTubulacao(String tubulacao) {
        this.tubulacao = tubulacao;
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public void setComprimento(BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

    public BigDecimal getNivelOrigem() {
        return nivelOrigem;
    }

    public void setNivelOrigem(BigDecimal nivelOrigem) {
        this.nivelOrigem = nivelOrigem;
    }

    public BigDecimal getNivelDestino() {
        return nivelDestino;
    }

    public void setNivelDestino(BigDecimal nivelDestino) {
        this.nivelDestino = nivelDestino;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public Nodo getFonte() {
        return fonte;
    }

    public void setFonte(Nodo fonte) {
        this.fonte = fonte;
    }

    public RedeCaptacao getIdRede() {
        return idRede;
    }

    public void setIdRede(RedeCaptacao idRede) {
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
        if (!(object instanceof Adutora)) {
            return false;
        }
        Adutora other = (Adutora) object;
        if ((this.idTubulacao == null && other.idTubulacao != null) || (this.idTubulacao != null && !this.idTubulacao.equals(other.idTubulacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Adutora[ idTubulacao=" + idTubulacao + " ]";
    }
    
}
