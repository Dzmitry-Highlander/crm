package service.api;

public interface IConverterUtil<T, S> {
    T dtoToEntity (S item);

    S entityToDTO (T item);
}
