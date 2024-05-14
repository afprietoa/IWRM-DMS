package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="alerts")
@Data
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alertId;
    private LocalDate date;
    private Level level;
    private String message;
    private Integer userId;
    private Integer eventId;
}
