package br.com.adrianob.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author drink
 */
public class Manager {
    
    private EntityManager em;
    
    private static Manager instance = null;
    
    public static Manager getInstance(){
        if (instance==null) {
            instance = new Manager();
        }
        return instance;
    }
    
    private Manager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
