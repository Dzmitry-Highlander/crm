package dao.db;

import dao.api.ILocationDao;
import dao.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.util.HibernateUtil;

import java.util.List;

public class LocationJDBCDao implements ILocationDao {
    @Override
    public Location create(Location item) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction t = em.getTransaction();

        t.begin();
        em.persist(item);
        t.commit();
        em.refresh(item);
        em.close();

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
    public Location update(Location item) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction t = em.getTransaction();

        t.begin();
        em.merge(item);
        t.commit();
        em.refresh(item);
        em.close();

        return item;
    }

    @Override
    public void delete(Long id) {

    }
}
