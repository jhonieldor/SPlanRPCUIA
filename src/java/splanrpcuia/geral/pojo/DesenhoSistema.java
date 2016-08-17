/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "desenho_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesenhoSistema.findAll", query = "SELECT d FROM DesenhoSistema d"),
    @NamedQuery(name = "DesenhoSistema.findByIdDesenhoSistema", query = "SELECT d FROM DesenhoSistema d WHERE d.idDesenhoSistema = :idDesenhoSistema"),
    @NamedQuery(name = "DesenhoSistema.findByVersao", query = "SELECT d FROM DesenhoSistema d WHERE d.versao = :versao"),
    @NamedQuery(name = "DesenhoSistema.findByIdentificacao", query = "SELECT d FROM DesenhoSistema d WHERE d.identificacao = :identificacao"),
    @NamedQuery(name = "DesenhoSistema.findByDataDesenho", query = "SELECT d FROM DesenhoSistema d WHERE d.dataDesenho = :dataDesenho")})
public class DesenhoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desenho_sistema")
    private Integer idDesenhoSistema;
    @Size(max = 10)
    @Column(name = "versao")
    private String versao;
    @Size(max = 50)
    @Column(name = "identificacao")
    private String identificacao;
    @Column(name = "data_desenho")
    @Temporal(TemporalType.DATE)
    private Date dataDesenho;
    @Lob
    @Column(name = "arquivo_dwg")
    private byte[] arquivoDwg;
    @Lob
    @Column(name = "imagem_desenho")
    private byte[] imagemDesenho;
    @JoinColumn(name = "id_sistema", referencedColumnName = "id_sistema")
    @ManyToOne
    private Sistema idSistema;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public DesenhoSistema() {
    }

    public DesenhoSistema(Integer idDesenhoSistema) {
        this.idDesenhoSistema = idDesenhoSistema;
    }

    public Integer getIdDesenhoSistema() {
        return idDesenhoSistema;
    }

    public void setIdDesenhoSistema(Integer idDesenhoSistema) {
        this.idDesenhoSistema = idDesenhoSistema;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Date getDataDesenho() {
        return dataDesenho;
    }

    public void setDataDesenho(Date dataDesenho) {
        this.dataDesenho = dataDesenho;
    }

    public byte[] getArquivoDwg() {
        return arquivoDwg;
    }

    public void setArquivoDwg(byte[] arquivoDwg) {
        this.arquivoDwg = arquivoDwg;
    }

    public byte[] getImagemDesenho() {
        return imagemDesenho;
    }

    public void setImagemDesenho(byte[] imagemDesenho) {
        this.imagemDesenho = imagemDesenho;
    }

    public Sistema getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Sistema idSistema) {
        this.idSistema = idSistema;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesenhoSistema != null ? idDesenhoSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesenhoSistema)) {
            return false;
        }
        DesenhoSistema other = (DesenhoSistema) object;
        if ((this.idDesenhoSistema == null && other.idDesenhoSistema != null) || (this.idDesenhoSistema != null && !this.idDesenhoSistema.equals(other.idDesenhoSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.DesenhoSistema[ idDesenhoSistema=" + idDesenhoSistema + " ]";
    }
    
}
