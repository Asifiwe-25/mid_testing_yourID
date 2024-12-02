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

@Table(name="Borrower")
public class BorrowersBkp {
	
	@Id
	@Column(name = "ID")
    private UUID id = UUID.randomUUID();
	 @Column(name = "due_date")
    private Date due_date;
	 @Column(name = "fine")
    private int fine;
	@Column(name = "late_charge")
    private int late_charge_fees;
	 @Column(name = "pick_date")
    private Date pickup_date;
	 @Column(name = "returnDate")
    private Date return_date;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private  Book book;
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private User reader;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getLate_charge_fees() {
        return late_charge_fees;
    }

    public void setLate_charge_fees(int late_charge_fees) {
        this.late_charge_fees = late_charge_fees;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }
    
    
}
