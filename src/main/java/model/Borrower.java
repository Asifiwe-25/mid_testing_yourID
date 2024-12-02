package model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity

@Table(name="Borrowers")
public class Borrower {
	
	@Id
	 @Column(name = "ID")
    private UUID id = UUID.randomUUID();
	 @Column(name = "due_date")
    private Date due_date;
	 @Column(name = "fine")
    private int fine;
	 @Column(name = "late_charge_fees")
    private int late_charge_fees;
	 @Column(name = "pickup_date")
    private Date pickup_date;
	 @Column(name = "return_date")
    private Date return_date;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private  Book book;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
        
        


}
