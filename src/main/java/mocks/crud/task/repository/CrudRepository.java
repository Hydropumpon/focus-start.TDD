package mocks.crud.task.repository;

import java.util.List;

/**
 * Основной репозиторий для работы с сущностями
 * @param <K> id сущности
 * @param <E> сама сущность
 */
public interface CrudRepository<K, E> {
    /**
     *Сохранить сущность
     * @param element сущность
     */
    void save(E element);

    /**
     * Найти сущность по id
     * @param id
     * @return сущность
     */
    E findById(K id);

    /**
     * Найти все сущности
     * @return список всех сущностей
     */
    List<E> findAll();

    /**
     * Обновить элемент
     * @param element элемент, который нужно обновить
     * @return обновленный элемент
     */
    E update(E element);

    /**
     * Удалить элемент
     * @param element элемент, который нужно удалить
     */
    void delete(E element);
}
