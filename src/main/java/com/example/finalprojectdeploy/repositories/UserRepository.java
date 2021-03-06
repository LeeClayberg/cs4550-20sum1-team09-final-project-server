package com.example.finalprojectdeploy.repositories;

import com.example.finalprojectdeploy.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT user FROM User user")
  public List<User> findAllUsers();

  @Query("SELECT user FROM User user WHERE user.id=:userId")
  public User findUserById(@Param("userId") Integer id);

  @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
  public User userLogin(@Param("username") String username, @Param("password") String password);
}
