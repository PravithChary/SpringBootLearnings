package com.jpa.test.dao;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.jpa.test.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    // PreDefined Methods
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
    public List<User> findByNameStartingWith(String prefix);
    public List<User> findByNameEndingWith(String suffix);
    public List<User> findByNameContaining(String likePattern);
    public List<User> findByAgeLessThan(int age);
    public List<User> findByAgeGreaterThan(int age);
    public List<User> findByAgeIn(Collection<Integer>ages);

    // Custom Finder Methods / Derived Query Methods
    @Query("select u from User u")
    public List<User> getAllUser();

    @Query("select u from User u where u.name= :n")
    public List<User> getUserByName(@Param("n") String name);

    // SQL Query
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();
}
