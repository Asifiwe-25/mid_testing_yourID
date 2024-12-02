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
 * @author drg
 */
@Entity
public class Membership_type {
    @Id
    @Column(name = "Id")
    private UUID membership_type_id = UUID.randomUUID();
    @Column(name = "max_books")
    private int max_books;
    @Column(name = "name")
    private String membership_name;
    @Column(name = "price")
    private int price;

    public UUID getMembership_type_id() {
        return membership_type_id;
    }

    public void setMembership_type_id(UUID membership_type_id) {
        this.membership_type_id = membership_type_id;
    }

    public int getMax_books() {
        return max_books;
    }

    public void setMax_books(int max_books) {
        this.max_books = max_books;
    }

    public String getMembership_name() {
        return membership_name;
    }

    public void setMembership_name(String membership_name) {
        this.membership_name = membership_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
