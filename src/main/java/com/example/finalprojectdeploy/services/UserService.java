package com.example.finalprojectdeploy.services;

import com.example.finalprojectdeploy.model.ComicBook;
import com.example.finalprojectdeploy.model.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserService {
  User user1 = new User(123, "tom", "tmoney123", "admin", "2020-06-07");
  public List<User> users = new ArrayList<User>();
  {
    users.add(user1);
  }

  //Basic Operations

  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return users;
  }

  @GetMapping("/api/users/{userId}")
  public User findUserById(@PathVariable("userId") Integer id) {
    for(User user: users) {
      if(user.getId() == id) {
        return user;
      }
    }
    return null;
  }

  @PostMapping("/api/users")
  public User createUser(@RequestBody User user) {
    users.add(user);
    return user;
  }

  @PutMapping("/api/users/{userId}")
  public User updateUser(@PathVariable("userId") Integer id, @RequestBody User newUser) {
    for(User user: users) {
      if(user.getId() == id) {
        user.updateUser(newUser);
        return user;
      }
    }
    return null;
  }

  @DeleteMapping("/api/users/{userId}")
  public void deleteUser(@PathVariable("userId") Integer id) {
    for(User user: users) {
      if(user.getId() == id) {
        users.remove(user);
        return;
      }
    }
  }

  //Comic Books Collection

  @GetMapping("/api/users/{userId}/collection")
  public List<ComicBook> findComicBooksForUser(@PathVariable("userId") Integer id) {
    for(User user: users) {
      if(user.getId() == id) {
        return user.getComicBooks();
      }
    }
    return null;
  }

  @GetMapping("/api/users/{userId}/collection&sort={sortBy}")
  public List<ComicBook> findComicBooksForUserSorted(@PathVariable("userId") Integer id, @PathVariable("sortBy") String sortBy) {
    for(User user: users) {
      if(user.getId() == id) {
        return user.getComicBooks(sortBy);
      }
    }
    return null;
  }

  @GetMapping("/api/users/{userId}/collection&sort={sortBy}&resource={resource}&search={query}")
  public List<ComicBook> findComicBooksForUserSortedSearch(@PathVariable("userId") Integer id, @PathVariable("sortBy") String sortBy,
                                                           @PathVariable("resource") String resource, @PathVariable("query") String query) {
    for(User user: users) {
      if(user.getId() == id) {
        return user.getComicBooks(sortBy, resource, query);
      }
    }
    return null;
  }

  @GetMapping("/api/users/{userId}/collection/{comicBookId}")
  public ComicBook findComicBookById(@PathVariable("userId") Integer userId, @PathVariable("comicBookId") Integer id) {
    for(User user: users) {
      if (user.getId() == userId) {
        for (ComicBook comicBook : user.getComicBooks()) {
          if (comicBook.getId() == id) {
            return comicBook;
          }
        }
      }
    }
    return null;
  }

  @PostMapping("/api/users/{userId}/collection")
  public ComicBook createComicBook(@PathVariable("userId") Integer userId, @RequestBody ComicBook comicBook) {
    for(User user: users) {
      if (user.getId() == userId) {
        user.addComicBook(comicBook);
        return comicBook;
      }
    }
    return null;
  }

  @DeleteMapping("/api/users/{userId}/collection/{comicBookId}")
  public void deleteComicBook(@PathVariable("userId") Integer userId, @PathVariable("comicBookId") Integer id) {
    for (User user : users) {
      if (user.getId() == userId) {
        for (ComicBook comicBook : user.getComicBooks()) {
          if (comicBook.getId() == id) {
            user.removeComicBook(comicBook);
            return;
          }
        }
      }
    }
  }
}