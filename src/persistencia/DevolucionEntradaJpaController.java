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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.DevolucionEntrada;
import modelo.Entrada;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author luisalvaranleav
 */
public class DevolucionEntradaJpaController implements Serializable {

    public DevolucionEntradaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DevolucionEntrada devolucionEntrada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrada idEntrada = devolucionEntrada.getIdEntrada();
            if (idEntrada != null) {
                idEntrada = em.getReference(idEntrada.getClass(), idEntrada.getIdEntrada());
                devolucionEntrada.setIdEntrada(idEntrada);
            }
            em.persist(devolucionEntrada);
            if (idEntrada != null) {
                idEntrada.getDevolucionEntradaCollection().add(devolucionEntrada);
                idEntrada = em.merge(idEntrada);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DevolucionEntrada devolucionEntrada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DevolucionEntrada persistentDevolucionEntrada = em.find(DevolucionEntrada.class, devolucionEntrada.getIdDevolucionEntrada());
            Entrada idEntradaOld = persistentDevolucionEntrada.getIdEntrada();
            Entrada idEntradaNew = devolucionEntrada.getIdEntrada();
            if (idEntradaNew != null) {
                idEntradaNew = em.getReference(idEntradaNew.getClass(), idEntradaNew.getIdEntrada());
                devolucionEntrada.setIdEntrada(idEntradaNew);
            }
            devolucionEntrada = em.merge(devolucionEntrada);
            if (idEntradaOld != null && !idEntradaOld.equals(idEntradaNew)) {
                idEntradaOld.getDevolucionEntradaCollection().remove(devolucionEntrada);
                idEntradaOld = em.merge(idEntradaOld);
            }
            if (idEntradaNew != null && !idEntradaNew.equals(idEntradaOld)) {
                idEntradaNew.getDevolucionEntradaCollection().add(devolucionEntrada);
                idEntradaNew = em.merge(idEntradaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = devolucionEntrada.getIdDevolucionEntrada();
                if (findDevolucionEntrada(id) == null) {
                    throw new NonexistentEntityException("The devolucionEntrada with id " + id + " no longer exists.");
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
            DevolucionEntrada devolucionEntrada;
            try {
                devolucionEntrada = em.getReference(DevolucionEntrada.class, id);
                devolucionEntrada.getIdDevolucionEntrada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The devolucionEntrada with id " + id + " no longer exists.", enfe);
            }
            Entrada idEntrada = devolucionEntrada.getIdEntrada();
            if (idEntrada != null) {
                idEntrada.getDevolucionEntradaCollection().remove(devolucionEntrada);
                idEntrada = em.merge(idEntrada);
            }
            em.remove(devolucionEntrada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DevolucionEntrada> findDevolucionEntradaEntities() {
        return findDevolucionEntradaEntities(true, -1, -1);
    }

    public List<DevolucionEntrada> findDevolucionEntradaEntities(int maxResults, int firstResult) {
        return findDevolucionEntradaEntities(false, maxResults, firstResult);
    }

    private List<DevolucionEntrada> findDevolucionEntradaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DevolucionEntrada.class));
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

    public DevolucionEntrada findDevolucionEntrada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DevolucionEntrada.class, id);
        } finally {
            em.close();
        }
    }

    public int getDevolucionEntradaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DevolucionEntrada> rt = cq.from(DevolucionEntrada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
