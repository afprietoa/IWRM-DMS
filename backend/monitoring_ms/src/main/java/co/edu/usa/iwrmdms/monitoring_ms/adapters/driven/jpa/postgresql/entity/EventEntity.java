package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Magnitude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="events")
@Data
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "magnitude")
    private Magnitude magnitude;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "pollutant_id")
    private PollutantEntity pollutant;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resource;
}
