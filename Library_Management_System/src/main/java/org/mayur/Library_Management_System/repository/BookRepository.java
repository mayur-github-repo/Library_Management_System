package org.mayur.Library_Management_System.repository;

import org.mayur.Library_Management_System.models.Book;
import org.mayur.Library_Management_System.models.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByBookNo(String bookNo);

    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByCost(Integer cost);

    List<Book> findByType(BookType type);

    List<Book> findByCostLessThan(Integer cost);
    List<Book> findByCostGreaterThan(Integer cost);
}
