package dao.factory;

import dao.db.DepartmentJBDCDao;
import dao.api.IDepartmentDao;

public class DepartmentDaoFactory {
    private static volatile IDepartmentDao instance;

    private DepartmentDaoFactory() {
    }

    public static IDepartmentDao getInstance() {
        if (instance == null)  {
            synchronized (DepartmentDaoFactory.class) {
                if (instance == null) {
                    instance = new DepartmentJBDCDao();
                }
            }
        }

        return instance;
    }
}
