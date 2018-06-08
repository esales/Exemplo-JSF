package repositorio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Estado;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;

public class EstadoRepositorio {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstadoPU");
    private EntityManager entityManager;
            
    public EstadoRepositorio(){
        this.entityManager = emf.createEntityManager();
    }
    
    public void cadastrar(Estado estado){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(estado);
        this.entityManager.getTransaction().commit();
    }
    
    public void excluir(Estado estado){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(estado);
        this.entityManager.getTransaction().commit();
    }
    
    public void alterar(Estado estado){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(estado);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Estado> retornaTodos(){
        return this.entityManager.createQuery("from Estado").getResultList();
    }
}
