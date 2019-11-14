package mocks.crud.task.repository;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;

import java.util.List;

/**
 * Дополнительный репозиторий
 */
public interface AdvancedRepository {
    /**
     * Метод для поиска родственников
     * @param person человек, родственников которого нужно найти
     * @return список родственников
     */
    List<Person> findAllRelatives(Person person);

    /**
     * Метод для поиска адреса пользователя
     * @param person человек, адрес которого нужно найти
     * @return адрес человека
     */
    Address getAddress(Person person);
}
