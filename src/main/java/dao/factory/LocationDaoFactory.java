package dao.factory;

import dao.api.ILocationDao;
import dao.db.LocationJDBCDao;

public class LocationDaoFactory {
    private static volatile ILocationDao instance;

    private LocationDaoFactory() {
    }

    public static ILocationDao getInstance() {
        if (instance == null)  {
            synchronized (LocationDaoFactory.class) {
                if (instance == null) {
                    instance = new LocationJDBCDao();
                }
            }
        }

        return instance;
    }
}
