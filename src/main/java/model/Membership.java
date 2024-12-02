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
public class Membership{
    @Id
    @Column(name = "membership_id")
    private UUID membership_id= UUID.randomUUID();
    @Column(name = "expiring_date")
    private Date expiring_time;
    
    @Column(name = "membership_code")
    private String membership_code;
    
    @Column(name = "registration_date")
    private Date registration_date;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    private User reader;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_type_id")
    private Membership_type membership_type;

    public UUID getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(UUID membership_id) {
        this.membership_id = membership_id;
    }

    public Date getExpiring_time() {
        return expiring_time;
    }

    public void setExpiring_time(Date expiring_time) {
        this.expiring_time = expiring_time;
    }

    public String getMembership_code() {
        return membership_code;
    }

    public void setMembership_code(String membership_code) {
        this.membership_code = membership_code;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
    
    public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

	public Membership_type getMembership_type() {
		return membership_type;
	}

	public void setMembership_type(Membership_type membership_type) {
		this.membership_type = membership_type;
	}
}
