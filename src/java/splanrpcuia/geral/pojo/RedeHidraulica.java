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
import javax.persistence.JoinColumns;
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
@Table(name = "rede_hidraulica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeHidraulica.findAll", query = "SELECT r FROM RedeHidraulica r"),
    @NamedQuery(name = "RedeHidraulica.findByIdRede", query = "SELECT r FROM RedeHidraulica r WHERE r.idRede = :idRede"),
    @NamedQuery(name = "RedeHidraulica.findByRede", query = "SELECT r FROM RedeHidraulica r WHERE r.rede = :rede"),
    @NamedQuery(name = "RedeHidraulica.findByAtiva", query = "SELECT r FROM RedeHidraulica r WHERE r.ativa = :ativa")})
public class RedeHidraulica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rede")
    private Integer idRede;
    @Size(max = 200)
    @Column(name = "rede")
    private String rede;
    @Column(name = "ativa")
    private Boolean ativa;
    @OneToMany(mappedBy = "idRede")
    private List<PontoHidraulico> pontoHidraulicoList;
    @OneToMany(mappedBy = "idRede")
    private List<TubulacaoHidraulica> tubulacaoHidraulicaList;
    @OneToMany(mappedBy = "idRede")
    private List<Juncao> juncaoList;
    @JoinColumns({
        @JoinColumn(name = "id_reservatorio", referencedColumnName = "id_reservatorio"),
        @JoinColumn(name = "id_fonte", referencedColumnName = "id_fonte")})
    @ManyToOne
    private FonteReservatorio fonteReservatorio;
    @JoinColumn(name = "id_subunidade", referencedColumnName = "id_unidade_predial")
    @ManyToOne
    private SubUnidade idSubunidade;
    @JoinColumn(name = "id_tipo_rede", referencedColumnName = "id_tipo_rede")
    @ManyToOne
    private TipoRede idTipoRede;

    public RedeHidraulica() {
    }

    public RedeHidraulica(Integer idRede) {
        this.idRede = idRede;
    }

    public Integer getIdRede() {
        return idRede;
    }

    public void setIdRede(Integer idRede) {
        this.idRede = idRede;
    }

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    @XmlTransient
    public List<PontoHidraulico> getPontoHidraulicoList() {
        return pontoHidraulicoList;
    }

    public void setPontoHidraulicoList(List<PontoHidraulico> pontoHidraulicoList) {
        this.pontoHidraulicoList = pontoHidraulicoList;
    }

    @XmlTransient
    public List<TubulacaoHidraulica> getTubulacaoHidraulicaList() {
        return tubulacaoHidraulicaList;
    }

    public void setTubulacaoHidraulicaList(List<TubulacaoHidraulica> tubulacaoHidraulicaList) {
        this.tubulacaoHidraulicaList = tubulacaoHidraulicaList;
    }

    @XmlTransient
    public List<Juncao> getJuncaoList() {
        return juncaoList;
    }

    public void setJuncaoList(List<Juncao> juncaoList) {
        this.juncaoList = juncaoList;
    }

    public FonteReservatorio getFonteReservatorio() {
        return fonteReservatorio;
    }

    public void setFonteReservatorio(FonteReservatorio fonteReservatorio) {
        this.fonteReservatorio = fonteReservatorio;
    }

    public SubUnidade getIdSubunidade() {
        return idSubunidade;
    }

    public void setIdSubunidade(SubUnidade idSubunidade) {
        this.idSubunidade = idSubunidade;
    }

    public TipoRede getIdTipoRede() {
        return idTipoRede;
    }

    public void setIdTipoRede(TipoRede idTipoRede) {
        this.idTipoRede = idTipoRede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRede != null ? idRede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeHidraulica)) {
            return false;
        }
        RedeHidraulica other = (RedeHidraulica) object;
        if ((this.idRede == null && other.idRede != null) || (this.idRede != null && !this.idRede.equals(other.idRede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.RedeHidraulica[ idRede=" + idRede + " ]";
    }
    
}
