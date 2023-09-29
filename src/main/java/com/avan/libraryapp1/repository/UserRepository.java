package com.avan.libraryapp1.repository;

import com.avan.libraryapp1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Custom query to fetch users based on their role
    List<User> findByRole(String role);
}
