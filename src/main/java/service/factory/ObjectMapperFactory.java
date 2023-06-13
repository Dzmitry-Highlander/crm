package service.factory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
    private static volatile ObjectMapper instance;

    private ObjectMapperFactory() {}

    public static ObjectMapper getInstance() {
        if (instance == null) {
            synchronized (ObjectMapperFactory.class) {
                if (instance == null) {
                    instance = new ObjectMapper();
                }
            }
        }
        return instance;
    }
}
