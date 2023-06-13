package dao.db;

import dao.api.IDepartmentDao;
import dao.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.util.HibernateUtil;

import java.util.List;

public class DepartmentJBDCDao implements IDepartmentDao {
    @Override
    public Department create(Department item) {
        return null;
    }

    @Override
    public Department read(Long id) {
        return null;
    }

    @Override
    public List<Department> read() {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
        Root<Department> departmentRoot = criteria.from(Department.class);

        criteria.select(departmentRoot);

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
