package mocks.crud.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static mocks.crud.example.TestUtils.TEST_BOOK;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    Repository<Long, Book> repository;

    private BookService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        service = new BookService(repository);
    }

    @Test
    public void findAllTest() {
        when(repository.findById(1L)).thenReturn(TEST_BOOK);
        Book result = service.findById(1L);
        assertEquals(result, TEST_BOOK);
        verify(repository, times(1)).findById(1L);
    }

}
