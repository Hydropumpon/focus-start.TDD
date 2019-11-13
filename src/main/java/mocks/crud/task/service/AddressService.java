package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;

import java.util.List;

public class AddressService implements CrudRepository<Long, Address> {
    public AddressService(CrudRepository<Long, Address> addressCrudRepository)
    {
        this.addressCrudRepository = addressCrudRepository;
    }

    private CrudRepository<Long, Address> addressCrudRepository;

    @Override
    public void save(Address element) {
        addressCrudRepository.save(element);
    }

    @Override
    public Address findById(Long id) {
        return addressCrudRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressCrudRepository.findAll();
    }

    @Override
    public Address update(Address element) {
        return addressCrudRepository.update(element);
    }

    @Override
    public void delete(Address element) {
        addressCrudRepository.delete(element);
    }
}
