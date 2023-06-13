package service.api;

import java.util.List;

public interface IServiceCRUD<T, S> {
    S create(T item);

    S get(Long id);

    List<S> get();

    S update(T item);

    void delete(Long id);
}
