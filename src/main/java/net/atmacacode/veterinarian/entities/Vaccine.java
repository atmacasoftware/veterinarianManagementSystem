package net.atmacacode.veterinarian.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @Column(name = "vaccine_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "code", nullable = false, length = 100)
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "protection_start_date", nullable = false, length = 100)
    private LocalDate protectionStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "protection_finish_date", nullable = false, length = 100)
    private LocalDate protectionFinishDate;
}
