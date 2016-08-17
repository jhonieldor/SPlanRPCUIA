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
@Table(name = "desenho_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesenhoComponente.findAll", query = "SELECT d FROM DesenhoComponente d"),
    @NamedQuery(name = "DesenhoComponente.findByIdDesenhoComponente", query = "SELECT d FROM DesenhoComponente d WHERE d.idDesenhoComponente = :idDesenhoComponente"),
    @NamedQuery(name = "DesenhoComponente.findByVersao", query = "SELECT d FROM DesenhoComponente d WHERE d.versao = :versao"),
    @NamedQuery(name = "DesenhoComponente.findByIdentificacao", query = "SELECT d FROM DesenhoComponente d WHERE d.identificacao = :identificacao"),
    @NamedQuery(name = "DesenhoComponente.findByDataDesenho", query = "SELECT d FROM DesenhoComponente d WHERE d.dataDesenho = :dataDesenho")})
public class DesenhoComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desenho_componente")
    private Integer idDesenhoComponente;
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
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne
    private Componente idComponente;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public DesenhoComponente() {
    }

    public DesenhoComponente(Integer idDesenhoComponente) {
        this.idDesenhoComponente = idDesenhoComponente;
    }

    public Integer getIdDesenhoComponente() {
        return idDesenhoComponente;
    }

    public void setIdDesenhoComponente(Integer idDesenhoComponente) {
        this.idDesenhoComponente = idDesenhoComponente;
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

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
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
        hash += (idDesenhoComponente != null ? idDesenhoComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesenhoComponente)) {
            return false;
        }
        DesenhoComponente other = (DesenhoComponente) object;
        if ((this.idDesenhoComponente == null && other.idDesenhoComponente != null) || (this.idDesenhoComponente != null && !this.idDesenhoComponente.equals(other.idDesenhoComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.DesenhoComponente[ idDesenhoComponente=" + idDesenhoComponente + " ]";
    }
    
}
