package service.api;

import java.util.List;

public interface IServiceCRUD<T, S> {
    T create(S item);

    T read(Long id);

    List<T> read();

    T update(Long id, S item);

    void delete(Long id);
}
