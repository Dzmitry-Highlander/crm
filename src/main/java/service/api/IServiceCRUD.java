package service.api;

import java.util.List;

public interface IServiceCRUD<T, S> {
    S create(T item);

    S read(Long id);

    List<S> read();

    void update(T item);

    void delete(Long id);
}
