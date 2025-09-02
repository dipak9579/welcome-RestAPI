package com.dipak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dipak.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
