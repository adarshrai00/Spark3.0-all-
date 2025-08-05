package org.example.eccomerce.repo;

import org.example.eccomerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User  findByEmail(String email);
}
