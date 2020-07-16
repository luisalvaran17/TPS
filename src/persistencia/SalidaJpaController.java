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
import modelo.DevolucionSalida;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Salida;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author luisalvaranleav
 */
public class SalidaJpaController implements Serializable {
    
    
     public SalidaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPS_entrega0PU");
    }

    public SalidaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Salida salida) {
        if (salida.getDevolucionSalidaCollection() == null) {
            salida.setDevolucionSalidaCollection(new ArrayList<DevolucionSalida>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Articulo idArticulo = salida.getIdArticulo();
            if (idArticulo != null) {
                idArticulo = em.getReference(idArticulo.getClass(), idArticulo.getIdArticulo());
                salida.setIdArticulo(idArticulo);
            }
            Collection<DevolucionSalida> attachedDevolucionSalidaCollection = new ArrayList<DevolucionSalida>();
            for (DevolucionSalida devolucionSalidaCollectionDevolucionSalidaToAttach : salida.getDevolucionSalidaCollection()) {
                devolucionSalidaCollectionDevolucionSalidaToAttach = em.getReference(devolucionSalidaCollectionDevolucionSalidaToAttach.getClass(), devolucionSalidaCollectionDevolucionSalidaToAttach.getIdDevolucionSalida());
                attachedDevolucionSalidaCollection.add(devolucionSalidaCollectionDevolucionSalidaToAttach);
            }
            salida.setDevolucionSalidaCollection(attachedDevolucionSalidaCollection);
            em.persist(salida);
            if (idArticulo != null) {
                idArticulo.getSalidaCollection().add(salida);
                idArticulo = em.merge(idArticulo);
            }
            for (DevolucionSalida devolucionSalidaCollectionDevolucionSalida : salida.getDevolucionSalidaCollection()) {
                Salida oldIdSalidaOfDevolucionSalidaCollectionDevolucionSalida = devolucionSalidaCollectionDevolucionSalida.getIdSalida();
                devolucionSalidaCollectionDevolucionSalida.setIdSalida(salida);
                devolucionSalidaCollectionDevolucionSalida = em.merge(devolucionSalidaCollectionDevolucionSalida);
                if (oldIdSalidaOfDevolucionSalidaCollectionDevolucionSalida != null) {
                    oldIdSalidaOfDevolucionSalidaCollectionDevolucionSalida.getDevolucionSalidaCollection().remove(devolucionSalidaCollectionDevolucionSalida);
                    oldIdSalidaOfDevolucionSalidaCollectionDevolucionSalida = em.merge(oldIdSalidaOfDevolucionSalidaCollectionDevolucionSalida);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Salida salida) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Salida persistentSalida = em.find(Salida.class, salida.getIdSalida());
            Articulo idArticuloOld = persistentSalida.getIdArticulo();
            Articulo idArticuloNew = salida.getIdArticulo();
            Collection<DevolucionSalida> devolucionSalidaCollectionOld = persistentSalida.getDevolucionSalidaCollection();
            Collection<DevolucionSalida> devolucionSalidaCollectionNew = salida.getDevolucionSalidaCollection();
            List<String> illegalOrphanMessages = null;
            for (DevolucionSalida devolucionSalidaCollectionOldDevolucionSalida : devolucionSalidaCollectionOld) {
                if (!devolucionSalidaCollectionNew.contains(devolucionSalidaCollectionOldDevolucionSalida)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DevolucionSalida " + devolucionSalidaCollectionOldDevolucionSalida + " since its idSalida field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idArticuloNew != null) {
                idArticuloNew = em.getReference(idArticuloNew.getClass(), idArticuloNew.getIdArticulo());
                salida.setIdArticulo(idArticuloNew);
            }
            Collection<DevolucionSalida> attachedDevolucionSalidaCollectionNew = new ArrayList<DevolucionSalida>();
            for (DevolucionSalida devolucionSalidaCollectionNewDevolucionSalidaToAttach : devolucionSalidaCollectionNew) {
                devolucionSalidaCollectionNewDevolucionSalidaToAttach = em.getReference(devolucionSalidaCollectionNewDevolucionSalidaToAttach.getClass(), devolucionSalidaCollectionNewDevolucionSalidaToAttach.getIdDevolucionSalida());
                attachedDevolucionSalidaCollectionNew.add(devolucionSalidaCollectionNewDevolucionSalidaToAttach);
            }
            devolucionSalidaCollectionNew = attachedDevolucionSalidaCollectionNew;
            salida.setDevolucionSalidaCollection(devolucionSalidaCollectionNew);
            salida = em.merge(salida);
            if (idArticuloOld != null && !idArticuloOld.equals(idArticuloNew)) {
                idArticuloOld.getSalidaCollection().remove(salida);
                idArticuloOld = em.merge(idArticuloOld);
            }
            if (idArticuloNew != null && !idArticuloNew.equals(idArticuloOld)) {
                idArticuloNew.getSalidaCollection().add(salida);
                idArticuloNew = em.merge(idArticuloNew);
            }
            for (DevolucionSalida devolucionSalidaCollectionNewDevolucionSalida : devolucionSalidaCollectionNew) {
                if (!devolucionSalidaCollectionOld.contains(devolucionSalidaCollectionNewDevolucionSalida)) {
                    Salida oldIdSalidaOfDevolucionSalidaCollectionNewDevolucionSalida = devolucionSalidaCollectionNewDevolucionSalida.getIdSalida();
                    devolucionSalidaCollectionNewDevolucionSalida.setIdSalida(salida);
                    devolucionSalidaCollectionNewDevolucionSalida = em.merge(devolucionSalidaCollectionNewDevolucionSalida);
                    if (oldIdSalidaOfDevolucionSalidaCollectionNewDevolucionSalida != null && !oldIdSalidaOfDevolucionSalidaCollectionNewDevolucionSalida.equals(salida)) {
                        oldIdSalidaOfDevolucionSalidaCollectionNewDevolucionSalida.getDevolucionSalidaCollection().remove(devolucionSalidaCollectionNewDevolucionSalida);
                        oldIdSalidaOfDevolucionSalidaCollectionNewDevolucionSalida = em.merge(oldIdSalidaOfDevolucionSalidaCollectionNewDevolucionSalida);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = salida.getIdSalida();
                if (findSalida(id) == null) {
                    throw new NonexistentEntityException("The salida with id " + id + " no longer exists.");
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
            Salida salida;
            try {
                salida = em.getReference(Salida.class, id);
                salida.getIdSalida();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salida with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DevolucionSalida> devolucionSalidaCollectionOrphanCheck = salida.getDevolucionSalidaCollection();
            for (DevolucionSalida devolucionSalidaCollectionOrphanCheckDevolucionSalida : devolucionSalidaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Salida (" + salida + ") cannot be destroyed since the DevolucionSalida " + devolucionSalidaCollectionOrphanCheckDevolucionSalida + " in its devolucionSalidaCollection field has a non-nullable idSalida field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Articulo idArticulo = salida.getIdArticulo();
            if (idArticulo != null) {
                idArticulo.getSalidaCollection().remove(salida);
                idArticulo = em.merge(idArticulo);
            }
            em.remove(salida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Salida> findSalidaEntities() {
        return findSalidaEntities(true, -1, -1);
    }

    public List<Salida> findSalidaEntities(int maxResults, int firstResult) {
        return findSalidaEntities(false, maxResults, firstResult);
    }

    private List<Salida> findSalidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Salida.class));
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

    public Salida findSalida(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Salida.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Salida> rt = cq.from(Salida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
