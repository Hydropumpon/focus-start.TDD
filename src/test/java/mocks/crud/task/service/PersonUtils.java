package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;

final class PersonUtils {

	private static final Address TEST_ADDRESS;

	static {
		TEST_ADDRESS = new Address();
		TEST_ADDRESS.setId(1L);
		TEST_ADDRESS.setAddress("Esenina");

	}

	static final Person TEST_PERSON;

	static {
		TEST_PERSON = new Person("Alex", 30, TEST_ADDRESS);
		TEST_PERSON.setId(1L);
	}

	static final Person RELATIVE_PERSON;

	static
	{
		RELATIVE_PERSON = new Person("Igor", 36, TEST_ADDRESS);
		RELATIVE_PERSON.setId(2L);
	}

}
