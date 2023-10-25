package org.mayur.Library_Management_System.repository;

import org.mayur.Library_Management_System.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query(value = "select * from author where email =:email", nativeQuery = true)
    Author getAuthorWithMailAddress(String email);

    @Query("select a from Author a where a.email = ?1")
    Author getAuthorWithMailAddressWithoutNative(String email);

    Author findByEmail(String email);



}
