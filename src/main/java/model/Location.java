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
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "location_id")
    private UUID location_id = UUID.randomUUID();
    @Column(name = "loc_Code")
    private String location_code;
    @Column(name = "loc_Name")
    private String location_name;
    @Enumerated(EnumType.STRING)
    private Location_type type;
    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "location_id")
    private Location parent;
    
    @OneToMany(mappedBy = "parent")
    private List<Location> child = new ArrayList<>();

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public void setLocation_id(UUID location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public Location_type getType() {
        return type;
    }

    public void setType(Location_type type) {
        this.type = type;
    }

    public Location getParent() {
        return parent;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }

    public List<Location> getChild() {
        return child;
    }

    public void setChild(List<Location> child) {
        this.child = child;
    }
    
}
