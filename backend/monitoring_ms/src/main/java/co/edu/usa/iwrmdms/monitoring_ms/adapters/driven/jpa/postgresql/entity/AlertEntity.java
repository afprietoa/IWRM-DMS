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
    @Column(name = "alert_id")
    private Integer alertId;
    @Column(name = "date")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;
}
