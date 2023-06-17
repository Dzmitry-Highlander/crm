package service.api;

import java.util.List;

public interface IServiceCRUD<T, S, K> {
    T create(S item);

    T read(Long id);

    List<T> read();

    T update(Long id, K item);

    void delete(Long id);
}
