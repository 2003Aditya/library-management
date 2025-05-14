//package com.example.demo.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//    private String author;
//    private String isbn;
//
//    @ManyToOne
//    @JoinColumn(name = "issued_to_id")
//    private User issuedTo;
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getTitle() { return title; }
//    public void setTitle(String title) { this.title = title; }
//
//    public String getAuthor() { return author; }
//    public void setAuthor(String author) { this.author = author; }
//
//    public String getIsbn() { return isbn; }
//    public void setIsbn(String isbn) { this.isbn = isbn; }
//
//    public User getIssuedTo() { return issuedTo; }
//    public void setIssuedTo(User issuedTo) { this.issuedTo = issuedTo; }
//}
//
//
//
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issued_to_id", nullable = true)
    private User issuedTo;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public User getIssuedTo() { return issuedTo; }
    public void setIssuedTo(User issuedTo) { this.issuedTo = issuedTo; }
}

