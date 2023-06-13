package dao.db;

import dao.api.ILocationDao;
import dao.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.util.HibernateUtil;

import java.util.List;

public class LocationJDBCDao implements ILocationDao {
    @Override
    public Location create(Location item) {
        EntityManager em = HibernateUtil.getEntityManager();
        Session session = em.unwrap(Session.class);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Location> criteriaUpdate = cb.createCriteriaUpdate(Location.class);
        Root<Location> root = criteriaUpdate.from(Location.class);

        criteriaUpdate.set("id", item.getId());
        criteriaUpdate.set("name", item.getName());
        criteriaUpdate.where(cb.equal(root.get("id"), item.getId()));
        criteriaUpdate.where(cb.equal(root.get("name"), item.getName()));

        Transaction transaction = session.beginTransaction();
        session.createSelectionQuery(criteriaUpdate.toString());
        transaction.commit();

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
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
