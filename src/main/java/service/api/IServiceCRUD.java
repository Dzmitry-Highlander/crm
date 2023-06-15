package service.api;

import java.util.List;

public interface IServiceCRUD<T, S> {
    S create(T item);

    S read(Long id);

    List<S> read();

    S update(S item);

    void delete(Long id);
}
