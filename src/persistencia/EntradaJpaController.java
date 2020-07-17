/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Articulo;
import modelo.DevolucionEntrada;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Entrada;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author luisalvaranleav
 */
public class EntradaJpaController implements Serializable {

    /******************************************************/
    
    public EntradaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPS_entrega0PU");
    }
    
    /******************************************************/
    
    public EntradaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entrada entrada) {
        if (entrada.getDevolucionEntradaCollection() == null) {
            entrada.setDevolucionEntradaCollection(new ArrayList<DevolucionEntrada>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Articulo idArticulo = entrada.getIdArticulo();
            if (idArticulo != null) {
                idArticulo = em.getReference(idArticulo.getClass(), idArticulo.getIdArticulo());
                entrada.setIdArticulo(idArticulo);
            }
            Collection<DevolucionEntrada> attachedDevolucionEntradaCollection = new ArrayList<DevolucionEntrada>();
            for (DevolucionEntrada devolucionEntradaCollectionDevolucionEntradaToAttach : entrada.getDevolucionEntradaCollection()) {
                devolucionEntradaCollectionDevolucionEntradaToAttach = em.getReference(devolucionEntradaCollectionDevolucionEntradaToAttach.getClass(), devolucionEntradaCollectionDevolucionEntradaToAttach.getIdDevolucionEntrada());
                attachedDevolucionEntradaCollection.add(devolucionEntradaCollectionDevolucionEntradaToAttach);
            }
            entrada.setDevolucionEntradaCollection(attachedDevolucionEntradaCollection);
            em.persist(entrada);
            if (idArticulo != null) {
                idArticulo.getEntradaCollection().add(entrada);
                idArticulo = em.merge(idArticulo);
            }
            for (DevolucionEntrada devolucionEntradaCollectionDevolucionEntrada : entrada.getDevolucionEntradaCollection()) {
                Entrada oldIdEntradaOfDevolucionEntradaCollectionDevolucionEntrada = devolucionEntradaCollectionDevolucionEntrada.getIdEntrada();
                devolucionEntradaCollectionDevolucionEntrada.setIdEntrada(entrada);
                devolucionEntradaCollectionDevolucionEntrada = em.merge(devolucionEntradaCollectionDevolucionEntrada);
                if (oldIdEntradaOfDevolucionEntradaCollectionDevolucionEntrada != null) {
                    oldIdEntradaOfDevolucionEntradaCollectionDevolucionEntrada.getDevolucionEntradaCollection().remove(devolucionEntradaCollectionDevolucionEntrada);
                    oldIdEntradaOfDevolucionEntradaCollectionDevolucionEntrada = em.merge(oldIdEntradaOfDevolucionEntradaCollectionDevolucionEntrada);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entrada entrada) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrada persistentEntrada = em.find(Entrada.class, entrada.getIdEntrada());
            Articulo idArticuloOld = persistentEntrada.getIdArticulo();
            Articulo idArticuloNew = entrada.getIdArticulo();
            Collection<DevolucionEntrada> devolucionEntradaCollectionOld = persistentEntrada.getDevolucionEntradaCollection();
            Collection<DevolucionEntrada> devolucionEntradaCollectionNew = entrada.getDevolucionEntradaCollection();
            List<String> illegalOrphanMessages = null;
            for (DevolucionEntrada devolucionEntradaCollectionOldDevolucionEntrada : devolucionEntradaCollectionOld) {
                if (!devolucionEntradaCollectionNew.contains(devolucionEntradaCollectionOldDevolucionEntrada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DevolucionEntrada " + devolucionEntradaCollectionOldDevolucionEntrada + " since its idEntrada field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idArticuloNew != null) {
                idArticuloNew = em.getReference(idArticuloNew.getClass(), idArticuloNew.getIdArticulo());
                entrada.setIdArticulo(idArticuloNew);
            }
            Collection<DevolucionEntrada> attachedDevolucionEntradaCollectionNew = new ArrayList<DevolucionEntrada>();
            for (DevolucionEntrada devolucionEntradaCollectionNewDevolucionEntradaToAttach : devolucionEntradaCollectionNew) {
                devolucionEntradaCollectionNewDevolucionEntradaToAttach = em.getReference(devolucionEntradaCollectionNewDevolucionEntradaToAttach.getClass(), devolucionEntradaCollectionNewDevolucionEntradaToAttach.getIdDevolucionEntrada());
                attachedDevolucionEntradaCollectionNew.add(devolucionEntradaCollectionNewDevolucionEntradaToAttach);
            }
            devolucionEntradaCollectionNew = attachedDevolucionEntradaCollectionNew;
            entrada.setDevolucionEntradaCollection(devolucionEntradaCollectionNew);
            entrada = em.merge(entrada);
            if (idArticuloOld != null && !idArticuloOld.equals(idArticuloNew)) {
                idArticuloOld.getEntradaCollection().remove(entrada);
                idArticuloOld = em.merge(idArticuloOld);
            }
            if (idArticuloNew != null && !idArticuloNew.equals(idArticuloOld)) {
                idArticuloNew.getEntradaCollection().add(entrada);
                idArticuloNew = em.merge(idArticuloNew);
            }
            for (DevolucionEntrada devolucionEntradaCollectionNewDevolucionEntrada : devolucionEntradaCollectionNew) {
                if (!devolucionEntradaCollectionOld.contains(devolucionEntradaCollectionNewDevolucionEntrada)) {
                    Entrada oldIdEntradaOfDevolucionEntradaCollectionNewDevolucionEntrada = devolucionEntradaCollectionNewDevolucionEntrada.getIdEntrada();
                    devolucionEntradaCollectionNewDevolucionEntrada.setIdEntrada(entrada);
                    devolucionEntradaCollectionNewDevolucionEntrada = em.merge(devolucionEntradaCollectionNewDevolucionEntrada);
                    if (oldIdEntradaOfDevolucionEntradaCollectionNewDevolucionEntrada != null && !oldIdEntradaOfDevolucionEntradaCollectionNewDevolucionEntrada.equals(entrada)) {
                        oldIdEntradaOfDevolucionEntradaCollectionNewDevolucionEntrada.getDevolucionEntradaCollection().remove(devolucionEntradaCollectionNewDevolucionEntrada);
                        oldIdEntradaOfDevolucionEntradaCollectionNewDevolucionEntrada = em.merge(oldIdEntradaOfDevolucionEntradaCollectionNewDevolucionEntrada);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entrada.getIdEntrada();
                if (findEntrada(id) == null) {
                    throw new NonexistentEntityException("The entrada with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrada entrada;
            try {
                entrada = em.getReference(Entrada.class, id);
                entrada.getIdEntrada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entrada with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DevolucionEntrada> devolucionEntradaCollectionOrphanCheck = entrada.getDevolucionEntradaCollection();
            for (DevolucionEntrada devolucionEntradaCollectionOrphanCheckDevolucionEntrada : devolucionEntradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Entrada (" + entrada + ") cannot be destroyed since the DevolucionEntrada " + devolucionEntradaCollectionOrphanCheckDevolucionEntrada + " in its devolucionEntradaCollection field has a non-nullable idEntrada field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Articulo idArticulo = entrada.getIdArticulo();
            if (idArticulo != null) {
                idArticulo.getEntradaCollection().remove(entrada);
                idArticulo = em.merge(idArticulo);
            }
            em.remove(entrada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entrada> findEntradaEntities() {
        return findEntradaEntities(true, -1, -1);
    }

    public List<Entrada> findEntradaEntities(int maxResults, int firstResult) {
        return findEntradaEntities(false, maxResults, firstResult);
    }

    private List<Entrada> findEntradaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entrada.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Entrada findEntrada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entrada.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntradaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entrada> rt = cq.from(Entrada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
