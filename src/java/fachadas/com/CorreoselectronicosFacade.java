/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas.com;

import database.com.Correoselectronicos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Developer
 */
@Stateless
public class CorreoselectronicosFacade extends AbstractFacade<Correoselectronicos> {
    @PersistenceContext(unitName = "LibretaJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreoselectronicosFacade() {
        super(Correoselectronicos.class);
    }
    
}
