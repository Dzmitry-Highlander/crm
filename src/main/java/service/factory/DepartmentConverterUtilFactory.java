package service.factory;

import service.util.DepartmentConverterUtil;

public class DepartmentConverterUtilFactory {
    private static volatile DepartmentConverterUtil instance;

    private DepartmentConverterUtilFactory() {
    }

    public static DepartmentConverterUtil getInstance() {
        if (instance == null) {
            synchronized (DepartmentConverterUtil.class) {
                if (instance == null) {
                    instance = new DepartmentConverterUtil();
                }
            }
        }

        return instance;
    }
}
