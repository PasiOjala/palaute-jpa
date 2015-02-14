/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palaute;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Pasi
 */
@Named
@RequestScoped
@Entity
@NamedQueries(
    {
        @NamedQuery(
            name="palauteP.haeKaikki",
            query="select p from PalautePersistent as p"
        )
    }
)
public class PalautePersistent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id     @GeneratedValue
    private Long id;
    private String palauteTeksti;

    
    public String getPalauteTeksti() {
        return palauteTeksti;
    }

    public void setPalauteTeksti(String palauteTeksti) {
        this.palauteTeksti = palauteTeksti;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PalautePersistent)) {
            return false;
        }
        PalautePersistent other = (PalautePersistent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "palaute.PalauteP[ id=" + id + " ]";
    }
    
}
