package model;

import java.util.*;
import jakarta.persistence.*;

/**
 *
 * @author drg
 */
@Entity(name="User")
@Table(name="users")
public class User extends Person{
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "user_name")
    private String userName;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "village_id")
    private Village location;
    
    @OneToOne(mappedBy = "reader", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Membership membership;
    
    @OneToMany(mappedBy = "user")
    private List<Borrower> borrower = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    
    public Village getLocation() {
        return location;
    }

    public void setLocation(Village Location) {
        this.location = Location;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public List<Borrower> getBorrower() {
        return borrower;
    }

    public void setBorrower(List<Borrower> borrower) {
        this.borrower = borrower;
    }
    
    
}
