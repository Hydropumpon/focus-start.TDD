package mocks.crud.example;

public class BookService {

    Repository<Long, Book> repository;

    public BookService(Repository repository) {
        this.repository = repository;
    }

    public Book findById(Long id) {

        return repository.findById(id);
    }

}
