/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.DevolucionSalida;
import modelo.Salida;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author luisalvaranleav
 */
public class DevolucionSalidaJpaController implements Serializable {

     public DevolucionSalidaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPS_entrega0PU");
    }
    
    public DevolucionSalidaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DevolucionSalida devolucionSalida) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Salida idSalida = devolucionSalida.getIdSalida();
            if (idSalida != null) {
                idSalida = em.getReference(idSalida.getClass(), idSalida.getIdSalida());
                devolucionSalida.setIdSalida(idSalida);
            }
            em.persist(devolucionSalida);
            if (idSalida != null) {
                idSalida.getDevolucionSalidaCollection().add(devolucionSalida);
                idSalida = em.merge(idSalida);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DevolucionSalida devolucionSalida) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DevolucionSalida persistentDevolucionSalida = em.find(DevolucionSalida.class, devolucionSalida.getIdDevolucionSalida());
            Salida idSalidaOld = persistentDevolucionSalida.getIdSalida();
            Salida idSalidaNew = devolucionSalida.getIdSalida();
            if (idSalidaNew != null) {
                idSalidaNew = em.getReference(idSalidaNew.getClass(), idSalidaNew.getIdSalida());
                devolucionSalida.setIdSalida(idSalidaNew);
            }
            devolucionSalida = em.merge(devolucionSalida);
            if (idSalidaOld != null && !idSalidaOld.equals(idSalidaNew)) {
                idSalidaOld.getDevolucionSalidaCollection().remove(devolucionSalida);
                idSalidaOld = em.merge(idSalidaOld);
            }
            if (idSalidaNew != null && !idSalidaNew.equals(idSalidaOld)) {
                idSalidaNew.getDevolucionSalidaCollection().add(devolucionSalida);
                idSalidaNew = em.merge(idSalidaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = devolucionSalida.getIdDevolucionSalida();
                if (findDevolucionSalida(id) == null) {
                    throw new NonexistentEntityException("The devolucionSalida with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DevolucionSalida devolucionSalida;
            try {
                devolucionSalida = em.getReference(DevolucionSalida.class, id);
                devolucionSalida.getIdDevolucionSalida();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The devolucionSalida with id " + id + " no longer exists.", enfe);
            }
            Salida idSalida = devolucionSalida.getIdSalida();
            if (idSalida != null) {
                idSalida.getDevolucionSalidaCollection().remove(devolucionSalida);
                idSalida = em.merge(idSalida);
            }
            em.remove(devolucionSalida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DevolucionSalida> findDevolucionSalidaEntities() {
        return findDevolucionSalidaEntities(true, -1, -1);
    }

    public List<DevolucionSalida> findDevolucionSalidaEntities(int maxResults, int firstResult) {
        return findDevolucionSalidaEntities(false, maxResults, firstResult);
    }

    private List<DevolucionSalida> findDevolucionSalidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DevolucionSalida.class));
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

    public DevolucionSalida findDevolucionSalida(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DevolucionSalida.class, id);
        } finally {
            em.close();
        }
    }

    public int getDevolucionSalidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DevolucionSalida> rt = cq.from(DevolucionSalida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
