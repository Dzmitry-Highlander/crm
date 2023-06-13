package service.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory enFactory;

    static {
        enFactory = Persistence.createEntityManagerFactory("crm");
    }

    public static EntityManager getEntityManager() {
        return enFactory.createEntityManager();
    }

    public static void close() {
        enFactory.close();
    }
}
