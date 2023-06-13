package service.factory;

import dao.factory.LocationDaoFactory;
import service.LocationService;
import service.api.ILocationService;

public class LocationServiceFactory {
    private static volatile ILocationService instance;

    private LocationServiceFactory() {
    }

    public static ILocationService getInstance() {
        if (instance == null) {
            synchronized (LocationServiceFactory.class) {
                instance = new LocationService(LocationDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
