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

	//проверка валидности данных для поиска в репозитории
	private boolean isPersonDataIncorrect(Person person)
	{
		if (person == null)
		{
			return true;
		}
		if (person.getAge() == null)
		{
			return true;
		}
		return person.getName() == null;
	}

	@Override
	public List<Person> findAllRelatives(Person person)
	{
		List<Person> relatives = new ArrayList<>();
		//если условия для поиска не соответствуют требуемым
		if (isPersonDataIncorrect(person))
		{
			return relatives;
		}
		for (Person p : findAll())
		{
			//если найденный в репозитории человек - мы сами, то пропускаем
			if (p.getAge().equals(person.getAge()) && p.getName().equals(person.getName()))
			{
				continue;
			}
			//если совпадает адрес - то добавляем в родственников
			if (p.getAddress().getId().equals(person.getAddress().getId()) && p.getAddress().getAddress().equals(person.getAddress().getAddress()))
			{
				relatives.add(p);
			}
		}
		return relatives;

	}

	@Override
	public Address getAddress(Person person)
	{
		if (isPersonDataIncorrect(person))
		{
			return null;
		}
		for (Person p : findAll())
		{
			//если мы нашли человека в репозитории
			if (p.getName().equals(person.getName()) && (p.getAge().equals(person.getAge())))
			{
				return p.getAddress();
			}
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
