/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

/**
 *
 * @author drg
 */
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "room_Id")
    private UUID room_id=UUID.randomUUID();
    @Column(name = "code")
    private String room_code;
    
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Shelf> shelves= new ArrayList<>();

    public UUID getRoom_id() {
        return room_id;
    }

    public void setRoom_id(UUID room_id) {
        this.room_id = room_id;
    }

    public String getRoom_code() {
        return room_code;
    }

    public void setRoom_code(String room_code) {
        this.room_code = room_code;
    }

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

    
    
}
