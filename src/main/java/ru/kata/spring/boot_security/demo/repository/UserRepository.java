package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u left join fetch u.roles where u.username=:username")
    User findByUsername(String username);

    @Query("Select u from User u left join fetch u.roles where u.id=:id")
    User getById(Long id);

    User findByEmail(String email);
}
