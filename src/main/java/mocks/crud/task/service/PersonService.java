package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.AdvancedRepository;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;


public class PersonService implements AdvancedRepository
{
	private AddressService addressService;

	private CrudRepository<Long, Person> personRepository;

	public PersonService(AddressService addressService, CrudRepository<Long, Person> crudRepository)
	{
		this.addressService = addressService;
		this.personRepository = crudRepository;
	}

	private void checkPersonData(Person person) throws NullPointerException, IllegalArgumentException
	{
		if (person == null)
		{
			throw new NullPointerException("Error, empty person object");
		}
		if (person.getAge() == null)
		{
			throw new IllegalArgumentException("Error, empty person age");
		}
		if (person.getName() == null)
		{
			throw new IllegalArgumentException("Error, empty person name");
		}
	}

	@Override
	public List<Person> findAllRelatives(Person person)
	{
		List<Person> relatives = new ArrayList<>();
		checkPersonData(person);
		for (Person p : findAll())
		{
			if (p.getAge().equals(person.getAge()) && p.getName().equals(person.getName()))
			{
				continue;
			}
			if (getAddress(person).equals(getAddress(p)))
			{
				relatives.add(p);
			}
		}
		return relatives;

	}

	@Override
	public Address getAddress(Person person)
	{
		checkPersonData(person);
		for (Person p : findAll())
		{
			if (p.getName().equals(person.getName()) && (p.getAge().equals(person.getAge())))
				return addressService.findById(p.getAddress().getId());
		}
		return null;
	}

	public void save(Person element)
	{
		personRepository.save(element);
	}

	public Person findById(Long id)
	{
		return personRepository.findById(id);
	}

	public List<Person> findAll()
	{
		return personRepository.findAll();
	}

	public Person update(Person element)
	{
		return personRepository.update(element);
	}

	public void delete(Person element)
	{
		personRepository.delete(element);
	}

}
