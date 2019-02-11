package com.example.Test1.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



@Entity
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long idauthor;


    private String firstnme;
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books= new HashSet<>();

    public Author() {
    }

    public Author(String firstnme, String lastname) {
        this.firstnme = firstnme;
        this.lastname = lastname;
    }

    public Author(String firstnme, String lastname, Set<Book> books) {
        this.firstnme = firstnme;
        this.lastname = lastname;
        this.books = books;
    }

    public void setFirstnme(String firstnme) {
        this.firstnme = firstnme;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getFirstnme() {
        return firstnme;
    }

    public String getLastname() {
        return lastname;
    }

    public Set<Book> getBooks() {
        return books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return idauthor == author.idauthor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idauthor);
    }

    @Override
    public String toString() {
        return "Author{" +
                "idauthor=" + idauthor +
                ", firstnme='" + firstnme + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }
}
