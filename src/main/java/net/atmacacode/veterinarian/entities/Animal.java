package net.atmacacode.veterinarian.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @Column(name = "animal_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "species", length = 100, nullable = false)
    private String species;

    @Column(name = "breed", length = 100, nullable = false)
    private String breed;

    @Column(name = "gender", length = 20, nullable = false)
    private String gender;

    @Column(name = "colour", length = 50, nullable = false)
    private String colour;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", length = 50, nullable = false)
    private LocalDate dateOfBirth;

}
