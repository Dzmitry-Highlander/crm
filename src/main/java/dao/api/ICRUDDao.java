package dao.api;

import java.util.List;

public interface ICRUDDao<T> {
    T create(T item);

    T read(Long id);

    List<T> read();

    T update(Long id, T item);

    void delete(Long id);
}
