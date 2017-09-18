
package br.com.adrianob.dao;

import br.com.adrianob.model.Produto;
import br.com.adrianob.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author drink
 */
public class DaoProduto {
    
    private EntityManager em;

    public DaoProduto() {
        em = Manager.getInstance().getEm();
    }
       
    
    public void salvar(Produto p) {
        em.getTransaction().begin();
        if (p.getCodigo()>0) {
            p = em.merge(p);
        }
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public List<Produto> getAll(){
        Query qry = em.createQuery("Select p from br.com.adrianob.model.Produto p ");
        List produtos = qry.getResultList();
         return (List<Produto>) produtos;     
    }
    
    public void remover(Produto p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
}
