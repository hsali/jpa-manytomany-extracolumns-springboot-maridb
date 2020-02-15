package com.hellokoding.jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book{
    private int bid;
    private String name;
    private Set<BookPublisher> bookPublishers;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
        bookPublishers = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getBid() {
        return bid;
    }

    public void setBid(int id) {
        this.bid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<BookPublisher>   getBookPublishers() {
        return bookPublishers;
    }

    public void setBookPublishers(Set<BookPublisher> bookPublishers) {
        this.bookPublishers = bookPublishers;
    }
}
