package dao.db;

import dao.api.IDepartmentDao;
import dao.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.util.HibernateUtil;

import java.util.List;

public class DepartmentJBDCDao implements IDepartmentDao {
    @Override
    public Department create(Department item) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction t = em.getTransaction();

        t.begin();
        em.persist(item);
        t.commit();
        em.close();

        return item;
    }

    @Override
    public Department read(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
        Root<Department> emp = criteria.from(Department.class);
        criteria.select(emp)
                .where(cb.equal(emp.get("id"), id));

        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Department> read() {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
        criteria.from(Department.class);

        return em.createQuery(criteria).getResultList();
    }

    @Override
    public Department update(Department item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
