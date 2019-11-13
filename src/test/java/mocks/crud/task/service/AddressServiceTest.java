package mocks.crud.task.service;

import mocks.crud.task.model.Address;
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

import static mocks.crud.task.service.AddressUtils.TEST_ADDRESS;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest
{
	@Mock
	CrudRepository<Long, Address> crudRepository;

	private AddressService service;

	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		service = new AddressService(crudRepository);
	}

	@Test
	public void findByIdTest()
	{
		when(crudRepository.findById(1L)).thenReturn(TEST_ADDRESS);
		Address result = service.findById(1L);
		assertEquals(result, TEST_ADDRESS);
		verify(crudRepository, times(1)).findById(1L);
	}

	@Test
	public void findAllTest()
	{
		List<Address> addressListTest = new ArrayList<>();
		addressListTest.add(TEST_ADDRESS);
		when(crudRepository.findAll()).thenReturn(addressListTest);
		List<Address> result = service.findAll();
		assertEquals(result, addressListTest);
		verify(crudRepository, times(1)).findAll();

	}

	@Test
	public void saveTest()
	{

		ArgumentCaptor<Address> valueCapture = ArgumentCaptor.forClass(Address.class);
		doNothing().when(crudRepository).save(valueCapture.capture());
		service.save(TEST_ADDRESS);
		assertEquals(TEST_ADDRESS, valueCapture.getValue());
		verify(crudRepository,times(1)).save(TEST_ADDRESS);

	}

	@Test
	public void updateTest()
	{
		when(crudRepository.update(TEST_ADDRESS)).thenReturn(TEST_ADDRESS);
		Address result = service.update(TEST_ADDRESS);
		assertEquals(result, TEST_ADDRESS);
		verify(crudRepository,times(1)).update(TEST_ADDRESS);

	}

	@Test
	public void deleteTest()
	{
		ArgumentCaptor<Address> valueCapture = ArgumentCaptor.forClass(Address.class);
		doNothing().when(crudRepository).delete(valueCapture.capture());
		service.delete(TEST_ADDRESS);
		assertEquals(TEST_ADDRESS, valueCapture.getValue());
		verify(crudRepository,times(1)).delete(TEST_ADDRESS);
	}

}


