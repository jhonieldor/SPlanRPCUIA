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
@Table(name = "sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s"),
    @NamedQuery(name = "Sistema.findByIdSistema", query = "SELECT s FROM Sistema s WHERE s.idSistema = :idSistema"),
    @NamedQuery(name = "Sistema.findByNome", query = "SELECT s FROM Sistema s WHERE s.nome = :nome"),
    @NamedQuery(name = "Sistema.findByIdEspaco", query = "SELECT s FROM Sistema s WHERE s.idEspaco = :idEspaco"),
    @NamedQuery(name = "Sistema.findByLimiteInvestimento", query = "SELECT s FROM Sistema s WHERE s.limiteInvestimento = :limiteInvestimento"),
    @NamedQuery(name = "Sistema.findByPrazoImplementacao", query = "SELECT s FROM Sistema s WHERE s.prazoImplementacao = :prazoImplementacao")})
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistema")
    private Integer idSistema;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "id_espaco")
    private Integer idEspaco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_investimento")
    private BigDecimal limiteInvestimento;
    @Column(name = "prazo_implementacao")
    private BigDecimal prazoImplementacao;
    @JoinColumn(name = "tipo_sistema", referencedColumnName = "id_tipo_sistema")
    @ManyToOne
    private TipoSistema tipoSistema;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idSistema")
    private List<VariacaoSimuladaSistema> variacaoSimuladaSistemaList;
    @OneToMany(mappedBy = "idSistemaIntegrado")
    private List<SistemasIntegrados> sistemasIntegradosList;
    @OneToMany(mappedBy = "idSistema")
    private List<SistemasIntegrados> sistemasIntegradosList1;
    @OneToMany(mappedBy = "idSistema")
    private List<SimulacaoSistema> simulacaoSistemaList;
    @OneToMany(mappedBy = "idSistema")
    private List<Componente> componenteList;
    @OneToMany(mappedBy = "idSistema")
    private List<DesenhoSistema> desenhoSistemaList;

    public Sistema() {
    }

    public Sistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Integer idEspaco) {
        this.idEspaco = idEspaco;
    }

    public BigDecimal getLimiteInvestimento() {
        return limiteInvestimento;
    }

    public void setLimiteInvestimento(BigDecimal limiteInvestimento) {
        this.limiteInvestimento = limiteInvestimento;
    }

    public BigDecimal getPrazoImplementacao() {
        return prazoImplementacao;
    }

    public void setPrazoImplementacao(BigDecimal prazoImplementacao) {
        this.prazoImplementacao = prazoImplementacao;
    }

    public TipoSistema getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(TipoSistema tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<VariacaoSimuladaSistema> getVariacaoSimuladaSistemaList() {
        return variacaoSimuladaSistemaList;
    }

    public void setVariacaoSimuladaSistemaList(List<VariacaoSimuladaSistema> variacaoSimuladaSistemaList) {
        this.variacaoSimuladaSistemaList = variacaoSimuladaSistemaList;
    }

    @XmlTransient
    public List<SistemasIntegrados> getSistemasIntegradosList() {
        return sistemasIntegradosList;
    }

    public void setSistemasIntegradosList(List<SistemasIntegrados> sistemasIntegradosList) {
        this.sistemasIntegradosList = sistemasIntegradosList;
    }

    @XmlTransient
    public List<SistemasIntegrados> getSistemasIntegradosList1() {
        return sistemasIntegradosList1;
    }

    public void setSistemasIntegradosList1(List<SistemasIntegrados> sistemasIntegradosList1) {
        this.sistemasIntegradosList1 = sistemasIntegradosList1;
    }

    @XmlTransient
    public List<SimulacaoSistema> getSimulacaoSistemaList() {
        return simulacaoSistemaList;
    }

    public void setSimulacaoSistemaList(List<SimulacaoSistema> simulacaoSistemaList) {
        this.simulacaoSistemaList = simulacaoSistemaList;
    }

    @XmlTransient
    public List<Componente> getComponenteList() {
        return componenteList;
    }

    public void setComponenteList(List<Componente> componenteList) {
        this.componenteList = componenteList;
    }

    @XmlTransient
    public List<DesenhoSistema> getDesenhoSistemaList() {
        return desenhoSistemaList;
    }

    public void setDesenhoSistemaList(List<DesenhoSistema> desenhoSistemaList) {
        this.desenhoSistemaList = desenhoSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistema != null ? idSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.idSistema == null && other.idSistema != null) || (this.idSistema != null && !this.idSistema.equals(other.idSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Sistema[ idSistema=" + idSistema + " ]";
    }
    
}
