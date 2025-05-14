package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String username;

    private String password;

    @OneToMany(mappedBy = "issuedTo")
    private List<Book> issuedBooks;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Book> getIssuedBooks() { return issuedBooks; }
    public void setIssuedBooks(List<Book> issuedBooks) { this.issuedBooks = issuedBooks; }
}

