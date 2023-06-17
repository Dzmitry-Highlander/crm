package service.api;

public interface IConverterUtil<T, S> {
    S entityToDTO (T item);
}
