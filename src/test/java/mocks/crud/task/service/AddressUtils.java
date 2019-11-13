package mocks.crud.task.service;

import mocks.crud.task.model.Address;

final class AddressUtils {

	static final Address TEST_ADDRESS;

	static {
		TEST_ADDRESS = new Address();
		TEST_ADDRESS.setId(1L);
		TEST_ADDRESS.setAddress("Esenina");

	}

}
