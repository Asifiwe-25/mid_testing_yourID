/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="province")
public class Province {
    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    private UUID id = UUID.randomUUID();

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<District> districts = new ArrayList<>();


    public Province(String name) {
        this.name = name;
    }

    public Province() {
    }
    

    // Add district to the province
    public void addDistrict(District district) {
        district.setProvince(this);
        districts.add(district);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    
}

