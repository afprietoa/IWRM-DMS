package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pollutants")
@Data
public class PollutantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pollutantId;
    private String name;
    private Float load;
}
