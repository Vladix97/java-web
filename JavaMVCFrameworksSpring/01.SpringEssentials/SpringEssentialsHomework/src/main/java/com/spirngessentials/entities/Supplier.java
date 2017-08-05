package com.spirngessentials.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable {

    private Long id;

    private String name;

    private Boolean isImporter;

    private Set<Part> parts;

    public Supplier() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "importer")
    public Boolean getImporter() {
        return this.isImporter;
    }

    public void setImporter(Boolean importer) {
        this.isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier", orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
