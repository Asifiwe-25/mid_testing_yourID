package model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "villages")
public class Village {

    @Id
    @Column(name = "village_id", nullable = false, length = 36)
    private UUID village_id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cell_id", nullable = false)
    private Cell cell;
    
    // Optional bidirectional mapping
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY) // Mapped by the `location` field in User
    private List<User> users;

    // Constructors
    public Village() {}

    public Village(String name, Cell cell) {
        this.name = name;
        this.cell = cell;
    }

    // Getters and setters
    public UUID getId() {
        return village_id;
    }

    public void setId(UUID id) {
        this.village_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "Village{" +
                "id=" + village_id +
                ", name='" + name + '\'' +
                ", cell=" + cell +
                '}';
    }
}
