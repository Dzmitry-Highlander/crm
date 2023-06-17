package service.api;

public interface IConverterUtil<T, S> {
    T entityToDTO (S item);
}
