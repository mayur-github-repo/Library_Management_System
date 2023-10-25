package org.mayur.Library_Management_System.repository;

import org.mayur.Library_Management_System.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByContact(String contact);
}
