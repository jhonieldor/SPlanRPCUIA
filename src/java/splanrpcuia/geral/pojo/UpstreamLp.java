/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splanrpcuia.geral.pojo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "upstream_lp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UpstreamLp.findAll", query = "SELECT u FROM UpstreamLp u"),
    @NamedQuery(name = "UpstreamLp.findByUpstream", query = "SELECT u FROM UpstreamLp u WHERE u.upstreamLpPK.upstream = :upstream"),
    @NamedQuery(name = "UpstreamLp.findByLinhaProducao", query = "SELECT u FROM UpstreamLp u WHERE u.upstreamLpPK.linhaProducao = :linhaProducao")})
public class UpstreamLp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UpstreamLpPK upstreamLpPK;

    public UpstreamLp() {
    }

    public UpstreamLp(UpstreamLpPK upstreamLpPK) {
        this.upstreamLpPK = upstreamLpPK;
    }

    public UpstreamLp(int upstream, int linhaProducao) {
        this.upstreamLpPK = new UpstreamLpPK(upstream, linhaProducao);
    }

    public UpstreamLpPK getUpstreamLpPK() {
        return upstreamLpPK;
    }

    public void setUpstreamLpPK(UpstreamLpPK upstreamLpPK) {
        this.upstreamLpPK = upstreamLpPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (upstreamLpPK != null ? upstreamLpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UpstreamLp)) {
            return false;
        }
        UpstreamLp other = (UpstreamLp) object;
        if ((this.upstreamLpPK == null && other.upstreamLpPK != null) || (this.upstreamLpPK != null && !this.upstreamLpPK.equals(other.upstreamLpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "splanrpcuia.geral.pojo.UpstreamLp[ upstreamLpPK=" + upstreamLpPK + " ]";
    }
    
}
