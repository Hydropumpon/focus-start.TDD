package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.AdvancedRepository;
import mocks.crud.task.repository.CrudRepository;

import java.util.List;

public class PersonService implements  AdvancedRepository {

    private AddressService addressService;

    private CrudRepository<Person, Long> personRepository;

    public PersonService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public List<Person> findAllRelatives(Person person) {
        //todo написать реализацию
        return null;
    }

    @Override
    public Address getAddress(Person person) {
        //todo написать реализацию
        return null;
    }

    public void save(Person element) {
        //todo написать реализацию
    }

    public Person findById(Long id) {
        //todo написать реализацию
        return null;
    }

    public List<Person> findAll() {
        //todo написать реализацию
        return null;
    }

    public Person update(Person element) {
        //todo написать реализацию
        return null;
    }

    public void delete(Person element) {
        //todo написать реализацию
    }
}
