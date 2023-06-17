package service.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IServiceCRUD<T, S, K> {
    T create(S item);

    T read(Long id);

    List<T> read();

    T update(Long id, LocalDateTime date, K item);

    void delete(Long id);
}
