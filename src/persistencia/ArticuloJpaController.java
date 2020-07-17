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
import modelo.Entrada;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Articulo;
import modelo.Salida;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author luisalvaranleav
 */
public class ArticuloJpaController implements Serializable {

    
    public ArticuloJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPS_entrega0PU");
    }
    
    public ArticuloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Articulo articulo) {
        if (articulo.getEntradaCollection() == null) {
            articulo.setEntradaCollection(new ArrayList<Entrada>());
        }
        if (articulo.getSalidaCollection() == null) {
            articulo.setSalidaCollection(new ArrayList<Salida>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Entrada> attachedEntradaCollection = new ArrayList<Entrada>();
            for (Entrada entradaCollectionEntradaToAttach : articulo.getEntradaCollection()) {
                entradaCollectionEntradaToAttach = em.getReference(entradaCollectionEntradaToAttach.getClass(), entradaCollectionEntradaToAttach.getIdEntrada());
                attachedEntradaCollection.add(entradaCollectionEntradaToAttach);
            }
            articulo.setEntradaCollection(attachedEntradaCollection);
            Collection<Salida> attachedSalidaCollection = new ArrayList<Salida>();
            for (Salida salidaCollectionSalidaToAttach : articulo.getSalidaCollection()) {
                salidaCollectionSalidaToAttach = em.getReference(salidaCollectionSalidaToAttach.getClass(), salidaCollectionSalidaToAttach.getIdSalida());
                attachedSalidaCollection.add(salidaCollectionSalidaToAttach);
            }
            articulo.setSalidaCollection(attachedSalidaCollection);
            em.persist(articulo);
            for (Entrada entradaCollectionEntrada : articulo.getEntradaCollection()) {
                Articulo oldIdArticuloOfEntradaCollectionEntrada = entradaCollectionEntrada.getIdArticulo();
                entradaCollectionEntrada.setIdArticulo(articulo);
                entradaCollectionEntrada = em.merge(entradaCollectionEntrada);
                if (oldIdArticuloOfEntradaCollectionEntrada != null) {
                    oldIdArticuloOfEntradaCollectionEntrada.getEntradaCollection().remove(entradaCollectionEntrada);
                    oldIdArticuloOfEntradaCollectionEntrada = em.merge(oldIdArticuloOfEntradaCollectionEntrada);
                }
            }
            for (Salida salidaCollectionSalida : articulo.getSalidaCollection()) {
                Articulo oldIdArticuloOfSalidaCollectionSalida = salidaCollectionSalida.getIdArticulo();
                salidaCollectionSalida.setIdArticulo(articulo);
                salidaCollectionSalida = em.merge(salidaCollectionSalida);
                if (oldIdArticuloOfSalidaCollectionSalida != null) {
                    oldIdArticuloOfSalidaCollectionSalida.getSalidaCollection().remove(salidaCollectionSalida);
                    oldIdArticuloOfSalidaCollectionSalida = em.merge(oldIdArticuloOfSalidaCollectionSalida);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Articulo articulo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Articulo persistentArticulo = em.find(Articulo.class, articulo.getIdArticulo());
            Collection<Entrada> entradaCollectionOld = persistentArticulo.getEntradaCollection();
            Collection<Entrada> entradaCollectionNew = articulo.getEntradaCollection();
            Collection<Salida> salidaCollectionOld = persistentArticulo.getSalidaCollection();
            Collection<Salida> salidaCollectionNew = articulo.getSalidaCollection();
            List<String> illegalOrphanMessages = null;
            for (Entrada entradaCollectionOldEntrada : entradaCollectionOld) {
                if (!entradaCollectionNew.contains(entradaCollectionOldEntrada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Entrada " + entradaCollectionOldEntrada + " since its idArticulo field is not nullable.");
                }
            }
            for (Salida salidaCollectionOldSalida : salidaCollectionOld) {
                if (!salidaCollectionNew.contains(salidaCollectionOldSalida)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Salida " + salidaCollectionOldSalida + " since its idArticulo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Entrada> attachedEntradaCollectionNew = new ArrayList<Entrada>();
            for (Entrada entradaCollectionNewEntradaToAttach : entradaCollectionNew) {
                entradaCollectionNewEntradaToAttach = em.getReference(entradaCollectionNewEntradaToAttach.getClass(), entradaCollectionNewEntradaToAttach.getIdEntrada());
                attachedEntradaCollectionNew.add(entradaCollectionNewEntradaToAttach);
            }
            entradaCollectionNew = attachedEntradaCollectionNew;
            articulo.setEntradaCollection(entradaCollectionNew);
            Collection<Salida> attachedSalidaCollectionNew = new ArrayList<Salida>();
            for (Salida salidaCollectionNewSalidaToAttach : salidaCollectionNew) {
                salidaCollectionNewSalidaToAttach = em.getReference(salidaCollectionNewSalidaToAttach.getClass(), salidaCollectionNewSalidaToAttach.getIdSalida());
                attachedSalidaCollectionNew.add(salidaCollectionNewSalidaToAttach);
            }
            salidaCollectionNew = attachedSalidaCollectionNew;
            articulo.setSalidaCollection(salidaCollectionNew);
            articulo = em.merge(articulo);
            for (Entrada entradaCollectionNewEntrada : entradaCollectionNew) {
                if (!entradaCollectionOld.contains(entradaCollectionNewEntrada)) {
                    Articulo oldIdArticuloOfEntradaCollectionNewEntrada = entradaCollectionNewEntrada.getIdArticulo();
                    entradaCollectionNewEntrada.setIdArticulo(articulo);
                    entradaCollectionNewEntrada = em.merge(entradaCollectionNewEntrada);
                    if (oldIdArticuloOfEntradaCollectionNewEntrada != null && !oldIdArticuloOfEntradaCollectionNewEntrada.equals(articulo)) {
                        oldIdArticuloOfEntradaCollectionNewEntrada.getEntradaCollection().remove(entradaCollectionNewEntrada);
                        oldIdArticuloOfEntradaCollectionNewEntrada = em.merge(oldIdArticuloOfEntradaCollectionNewEntrada);
                    }
                }
            }
            for (Salida salidaCollectionNewSalida : salidaCollectionNew) {
                if (!salidaCollectionOld.contains(salidaCollectionNewSalida)) {
                    Articulo oldIdArticuloOfSalidaCollectionNewSalida = salidaCollectionNewSalida.getIdArticulo();
                    salidaCollectionNewSalida.setIdArticulo(articulo);
                    salidaCollectionNewSalida = em.merge(salidaCollectionNewSalida);
                    if (oldIdArticuloOfSalidaCollectionNewSalida != null && !oldIdArticuloOfSalidaCollectionNewSalida.equals(articulo)) {
                        oldIdArticuloOfSalidaCollectionNewSalida.getSalidaCollection().remove(salidaCollectionNewSalida);
                        oldIdArticuloOfSalidaCollectionNewSalida = em.merge(oldIdArticuloOfSalidaCollectionNewSalida);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = articulo.getIdArticulo();
                if (findArticulo(id) == null) {
                    throw new NonexistentEntityException("The articulo with id " + id + " no longer exists.");
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
            Articulo articulo;
            try {
                articulo = em.getReference(Articulo.class, id);
                articulo.getIdArticulo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articulo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Entrada> entradaCollectionOrphanCheck = articulo.getEntradaCollection();
            for (Entrada entradaCollectionOrphanCheckEntrada : entradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Articulo (" + articulo + ") cannot be destroyed since the Entrada " + entradaCollectionOrphanCheckEntrada + " in its entradaCollection field has a non-nullable idArticulo field.");
            }
            Collection<Salida> salidaCollectionOrphanCheck = articulo.getSalidaCollection();
            for (Salida salidaCollectionOrphanCheckSalida : salidaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Articulo (" + articulo + ") cannot be destroyed since the Salida " + salidaCollectionOrphanCheckSalida + " in its salidaCollection field has a non-nullable idArticulo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(articulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Articulo> findArticuloEntities() {
        return findArticuloEntities(true, -1, -1);
    }

    public List<Articulo> findArticuloEntities(int maxResults, int firstResult) {
        return findArticuloEntities(false, maxResults, firstResult);
    }

    private List<Articulo> findArticuloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Articulo.class));
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

    public Articulo findArticulo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Articulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticuloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Articulo> rt = cq.from(Articulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
