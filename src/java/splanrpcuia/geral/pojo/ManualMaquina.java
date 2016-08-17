/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "manual_maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ManualMaquina.findAll", query = "SELECT m FROM ManualMaquina m"),
    @NamedQuery(name = "ManualMaquina.findByIdManual", query = "SELECT m FROM ManualMaquina m WHERE m.idManual = :idManual"),
    @NamedQuery(name = "ManualMaquina.findByDataManual", query = "SELECT m FROM ManualMaquina m WHERE m.dataManual = :dataManual"),
    @NamedQuery(name = "ManualMaquina.findByVersao", query = "SELECT m FROM ManualMaquina m WHERE m.versao = :versao"),
    @NamedQuery(name = "ManualMaquina.findByNome", query = "SELECT m FROM ManualMaquina m WHERE m.nome = :nome"),
    @NamedQuery(name = "ManualMaquina.findByDescricao", query = "SELECT m FROM ManualMaquina m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "ManualMaquina.findByParametros", query = "SELECT m FROM ManualMaquina m WHERE m.parametros = :parametros"),
    @NamedQuery(name = "ManualMaquina.findByDetalhes", query = "SELECT m FROM ManualMaquina m WHERE m.detalhes = :detalhes")})
public class ManualMaquina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_manual")
    private Integer idManual;
    @Column(name = "data_manual")
    @Temporal(TemporalType.DATE)
    private Date dataManual;
    @Size(max = 20)
    @Column(name = "versao")
    private String versao;
    @Size(max = 80)
    @Column(name = "nome")
    private String nome;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 500)
    @Column(name = "parametros")
    private String parametros;
    @Size(max = 500)
    @Column(name = "detalhes")
    private String detalhes;
    @Lob
    @Column(name = "desenho")
    private byte[] desenho;
    @Lob
    @Column(name = "arquivo_pdf")
    private byte[] arquivoPdf;
    @JoinColumn(name = "id_maquina", referencedColumnName = "id_maquina")
    @ManyToOne
    private Maquina idMaquina;
    @OneToMany(mappedBy = "idManual")
    private List<ChecklistMaquina> checklistMaquinaList;

    public ManualMaquina() {
    }

    public ManualMaquina(Integer idManual) {
        this.idManual = idManual;
    }

    public Integer getIdManual() {
        return idManual;
    }

    public void setIdManual(Integer idManual) {
        this.idManual = idManual;
    }

    public Date getDataManual() {
        return dataManual;
    }

    public void setDataManual(Date dataManual) {
        this.dataManual = dataManual;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public byte[] getDesenho() {
        return desenho;
    }

    public void setDesenho(byte[] desenho) {
        this.desenho = desenho;
    }

    public byte[] getArquivoPdf() {
        return arquivoPdf;
    }

    public void setArquivoPdf(byte[] arquivoPdf) {
        this.arquivoPdf = arquivoPdf;
    }

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
    }

    @XmlTransient
    public List<ChecklistMaquina> getChecklistMaquinaList() {
        return checklistMaquinaList;
    }

    public void setChecklistMaquinaList(List<ChecklistMaquina> checklistMaquinaList) {
        this.checklistMaquinaList = checklistMaquinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManual != null ? idManual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManualMaquina)) {
            return false;
        }
        ManualMaquina other = (ManualMaquina) object;
        if ((this.idManual == null && other.idManual != null) || (this.idManual != null && !this.idManual.equals(other.idManual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.ManualMaquina[ idManual=" + idManual + " ]";
    }
    
}
