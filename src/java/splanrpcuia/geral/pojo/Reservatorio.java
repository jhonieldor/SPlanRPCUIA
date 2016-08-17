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
import javax.persistence.CascadeType;
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
@Table(name = "reservatorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservatorio.findAll", query = "SELECT r FROM Reservatorio r"),
    @NamedQuery(name = "Reservatorio.findByIdReservatorio", query = "SELECT r FROM Reservatorio r WHERE r.idReservatorio = :idReservatorio"),
    @NamedQuery(name = "Reservatorio.findByCapacidadeLitros", query = "SELECT r FROM Reservatorio r WHERE r.capacidadeLitros = :capacidadeLitros"),
    @NamedQuery(name = "Reservatorio.findByCapacidadeVolume", query = "SELECT r FROM Reservatorio r WHERE r.capacidadeVolume = :capacidadeVolume"),
    @NamedQuery(name = "Reservatorio.findByReservatorio", query = "SELECT r FROM Reservatorio r WHERE r.reservatorio = :reservatorio"),
    @NamedQuery(name = "Reservatorio.findByDescricao", query = "SELECT r FROM Reservatorio r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "Reservatorio.findByDiametro", query = "SELECT r FROM Reservatorio r WHERE r.diametro = :diametro"),
    @NamedQuery(name = "Reservatorio.findByAltura", query = "SELECT r FROM Reservatorio r WHERE r.altura = :altura")})
public class Reservatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reservatorio")
    private Integer idReservatorio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capacidade_litros")
    private BigDecimal capacidadeLitros;
    @Column(name = "capacidade_volume")
    private BigDecimal capacidadeVolume;
    @Size(max = 200)
    @Column(name = "reservatorio")
    private String reservatorio;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "diametro")
    private BigDecimal diametro;
    @Column(name = "altura")
    private BigDecimal altura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservatorio")
    private List<FonteReservatorio> fonteReservatorioList;
    @JoinColumn(name = "id_tipo_reservatorio", referencedColumnName = "id_tipo_reservatorio")
    @ManyToOne
    private TipoReservatorio idTipoReservatorio;

    public Reservatorio() {
    }

    public Reservatorio(Integer idReservatorio) {
        this.idReservatorio = idReservatorio;
    }

    public Integer getIdReservatorio() {
        return idReservatorio;
    }

    public void setIdReservatorio(Integer idReservatorio) {
        this.idReservatorio = idReservatorio;
    }

    public BigDecimal getCapacidadeLitros() {
        return capacidadeLitros;
    }

    public void setCapacidadeLitros(BigDecimal capacidadeLitros) {
        this.capacidadeLitros = capacidadeLitros;
    }

    public BigDecimal getCapacidadeVolume() {
        return capacidadeVolume;
    }

    public void setCapacidadeVolume(BigDecimal capacidadeVolume) {
        this.capacidadeVolume = capacidadeVolume;
    }

    public String getReservatorio() {
        return reservatorio;
    }

    public void setReservatorio(String reservatorio) {
        this.reservatorio = reservatorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getDiametro() {
        return diametro;
    }

    public void setDiametro(BigDecimal diametro) {
        this.diametro = diametro;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    @XmlTransient
    public List<FonteReservatorio> getFonteReservatorioList() {
        return fonteReservatorioList;
    }

    public void setFonteReservatorioList(List<FonteReservatorio> fonteReservatorioList) {
        this.fonteReservatorioList = fonteReservatorioList;
    }

    public TipoReservatorio getIdTipoReservatorio() {
        return idTipoReservatorio;
    }

    public void setIdTipoReservatorio(TipoReservatorio idTipoReservatorio) {
        this.idTipoReservatorio = idTipoReservatorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservatorio != null ? idReservatorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservatorio)) {
            return false;
        }
        Reservatorio other = (Reservatorio) object;
        if ((this.idReservatorio == null && other.idReservatorio != null) || (this.idReservatorio != null && !this.idReservatorio.equals(other.idReservatorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Reservatorio[ idReservatorio=" + idReservatorio + " ]";
    }
    
}
