package com.example.finalprojectdeploy.model;

import com.example.finalprojectdeploy.model.ComicBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
  private int id;
  private String username;
  private String password;
  private String first;
  private String last;
  private String email;
  private String address;
  private String city;
  private String state;
  private int zip;
  private String bio;
  private String pictureURL;
  private String role;
  private String startDate;
  private List<ComicBook> comicBooks;

  public User(int id, String username, String password, String first, String last, String email, String address, String city, String state, int zip, String bio, String pictureURL, String role, String startDate) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.first = first;
    this.last = last;
    this.email = email;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.bio = bio;
    this.pictureURL = pictureURL;
    this.role = role;
    this.startDate = startDate;
    this.comicBooks = new ArrayList<ComicBook>();
  }

  public User(int id, String username, String password, String role, String startDate) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
    this.startDate = startDate;
    this.comicBooks = new ArrayList<ComicBook>();
  }

  public User() {
    this.comicBooks = new ArrayList<ComicBook>();
  }

  public void updateUser(User newUser) {
    this.id = newUser.id;
    this.username = newUser.username;
    this.password = newUser.password;
    this.first = newUser.first;
    this.last = newUser.last;
    this.email = newUser.email;
    this.address = newUser.address;
    this.city = newUser.city;
    this.state = newUser.state;
    this.zip = newUser.zip;
    this.bio = newUser.bio;
    this.pictureURL = newUser.pictureURL;
    this.role = newUser.role;
    this.startDate = newUser.startDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getPictureURL() {
    return pictureURL;
  }

  public void setPictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public List<ComicBook> getComicBooks() {
    return comicBooks;
  }

  public void setComicBooks(List<ComicBook> comicBooks) {
    this.comicBooks = comicBooks;
  }

  //Extra Methods

  public void addComicBook(ComicBook comicBook) {
    this.comicBooks.add(comicBook);
  }

  public void removeComicBook(ComicBook comicBook) {
    this.comicBooks.remove(comicBook);
  }

  public List<ComicBook> getComicBooks(String sortBy) {
    switch (sortBy) {
      case "grade": Collections.sort(comicBooks, new ComicBook.GradeComparator());
        break;
      case "coverdate": Collections.sort(comicBooks, new ComicBook.CoverDateComparator());
        break;
      case "timestamp": Collections.sort(comicBooks, new ComicBook.DateAddedComparator());
        break;
      case "title": Collections.sort(comicBooks, new ComicBook.TitleComparator());
        break;
    }
    return comicBooks;
  }

  public List<ComicBook> getComicBooks(String sortBy, String resource, String query) {
    List<ComicBook> results = new ArrayList<>(this.getComicBooks(sortBy));
    switch (resource) {
      case "title": results.removeIf(comicBook -> !comicBook.getTitle().contains(query));
        break;
      case "volume": results.removeIf(comicBook -> !comicBook.getVolume().contains(query));
        break;
      case "character": results.removeIf(comicBook -> !comicBook.getCharacters().contains(query));
        break;
    }
    return results;
  }
}