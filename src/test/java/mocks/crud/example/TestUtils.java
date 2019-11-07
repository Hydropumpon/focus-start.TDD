package mocks.crud.example;

import mocks.crud.example.Book;

public final class TestUtils {

    public static final Book TEST_BOOK;

    static {
        TEST_BOOK = new Book();
        TEST_BOOK.setId(1L);
        TEST_BOOK.setAuthor("Lev Tolstoy");
        TEST_BOOK.setName("War and peace");
    }
}
