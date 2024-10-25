package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NamedQueries({
        @NamedQuery(name="Category.findAll", query="select c from Category c")
})
@Data @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name") // If the column name is different from the attribute name when mapping the table, we must specify it
    private String name;


    @Override
    public String toString() {
        return String.format("%5d %-40s", id, name);
    }
}