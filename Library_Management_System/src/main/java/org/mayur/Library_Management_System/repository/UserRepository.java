package org.mayur.Library_Management_System.repository;

import org.mayur.Library_Management_System.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByContact(String contact);
}
