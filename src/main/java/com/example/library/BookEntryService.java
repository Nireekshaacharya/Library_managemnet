package com.example.library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEntryService {

    @Autowired
    private BookEntryRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public void save(Book entry) {
        repository.save(entry);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
