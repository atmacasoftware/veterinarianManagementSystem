package net.atmacacode.veterinarian.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @Column(name = "doctor_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone", length = 11, nullable = false)
    private String phone;

    @Column(name = "mail", length = 255, nullable = false, unique = true)
    private String mail;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "city", length = 255, nullable = false)
    private String city;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AvailableDate> availableDateList;

}
