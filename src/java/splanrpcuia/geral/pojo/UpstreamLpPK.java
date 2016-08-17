/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrador
 */
@Embeddable
public class UpstreamLpPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "upstream")
    private int upstream;
    @Basic(optional = false)
    @NotNull
    @Column(name = "linha_producao")
    private int linhaProducao;

    public UpstreamLpPK() {
    }

    public UpstreamLpPK(int upstream, int linhaProducao) {
        this.upstream = upstream;
        this.linhaProducao = linhaProducao;
    }

    public int getUpstream() {
        return upstream;
    }

    public void setUpstream(int upstream) {
        this.upstream = upstream;
    }

    public int getLinhaProducao() {
        return linhaProducao;
    }

    public void setLinhaProducao(int linhaProducao) {
        this.linhaProducao = linhaProducao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) upstream;
        hash += (int) linhaProducao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UpstreamLpPK)) {
            return false;
        }
        UpstreamLpPK other = (UpstreamLpPK) object;
        if (this.upstream != other.upstream) {
            return false;
        }
        if (this.linhaProducao != other.linhaProducao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.UpstreamLpPK[ upstream=" + upstream + ", linhaProducao=" + linhaProducao + " ]";
    }
    
}
