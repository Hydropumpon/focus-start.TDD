package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.CrudRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static mocks.crud.task.service.PersonUtils.*;
import static mocks.crud.task.service.AddressUtils.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

	@Mock
	AddressService addressService;
	@Mock
	CrudRepository<Long, Person> personCrudRepository;

	private PersonService personService;

	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		personService = new PersonService(addressService, personCrudRepository);
	}


	@Test
	public void findAllRelatives()
	{
		List<Person> personList = new ArrayList<>();
		personList.add(TEST_PERSON);
		personList.add(RELATIVE_PERSON);
		List<Person> relatives = new ArrayList<>();
		relatives.add(RELATIVE_PERSON);
		when(personCrudRepository.findAll()).thenReturn(personList);
		when(addressService.findById(TEST_PERSON.getId())).thenReturn(TEST_ADDRESS);
		when(addressService.findById(RELATIVE_PERSON.getId())).thenReturn(TEST_ADDRESS);
		List<Person> result = personService.findAllRelatives(TEST_PERSON);
		assertEquals(result, relatives);
		verify(addressService, times(personList.size())).findById(anyLong());
	}

	@Test
	public void getAddress()
	{
		List<Person> personList = new ArrayList<>();
		personList.add(TEST_PERSON);
		when(personCrudRepository.findAll()).thenReturn(personList);
		when(addressService.findById(TEST_PERSON.getAddress().getId())).thenReturn(TEST_ADDRESS);
		Address result = personService.getAddress(TEST_PERSON);
		assertEquals(TEST_ADDRESS, result);
		verify(personCrudRepository, times(1)).findAll();
		verify(addressService,times(1)).findById(anyLong());
	}

	@Test
	public void save()
	{
		ArgumentCaptor<Person> valueCapture = ArgumentCaptor.forClass(Person.class);
		doNothing().when(personCrudRepository).save(valueCapture.capture());
		personService.save(TEST_PERSON);
		assertEquals(TEST_PERSON, valueCapture.getValue());
		verify(personCrudRepository,times(1)).save(TEST_PERSON);
	}

	@Test
	public void findById()
	{
		when(personCrudRepository.findById(1L)).thenReturn(TEST_PERSON);
		Person result = personService.findById(1L);
		assertEquals(result, TEST_PERSON);
		verify(personCrudRepository, times(1)).findById(1L);
	}

	@Test
	public void findAll()
	{
		List<Person> testList = new ArrayList<>();
		testList.add(TEST_PERSON);
		when(personCrudRepository.findAll()).thenReturn(testList);
		List<Person> result = personService.findAll();
		assertEquals(result, testList);
		verify(personCrudRepository, times(1)).findAll();
	}

	@Test
	public void update()
	{
		when(personCrudRepository.update(TEST_PERSON)).thenReturn(TEST_PERSON);
		Person result = personService.update(TEST_PERSON);
		assertEquals(result, TEST_PERSON);
		verify(personCrudRepository, times(1)).update(TEST_PERSON);
	}

	@Test
	public void delete()
	{
		ArgumentCaptor<Person> valueCapture = ArgumentCaptor.forClass(Person.class);
		doNothing().when(personCrudRepository).delete(valueCapture.capture());
		personService.delete(TEST_PERSON);
		assertEquals(TEST_PERSON, valueCapture.getValue());
		verify(personCrudRepository,times(1)).delete(TEST_PERSON);
	}
}