package mocks.crud.example;


final class TestUtils {

    static final Book TEST_BOOK;

    static {
        TEST_BOOK = new Book();
        TEST_BOOK.setId(1L);
        TEST_BOOK.setAuthor("Lev Tolstoy");
        TEST_BOOK.setName("War and peace");
    }



}
