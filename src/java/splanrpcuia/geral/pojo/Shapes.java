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
@Table(name = "shapes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shapes.findAll", query = "SELECT s FROM Shapes s"),
    @NamedQuery(name = "Shapes.findByIdShape", query = "SELECT s FROM Shapes s WHERE s.idShape = :idShape"),
    @NamedQuery(name = "Shapes.findByShape", query = "SELECT s FROM Shapes s WHERE s.shape = :shape")})
public class Shapes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_shape")
    private Integer idShape;
    @Size(max = 20)
    @Column(name = "shape")
    private String shape;

    public Shapes() {
    }

    public Shapes(Integer idShape) {
        this.idShape = idShape;
    }

    public Integer getIdShape() {
        return idShape;
    }

    public void setIdShape(Integer idShape) {
        this.idShape = idShape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShape != null ? idShape.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shapes)) {
            return false;
        }
        Shapes other = (Shapes) object;
        if ((this.idShape == null && other.idShape != null) || (this.idShape != null && !this.idShape.equals(other.idShape))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.Shapes[ idShape=" + idShape + " ]";
    }
    
}
