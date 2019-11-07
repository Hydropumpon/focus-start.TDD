package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;

import java.util.List;

public class AddressService implements CrudRepository<Long, Address> {
    @Override
    public void save(Address element) {
        //todo написать реализацию
    }

    @Override
    public Address findById(Long id) {
        //todo написать реализацию
        return null;
    }

    @Override
    public List<Address> findAll() {
        //todo написать реализацию
        return null;
    }

    @Override
    public Address update(Address element) {
        //todo написать реализацию
        return null;
    }

    @Override
    public void delete(Address element) {
        //todo написать реализацию
    }
}
