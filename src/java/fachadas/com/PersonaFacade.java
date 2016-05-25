/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas.com;

import database.com.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Developer
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "LibretaJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
     public List<Persona> findByBuscado(String buscado) {
                  
        return getEntityManager().createNamedQuery("Persona.findByBuscado",Persona.class).setParameter("buscado","%"+ buscado + "%").getResultList();
       
    }   
    
    // Persona.findByBuscado
    
    
    
}
