package net.atmacacode.veterinarian.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @Column(name = "animal_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Appointment> appointmentList;

}
