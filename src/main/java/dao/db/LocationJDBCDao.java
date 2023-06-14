package dao.db;

import dao.api.ILocationDao;
import dao.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.util.HibernateUtil;

import java.util.List;

public class LocationJDBCDao implements ILocationDao {
    @Override
    public Location create(Location item) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            EntityTransaction t = em.getTransaction();

            t.begin();
            em.persist(item);
            t.commit();
            em.refresh(item);
        } catch (PersistenceException e) {
            throw new RuntimeException("Ошибка выполнения запроса", e);
        }

        return item;
    }

    @Override
    public Location read(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = cb.createQuery(Location.class);
        Root<Location> emp = criteria.from(Location.class);
        criteria.select(emp)
                .where(cb.equal(emp.get("id"), id));

        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Location> read() {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = cb.createQuery(Location.class);
        criteria.from(Location.class);

        return em.createQuery(criteria).getResultList();
    }

    @Override
    public Location update(Location item, Location update) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            // create update
            CriteriaUpdate<Location> criteriaUpdate = cb.createCriteriaUpdate(Location.class);

            // set the root class
            Root<Location> r = criteriaUpdate.from(Location.class);

            // set update and where clause
            criteriaUpdate.set(r.get("name"), update.getName())
                    .where(cb.equal(r.get("name"), item.getName()));

            // perform update
            em.createQuery(criteriaUpdate).executeUpdate();
        } catch (PersistenceException e) {
            throw new RuntimeException("Ошибка выполнения запроса", e);
        }

        return item;
    }

    @Override
    public void delete(Long id) {

    }
}
