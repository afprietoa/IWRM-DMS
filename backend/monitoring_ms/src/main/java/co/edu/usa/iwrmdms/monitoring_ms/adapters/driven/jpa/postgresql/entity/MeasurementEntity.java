package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="measurements")
@Data
public class MeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Integer measurementId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "ph")
    private Float ph;
    @Column(name = "temperature")
    private Float temperature;
    @JoinColumn(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "pollutant_id")
    private PollutantEntity pollutant;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resource;
}
