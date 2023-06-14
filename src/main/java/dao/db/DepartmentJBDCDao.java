package dao.db;

import dao.api.IDepartmentDao;
import dao.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.util.HibernateUtil;

import java.util.List;

public class DepartmentJBDCDao implements IDepartmentDao {
    @Override
    public Department create(Department item) {
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
    public void update(Department item) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            EntityTransaction tr = em.getTransaction();
            Department department = em.find(Department.class, item.getName());

            tr.begin();
            if (department != null) {
                department.setName(item.getName());
                em.merge(item);
            }
            tr.commit();
        } catch (PersistenceException e) {
            throw new RuntimeException("Ошибка выполнения запроса", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            EntityTransaction tr = em.getTransaction();
            Department item = em.find(Department.class, id);

            tr.begin();
            if (item != null) {
                em.remove(item);
            }
            tr.commit();
        } catch (PersistenceException e) {
            throw new RuntimeException("Ошибка выполнения запроса", e);
        }
    }
}
