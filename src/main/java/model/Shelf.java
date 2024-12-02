/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.util.UUID;
import jakarta.persistence.*;

/**
 *
 * @author drg
 */
@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @Column(name = "Id")
    private UUID id = UUID.randomUUID();
    @Column(name = "availableStock")
    private int available_stock;
    @Column(name = "category")
    private String book_category;
    @Column(name = "borrowed_number")
    private int borrowed_number;
    @Column(name = "initialStock")
    private int initial_stock;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(mappedBy = "shelf",fetch=FetchType.EAGER)
    private List<Book> book = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(int available_stock) {
        this.available_stock = available_stock;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public int getBorrowed_number() {
        return borrowed_number;
    }

    public void setBorrowed_number(int borrowed_number) {
        this.borrowed_number = borrowed_number;
    }

    public int getInitial_stock() {
        return initial_stock;
    }

    public void setInitial_stock(int initial_stock) {
        this.initial_stock = initial_stock;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
    
    
}
