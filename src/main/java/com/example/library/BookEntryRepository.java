package com.example.library;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntryRepository extends JpaRepository<Book, Long> {
}
