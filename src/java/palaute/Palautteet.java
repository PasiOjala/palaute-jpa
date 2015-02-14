/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palaute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;


@Named
@Stateless

public class Palautteet implements Serializable {

    @PersistenceContext
    EntityManager em;
//    @Inject
//    Palaute palaute;

//    @OneToMany(mappedBy="tuoteryhmä",fetch=EAGER)
////    ArrayList<PalauteP> kaikkiPalautteet=new ArrayList<>();
//    public ArrayList<PalauteP> getKaikkiPalautteet() {
//        return kaikkiPalautteet;
//    }
//
//    public void setKaikkiPalautteet(ArrayList<PalauteP> kaikkiPalautteet) {
//        this.kaikkiPalautteet = kaikkiPalautteet;
//    }
    
    public void lisää(PalautePersistent palaute){
        em.persist(palaute);
    }
    
        @Produces @Named("kaikkiPalautteet")
    public List<PalautePersistent> haePalautteet() {
        List<PalautePersistent> ret= em
            .createNamedQuery(
                "palauteP.haeKaikki", 
                PalautePersistent.class)
            .getResultList();
        return ret;
    }
}