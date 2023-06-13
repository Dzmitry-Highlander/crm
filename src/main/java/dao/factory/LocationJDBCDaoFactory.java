package dao.factory;

import dao.api.ILocationDao;
import dao.db.LocationJDBCDao;

public class LocationJDBCDaoFactory {
    private static volatile ILocationDao instance;

    private LocationJDBCDaoFactory() {
    }

    public static ILocationDao getInstance() {
        if (instance == null)  {
            synchronized (LocationJDBCDaoFactory.class) {
                if (instance == null) {
                    instance = new LocationJDBCDao();
                }
            }
        }

        return instance;
    }
}
