package service.factory;

import dao.factory.DepartmentDaoFactory;
import dao.factory.LocationDaoFactory;
import service.DepartmentService;
import service.api.IDepartmentService;

public class DepartmentServiceFactory {
    private static volatile IDepartmentService instance;

    private DepartmentServiceFactory() {
    }

    public static IDepartmentService getInstance() {
        if (instance == null) {
            synchronized (DepartmentServiceFactory.class) {
                instance = new DepartmentService(DepartmentDaoFactory.getInstance(), LocationDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
