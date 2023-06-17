package service.factory;

import service.util.LocationConverterUtil;

public class LocationConverterUtilFactory {
    private static volatile LocationConverterUtil instance;

    private LocationConverterUtilFactory() {}

    public static LocationConverterUtil getInstance() {
        if (instance == null) {
            synchronized (LocationConverterUtil.class) {
                if (instance == null) {
                    instance = new LocationConverterUtil();
                }
            }
        }

        return instance;
    }
}
