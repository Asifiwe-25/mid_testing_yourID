/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import jakarta.persistence.*;

/**
 *
 * 
 */
@Entity
@Table(name="Books")
public class Book {
    @Id
    @Column(name = "bookId")
    private UUID book_id= UUID.randomUUID();
    @Enumerated(EnumType.STRING)
    private Book_status status;
    @Column(name = "edition")
    private int edtition;
    @Column(name = "isbnCode")
    private String ISBNCode;
    @Column(name = "publicationYear")
    private Date publication_year;
    @Column(name = "publisherName")
    private String publisher_name;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "book")
    private List<Borrower> borrower = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "shelfId")
    private Shelf shelf;

    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public Book_status getStatus() {
        return status;
    }

    public void setStatus(Book_status status) {
        this.status = status;
    }

    public int getEdtition() {
        return edtition;
    }

    public void setEdtition(int edtition) {
        this.edtition = edtition;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public Date getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Date publication_year) {
        this.publication_year = publication_year;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Borrower> getBorrower() {
        return borrower;
    }

    public void setBorrower(List<Borrower> borrower) {
        this.borrower = borrower;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
    
    
}
