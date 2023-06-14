package dao.api;

import java.util.List;

public interface ICRUDDao<T> {
    T create(T item);

    T read(Long id);

    List<T> read();

    void update(T item);

    void delete(Long id);
}
